//package org.example.programmers;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class SeesawPairs {
//
//    static class Solution {
//        public long solution(int[] weights) {
//            long answer = 0;
//            ArrayList<Integer> list = new ArrayList<>();
//            Arrays.stream(weights).forEach(list::add);
//            List<Integer> collect = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
//            int[] mod = {2, 3, 4};
//
//            System.out.println(collect);
//
//
//            for (int i = collect.size() -1; i > 0 ; i--) {
//                for (int j = 0; j < i; j++) {
//                    Integer a = collect.get(j);
//                    Integer b = collect.get(j + 1);
//                    int q = Math.floorMod(a, b);
//                    for (int k = 0; k < mod.length; k++) {
//                        if (mod[k] * q == a) {
//                            answer++;
//                        }
//                    }
//                }
//            }
//
//            return answer;
//        }
//    }
//
//    public static void main(String[] args) {
//        int[] ints = new int[]{100,180,360,100,270};
////
//        long solution = new Solution().solution(ints);
//
//        System.out.println(solution);
//
//    }
//}
