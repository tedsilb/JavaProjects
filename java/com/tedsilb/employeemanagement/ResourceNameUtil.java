package com.tedsilb.employeemanagement;

class ResourceNameUtil {
  static String employeeNameFromId(String id) {
    return "employees/" + id;
  }

  static String employeeIdFromName(String name) {
    return name.replaceFirst("employees/", "");
  }

  private ResourceNameUtil() {}
}
