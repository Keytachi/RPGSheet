package com.company;

import com.company.ClassType.Barbarian;
import com.company.IO.IO;
import com.company.RaceType.Elf;
import com.company.RaceType.Human;
import com.company.RaceType.Race;

public class Main {

    public static void main(String[] args) {
        Race player1 = new Human("Brandon", new Barbarian());
        
        System.out.println(player1.getMaximum_Health());
    }
}
