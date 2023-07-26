class Solution {
    public int secondHighest(String s) {
        Set<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for(char c:s.toCharArray())
            if(Character.isDigit(c))
                set.add(Integer.parseInt(String.valueOf(c)));

        if(set.size() == 1)
            return -1;

        int i=1;
        for(int j: set)
            if(i++==2)
                return j;

        return -1;
    }
}