package String;

import org.junit.Test;

import javax.sound.midi.Soundbank;

public class StringTest {

    @Test
    public void test1(){
        String s1 = "abc";
        String s2 = "abc";
//        s1 = "hello";

        System.out.println(s1==s2);
        System.out.println(s2);
        System.out.println("************");
        String s3 = "abc";
        s3 += "def";
        System.out.println(s3);
        System.out.println(s2);
        System.out.println("************");
        String s4 = "abc";
        String s5 = s4.replace('a', 'm');
        System.out.println(s4);
        System.out.println(s5);
    }
}
