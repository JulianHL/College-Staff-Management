/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes.college;

/**
 *
 * @author juldh
 */
public abstract class Person {

  private String name;
  private int birthyear;
  private int id;
  private int departmentId;
  private String gender;
  private String category;
  private String department;

  public Person(
    String name,
    int birthyear,
    int id,
    String gender,
    String category
  ) {
    this.name = name;
    this.birthyear = birthyear;
    this.id = id;
    this.gender = gender;
    this.category = category;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getBirthyear() {
    return birthyear;
  }

  public void setBirthyear(int birthyear) {
    this.birthyear = birthyear;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(int departmentId) {
    this.departmentId = departmentId;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getCategory() {
    this.setCategory();
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public abstract void setCategory();

  @Override
  public String toString() {
    return (
      "Person{" +
      "name=" +
      name +
      ", birthyear=" +
      birthyear +
      ", id=" +
      id +
      ", departmentId=" +
      departmentId +
      ", gender=" +
      gender +
      ", category="
    );
  }
}
