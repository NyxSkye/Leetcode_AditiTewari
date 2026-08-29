class Solution {
    void combination(int i, String s, Map<Integer, String> m, String tem, List<String> ans){
        if (i==s.length()){
            ans.add(tem);
            return;
        }
        int el=s.charAt(i)-'0';
        String str=m.get(el);
        for(int j=0;j<str.length();j++){
            char ch=str.charAt(j);
            tem+=ch;
            combination(i+1,s,m,tem,ans);
            tem = tem.substring(0, tem.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        Map<Integer, String> map = new HashMap<>();
        List<String> ans=new ArrayList<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        combination(0,digits,map,"",ans);
        return ans;
    }
}
