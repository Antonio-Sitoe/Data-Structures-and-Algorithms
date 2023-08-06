package exercices;

import java.util.ArrayList;

public class Contains {
    public static void main(String[] args) {
        int[] alotNumber = {45, 18, 72, 6, 90, 30, 84,2,3,4,2,2,2,4,14,59, 14, 59, 26, 73, 51, 68, 55, 87, 8, 45, 77, 2, 69, 61, 47, 95, 16, 76, 18, 43, 98, 2, 63, 67, 4, 57, 51, 85, 33, 53, 87, 20, 29, 58, 20, 47, 62, 62, 76, 96, 57, 34};
        ArrayList<Integer> arrlist = new ArrayList<Integer>(alotNumber[0]);

        for (int i : alotNumber) {
            if (!arrlist.contains(i)) {
                arrlist.add(i);
            }
        }
        System.out.println("array cleaned "+alotNumber.length);
        System.out.println("array cleaned "+ arrlist.size() + " " + arrlist );
    }
}
