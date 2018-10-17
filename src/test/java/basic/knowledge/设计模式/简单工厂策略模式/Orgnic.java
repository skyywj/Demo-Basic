package basic.knowledge.设计模式.简单工厂策略模式;

/**
 * @Author: CarryJey @Date: 2018/10/17 19:46:41
 * desc:默认1000之内不打折
 */

@PriceRegion(min = 0,max = 9999)
public class Orgnic implements CalPrice{

    @Override
    public Double calPrice(Double orgnicPrice) {
        return orgnicPrice;
    }
}
