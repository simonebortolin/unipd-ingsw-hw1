public abstract class Character {
    EnhancementsDataStructure attack;
    EnhancementsDataStructure defence;

    /**
     * get attack without reinforcements
     * @return the attack without reinforcements
     */
    public int getAttack() {
        return attack.get();
    }

    /**
     * get defence with boosting
     * @param land the land
     * @param daytime the daytime
     * @return the defence with boosting
     */
    public int getAttack(Land land, Daytime daytime) {
        return attack.get(land, daytime);
    }

    /**
     * get defence without reinforcements
     * @return the defence without reinforcements
     */
    public int getDefence() {
        return defence.get();
    }

    /**
     * get defence with boosting
     * @param land the land
     * @param daytime the daytime
     * @return the defence with boosting
     */
    public int getDefence(Land land, Daytime daytime) {
        return defence.get(land, daytime);
    }
}
