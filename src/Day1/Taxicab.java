package Day1;
import java.awt.*;
import java.io.*;
import java.util.HashSet;
import java.util.Scanner;


public class Taxicab{
    public static void main(String[] args) throws FileNotFoundException {
        HashSet<Point> visited = new HashSet<>();
        int x = 0;
        int y = 0;
        int dir = 0;
        boolean done = false;
        Scanner in = new Scanner(new File("src/Day1/input.txt"));
        while(in.hasNext()) {
            String step = in.next();
            char stepDir = step.charAt(0);
            int dist = Integer.parseInt(step.substring(1));
            if(stepDir == 'R') {
                dir++;
            } else {
                dir+=3;
            }
            dir %= 4;
            for (int i = 0; i < dist; i++) {
                Point curPoint = new Point(x,y);
                if(visited.contains(curPoint)) {
                    done = true;
                    System.out.println(Math.abs(x) + Math.abs(y));
                }
                visited.add(curPoint);
                    switch (dir) {
                        case 0 -> y++;
                        case 1 -> x++;
                        case 2 -> y--;
                        case 3 -> x--;
                    }
            }

            if(done) break;
//            System.out.println(dir + " -- " + dist);
        }
//        System.out.println(Math.abs(x) + Math.abs(y));
    }
}
