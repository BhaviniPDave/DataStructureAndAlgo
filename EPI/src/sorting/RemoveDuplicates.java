package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RemoveDuplicates {
    public static class Name implements Comparable<Name> {

        String firstName;
        String lastName;

        @Override
        public int compareTo(Name o) {
            int cmpFirst  = firstName.compareTo(o.firstName);
            if(cmpFirst != 0)
                return cmpFirst;
            return lastName.compareTo(o.lastName);
        }

        public Name(String firstName,String lastName){
            this.firstName = firstName;
            this.lastName = lastName;
        }
    }

    public static void eliminateDuplicate(List<Name> names) {
        Collections.sort(names);
        int writeIndex = 0;
        for(int i=1;i<names.size();i++){
            if(!names.get(i).firstName.equals(names.get(writeIndex).firstName)) {
                names.set(++writeIndex,names.get(i));
            }
        }
        names.subList(++writeIndex,names.size()).clear();
    }

    public static void main (String[] args) {
        List<Name> names = new ArrayList<>();
        names.add(new Name("Ian","Botham"));
        names.add(new Name("David","Gower"));
        names.add(new Name("Bhavini","Bell"));
        names.add(new Name("Ian","Chappel"));

        eliminateDuplicate(names);

        System.out.println(names);

    }
}


