package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;


@Data
@Entity
@RequiredArgsConstructor
@EqualsAndHashCode
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @Column(name="username" ,unique = true,nullable = false)
    @JsonProperty("username")
    @NotEmpty(message = "kullanıcı ismi boş bırakılamaz!")
    private String username;

    @Column(name="name")
    @JsonProperty("name")
    @NotEmpty(message = "isim boş bırakılamaz!")
    private String name;

    @Column(name="surname")
    @JsonProperty("surname")
    @NotEmpty(message = "soyisim boş bırakılamaz!")
    private String surname;

    @Column(name="email")
    @JsonProperty("email")
    @Email(message = "hatalı email!")
    @NotEmpty(message = "mail boş bırakılamaz")
    private String email;

    @Column(name="pass")
    @JsonProperty("pass")
    @NotEmpty(message = "şifre boş bırakılamaz!")
    private String pass;

    @Column(name="pass2")
    @JsonProperty("pass2")
    private String pass2;
    @Column(name="key")
    @JsonProperty("key")
    private String key;

    @Column(name="createDate")
    @JsonProperty("createDate")
    private Date createDate=new Date();

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Note> notes;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", pass='" + pass + '\'' +
                ", pass2='" + pass2 + '\'' +
                ", key='" + key + '\'' +
                ", createDate=" + createDate +
                '}';
    }

}