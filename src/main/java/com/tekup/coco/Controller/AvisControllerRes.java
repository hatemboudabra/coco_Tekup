package com.tekup.coco.Controller;

import com.tekup.coco.entity.Avis;
import com.tekup.coco.services.AvisServiceImp;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/avis")
public class AvisControllerRes {
    @Autowired
    AvisServiceImp avisServiceImp;

    @PostMapping("/createAvis")
    public Avis createAvis(@RequestBody Avis a) {
        Avis avis =  avisServiceImp.createAvis(a);
        return avis;
    }
    @DeleteMapping("/deleteAvis/{id}")
    public void deleteAvis (@PathVariable("id") Long blId) {
        avisServiceImp.deleteAvis(blId);
    }
    @GetMapping("/getAvis/{userId}")
    public Avis getAvisByUserID(@PathParam("userId") Long Id) {
        return avisServiceImp.getAvisByUserID(Id);

}
}
