public class Elf extends Character {
    public Elf() {
        attack = new EnhancementsDataStructure(5);
        defence = new EnhancementsDataStructure.Builder(2)
                .setEnhancements(Land.FOREST, 100).build();
    }
}
