package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1610. Maximum Number of Visible Points
 * You are given an array points, an integer angle, and your location, where location = [posx, posy] and points[i] = [xi, yi] both denote integral coordinates on the X-Y plane.
 *
 * Initially, you are facing directly east from your position. You cannot move from your position, but you can rotate. In other words, posx and posy cannot be changed. Your field of view in degrees is represented by angle, determining how wide you can see from any given view direction. Let d be the amount in degrees that you rotate counterclockwise. Then, your field of view is the inclusive range of angles [d - angle/2, d + angle/2].
 * You can see some set of points if, for each point, the angle formed by the point, your position, and the immediate east direction from your position is in your field of view.
 *
 * There can be multiple points at one coordinate. There may be points at your location, and you can always see these points regardless of your rotation. Points do not obstruct your vision to other points.
 *
 * Return the maximum number of points you can see.
 *
 * https://leetcode.com/problems/maximum-number-of-visible-points/
 */
public class NumberOfVisiblePointsG {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        // only the angle between point and origin matters, the distance doesn't matter
        List<Double> angles = new ArrayList<>();
        int atOrigin = 0;
        for (List<Integer> p : points) {
            int dx = p.get(0) - location.get(0);
            int dy = p.get(1) - location.get(1);
            if (dx == 0 && dy == 0) { // edge case of same point
                atOrigin++;
                continue;
            }
            angles.add(Math.atan2(dy, dx) * (180 / Math.PI));
        }
        Collections.sort(angles);
        List<Double> tmp = new ArrayList<>(angles);
        for (double d : angles) {
            tmp.add(d + 360); // concatenate to handle edge case
        }
        int res = atOrigin;
        int j = 0;
        for (int i = 0; i < tmp.size(); i++) { // sliding window with two pointers
            while (j < tmp.size()) {
                if (tmp.get(j) - tmp.get(i) <= angle) {
                    j++;
                } else {
                    break;
                }
            }
            res = Math.max(res, atOrigin + j - i);
        }
        return res;
    }

    public static void main(String[] args) {
        NumberOfVisiblePointsG obj = new NumberOfVisiblePointsG();
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> p1 = new ArrayList<>();
        p1.add(2);
        p1.add(1);
        list.add(p1);

        List<Integer> p2 = new ArrayList<>();
        p2.add(2);
        p2.add(2);
        list.add(p2);

        List<Integer> p3 = new ArrayList<>();
        p3.add(3);
        p3.add(3);
        list.add(p3);

        List<Integer> location = new ArrayList<>();
        location.add(1);
        location.add(1);
        System.out.println(obj.visiblePoints(list,90,location));
    }
}
