package top.treegrowth.nio.channel.socketchannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author wusi
 * @version 2017/2/25 10:21.
 */
public class SocketConnectServer {

    public static final String GREETING = "Hello I must be going.\r\n";

    public static void main(String[] args) throws IOException, InterruptedException {

        //初始化一些返回给客户端的数据
        ByteBuffer buffer = ByteBuffer.wrap(GREETING.getBytes());

        int port = 4567;
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.socket().bind(new InetSocketAddress(port));
        ssc.configureBlocking(false);

        while (true) {
            System.out.println("Waiting for connections");

            SocketChannel sc = ssc.accept();

            if (sc == null) {
                // 如果没有连接的话等待一会儿
                Thread.sleep(2000);
            } else {
                System.out.println("Incoming connection from: " + sc.socket().getRemoteSocketAddress());

                buffer.rewind();
                sc.write(buffer);
                sc.close();
            }
        }
    }
}
