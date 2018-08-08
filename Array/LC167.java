package Array;

public class LC167 {
    public int[] twoSum(int[] numbers, int target) {
        int low = 0, high = numbers.length;
        int sum = numbers[low] + numbers[high];
        while (sum != target) {
            if (sum < target) {
                low++;
            }
            if (sum > target) {
                high--;
            }
            sum = numbers[low] + numbers[high];
        }
        return new int[]{low, high};
    }
}
