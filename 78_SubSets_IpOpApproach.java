import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> num= new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            num.add(nums[i]);
        }
        generateSubsets(num, new ArrayList<>(), result);
        return result;
    }

    private void generateSubsets(List<Integer> nu, List<Integer> tmp, List<List<Integer>> result) {
        result.add(new ArrayList<>(tmp)); 
        if (nu.size()==0) {
            return;
        }
        for(int i=0;i<nu.size();i++){
            List<Integer> ip=new ArrayList<>(nu);
            List<Integer> op=new ArrayList<>(tmp);
            op.add(ip.get(i));
            ip.subList(0,i+1).clear();
            generateSubsets(ip,op,result);
        }
    }
}
