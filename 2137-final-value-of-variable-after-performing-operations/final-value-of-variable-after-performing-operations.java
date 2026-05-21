class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int X = 0;
        int n = operations.length;
        for (int i = 0; i < n; i++) {
            if (operations[i].equals("X++") || operations[i].equals("++X")) {
                X += 1;
            } else {
                X -= 1;
            }
        }
        return X;
    }
}
        
    
