package string;

public class StringIntegerInterConversion {

    public static void main(String args[]){
      StringIntegerInterConversion obj = new StringIntegerInterConversion();
      System.out.println(obj.intToString(123));
        System.out.println(obj.intToString(-123));
        System.out.println(obj.stringToInt("-123"));
        System.out.println(obj.stringToInt("123"));
    }

    public String intToString(int x){
        boolean negative = false;
        if(x < 0){
            negative  = true;
        }
        StringBuilder sb = new StringBuilder();
        do{
            sb.append((char)( '0' + Math.abs(x%10)));
            x = x/10;
        }while(x!=0);
        sb.append(negative?"-":"");
        return sb.reverse().toString();
    }

    public Integer stringToInt(String str) {
        int x  = (str.charAt(0) == '-'?-1:1)  * str.substring(str.charAt(0) == '-'?1:0).chars().reduce(0,(runningSum,c) -> runningSum *10 + c - '0');
        return x;
    }
}
