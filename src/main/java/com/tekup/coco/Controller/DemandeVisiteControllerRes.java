package com.tekup.coco.Controller;

import com.tekup.coco.Dto.Demande_visiteDto;
import com.tekup.coco.entity.Demande_visite;
import com.tekup.coco.services.ServiceImpl.Demande_visiteServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demande_visite")
public class DemandeVisiteControllerRes {
   private final   Demande_visiteServiceImp demandeVisiteServiceImp;
    @Autowired
    public DemandeVisiteControllerRes(Demande_visiteServiceImp demandeVisiteServiceImp) {
        this.demandeVisiteServiceImp = demandeVisiteServiceImp;
    }

    @PostMapping("/create")
    public Demande_visiteDto createDemandeVisite(@RequestBody Demande_visiteDto demandeVisite) {
        return demandeVisiteServiceImp.createDemandeVisite(demandeVisite);
    }



    @GetMapping("/getAllDemandeVisite")
    public List<Demande_visite> getAllDemandeVisite() {
        List<Demande_visite> listAllDemandeVisite = demandeVisiteServiceImp.getAllDemandeVisite();
        return listAllDemandeVisite;
    }

    @GetMapping("/getDemandeVisiteId/{id}")
    public  Demande_visite DemandeVisiteById(@PathVariable("id") Long id) {
        Demande_visite demandevisite = demandeVisiteServiceImp.getDemandeVisiteById(id);

        return demandevisite;
    }
    @PutMapping("/updateDemandeVisite")
    public Demande_visite updateDemandeVisite(@RequestBody Demande_visite d){
        Demande_visite demandeVisite = demandeVisiteServiceImp.updateDemandeVisite(d);
        return demandeVisite ;
    }
    @DeleteMapping("/deleteDemandeVisite/{id}")
    public void  deleteDemandeVisite(@PathVariable("id") Long blId){
        demandeVisiteServiceImp.deleteDemandeVisite(blId);
    }
}