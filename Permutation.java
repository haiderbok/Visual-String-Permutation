import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Permutation {
    String str ;
    Map<Character, Integer> count = new TreeMap<Character, Integer>();

    Permutation () {}

    Permutation(String string) {
        str = string;
    }

    Integer num_of_permutaion (String str) {

        if(str == null) {
            return -1;
        }

        int unique = 0;
        for (int i = 0; i < str.length() ; i++) {
                if (count.containsKey(str.charAt(i))) {
                    Integer temp = count.get(str.charAt(i));
                    temp = ++temp;
                    count.replace(str.charAt(i),temp);
                } else {
                    count.put(str.charAt(i), 1);
                }
            unique++;
        }

        Integer numerator = factorial(unique);

        Integer denominator = 1;
        for (Map.Entry<Character, Integer> entry: count.entrySet()) {
            if(entry.getValue() > 1) {
                denominator *= factorial(entry.getValue());
            }
        }

        return (numerator / denominator);

    }

        Integer factorial (Integer num) {

            if (num < 2) {
                return 1;
            } else {
                return num * factorial(num - 1);
            }
        }

        ArrayList<String> permutaions (String str) {
        num_of_permutaion(str);
            ArrayList<String> perm = new ArrayList<>();
            char result[] = new char[str.length()];
            char str1[] = new char[count.size()];
            int count1[] = new int[count.size()];
            int index = 0;
            for (Map.Entry<Character, Integer> entry : count.entrySet()) {
                str1[index] = entry.getKey();
                count1[index] = entry.getValue();
                index++;
            }
            permuteUtil(str1,count1,result,0, perm);
            return perm;
        }


    public void permuteUtil(char str[], int count[], char result[], int level, ArrayList<String> perm) {
        if (level == result.length) {
            perm.add(new String(result));
            return;
        }

        for(int i = 0; i < str.length; i++) {
            if(count[i] == 0) {
                continue;
            }
            result[level] = str[i];
            count[i]--;
            permuteUtil(str, count, result, level + 1, perm);
            count[i]++;
        }
    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation("ABC");



        System.out.println(permutation.permutaions(permutation.str));
    }

} // end of class
