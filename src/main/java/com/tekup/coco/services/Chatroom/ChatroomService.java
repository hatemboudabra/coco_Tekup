package com.tekup.coco.services.Chatroom;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tekup.coco.entity.Chatrromassistance;
import com.tekup.coco.entity.User;
import com.tekup.coco.repository.ChatrromAssitanceRepo;
import com.tekup.coco.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ChatroomService {
    @Autowired
    private UserRepo userRepository;
    @Autowired
    private ChatrromAssitanceRepo chatroomRepo;
  //  private JavaMailSender javaMailSender;


    public Chatrromassistance addChatroom(Chatrromassistance c, Long id) throws JsonProcessingException {
        Optional<User> u=userRepository.findById(id);
        if(u.isPresent()){
            c.setOwner(u.get());
            Chatrromassistance newchaatroom=chatroomRepo.save(c);
            return newchaatroom;
        }
        return null;
    }
    public Chatrromassistance updateChatroom(Chatrromassistance c){
        Optional<Chatrromassistance> chatroomOptional=chatroomRepo.findById(c.getChatRoomId());
        if(chatroomOptional.isPresent()){
            c.setOwner(chatroomOptional.get().getOwner());
            Chatrromassistance updatechaatroom=chatroomRepo.save(c);
            return updatechaatroom;
        }
        return null;
    }/*
    public void sendEmailInvite(String emailUser,String nom ,String titre) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("hatemboudabra41@gmail.com");
        message.setTo(emailUser);
        message.setSubject("CoCo - Invite Room");
        String emailBody = """
        Hello Miss/ Sir,
        
        we are glad to inform that   """ + nom + "  have invited you to the room  "+ titre + """
        
        Sincerely,
        CoCoTeam
        """;
        message.setText(emailBody);
        javaMailSender.send(message);
    }
    public void sendEmailjoin(String emailUser,String nom ,String titre) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("hatemboudabra41@gmail.com");
        message.setTo(emailUser);
        message.setSubject("CoCo - join Room");
        String emailBody = """
        Hello Miss/ Sir,
        
        we are glad to inform that   """ + nom + "  have joined your  room  "+ titre + """
        
        Sincerely,
        CoCoTeam
        """;
        message.setText(emailBody);
        javaMailSender.send(message);
    }*/
    public Chatrromassistance invite(List<Long> ids, Integer idroom){
        List<User> users=new ArrayList<>();
        Optional<Chatrromassistance> chatroomOptional=chatroomRepo.findById(idroom);
        if(chatroomOptional.isPresent()){
            for (Long id : ids) {
                Optional<User> u=userRepository.findById(id);
                if(u.isPresent()){
                    users.add(u.get());
                  //  sendEmailInvite(u.get().getEmail(),chatroomOptional.get().getOwner().getUsername(),chatroomOptional.get().getNom());
                }
            }
            chatroomOptional.get().setUsers(users);
            Chatrromassistance updatechaatroom=chatroomRepo.save(chatroomOptional.get());
            return updatechaatroom;
        }
        return null;
    }

    public Chatrromassistance joindre(Long idu,Integer idroom){
        Optional<Chatrromassistance> chatroomOptional=chatroomRepo.findById(idroom);
        if(chatroomOptional.isPresent()){
            Optional<User> u=userRepository.findById(idu);
            if(u.isPresent()){
                if(chatroomOptional.get().isStatus()){
                    Chatrromassistance chatroom = chatroomOptional.get();
                    List<User> users = chatroom.getUsers();
                    users.add(u.get());
                 //   sendEmailjoin(chatroomOptional.get().getOwner().getEmail(),u.get().getUsername(),chatroomOptional.get().getNom());
                    chatroom.setUsers(users);
                    Chatrromassistance updatechaatroom=chatroomRepo.save(chatroom);
                    return updatechaatroom;
                }
            }

        }
        return null;
    }
    public List<User> UsersList(){
        return userRepository.findAll();
    }
    public List<Chatrromassistance> ListChatroom() {
        return chatroomRepo.findAll();
    }
    public void removechatromm(Integer id){
        chatroomRepo.deleteById(id);
    }
    public String usernameuser(Long id){
        return userRepository.findById(id).get().getUsername();
    }
}
