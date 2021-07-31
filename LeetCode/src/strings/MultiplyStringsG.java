package strings;

public class MultiplyStringsG {

    public String multiply(String num1, String num2) {
        int n1 = 0;
        int n2 = 0;
        for(int i=0;i<num1.length();i++){
            n1 = 10 * n1 + (num1.charAt(i) - '0');
        }
        for(int i=0;i<num2.length();i++){
            n2 = 10 * n2 + (num2.charAt(i) - '0');
        }
        return String.valueOf(n1 * n2);
    }


    public static void main (String[] args) {
        MultiplyStringsG obj = new MultiplyStringsG();
        System.out.println(obj.multiply("123","456"));
    }
}
