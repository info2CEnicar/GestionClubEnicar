package tn.enicarthage.gestionclub.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityNotFoundException;
import tn.enicarthage.gestionclub.services.IAuthentificationService;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthentificationController {
	@Autowired
    private IAuthentificationService authenticationService;

	@PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestParam String email, @RequestParam String password) {
        try {
            String userType = authenticationService.authenticateUser(email, password);
            return ResponseEntity.ok("Login successful as " + userType);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal server error");
        }
    }
}
