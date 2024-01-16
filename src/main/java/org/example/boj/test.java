package org.example.boj;

import java.util.function.Consumer;

public class test {
  public enum Week {
    SATURDAY(GoalPrinter::saturdayGoal),
    SUNDAY(GoalPrinter::sundayGoal),
    MONDAY(GoalPrinter::mondayGoal),
    TUESDAY(GoalPrinter::tuesdayGoal),
    WEDNESDAY(GoalPrinter::wednesdayGoal),
    THURSDAY(GoalPrinter::thursdayGoal),
    FRIDAY(GoalPrinter::fridayGoal);


    public final Consumer<GoalPrinter> consumer;


    Week(Consumer<GoalPrinter> consumer) {
      this.consumer = consumer;
    }
  }

  public static void main(String[] args) {
    Week week = Week.FRIDAY;
    week.consumer.accept(new GoalPrinter());
  }
}
