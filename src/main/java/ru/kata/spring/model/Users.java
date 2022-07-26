package ru.kata.spring.model;

import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@ToString
@RequiredArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
@Entity
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

    public Users(long id, String name, String lastName, String email) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
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
