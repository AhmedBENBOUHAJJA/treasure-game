package entities.adventurer;

import entities.adventurer.model.AdventurerAction;
import entities.adventurer.model.AdventurerDirection;
import entities.adventurer.model.AdventurerUtils;
import entities.exceptions.NoDirectionFoundException;
import entities.exceptions.UnexpectedMovementException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AdventurerActionsTest {

    @Test
    public void should_return_adventurer_action() throws UnexpectedMovementException {
        assertEquals(AdventurerAction.MOVE_FORWARD, AdventurerUtils.getAdventurerActionFromChar('A'));
        assertEquals(AdventurerAction.MOVE_RIGHT, AdventurerUtils.getAdventurerActionFromChar('D'));
        assertEquals(AdventurerAction.MOVE_LEFT, AdventurerUtils.getAdventurerActionFromChar('G'));
    }

    @Test
    public void should_throws_UnexpectedMovementEsxception() {
        assertThrows(UnexpectedMovementException.class, () -> AdventurerUtils.getAdventurerActionFromChar('Z'));
    }

    @Test
    public void should_return_adventurer_direction() throws NoDirectionFoundException {
        assertEquals(AdventurerDirection.NORTH, AdventurerUtils.getAdventurerDirectionFromString("N"));
        assertEquals(AdventurerDirection.SOUTH, AdventurerUtils.getAdventurerDirectionFromString("S"));
        assertEquals(AdventurerDirection.EAST, AdventurerUtils.getAdventurerDirectionFromString("E"));
        assertEquals(AdventurerDirection.WEST, AdventurerUtils.getAdventurerDirectionFromString("O"));
    }

    @Test
    public void should_throws_NoDirectionFoundException() {
        assertThrows(NoDirectionFoundException.class, () -> AdventurerUtils.getAdventurerDirectionFromString("Z"));
    }

}
