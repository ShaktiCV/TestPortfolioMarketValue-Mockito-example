package CodeSnippets;

import java.util.HashMap;

public class Portfolio  {
	
	StockService stockService;
	
	public Portfolio(StockService stockService) {
		super();
		this.stockService = stockService;
	}

	public HashMap<String,Integer> stocks = new HashMap<String,Integer>();
	
	public int getMarketValue() {
		
		stocks.put("google", 100);
		stocks.put("microsoft", 1000);	
		
		int marketValue = (stocks.get("google") * stockService.getPrice("google"))+ 
				(stocks.get("microsoft") * stockService.getPrice("microsoft")) ;
		
		return marketValue;
		
		
	}
	
	
	
	
	
	
	

	
	

}
