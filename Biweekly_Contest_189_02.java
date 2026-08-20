class Solution {
    public int pal(String s){
        int i=0;
        int j=s.length()-1;
        int c=0;
        while (i<j){
            //increment (maybe using ascii)
            int a1=Math.abs((s.charAt(i)-'a')-(s.charAt(j)-'a'));
            int a2=26-a1;
            c+=Math.min(a1,a2);
            i+=1;
            j-=1;
        }
        return c;
    }
    public int minOperations(String s) {
        int n=s.length();
        int m= Integer.MAX_VALUE;
        for (int i=0;i<n;i++){
            int cost= pal(s)+i;
            m=Math.min(m,cost);
            s+=s.charAt(0);
            s = s.substring(1);
            }
        return m;
    }
}