package entities.adventurer;

import entities.adventurer.model.Adventurer;
import entities.adventurer.model.AdventurerDirection;
import entities.adventurer.service.AdventurerMovementsService;
import entities.coordinates.Coordinates;

import entities.map.MapSize;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdventurerMovementsTest {

    @Test
    public void should_move_forward_adventurer() {
        Coordinates fakeMapDimensions = new Coordinates(2, 2);
        MapSize[][] fakeMap = new MapSize[2][2];

        for (int i = 0; i < fakeMapDimensions.getOrdinatesAxis(); i++) {
            for (int j = 0; j < fakeMapDimensions.getAbscissasAxis(); j++) {
                fakeMap[i][j]  = new MapSize();
                fakeMap[i][j].setPosX(i);
                fakeMap[i][j].setPosY(j);
            }
        }

        Adventurer adventurer = new Adventurer();
        adventurer.setAdventurerDirection(AdventurerDirection.NORTH);
        adventurer.setCoordinates(new Coordinates(1,1));
        fakeMap[1][1].setAdventurer(adventurer);
        AdventurerMovementsService.moveAdventurerForward(fakeMap, adventurer);

        assertEquals(adventurer, fakeMap[0][1].getAdventurer());
    }

    @Test
    public void should_not_move_forward_adventurer_cause_map_size() {

        Coordinates fakeMapDimensions = new Coordinates(2, 2);
        MapSize[][] fakeMap = new MapSize[2][2];

        for (int i = 0; i < fakeMapDimensions.getOrdinatesAxis(); i++) {
            for (int j = 0; j < fakeMapDimensions.getAbscissasAxis(); j++) {
                fakeMap[i][j] = new MapSize();
                fakeMap[i][j].setPosX(i);
                fakeMap[i][j].setPosY(j);
            }
        }

        Adventurer adventurer = new Adventurer();
        adventurer.setAdventurerDirection(AdventurerDirection.NORTH);
        adventurer.setCoordinates(new Coordinates(0,0));
        fakeMap[0][0].setAdventurer(adventurer);
        AdventurerMovementsService.moveAdventurerForward(fakeMap, adventurer);

        assertEquals(adventurer, fakeMap[0][0].getAdventurer());
    }

    @Test
    public void should_not_move_forward_adventurer_cause_mountain() {

        Coordinates fakeMapDimensions = new Coordinates(2, 2);
        MapSize[][] fakeMap = new MapSize[2][2];

        for (int i = 0; i < fakeMapDimensions.getOrdinatesAxis(); i++) {
            for (int j = 0; j < fakeMapDimensions.getAbscissasAxis(); j++) {
                fakeMap[i][j] = new MapSize();
                fakeMap[i][j].setPosX(i);
                fakeMap[i][j].setPosY(j);
            }
        }

        Adventurer adventurer = new Adventurer();
        adventurer.setAdventurerDirection(AdventurerDirection.NORTH);
        adventurer.setCoordinates(new Coordinates(1,1));
        fakeMap[1][1].setAdventurer(adventurer);
        fakeMap[0][1].setMountain(true);
        AdventurerMovementsService.moveAdventurerForward(fakeMap, adventurer);

        assertEquals(adventurer, fakeMap[1][1].getAdventurer());

    }

    @Test
    public void should_update_direction_to_the_left() {
        Adventurer adventurer = new Adventurer();
        adventurer.setAdventurerDirection(AdventurerDirection.NORTH);
        AdventurerMovementsService.updateAdventurerDirectionToTheLeft(adventurer);

        assertEquals(AdventurerDirection.WEST, adventurer.getAdventurerDirection());
    }

    @Test
    public void should_update_direction_to_the_right() {
        Adventurer adventurer = new Adventurer();
        adventurer.setAdventurerDirection(AdventurerDirection.NORTH);
        AdventurerMovementsService.updateAdventurerDirectionToTheRight(adventurer);

        assertEquals(AdventurerDirection.EAST, adventurer.getAdventurerDirection());
    }
}
