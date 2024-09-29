/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes.college;

/**
 *
 * @author juldh
 */
public class FullTimeTeacher extends Teacher {

  public FullTimeTeacher(
    String specialty,
    String degree,
    String name,
    int birthyear,
    int id,
    String gender
  ) {
    super(specialty, degree, 32, 4, name, birthyear, id, gender);
  }

  @Override
  public double computePayroll() {
    return (this.getHoursWorked() * this.getDegreeRate() * 2) * 0.85;
  }

  @Override
  public String toString() {
    return "FullTimeTeacher{" + super.toString() + '}';
  }
}
