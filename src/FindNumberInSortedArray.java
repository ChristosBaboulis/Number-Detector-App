import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class FindNumberInSortedArray {

    public static List<Integer> convertIntegerSequenceToList(String input) {
        List<Integer> list = new ArrayList<>();
        String[] elements = input.split("\\s+");
        for (String element : elements) {
            list.add(Integer.valueOf(element));
        }
        return list;
    }

    public static List<Integer> convertFileSequenceToList(File input) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(input));
        String line = br.readLine();
        br.close();
        return convertIntegerSequenceToList(line);
    }

    public static void main(String[] args) throws IOException {

        File sm = new File("1-sm.txt");
        System.out.print("Inserted File: "+convertFileSequenceToList(sm));
        List<Integer> A = convertFileSequenceToList(sm);

        int x = 8;
        int count = 0;
        int j = A.size()/2;
        int mid = A.get(j);

        if (x > mid) {
            for(int i = A.size()/2 + 1; i < A.size(); i++) {
                if(A.get(i).equals(x)) {
                    count = count + 1;
                }
            }
        }
        else if(x == mid) {
            count = count +1;
            int n = 1;
            while(A.get(j-n) == x) {
                count = count + 1;
                n = n + 1;
            }
            n = 1;
            while(A.get(j+n) == x) {
                count = count + 1;
                n = n + 1;
            }
        }

        else {
            for(int i = 0; i<A.size()/2;i++) {
                if(A.get(i).equals(x)) {
                    count = count + 1;
                }
            }
        }
        System.out.print("\nX = "+x+" appears "+count+" times.");
    }
}