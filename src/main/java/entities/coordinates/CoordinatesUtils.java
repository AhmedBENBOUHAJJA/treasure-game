package entities.coordinates;

public abstract class CoordinatesUtils {
    public static boolean isCoordinatesInMapLimits(Coordinates mapLimits, Coordinates adventurerNextCoordinates) {
        return (
                mapLimits.getOrdinatesAxis() > adventurerNextCoordinates.getOrdinatesAxis() &&
                        mapLimits.getAbscissasAxis() > adventurerNextCoordinates.getAbscissasAxis() &&
                        adventurerNextCoordinates.getOrdinatesAxis() >= 0 &&
                        adventurerNextCoordinates.getAbscissasAxis() >= 0
        );
    }
}
