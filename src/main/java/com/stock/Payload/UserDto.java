package com.stock.Payload;



import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class UserDto {

	    private  Long userId;
		
	    private String userName;
		
	    private String address;
		
	    private String email;
		
	    private String password;
	    private  Date timeStamp;
	    
	    private List<PortfolioDto> portfolios = new ArrayList<>();
	    
	    private List<StocksDto> stocks = new ArrayList<>();
	    
	  
}
