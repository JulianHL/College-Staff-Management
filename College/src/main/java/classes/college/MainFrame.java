/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes.college;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.*;

/**
 *
 * @author juldh
 */

public class MainFrame extends JFrame {

  private JTabbedPane tabbedPane;
  private AddTeacherPanel addTeacherPanel;
  private AddStaffPanel addStaffPanel;
  private AddDepartmentPanel addDepartmentPanel;
  private JPanel viewPanel;

  public MainFrame() {
    super("Teacher and Department Management");
    tabbedPane = new JTabbedPane();
    addTeacherPanel = new AddTeacherPanel();
    addStaffPanel = new AddStaffPanel();
    addDepartmentPanel = new AddDepartmentPanel();

    tabbedPane.addTab("Add Teacher", addTeacherPanel);
    tabbedPane.addTab("Add Staaff", addStaffPanel);
    tabbedPane.addTab("Add Department", addDepartmentPanel);

    setLayout(new BorderLayout());
    add(tabbedPane, BorderLayout.CENTER);

    setSize(600, 400);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);

    try {
      Teacher.readFromTextFile("personal.txt");
      Staff.readFromTextFile("personal.txt");
    } catch (FileNotFoundException ex) {
      System.err.println("The file was not found.");
    }

    addWindowListener(
      new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
          super.windowClosing(e);
          try {
            DepartmentManager.writeToTextFile("personal.txt");
          } catch (IOException ex) {
            System.err.println("It was impossible to write into the file.");
          }
        }
      }
    );

    addTeacherPanel.getAddButton().addActionListener(e -> addTeacher());
    addStaffPanel.getAddButton().addActionListener(e -> addStaff());
    addDepartmentPanel.getAddButton().addActionListener(e -> addDepartment());
  }

  private void addTeacher() {
    String specialty = addTeacherPanel.getSpecialtyField().getText();
    String degree = addTeacherPanel.getDegreeField().getText();
    int hoursWorked = Integer.parseInt(
      addTeacherPanel.getHoursWorkedField().getText()
    );
    int coursesQuantity = Integer.parseInt(
      addTeacherPanel.getCoursesQuantityField().getText()
    );
    String name = addTeacherPanel.getNameField().getText();
    int birthyear = Integer.parseInt(
      addTeacherPanel.getBirthyearField().getText()
    );
    int id = Integer.parseInt(addTeacherPanel.getIdField().getText());
    String gender = addTeacherPanel.getGenderField().getText();
    int departmentId = Integer.parseInt(
      addTeacherPanel.getDepartmentIdField().getText()
    );

    Teacher teacher = new Teacher(
      specialty,
      degree,
      hoursWorked,
      coursesQuantity,
      name,
      birthyear,
      id,
      gender
    );
    Department department = DepartmentManager.findDepartmentById(departmentId);
    if (department != null) {
      department.addTeacherMap(teacher);
      JOptionPane.showMessageDialog(
        MainFrame.this,
        "Teacher added successfully!"
      );
    } else {
      JOptionPane.showMessageDialog(
        MainFrame.this,
        "Department not found!",
        "Error",
        JOptionPane.ERROR_MESSAGE
      );
    }
  }

  private void addStaff() {
    String duty = addStaffPanel.getDutyField().getText();
    int workLoad = Integer.parseInt(addStaffPanel.getWorkLoadField().getText());
    String name = addStaffPanel.getNameField().getText();
    int birthyear = Integer.parseInt(
      addStaffPanel.getBirthyearField().getText()
    );
    int id = Integer.parseInt(addStaffPanel.getIdField().getText());
    String gender = addStaffPanel.getGenderField().getText();
    int departmentId = Integer.parseInt(
      addStaffPanel.getDepartmentIdField().getText()
    );

    Staff staff = new Staff(duty, workLoad, name, birthyear, id, gender);
    Department department = DepartmentManager.findDepartmentById(departmentId);
    if (department != null) {
      department.addStaffMap(staff);
      JOptionPane.showMessageDialog(
        MainFrame.this,
        "Staff added successfully!"
      );
    } else {
      JOptionPane.showMessageDialog(
        MainFrame.this,
        "Department not found!",
        "Error",
        JOptionPane.ERROR_MESSAGE
      );
    }
  }

  private void addDepartment() {
    String name = addDepartmentPanel.getNameField().getText();
    int id = Integer.parseInt(addDepartmentPanel.getIdField().getText());

    Department departmentContained = DepartmentManager.findDepartmentById(id);
    if (departmentContained != null) {
      JOptionPane.showMessageDialog(
        MainFrame.this,
        "Department already exists!",
        "Error",
        JOptionPane.ERROR_MESSAGE
      );
    } else {
      Department department = new Department(id, name);
	  DepartmentManager.addDepartment(department);
      JOptionPane.showMessageDialog(
        MainFrame.this,
        "Department added successfully!"
      );
    }
  }
}
