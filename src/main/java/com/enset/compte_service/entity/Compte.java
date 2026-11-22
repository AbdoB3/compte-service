package com.enset.compte_service.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity                      // cette classe devient une table
@Data                        // Lombok : getters, setters, toString...
@NoArgsConstructor           // constructeur vide (obligatoire pour JPA)
@AllArgsConstructor          // constructeur avec tous les champs
@Builder                     // permet Compte.builder().solde(100).build()
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id auto-incrémenté
    private Long id;

    private double solde;

    @Temporal(TemporalType.DATE)
    private Date dateCreation;

    @Enumerated(EnumType.STRING)  // stocke "COURANT" plutôt que 0
    private TypeCompte type;
}