class Solution { 
    public int power(int n) { 
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n % 2 != 0) {
            return 0;
        }
        return power(n / 2); 
    } 
    public boolean isPowerOfTwo(int n) { 
        int res = power(n); 
        if (res == 1) { 
            return true; 
        } else { 
            return false; 
        } 
    } 
}
