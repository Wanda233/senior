import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListTest {
    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("tom",20));
        list.add(456);

        System.out.println(list);

        list.add(1,"bb");
        System.out.println(list);

        List<Integer> list1 = Arrays.asList(1, 2, 3);
        list.addAll(list1);
        System.out.println(list);
        System.out.println(list.size());

        System.out.println(list.get(2));
    }

    @Test
    public void test2(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("tom",20));
        list.add(456);

        int index = list.indexOf(456);
        System.out.println(index);

        List list1 = list.subList(1, 3);
        System.out.println(list1);
       //方式一：Iterator迭代器方式
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //方式二：增强for循环
        for(Object o :list){
            System.out.println(o);
        }
    }
}
