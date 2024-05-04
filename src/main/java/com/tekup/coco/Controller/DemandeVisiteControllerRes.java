package com.tekup.coco.Controller;

import com.tekup.coco.entity.Demande_visite;
import com.tekup.coco.services.Demande_visiteService;
import com.tekup.coco.services.Demande_visiteServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/demande_visite")
public class DemandeVisiteControllerRes {
    Demande_visiteServiceImp demandeVisiteServiceImp;

    @PostMapping("/createDemandeVisite")
    public Demande_visite addDemandeVisite(@RequestBody Demande_visite b) {
        Demande_visite demande_visite = demandeVisiteServiceImp.createDemandeVisite(b);
        return demande_visite;
    }

    Demande_visiteService demande_visite;

    @GetMapping("/getAllDemandeVisite")
    public List<Demande_visite> getAllDemandeVisite() {
        List<Demande_visite> listAllDemandeVisite = demande_visite.getAllDemandeVisite();
        return listAllDemandeVisite;
    }

    @GetMapping("/getDemandeVisiteId/{id}")
    public  Demande_visite DemandeVisiteById(@PathVariable("id") Long id) {
        Demande_visite demandevisite = demande_visite.getDemandeVisiteById(id);

        return demandevisite;
    }
    @PutMapping("/updateDemandeVisite")
    public Demande_visite updateDemandeVisite(@RequestBody Demande_visite d){
        Demande_visite demandeVisite = demande_visite.updateDemandeVisite(d);
        return demandeVisite ;
    }
    @DeleteMapping("/deleteDemandeVisite/{id}")
    public void  deleteDemandeVisite(@PathVariable("id") Long blId){
       demande_visite.deleteDemandeVisite(blId);
}
}