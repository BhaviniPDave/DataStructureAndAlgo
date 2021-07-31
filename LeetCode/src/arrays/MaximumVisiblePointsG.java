package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1610. Maximum Number of Visible Points
 * You are given an array points, an integer angle, and your location, where location = [posx, posy] and points[i] = [xi, yi] both denote integral coordinates on the X-Y plane.
 *
 * Initially, you are facing directly east from your position.
 * You cannot move from your position, but you can rotate.
 * In other words, posx and posy cannot be changed.
 * Your field of view in degrees is represented by angle, determining how wide you can see from any given view direction.
 * Let d be the amount in degrees that you rotate counterclockwise.
 * Then, your field of view is the inclusive range of angles [d - angle/2, d + angle/2].
 *
 * You can see some set of points if, for each point, the angle formed by the point, your position,
 * and the immediate east direction from your position is in your field of view.
 *
 * There can be multiple points at one coordinate. There may be points at your location,
 * and you can always see these points regardless of your rotation. Points do not obstruct your vision to other points.
 *
 * Return the maximum number of points you can see.
 */
public class MaximumVisiblePointsG {
    private int origin = 0;
    private List<Double> angles = new ArrayList<>();

    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        checkAngle(location, points);
        Collections.sort(angles);

        int res = 0;
        for (int i = 0, j = 0; j < angles.size(); j++) {
            while (angles.get(j) - angles.get(i) > (double) angle + 1e-9)
                i++;
            res = Math.max(res, j - i + 1);
        }

        return res + origin;
    }

    private void checkAngle(List<Integer> loc, List<List<Integer>> points) {
        for (List<Integer> point : points) {
            int dy = point.get(1) - loc.get(1);
            int dx = point.get(0) - loc.get(0);

            if (dy == 0 && dx == 0) {
                origin++;
                continue;
            }

            double temp = Math.atan((double) dy / dx) / Math.PI * 180.0;
            if (dx < 0) temp += 180.0;
            else if (dy < 0) temp += 360.0;

            angles.add(temp);
            angles.add(temp + 360.0);
        }
    }

    public static void main (String[] args) {
        MaximumVisiblePointsG obj = new MaximumVisiblePointsG();
        List<List<Integer>> points = new ArrayList<>();
        List<Integer> point1 = new ArrayList<>();
        point1.add(2);
        point1.add(1);
        points.add(point1);

        List<Integer> point2 = new ArrayList<>();
        point2.add(2);
        point2.add(2);
        points.add(point2);

        List<Integer> point3 = new ArrayList<>();
        point3.add(3);
        point3.add(4);
        points.add(point3);

        List<Integer> point4 = new ArrayList<>();
        point4.add(1);
        point4.add(1);
        points.add(point4);

        List<Integer> location = new ArrayList<>();
        location.add(1);
        location.add(1);

        System.out.println(obj.visiblePoints(points,90,location));
    }
}
