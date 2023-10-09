package entities.adventurer.service;

import entities.adventurer.model.Adventurer;
import entities.adventurer.model.AdventurerDirection;
import entities.adventurer.model.AdventurerUtils;
import entities.coordinates.Coordinates;
import entities.coordinates.CoordinatesUtils;
import entities.map.MapService;
import entities.map.MapSize;
import entities.map.MapUtils;

public class AdventurerMovementsService {

    public static void moveAdventurerForward(MapSize[][] map, Adventurer adventurer) {
        Coordinates adventurerNextCoordinates = AdventurerUtils.getNextAdventurerCoordinates(adventurer);

        if (CoordinatesUtils.isCoordinatesInMapLimits(MapService.getMapDimensions(map), adventurerNextCoordinates)) {
            MapSize currentAdventurerCell = map[adventurer.getCoordinates().getOrdinatesAxis()][adventurer.getCoordinates().getAbscissasAxis()];
            MapSize nextAdventurerCell = map[adventurerNextCoordinates.getOrdinatesAxis()][adventurerNextCoordinates.getAbscissasAxis()];

            if (MapUtils.isAccessibleForAdventurer(nextAdventurerCell)) {
                currentAdventurerCell.setAdventurer(null);
                adventurer.setCoordinates(adventurerNextCoordinates);
                nextAdventurerCell.setAdventurer(adventurer);
                System.out.println(adventurer.getName() + " just moved forward one space");
                if (nextAdventurerCell.getTreasures() > 0) {
                    adventurer.setDiscoveredTreasures(adventurer.getDiscoveredTreasures() + 1);
                    nextAdventurerCell.setTreasures(nextAdventurerCell.getTreasures() - 1);
                    System.out.println(adventurer.getName() + " just found a new treasure. He has it now " + adventurer.getDiscoveredTreasures());
                }
            } else {
                System.out.println(adventurer.getName() + " wishes to advance to an inaccessible position. This movement is ignored ");
            }
        } else {
            System.out.println(" Impossible to move forward " + adventurer.getName() + ". If he advances further he will go outside the limits of the map. This movement is ignored.");
        }
    }

    public static void updateAdventurerDirectionToTheLeft(Adventurer adventurer) {
        switch (adventurer.getAdventurerDirection()) {
            case NORTH:
                System.out.println(adventurer.getName() + " look north. He turns left and now looks west");
                adventurer.setAdventurerDirection(AdventurerDirection.WEST);
                break;
            case SOUTH:
                System.out.println(adventurer.getName() + " look south. He turns left and now looks east");
                adventurer.setAdventurerDirection(AdventurerDirection.EAST);
                break;
            case EAST:
                System.out.println(adventurer.getName() + " look east. He turns left and now looks north");
                adventurer.setAdventurerDirection(AdventurerDirection.NORTH);
                break;
            case WEST:
                System.out.println(adventurer.getName() + " look west. He turns left and now looks south");
                adventurer.setAdventurerDirection(AdventurerDirection.SOUTH);
                break;
        }
    }

    public static void updateAdventurerDirectionToTheRight(Adventurer adventurer) {
        switch (adventurer.getAdventurerDirection()) {
            case NORTH:
                System.out.println(adventurer.getName() + " look north. He turns right and now looks east");
                adventurer.setAdventurerDirection(AdventurerDirection.EAST);
                break;
            case SOUTH:
                System.out.println(adventurer.getName() + " look south. He turns right and now looks west");
                adventurer.setAdventurerDirection(AdventurerDirection.WEST);
                break;
            case EAST:
                System.out.println(adventurer.getName() + " look east. He turns right and now looks south");
                adventurer.setAdventurerDirection(AdventurerDirection.SOUTH);
                break;
            case WEST:
                System.out.println(adventurer.getName() + " look west. He turns right and now looks north");
                adventurer.setAdventurerDirection(AdventurerDirection.NORTH);
                break;
        }
    }
}
