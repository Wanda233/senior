
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileTest {

    @Test
    public void test6() throws IOException {
        File file = new File("hi.txt");
        if (!file.exists()) {
            file.createNewFile();
        } else {
            file.delete();
            System.out.println("delete");
        }
    }

    @Test
    public void test() {
        File file = new File("d:\\io\\io1");
        boolean mkdirs = file.mkdirs();
        System.out.println(mkdirs);
    }

    @Test
    public void test1() throws IOException {
        File file = new File("hello.txt");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("i have a dream\n");
        fileWriter.write("you need to have a dream");
        fileWriter.close();
    }

    @Test
    public void test2() {
        File file1 = new File("hello.txt");
        File file2 = new File("hello1.txt");

        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader(file1);
            fileWriter = new FileWriter(file2);
            //方式一
//            int data;
//            while((data = fileReader.read()) != -1){
//                fileWriter.write((char)data);
//            }
            //方式二
            char[] cbuf = new char[5];
            int len;
            while ((len = fileReader.read(cbuf)) != -1){
                fileWriter.write(cbuf,0,len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fileWriter!= null)
                    fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(fileReader != null)
                    fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
