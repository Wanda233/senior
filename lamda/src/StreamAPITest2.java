import org.junit.Test;

import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamAPITest2 {
    @Test
    public void test1(){
        List<Employee> list = EmployeeData.getEmployees();
        boolean match = list.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(match);

        boolean match1 = list.stream().anyMatch(e -> e.getSalary() > 10000);
        System.out.println(match1);

        boolean noneMatch = list.stream().noneMatch(e -> e.getName().startsWith("雷"));
        System.out.println(noneMatch);

        Optional<Employee> first = list.stream().findFirst();
        System.out.println(first);

        Optional<Employee> any = list.stream().findAny();
        System.out.println(any);
    }
    @Test
    public void test2(){
        List<Employee> list1 = EmployeeData.getEmployees();
        long count = list1.stream().count();
        System.out.println(count);
        Optional<Employee> max = list1.stream().max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(max);

        Optional<Double> min = list1.stream().map(Employee::getSalary).min(Double::compare);
        System.out.println(min);
    }

    @Test
    public void test3(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer reduce = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce);

        List<Employee> employees = EmployeeData.getEmployees();
        Optional<Double> reduce1 = employees.stream().map(Employee::getSalary).reduce((d1, d2) -> d1 + d2);
        System.out.println(reduce1.get());
    }
}
