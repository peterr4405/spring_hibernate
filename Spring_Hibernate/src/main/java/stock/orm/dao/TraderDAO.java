package stock.orm.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.query.Query;
import stock.orm.model.Trader;


public class TraderDAO extends BaseDAO implements ITraderDAO{

    @Override
    @Transactional
    public Trader findByName(String traderName) {
        String sql = "from Trader where name =: name";
        Query query = getSessionFactory().getCurrentSession().createQuery(sql,Trader.class);
        query.setParameter("name", traderName).setMaxResults(1);
        List <Trader> list = query.list();
        return list.size()>0? list.get(0):null;
        
    }
    
    
    
}
