package com.tedsilb.employeemanagement;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.ProjectionEntity;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.common.collect.Lists;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.tedsilb.employeemanagement.Protos.Employee;
import com.tedsilb.employeemanagement.Protos.Name;
import java.util.ArrayList;

public class DatastoreUtil {
  private DatastoreUtil() {}
  protected static Datastore getDatastore(final String projectId, final GoogleCredentials creds) {
    return DatastoreOptions.newBuilder()
        .setProjectId(projectId)
        .setCredentials(
            creds.createScoped(Lists.newArrayList("https://www.googleapis.com/auth/datastore")))
        .build()
        .getService();
  }

  protected final static String generateEmployeeId(final Datastore datastore) {
    ArrayList<String> existingIds = listEmployeeIds(datastore);
    existingIds.replaceAll(id -> id.replace("employees/", ""));

    String newId;
    do {
      newId = StringUtil.getRandomStringAlpha(10);
    } while (existingIds.contains(newId));

    return "employees/" + newId;
  }

  protected final static Employee createEmployee(
      final Datastore datastore, final String first, final String last) {
    final Employee employee =
        Employee.newBuilder()
            .setId(generateEmployeeId(datastore))
            .setName(Name.newBuilder().setFirst(first).setMiddle("").setLast(last).build())
            .build();

    datastore.put(
        Entity.newBuilder(datastore.newKeyFactory().setKind("Employee").newKey(employee.getId()))
            .set("proto", employee.toByteString().toStringUtf8())
            .build());

    return employee;
  }

  protected final static Employee getEmployee(final Datastore datastore, final String id)
      throws InvalidProtocolBufferException {
    final String retrieved =
        datastore.get(datastore.newKeyFactory().setKind("Employee").newKey(id)).getString("proto");

    return Employee.parseFrom(ByteString.copyFromUtf8(retrieved));
  }

  protected final static ArrayList<Employee> listEmployees(final Datastore datastore) {
    // TODO(tedsilb): make this paginated
    QueryResults<ProjectionEntity> queryResults = datastore.run(
        Query.newProjectionEntityQueryBuilder().setKind("Employee").setProjection("proto").build());

    ArrayList<Employee> employees = new ArrayList<Employee>();

    while (queryResults.hasNext()) {
      try {
        employees.add(
            Employee.parseFrom(ByteString.copyFromUtf8(queryResults.next().getString("proto"))));
      } catch (InvalidProtocolBufferException e) {
        // If we get an invalid protobuf, ignore it - nothing we can do.
      }
    }

    return employees;
  }

  protected final static ArrayList<String> listEmployeeIds(final Datastore datastore) {
    // TODO(tedsilb): make this paginated
    QueryResults<Key> queryResults =
        datastore.run(Query.newKeyQueryBuilder().setKind("Employee").build());

    ArrayList<String> employeeIds = new ArrayList<String>();

    while (queryResults.hasNext()) {
      employeeIds.add(queryResults.next().getName());
    }

    return employeeIds;
  }
}
