package src.AmzOA;

public class FiveStartSeller {

    public static void main(String[] args) {
        int threshold = 77;
        int[][] data = new int[][]
                {
                        new int[] {4, 4},
                        new int[] {1, 2},
                        new int[] {3, 6},
                };
        int result = GetRequiredFiveStars(data, threshold);
        System.out.println(result);
    }

    private static int GetRequiredFiveStars(int[][] data, int threshold)
    {
        int result = 0;
        int totalProducts = data.length;
        double reqdSum = threshold * totalProducts * 1.0/ 100;

        double currentSum = 0;
        while(currentSum < reqdSum )
        {
            currentSum = 0;
            double maxContribution = 0;
            int productItem = -1;
            for (int i = 0; i < data.length; i++)
            {
                double contribution = (data[i][0] + 1)* 1.0/ (data[i][1] + 1) - data[i][0] * 1.0/ data[i][1];
                if (maxContribution < contribution)
                {
                    maxContribution = contribution;
                    productItem = i;
                }
                currentSum += data[i][0] * 1.0 / data[i][1];
            }

            currentSum = currentSum - data[productItem][0] * 1.0 / data[productItem][1];
            data[productItem][0] = data[productItem][0] + 1;
            data[productItem][1] = data[productItem][1] + 1;
            currentSum = currentSum + data[productItem][0] * 1.0 / data[productItem][1];
            result++;
        }

        return result;
    }
}
