import org.junit.Test;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorRefTest {
    @Test
    public void test1(){
        Supplier<Employee> sup = new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };
        System.out.println("*******************");
        Supplier<Employee> sup1 = ()->new Employee();
        System.out.println(sup1.get());
        System.out.println("*******************");
        Supplier<Employee> sup2 = Employee::new;
        System.out.println(sup2.get());
    }

    @Test
    public void test2(){
        Function<Integer,Employee> function = id->new Employee(id);
        Employee employee = function.apply(1001);
        System.out.println(employee);

        System.out.println("*******************");

        Function<Integer,Employee> function1 = Employee::new;
        Employee employee1 = function1.apply(1002);
        System.out.println(employee1);
    }

    //数组引用
    //Function中的R apply(T t)
    @Test
    public void test4(){
        Function<Integer,String[]> function = length->new String[length];
        String[] strings = function.apply(5);
        System.out.println(Arrays.toString(strings));

        System.out.println("*******************");

        Function<Integer,String[]> function1 = String[]::new;
        String[] arr2 = function1.apply(10);
        System.out.println(Arrays.toString(arr2));
    }
}
