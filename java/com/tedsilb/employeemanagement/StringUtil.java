package com.tedsilb.employeemanagement;

public class StringUtil {
  private StringUtil() {}
  private final static String ALPHA_OPTIONS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
      + "abcdefghijklmnopqrstuvwxyz";
  private final static String ALPHANUM_OPTIONS = ALPHA_OPTIONS + "0123456789";

  protected final static String getRandomString(final String options, final int len) {
    final StringBuilder stringBuilder = new StringBuilder(len);

    for (int i = 0; i < len; i++) {
      final int index = (int) (options.length() * Math.random());
      stringBuilder.append(options.charAt(index));
    }

    return stringBuilder.toString();
  }

  protected final static String getRandomStringAlpha(final int len) {
    return getRandomString(ALPHA_OPTIONS, len);
  }

  protected final static String getRandomStringAlphaNum(final int len) {
    return getRandomString(ALPHANUM_OPTIONS, len);
  }
}
