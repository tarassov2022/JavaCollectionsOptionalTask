import java.util.Scanner;
import java.util.Stack;

public class OptionalTaskItem2 {
    static Stack<Integer> stack = new Stack<>();

    private static boolean isNumber(String typeNumber) {
        return typeNumber.matches("\\d+");
    }

    private static void inputDataThroughConsole() {
        String typeNumber;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number (integer): ");
        while (true) {
            typeNumber = scanner.nextLine();
            if (isNumber(typeNumber)) {
                for (int j = 0; j < typeNumber.length(); j++) {
                    stack.push(Integer.parseInt(String.valueOf(typeNumber.charAt(j))));
                }
                return;
            }
            System.out.println("Not an integer number, enter the integer number: ");
        }
    }

    private static void outputDataToConsole() {
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }

    public static void main(String[] args) {
        inputDataThroughConsole();
        outputDataToConsole();
    }
}
