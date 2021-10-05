package codeTrain.arrayExam;

/**
 * @author Epic
 * @create 2021-09-29 22:10
 */
public class MaxDiff {
  public int maximumDifference(int[] nums) {
    // Arrays.sort(nums);
    int max = -1;
    int min = nums[0];
    for(int i = 1; i < nums.length; i++){
      int sub = nums[i] - min;
      if(sub > 0){
        max = Math.max(max,sub);
      }else{
        //更新最小值
        min = nums[i];
      }

    }

    return max;
  }
}
