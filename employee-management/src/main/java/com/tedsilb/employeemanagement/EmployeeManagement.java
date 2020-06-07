
package com.tedsilb.employeemanagement;

import com.google.common.collect.ImmutableMap;
import java.util.Random;

public class EmployeeManagement {
  private enum Language { ENGLISH, GERMAN, SPANISH }
  ;

  private final static ImmutableMap<Language, String> languageToGreetingMap =
      ImmutableMap.<Language, String>builder()
          .put(Language.ENGLISH, "Hello World!")
          .put(Language.GERMAN, "Hallo Welt!")
          .put(Language.SPANISH, "Hola Mundo!")
          .build();

  public static String getRandomGreeting() {
    final Language randomLanguage =
        Language.values()[new Random().nextInt(Language.values().length)];
    return languageToGreetingMap.get(randomLanguage);
  }

  public static void main(final String[] args) {
    System.out.println(getRandomGreeting());
  }
}
