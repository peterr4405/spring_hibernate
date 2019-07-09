package stock.orm.model;


public class Trader {
    
    private Integer traderid;
    private String name;
    private Fund fund;

    public Trader() {
    }

    public Trader(String name) {
        this.name = name;
    }

    public Integer getTraderid() {
        return traderid;
    }

    public void setTraderid(Integer traderid) {
        this.traderid = traderid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Fund getFund() {
        return fund;
    }

    public void setFund(Fund fund) {
        this.fund = fund;
    }

    @Override
    public String toString() {
        return "Trader{" + "traderid=" + traderid + ", name=" + name + ", fund=" + fund + '}';
    }
    
    
}
