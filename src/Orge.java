public class Orge extends Character {
    public Orge() {
        attack = new EnhancementsDataStructure.Builder(4).setEnhancements(Daytime.DAY, -50).setEnhancements(Daytime.NIGHT, +50).build();
        defence = new EnhancementsDataStructure.Builder(4).setEnhancements(Daytime.DAY, -50).setEnhancements(Daytime.NIGHT, +50).build();
    }
}
