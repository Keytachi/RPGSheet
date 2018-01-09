package com.company;

import com.company.Character.PlayerCharacter;

import java.util.ArrayList;

public class Game {
    SocketClient socketClient;
    PlayerCharacter player;
    ArrayList<PlayerCharacter> otherPlayers;
    public Game(){

    }

    public void setSocketClient(SocketClient sc){
        socketClient = sc;
    }
    public void messageFromServer(String msg){

    }
}
