package hard.aboutArray;

import java.util.*;

class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
}
/**
* @Description: 插入interval间隔，有重叠部门则进行合并。
* @Author: chenpeng
* @Date: 12:40 2018/10/12
* @param:
* @return:
*/
public class InsertInterval_57 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals.size() == 0) {
            intervals.add(newInterval);
            return intervals;
        } else {
            if (newInterval.start>intervals.get(intervals.size()-1).end) {
                intervals.add(newInterval);
                return intervals;
            }
            if (newInterval.end<intervals.get(0).start) {
                intervals.add(0,newInterval);
                return intervals;
            }
            boolean isfind = false;
            for (int i = 0; i<intervals.size();i++) {
                int index = i;
                if (intervals.get(i).end >= newInterval.start && newInterval.end >=intervals.get(i).start) {
                    isfind = true;
                    for (;i<intervals.size();i++) {
                        if(intervals.get(i).start <= newInterval.end) {
                            newInterval.end =Math.max(intervals.get(i).end,newInterval.end);
                            if (i != index) {
                                intervals.remove(i);
                                i--;
                            }
                        } else {
                            break;
                        }
                    }
                    intervals.get(index).end = newInterval.end;
                    intervals.get(index).start = Math.min(newInterval.start,intervals.get(index).start);
                    break;
                }
            }
            if (!isfind) {
                for (int i = intervals.size()-1; i>=0;i--) {
                    if (intervals.get(i).start>newInterval.end && intervals.get(i-1).end<newInterval.start) {
                        intervals.add(i,newInterval);
                        break;
                    }
                }
            }
            return intervals;
        }

    }
//[[1,5]]
//        [0,3]
    public static void main(String[] args) {
        //[[1,2],[3,5],[6,7],[8,10],[12,16]]
        //[[3,5],[12,15]]
        //[6,6]
        //[[1,5]]
//[0,1]
        Interval interval1 = new Interval(3,5);
        Interval interval2 = new Interval(12,15);
        Interval interval3 = new Interval(6,6);
        Interval interval4 = new Interval(8,10);
        Interval interval5 = new Interval(12,16);
        Interval interval6 = new Interval(4,8);
        InsertInterval_57 insertInterval_57 = new InsertInterval_57();
        List<Interval> list = new ArrayList<>();
        insertInterval_57.insert(list, interval1);
         insertInterval_57.insert(list, interval2);
        List<Interval> res = insertInterval_57.insert(list, interval3);
//        insertInterval_57.insert(list, interval3);
//        insertInterval_57.insert(list, interval4);
//        insertInterval_57.insert(list, interval5);
//        List<Interval> res = insertInterval_57.insert(list, interval6);
        for (Interval interval:res) {
            System.out.println(interval.start+"==="+interval.end);
        }
    }
}
