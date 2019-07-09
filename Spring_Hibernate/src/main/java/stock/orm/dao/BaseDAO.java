package stock.orm.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.SessionFactory;

public abstract class BaseDAO implements IBaseDAO {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
   
    
    @Override
    @Transactional
    public void create(Object o) {
        sessionFactory.getCurrentSession().save(o);
    }

    @Override
    @Transactional
    public void update(Object o) {
        sessionFactory.getCurrentSession().update(o);
    }

    @Override
    @Transactional
    public void delete(Object o) {
        sessionFactory.getCurrentSession().delete(o);
    }

    @Override
    @Transactional
    public <T> T get(Class<T> cla, Integer id) {
        return sessionFactory.getCurrentSession().get(cla, id);
    }

    @Override
    @Transactional
    public <T> List<T> queryAll(Class<T> cla) {
        List list = sessionFactory.getCurrentSession().createQuery("from "+cla.getSimpleName()).list();
        return list;
    }

}
