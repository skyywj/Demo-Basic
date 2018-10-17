package basic.knowledge.设计模式.简单工厂策略模式;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: CarryJey @Date: 2018/10/17 20:15:27
 */
@ContextConfiguration
@Component
@RunWith(SpringRunner.class)
public class TestRun {

    private Customer customer = new Customer();

    @Test
    public void testRun() {
        customer.buy(15000D);
        System.out.println("原价为: " + customer.getTotalAmount());
        System.out.println("最终总价为: " + customer.finalAmount());
        System.out.println("---------分割线以下为第二次购物---------");
        customer.buy(10000D);
        System.out.println("原价为: " + customer.getTotalAmount());
        System.out.println("最终总价为: " + customer.finalAmount());

    }
    /**
     * 运行结果
     *     原价为: 15000.0
     *     您的消费达￥10000，给您九折优惠
     *     最终总价为: 13500.0
     *             ---------分割线以下为第二次购物---------
     *     原价为: 25000.0
     *     您的消费达￥20000，给您八折优惠
     *     最终总价为: 8000.0
     */

}
