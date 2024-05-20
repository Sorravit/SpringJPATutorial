package org.example.springjpatutorial.model.authorization;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //The role name HAVE TO be prefixed with ROLE_
    //    ROLE_ADMIN, ROLE_USER
    private String name;

}