package arrays;

import java.util.Stack;

public class CarFleetIIG {
    public double[] getCollisionTimes(int[][] cars) {
        int n = cars.length;
        double ret[] = new double[n];

        Stack<double[]> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            double meetTime = -1;
            while (!stack.isEmpty()) {
                double[] cur = stack.pop();
                meetTime = meetTime(cars[i][0], cur[0], cars[i][1], cur[1]);
                if (meetTime == -1 || (cur[2] != -1 && meetTime > cur[2])) continue;
                stack.push(cur);
                break;
            }
            ret[i] = meetTime;
            stack.add(new double[]{cars[i][0], cars[i][1], meetTime});
        }
        return ret;
    }

    private double meetTime(double p1, double p2, double s1, double s2) {
        if (s1 <= s2) return -1;
        return (p2 - p1) / (s1 - s2);
    }

    public static void main(String[] args) {
        CarFleetIIG obj = new CarFleetIIG();
        int[][] cars = {{1,2},{2,1},{4,3},{7,2}};
        int[][] cars2 = {{3,4},{5,4},{6,3},{9,1}};

        double[] ret = obj.getCollisionTimes(cars2);
        for(double d: ret) {
            System.out.println(d);
        }
    }

}
