class Solution {
    public boolean judgeCircle(String moves) {
        char arr[] = moves.toCharArray();
        int r=0;
        int u=0;

        for(int i =0 ;i<arr.length;i++){
            if(arr[i]=='U') u++;
            else if(arr[i]=='D')u--;
            else if(arr[i]=='L') r--;
            else r++;
        }
        
        if(r==0 && u==0 ) return true;
        return false;
    }
}