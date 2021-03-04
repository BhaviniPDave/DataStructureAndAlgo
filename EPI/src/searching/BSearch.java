package searching;

import java.util.List;

public class BSearch {

    public int bSearch(int t, List<Integer> A) {
        int L=0;
        int U = A.size()  -1;
        while(L <=U) {
            int M  = (L+U)/2;
            if (A.get(M) < t){
                L = M +1;
            }
            else if (A.get(M) > t) {
                U = M -1;
            }
            else {
                return M;
            }
        }
        return -1;
    }
}
