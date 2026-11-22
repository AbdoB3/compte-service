package com.enset.compte_service.repositories;

import com.enset.compte_service.entity.Compte;
import com.enset.compte_service.entity.TypeCompte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompteRepository extends JpaRepository<Compte, Long> {
    List<Compte> findByType(TypeCompte type);
}
