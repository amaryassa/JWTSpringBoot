package com.tokenjwt.task.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class AppUser { 

    @Id @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String username;
    // @JsonIgnore
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)// EAGER==> à chaque fois que je charge l'utilisateur il va charger ses roles
    private Collection<AppRole> roles= new ArrayList<>();

}

/* 
pour ne pas afficher (retourner) le mot de passe en réponse json 

@JsonIgnore
getter

@JsonSetter
Setter
 */