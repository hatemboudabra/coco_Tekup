package com.tekup.coco.Controller;

import com.tekup.coco.Dto.AnnonceCovoiturageDto;
import com.tekup.coco.Dto.UserDto;
import com.tekup.coco.entity.AnnonceCovoiturage;
import com.tekup.coco.services.ServiceImpl.AnnonceCovoiturageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
@RequestMapping("/annoncecovoiturage")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class AnnonceCovoiturageController {
    private final AnnonceCovoiturageServiceImpl annonceCovoiturageService;

    @Autowired
    public AnnonceCovoiturageController(AnnonceCovoiturageServiceImpl annonceCovoiturageService) {
        this.annonceCovoiturageService = annonceCovoiturageService;
    }

    @PostMapping(path = "/addAnnonce")
    public AnnonceCovoiturageDto addAnnonce(@RequestBody AnnonceCovoiturageDto annonceCovoiturageDto) {
        return annonceCovoiturageService.addAnnonce(annonceCovoiturageDto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AnnonceCovoiturage> updateAnnonce(@PathVariable Long id, @RequestBody AnnonceCovoiturageDto annonceCovoiturageDto) {
        AnnonceCovoiturage updatedAnnonce = annonceCovoiturageService.updateAnnonce(id, annonceCovoiturageDto);
        if (updatedAnnonce != null) {
            return ResponseEntity.ok(updatedAnnonce);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public List<AnnonceCovoiturage> findallAnnonce(AnnonceCovoiturageDto annonceCovoiturageDto) {
        return annonceCovoiturageService.findAll();
    }

    @DeleteMapping("/delete/{annonceId}")
    public ResponseEntity<String> deleteAnnonceById(@PathVariable Long annonceId) {
        annonceCovoiturageService.deleteAnnonceById(annonceId);
        return new ResponseEntity<>("Annonce supprimée avec succès", HttpStatus.OK);
    }

    @GetMapping("/bylieu")
    public List<AnnonceCovoiturage> findByLieuDepart(@RequestParam String lieuDepart) {
        return annonceCovoiturageService.findByLieuDepart(lieuDepart);
    }

    @GetMapping("/byUser")
    public List<AnnonceCovoiturage> rechercherAnnoncesParUtilisateur(@RequestParam Long userId) {
        return annonceCovoiturageService.rechercherAnnoncesParUtilisateur(userId);
    }

    @GetMapping("/sortAnnoncebyDate")
    public List<AnnonceCovoiturage> trierAnnonceCovoiturageParDate() {
        return annonceCovoiturageService.trierAnnonceCovoiturageParDate();

    }

    @GetMapping("/stats/users")
    public Map<Long, Map<String, Object>> annoncesParUserService()   {
        return annonceCovoiturageService.annoncesParUserService();
    }
}
