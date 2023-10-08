package entities.adventurer.service;

import entities.adventurer.model.Adventurer;
import entities.exceptions.NoAdventurerFoundException;
import entities.exceptions.ProgramException;
import entities.line.Line;
import entities.line.LineUtils;

import java.util.ArrayList;
import java.util.List;

public abstract class AdventurerService {

    public static List<Adventurer> getAdventurersFromLines(List<Line> lines) throws ProgramException {
        List<Adventurer> adventurers = new ArrayList<>();

        for (Line line : lines) {
            if (LineUtils.isLineAdventurerType(line)) {
                Adventurer adventurer = LineUtils.getAdventurerFromLine(line);
                adventurers.add(adventurer);
            }
        }

        if (adventurers.isEmpty()) {
            throw new NoAdventurerFoundException("Aucun aventurier n'a été trouvé dans le fichier donné. Impossible de lancer le programme !");
        } else {
            return adventurers;
        }
    }
}
