public enum Status {
    NOT_STARTED ("Not Started"),
    ATTEMPTED(" Attempted"),
    SOLVED("Solved"),
    NEED_REVISION("Need Revision");

    private String displayName;

    Status(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
