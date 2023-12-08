package org.example.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_11021 {

      static FastReader scan = new FastReader();
      //정답은 sb에 append 를 사용하여 출력
      //만약 개행까지 출력하고 싶으면 append('\n')을 추가
      static StringBuilder sb = new StringBuilder();

      public static void main(String[] args) throws IOException {
          input();
      }
      static void input() throws IOException {

        int test = scan.nextInt();
        int[] sum = new int[test];
        int index = 1;

        for (int i = 0; i < test; i++) {
          int a = scan.nextInt();
          int b = scan.nextInt();
          sum[i] = a + b;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < sum.length; i++) {
          bw.write("Case #" + (index + i) + ":" + " " + sum[i] + "\n");
        }
        bw.close();
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
