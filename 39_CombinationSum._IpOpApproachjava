class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> input=new ArrayList<>();
        List<Integer> output=new ArrayList<>();
        for(int a:nums){
            input.add(a);
        }
        Collections.sort(input);
        generateSubSets(input,output,0,target,ans);
        ans.forEach(Collections::sort);
        List<List<Integer>> fResult = new ArrayList<>(new LinkedHashSet<>(ans));
        return fResult;    
        }
    void generateSubSets(List<Integer> input,List<Integer> output,int cur,int tar,List<List<Integer>> ans){
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
            generateSubSets(ip,op,cur+tem,tar,ans);
        }
    }
}
