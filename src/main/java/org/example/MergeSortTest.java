package org.example;

import java.util.ArrayList;
import java.util.List;

public class MergeSortTest {
  public List<Integer> sort(List<Integer> list) {
    if (list.size() <= 1) {
      return list;
    }
    int mid = list.size() / 2;
    List<Integer> leftArr = sort(new ArrayList<>(list.subList(0, mid)));
    List<Integer> rightArr = sort(new ArrayList<>(list.subList(mid, list.size())));
    return merge(leftArr, rightArr);
  }

  public List<Integer> merge(List<Integer> leftArr, List<Integer> rightArr) {
    ArrayList<Integer> mergeList = new ArrayList<>();
    int leftPoint = 0;
    int rightPoint = 0;

    while (leftArr.size() > leftPoint && rightArr.size() > rightPoint) {
      if (leftArr.get(leftPoint) > rightArr.get(rightPoint)) {
        mergeList.add(rightArr.get(rightPoint));
        rightPoint++;
      } else {
        mergeList.add(leftArr.get(leftPoint));
        leftPoint++;
      }
    }

    while (leftArr.size() > leftPoint) {
      mergeList.add(leftArr.get(leftPoint));
      leftPoint++;
    }

    while (rightArr.size() > rightPoint) {
      mergeList.add(rightArr.get(rightPoint));
      rightPoint++;
    }

    return mergeList;
  }

  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < 100; i++) {
      list.add((int) (Math.random() * 100));
    }
    System.out.println(new MergeSortTest().sort(list));
  }
}
