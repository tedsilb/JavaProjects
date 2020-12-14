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
import com.tedsilb.employeemanagement.Protos.Employee;
import com.tedsilb.employeemanagement.Protos.Name;

public class DatastoreUtil {
  private DatastoreUtil() {}
  protected static Datastore getDatastore(final String projectId, final GoogleCredentials creds) {
    return DatastoreOptions.newBuilder()
        .setProjectId(projectId)
        .setCredentials(
            creds.createScoped(ImmutableList.of("https://www.googleapis.com/auth/datastore")))
        .build()
        .getService();
  }

  protected final static String generateEmployeeId(final Datastore datastore) {
    ImmutableList<String> existingIds = listEmployeeIds(datastore)
                                            .stream()
                                            .map(id -> id.replace("employees/", ""))
                                            .collect(toImmutableList());

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
            .set("proto", employee.toString())
            .build());

    return employee;
  }

  protected final static Employee getEmployee(final Datastore datastore, final String id)
      throws InvalidProtocolBufferException {
    final String retrieved =
        datastore.get(datastore.newKeyFactory().setKind("Employee").newKey(id)).getString("proto");

    return Employee.parseFrom(ByteString.copyFromUtf8(retrieved));
  }

  protected final static ImmutableList<Employee> listEmployees(final Datastore datastore) {
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

  protected final static ImmutableList<String> listEmployeeIds(final Datastore datastore) {
    // TODO(tedsilb): make this paginated
    QueryResults<Key> queryResults =
        datastore.run(Query.newKeyQueryBuilder().setKind("Employee").build());

    ImmutableList.Builder<String> employeeIds = new ImmutableList.Builder<String>();

    while (queryResults.hasNext()) {
      employeeIds.add(queryResults.next().getName());
    }

    return employeeIds.build();
  }
}
