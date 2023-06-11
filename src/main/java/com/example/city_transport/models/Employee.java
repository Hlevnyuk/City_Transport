package com.example.city_transport.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String email;
    private int numberEmployee;
    private String surname;
    private String name;
    private String patronymic;
    private String telephone;
    private String post;
    private Date dateBirth;
    private String address;
    private String password;
}
