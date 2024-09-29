/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes.college;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author juldh
 */
public class Staff extends Person implements PayRoll {

  private String duty;
  private int workLoad;

  public Staff(
    String duty,
    int workLoad,
    String name,
    int birthyear,
    int id,
    String gender
  ) {
    super(name, birthyear, id, gender, "Staff");
    this.duty = duty;
    this.workLoad = workLoad;
  }

  // These methods in the `Staff` class are responsible for managing the duty, work load, category, and
  // payroll computation for a staff member.
  public String getDuty() {
    return duty;
  }

  public void setDuty(String duty) {
    this.duty = duty;
  }

  public int getWorkLoad() {
    return workLoad;
  }

  public void setWorkLoad(int workLoad) {
    this.workLoad = workLoad;
  }

  @Override
  public void setCategory() {
    super.setCategory("Staff");
  }

  @Override
  public double computePayroll() {
    return (workLoad * 32 * 2) * 0.75;
  }

  /**
   * The `toString` method is overridden to include additional information specific to a `Staff` object
   * in Java.
   *
   * @return The `toString()` method is being overridden to return a string representation of the
   * object. The returned string includes the result of calling the superclass's `toString()` method,
   * along with additional information specific to the `Staff` class such as duty and workLoad.
   */
  @Override
  public String toString() {
    return (
      super.toString() +
      "Staff{" +
      "duty=" +
      duty +
      ", workLoad=" +
      workLoad +
      "}}"
    );
  }

  public static void readFromTextFile(String personalFile)
    throws FileNotFoundException {
    try (Scanner scanner = new Scanner(new File(personalFile))) {
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        String[] parts = line.split(",");
        if (parts.length == 9 && parts[0].equals("Staff")) {
          String duty = parts[1];
          int workLoad = Integer.parseInt(parts[2]);
          String name = parts[3];
          int birthyear = Integer.parseInt(parts[4]);
          int id = Integer.parseInt(parts[5]);
          String gender = parts[6];
          int departmentId = Integer.parseInt(parts[7]);
          String departmentName = parts[8];

          Staff staff = new Staff(duty, workLoad, name, birthyear, id, gender);
          staff.setDepartmentId(departmentId);

          Department department = DepartmentManager.findDepartmentById(
            departmentId
          );
          if (department != null) {
            department.addStaffMap(staff);
          } else {
            department = new Department(departmentId, departmentName);
            DepartmentManager.addDepartment(department);
            department.addStaffMap(staff);
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
