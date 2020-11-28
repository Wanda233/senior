package map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest {
    @Test
    public void test1(){
        Map map = new HashMap();
        map.put("AA",12);
        map.put(45,12);
        map.put("BB",12);
        map.put("BB",52);
        System.out.println(map);

        Set set = map.keySet();

        System.out.println(set);
        for(Object o: set){
            System.out.println(o);
        }

    }
}
