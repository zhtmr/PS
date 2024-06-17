package org.example;

import java.util.*;

public class Assign {
  public static void main(String[] args) {
    // 패턴 리스트
    List<String> creationPatterns = List.of("Singleton", "Factory Method", "Abstract Factory", "Builder", "Prototype");
    List<String> structuralPatterns = List.of("Adapter", "Bridge", "Composite", "Decorator", "Facade", "Flyweight", "Proxy");
    List<String> behavioralPatterns = List.of("Chain of Responsibility", "Command", "Interpreter", "Iterator", "Mediator", "Memento", "Observer", "State", "Strategy", "Template Method", "Visitor");

    // 전체 패턴 리스트
    List<String> allPatterns = new ArrayList<>();
    allPatterns.addAll(creationPatterns);
    allPatterns.addAll(structuralPatterns);
    allPatterns.addAll(behavioralPatterns);

    // 패턴 섞기
    Collections.shuffle(allPatterns);

    // 담당자 리스트
    List<String> developers = List.of("J", "S", "C", "Y");

    // 담당자별 패턴 맵
    Map<String, List<String>> assignments = new HashMap<>();
    for (String developer : developers) {
      assignments.put(developer, new ArrayList<>());
    }

    // 패턴 분배
    for (int i = 0; i < allPatterns.size(); i++) {
      String developer = developers.get(i % developers.size());
      assignments.get(developer).add(allPatterns.get(i));
    }

    // 결과 출력
    assignments.forEach((key, value) -> System.out.println(key + ": " + value));
  }
}
