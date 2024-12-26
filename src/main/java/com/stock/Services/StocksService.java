package com.stock.Services;

import com.stock.Payload.StocksDto;
import java.util.List;


public interface StocksService {

	StocksDto  createStocks(StocksDto  stocksDto,Long userId);
	StocksDto updateStocks(StocksDto stocksDto, Long StockId);
	StocksDto getByStocksId(Long StockId);
	void deleteStock(Long StockId);
	List<StocksDto> getAllStocks();
	List<StocksDto> getAllStocksByUserId(Long userId);
}




