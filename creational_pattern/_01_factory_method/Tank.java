package _01_factory_method;

// 坦克敌人
public class Tank extends Enemy{

    public Tank(int x, int y) {
        super(x, y);
    }

    @Override
    public void show() {
        System.out.println("坦克出现坐标：" + x + "," + y);
        System.out.println("坦克向玩家发起攻击……");
    }
}
