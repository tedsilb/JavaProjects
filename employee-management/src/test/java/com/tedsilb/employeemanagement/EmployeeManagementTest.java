
package com.tedsilb.employeemanagement;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("EmployeeManagement")
public class EmployeeManagementTest {
  @Test
  @DisplayName("Make sure getRandomGreeting returns something")
  void testGetRandomGreeting_returnsSomething() {
    String greeting = EmployeeManagement.getRandomGreeting();
    assertThat(greeting).isNotEmpty();
  }
}
