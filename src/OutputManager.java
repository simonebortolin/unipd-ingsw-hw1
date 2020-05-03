import javafx.util.Pair;

import java.awt.Point;
import java.util.ArrayList;

public class OutputManager {

    /**
     * get number of pieces of type
     * @param mapDataStructure the map
     * @param theClass the type
     * @return the number of pices
     */
    public static int getNumberOfPices(MapDataStructure mapDataStructure, Class theClass) {
        if(theClass.getSuperclass().equals(Character.class)) {
            int count = 0;
            for (Pair<Point, MapDataStructure.Item> pair : mapDataStructure) {
                count += pair.getValue().getCharacters().stream().filter(n -> n.getClass().equals(theClass)).count();

            }
            return count;
        }
        throw new ProgramException("theClass is not valid");
    }

    /**
     * get maximum defende value
     * @param mapDataStructure the map
     * @param daytime the daytime
     * @return the maximum value
     */
    public static Point[] getMaximumDefendeValue(MapDataStructure mapDataStructure, Daytime daytime) {
        if(mapDataStructure.isEmpty()) return new Point[]{};

        int max = mapDataStructure.stream().mapToInt(i -> i.getValue().getCharacters().stream().mapToInt(t -> t.getDefence(i.getValue().getLand(), daytime)).reduce(0, Integer::sum)).max().getAsInt();

        return mapDataStructure.stream().filter(i -> i.getValue().getCharacters().stream().mapToInt(t -> t.getDefence(i.getValue().getLand(), daytime)).reduce(0, Integer::sum) == max).map(i -> i.getKey()).toArray(Point[]::new);
    }

    /**
     * get maximum attack value
     * @param mapDataStructure the map
     * @param daytime the daytime
     * @return the attack value
     */
    public static Point[] getMaximumAttackValue(MapDataStructure mapDataStructure, Daytime daytime) {
        if(mapDataStructure.isEmpty()) return new Point[]{};

        int max = mapDataStructure.stream().mapToInt(i -> i.getValue().getCharacters().stream().mapToInt(t -> t.getAttack(i.getValue().getLand(), daytime)).reduce(0, Integer::sum)).max().getAsInt();

        return mapDataStructure.stream().filter(i -> i.getValue().getCharacters().stream().mapToInt(t -> t.getAttack(i.getValue().getLand(), daytime)).reduce(0, Integer::sum) == max).map(Pair::getKey).toArray(Point[]::new);
    }

    /**
     * get the cell that holds the most elements of the same type
     * @param mapDataStructure the map
     * @param theClass type of item
     * @return the cell that holds the most elements of the same type
     */
    public static Point[] getMaximumCellOfType(MapDataStructure mapDataStructure, Class theClass) {
        if(mapDataStructure.isEmpty()) return new Point[]{};

        if(theClass.getSuperclass().equals(Character.class)) {
            long max = mapDataStructure.stream().mapToLong(i -> i.getValue().getCharacters().stream().filter(j -> j.getClass().equals(theClass)).count()).max().getAsLong();

            return mapDataStructure.stream().filter(i -> i.getValue().getCharacters().stream().filter(j -> j.getClass().equals(theClass)).count() == max).map(Pair::getKey).toArray(Point[]::new);
        }
        throw new ProgramException("theClass is not valid");
    }
}
