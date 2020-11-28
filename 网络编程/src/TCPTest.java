import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPTest {
    @Test
    public void client(){
        Socket socket = null;
        OutputStream outputStream = null;
        try {
            socket = new Socket(InetAddress.getByName("192.168.0.120"),8836);
            outputStream = socket.getOutputStream();
            outputStream.write("你好，我是客户端徐曹军".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }




    }

    @Test
    public void server() {
        ServerSocket serverSocket = null;
        Socket accept = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        try {
                serverSocket = new ServerSocket(8836);
                accept = serverSocket.accept();
                inputStream = accept.getInputStream();

                inputStreamReader = new InputStreamReader(inputStream);
                char[] buff = new char[5];
                int len;
                String ss = "";
                while ((len = inputStreamReader.read(buff))!=-1){
                    String s = new String(buff,0,len);
                    ss = ss + s;
                }
                System.out.println(ss);


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(inputStreamReader!=null){
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(accept!=null){
                try {
                    accept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(serverSocket!=null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }

}
