package tn.enicarthage.organisation.RestControllers;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import tn.enicarthage.organisation.Entities.Admin;
import tn.enicarthage.organisation.Entities.Organisation;
import tn.enicarthage.organisation.Repository.AdminRepository;
import tn.enicarthage.organisation.Repository.OrganisationRepository;
import tn.enicarthage.organisation.Services.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
//@CrossOrigin("*")
@RequestMapping(value="/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminRestController {
    @Autowired
    AdminService adminService ;
    @RequestMapping(method = RequestMethod.POST)

    public Admin ajoutadmin(@RequestBody Admin admin){

        return adminService.ajouterAdmin(admin);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Admin modifierAdmin(@PathVariable("id") Long id, @RequestBody Admin admin){
        Admin newAdmin = adminService.modifierAdmin(admin);
        return newAdmin;
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<Admin> afficheradmin(){
        return adminService.afficherAdmin();
    }
    @RequestMapping(value = "/{id}",method=RequestMethod.DELETE)
    public void supprimeradmin(@PathVariable("id") Long id){

        adminService.supprimerById(id);
    }
    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public Optional<Admin> getAdminById(@PathVariable("id") Long id){

        Optional<Admin> admin = adminService.getAdminById(id);
        return admin;
    }
    @PostMapping(path = "/login")
    public ResponseEntity<Map<String, Object>> loginAdmin(@RequestBody Admin admin) {

        HashMap<String, Object> response = new HashMap<>();

        Admin userFromDB = adminRepository.findByEmail(admin.getEmail());

        if (userFromDB == null) {
            response.put("message", "Admin not found !");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }  else {
            String token = Jwts.builder()
                    .claim("data", userFromDB)
                    .signWith(SignatureAlgorithm.HS256, "SECRET") //hedha el cryptage elli trod e token crypté
                    .compact();
            response.put("token", token);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }
    @Autowired
    private AdminRepository adminRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public AdminRestController(AdminRepository adminRepository)
    {this.adminRepository= adminRepository;}
    @PostMapping(path = "registeradmin")
    public ResponseEntity<?> addAdmin(@RequestBody Admin admin) {
        if(adminRepository.existsByEmail(admin.getEmail()))
            return new ResponseEntity<Void>(HttpStatus.FOUND);
        admin.setMdp(this.bCryptPasswordEncoder.encode(admin.getMdp()));
        Admin savedUser = adminRepository.save(admin);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }
}
