package com.joaoneto.moneo_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter  private Long id;

    @Column(nullable = false, unique = true)
    @Getter @Setter  private String email;

    @Column(nullable = false)
    @Getter @Setter  private String name;

    public User(String email, String name){
        this.email = email;
        this.name = name;
    }
}
