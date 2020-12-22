import java.util.InputMismatchException;
import java.util.Scanner;

public class example_3 {
    private static Scanner in = new Scanner(System.in);
    private static int index = 0;
    private static int[] arr = new int[0];

    public static void main(String[] args) {
        System.out.println("Enter the number");
        System.out.println("If you want to stop typing, enter STOP");
        int[] arr1 = reqMethodInput(arr);
        reqMethodOutput(arr1);
    }

    public static int[] reqMethodOutput(int[] arr) {
        System.out.println(arr[index-arr.length]);
        index++;
        if (index/2 < arr.length){
            reqMethodOutput(arr);
        }
        return arr;
    }

    public static int[] reqMethodInput(int[] arr) {
        String numStr = in.nextLine();
        int num = 0;
        if (numStr.toUpperCase().equals("STOP")){
            return arr;
        } else {
            num = Integer.parseInt(numStr);
        }
        try {
            arr[index] = num;
        } catch (ArrayIndexOutOfBoundsException exception) {
            arr = copy(arr);
            arr[index] = num;
        }
        index++;
        return reqMethodInput(arr);
    }

    private static int[] copy(int[] arr) {
        int[] buffer = arr.clone();
        arr = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            if (buffer.length <= i) {
                return arr;
            }
            arr[i] = buffer[i];
        }
        return arr;
    }
}
