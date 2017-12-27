package com.company;

//TODO: When making the board game, come back to this.
public abstract class Entity {

    private enum Size{
        TINY(2.5,2.5),
        SMALL(5,5),
        MEDIUM(5,5),
        LARGE(10,10),
        HUGE(15,15),
        GARGANTUAN(20,20);

        private Size(double width, double length){
            block_Width = width;
            block_Length = length;
        }

        final double getWidth(){
            return block_Width;
        }

        final double getLength(){
            return block_Length;
        }

        private final double block_Width;
        private final double block_Length;
    }

    public Entity() {

    }

}
