package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bathroom2 {
    static char[][] keypad = new char[][] {{'0', '0', '1', '0', '0'}, {'0','2','3','4','0'}, {'5', '6', '7', '8', '9'}, {'0', 'A', 'B', 'C', '0'}, {'0','0','D','0','0'}};
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("src/Day2/input.txt"));
        String result = "";

        while(in.hasNext()) {
            int r = 2;
            int c = 0;
            String line = in.nextLine();
            for (int i = 0; i < line.length(); i++) {
                char cur = line.charAt(i);
                switch (cur) {
                    case 'U' -> {
                        r--;
                        if (r < 0 || keypad[r][c] == '0') {
                            r++;
                        }
                    }
                    case 'R' -> {
                        c++;
                        if (c > 4 || keypad[r][c] == '0') {
                            c--;
                        }
                    }
                    case 'D' -> {
                        r++;
                        if (r > 4 || keypad[r][c] == '0') {
                            r--;
                        }
                    }
                    case 'L' -> {
                        c--;
                        if (c < 0 || keypad[r][c] == '0') {
                            c++;
                        }
                    }
                }
            }
            result+=keypad[r][c];
        }
        System.out.println(result);
    }

}
