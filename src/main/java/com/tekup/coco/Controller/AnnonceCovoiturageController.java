package com.tekup.coco.Controller;

import com.tekup.coco.Dto.AnnonceCovoiturageDto;
import com.tekup.coco.entity.AnnonceCovoiturage;
import com.tekup.coco.services.ServiceImpl.AnnonceCovoiturageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class AnnonceCovoiturageController {
    private final AnnonceCovoiturageServiceImpl annonceCovoiturageService;
    @Autowired
    public AnnonceCovoiturageController(AnnonceCovoiturageServiceImpl annonceCovoiturageService) {
        this.annonceCovoiturageService = annonceCovoiturageService;
    }
    @PostMapping(path = "/addAnnonce")
     public AnnonceCovoiturage addAnnonce(@RequestBody AnnonceCovoiturageDto annonceCovoiturageDto){
        return annonceCovoiturageService.addAnnonce(annonceCovoiturageDto);
    }
    @GetMapping
    public List<AnnonceCovoiturage> findallAnnonce (AnnonceCovoiturageDto annonceCovoiturageDto){
        return  annonceCovoiturageService.findAll();
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAnnonce(@PathVariable("id") long id){
        annonceCovoiturageService.delete(id);
        return new ResponseEntity<String>("Annonce deleted successfully!.", HttpStatus.OK);
    }

}
