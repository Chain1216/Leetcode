class Solution {
  //X27
  //Input: nums = [3,2,2,3], val = 3
  //Output: 2, nums = [2,2,_,_]
  //基础快慢双指针，根据（有事）（没事）判定指针起始位置；例如duplicate比较的是前后，指针一个起始1，一个起始0
  //有事的时候，什么都不干（快指针增加）；没事的时候，慢指针前进-改变数据的量，起到移动数据的作用
  
    public int removeElement(int[] nums, int val) {
        int fast = 0;
        int slow = 0;
        int size = nums.length;
        
        for(fast = 0; fast < size;  fast++){
            if(nums[fast] != val){  //没事的时候，大家和平相处
                nums[slow]=nums[fast];
                slow++;
            }
          //一旦有事，快指针前进，前进到没事的状态，然后把这个时候的值赋到慢指针处（指向一个需要被处理的值=有事）
        }
        return slow;
    }
  
  //X26
  //Input: nums = [0,0,1,1,1,2,2,3,3,4]
  //Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
  
  public int removeDuplicates(int[] nums) {
        int fast;
        int slow = 0;
        for(fast = 1; fast < nums.length; fast++){
            if(nums[fast] != nums[slow]){    //没事的时候，和平相处，自己等于自己，一旦形成距离差，就开始移动数据
                slow++;                      //这里先slow++，再变值是因为duplicate要改变第二个值（移动后面的到他这），而非改变第一个值（fast出事的时候slow正好指向的）。
                nums[slow] = nums[fast];
            }
        }
        
        return slow+1; //因为快指针先走一步，slow要弥补回来才能指向正确的数量
    }
  
  //X283
  //Input: nums = [0,1,0,3,12]
  //Output: [1,3,12,0,0]
  //
   public void moveZeroes(int[] nums) {
        int fast;
        int slow = 0;
        int count = 0;
        
        for(fast = 0; fast < nums.length; fast++){  //起始位置都是0因为判定在于单个元素，而非比较一前一后   
            if(nums[fast] != 0){              //没事的时候，和平相处
                nums[slow] = nums[fast];
                slow++;
                
            }
            else{
                count++;
            }
        }
        
        for(int j = nums.length-1; j >= nums.length-count; j--){
            nums[j] = 0;
        }
        
    }
  
  
  //844
  //977 用单独的这种方法暂时不能理解;
}


//209
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。

class Solution {
    public int minSubArrayLen(int target, int[] nums) {  //这个叫做滑动窗口法，也可以叫做双指针的变形
        int left = 0;
        int right;
        int sum = 0;
        int count = Integer.MAX_VALUE;

        for(right = 0; right < nums.length; right++){
            sum+=nums[right];
            while (sum >= target){  //如果现在的加值大于target，则滑动左边直到小于target位置，牛逼吧？
                count = Math.min(count, right-left+1);
                    sum-= nums[left];
                    left++;
                
            }

        }
        
        return count == Integer.MAX_VALUE ? 0:count;    


    }
}








