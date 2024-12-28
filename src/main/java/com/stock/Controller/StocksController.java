package com.stock.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.stock.Payload.ApiResponse;
import com.stock.Payload.StocksDto;
import com.stock.Services.StocksService;

@RestController()
@RequestMapping("/api/v1")
public class StocksController {

	@Autowired
    private StocksService  stockService;
	
	@PostMapping("/user/{userId}/stock/create")
	ResponseEntity<StocksDto>  createStock(@RequestBody  StocksDto stocksDto,@PathVariable Long userId)
	{
		StocksDto  savedStocks = this.stockService.createStocks(stocksDto,userId);
		return new ResponseEntity<StocksDto>(savedStocks,HttpStatus.CREATED);
	}
	
	@PutMapping("/stock/update/{stockId}")
	ResponseEntity<StocksDto> updateStocks(@RequestBody StocksDto stockDto,@PathVariable Long stockId)
	{
		StocksDto updateStock =  this.stockService.updateStocks(stockDto, stockId);
		return new ResponseEntity<StocksDto>(updateStock,HttpStatus.OK);
	}
	
	@GetMapping("/stock/{stockId}")
	ResponseEntity<StocksDto> getStockById(@RequestBody @PathVariable Long stockId)
	{
		StocksDto stocks = this.stockService.getByStocksId(stockId);
		return new ResponseEntity<StocksDto>(stocks,HttpStatus.OK);
	}
	
    @GetMapping("/stock/all")
    ResponseEntity<List<StocksDto>> getAllStocks()
    {
    	List<StocksDto>   allStocks = this.stockService.getAllStocks();
    	return new ResponseEntity<List<StocksDto>>(allStocks,HttpStatus.OK);
    }
    
    @DeleteMapping("/Stock/delete/{stockId}")
    ResponseEntity<ApiResponse>  deleteStocks(@RequestBody @PathVariable Long stockId)
    {
    	this.stockService.deleteStock(stockId);
    	return new ResponseEntity<ApiResponse>(new ApiResponse("Stock Delete Successfully...",true) , HttpStatus.OK);
    }
    
    @GetMapping("/user/{userId}/stock/all")
    ResponseEntity<List<StocksDto>> getAllStocksByUserId(@RequestBody @PathVariable Long userId)
    {
    	List<StocksDto>   allStocks = this.stockService.getAllStocksByUserId(userId);
    	return new ResponseEntity<List<StocksDto>>(allStocks,HttpStatus.OK);
    }
}
