package com.tekup.coco.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tekup.coco.entity.MessageChattrom;
import com.tekup.coco.services.Message.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class MessageControlleur {
    @Autowired
    MessageService messageService;


    @PostMapping("/Message/add/{idroom}/{idu}")
    @CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
    public MessageChattrom add(@RequestBody MessageChattrom m, @PathVariable("idroom") Integer idroom, @PathVariable("idu") Long idu) throws JsonProcessingException {
        return messageService.AddMessage(m,idroom,idu);
    }

    @PostMapping("/Message/update")
    @CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
    public MessageChattrom update(@RequestBody MessageChattrom m){
        return messageService.UpdateMessage(m);
    }

    @DeleteMapping("/Message/remove/{id}")
    @CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
    public void remove(@PathVariable("id") Integer id){
        messageService.removeMessage(id);
    }

}
