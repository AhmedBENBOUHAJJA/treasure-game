package entities.map;

import entities.coordinates.Coordinates;

public abstract class MapService {
    public static Coordinates getMapDimensions(MapSize[][] map) {
        Coordinates coordinates = new Coordinates();
        coordinates.setOrdinatesAxis(map.length);
        coordinates.setAbscissasAxis(map[0].length);

        return coordinates;
    }
}
