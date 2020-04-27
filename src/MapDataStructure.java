import javafx.util.Pair;
import java.awt.*;
import java.util.*;
import java.util.List;

public class MapDataStructure implements Iterable<Pair<Point, MapDataStructure.Item>>  {

    public static class Item {

        private final Land land;
        private final List<Character> characters;

        public Item(Land land) {
            this.land = land;
            this.characters = new ArrayList<>(0); // empty array list
        }

        public Land getLand() {
            return land;
        }

        public void addCharacter(Character character) {
            if(characters.size() < 5)
                characters.add(character);
            else {
                throw new ProgramException("there must be a maximum of 5 pieces in a cell");
            }
        }

        public void addCharacter(Character... characters) {
            for(Character character : characters)
                addCharacter(character);
        }

        public Character getCharacter(int index) {
            return characters.get(index);
        }

        public List<Character> getCharacters() {
            return characters;
        }

        public int getCharactersSize() {
            return characters.size();
        }
    }

    public MapDataStructure(Item[][] matrix) {
        this.matrix = matrix;
    }

    private Item[][] matrix;

    public Item get(int x, int y) {
        return matrix[x][y];
    }

    public void set(int x, int y, Item item) {
        matrix[x][y] = item;
    }

    @Override
    public Iterator<Pair<Point,Item>> iterator() {
        return new Iterator<>() {
            private final Item[][] _matrix = matrix;
            private int currentRow = 0;
            private int currentColumn = 0;

            @Override
            public boolean hasNext() {
                if (currentRow + 1 == _matrix.length) {
                    return currentColumn < _matrix[currentRow].length;
                }
                return currentRow < _matrix.length;
            }

            @Override
            public Pair<Point,Item> next() {
                if (currentColumn == _matrix[currentRow].length) {
                    currentColumn = 0;
                    currentRow++;
                }
                if (currentRow == _matrix.length -1 && currentColumn == _matrix[currentRow].length - 1) {
                    throw new NoSuchElementException();
                }
                return new Pair<>(new Point(currentRow,currentColumn), _matrix[currentRow][currentColumn++]);
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(Item[] items : matrix){
            for(Item item : items) {
                stringBuilder.append(item.land.toString().charAt(0));
            }
            stringBuilder.append('\n');
        }

        return stringBuilder.toString();
    }
}
