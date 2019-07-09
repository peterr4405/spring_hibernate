package stock.orm.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import stock.orm.dao.IFundDAO;
import stock.orm.dao.IInvestorDAO;
import stock.orm.dao.IStockDAO;
import stock.orm.dao.ITraderDAO;
import stock.orm.dao.InvestorDAO;
import stock.orm.model.Fund;
import stock.orm.model.FundNet;
import stock.orm.model.Investor;
import stock.orm.model.Stock;
import stock.orm.model.Trader;



public class Fund_CRUD {
    private static ApplicationContext context;
    private static IFundDAO fundDAO;
    private static IStockDAO stockDAO;
    private static ITraderDAO traderDAO;
    private static IInvestorDAO InvestorDAO;
    
    
    
    static{
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        fundDAO = (IFundDAO)context.getBean("fundDAO");
        stockDAO = (IStockDAO)context.getBean("StockDAO");
        traderDAO = (ITraderDAO)context.getBean("traderDAO");
        InvestorDAO = (IInvestorDAO)context.getBean("investorDAO");
    }
    
    
    
    
    public static void main(String[] args) {
        
//        create("A", "高收益");
//        create("B", "高股價");
//        create("C", "高利潤");
//        addStock("A", "3008");
//        addTrader("B", "Mary");
        //addInvestior("A", "Lucky");
        find("A");
    }
    
    
    public static void create(String name,String desc){
        Fund fund = new Fund(name,desc);
        
        FundNet fundnet = new FundNet();
        fundnet.setValue(10);
        fundnet.setFund(fund);
        fund.setFundnet(fundnet);
        fundDAO.create(fund);
    }
    
    
    public static void addStock(String name,String ... stockCodes){
        Fund fund = fundDAO.findByName(name);
        
        for(String stockCode : stockCodes){
        Stock stock = stockDAO.findByCode(stockCode);
        fund.getStocks().add(stock);
        }
        fundDAO.update(fund);
    }
    
    public static void addTrader(String name , String ... traderNames){
        Fund fund = fundDAO.findByName(name);
    
        for(String traderName: traderNames){
        Trader trader = traderDAO.findByName(traderName);
        fund.getTraders().add(trader);
        }
        fundDAO.update(fund);
    }
    
        public static void addInvestior(String name,String ... InvestorNames){
        Fund fund = fundDAO.findByName(name);
        for(String investorname : InvestorNames){
            Investor inverstor = InvestorDAO.findByName(investorname);
            fund.getInvestors().add(inverstor);
        }
        fundDAO.update(fund); 
    
    } 
    
    public static void find(String name){
        Fund fund = fundDAO.findByName(name);
        System.out.println("基金名稱: "+fund.getName()+" " +fund.getDesc());
        System.out.println("成分股: ");
        fund.getStocks().stream().forEach(e ->System.out.println(" "+e.getStockCode() + " "+ e.getStockName()));
        System.out.println("操盤手: ");
        fund.getTraders().stream().forEach(e -> System.out.println(" "+e.getName()));
        System.out.println("投資人: ");
        fund.getInvestors().stream().forEach(e ->System.out.println(" "+e.getName()));
    }
    
    
}
