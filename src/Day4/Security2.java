package Day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Security2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("src/Day4/input.txt"));
        while(in.hasNext()) {
            String line = in.nextLine();
            String checksum = line.substring(line.length()-7).substring(1, 6); //Checksum always the last 7 letters, trim brackets after
            line = line.substring(0, line.length()-7);
            int sectorID = Integer.parseInt(line.substring(line.length()-3));
            line = line.substring(0, line.length()-3);
            int[] counts = new int[26]; //Count per letter
            for (int i = 0; i < line.length(); i++) {
                if((int)line.charAt(i) < 97) {
                    continue;
                }
                int index = (int)line.charAt(i) - 97; //Ascii values to index. 'a' is 97
                counts[index]++;
            }
            boolean works = true;
            for (int i = 0; i < 5; i++) {
                int maxIndex = 0;
                int maxValue = counts[0];
                for (int j = 1; j < 26; j++) {
                    if(counts[j] > maxValue) { //In the case of a tie, the first index found is chosen
                        maxIndex = j;
                        maxValue = counts[j];
                    }
                }
                //Convert index to character
                char c = (char) (maxIndex+97);
                if(c != checksum.charAt(i)) {
                    works = false;
                    break;
                }
                //Remove the max value just found so next iteration find 2nd max value
                counts[maxIndex] = 0;
            }
            if(works) {
                String result = "";
                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);
                    int n = c - 97; //From ascii to character index (with a = 0, b = 1, so on)
                    n += sectorID;
                    n %= 26;
                    n += 97;
                    result += (char) n;
                }
                if(result.contains("northpole")) {
                    
                    System.out.println(sectorID);
                }
            }
        }
    }
}
