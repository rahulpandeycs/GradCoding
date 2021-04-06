package codesignal;

public class SawToothSequenceJava {

    // Function to count the number of maximal contiguous
    // increasing and decreasing subsequences
    static long countSawSubarrays(int[] arr) {
        int n = arr.length;
        long ans = 0;
        long[] saw = new long[n];

        // check edge cases for n = 0,1,2
        if (n == 0 || n == 1) {
            return 0;
        }
        if (n == 2) {
            if(arr[0] > arr[1] || arr[1] > arr[0]) return 1;
            else return 0;
        }
        // saw[i] represent the size of sawtooth subarray including index i.
        // first element cannot form a sawtooth sequence
        saw[0] = 0;

        // initialize the saw[] array for n=2
        if(arr[0] > arr[1] || arr[1] > arr[0]) {
            saw[1] = 2;
        }

        for (int i=2; i<n; i++) {
            // check if including ith element forms a sawtooth sequence
            if((arr[i-2] < arr[i-1] && arr[i-1] > arr[i])
                    || (arr[i-2] > arr[i-1] && arr[i-1] < arr[i]))
            {
                if(i==2) {
                    saw[i] = saw[i-2] + 3;
                }
                else {
                    saw[i] = saw[i-2] + 2;
                }
            }
            // if ith element forms a sawtooth sequence just with previous element
            else if(arr[i-1] > arr[i] || arr[i] > arr[i-1]) {
                saw[i] = 2;
            }
        }

        // compute ans, which is sum of all (non-zero values - 1)
        for(int i=0; i<n; i++) {
            if(saw[i] <= 0) continue;
            ans += saw[i] - 1;
        }
        return ans;
    }

    // Driver code
    public static void main (String[] args)
    {
        int[] arr = {1,2,1,2,1};
        int[] arr2 = {9,8,7,6,5};
        int[] arr3 = {-1000000000,1000000000};
        int[] arr4 = {10, 10, 10, 10};
        System.out.println(countSawSubarrays(arr));
        System.out.println(countSawSubarrays(arr2));
        System.out.println(countSawSubarrays(arr3));
        System.out.println(countSawSubarrays(arr4));
    }
}
