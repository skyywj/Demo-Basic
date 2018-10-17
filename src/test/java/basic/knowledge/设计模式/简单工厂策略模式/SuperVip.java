package basic.knowledge.设计模式.简单工厂策略模式;

/**
 * @Author: CarryJey @Date: 2018/10/17 19:48:16
 * desc: SuperVip打九折。消费20000 <= calPrice
 */

@PriceRegion(min = 20000)
public class SuperVip implements CalPrice{

    @Override
    public Double calPrice(Double orgnicPrice) {
        System.out.println("您的消费达￥20000，给您八折优惠");
        return orgnicPrice * 0.8;
    }
}
