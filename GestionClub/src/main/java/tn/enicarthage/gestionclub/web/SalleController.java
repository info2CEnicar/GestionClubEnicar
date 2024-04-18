package tn.enicarthage.gestionclub.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.enicarthage.gestionclub.entities.Salle;
import tn.enicarthage.gestionclub.services.ISalleService;

@RestController
@RequestMapping("/salleOrganisation")
public class SalleController {

	 @Autowired
	 private ISalleService salleService;

    // Endpoint to get available salles for a given date
    @GetMapping("/available")
    public ResponseEntity<List<Salle>> getAvailableSalles(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        List<Salle> availableSalles = salleService.getAvailableSalles(date);
        return ResponseEntity.ok(availableSalles);
    }
}