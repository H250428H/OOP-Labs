enum Level {
    LOW, MEDIUM, HIGH
}

public class LevelEnumDemo {
    static String advice(Level level) {
        return switch (level) {
            case LOW -> "Keep monitoring.";
            case MEDIUM -> "Prepare a response.";
            case HIGH -> "Act immediately.";
        };
    }

    public static void main(String[] args) {
        for (Level level : Level.values()) System.out.println(level + ": " + advice(level));
    }
}
