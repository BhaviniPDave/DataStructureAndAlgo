package arrays;

public class MedianOfSortedArraysG {
    public double findMedianSortedArrays(int[] a, int[] b) {
        if(a.length > b.length)
            return findMedianSortedArrays(b,a);
        int m = a.length;
        int n = b.length;

        int start = 0;
        int end = m;

        while (start < end) {
            int mid1=(end+start)/2;
            int mid2=(m+n+1)/2-mid1;

            int left1 = mid1==0 ? Integer.MIN_VALUE : a[mid1-1];
            int left2 = mid2==0 ? Integer.MIN_VALUE : b[mid2-1];

            int right1 = mid1==m ? Integer.MAX_VALUE : a[mid1];
            int right2 = mid2==n ? Integer.MAX_VALUE : b[mid2];

            if(left1 <= right2 && left2 <= right1)
            {
                if((m+n)%2 == 0)
                    return (Math.max(left1,left2) + Math.min(right1,right2))/2.0;
                else
                    return Math.max(left1,left2)/1.0;
            }
            else if(left1 > right2)
            {
                end = mid1 - 1;
            }
            else
            {
                start = mid1 + 1;
            }

        }
        return 0.0;

    }
    public static void main (String[] args) {
        MedianOfSortedArraysG obj = new MedianOfSortedArraysG();
        int[] a = {1,3};
        int[] b = {2};
        System.out.println(obj.findMedianSortedArrays(a,b));
    }
}
