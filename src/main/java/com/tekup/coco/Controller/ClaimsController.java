package com.tekup.coco.Controller;

import com.tekup.coco.entity.Reclamation;
import com.tekup.coco.entity.enummeration.TypeClaim;
import com.tekup.coco.services.ServiceImpl.ClaimsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ClaimsController {
    @Autowired
    ClaimsServices claimService;

    @PostMapping("/addClaim")
    //@CrossOrigin(origins = "http://localhost:4200")
    public Reclamation AddClaim(@RequestBody Reclamation claims) {
        return claimService.addClaims(claims);

    }
    @GetMapping("/GetALLClaims")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Reclamation> GetALLClaims(){
        return claimService.GetClaims();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/findByUser/{id}")
    public List<Reclamation> findByUser(@PathVariable("id") long id){
        return claimService.findByUser(id);
    }


    @GetMapping("/GetClaimsById/{idClaims}")
    @CrossOrigin(origins = "http://localhost:4200")
    public  Reclamation GetClaimsById(@PathVariable Integer idClaims){
        return claimService.getClaimsById(idClaims);
    }

    @PutMapping("/statusClaims/{idClaims}/{status}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Reclamation statusClaims(@PathVariable("idClaims") Integer idClaims,@PathVariable("status") String status) {
        return claimService.statusClaims(idClaims,status);
    }
    @DeleteMapping("/DeleteClaims/{idClaims}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void Delete(@PathVariable Integer idClaims){
        claimService.deleteClaims( idClaims);
    }

    @PutMapping("/UpdateClaims")
    @CrossOrigin(origins = "http://localhost:4200")
    public Reclamation UpdateClaims(@RequestBody Reclamation claims) {
        return  claimService.Update(claims);

    }
    @GetMapping("/claims/page")
    public Page<Reclamation> getClaimsByPage(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size) {
        return claimService.getClaimsWithPagination(page, size);
    }
    @GetMapping("/calculateClaimPercentage")
    @CrossOrigin(origins = "http://localhost:4200")
    public Map<TypeClaim, Double> calculateClaimPercentage(){
        return claimService.calculateClaimPercentage();
    }

}
