package com.tedsilb.employeemanagement;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.datastore.Datastore;
import com.google.common.collect.ImmutableList;
import com.google.common.flogger.FluentLogger;
import com.google.protobuf.InvalidProtocolBufferException;
import com.tedsilb.employeemanagement.proto.EmployeeProto.Employee;
import java.io.IOException;
import java.util.Scanner;

public class Main {
  private static final FluentLogger logger = FluentLogger.forEnclosingClass();
  private static final String DATASTORE_PROJECT_ID = "employee-management-279606";

  public static void main(String[] args) {
    GoogleCredentials creds;
    try {
      creds = GoogleCredentials.getApplicationDefault();
    } catch (IOException e) {
      logger.atSevere().withCause(e).log("Unable to retrieve credentials. "
          + "Try logging in with `gcloud auth application-default login`.");
      return;
    }

    Datastore datastore = DatastoreUtil.getDatastore(DATASTORE_PROJECT_ID, creds);

    Scanner scan = new Scanner(System.in);

    System.out.println("Please enter the operation to perform [create/get/delete/list]:");
    String operation = scan.nextLine();
    if (operation.equals("create")) {
      System.out.println("Please enter the first name of an Employee to add:");
      String first = scan.nextLine();

      System.out.println("Please enter the last name of an Employee to add:");
      String last = scan.nextLine();

      System.out.printf("About to add %s %s. Ok?", first, last);
      scan.nextLine();

      DatastoreUtil.createEmployee(datastore, first, last);
    } else if (operation.equals("get")) {
      System.out.println("Please enter an Employee ID to retrieve (in format 'employees/{id}'):");
      String id = scan.nextLine();

      Employee employee;
      try {
        employee = DatastoreUtil.getEmployee(datastore, id);
      } catch (InvalidProtocolBufferException e) {
        logger.atSevere().withCause(e).log("Invalid protobuf retrieved from database.");
        scan.close();
        return;
      }

      System.out.println(employee.toString());
    } else if (operation.equals("delete")) {
      System.out.println("Please enter an Employee ID to delete (in format 'employees/{id}'):");
      String id = scan.nextLine();

      System.out.println(String.format("About to delete employee %s. Are you sure?", id));
      scan.nextLine();
      DatastoreUtil.deleteEmployee(datastore, id);
      System.out.println(String.format("Deleted employee %s.", id));
    } else if (operation.equals("list")) {
      ImmutableList<String> employeeIds = DatastoreUtil.listEmployeeIds(datastore);
      System.out.println("All employee IDs:");
      System.out.println(String.format("%s", employeeIds));
    }

    scan.close();
  }
}
