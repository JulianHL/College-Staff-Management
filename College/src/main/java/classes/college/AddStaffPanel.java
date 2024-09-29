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

public class AddStaffPanel extends JPanel {

  private JLabel nameLabel;
  private JLabel dutyLabel;
  private JLabel workLoadLabel;
  private JLabel birthyearLabel;
  private JLabel idLabel;
  private JLabel genderLabel;
  private JLabel departmentIdLabel;
  private JTextField nameField;
  private JTextField dutyField;
  private JTextField workLoadField;
  private JTextField birthyearField;
  private JTextField idField;
  private JTextField genderField;
  private JTextField departmentIdField;
  private JButton addButton;

  public AddStaffPanel() {
    setLayout(new GridLayout(9, 2));

    nameLabel = new JLabel("Name:");
    nameField = new JTextField();
    dutyLabel = new JLabel("Duty:");
    dutyField = new JTextField();
    workLoadLabel = new JLabel("Work Load:");
    workLoadField = new JTextField();
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
    add(dutyLabel);
    add(dutyField);
    add(workLoadLabel);
    add(workLoadField);
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

  public JLabel getDutyLabel() {
    return dutyLabel;
  }

  public JLabel getWorkLoadLabel() {
    return workLoadLabel;
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

  public JTextField getDutyField() {
    return dutyField;
  }

  public JTextField getWorkLoadField() {
    return workLoadField;
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
