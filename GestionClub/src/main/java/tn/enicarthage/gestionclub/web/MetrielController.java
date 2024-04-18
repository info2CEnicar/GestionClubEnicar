package tn.enicarthage.gestionclub.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.enicarthage.gestionclub.services.IMaterielService;

@RestController
@RequestMapping("/matrielOrganisation")
public class MetrielController {
	@Autowired
    private IMaterielService materielService;

    // Endpoint to calculate available quantity of a material on a given date
    @GetMapping("/{materielId}/available")
    public ResponseEntity<?> getAvailableMaterial(@PathVariable Long materielId, 
                                                  @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        try {
            int availableQuantity = materielService.calculateAvailableMaterial(materielId, date);
            return ResponseEntity.ok(availableQuantity);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
