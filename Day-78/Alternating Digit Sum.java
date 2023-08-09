class Solution {
    public int alternateDigitSum(int n) {
        String s = String.valueOf(n);
        int factor = 1;
        int res = 0;

        for (char chr : s.toCharArray()) {
            res += (Character.getNumericValue(chr) * factor);
            factor *= -1;
        }
        return res;
    }
}