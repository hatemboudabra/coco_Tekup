package com.tekup.coco.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tekup.coco.entity.ReactionMessage;
import com.tekup.coco.entity.ReponseMessage;
import com.tekup.coco.services.ReactionReponse.ReactionReponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReactionReponseControlleur {
    @Autowired
    private ReactionReponseService reactionReponseService;


    @PostMapping("/ReponseReaction/addReponse/{idmeesage}/{idu}")
    @CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
    public ReponseMessage addReponse(@RequestBody ReponseMessage r, @PathVariable("idmeesage") Integer idmeesage, @PathVariable("idu") Long idu) throws JsonProcessingException {
        return reactionReponseService.AddReponse(r,idmeesage,idu);
    }

    @PostMapping("/ReponseReaction/addReaction/{idmeesage}/{idu}")
    @CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
    public ReactionMessage addReaction(@RequestBody ReactionMessage r, @PathVariable("idmeesage") Integer idmeesage, @PathVariable("idu") Long idu) throws JsonProcessingException {
        return reactionReponseService.AddReaction(r,idmeesage,idu);
    }

    @PutMapping("/ReponseReaction/UpdateReaction/{id}/{contenu}")
    @CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
    public ReactionMessage UpdateRecation(@PathVariable("id") Integer id, @PathVariable("contenu") String contenu){
        return reactionReponseService.UpdateReaction(id,contenu);
    }

    @PutMapping("/ReponseReaction/UpdateReponse/{id}/{contenu}")
    @CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
    public ReponseMessage UpdateReponse(@PathVariable("id") Integer id, @PathVariable("contenu") String contenu){
        return reactionReponseService.UpdateReponse(id,contenu);
    }

    @DeleteMapping("/ReponseReaction/RemoveReaction/{id}")
    @CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
    public void RemoveReaction(@PathVariable("id") Integer id){
        reactionReponseService.delteReaction(id);
    }

}
