package com.stock.ServiceImpl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.Entities.Stocks;
import com.stock.Entities.User;
import com.stock.Payload.StocksDto;
import com.stock.Repositories.StocksRepo;
import com.stock.Repositories.UserRepo;
import com.stock.Services.StocksService;

@Service
public class StocksServiceImpl  implements  StocksService {

	@Autowired
	private StocksRepo   stockRepo;
	
	@Autowired
	private ModelMapper  modelMapper;
	
	@Autowired
	private UserRepo  userRepo;
	
	
	@Override
	public StocksDto createStocks(StocksDto stocksDto,Long userId) {
		User user =   this.userRepo.findById(userId).orElseThrow(()-> new RuntimeException("User Not Found"));
		stocksDto.setTimeStamp(new Date());
	  Stocks stock = this.modelMapper.map(stocksDto, Stocks.class);
	  stock.setUser(user);
	  Stocks  savedStock = this.stockRepo.save(stock);
		return this.modelMapper.map(savedStock, StocksDto.class);
	}

	@Override
	public StocksDto updateStocks(StocksDto stocksDto, Long StockId) {
		Stocks  stock = this.stockRepo.findById(StockId).orElseThrow(()-> new  RuntimeException("Stock Not Found"));
		stock.setStockName(stocksDto.getStockName());
		stock.setTicker(stocksDto.isTicker());
		stock.setQuantity(stocksDto.getQuantity());
		stock.setClose(stocksDto.getClose());
		stock.setOpen(stocksDto.getOpen());
		stock.setMarketPrice(stocksDto.getMarketPrice());
		Stocks  udpatedStock = this.stockRepo.save(stock);
		return this.modelMapper.map(udpatedStock, StocksDto.class);
	}

	@Override
	public StocksDto getByStocksId(Long StockId) {
		Stocks  stock = this.stockRepo.findById(StockId).orElseThrow(()-> new  RuntimeException("Stock Not Found"));
		
		return this.modelMapper.map(stock, StocksDto.class);
	}

	@Override
	public void deleteStock(Long StockId) {
		Stocks  stock = this.stockRepo.findById(StockId).orElseThrow(()-> new  RuntimeException("Stock Not Found"));
		
		this.stockRepo.delete(stock);
	}

	@Override
	public List<StocksDto> getAllStocks() {
		List<Stocks>  allStocks = this.stockRepo.findAll();
		List<StocksDto> convertedStocks = allStocks.stream().map((stock)-> this.modelMapper.map(stock, StocksDto.class)).collect(Collectors.toList());
		return convertedStocks;
	}

	@Override
	public List<StocksDto> getAllStocksByUserId(Long userId) {
		User user =   this.userRepo.findById(userId).orElseThrow(()-> new RuntimeException("User Not Found"));
		List<Stocks>  allStocks = this.stockRepo.findByUser(user);
		List<StocksDto> convertedStocks = allStocks.stream().map((stock)-> this.modelMapper.map(stock, StocksDto.class)).collect(Collectors.toList());
		return convertedStocks;
		
	}

}
