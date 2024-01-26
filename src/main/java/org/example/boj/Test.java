package org.example.boj;

public class Test {
  static class A {
    int value;
    void plus() {
      while (value < 1000_0000) {
        value += 1;
      }
      System.out.println("value = " + value);
    }
  }

  static class Worker extends Thread {
    A a;

    public Worker(A a) {
      this.a = a;
    }

    @Override
    public void run() {
      a.plus();
    }
  }

  public static void main(String[] args) {
    A a = new A();
    Worker worker1 = new Worker(a);
    Worker worker2 = new Worker(a);
    Worker worker3 = new Worker(a);
    Worker worker4 = new Worker(a);
    worker1.start();
    worker2.start();
    worker3.start();
    worker4.start();
  }

}
