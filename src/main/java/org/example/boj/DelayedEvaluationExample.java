package org.example.boj;

import java.util.function.Supplier;

public class DelayedEvaluationExample {
  public static void main(String[] args) {
    System.out.println("------ lazy evaluation ------");
    long start1 = System.currentTimeMillis();
    getLazyValue(true, DelayedEvaluationExample::computeValue);
    getLazyValue(false, DelayedEvaluationExample::computeValue);
    getLazyValue(false, DelayedEvaluationExample::computeValue);
    System.out.println("Time: " + (System.currentTimeMillis() - start1)/1000);

    System.out.println("------ eager evaluation ------");
    long start2 = System.currentTimeMillis();
    getEagerValue(true, computeValue());
    getEagerValue(false, computeValue());
    getEagerValue(false, computeValue());
    System.out.println("Time: " + (System.currentTimeMillis() - start2)/1000);
  }

  private static int computeValue() {
    System.out.println("Computing the value...");
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return 42;
  }

  public static void getLazyValue(boolean valid, Supplier<Integer> supplier) {
    if (valid) {
      System.out.println("Value: " + supplier.get());
    } else {
      System.out.println("Invalid");
    }
  }

  public static void getEagerValue(boolean valid, int value) {
    if (valid) {
      System.out.println("Value: " + value);
    } else {
      System.out.println("Invalid");
    }
  }
}
