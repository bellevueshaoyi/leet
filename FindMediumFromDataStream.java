// https://leetcode.com/articles/find-median-from-data-stream/.
// 有几个很有意思的解法.有好几个很好的解法. 比如1) 用两个heap,或者2) 用multiset (which is an AVL balanced tree) + 2 pointers, or 3) 采集小样本, or 4) bucketize
// 注意当queue.isEmpty()的时候,queue.peek() returns null!!
public class MedianFinder {

    private PriorityQueue<Integer> bigHalf;
    private PriorityQueue<Integer> smallHalf;
    /** initialize your data structure here. */
    public MedianFinder() {
        // Min Heap.
        bigHalf = new PriorityQueue<>();
        // Max heap.
        smallHalf = new PriorityQueue<>(10, Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        // Queue.peek() returns null when it's empty!!!!!
        if (smallHalf.size() > 0 && num > smallHalf.peek()) {
            bigHalf.offer(num);
        } else {
            smallHalf.offer(num);
        }
        if (smallHalf.size() > bigHalf.size() + 1) {
            bigHalf.offer(smallHalf.poll());
        } else if (smallHalf.size() < bigHalf.size()) {
            smallHalf.offer(bigHalf.poll());
        }
    }
    
    public double findMedian() {
        if (smallHalf.size()==bigHalf.size()) {
            return (double)(smallHalf.peek()+bigHalf.peek())/2;
        } else {
            return smallHalf.peek();
        }
    }
}


/// c++ version:

class MedianFinder {
    multiset<int> data;
    multiset<int>::iterator lo_median, hi_median;

public:
    MedianFinder()
        : lo_median(data.end())
        , hi_median(data.end())
    {
    }

    void addNum(int num)
    {
        const size_t n = data.size();   // store previous size

        data.insert(num);               // insert into multiset

        if (!n) {
            // no elements before, one element now
            lo_median = hi_median = data.begin();
        }
        else if (n & 1) {
            // odd size before (i.e. lo == hi), even size now (i.e. hi = lo + 1)

            if (num < *lo_median)       // num < lo
                lo_median--;
            else                        // num >= hi
                hi_median++;            // insertion at end of equal range
        }
        else {
            // even size before (i.e. hi = lo + 1), odd size now (i.e. lo == hi)

            if (num > *lo_median && num < *hi_median) {
                lo_median++;                    // num in between lo and hi
                hi_median--;
            }
            else if (num >= *hi_median)         // num inserted after hi
                lo_median++;
            else                                // num <= lo < hi
                lo_median = --hi_median;        // insertion at end of equal range spoils lo
        }
    }

    double findMedian()
    {
        return (*lo_median + *hi_median) * 0.5;
    }
};


/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
