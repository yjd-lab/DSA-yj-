class Solution {
    public int power(int n){
        if(n<=0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(n%3!=0){
            return 0;
        }
        return power(n/3);
    }
    public boolean isPowerOfThree(int n) {
          int res = power(n); 
        
        if (res == 1) { 
            return true; 
        } else { 
            return false; 
        } 
    }
}