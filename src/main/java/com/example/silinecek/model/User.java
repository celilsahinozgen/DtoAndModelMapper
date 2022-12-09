package com.example.silinecek.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@Data
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "ISIM")
    String firstName;
    @Column(name = "SOYISIM")
    String lastName;
    @Column(name = "ADRES")
    String adres;
    @Column(name = "TC_NUMARASI")
    int tcNo;
    @Column(name = "YAS")
    String yas;
}
