class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> input=new ArrayList<>();
        List<Integer> output=new ArrayList<>();
        for(int a:nums){
            input.add(a);
        }
        Collections.sort(input);
        generateSubSets(input,output,0,target,ans);
        return ans;
    }
    void generateSubSets(List<Integer> input,List<Integer> output,int cur,int tar,List<List<Integer>> ans){
        System.out.println(ans+" "+output+" "+cur);
        if(cur==tar){
            ans.add(new ArrayList<>(output));
            return;
        }
        if(input.size()==0 || cur>tar){
            return;
        }
        for(int i=0;i<input.size();i++){
            List<Integer> ip=new ArrayList<>(input);
            List<Integer> op=new ArrayList<>(output);
            if(i>0 && ip.get(i)==ip.get(i-1)){
                continue;
            }
            int tem=ip.get(i);
            op.add(tem);
            ip.subList(0,i+1).clear();
            generateSubSets(ip,op,cur+tem,tar,ans);
        }
    }
}
