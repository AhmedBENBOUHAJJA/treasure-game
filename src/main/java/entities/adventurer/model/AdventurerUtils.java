package entities.adventurer.model;

import entities.coordinates.Coordinates;
import entities.exceptions.NoDirectionFoundException;
import entities.exceptions.UnexpectedMovementException;

public class AdventurerUtils {

    public static AdventurerDirection getAdventurerDirectionFromString(String s) throws NoDirectionFoundException {
        switch (s) {
            case "N":
                return AdventurerDirection.NORTH;
            case "S":
                return AdventurerDirection.SOUTH;
            case "E":
                return AdventurerDirection.EAST;
            case "O":
                return AdventurerDirection.WEST;
        }
        throw new NoDirectionFoundException("Impossible to define the direction of an adventurer!");
    }

    public static AdventurerAction getAdventurerActionFromChar(char c) throws UnexpectedMovementException {
        switch (c) {
            case 'A':
                return AdventurerAction.MOVE_FORWARD;
            case 'G':
                return AdventurerAction.MOVE_LEFT;
            case 'D':
                return AdventurerAction.MOVE_RIGHT;
        }
        throw new UnexpectedMovementException("An adventurer's movement is not correctly recorded.");
    }

    public static Coordinates getNextAdventurerCoordinates(Adventurer adventurer) {
        Coordinates nextCoordinates = new Coordinates();
        Coordinates adventurerCoordinates = adventurer.getCoordinates();
        switch (adventurer.getAdventurerDirection()) {
            case NORTH:
                nextCoordinates.setOrdinatesAxis(adventurerCoordinates.getOrdinatesAxis() - 1);
                nextCoordinates.setAbscissasAxis(adventurerCoordinates.getAbscissasAxis());
                break;
            case SOUTH:
                nextCoordinates.setOrdinatesAxis(adventurerCoordinates.getOrdinatesAxis() + 1);
                nextCoordinates.setAbscissasAxis(adventurerCoordinates.getAbscissasAxis());
                break;
            case EAST:
                nextCoordinates.setOrdinatesAxis(adventurerCoordinates.getOrdinatesAxis());
                nextCoordinates.setAbscissasAxis(adventurerCoordinates.getAbscissasAxis() + 1);
                break;
            case WEST:
                nextCoordinates.setOrdinatesAxis(adventurerCoordinates.getOrdinatesAxis());
                nextCoordinates.setAbscissasAxis(adventurerCoordinates.getAbscissasAxis() - 1);
                break;
        }
        return nextCoordinates;
    }

}
