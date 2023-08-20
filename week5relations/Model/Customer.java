package com.example.week5relations.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

  @NotNull(message = "Name must be not null")
  @Column(columnDefinition = "varchar(20) not null")
   private String name;


  @OneToOne(cascade = CascadeType.ALL ,mappedBy = "customer")
  @PrimaryKeyJoinColumn
  private Details details;
}
