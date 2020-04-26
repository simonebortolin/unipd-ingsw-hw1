public class Dwarf extends Character {
    public Dwarf() {
        defence = new EnhancementsDataStructure(5);
        attack = new EnhancementsDataStructure.Builder(2).setEnhancements(Land.FOREST, 100).build();
    }
}
