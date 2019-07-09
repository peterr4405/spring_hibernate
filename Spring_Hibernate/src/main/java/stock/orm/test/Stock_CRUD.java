package stock.orm.test;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import stock.orm.dao.IStockDAO;
import stock.orm.model.Stock;


public class Stock_CRUD {
    private static ApplicationContext context;
    private static IStockDAO stockDAO;
    
    static{
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        stockDAO = (IStockDAO)context.getBean("StockDAO");
    
    }
    
    
    
    public static void main(String[] args) {
        //add();
        //update("3376", "新日興");
        //delete("3376");
        queryAll().stream().forEach(e -> System.out.println(e.getStockCode()+" "+e.getStockName()));
        
        
    }
    
    public static void add(){
       Stock stock = new Stock("3008", "大立光");
       Stock stock2 = new Stock("2330", "台積電");
       Stock stock3 = new Stock("3376", "新日興");
       stockDAO.create(stock);
       stockDAO.create(stock2);
       stockDAO.create(stock3);
    }
    
    public static void update(String stockcode,String stockname){
        Stock stock = stockDAO.findByCode(stockcode);
        stock.setStockName(stockname);
        stockDAO.update(stock);
    }
    
    public static void delete(String stockcode){
        Stock stock = stockDAO.findByCode(stockcode);
        stockDAO.delete(stock);
    }
    
    public static List<Stock> queryAll(){
    
    return stockDAO.queryAll(Stock.class);
    }
    
    
}
