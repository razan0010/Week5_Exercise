package com.example.week5relations.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Details {

    @Id
    private Integer id;
    private String gender;
    private String email;
    private Integer age;

   @OneToOne
   @MapsId
   @JsonIgnore
    private Customer customer;


}
