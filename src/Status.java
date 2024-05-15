public enum Status {

    GAME_OVER("3S 0B"),
    OUT("OUT");

    private final String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
