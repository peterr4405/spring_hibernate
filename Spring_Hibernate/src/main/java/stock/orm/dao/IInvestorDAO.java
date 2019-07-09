package stock.orm.dao;

import java.util.List;
import stock.orm.model.Investor;

public interface IInvestorDAO extends IBaseDAO{

    List<Investor> queryByName(String name);

    Investor findByName(String name);
}
