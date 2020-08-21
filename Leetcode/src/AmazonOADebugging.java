package src;

public class AmazonOADebugging {
    public static void main(String[] args) {
        System.out.println(compareProduct(13355));
        System.out.println(compareProduct(10350));
        int[] arr = new int[]{4,5,6,1,2,3};
        System.out.println(countRotation(arr, 6));
    }

   static boolean compareProduct(int num){
        if(num < 10) return false;
        int oddP = 1, evenP = 1;

        while(num > 0){
            int dig = num %10;
            oddP*=dig;
            num/=10;

            if(num == 0) break;

            dig = num%10;
            evenP*=dig;
            num/=10;
        }
        return (evenP == oddP);
    }

  static int countRotation(int[] list,int size) {
        int res = countRotationUtil(list, 0, size-1);
        return res;
  }
  static int countRotationUtil(int[] list, int low, int high){
         if(high < low)
            return 0;
         if(high == low)
             return low;

         int mid = low + (high - low)/2;
         if(mid < high && list[mid+1] < list[mid])
             return mid+1;

         if(mid > low && list[mid] < list[mid-1])
             return mid;

         if(list[high] > list[mid])
             return countRotationUtil(list,low,mid);

         return countRotationUtil(list,mid,high);

  }
}
