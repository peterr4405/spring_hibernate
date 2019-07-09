package stock.orm.dao;

import stock.orm.model.Trader;


public interface ITraderDAO extends IBaseDAO{
    Trader findByName(String traderName);
}
