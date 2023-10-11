// https://leetcode.com/problems/4sum/description/


class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);
        int n = nums.length;

        List<List<Integer>> ans = new ArrayList<>();

        int countEven = 0;
        int countOdd = 0;

        for(int i = 0 ; i<n ; i++){
            if(nums[i] > 0){
                countEven++;
            }
            else if(nums[i] < 0){
                countOdd++;
            }
        }

        if((countEven == n && target<0) ||  (countOdd == n && target>0)){
            return ans;
        }


        HashSet<List<Integer>> HS = new HashSet<>();

        for(int i = 0; i <n-3 ; i++){
            for(int j = i+1; j<n-2 ; j++){

                int left = j+1;
                int right = n-1;

                while(left<right){

                    int sum = nums[i] + nums[j] + nums[left] + nums[right];

                    if(sum == target){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[left]);
                        temp.add(nums[right]);

                        if(!HS.contains(temp)){
                            HS.add(temp);
                            ans.add(temp);
                        }

                        left++;
                        right--;
                    }
                    else if(sum < target){
                        left++;
                    }
                    else{
                        right--;
                    }
                }
            }

        }

        return ans;        
    }
}
