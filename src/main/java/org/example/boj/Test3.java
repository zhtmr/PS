package org.example.boj;

import java.util.concurrent.TimeUnit;

public class Test3 {
  private static boolean stopReq;

  public static void main(String[] args) throws InterruptedException {
    Thread thread = new Thread(() -> {
      int i = 0;
      while (!stopReq)
        i++;
    });
    thread.start();

    TimeUnit.SECONDS.sleep(1);
    stopReq = true;
  }
}
