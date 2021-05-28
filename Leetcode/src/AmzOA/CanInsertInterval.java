package src.AmzOA;

public class CanInsertInterval {

//    type Interval struct {
//        start, end int
//    }
//
//    func canSchedule(schedule []Interval, job Interval) (canInsert bool) {
//        if len(schedule) == 0 {
//            return true
//        }
//
//        // sort by start
//        sort.Slice(schedule, func(i, j int) bool {
//            return schedule[i].start < schedule[j].start
//        })
//
//        lo, hi := 0, len(schedule)-1
//        for lo <= hi {
//            mid := (hi+lo)/2
//            if canInsertBeforeMid(schedule, job, mid) || canInsertAfterMid(schedule, job, mid) {
//                return true
//            } else if job.start < schedule[mid].start {
//                hi = mid-1
//            } else {
//                lo = mid+1
//            }
//        }
//        return false
//    }
//
//    func canInsertBeforeMid(schedule []Interval, job Interval, mid int) bool {
//        return job.end <= schedule[mid].start && (mid == 0 || schedule[mid-1].end <= job.start)
//    }
//
//    func canInsertAfterMid(schedule []Interval, job Interval, mid int) bool {
//        return job.start >= schedule[mid].end && (mid == len(schedule)-1 || schedule[mid+1].start >= job.end)
//    }

}
