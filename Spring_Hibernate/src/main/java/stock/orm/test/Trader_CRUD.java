package stock.orm.test;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import stock.orm.dao.ITraderDAO;
import stock.orm.model.Trader;

public class Trader_CRUD {

    private static ApplicationContext context;
    private static ITraderDAO traderDAO;

    static {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        traderDAO = (ITraderDAO) context.getBean("traderDAO");
    }

    public static void main(String[] args) {

        //add();
        //update("Peter", "Jason");
        //delete("Jason");
        queryAll().stream().forEach(e ->System.out.println(e.getName()));
        
    }

    public static void add() {
        Trader t = new Trader("Mary");
        Trader t2 = new Trader("John");
        Trader t3 = new Trader("Peter");
        traderDAO.create(t);
        traderDAO.create(t2);
        traderDAO.create(t3);
    }

    public static void update(String name, String newName) {
        Trader t = traderDAO.findByName(name);
        if (t != null) {
            t.setName(newName);
            traderDAO.update(t);
        } else {
            System.out.println("didn't find Trader Name!");
        }
    }

    public static void delete(String name) {
        Trader t = traderDAO.findByName(name);
        if (t != null) {
            traderDAO.delete(t);
        } else {
            System.out.println("didn't find Trader Name!");
        }

    }

    public static List<Trader> queryAll() {

        return traderDAO.queryAll(Trader.class);

    }

}
