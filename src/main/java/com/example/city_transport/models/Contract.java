package com.example.city_transport.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contract {
    private int id;
    private String firm;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateStartContract;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateEndContract;
}
