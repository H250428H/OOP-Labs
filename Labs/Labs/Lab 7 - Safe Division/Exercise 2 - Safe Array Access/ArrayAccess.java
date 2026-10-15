public class ArrayAccess {

    static int getOrDefault(int[] data, int index, int fallback) {
        try {
            return data[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("  Caught: " + e.getMessage());
            return fallback;
        }
    }

    public static void main(String[] args) {
        int[] marks = {70, 85, 90, 60, 75};
        int[] indexes = {2, 7, -1};

        for (int index : indexes) {
            int value = getOrDefault(marks, index, -1);
            System.out.println("marks[" + index + "] -> " + value);
        }
    }
}
