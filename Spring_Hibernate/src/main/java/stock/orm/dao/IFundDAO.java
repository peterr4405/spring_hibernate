package stock.orm.dao;

import stock.orm.model.Fund;


public interface IFundDAO extends IBaseDAO{
    Fund findByName(String name);
}
