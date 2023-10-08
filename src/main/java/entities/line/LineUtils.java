package entities.line;

import entities.adventurer.model.Adventurer;
import entities.adventurer.model.AdventurerMovement;
import entities.adventurer.model.AdventurerUtils;
import entities.coordinates.Coordinates;
import entities.exceptions.NoDirectionFoundException;
import entities.exceptions.UnexpectedMovementException;

import java.util.ArrayList;
import java.util.List;

public class LineUtils {

    private static final String splitOn = " - ";

    public static boolean isLineAdventurerType(Line line) {
        return line.getLineType().equals(LineType.ADVENTURER);
    }

    public static Coordinates getAdventurerCoordinatesFromLine(String line) {
        String[] split = line.split(splitOn);
        return new Coordinates(Integer.parseInt(split[3]), Integer.parseInt(split[2]));
    }

    public static Adventurer getAdventurerFromLine(Line line) throws NoDirectionFoundException, UnexpectedMovementException {
        String[] split = line.getLine().split(splitOn);

        List<AdventurerMovement> movements = new ArrayList<>();

        for (char c : split[5].toCharArray()) {
            movements.add(new AdventurerMovement(AdventurerUtils.getAdventurerActionFromChar(c), false));
        }

        Coordinates adventurerCoordinates = LineUtils.getAdventurerCoordinatesFromLine(line.getLine());

        return new Adventurer(
                split[1],
                adventurerCoordinates,
                AdventurerUtils.getAdventurerDirectionFromString(split[4]),
                movements,
                0
        );
    }

}
