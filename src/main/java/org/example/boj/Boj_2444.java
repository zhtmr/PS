package org.example.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2444 {

      static FastReader scan = new FastReader();
      //정답은 sb에 append 를 사용하여 출력
      //만약 개행까지 출력하고 싶으면 append('\n')을 추가
      static StringBuilder sb = new StringBuilder();

      public static void main(String[] args) {
          input();
      }
      static void input(){
        int n = scan.nextInt();
        for (int i = 0; i < (2 * n - 1) >> 1; i++) {
          for (int j = n - 1; j > i; j--) {
            sb.append(" ");
          }
          for (int j = 0; j < 2 * i + 1; j++) {
            sb.append("*");
          }
          sb.append("\n");
        }

        for (int i = 0; i <= (2 * n - 1) >> 1; i++) {
          for (int j = 0; j < i; j++) {
            sb.append(" ");
          }
          for (int j = (2 * n - 1) - 2 * i; j > 0; j--) {
            sb.append("*");
          }
          sb.append("\n");
        }

        System.out.println(sb);

        sb.setLength(0);
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
