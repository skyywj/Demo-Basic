package basic.knowledge.designModel.简单工厂策略模式;

/**
 * @Author: CarryJey @Date: 2018/10/17 19:43:50
 */
public class Customer {
    //消费总金额
    private Double totalAmount = 0D;
    //单次消费金额
    private Double amount = 0D;
    //默认消费1000元之内不打折
    private CalPrice calPrice = new Orgnic();

    public void buy(Double amount){
        this.amount = amount;
        this.totalAmount += amount;
        calPrice = CalPriceFactory.getInstance().createCalPrice(this);
    }


    //客户最终需要付的钱
    public Double finalAmount(){
        return calPrice.calPrice(amount);
    }

    //获取总金额
    public Double getTotalAmount() {
        return totalAmount;
    }
}
