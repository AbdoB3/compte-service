package com.enset.compte_service.web;

import com.enset.compte_service.entity.Compte;
import com.enset.compte_service.repositories.CompteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/comptes")
public class CompteRestController {

    private final CompteRepository repo;

    public CompteRestController(CompteRepository repo) {   // injection de dépendance
        this.repo = repo;
    }

    @GetMapping                       // GET /api/comptes
    public List<Compte> liste() {
        return repo.findAll();
    }

    @GetMapping("/{id}")              // GET /api/comptes/1
    public Compte parId(@PathVariable Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Compte introuvable"));
    }

    @PostMapping                      // POST /api/comptes
    public Compte creer(@RequestBody Compte compte) {
        compte.setDateCreation(new Date());
        return repo.save(compte);
    }

    @PutMapping("/{id}")              // PUT /api/comptes/1
    public Compte modifier(@PathVariable Long id, @RequestBody Compte compte) {
        compte.setId(id);
        return repo.save(compte);
    }

    @DeleteMapping("/{id}")           // DELETE /api/comptes/1
    public void supprimer(@PathVariable Long id) {
        repo.deleteById(id);
    }
}