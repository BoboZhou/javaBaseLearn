package arithmetic.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: bobo
 * @Description 给定一个整数数组，找出其中两个数相加等于目标值
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * @Date :下午6:31 2018/9/14
 */

public class TowNumSum {

    public static Object getSumNum(int[] nums, int target) {
        HashMap<Integer, Integer> recoderMap = new HashMap<>();
        // null length
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (recoderMap.containsKey(nums[i])) {
                HashMap<Integer, Integer> resmap = new HashMap<>();
                resmap.put(recoderMap.get(nums[i]), i);
                return resmap;
            }
            recoderMap.put(need, i);
        }
        return null;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{2, 7, 11, 15};
        System.out.println(getSumNum(nums,13));

    }
}
