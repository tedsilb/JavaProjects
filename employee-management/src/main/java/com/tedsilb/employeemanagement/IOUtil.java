package com.tedsilb.employeemanagement;

import com.google.auth.oauth2.GoogleCredentials;
import java.io.FileInputStream;
import java.io.IOException;

public class IOUtil {
  private IOUtil() {}
  protected static GoogleCredentials readGoogleCredentialsFromFile(String path) throws IOException {
    return GoogleCredentials.fromStream(new FileInputStream(path));
  }
}
