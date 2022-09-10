package lesson.two;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j <= nums.length - 1; j++) {
                if (target == nums[i] + nums[j] && i != j) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        int[] array = ts.twoSum(new int[]{3, 2, 4}, 6);
        for (int i = 0; i < 2; i++) {
            System.out.println(array[i]);
        }

    }

}
