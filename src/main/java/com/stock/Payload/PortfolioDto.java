package com.stock.Payload;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PortfolioDto {
  
	   private Long portfolioId;
	   private Long value;
	   private Date timeStamp;
}
