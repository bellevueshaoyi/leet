// https://leetcode.com/problems/frog-jump/.
// See the 4 solutions at https://leetcode.com/articles/frog-jump/.

// Solution 1. Brute force. O(3^n).
public class Solution {
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0) {
            return true;
        }
        Map<Integer, Set<Integer>> path = new HashMap<>();
        for (int i=0; i<stones.length; ++i) {
            path.put(stones[i], new HashSet<Integer>());
        }
        path.get(stones[0]).add(0);
        for (int i=0; i<stones.length; ++i) {
            int val = stones[i];
            for (int k : path.get(val)) {
                for (int jumpsize = k-1; jumpsize <=k+1; ++jumpsize) {
                    if (jumpsize != 0 && path.containsKey(val + jumpsize)) {
                        path.get(val+jumpsize).add(jumpsize);
                    }
                }
            }
        }
        return path.get(stones[stones.length-1]).size() > 0;
    }
}

// Solution 2. Brute force with memory.  O(n^2)
// Complexity is O(n^2) because some of the recursive calls return in O(1), which cuts O(3^n) of brute force to O(n^2).
// It's common to use memorization to optimize DP with brute force.
public class Solution {
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0) {
            return true;
        }
        Map<Integer, Set<Integer>> path = new HashMap<>();
        for (int i=0; i<stones.length; ++i) {
            path.put(stones[i], new HashSet<Integer>());
        }
        path.get(stones[0]).add(0);
        for (int i=0; i<stones.length; ++i) {
            int val = stones[i];
            for (int k : path.get(val)) {
                for (int jumpsize = k-1; jumpsize <=k+1; ++jumpsize) {
                    if (jumpsize != 0 && path.containsKey(val + jumpsize)) {
                        path.get(val+jumpsize).add(jumpsize);
                    }
                }
            }
        }
        return path.get(stones[stones.length-1]).size() > 0;
    }
}

// Solution 3. DP
public class Solution {
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0) {
            return true;
        }
        Map<Integer, Set<Integer>> path = new HashMap<>();
        for (int i=0; i<stones.length; ++i) {
            path.put(stones[i], new HashSet<Integer>());
        }
        path.get(stones[0]).add(0);
        for (int i=0; i<stones.length; ++i) {
            int val = stones[i];
            for (int k : path.get(val)) {
                for (int jumpsize = k-1; jumpsize <=k+1; ++jumpsize) {
                    if (jumpsize != 0 && path.containsKey(val + jumpsize)) {   // !. Check jumpsize!=0, o.w. concurrentModify exception!
                        path.get(val+jumpsize).add(jumpsize);
                    }
                }
            }
        }
        return path.get(stones[stones.length-1]).size() > 0;
    }
}
