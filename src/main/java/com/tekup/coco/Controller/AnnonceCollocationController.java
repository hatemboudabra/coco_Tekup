package com.tekup.coco.Controller;

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
    @Operation(description = "annonce")
    @GetMapping("/")
    public List<AnnonceCollocation> getAllAnnonces() {
        return annonceCollocationService.getAllAnnonces();
    }
    @Operation(description = "annonce")

    @GetMapping("/{id}")
    public Optional<AnnonceCollocation> getAnnonceById(@PathVariable Long id) {
        return annonceCollocationService.getAnnonceById(id);
    }

    @PostMapping("/ajouter")
    public AnnonceCollocation createOrUpdateAnnonce(@RequestBody AnnonceCollocation annonce) {
        return annonceCollocationService.saveOrUpdateAnnonce(annonce);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAnnonce(@PathVariable Long id) {
        annonceCollocationService.deleteAnnonceById(id);
        return new ResponseEntity<String>("Annonce deleted successfully!.", HttpStatus.OK);
    }
}
