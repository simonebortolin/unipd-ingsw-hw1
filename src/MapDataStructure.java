import java.util.ArrayList;

public class MapDataStructure {
    public class Item {

        public class Builder {
            private Land _land;
            private ArrayList<Character> _characters = new ArrayList<>(5);

            public Builder(Land _land) {
                this._land = _land;
            }

            public Builder addCharacter(Character character) {
                if(_characters.size() < 5)
                _characters.add(character);
                else {
                    throw new ProgramException("there must be a maximum of 5 pieces in a cell");
                }
                return this;
            }

            public Builder addCharacter(Character... characters) {
                for(Character character : characters)
                    addCharacter(character);
                return this;
            }

            public Item build() {
                return new Item(this);
            }
        }

        private final Land land;
        private final ArrayList<Character> characters;

        public Item(Land land) {
            this.land = land;
            this.characters = new ArrayList<>(0); // empty array list
        }

        private Item(Builder builder) {
            this.land = builder._land;
            this.characters = builder._characters;
        }

        public Land getLand() {
            return land;
        }

        public Character getCharacter(int index) {
            return characters.get(index);
        }
    }

    private Item[][] matrix;

    public Item get(int x, int y) {
        return matrix[x][y];
    }

    public void set(int x, int y, Item item) {
        matrix[x][y] = item;
    }
}
