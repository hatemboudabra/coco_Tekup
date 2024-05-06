package com.tekup.coco.services.Message;

import com.tekup.coco.entity.Chatrromassistance;
import com.tekup.coco.entity.MessageChattrom;
import com.tekup.coco.entity.User;
import com.tekup.coco.repository.ChatrromAssitanceRepo;
import com.tekup.coco.repository.MessageChattromRepo;
import com.tekup.coco.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MessageService {
    @Autowired
    private UserRepo userRepository;
    @Autowired
    private ChatrromAssitanceRepo chatroomRepo;
    @Autowired
    private MessageChattromRepo messageRepo;

    public MessageChattrom AddMessage(MessageChattrom m, Integer idroom, Long idu)  {
        Optional<Chatrromassistance> c=chatroomRepo.findById(idroom);
        if(c.isPresent()){
            Optional<User> u=userRepository.findById(idu);
            if(u.isPresent()){
                m.setChatroom(c.get());
                m.setUser(u.get());
                m.setDateTime(new Date());
                MessageChattrom newmessage=messageRepo.save(m);
                return newmessage;
            }
        }
        return null;
    }
    public MessageChattrom UpdateMessage(MessageChattrom m){
        Optional<MessageChattrom>optionalMessage=messageRepo.findById(m.getMessageId());
        if(optionalMessage.isPresent()){
            optionalMessage.get().setContent(m.getContent());
            optionalMessage.get().setDateTime(new Date());
            MessageChattrom updatemessage=messageRepo.save(optionalMessage.get());
            return updatemessage;
        }
        return null;
    }
    public void removeMessage(Integer id){
        messageRepo.deleteById(id);
    }
}
