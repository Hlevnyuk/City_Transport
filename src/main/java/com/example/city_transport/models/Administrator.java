package com.example.city_transport.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Administrator {
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateBirth;
    private String phoneNumber;
    private String password;
}
