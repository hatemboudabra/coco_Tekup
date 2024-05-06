package com.tekup.coco.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tekup.coco.entity.Chatrromassistance;
import com.tekup.coco.entity.User;
import com.tekup.coco.services.Chatroom.ChatroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ChatroomControlleur {
    @Autowired
    ChatroomService chatroomService;

    @PostMapping("/Chatroom/add/{id}")
    @CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
    public Chatrromassistance add(@RequestBody Chatrromassistance c, @PathVariable("id") Long id) throws JsonProcessingException {
        return chatroomService.addChatroom(c,id);
    }

    @PostMapping("/Chatroom/update")
    @CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
    public Chatrromassistance update(@RequestBody Chatrromassistance c){
        return chatroomService.updateChatroom(c);
    }

    @PostMapping("/Chatroom/invite/{idroom}")
    @CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
    public Chatrromassistance invite(@RequestBody List<Long> ids, @PathVariable("idroom") Integer idroom){
        return chatroomService.invite(ids,idroom);
    }

    @PutMapping("/Chatroom/joindre/{idu}/{idroom}")
    @CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
    public Chatrromassistance joindre(@PathVariable("idu") Long idu, @PathVariable("idroom") Integer idroom){
        return chatroomService.joindre(idu,idroom);
    }

    @GetMapping("/Chatroom/AllUsers")
    @CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
    public List<User> listUsers(){
        return chatroomService.UsersList();
    }
    @GetMapping("/Chatroom/AllChatroom")
    @CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
    public List<Chatrromassistance> AllChatroom() throws JsonProcessingException {
        return chatroomService.ListChatroom();
    }

    @DeleteMapping("/Chatroom/Delete/{id}")
    @CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
    public void Delete(@PathVariable("id") Integer id){
        chatroomService.removechatromm(id);
    }
    @GetMapping("/Chatroom/getusername/{id}")
    @CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
    public String username(@PathVariable("id") Long id){
        return chatroomService.usernameuser(id);
    }
}

