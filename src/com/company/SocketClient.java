package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {

    String host;
    int port;
    Socket socket;
    Game game;
    public SocketClient(Game game, String host, int port){
        this.host = host;
        this.port = port;
        this.game = game;

    }


    public void connectToServer(){
        try {
            Socket sock = new Socket(host, port);
            socket = sock;
            game.setSocketClient(this);
            new Thread(){
                public void run(){
                    handleConnection();
                }
            }.start();
        }
        catch (IOException e){
            System.out.println("Error Connecting to Socket: "+e);
        }
    }

    public void handleConnection(){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter bw = new PrintWriter(socket.getOutputStream(), true);
            //bw.println("lawl");
            String inputLine;
            while ((inputLine = br.readLine()) != null){
                handleMessage(inputLine);

            }
        }
        catch (IOException e){
            System.out.println("Error communicating with server");
        }
    }
    public void handleMessage(String msg){
        System.out.println("Recieved: "+msg);
        game.messageFromServer(msg);
    }
    public void sendMessage(String msg){
        if (socket == null){
            System.out.println("No connection exists");
            return;
        }
        try {
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println(msg);
        }
        catch (IOException e){
            System.out.println("Failed to send message: "+e);
        }

    }

}
