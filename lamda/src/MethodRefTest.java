import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodRefTest {
    // 情况一：对象 :: 实例方法
    //Consumer中的void accept(T t)
    //PrintStream中的void println(T t)
    @Test
    public void test1(){
//        Consumer<String> consumer = str -> System.out.println(str);
        Consumer<String> consumer =  System.out::println;
        consumer.accept("北京");
    }
    @Test
    public void test2(){
        Employee employee = new Employee(1001,"tom", 23, 2500);

        Supplier<String> stringSupplier = ()->employee.getName();
        System.out.println(stringSupplier.get());

        System.out.println("**************************");
        Supplier<Integer> stringSupplier1 = employee::getId;
        System.out.println(stringSupplier1.get());
    }
    // 情况二：类 :: 静态方法
    //Comparator中的int compare(T t1,T t2)
    //Integer中的int compare(T t1,T t2)
    @Test
    public void test3(){
        Comparator<Integer> comparator = (t1, t2)->Integer.compare(t1,t2);
        System.out.println(comparator.compare(11,2));

        System.out.println("**************************");
        Comparator<Integer> comparator1 = Integer::compare;
        System.out.println(comparator1.compare(11,52));
    }
    @Test
    public void test4(){
        Function<Double,Long> function = d->Math.round(d);
        System.out.println(function.apply(23.2));
        System.out.println("**************************");
        Function<Double,Long> function1 = Math::round;
        System.out.println(function1.apply(23.2));
    }
    // 情况三：类 :: 实例方法  (有难度)
    // Comparator中的int comapre(T t1,T t2)
    // String中的int t1.compareTo(t2)
    @Test
    public void test5(){
        Comparator<String> com1 = (s1,s2) -> s1.compareTo(s2);
        System.out.println(com1.compare("abc","abd"));

        System.out.println("*******************");
        Comparator<String> com2 = String::compareTo;
        System.out.println(com2.compare("abd","abm"));
    }

    @Test
    public void test6(){
        Employee employee = new Employee(1001, "Jerry", 23, 6000);
        Function<Employee,String> function = e ->e.getName();
        System.out.println(function.apply(employee));

        System.out.println("****************************");
        Function<Employee,String> function1 = Employee::getName;
        System.out.println(function1.apply(employee));
    }
}
