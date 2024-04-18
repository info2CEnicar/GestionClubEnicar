package tn.enicarthage.gestionclub.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityNotFoundException;
import tn.enicarthage.gestionclub.entities.ResponsableClub;
import tn.enicarthage.gestionclub.services.IResponsableClubService;

@RestController
@RequestMapping("/register")
public class ResponsableClubController {

	@Autowired
    private IResponsableClubService responsableClubService;

    @PostMapping("/updateOrCreate")
    public ResponseEntity<?> createOrUpdateResponsableClub(
        @RequestParam String userName,
        @RequestParam String email,
        @RequestParam String password,
        @RequestParam String clubName,
        @RequestParam String clubDescription,
        @RequestParam String clubType,
        @RequestParam String clubImage,
        @RequestParam int responsableClubNumTel) {

        try {
            ResponsableClub responsableClub = responsableClubService.createOrUpdateResponsableClubWithClubInfo( 
                userName, email, password,
                clubName, clubDescription, clubType, clubImage, 
                responsableClubNumTel);
            return ResponseEntity.ok(responsableClub);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}