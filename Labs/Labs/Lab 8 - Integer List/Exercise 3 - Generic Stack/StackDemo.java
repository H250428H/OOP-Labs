public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer> numbers = new Stack<>();
        numbers.push(10);
        numbers.push(20);
        numbers.push(30);

        System.out.println("Stack: " + numbers + ", size " + numbers.size());
        System.out.println("peek -> " + numbers.peek());
        System.out.println("pop  -> " + numbers.pop());
        System.out.println("pop  -> " + numbers.pop());
        System.out.println("isEmpty? " + numbers.isEmpty());
        System.out.println("pop  -> " + numbers.pop());
        System.out.println("isEmpty? " + numbers.isEmpty());

        try {
            numbers.pop();
        } catch (IllegalStateException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        Stack<String> words = new Stack<>();
        for (String w : "to be or not to be".split(" ")) {
            words.push(w);
        }

        System.out.print("Words in reverse: ");
        while (!words.isEmpty()) {
            System.out.print(words.pop() + " ");
        }
        System.out.println();
    }
}
