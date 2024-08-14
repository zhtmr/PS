package org.example.programmers;

public class p_148653 {
  public int solution(int storey) {
    int answer = 0;
    while (storey > 0) {
      int lastNum = storey % 10;
      if (lastNum > 5 || (lastNum == 5 && (storey / 10) % 10 >= 5)) {
        answer += (10 - lastNum);
        storey += (10 - lastNum);
      } else {
        answer += lastNum;
      }
      storey /= 10;
    }

    System.out.println("storey = " + storey);
    System.out.println(answer);
    return answer;
  }

  public static void main(String[] args) {
    new p_148653().solution(16);
    new p_148653().solution(2554);
    new p_148653().solution(15);
  }
}
