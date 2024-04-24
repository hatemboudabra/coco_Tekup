    package com.tekup.coco.services.ServiceImpl;

    import com.tekup.coco.Dto.AnnonceCollocationDto;
    import com.tekup.coco.entity.AnnonceCollocation;
    import com.tekup.coco.entity.User;
    import com.tekup.coco.repository.AnnonceCollocationRepository;
    import com.tekup.coco.repository.UserRepo;
    import com.tekup.coco.services.AnnonceCollocationService;
    import jakarta.transaction.Transactional;
    import org.springframework.stereotype.Service;

    import java.util.List;
    import java.util.Optional;

    @Service
    @Transactional

    public class AnnonceCollocationServiceImpl implements AnnonceCollocationService {
        private final AnnonceCollocationRepository annonceCollocationRepo;
        private final UserRepo userRepo;

        public AnnonceCollocationServiceImpl(AnnonceCollocationRepository annonceCollocationRepo, UserRepo userRepo) {
            this.annonceCollocationRepo = annonceCollocationRepo;
            this.userRepo = userRepo;
        }


        @Override
        public AnnonceCollocationDto addAnnonce(AnnonceCollocationDto annonceCollocationDto) {
            AnnonceCollocation annonceCollocation = new AnnonceCollocation();
            annonceCollocation.setDate_dispo(annonceCollocationDto.getDate_dispo());
            annonceCollocation.setNbre_chmbre(annonceCollocationDto.getNbre_chmbre());
            annonceCollocation.setDescrption(annonceCollocationDto.getDescrption());
            annonceCollocation.setMontant(annonceCollocationDto.getMontant());
            annonceCollocation.setNbre_person(annonceCollocationDto.getNbre_person());
            annonceCollocation.setTypeLogement(annonceCollocationDto.getTypeLogement());
            annonceCollocation.setTypeAnnoColloc(annonceCollocationDto.getTypeAnnoColloc());

            User user = userRepo.findById(annonceCollocationDto.getUserId()).orElse(null);
            annonceCollocation.setUser(user);

             annonceCollocationRepo.save(annonceCollocation);
             return annonceCollocationDto;
        }


        @Override
        public AnnonceCollocationDto updateAnnonce(Long id, AnnonceCollocationDto annonceCollocationDto) {
            Optional<AnnonceCollocation> optionalAnnonceCollocation = annonceCollocationRepo.findById(id);
            if (optionalAnnonceCollocation.isPresent()) {
                AnnonceCollocation annonceCollocation = optionalAnnonceCollocation.get();
                annonceCollocation.setDate_dispo(annonceCollocationDto.getDate_dispo());
                annonceCollocation.setNbre_chmbre(annonceCollocationDto.getNbre_chmbre());
                annonceCollocation.setDescrption(annonceCollocationDto.getDescrption());
                annonceCollocation.setMontant(annonceCollocationDto.getMontant());
                annonceCollocation.setNbre_person(annonceCollocationDto.getNbre_person());
                annonceCollocation.setTypeLogement(annonceCollocationDto.getTypeLogement());
                annonceCollocation.setTypeAnnoColloc(annonceCollocationDto.getTypeAnnoColloc());

                User user = userRepo.findById(annonceCollocationDto.getUserId()).orElse(null);
                annonceCollocation.setUser(user);

                 annonceCollocationRepo.save(annonceCollocation);
                return annonceCollocationDto;

            }
            return null;
        }

        @Override
        public List<AnnonceCollocation> getAllAnnonces() {
            return annonceCollocationRepo.findAll();        }

        @Override
        public void deleteAnnonceById(Long id) {
            annonceCollocationRepo.deleteById(id);

        }
        @Override
        public Optional<AnnonceCollocation> getAnnonceById(Long id) {
            return annonceCollocationRepo.findById(id);
        }
    }
