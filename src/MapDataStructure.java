import javafx.util.Pair;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class MapDataStructure implements Iterable<Pair<Point, MapDataStructure.Item>> {

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

        private void addCharacter(Character character) {
            if (characters.size() < 5)
                characters.add(character);
            else {
                System.err.println("An error has occurred: there must be a maximum of 5 pieces in a cell");
            }
        }

        public void addCharacters(Character... characters) {
            for (Character character : characters)
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
        try {
            return matrix[x][y];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ProgramException(e);
        }
    }

    public void set(int x, int y, Item item) {
        try {
            matrix[x][y] = item;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("An error has occurred: " + e.getLocalizedMessage());
        }
    }

    public void addCharacters(int x, int y, Character... characters) {
        try {
            matrix[x][y].addCharacters(characters);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("An error has occurred: " + e.getLocalizedMessage());
        }
    }

    @Override
    public Iterator<Pair<Point, Item>> iterator() {
        return new Iterator<>() {
            private final Item[][] _matrix = matrix;
            private int currentRow = 0;
            private int currentColumn = 0;

            @Override
            public boolean hasNext() {
                if (currentRow == _matrix.length - 1) {
                    return currentColumn < _matrix[currentRow].length;
                }
                return currentRow < _matrix.length;
            }

            @Override
            public Pair<Point, Item> next() {
                if (currentColumn == _matrix[currentRow].length) {
                    currentColumn = 0;
                    currentRow++;
                }
                if (currentRow >= _matrix.length) {
                    throw new NoSuchElementException();
                }
                return new Pair<>(new Point(currentRow, currentColumn), _matrix[currentRow][currentColumn++]);
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Item[] items : matrix) {
            for (Item item : items) {
                stringBuilder.append(item.land.toString());
                stringBuilder.append(':');
                stringBuilder.append(item.getCharactersSize());
                stringBuilder.append(' ');
            }
            stringBuilder.append('\n');
        }

        return stringBuilder.toString();
    }

    public Stream<Pair<Point, Item>> stream() {
        Spliterator<Pair<Point, Item>> spliterator = Spliterators.spliteratorUnknownSize(iterator(), 0);
        return StreamSupport.stream(spliterator, false);
    }
}
