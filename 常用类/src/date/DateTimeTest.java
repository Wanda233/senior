package date;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeTest {

    @Test
    public void test1(){
        long time = System.currentTimeMillis();
        System.out.println(time);
    }

    @Test
    public void test2(){
        Date date1 = new Date();
        System.out.println(date1.toString());
        System.out.println(date1.getTime());

        //构造器二：创建指定毫秒数的Date对象
        Date date2 = new Date(155030620410L);
        System.out.println(date2.toString());

        Date date = new Date();
        java.sql.Date date3 = new java.sql.Date(date.getTime());
        System.out.println(date);
        System.out.println(date3);
    }

    @Test
    public void test3() throws ParseException {
        String data = "2020-09-02";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date da = simpleDateFormat.parse(data);
        System.out.println(da);
        java.sql.Date date3 = new java.sql.Date(da.getTime());
        System.out.println(date3);

    }


}
