import org.junit.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamAPITest {
    @Test
    public void test1(){
        List<Employee> list = EmployeeData.getEmployees();
        list.stream().filter(employee -> employee.getSalary()>7000).forEach(System.out::println);
        System.out.println();
        list.stream().limit(3).forEach(System.out::println);
        System.out.println();
        list.stream().skip(3).forEach(System.out::println);
        System.out.println();
    }
    @Test
    public void test2(){
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(str->str.toUpperCase()).forEach(System.out::println);
        List<Employee> list1 = EmployeeData.getEmployees();
        list1.stream().map(Employee::getName).filter(name->name.length()>3).forEach(System.out::println);
        System.out.println();
        list.stream().map(StreamAPITest::fromStringToStream).forEach(s->{
            s.forEach(System.out::println);
        });
        System.out.println();

        list.stream().flatMap(StreamAPITest::fromStringToStream).forEach(System.out::println);
    }

    public static Stream<Character> fromStringToStream(String str){
        ArrayList<Character> list = new ArrayList<>();
        for(Character c:str.toCharArray()){
            list.add(c);
        }
        return list.stream();
    }

    @Test
    public void test3(){
        //        sorted()——自然排序
        List<Integer> list = Arrays.asList(12, 43, 65, 34, 87, 0, -98, 7);
        list.stream().sorted().forEach(System.out::println);
        //抛异常，原因:Employee没有实现Comparable接口


//        sorted(Comparator com)——定制排序

        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted( (e1,e2) -> {

            int ageValue = Integer.compare(e1.getAge(),e2.getAge());
            if(ageValue != 0){
                return ageValue;
            }else{
                return -Double.compare(e1.getSalary(),e2.getSalary());
            }

        }).forEach(System.out::println);
    }
}
