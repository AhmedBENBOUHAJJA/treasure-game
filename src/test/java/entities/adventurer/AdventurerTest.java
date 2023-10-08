package entities.adventurer;

import entities.adventurer.model.Adventurer;
import entities.adventurer.service.AdventurerService;
import entities.exceptions.NoAdventurerFoundException;
import entities.line.Line;
import entities.line.LineType;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AdventurerTest {

    @Test
    public void should_return_one_adventurer() {
        //GIVEN
        Line line = new Line("A - Ahmed - 0 - 0 - N - AA", LineType.ADVENTURER);
        List<Line> lines = Collections.singletonList(line);
        //WHEN
        List<Adventurer> adventurers = AdventurerService.getAdventurersFromLines(lines);
        //THEN
        assertEquals(1, adventurers.size());
        assertEquals("Ahmed", adventurers.get(0).getName());
    }

    @Test
    public void should_return_two_adventurers()  {
        //GIVEN
        Line line1 = new Line("A - Ahmed - 0 - 0 - N - AA", LineType.ADVENTURER);
        Line line2 = new Line("A - Nicolas - 0 - 0 - N - AA", LineType.ADVENTURER);
        List<Line> lines = new ArrayList<>();
        lines.add(line1);
        lines.add(line2);
        //WHEN
        List<Adventurer> adventurers = AdventurerService.getAdventurersFromLines(lines);
        //THEN
        assertEquals(2, adventurers.size());
        assertEquals("Ahmed", adventurers.get(0).getName());
        assertEquals("Nicolas", adventurers.get(1).getName());
    }

    @Test
    public void should_throws_NoAdventurerFoundException() {
        assertThrows(NoAdventurerFoundException.class, () -> AdventurerService.getAdventurersFromLines(Collections.emptyList()));

    }
}
