package Tests;

import org.junit.Before;
import org.junit.Test;

import CodeSnippets.Portfolio;
import CodeSnippets.StockService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class PortfolioTest {
	
	StockService StockServiceMock;
	Portfolio portfolioMock;
	
	@Before
	public void setUp() {		
		//Create the mock object of Portfolio
		StockServiceMock = mock(StockService.class);		
		portfolioMock = new Portfolio(StockServiceMock); 	
	}
	
	@Test
	public void test_Portfolio_toReturnCurrentMarketValue_WithMock() {	
		
		// stubbing values
	     when(StockServiceMock.getPrice("google")).thenReturn(50);
	     when(StockServiceMock.getPrice("microsoft")).thenReturn(100);   
	      
	      
	      //test
	      assertEquals(105000, portfolioMock.getMarketValue());
	     
	}
	
	@Test
	public void test_Portfolio_toReturnCurrentMarketValue_WithSpy() {
		StockService stockServiceSpy = spy(StockService.class);		
		Portfolio portfolioSpy = new Portfolio(stockServiceSpy);
		
		// stubbing values
	      when(stockServiceSpy.getPrice("google")).thenReturn(50);
	      when(stockServiceSpy.getPrice("microsoft")).thenReturn(100);   
	      
	      
	      //test
	      assertEquals(105000, portfolioSpy.getMarketValue());
		
		
	}
	

}
