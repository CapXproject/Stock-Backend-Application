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
public class StocksDto {
	private Long stockId;
	
	private String stockName;
	
	private boolean ticker;
	
	private Integer quantity;
	
	private Long open;
	
	private Long close;
	
	private Long marketPrice;
	private Date timeStamp;
	
	// private UserDto user;
}
