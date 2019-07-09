package stock.orm.test;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import stock.orm.dao.IFundDAO;
import stock.orm.dao.IInvestorDAO;
import stock.orm.model.Fund;
import stock.orm.model.Investor;

public class Investor_CRUD {

    private static ApplicationContext context;
    private static IInvestorDAO investorDAO;
    private static IFundDAO fundDAO;

    static {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        investorDAO = (IInvestorDAO) context.getBean("investorDAO");
        fundDAO = (IFundDAO) context.getBean("fundDAO");
    }

    public static void main(String[] args) {

//        add("Lucky", 10000, "A");
     queryAll().stream().forEach(e ->System.out.println(e.getName()+" "+e.getUnits()+" "+e.getNetValue()+" "+e.getFund().getName()));
    }

    public static void add(String investorName, double units, String fundName) {
        Fund fund = fundDAO.findByName(fundName);
        Investor inv = new Investor(investorName);
        inv.setUnits(units);
        inv.setFund(fund);
        investorDAO.create(inv);
    }

    public static List<Investor> queryAll() {

        return investorDAO.queryAll(Investor.class);
    }

}
