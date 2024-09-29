/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes.college;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author juldh
 */

public class AddTeacherPanel extends JPanel {

  private JLabel nameLabel;
  private JLabel specialtyLabel;
  private JLabel degreeLabel;
  private JLabel hoursWorkedLabel;
  private JLabel coursesQuantityLabel;
  private JLabel birthyearLabel;
  private JLabel idLabel;
  private JLabel genderLabel;
  private JLabel departmentIdLabel;
  private JTextField nameField;
  private JTextField specialtyField;
  private JTextField degreeField;
  private JTextField hoursWorkedField;
  private JTextField coursesQuantityField;
  private JTextField birthyearField;
  private JTextField idField;
  private JTextField genderField;
  private JTextField departmentIdField;
  private JButton addButton;

  public AddTeacherPanel() {
    setLayout(new GridLayout(11, 2));

    nameLabel = new JLabel("Name:");
    nameField = new JTextField();
    specialtyLabel = new JLabel("Specialty:");
    specialtyField = new JTextField();
    degreeLabel = new JLabel("Degree:");
    degreeField = new JTextField();
    hoursWorkedLabel = new JLabel("Hours Worked:");
    hoursWorkedField = new JTextField();
    coursesQuantityLabel = new JLabel("Courses Quantity Weekly:");
    coursesQuantityField = new JTextField();
    birthyearLabel = new JLabel("Birthyear:");
    birthyearField = new JTextField();
    idLabel = new JLabel("ID:");
    idField = new JTextField();
    genderLabel = new JLabel("Gender:");
    genderField = new JTextField();
    departmentIdLabel = new JLabel("Department ID:");
    departmentIdField = new JTextField();
    addButton = new JButton("Add");

    add(nameLabel);
    add(nameField);
    add(specialtyLabel);
    add(specialtyField);
    add(degreeLabel);
    add(degreeField);
    add(hoursWorkedLabel);
    add(hoursWorkedField);
    add(coursesQuantityLabel);
    add(coursesQuantityField);
    add(birthyearLabel);
    add(birthyearField);
    add(idLabel);
    add(idField);
    add(genderLabel);
    add(genderField);
    add(departmentIdLabel);
    add(departmentIdField);
    add(addButton);
  }

  public JLabel getNameLabel() {
    return nameLabel;
  }

  public JLabel getSpecialtyLabel() {
    return specialtyLabel;
  }

  public JLabel getDegreeLabel() {
    return degreeLabel;
  }

  public JLabel getHoursWorkedLabel() {
    return hoursWorkedLabel;
  }

  public JLabel getCoursesQuantityLabel() {
    return coursesQuantityLabel;
  }

  public JLabel getBirthyearLabel() {
    return birthyearLabel;
  }

  public JLabel getIdLabel() {
    return idLabel;
  }

  public JLabel getGenderLabel() {
    return genderLabel;
  }

  public JLabel getDepartmentIdLabel() {
    return departmentIdLabel;
  }

  public JTextField getNameField() {
    return nameField;
  }

  public JTextField getSpecialtyField() {
    return specialtyField;
  }

  public JTextField getDegreeField() {
    return degreeField;
  }

  public JTextField getHoursWorkedField() {
    return hoursWorkedField;
  }

  public JTextField getCoursesQuantityField() {
    return coursesQuantityField;
  }

  public JTextField getBirthyearField() {
    return birthyearField;
  }

  public JTextField getIdField() {
    return idField;
  }

  public JTextField getGenderField() {
    return genderField;
  }

  public JTextField getDepartmentIdField() {
    return departmentIdField;
  }

  public JButton getAddButton() {
    return addButton;
  }
}
