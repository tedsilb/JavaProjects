package com.tedsilb.employeemanagement;

import static com.google.common.collect.ImmutableList.toImmutableList;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.ProjectionEntity;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.tedsilb.employeemanagement.proto.EmployeeProto.Employee;
import java.nio.charset.StandardCharsets;

class DatastoreUtil {
  private static final ImmutableList<String> DATASTORE_SCOPES =
      ImmutableList.of("https://www.googleapis.com/auth/datastore");

  static Datastore getDatastore(String projectId, GoogleCredentials creds) {
    return DatastoreOptions.newBuilder()
        .setProjectId(projectId)
        .setCredentials(creds.createScoped(DATASTORE_SCOPES))
        .build()
        .getService();
  }

  static Employee createEmployee(Datastore datastore, String first, String last) {
    Employee employee =
        Employee.newBuilder()
            .setId(generateEmployeeId(datastore))
            .setName(Employee.Name.newBuilder().setFirst(first).setMiddle("").setLast(last).build())
            .build();

    datastore.put(
        Entity.newBuilder(datastore.newKeyFactory().setKind("Employee").newKey(employee.getId()))
            .set("proto", new String(employee.toByteArray(), StandardCharsets.US_ASCII))
            .build());

    return employee;
  }

  static void deleteEmployee(Datastore datastore, String id) {
    datastore.delete(datastore.newKeyFactory().setKind("Employee").newKey(id));
  }

  static Employee getEmployee(Datastore datastore, String id)
      throws InvalidProtocolBufferException {
    Key key = datastore.newKeyFactory().setKind("Employee").newKey(id);
    Entity retrieved = datastore.get(key);
    if (retrieved == null) {
      throw new IllegalArgumentException("");
    }

    return Employee.parseFrom(ByteString.copyFromUtf8(retrieved.getString("proto")));
  }

  static ImmutableList<Employee> listEmployees(Datastore datastore) {
    // TODO(tedsilb): make this paginated
    QueryResults<ProjectionEntity> queryResults = datastore.run(
        Query.newProjectionEntityQueryBuilder().setKind("Employee").setProjection("proto").build());

    ImmutableList.Builder<Employee> employees = new ImmutableList.Builder<Employee>();

    while (queryResults.hasNext()) {
      try {
        employees.add(
            Employee.parseFrom(ByteString.copyFromUtf8(queryResults.next().getString("proto"))));
      } catch (InvalidProtocolBufferException e) {
        // If we get an invalid proto, ignore it - nothing we can do.
      }
    }

    return employees.build();
  }

  static ImmutableList<String> listEmployeeIds(Datastore datastore) {
    // TODO(tedsilb): make this paginated
    QueryResults<Key> queryResults =
        datastore.run(Query.newKeyQueryBuilder().setKind("Employee").build());

    ImmutableList.Builder<String> employeeIds = ImmutableList.builder();

    while (queryResults.hasNext()) {
      employeeIds.add(queryResults.next().getName());
    }

    return employeeIds.build();
  }

  private static String generateEmployeeId(Datastore datastore) {
    ImmutableList<String> existingIds = listEmployeeIds(datastore)
                                            .stream()
                                            .map(ResourceNameUtil::employeeIdFromName)
                                            .collect(toImmutableList());

    String newId;
    do {
      newId = StringUtil.getRandomStringAlpha(10);
    } while (existingIds.contains(newId));

    return ResourceNameUtil.employeeNameFromId(newId);
  }

  private DatastoreUtil() {}
}
