package com.tedsilb.employeemanagement;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;

public class ResourceNameUtilTest {
  @Test
  public void employeeNameFromId_givenId_returnsExpected() throws Exception {
    String name = ResourceNameUtil.employeeNameFromId("abc123");

    assertThat(name).isEqualTo("employees/abc123");
  }

  @Test
  public void employeeIdFromName_givenName_returnsExpected() throws Exception {
    String id = ResourceNameUtil.employeeIdFromName("employees/abc123");

    assertThat(id).isEqualTo("abc123");
  }
}
