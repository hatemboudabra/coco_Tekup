package com.tekup.coco.services;

import com.tekup.coco.Dto.ReclamationDto;
import com.tekup.coco.entity.Reclamation;
import com.tekup.coco.entity.enummeration.TypeClaim;

import java.util.List;
import java.util.Map;

public interface ClaimService {
    public ReclamationDto addClaims(ReclamationDto claims) ;
    public Reclamation getClaimsById(Integer idClaims);
    public List<Reclamation> GetClaims() ;
    public List<Reclamation> findByUser(Long id) ;
    public Reclamation Update( Reclamation claims) ;
    public Reclamation statusClaims(Integer idClaims , String status) ;
    public void deleteClaims(Integer idClaims );
    public Map<TypeClaim, Double> calculateClaimPercentage();
}
