package entities.map;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MapSizeTest {

    @Test
    public void should_return_size() {
        MapSize[][] map = new MapSize[2][2];
        assertEquals(2, MapService.getMapDimensions(map).getAbscissasAxis());
        assertEquals(2, MapService.getMapDimensions(map).getOrdinatesAxis());
    }


}
