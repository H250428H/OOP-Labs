public class AgeValidator {

    private static final int MIN_AGE = 0;
    private static final int MAX_AGE = 120;

    static void validateAge(int age) throws InvalidAgeException {
        if (age < MIN_AGE || age > MAX_AGE) {
            throw new InvalidAgeException(age);
        }
        System.out.println("Age " + age + " is valid");
    }

    public static void main(String[] args) {
        int[] tests = {25, 0, 120, -5, 121, 200};

        for (int age : tests) {
            try {
                validateAge(age);
            } catch (InvalidAgeException e) {
                System.out.println("Rejected: " + e.getMessage());
            }
        }

    }
}
