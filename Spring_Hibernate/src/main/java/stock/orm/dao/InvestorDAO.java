package stock.orm.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.query.Query;
import stock.orm.model.Investor;


public class InvestorDAO extends BaseDAO implements IInvestorDAO{

    @Override
    @Transactional
    public List<Investor> queryByName(String name) {
        String sql = "from Investor where name =:name";
        Query query = getSessionFactory().getCurrentSession().createQuery(sql , Investor.class);
        query.setParameter("name", name);
        return query.list();
    }

    @Override
    @Transactional
    public Investor findByName(String name) {
        String sql = "from Investor where name =:name";
        Query query = getSessionFactory().getCurrentSession().createQuery(sql , Investor.class);
        query.setParameter("name", name).setMaxResults(1);
        List<Investor>list = query.list();
        return  list.size()>0? list.get(0):null;
    }
    
}
