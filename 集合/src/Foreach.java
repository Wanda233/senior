import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class Foreach {
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        for(Object object:coll){
            System.out.println(object);
        }
    }
}
