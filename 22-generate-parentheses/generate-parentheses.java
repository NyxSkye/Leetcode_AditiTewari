class Solution {
    public void gen(int n, int index, String curr, List<String> res, int to, int tb){
        if (to > n || tb > n){
            return;
        }
        if (tb > to){
            return;
        }
        if(index==(n*2)){
            res.add(curr);
            return;
        }

        gen(n,index+1,curr+"(",res, to+1, tb);
        gen(n,index+1,curr+")",res, to, tb+1);    
    }
    public List<String> generateParenthesis(int n) {
        List<String> res= new ArrayList<>(n*2);
        gen(n, 0, "", res, 0, 0);
        System.out.println(res);
        return res;
    }
}