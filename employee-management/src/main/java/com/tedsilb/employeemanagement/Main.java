
package com.tedsilb.employeemanagement;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.datastore.Datastore;
import com.google.common.flogger.FluentLogger;
import com.google.protobuf.InvalidProtocolBufferException;
import com.tedsilb.employeemanagement.Protos.Employee;

import java.io.IOException;
import java.util.Scanner;


public class Main {
  private static final String SERVICE_ACCOUNT_JSON =
      "../employee-management-279606-65a39db74815.json";

  private static final String DATASTORE_PROJECT_ID = "employee-management-279606";

  private static final FluentLogger logger = FluentLogger.forEnclosingClass();

  public static void main(final String[] args) {
    GoogleCredentials creds;
    try {
      creds = IOUtil.readGoogleCredentialsFromFile(SERVICE_ACCOUNT_JSON);
    } catch (IOException e) {
      logger.atSevere().withCause(e).log("Service account file not found.");
      return;
    }

    Datastore datastore = DatastoreUtil.getDatastore(DATASTORE_PROJECT_ID, creds);

    final Scanner scan = new Scanner(System.in);

    System.out.println("Please enter the first name of an Employee to add:");
    final String first = scan.nextLine();

    System.out.println("Please enter the last name of an Employee to add:");
    final String last = scan.nextLine();

    System.out.printf("About to add %s %s. Ok?", first, last);
    scan.nextLine();

    DatastoreUtil.createEmployee(datastore, first, last);

    System.out.println("Please enter an Employee to search for:");
    final String name = scan.nextLine();

    Employee employee;
    try {
      employee = DatastoreUtil.getEmployee(datastore, name);
    } catch (final InvalidProtocolBufferException e) {
      logger.atSevere().withCause(e);
      scan.close();
      return;
    }

    System.out.println(employee.toString());

    scan.close();
  }
}
