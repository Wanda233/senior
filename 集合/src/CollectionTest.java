import com.sun.org.apache.xpath.internal.operations.String;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class CollectionTest {
    @Test
    public void test1(){
        Collection collection = new ArrayList();
        collection.add("aa");
        collection.add(123);
        collection.add(new Date());
        collection.add(new Person("ton",20));
        collection.add(new java.lang.String("Tom"));
        System.out.println(collection.size());
        System.out.println(collection);

        Collection collection1 = new ArrayList();
        collection1.add("cc");
        collection1.add("dd");
        collection.addAll(collection1);
        System.out.println(collection);

        System.out.println(collection.contains(new java.lang.String("Tom")));
        System.out.println(collection.contains(new Person("ton",20)));
    }

    @Test
    public void test2(){

    }
}
