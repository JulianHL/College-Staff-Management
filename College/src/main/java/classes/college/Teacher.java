/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes.college;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author juldh
 */
public class Teacher extends Person implements PayRoll {

  private String specialty;
  private String degree;
  private int degreeRate;
  private int hoursWorked;
  private int coursesQuantityWeekly;

  public Teacher(
    String specialty,
    String degree,
    int hoursWorked,
    int coursesQuantityWeekly,
    String name,
    int birthyear,
    int id,
    String gender
  ) {
    super(name, birthyear, id, gender, "Teacher");
    this.specialty = specialty;
    this.degree = degree;
    this.hoursWorked = hoursWorked;
    this.coursesQuantityWeekly = coursesQuantityWeekly;
    switch (degree.toLowerCase()) {
      case "phd":
        this.degreeRate = 112;
        break;
      case "master":
        this.degreeRate = 82;
        break;
      case "bachelor":
        this.degreeRate = 42;
      default:
        this.degreeRate = 0;
        break;
    }
  }

  // These methods in the `Teacher` class are getter and setter methods for various attributes of a
  // teacher object:
  public String getSpecialty() {
    return specialty;
  }

  public void setSpecialty(String specialty) {
    this.specialty = specialty;
  }

  public String getDegree() {
    return degree;
  }

  public void setDegree(String degree) {
    this.degree = degree;
  }

  public int getHoursWorked() {
    return hoursWorked;
  }

  public void setHoursWorked(int workHours) {
    this.hoursWorked = workHours;
  }

  public int getCoursesQuantityWeekly() {
    return coursesQuantityWeekly;
  }

  public void setCoursesQuantityWeekly(int coursesQuantity) {
    this.coursesQuantityWeekly = coursesQuantity;
  }

  public int getDegreeRate() {
    return degreeRate;
  }

  public void setDegreeRate(int degreeRate) {
    this.degreeRate = degreeRate;
  }

  @Override
  public void setCategory() {
    super.setCategory("Teacher");
  }

  /**
   * The `computePayroll` method calculates the payroll based on hours worked and degree rate, applying
   * different multipliers depending on the hours worked.
   *
   * @return The `computePayroll` method is returning the calculated payroll amount based on the number
   * of hours worked and the degree rate of the employee. If the hours worked are greater than 31, the
   * payroll amount is calculated as `(hoursWorked * degreeRate * 2) * 0.85`, otherwise it is calculated
   * as `(hoursWorked * degreeRate * 2) * 0.76
   */
  @Override
  public double computePayroll() {
    if (this.getHoursWorked() > 31) {
      return (this.getHoursWorked() * this.getDegreeRate() * 2) * 0.85;
    } else {
      return (this.getHoursWorked() * this.getDegreeRate() * 2) * 0.76;
    }
  }

  /**
   * The toString method overrides the default implementation to provide a custom string representation
   * of a Teacher object.
   *
   * @return The `toString` method is being overridden to return a string representation of the object's
   * state. It concatenates the result of calling the superclass's `toString` method with additional
   * information specific to a `Teacher` object, such as specialty, degree, degree rate, hours worked,
   * and courses quantity weekly.
   */
  @Override
  public String toString() {
    return (
      super.toString() +
      "Teacher{" +
      ", specialty=" +
      specialty +
      ", degree=" +
      degree +
      ", degreeRate=" +
      degreeRate +
      ", hoursWorked=" +
      hoursWorked +
      ", coursesQuantityWeekly=" +
      coursesQuantityWeekly +
      "}}"
    );
  }

  /**
   * The function `readFromTextFile` reads data from a text file, parses the information for teachers,
   * creates teacher objects, assigns them to departments, and handles exceptions for file not found or
   * incorrect format.
   *
   * @param filename The `readFromTextFile` method reads data from a text file with the given filename.
   * The file is expected to contain information about teachers in a specific format. The method reads
   * each line, splits it by commas, and then creates `Teacher` objects based on the parsed data.
   */
  public static void readFromTextFile(String personalFile)
    throws FileNotFoundException {
    try (Scanner scanner = new Scanner(new FileReader(personalFile))) {
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        String[] parts = line.split(",");
        if (parts.length == 11 && parts[0].equals("Teacher")) {
          String specialty = parts[1];
          String degree = parts[2];
          int hoursWorked = Integer.parseInt(parts[3]);
          int coursesQuantityWeekly = Integer.parseInt(parts[4]);
          String name = parts[5];
          int birthyear = Integer.parseInt(parts[6]);
          int id = Integer.parseInt(parts[7]);
          String gender = parts[8];
          int departmentId = Integer.parseInt(parts[9]);
          String departmentName = parts[10];

          Teacher teacher = new Teacher(
            specialty,
            degree,
            hoursWorked,
            coursesQuantityWeekly,
            name,
            birthyear,
            id,
            gender
          );
          teacher.setDepartmentId(departmentId);

          Department department = DepartmentManager.findDepartmentById(
            departmentId
          );
          
          if (department != null) {
            department.addTeacherMap(teacher);
          } else {
            department = new Department(departmentId, departmentName);
            DepartmentManager.addDepartment(department);
            department.addTeacherMap(teacher);
          }
        }
      }
    } catch (FileNotFoundException ex) {
      System.err.println("the file wasn't found: " + personalFile);
      throw ex;
    } catch (NumberFormatException ex) {
      System.err.println("the file format is wrong: " + personalFile);
      throw ex;
    }
  }
}
