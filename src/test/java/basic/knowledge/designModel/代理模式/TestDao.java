package basic.knowledge.designModel.代理模式;

/**
 * @Author: CarryJey
 * @Date: 2018/10/17 21:55:51
 */
public class TestDao implements DaoInterface{
    @Override
    public void add() {
        System.out.println("add ...");
    }

    @Override
    public void delete() {
        System.out.println("delete ...");
    }

    @Override
    public void update() {
        System.out.println("update ...");
    }

    @Override
    public void select() {
        System.out.println("select ....");
    }
}
