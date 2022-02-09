import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class OptionalTaskItem1 {
    private static void putDataInAndOutOfFile(String pathToInput, String pathToOutput) {
        Stack<String> stack = new Stack<>();
        try (Scanner scanner = new Scanner(new File(pathToInput));
             FileWriter fileWriter = new FileWriter(pathToOutput)) {
            while (scanner.hasNextLine()) {
               stack.push(scanner.nextLine());

            }
            while (!stack.isEmpty()) {
               fileWriter.write(stack.pop()+"\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String pathToInput = "C:/data/OptionalTaskCollections/src/Item1/in/OptionalTaskItemOneInput.txt";
        String pathToOutput = "C:/data/OptionalTaskCollections/src/Item1/out/OptionalTaskItemOneOutput.txt";
        putDataInAndOutOfFile(pathToInput, pathToOutput);
    }
}
