package entities.map;

import entities.adventurer.model.Adventurer;

public class MapSize {
    private int posX;
    private int posY;
    private Boolean isMountain;
    private Adventurer adventurer;

    public MapSize() {
    }

    public MapSize(int posX, int posY, Boolean isMountain, Adventurer adventurer) {
        this.posX = posX;
        this.posY = posY;
        this.isMountain = isMountain;
        this.adventurer = adventurer;
    }

    public MapSize(int x, int y) {
        this.posX = x;
        this.posY = y;
        this.isMountain = false;
    }


    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public Boolean isMountain() {
        return isMountain;
    }

    public void setMountain(Boolean mountain) {
        isMountain = mountain;
    }

    public Adventurer getAdventurer() {
        return adventurer;
    }

    public void setAdventurer(Adventurer adventurer) {
        this.adventurer = adventurer;
    }
}
