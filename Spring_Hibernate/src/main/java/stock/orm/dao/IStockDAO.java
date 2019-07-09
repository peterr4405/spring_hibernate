package stock.orm.dao;

import stock.orm.model.Stock;


public interface IStockDAO extends IBaseDAO{
        Stock findByCode(String stockcode);
}
