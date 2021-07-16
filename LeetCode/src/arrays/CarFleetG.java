package arrays;

import dailyCodingProblems.TwoSum;

import java.util.Map;
import java.util.TreeMap;

/**
 * 853. Car Fleet
 * N cars are going to the same destination along a one lane road.  The destination is target miles away.
 *
 * Each car i has a constant speed speed[i] (in miles per hour), and initial position position[i] miles towards the target along the road.
 *
 * A car can never pass another car ahead of it, but it can catch up to it, and drive bumper to bumper at the same speed.
 *
 * The distance between these two cars is ignored - they are assumed to have the same position.
 *
 * A car fleet is some non-empty set of cars driving at the same position and same speed.  Note that a single car is also a car fleet.
 *
 * If a car catches up to a car fleet right at the destination point, it will still be considered as one car fleet.
 *
 *
 * How many car fleets will arrive at the destination?
 *
 * Example 1:
 *
 * Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
 * Output: 3
 * Explanation:
 * The cars starting at 10 and 8 become a fleet, meeting each other at 12.
 * The car starting at 0 doesn't catch up to any other car, so it is a fleet by itself.
 * The cars starting at 5 and 3 become a fleet, meeting each other at 6.
 * Note that no other cars meet these fleets before the destination, so the answer is 3.
 *
 */
public class CarFleetG {
    /**
     * If one car catch up the one before it, it means the time it takes to reach the target is shorter than the one in front(if no blocking).
     * For example:
     * car A at pos a with speed sa
     * car B at pos b with speed sb
     * (b < a < target)
     * Their distances to the target are (target-a) and (target-b).
     * If (target-a)/sa > (target-b)/sb it means car A take more time to reach target so car B will catch up car A and form a single group.
     * So we use the distance to target as key and speed as value, iterate through all cars in order of their distances to the target.
     * keep track of currently slowest one(which might block the car behind), if a car can catch up current slowest one, it will not cause a new group.
     * Otherwise, we count a new group and update the info of slowest
     *
     * @param target
     * @param position
     * @param speed
     * @return
     */
    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = position.length;
        for (int i = 0; i < n; ++i) {
            map.put(target - position[i], speed[i]);
        }
        int count = 0;
        double r = -1.0;
        /*for all car this value must > 0, so we can count for the car closeset to target*/
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int d = entry.getKey(); // distance
            int s = entry.getValue(); // speed
            double t = 1.0 * d / s; // time to target
            if (t > r) { // this car is unable to catch up previous one, form a new group and update the value
                ++count;
                r = t;
            }
        }
        return count;
    }
    /**
     * Calculate time needed to arrive the target, sort by the start position.
     * Loop on each car from the end to the beginning. cur recorde the current biggest time (the slowest).
     * If another car needs less or equal time than cur, it can catch up this car.
     * Otherwise it will become the new slowest car, that is new lead of a car fleet.
     */
    public int carFleetMethod2(int target, int[] pos, int[] speed) {
        TreeMap<Integer, Double> m = new TreeMap<>();
        for (int i = 0; i < pos.length; ++i) m.put(-pos[i], (double)(target - pos[i]) / speed[i]);
        int res = 0; double cur = 0;
        for (double time : m.values()) {
            if (time > cur) {
                cur = time;
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CarFleetG obj = new CarFleetG();
        int[] position = {10,8,0,5,3};
        int[] speeds = {2,4,1,1,3};
        System.out.println(obj.carFleet(12,position,speeds));
    }
}