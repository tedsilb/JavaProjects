package com.tedsilb.employeemanagement;

class StringUtil {
  private static final String ALPHA_OPTIONS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
      + "abcdefghijklmnopqrstuvwxyz";
  private static final String ALPHANUM_OPTIONS = ALPHA_OPTIONS + "0123456789";

  static String getRandomStringAlpha(int len) {
    return getRandomString(ALPHA_OPTIONS, len);
  }

  static String getRandomStringAlphaNum(int len) {
    return getRandomString(ALPHANUM_OPTIONS, len);
  }

  private static String getRandomString(String options, int len) {
    StringBuilder stringBuilder = new StringBuilder(len);

    for (int i = 0; i < len; i++) {
      int index = (int) (options.length() * Math.random());
      stringBuilder.append(options.charAt(index));
    }

    return stringBuilder.toString();
  }

  private StringUtil() {}
}
