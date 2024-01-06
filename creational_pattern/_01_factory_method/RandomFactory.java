package _01_factory_method;

import java.util.Random;

public class RandomFactory implements Factory{


    // 可以在屏宽之内来产出一个敌人，这就是我们抽象出来的工厂方法

    private Random random = new Random();

    @Override
    public Enemy create(int screenWidth) {
        Enemy enemy = null;
        if (random.nextBoolean()){
            enemy = new Airplane(random.nextInt(screenWidth), 0);//实例化飞机
        }else {
            enemy = new Tank(random.nextInt(screenWidth), 0);//实例化坦克
        }
        return enemy;
    }
}
