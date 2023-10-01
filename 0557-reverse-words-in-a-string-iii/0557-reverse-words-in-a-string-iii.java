class Solution {
    public String reverseWords(String s) {
        String a[]=s.split(" ");
        String ret="";
        String r="";
        for(int i=0;i<a.length;i++){
            ret=a[i];
            int j=ret.length();
            while(j>0){
                r=r+ret.charAt(j-1);
                j--;
            }  
            if(i==a.length-1){
                break;
            }
            r=r+" ";
        }
        return r;        
    }
}