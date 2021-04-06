package string;

/**
 * I/p: "Ram is Costly"
 * O/p: "Costly is Ram"
 *
 * Step 1: Reverse entire String -> ""yltsoc si mar"
 * Step 2: Reverse each word - > Costly is Ram"
 *
 */
public class ReverseWords {
    public static void main (String[] args) {
        String s = "Ram is Costly";
        System.out.println(reserseWords(s.toCharArray()));
    }
    public static char[] reserseWords (char[] input){
       int n = input.length;
       //First reverse whole string
        reverse(input,0,n-1);
        //Second reverse each word in the string
        int start = 0,finish = 0;
        while (start < n) {
            while (start < finish || start < n && input[start] == ' '){
                ++start; // Skip space chars
            }
            while (finish < start || finish < n && input[finish] != ' ') {
                ++finish;
            }
            reverse(input,start,finish-1);
        }
        return input;
    }
    private static void reverse (char[] array, int start, int end) {
        while (start < end) {
            char tmp = array [start];
            array[start ++] = array[end];
            array[end--] = tmp;
        }
    }
}
