package stock.orm.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import stock.orm.model.Fund;
import stock.orm.model.FundNet;
import stock.orm.model.Stock;
import stock.orm.model.Trader;


public class 四合一 {
    
    public static void main(String[] args) {
              // 建立新股票
        Stock stock1 = new Stock("3008", "大立光");
        Stock stock2 = new Stock("2330", "台積電");
        Stock stock3 = new Stock("2303", "聯電");
        
        // 建立新基金
        Fund fund = new Fund("A", "高科技");
        Set<Stock> stocks = new HashSet<>();
        stocks.add(stock1);
        stocks.add(stock2);
        stocks.add(stock3);
        fund.setStocks(stocks);
        
        // 建立基金淨值
        FundNet fundNet = new FundNet();
        fundNet.setValue(10);
        fundNet.setFund(fund);
        fund.setFundnet(fundNet);
        
        // 建立操盤手
        Trader trader1 = new Trader("Mary");
        Trader trader2 = new Trader("John");
        Set<Trader>traders = new HashSet<>();
        traders.add(trader1);
        traders.add(trader2);
        fund.setTraders(traders);
       // fund.getTraders().add(trader1);
       // fund.getTraders().add(trader2);
        
        // 經由 Hibernate 存入資料表
        Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction tx = session.beginTransaction();
        
        session.save(fund);
        
        tx.commit();
    }
    
}
