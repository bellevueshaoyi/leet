// https://leetcode.com/problems/meeting-rooms/?tab=Description.
public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }
        // 自定义Comparator.
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return Integer.compare(a.start, b.start);
            }
        });
        for (int i=1; i<intervals.length; ++i) {
            if (intervals[i].start < intervals[i-1].end) {
                return false;
            }
        }
        return true;
    }
}
