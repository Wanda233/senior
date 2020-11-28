import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class TCPTest2 {
    @Test
    public void client() throws IOException {
        Socket socket = new Socket(InetAddress.getByName("192.168.0.120"),5656);
        OutputStream outputStream = socket.getOutputStream();
        FileInputStream fileInputStream = new FileInputStream(new File("beauty.jpg"));
        byte[] buff = new byte[1024];
        int len;
        while ((len = fileInputStream.read(buff))!=-1){
            outputStream.write(buff,0,len);
        }

        fileInputStream.close();
        outputStream.close();
        socket.close();

    }

    @Test
    public void server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(5656);
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream(new File("beauty1.jpg"));
        byte[] buff = new byte[1024];
        int len;
        while ((len = inputStream.read(buff))!=-1){
            fileOutputStream.write(buff,0,len);
        }
        fileOutputStream.close();
        inputStream.close();
        accept.close();
        serverSocket.close();

    }
}
