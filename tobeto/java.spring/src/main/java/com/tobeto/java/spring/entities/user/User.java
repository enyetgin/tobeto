package com.tobeto.java.spring.entities.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = " User")
public class User implements UserDetails{
    @Id
    @GeneratedValue
    private Integer id;
    private String firstName;
    private String LastName;
    private String email;
    private String password;

}
