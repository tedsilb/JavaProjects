
package com.tedsilb.employeemanagement;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("EmployeeManagement")
public class MainTest {
  @Test
  @DisplayName("Smoke test")
  void smokeTest() {
    assertThat(true).isEqualTo(true);
  }
}
