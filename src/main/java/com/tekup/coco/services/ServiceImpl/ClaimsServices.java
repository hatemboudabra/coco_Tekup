package com.tekup.coco.services.ServiceImpl;

import com.tekup.coco.Dto.ReclamationDto;
import com.tekup.coco.entity.Reclamation;
import com.tekup.coco.entity.User;
import com.tekup.coco.entity.enummeration.Status;
import com.tekup.coco.entity.enummeration.TypeClaim;
import com.tekup.coco.repository.ReclamationRepo;
import com.tekup.coco.repository.UserRepo;
import com.tekup.coco.services.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class ClaimsServices  implements ClaimService {

   private final   ReclamationRepo claimsRepository;
    private final UserRepo UserRepository;
    @Autowired
    public ClaimsServices(ReclamationRepo claimsRepository, UserRepo userRepository) {
        this.claimsRepository = claimsRepository;
        UserRepository = userRepository;
    }

    @Override
    public ReclamationDto addClaims(ReclamationDto claims) {
        Reclamation reclamation = new Reclamation();
        reclamation.setTitle(claims.getTitle());
        reclamation.setOtherDetails(claims.getOtherDetails());
        reclamation.setDescription(claims.getDescription());
        reclamation.setTypeClaim(claims.getTypeClaim());
        reclamation.setStatusClaims(claims.getStatusClaims());
        reclamation.setCreatedAt(claims.getCreatedAt());
        reclamation.setConsultAt(claims.getConsultAt());
        User user = UserRepository.findById(claims.getIduser()).get();
        reclamation.setUser(user);
        claimsRepository.save(reclamation);
        return claims;

    }

    @Override
    public Reclamation getClaimsById(Integer id) {
        Reclamation getRec =claimsRepository.findById(id).orElse(null);
        return getRec;
    }

    @Override
    public List<Reclamation> GetClaims() {
        return claimsRepository.findAll();
    }


    public Page<Reclamation> getClaimsWithPagination(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return claimsRepository.findAll(pageRequest);
    }
    @Override
    public List<Reclamation> findByUser(Long id) {
        Optional<User> u =UserRepository.findById(id);
        if(u.isPresent()){
            return claimsRepository.findByUser(u.get());
        }
        else return null;
    }

    @Override
    public Reclamation statusClaims(Integer idClaims, String status) {
       // Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        String m=null;
        Reclamation treatedClaim= claimsRepository.findByIdClaims(idClaims);

        if(Objects.equals(status, "rejected")){
            treatedClaim.setStatusClaims(Status.Rejected);
            m="Désolé L'administrateur a rejeter votre réclamation";

        } else if (Objects.equals(status, "resolved")) {
            treatedClaim.setStatusClaims(Status.Resolved);
            m="L'administrateur a Fixer votre réclamation";
        }else {
            treatedClaim.setStatusClaims(Status.In_process);
            m="Votre réclamation est entrain de process";
        }
        treatedClaim.setConsultAt(LocalDateTime.now());
        /*Message message = Message.creator(
                        new PhoneNumber("+21658218173"),
                        new PhoneNumber(TWILIO_PHONE_NUMBER),
                        m)
                .create();*/
        return claimsRepository.save(treatedClaim);
    }
    @Override
    public void deleteClaims(Integer idClaims) {
        claimsRepository.deleteById(idClaims) ;

    }
    @Override
    public Reclamation Update( Reclamation claims){
        Reclamation getRec =claimsRepository.findById(claims.getIdClaims()).orElse(null);
        if(getRec!=null){
            getRec.setTitle(claims.getTitle());
            getRec.setDescription(claims.getDescription());
            getRec.setTypeClaim(claims.getTypeClaim());
            if(claims.getTypeClaim().toString()=="Other"){
                getRec.setOtherDetails(claims.getOtherDetails());
            }
            else {
                getRec.setOtherDetails(null);

            }
            getRec.setCreatedAt(LocalDateTime.now());
            return claimsRepository.save(getRec);
        }
        return null;
    }

    @Override
    public Map<TypeClaim, Double> calculateClaimPercentage() {
        Map<TypeClaim, Double> claimPercentageMap = new HashMap<>();
        int totalClaims = 0;
        List<Reclamation> allClaims = claimsRepository.findAll();
        for (Reclamation claim : allClaims) {
            totalClaims++;
            TypeClaim type = claim.getTypeClaim();
            claimPercentageMap.put(type, claimPercentageMap.getOrDefault(type, 0.0) + 1);
        }
        for (Map.Entry<TypeClaim, Double> entry : claimPercentageMap.entrySet()) {
            double percentage = (entry.getValue() / totalClaims) * 100;
            claimPercentageMap.put(entry.getKey(), percentage);
        }

        return claimPercentageMap;
    }


}
