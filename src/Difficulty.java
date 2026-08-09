public enum Difficulty {
        EASY("Easy"),
        MEDIUM("Medium"),
        HARD("Hard");

        private String displayName;

        Difficulty(String displayName) {
                this.displayName = displayName;
        }

        @Override
        public String toString(){
                return displayName;
        }
}
