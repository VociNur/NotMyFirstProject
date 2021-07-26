package fr.vocinur.notmyfirstproject.network;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.net.Socket;
import com.badlogic.gdx.net.SocketHints;

import java.nio.charset.Charset;


public class TcpClient {
    public TcpClient() {
        try{
            SocketHints socketHint = new SocketHints();
            socketHint.connectTimeout = 4000;
            Socket socket = Gdx.net.newClientSocket(Net.Protocol.TCP, "localhost", 51120, socketHint);
            System.out.println("Connected client !" + socket.isConnected());
            socket.getOutputStream().write("hqsdjklgfrsd".getBytes(Charset.defaultCharset()));
            System.out.println("Test write");
        }catch (Exception e){
            System.out.println("Erreure de connection: " + e.getMessage());
        }
    }


}
