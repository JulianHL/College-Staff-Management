/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes.college;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author juldh
 */
public class DepartmentManager {

  private static HashMap<Integer, Department> departmentsMap = new HashMap<>();

  /**
   * The addDepartment function adds a Department object to a map using the department's ID as the key.
   *
   * @param department The `addDepartment` method takes a `Department` object as a parameter. This
   * `Department` object represents the department that you want to add to the `departmentsMap` in the
   * `DepartmentManager` class.
   */
  public static void addDepartment(Department department) {
    DepartmentManager.departmentsMap.put(department.getId(), department);
  }

  // These two methods in the `DepartmentManager` class are getter and setter methods for the
  // `departmentsMap` field, which is a static HashMap storing Department objects with Integer keys.
  public static HashMap<Integer, Department> getDepartmentsMap() {
    return departmentsMap;
  }

  public static void setDepartmentsMap(
    HashMap<Integer, Department> departmentsMap
  ) {
    DepartmentManager.departmentsMap = departmentsMap;
  }

  public static Department findDepartmentById(int departmentId) {
    for (Department department : DepartmentManager
      .getDepartmentsMap()
      .values()) {
      if (department.getId() == departmentId) {
        return department;
      } else {
        System.out.println(
          "the department was not found, its id is: " + departmentId
        );
      }
    }
    return null;
  }

  public static void writeToTextFile(String filename) throws IOException {
    try (FileWriter writer = new FileWriter(filename)) {
      for (Department department : departmentsMap.values()) {
        for (Teacher teacher : department.getTeachersMap().values()) {
          String line = String.format(
            "Teacher,%s,%s,%d,%d,%s,%d,%d,%s,%d,%s\n",
            teacher.getSpecialty(),
            teacher.getDegree(),
            teacher.getHoursWorked(),
            teacher.getCoursesQuantityWeekly(),
            teacher.getName(),
            teacher.getBirthyear(),
            teacher.getId(),
            teacher.getGender(),
            teacher.getDepartmentId(),
            teacher.getDepartment()
          );
          writer.write(line);
        }
      }
      for (Department department : departmentsMap.values()) {
        for (Staff staff : department.getStaffMap().values()) {
          String line = String.format(
            "Staff,%s,%d,%s,%d,%d,%s,%d,%s\n",
            staff.getDuty(),
            staff.getWorkLoad(),
            staff.getName(),
            staff.getBirthyear(),
            staff.getId(),
            staff.getGender(),
            staff.getDepartmentId(),
            staff.getDepartment()
          );
          writer.write(line);
        }
      }
    } catch (IOException ex) {
      System.err.println("it was impossible to write into the file" + filename);
      throw ex;
    }
  }
}
