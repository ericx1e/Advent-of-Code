package Day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Signals2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("src/Day6/input.txt"));
        int columns = in.nextLine().length();

        int[][] frequencies = new int[columns][26]; //Go down columns and keep count of letter frequencies in here
        //A bit confusing but the rows of the grid represent a column in the  data
        in = new Scanner(new File("src/Day6/input.txt"));
        while(in.hasNext()) {
            String line = in.nextLine();
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                int charIndex = (int) c -'a';
                frequencies[i][charIndex]++;
            }
        }

        String result = "";
        for (int r = 0; r < columns; r++) {
            int minIndex = 0;
            for (int c = 1; c < 26; c++) {
                if (frequencies[r][c] < frequencies[r][minIndex]) {
                    minIndex = c;
                }
            }
            result += (char) (minIndex + 'a'); //Turn index of highest frequency back to a character
        }
        System.out.println(result);
    }
}
