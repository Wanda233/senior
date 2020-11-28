import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {
    @Test
    public void test1(){
        Person person = new Person("tom",12);
        person.age = 10;
        System.out.println(person.toString());
        person.show();
    }
    @Test
    public void test2() throws Exception{
        Class clazz = Person.class;
//1.通过反射，创建Person类的对象
        Constructor constructor = clazz.getConstructor(String.class,int.class);
        Object o = constructor.newInstance("tom", 12);
        Person person = (Person)o;
//2.通过反射，调用对象指定的属性、方法
        Field fieldAge = clazz.getDeclaredField("age");
        fieldAge.set(person,10);
        System.out.println(person.toString());

        Method show = clazz.getDeclaredMethod("show");
        show.invoke(person);
        System.out.println("************************************");
//通过反射，可以调用Person类的私有结构的。比如：私有的构造器、方法、属性
        //调用私有的构造器
        Constructor constructor1 = clazz.getDeclaredConstructor(String.class);
        constructor1.setAccessible(true);
        Person person1 = (Person)constructor1.newInstance("jerry");
        System.out.println(person1);

        //调用私有的属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(person1,"hanmeimei");
        System.out.println(person1.toString());
        //调用私有的方法
        Method method = clazz.getDeclaredMethod("showNation", String.class);
        method.setAccessible(true);
        method.invoke(person1, "中国");

    }
    /*
    关于java.lang.Class类的理解
    1.类的加载过程：
    程序经过javac.exe命令以后，会生成一个或多个字节码文件(.class结尾)。
    接着我们使用java.exe命令对某个字节码文件进行解释运行。相当于将某个字节码文件
    加载到内存中。此过程就称为类的加载。加载到内存中的类，我们就称为运行时类，此
    运行时类，就作为Class的一个实例。

    2.换句话说，Class的实例就对应着一个运行时类。
    3.加载到内存中的运行时类，会缓存一定的时间。在此时间之内，我们可以通过不同的方式
    来获取此运行时类。
     */
    //获取（注意：是获取而不是创建）Class的实例的方式（前三种方式需要掌握）
    @Test
    public void test3() throws ClassNotFoundException {
        //方式一：调用运行时类的属性：.class
        Class clazz1 = Person.class;
        System.out.println(clazz1);
        //方式二：通过运行时类的对象,调用getClass()
        Person person = new Person();
        Class clazz2 = person.getClass();
//        System.out.println(clazz2);
        //方式三：调用Class的静态方法：forName(String classPath)
        Class clazz3 = Class.forName("Person");
        System.out.println(clazz3);
    }
}
