package entities.adventurer.model;

import entities.coordinates.Coordinates;

import java.util.List;

public class Adventurer {

    private String name;
    private Coordinates coordinates;
    private AdventurerDirection adventurerDirection;
    private List<AdventurerMovement> movements;
    private int discoveredTreasures;

    public Adventurer(String name) {
        this.name = name;
    }

    public Adventurer(String name, Coordinates coordinates, AdventurerDirection adventurerDirection, List<AdventurerMovement> movements, int discoveredTreasures) {
        this.name = name;
        this.coordinates = coordinates;
        this.adventurerDirection = adventurerDirection;
        this.movements = movements;
        this.discoveredTreasures = discoveredTreasures;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
