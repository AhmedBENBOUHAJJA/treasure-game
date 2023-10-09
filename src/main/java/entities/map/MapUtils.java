package entities.map;

public abstract class MapUtils {
    public static boolean isAccessibleForAdventurer(MapSize mapSize) {
        return (!mapSize.isMountain() && mapSize.getAdventurer() == null);
    }
}
