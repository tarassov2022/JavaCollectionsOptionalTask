import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class OptionalTaskItem7 {
    private static boolean isElementAnOpenBracket(char bracket) {
        return "({[".indexOf(bracket) != -1;
    }

    private static boolean isElementACloseBracket(char bracket) {
        return ")}]".indexOf(bracket) != -1;
    }

    private static boolean doBracketsMatchToEachOther(char open, char close) {
        return open == '(' && close == ')'
                || open == '{' && close == '}'
                || open == '[' && close == ']';
    }

    public static boolean isComparisonDoneWithPositiveResult(String stringToCompareBrackets) {
        Stack<Character> stack = new Stack<>();
        for (char charElementOfString : stringToCompareBrackets.toCharArray()) {
            if (isElementACloseBracket(charElementOfString) && stack.isEmpty()) {
                return false;
            }
            if (isElementAnOpenBracket(charElementOfString)) {
                stack.push(charElementOfString);
            }
            if (isElementACloseBracket(charElementOfString)) {
                if (doBracketsMatchToEachOther(stack.peek(), charElementOfString)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static void compareStringLinesInInputFile(String pathToInputFile) {
        try {
            Scanner scanner = new Scanner(new File(pathToInputFile));
            while (scanner.hasNextLine()) {
                String stringLineInInputFileToCompare = scanner.nextLine();
                if (isComparisonDoneWithPositiveResult(stringLineInInputFileToCompare)) {
                    System.out.println(stringLineInInputFileToCompare + " The position of brackets is correct!");
                } else {
                    System.out.println(stringLineInInputFileToCompare + " The position of brackets is wrong!");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String pathToInputFile = "C:/data/OptionalTaskCollections/src/Item7/In/OptionalTaskItem7Input.txt";
        compareStringLinesInInputFile(pathToInputFile);
    }
}
