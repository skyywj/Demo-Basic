package basic.knowledge.设计模式.简单工厂策略模式;

/**
 * @Author: CarryJey @Date: 2018/10/17 19:48:16
 * desc: Vip打九折。消费超过10000<= calPrice <20000
 */

@PriceRegion(min = 10000,max = 19999)
public class Vip implements CalPrice{

    @Override
    public Double calPrice(Double orgnicPrice) {
        System.out.println("您的消费达￥10000，给您九折优惠");
        return orgnicPrice * 0.9;
    }
}
