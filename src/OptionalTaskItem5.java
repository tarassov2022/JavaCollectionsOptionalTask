import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OptionalTaskItem5 {
    private static final int NUMBERS = 12;
    private static final int BOUNDS = 100;
    
    static List<Integer> getListOfRandomIntegers(int numberOfIntegers, int boundOfIntegers) {
        Random random = new Random();
        List<Integer> list=new ArrayList<>(numberOfIntegers);
        for (int i = 0; i < numberOfIntegers; i++) {
            int element = random.nextInt(2*boundOfIntegers+1)  - boundOfIntegers;
            list.add(element);
        }

      return list;
    }

    static List<Integer> moveNegativesToEndList(List<Integer> list) {
        int i = 0;
        int index = 0;

        while (i < list.size() - index) {
            if (list.get(i) < 0) {
                list.add(list.get(i));
                list.remove(list.get(i));
                index++;
            } else {
                i++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> randomList=getListOfRandomIntegers(NUMBERS, BOUNDS);
        System.out.println("\nThe list of random integers: ");
        System.out.println(randomList);
        System.out.println("\nNegatives move to the end of the list: ");
        System.out.println(moveNegativesToEndList(randomList));
    }
}
