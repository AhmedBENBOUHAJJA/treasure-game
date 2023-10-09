package entities.coordinates;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MapCoordinatesTest {

    @Test
    public void should_return_true_if_coordinates_in_map_limits() {
        Coordinates mapLimits = new Coordinates(1, 1);
        Coordinates coordinates = new Coordinates(0, 0);

        assertTrue(CoordinatesUtils.isCoordinatesInMapLimits(mapLimits, coordinates));
    }

    @Test
    public void should_return_false_if_coordinates_not_in_map_limits() {
        Coordinates mapLimits = new Coordinates(1, 1);
        Coordinates coordinates = new Coordinates(1, 0);

        assertFalse(CoordinatesUtils.isCoordinatesInMapLimits(mapLimits, coordinates));
    }
}
