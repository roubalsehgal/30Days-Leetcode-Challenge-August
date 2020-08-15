class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0) return 0;
        
		Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        
        int minErase = 0;
        int nextStart = Integer.MAX_VALUE;
        for(int i = intervals.length - 1; i >= 0; i--) {
            if(nextStart < intervals[i][1]) minErase++;
            else nextStart = intervals[i][0];
        }
        
        return minErase;
    }
}