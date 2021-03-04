package strings;

public class LongPressedName {
    public static boolean isLongPressedName(String name, String typed) {
        int i=0, j=0;
        char prev = name.charAt(0);

        if(typed.length() < name.length()) {
            return false;
        }
        for(i=0, j=0; j< typed.length(); ) {
            if(i<name.length() && name.charAt(i) == typed.charAt(j)) {
                prev = name.charAt(i);
                i++;
                j++;
            } else if (prev == typed.charAt(j)) {
                j++;
            } else {
                return false;
            }
        }
        if(i< name.length()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isLongPressedName("alex","aaleex"));
    }

}
