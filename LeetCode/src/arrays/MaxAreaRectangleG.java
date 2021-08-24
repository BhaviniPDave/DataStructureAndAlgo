package arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxAreaRectangleG {
    /**
     * If you see rectangle diagonal points, we can see the other two points have x and y interchanged i.e p3=(x(point1),y(point2) ) p4=(x(point2),y(point1)).
     * There we will every combination of two points and will make a map to get the other two points . This way we can find area and hence the answer .
     * Please refer to the below code and let me know if you find any difficulty in understanding :
     * @param points
     * @return
     */
    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] p : points) {
            if (!map.containsKey(p[0])) {
                map.put(p[0], new HashSet<>());
            }
            map.get(p[0]).add(p[1]);
        }

        int min = Integer.MAX_VALUE;

        for(int[] p1:points){
            for(int[] p2:points){
                if(p1[0]==p2[0] || p1[1]==p2[1]) continue;
                if(map.get(p2[0]).contains(p1[1]) && map.get(p1[0]).contains(p2[1])){
                    min=Math.min(min,Math.abs(p2[0]-p1[0])*Math.abs(p2[1]-p1[1]));
                }
            }
        }

        return min==Integer.MAX_VALUE?0:min;
    }
    public static void main (String[] args) {
        MaxAreaRectangleG obj = new MaxAreaRectangleG();
        int[][] arr = {{1,1},{1,3},{3,1},{3,3},{2,2}};
        System.out.println((obj.minAreaRect(arr)));
    }
}
