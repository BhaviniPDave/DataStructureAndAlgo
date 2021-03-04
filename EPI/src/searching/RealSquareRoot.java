package searching;

public class RealSquareRoot {

    public static double squareRoot(double k) {
        double left, right;
        if(k < 1.0){
            left = k;
            right = 1.0;
        }
        else {
            left = 1.0;
            right =  k;
        }
        while (compare(left,right) != Ordering.EQUAL) {
            double mid = left + 0.5 * (right -left);
            double midSquare = mid * mid;
            if (compare(midSquare,k) == Ordering.LARGER) {
                right = mid;
            }
            else {
                left = mid;
            }
        }
        return left;
    }

    private enum Ordering {SMALLER, EQUAL, LARGER};
    private static Ordering compare(double a, double b){
        final double EPSILON = 0.000001;
        double diff = (a - b) /Math.max(Math.abs(a) , Math.abs(b));
        return diff < EPSILON  ? Ordering.SMALLER : (diff > EPSILON ? Ordering.LARGER : Ordering.EQUAL);
    }

    public static void main(String[] args) {
        System.out.println(squareRoot(1.0));
    }
}
