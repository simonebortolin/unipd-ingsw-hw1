public class Orge extends Character {
    public Orge() {
        EnhancementsDataStructure attack = new EnhancementsDataStructure.Builder(4).setEnhancements(Daytime.DAY, -50).setEnhancements(Daytime.NIGHT, +50).build();
        EnhancementsDataStructure defence = new EnhancementsDataStructure.Builder(4).setEnhancements(Daytime.DAY, -50).setEnhancements(Daytime.NIGHT, +50).build();
    }
}
