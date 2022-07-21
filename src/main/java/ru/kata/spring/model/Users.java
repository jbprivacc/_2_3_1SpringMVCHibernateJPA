package ru.kata.spring.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;



@RequiredArgsConstructor
@Builder
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@Table(name = "users_info")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    @NotEmpty(message = "Enter name")
    private String name;

    @Column(name = "lastname")
    @NotEmpty(message = "Enter last name")
    private String lastName;

    @Column(name = "email")
    @Email(message = "Invalid email")
    private String email;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Users users = (Users) o;
        return false;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
