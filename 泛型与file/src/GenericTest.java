import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenericTest {
    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        list.add(78);
        list.add(75);
        list.add(90);
        list.add(89);
        //问题一：类型不安全
        list.add("tom");

        for(Object o:list){
            //问题二：强转时，可能出现ClassCastException
            int studentScore = (Integer)o;
            System.out.println(studentScore);
        }
    }
    @Test
    public void test2(){
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(78);
        integers.add(82);
        integers.add(81);
        integers.add(68);
       // integers.add("iii");
        Iterator<Integer> iterator = integers.iterator();
        while(iterator.hasNext()){
      //      int stuScore = iterator.next();
            System.out.println(iterator.next());
        }
    }
}
