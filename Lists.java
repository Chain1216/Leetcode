public class Lists {
	
	public static void main(String args[]) {
		
	

/* Given an array of integers nums which is sorted in ascending order, and an integer target
* write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
* Input: nums = [-1,0,3,5,9,12], target = 9
* Output: 4
*/
		
	public int search(int[] nums, int target) {  //最基本的二分法
        int left = 0;
        int right = nums.length-1;
        
        while(left<=right){
            int middle = (left+right)/2;
            if(nums[middle]<target){
                left = middle+1;
            }
            else if(nums[middle]>target){
                right=middle-1;
            }
            else {
                return middle;
            }
            
        }
        
        return -1;
        
    }
		
/* Given a sorted array of distinct integers and a target value, return the index if the target is found. 
* If not, return the index where it would be if it were inserted in order.
* X35
*/
    public int searchInsert(int[] nums, int target) {
      if(target<nums[0]){
          return 0;
      }
      if(target>nums[nums.length-1]){
          return nums.length;
      }
    
      int left = 0, right = nums.length-1;
      while(left<=right){
          int middle = (left+right)/2;
          if(nums[middle]<target){
              left = middle + 1;
          }
          else if(nums[middle]>target){
              right= middle-1;
          }
          else {
              return middle;
          }
          
      }
    return right+1;  //如果target不在数组里面，第一个比middle大的数就是要插入的位置，while loop停止的时候，right等于middle（第一个比target大的数）-1
    }
		
/*
*Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
*If target is not found in the array, return [-1, -1].
*X35
*/
		/* 这里面共三种情况
    *1.target不在数组里；特别大或者特别小，这种情况不赋值（=-2）； 最后left=right在数组及右或及左；
    *2. target不在数组里，其职在数组值之间，这种情况最后leftBoard和rightBoard中间至少要间隔一个数据;(a,b,c)
    *3. target在数组里，找到左右边距A,B，分别A+1，B-1
    *寻找border的方法就是让middle在临界点找到target，然后找到target+1或者-1；
    *临界点就是当left或者right=target的时候，继续+1或者-1导致left>right或者right<left， loop结束
    */
    public int[] searchRange(int[] nums, int target) {
        int left = getLeftBorder(nums,target);
        int right = getRightBorder(nums,target);
        if(left==-2||right==-2){
            return new int[]{-1,-1};
        }
        if(right-left>=2){
            return new int[]{left+1,right-1};
        }
        return new int[]{-1,-1};
    }
    
    private int getRightBorder(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        int rightBorder = -2;
        
        while(left<=right){
            int middle = (left+right)/2;
            if(nums[middle]>target){
                right = middle-1;
            }
            else{
                left = middle+1;     // left一旦度过middle，新的middle永远大于target，right左移，loop结束；
                rightBorder = left;  // 寻找右边界，nums[middle] == target的时候更新left 
            }
        }
        return rightBorder;
    }
    
    private int getLeftBorder(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        int leftBorder = -2;
        
        while(left<=right){
            int middle = (left+right)/2;
            if(nums[middle]<target){
                left = middle+1;
            }
            else{
                right = middle-1;    //right一旦度过middle，新的middle永远小于target，left右移，loop结束；
                leftBorder = right; // 寻找左边界，就要在nums[middle] == target的时候更新right
            }
        
        }
        return leftBorder;
    }
		
/*Given a non-negative integer x, compute and return the square root of x.
*Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
*x69
*/

class Solution {
    public int mySqrt(int x) {                                 
        if(x<=1){
            return x;
        }
        
    
        int left = 0;
        int right = x/2;
        
        while(left<=right){
            int middle = (left+right)/2;
            long sq = (long)middle*(long)middle;
            
            if(sq<=x){
                left=middle+1;
            }
            else{
                right=middle-1;
            }
            
        }
        return left-1;
        
}
}
		
		
		
}
}
