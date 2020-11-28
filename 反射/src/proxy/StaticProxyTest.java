package proxy;
/*
代理：
1.根据被代理类对象（静态/动态）创建代理类对象
2.当通过代理类的对象调用方法a时，（静态的/动态的）调用被代理类的同名方法a
 */
interface ClothFactory{
    void productCloth();
}
//代理类
class ProxyClothFactory implements ClothFactory{
    private ClothFactory factory;
    public ProxyClothFactory(ClothFactory factory){
        this.factory = factory;
    }

    @Override
    public void productCloth() {
        System.out.println("代理工厂做一些准备工作");
        factory.productCloth();
        System.out.println("代理工厂做一些后续的收尾工作");
    }
}
//被代理类
class NikeClothFactory implements ClothFactory{
    @Override
    public void productCloth() {
        System.out.println("Nike工厂生产一批运动服");
    }
}
public class StaticProxyTest {
    public static void main(String[] args) {
        ClothFactory nike = new NikeClothFactory();
        ClothFactory proxyClothFactory = new ProxyClothFactory(nike);
        proxyClothFactory.productCloth();
    }
}
