import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.WriteAbortedException;

public class RandomAccessFileTest {
    @Test
    public void test() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("hello.txt","rw");

        randomAccessFile.seek(3);
        randomAccessFile.write("xyz".getBytes());
        randomAccessFile.close();
    }

    @Test
    public void test2() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("hello.txt","rw");
        randomAccessFile.seek(3);

        StringBuilder builder = new StringBuilder((int) new File("hello.txt").length());
        byte[] buffer = new byte[20];
        int len;
        while((len = randomAccessFile.read(buffer)) != -1){
            builder.append(new String(buffer,0,len)) ;
        }
        randomAccessFile.seek(3);
        randomAccessFile.write("xyz".getBytes());
        randomAccessFile.write(builder.toString().getBytes());
        randomAccessFile.close();

    }
}
