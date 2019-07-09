package stock.orm.dao;

import java.util.List;


public interface IBaseDAO {
    
    void create(Object o);
    
    void update(Object o);
    
    void delete(Object o);
    
    public <T extends Object>T get(Class<T> cla,Integer id);
    
    public <T extends Object>List<T> queryAll(Class<T>cla);
}
