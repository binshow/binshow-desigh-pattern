package _01_factory_method;


// 简单工厂需要多态化，我们应该对生产方式（工厂方法）进行抽象化
public interface Factory {

    public Enemy create(int screenWidth);
}
