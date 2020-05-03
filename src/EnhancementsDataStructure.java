public class EnhancementsDataStructure {

    private EnhancementsDataStructure(Builder builder) {
        this.value = builder._value;
        this.matrix = builder._matrix;
    }

    public EnhancementsDataStructure(int value) {
        this.value = value;
        this.matrix = new int[3][2];
    }

    public static class Builder {

        public Builder(int value) {
            this._value = value;
        }
        private final int _value;
        private final int[][] _matrix = new int[3][2];

        public Builder setEnhancements(Land land, Daytime daytime, int value) {
            _matrix[land.ordinal()][daytime.ordinal()] = value;

            return this;
        }

        public Builder setEnhancements(Land land, int value) {
            for (int i = 0; i < _matrix[0].length; i++) {
                _matrix[land.ordinal()][i] = value;
            }
            return this;
        }

        public Builder setEnhancements(Daytime daytime, int value) {
            for (int i = 0; i < _matrix.length; i++) {
                _matrix[i][daytime.ordinal()] = value;
            }
            return this;
        }

        public EnhancementsDataStructure build() {
            return new EnhancementsDataStructure(this);
        }

    }

    private final int value;
    private final int[][] matrix;

    /**
     * get the boosting
     * @param land the land
     * @param daytime the daytime
     * @returnthe boosting
     */
    public int getEnhancements(Land land, Daytime daytime) {
        return matrix[land.ordinal()][daytime.ordinal()];
    }

    /**
     * get value without reinforcements
     * @return the value without reinforcements
     */
    public int get() {
        return value;
    }

    /**
     * get value with boosting
     * @param land the land
     * @param daytime the daytime
     * @return the value with boosting
     */
    public int get(Land land, Daytime daytime) {
        return value + value * getEnhancements(land, daytime) / 100;
    }
}
