package strings;

/**
 * Given a valid (IPv4) IP address, return a defanged version of that IP address.
 *
 * A defanged IP address replaces every period "." with "[.]".
 *
 * Input: address = "1.1.1.1"
 * Output: "1[.]1[.]1[.]1"
 *
 * Input: address = "255.100.50.0"
 * Output: "255[.]100[.]50[.]0"
 */
public class DefangingIPAddress {
    public static  String defangIPaddr(String address) {
    StringBuilder sb = new StringBuilder();
    char[] arr = address.toCharArray();
        for(char ch:arr){
        if(ch == '.')
            sb.append("[.]");
        else
            sb.append(ch);
    }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(defangIPaddr("1.1.1.1"));
    }

}
