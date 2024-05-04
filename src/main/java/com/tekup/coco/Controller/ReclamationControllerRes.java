package com.tekup.coco.Controller;

import com.tekup.coco.entity.Reclamation;
import com.tekup.coco.services.ReclamationServiceImp;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("/Reclamation")
public class ReclamationControllerRes {
    @Autowired
    ReclamationServiceImp reclamationServiceImp;

    @PostMapping("/createReclamation")
    public Reclamation createReclamation(@RequestBody Reclamation r) {
        Reclamation reclamation = reclamationServiceImp.createReclamation(r);
        return reclamation;
    }

    @DeleteMapping("/deleteReclamation/{id}")
    public void deleteReclamation(@PathVariable("id") Long blId) {

        reclamationServiceImp.deleteReclamation(blId);
    }
    @GetMapping("/getreclamations/{userId}")
    public Reclamation getReclamationByUserID(@PathParam("userId") Long Id) {
        return reclamationServiceImp.getReclamationByUserID(Id);

    }
}
