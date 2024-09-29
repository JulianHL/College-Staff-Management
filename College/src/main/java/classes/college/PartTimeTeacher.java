/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes.college;

/**
 *
 * @author juldh
 */
public class PartTimeTeacher extends Teacher {

  public PartTimeTeacher(
    String specialty,
    String degree,
    int hoursWorked,
    String name,
    int birthyear,
    int id,
    String gender
  ) {
    super(specialty, degree, hoursWorked, 2, name, birthyear, id, gender);
  }

  @Override
  public double computePayroll() {
    return (this.getHoursWorked() * this.getDegreeRate() * 2) * 0.76;
  }

  @Override
  public String toString() {
    return "PartTimeTeacher{" + super.toString() + '}';
  }
}
