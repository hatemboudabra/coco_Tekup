package com.tekup.coco.Controller;

import com.tekup.coco.Dto.AnnonceCollocationDto;
import com.tekup.coco.entity.AnnonceCollocation;
import com.tekup.coco.entity.AnnonceCovoiturage;
import com.tekup.coco.entity.ImageModel;
import com.tekup.coco.services.AnnonceCollocationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.nio.file.Path;
import java.nio.file.Files;

@RestController
@RequestMapping("/annonces")
//@Tag(name = "Collocation")
@AllArgsConstructor
public class AnnonceCollocationController {
    @Autowired
    private AnnonceCollocationService annonceCollocationService;
    /*
    @PostMapping("/add")
    public ResponseEntity<AnnonceCollocationDto> addAnnonce(@RequestBody AnnonceCollocationDto annonceCollocationDto) {
        AnnonceCollocationDto annonceCollocation = annonceCollocationService.addAnnonce(annonceCollocationDto);
        return new ResponseEntity<>(annonceCollocation, HttpStatus.CREATED);
    }
    */
    @PostMapping(value = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public AnnonceCollocation add(
            @RequestPart("collocation") AnnonceCollocation annonceCollocation,
            @RequestPart("imageFile") MultipartFile[] file) {
        try {
            Set<ImageModel> imageModelSet = uploadImage(file);
            annonceCollocation.setImageModels(imageModelSet);
            return annonceCollocationService.Add(annonceCollocation);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Set<ImageModel> uploadImage(MultipartFile[] multipartFiles) throws IOException {
        Set<ImageModel> imageModels = new HashSet<>();
        for (MultipartFile file : multipartFiles) {
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            ImageModel imageModel = new ImageModel();
            imageModel.setFilePath(fileName); // Store only the file name
            imageModel.setBytes(file.getBytes());

            // Save image to the filesystem
            saveImageToFileSystem(file, fileName);
            imageModels.add(imageModel);
        }
        return imageModels;
    }

    // Ensure the saveImageToFileSystem method writes the file correctly
    public void saveImageToFileSystem(MultipartFile file, String fileName) throws IOException {
        String uploadDir = "C:/xampp/htdocs/collocation/"; // Ensure this path is correct

        // Create the directory if it does not exist
        Path uploadPath = Paths.get(uploadDir);
        Files.createDirectories(uploadPath);

        // Write the file to the filesystem
        Path filePath = uploadPath.resolve(fileName);
        Files.write(filePath, file.getBytes());
    }

    // Add a method to serve the image
    @GetMapping("/getimage/{filename}")
    public ResponseEntity<Resource> getImage(@PathVariable String filename) {
        try {
            Path file = Paths.get("C:/xampp/htdocs/collocation/").resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(resource);
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (Exception e) {
            throw new RuntimeException("Could not read the file: " + filename, e);
        }
    }




    @GetMapping("/CollocationbyUser/{userId}") // Définissez l'ID utilisateur comme path parameter
    public List<AnnonceCollocation> rechercherAnnoncesParUtilisateur(@PathVariable Long userId) {
        return annonceCollocationService.rechercherAnnoncesParUtilisateur(userId);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<AnnonceCollocationDto> updateAnnonce(@PathVariable Long id, @RequestBody AnnonceCollocationDto annonceCollocationDto) {
        AnnonceCollocationDto updatedAnnonceCollocation = annonceCollocationService.updateAnnonce(id, annonceCollocationDto);
        if (updatedAnnonceCollocation != null) {
            return new ResponseEntity<>(updatedAnnonceCollocation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<AnnonceCollocation>> getAllAnnonces(AnnonceCollocationDto annonceCollocationDto) {
        List<AnnonceCollocation> annonces = annonceCollocationService.getAllAnnonces();
        return new ResponseEntity<>(annonces, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAnnonce(@PathVariable Long id) {
        annonceCollocationService.deleteAnnonceById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AnnonceCollocation> getAnnonceById(@PathVariable Long id) {
        Optional<AnnonceCollocation> annonce = annonceCollocationService.getAnnonceById(id);
        return annonce.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
