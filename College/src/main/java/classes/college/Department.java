/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes.college;

import classes.college.exceptions.InvalidDeanException;
import java.util.HashMap;

/**
 *
 * @author juldh
 */
public class Department {

  private int id;
  private String name;
  private HashMap<Integer, Teacher> teachersMap;
  private HashMap<Integer, Staff> staffMap;
  private Teacher dean;

  public Department(int id, String name) {
    this.id = id;
    this.name = name;
    this.teachersMap = new HashMap<>();
    this.staffMap = new HashMap<>();
    DepartmentManager.addDepartment(this);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public HashMap<Integer, Teacher> getTeachersMap() {
    return teachersMap;
  }

  public void setTeachersMap(HashMap<Integer, Teacher> teachersMap) {
    this.teachersMap = teachersMap;
  }

  public HashMap<Integer, Staff> getStaffMap() {
    return staffMap;
  }

  public void setStaffMap(HashMap<Integer, Staff> staffMap) {
    this.staffMap = staffMap;
  }

  public void addTeacherMap(Teacher teacher) {
    this.teachersMap.put(teacher.getId(), teacher);
    teacher.setDepartmentId(id);
    teacher.setDepartment(name);
  }

  public void addStaffMap(Staff staff) {
    this.staffMap.put(staff.getId(), staff);
    staff.setDepartmentId(id);
    staff.setDepartment(name);
  }

  public Teacher getDean() {
    return dean;
  }

  public void setDean(Teacher dean) throws InvalidDeanException {
    if (dean.getDepartmentId() != this.id) {
      throw new InvalidDeanException(
        dean.toString() + " does not belong to this department."
      );
    }
    this.dean = dean;
  }
}
