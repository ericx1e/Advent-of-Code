package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bathroom {
    static int[][] keypad = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("src/Day2/input.txt"));
        String result = "";

        while(in.hasNext()) {
            int r = 1;
            int c = 1;
            String line = in.nextLine();
            for (int i = 0; i < line.length(); i++) {
                char cur = line.charAt(i);
                switch (cur) {
                    case 'U' -> r--;
                    case 'R' -> c++;
                    case 'D' -> r++;
                    case 'L' -> c--;
                }
                r = Math.max(r, 0);
                r = Math.min(r, 2);
                c = Math.max(c, 0);
                c = Math.min(c, 2);
            }
            result+=keypad[r][c];
        }
        System.out.println(result);
    }

}
