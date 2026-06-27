class Solution { 
    // This helper method now returns 1 if it's a power of two, and 0 if it's not
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
