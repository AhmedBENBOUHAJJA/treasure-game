package entities.adventurer.model;

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

}
