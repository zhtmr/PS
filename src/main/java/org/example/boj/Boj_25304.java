package org.example.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_25304 {

      static FastReader scan = new FastReader();
      //정답은 sb에 append 를 사용하여 출력
      //만약 개행까지 출력하고 싶으면 append('\n')을 추가
      static StringBuilder sb = new StringBuilder();

      public static void main(String[] args) {
          input();
      }
      static void input() {
        int totalPrice = scan.nextInt();
        int totalAmount = scan.nextInt();
        int price = 0;
        int amount = 0;
        int sum = 0;

        for (int i = 0; i < totalAmount; i++) {
          price = scan.nextInt();
          amount = scan.nextInt();
          sum += price * amount;
        }

        if (totalPrice == sum) {
          System.out.println("Yes");
        } else {
          System.out.println("No");
        }

      }



      static class FastReader {
          BufferedReader br;
          StringTokenizer st;
          public FastReader() {
              br = new BufferedReader(new InputStreamReader(System.in));
          }
          public FastReader(String s) throws FileNotFoundException {
              br = new BufferedReader(new FileReader(new File(s)));
          }
          String next() {
              while (st == null || !st.hasMoreElements()) {
                  try {
                      st = new StringTokenizer(br.readLine());
                  } catch (IOException e) {
                      e.printStackTrace();
                  }
              }
              return st.nextToken();
          }
          int nextInt() {
              return Integer.parseInt(next());
          }
          long nextLong() {
              return Long.parseLong(next());
          }
          double nextDouble() {
              return Double.parseDouble(next());
          }
          String nextLine() {
              String str = "";
              try {
                  str = br.readLine();
              } catch (IOException e) {
                  e.printStackTrace();
              }
              return str;
          }
      }


}
