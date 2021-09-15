package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Triangles {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("src/Day3/input.txt"));
        int result = 0;
        while(in.hasNext()) {
            int[][] data = new int[3][3];
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    data[r][c] = in.nextInt();
                }
            }

            for (int c = 0; c < 3; c++) {
                int x = data[0][c];
                int y = data[1][c];
                int z = data[2][c];
                if(x+y>z&&y+z>x&&x+z>y) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
