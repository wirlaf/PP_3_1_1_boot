package org.example.pp_3_1_1.model;

//import javax.persistence.*;
//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.Pattern;
//import javax.validation.constraints.Size;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Field should not be empty")
    @Size(min = 2, max = 10, message = "Incorrect length")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Incorrect format")
    @Column(name = "name")
    private String firstName;

    @NotEmpty(message = "Field should not be empty")
    @Size(min = 2, max = 10, message = "Incorrect length")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Incorrect format")
    @Column(name = "last_name")
    private String lastName;

    @NotEmpty(message = "Field should not be empty")
    @Email(message = "Incorrect format")
    @Column(name = "email")
    private String email;

    public User() {
    }

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
