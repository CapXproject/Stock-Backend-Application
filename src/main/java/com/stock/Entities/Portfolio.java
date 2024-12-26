package com.stock.Entities;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Portfolio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long portfolioId;
   private Long value;
   private Date timeStamp;
   
   @ManyToOne
   private User user ;
}
