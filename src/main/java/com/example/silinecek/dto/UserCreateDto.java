package com.example.silinecek.dto;


import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserCreateDto {


    String firstName;
    String lastName;
    String adres;
    int tcNo;
    String yas;


}
