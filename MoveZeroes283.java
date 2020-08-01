public class MoveZeroes283 {
    public static void moveZeroes(int[] nums) {
        if(nums.length <= 1) {
            return;
        }
        int p = 0, count = 0;
        while (p < nums.length) {
            if (nums[p] != 0) {
                nums[count] = nums[p];
                count++;
            }
            p++;
        }
        while (count < nums.length) {
            nums[count] = 0;
            count++;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0};
        moveZeroes(nums);

    }
}
