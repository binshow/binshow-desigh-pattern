package factory_method;


import java.util.Random;

/*
*   工厂方法模式：
*   工厂是对对象构造、实例化、初始化过程的一种封装，以提供给其他需要对象的地方去使用，
*   以降低耦合，提高系统的扩展性，重用性。
*   众所周知，当我们需要把类实例化成对象的时候，需要用到关键字new，比如Plane = new Plane()
*   这样做的结果就是会把这个对象的诞生过程死死捆绑在我们的代码里，宿主类与实例化过程强耦合。
*   对于一些庞大复杂的系统来说，过多的实例化逻辑于宿主类中会给其后期的维护与扩展带来很多麻烦。
*   而事实是我们根本不关心到底使用哪个对象；怎样生产出它的实例；制造过程是怎样，我们只在乎谁能给我产品来完成我的任务。
*   为了满足用户需求，解决用户的痛点，工厂粉墨登场。
*
*   相比简单工厂，工厂方法可以被看做是一个升级为设计模式的变种，其工厂方法的抽象化带来了极大好处，
*   与其把所有生产方式堆积在一个简单工厂类中，不如把生产方式被推迟到具体的子类工厂中实现，工厂本身也是需要分类的，
*   这样后期的代码维护以及对新产品的扩展都会更加方便直观，而不是对单一工厂类翻来覆去地不停改动。
*
*
*
* */
public class Main {

    //https://mp.weixin.qq.com/s?__biz=MzI4Njc5NjM1NQ==&mid=2247487170&idx=2&sn=34b135090c064c1ca202d629a4beab52&chksm=ebd631eedca1b8f85e444f7544c2cbe696b253fe3916f17dbcfbab49b6b74653126c230fdc39&scene=21#wechat_redirect

    public static void main(String[] args) {


        int screenWidth = 100;//屏幕宽度
        System.out.println("游戏开始");
        Random random = new Random();//准备随机数

        // 不使用任何模式

        int x = random.nextInt(screenWidth);//生成敌机横坐标随机数
        Enemy airplan = new Airplane(x, 0);//实例化飞机
        airplan.show();//显示飞机

        x = random.nextInt(screenWidth);//坦克同上
        Enemy tank = new Tank(x, 0);
        tank.show();

        System.out.println(" ========== ");
        System.out.println("使用 简单工厂模式 后");

        SimpleFactory factory = new SimpleFactory(100);
        factory.create("Airplane").show();
        factory.create("Tank").show();


        //简单工厂需要多态化


        System.out.println(" ========== ");
        System.out.println("使用 工厂方法模式 后");

        System.out.println("游戏开始!!!");
        Factory factory2 = new RandomFactory();
        for (int i = 0; i < 10; i++) {
            factory2.create(screenWidth).show();
        }
        System.out.println("抵达关底!!!");
        factory2 = new BossFactory();
        factory2.create(screenWidth).show();

    }



}
