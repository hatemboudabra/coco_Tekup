package com.tekup.coco.services.ReactionReponse;

import com.tekup.coco.entity.MessageChattrom;
import com.tekup.coco.entity.ReactionMessage;
import com.tekup.coco.entity.ReponseMessage;
import com.tekup.coco.entity.User;
import com.tekup.coco.entity.enummeration.ReactionType;
import com.tekup.coco.repository.MessageChattromRepo;
import com.tekup.coco.repository.ReactionRepo;
import com.tekup.coco.repository.ReponseRepo;
import com.tekup.coco.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ReactionReponseService {
    @Autowired
    private UserRepo userRepository;
    @Autowired
    private ReponseRepo reponseRepo;
    @Autowired
    private ReactionRepo reactionRepo;
    @Autowired
    private MessageChattromRepo messageRepo;
    public ReponseMessage AddReponse(ReponseMessage r, Integer idmeesage, Long idu)  {
        Optional<MessageChattrom> m=messageRepo.findById(idmeesage);
        if(m.isPresent()){
            Optional<User> u=userRepository.findById(idu);
            if(u.isPresent()){
                r.setUser(u.get());
                r.setMessage(m.get());
                return reponseRepo.save(r);
            }
        }
        return null;
    }

    public ReponseMessage UpdateReponse(Integer id,String contenu)  {
        Optional<ReponseMessage> r=reponseRepo.findById(id);
        if(r.isPresent()){
            r.get().setContent(contenu);
            return reponseRepo.save( r.get());

        }
        return null;
    }

    public ReactionMessage AddReaction(ReactionMessage r, Integer idmeesage, Long idu)  {
        Optional<MessageChattrom> m=messageRepo.findById(idmeesage);
        if(m.isPresent()){
            Optional<User> u=userRepository.findById(idu);
            if(u.isPresent()){
                r.setUser(u.get());
                r.setMsg(m.get());
                return reactionRepo.save(r);
            }
        }
        return null;
    }

    public ReactionMessage UpdateReaction(Integer id,String contenu)  {
        Optional<ReactionMessage> r=reactionRepo.findById(id);
        if(r.isPresent()){
            r.get().setType(ReactionType.valueOf(contenu));
            return reactionRepo.save( r.get());

        }
        return null;
    }
    public void delteReaction(Integer id){
        reactionRepo.deleteById(id);
    }

}
