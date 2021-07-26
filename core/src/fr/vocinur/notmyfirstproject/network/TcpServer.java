package fr.vocinur.notmyfirstproject.network;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.net.ServerSocket;
import com.badlogic.gdx.net.ServerSocketHints;
import com.badlogic.gdx.net.Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class TcpServer {
    public TcpServer() {

        new Thread(new Runnable(){

            @Override
            public void run() {

                ServerSocketHints serverSocketHint = new ServerSocketHints();
                serverSocketHint.acceptTimeout = 0;
                ServerSocket server = Gdx.net.newServerSocket(Net.Protocol.TCP, 51120, serverSocketHint);
                System.out.println("Connected !");

                // Loop forever
                while(true){
                    System.out.println("While");
                    // Create a socket
                    Socket socket = server.accept(null);
                    System.out.println(socket.getRemoteAddress());
                    // Read data from the socket into a BufferedReader

                    BufferedReader buffer = new BufferedReader(new InputStreamReader(socket.getInputStream(), Charset.defaultCharset()));

                    try {
                        // Read to the next newline (\n) and display that text on labelMessage
                        System.out.println("It will wait");
                        System.out.println(buffer.readLine()); // <-- :/
                        System.out.println("It has wait");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start(); // And, start the thread running
    }
}
