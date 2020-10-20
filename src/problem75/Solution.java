package problem75;

class Solution {
    public void sortColors(int[] nums) {
        int zeroPos = 0, twoPos = nums.length - 1;
        int nowPos = zeroPos;
        while(nowPos <= twoPos){
            if(nums[nowPos] == 0){
                if(nowPos == zeroPos){
                    nowPos++;
                }else{
                    swap(nums,zeroPos,nowPos);
                }
                zeroPos++;
            }else if(nums[nowPos] == 2){
                swap(nums,nowPos,twoPos--);
            }else{
                nowPos++;
            }
        }
    }
    public void swap(int[] nums, int l, int r){
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }
}