package com.tekup.coco.Controller;

import com.tekup.coco.Dto.AnnonceCollocationDto;
import com.tekup.coco.entity.AnnonceCollocation;
import com.tekup.coco.services.AnnonceCollocationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/annonces")
@Tag(name = "Collocation")

public class AnnonceCollocationController {
    @Autowired
    private AnnonceCollocationService annonceCollocationService;
    @PostMapping("/add")
    public ResponseEntity<AnnonceCollocationDto> addAnnonce(@RequestBody AnnonceCollocationDto annonceCollocationDto) {
        AnnonceCollocationDto annonceCollocation = annonceCollocationService.addAnnonce(annonceCollocationDto);
        return new ResponseEntity<>(annonceCollocation, HttpStatus.CREATED);
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
