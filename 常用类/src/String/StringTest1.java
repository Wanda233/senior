package String;

import org.junit.Test;

public class StringTest1 {

    @Test
    public void test(){
        String string = "123";
        int num = Integer.parseInt(string);

        String str = String.valueOf(num);
     //   String str = num + "";

    }
}
