import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> num= new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            num.add(nums[i]);
        }
        generatepermute(num, new ArrayList<>(), result);
        return result;
    }

    private void generatepermute(List<Integer> nu, List<Integer> tmp, List<List<Integer>> result) {
        if (nu.size()==0) {
            result.add(new ArrayList<>(tmp)); 
            return;
        }
        for(int i=0;i<nu.size();i++){
            if (i > 0 && nu.get(i).equals(nu.get(i - 1))) {
                continue;
            }
            List<Integer> ip=new ArrayList<>(nu);
            List<Integer> op=new ArrayList<>(tmp);
            op.add(ip.get(i));
            ip.remove(i);
            generatepermute(ip,op,result);
        }
    }
}
