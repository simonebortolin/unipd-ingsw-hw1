public abstract class Character {
    EnhancementsDataStructure attack;
    EnhancementsDataStructure defence;

    public int getAttack() {
        return attack.get();
    }

    public int getAttack(Land land, Daytime daytime) {
        return attack.get(land, daytime);
    }

    public int getDefence() {
        return defence.get();
    }

    public int getDefence(Land land, Daytime daytime) {
        return defence.get(land, daytime);
    }
}
