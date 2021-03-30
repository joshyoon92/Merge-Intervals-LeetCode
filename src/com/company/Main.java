package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] ans = merge(intervals);
        for (int[] i: ans){
            System.out.println(Arrays.toString(i));
        }
    }
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
        LinkedList<int[]> ans = new LinkedList<>();

        for (int[] interval: intervals){
            if (ans.isEmpty() || ans.getLast()[1] < interval[0]){
                ans.add(interval);
            }
            else {
                ans.getLast()[1] = Math.max(ans.getLast()[1], interval[1]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
