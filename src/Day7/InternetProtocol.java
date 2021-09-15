package Day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class InternetProtocol {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("src/Day7/input.txt"));

        int result = 0;

        while(in.hasNext()) {
            String line = in.nextLine();
            String[] split = line.split("\\[");

            boolean inHasABBA = true;
            boolean outHasABBA = false;

            for(String s : split) {
                if(s.contains("]")) { //This means the part before the "]" is the stuff inside the bracket and the rest is outside
                    String a = s.split("\\]")[0];
                    String b = s.split("\\]")[1];
                    if(hasABBA(a)) {
                        inHasABBA = false;
                        break;
                    }
                    if(hasABBA(b)) {
                        outHasABBA = true;
                    }

                } else {
                    if(hasABBA(s)) {
                        outHasABBA = true;
                    }
                }
            }
            if(inHasABBA && outHasABBA) {
                result++;
            }
        }
        System.out.println(result);
    }

    private static boolean hasABBA(String s) {
        for (int i = 0; i < s.length()-3; i++) {
            String sub = s.substring(i, i+4);
            if(sub.charAt(0) == sub.charAt(3) && sub.charAt(1) == sub.charAt(2) && sub.charAt(0) != sub.charAt(1)) {
                return true;
            }
        }
        return false;
    }
}
