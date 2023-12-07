package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MergeSort {

    public List<Integer> sort(List<Integer> dataList) {
        if (dataList.size() <= 1) {
            return dataList;
        }
        int medium = dataList.size() / 2;
        List<Integer> leftArr = sort(dataList.subList(0, medium));
        List<Integer> rightArr = sort(dataList.subList(medium, dataList.size()));

//        System.out.println("leftArr = " + leftArr);
//        System.out.println("rightArr = " + rightArr);
//        System.out.println("dataList = " + dataList);
        return merge(leftArr, rightArr);
    }

    private List<Integer> merge(List<Integer> leftArr, List<Integer> rightArr) {
        ArrayList<Integer> mergedList = new ArrayList<>();
        int leftPoint = 0;
        int rightPoint = 0;

        // case1 : left/right 둘다 남아있는 경우
        while (leftArr.size() > leftPoint && rightArr.size() > rightPoint) {
            if (leftArr.get(leftPoint) > rightArr.get(rightPoint)) {
                mergedList.add(rightArr.get(rightPoint));
                rightPoint++;
            } else {
                mergedList.add(leftArr.get(leftPoint));
                leftPoint++;
            }
        }

        // case2 : left 남았을때
        while (leftArr.size() > leftPoint) {
            mergedList.add(leftArr.get(leftPoint));
            leftPoint++;
        }
        // case3 : right 남았을때
        while (rightArr.size() > rightPoint) {
            mergedList.add(rightArr.get(rightPoint));
            rightPoint++;
        }
        return mergedList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add((int) (Math.random() * 100));
        }
        List<Integer> sorted = new MergeSort().sort(list);
        System.out.println("sorted = " + sorted);
    }

}
