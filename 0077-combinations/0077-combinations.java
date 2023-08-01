class Solution {

    List<List<Integer>> res;
    ArrayList<Integer> temp;

    void solve(int n,int k,int i){

        if(temp.size()==k){
            List<Integer> al=new ArrayList<>();
            for(int x:temp){
                al.add(x);
            }
            res.add(al);
            return;
        }

        for(int j=i;j<=n;j++){
            temp.add(j);
            solve(n,k,j+1);
            temp.remove(temp.size()-1);
        }

    }

    public List<List<Integer>> combine(int n, int k) {

        res=new ArrayList<>();
        temp=new ArrayList<>();
        solve(n,k,1);
        return res;

    }
}