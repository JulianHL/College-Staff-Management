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

public class AddDepartmentPanel extends JPanel {

  private JLabel nameLabel;
  private JLabel idLabel;
  private JTextField nameField;
  private JTextField idField;
  private JButton addButton;

  public AddDepartmentPanel() {
    setLayout(new GridLayout(11, 2));

    nameLabel = new JLabel("Name:");
    nameField = new JTextField();
    idLabel = new JLabel("ID:");
    idField = new JTextField();
    addButton = new JButton("Add");

    add(idLabel);
    add(idField);
    add(nameLabel);
    add(nameField);
    add(addButton);
  }

  public JLabel getNameLabel() {
    return nameLabel;
  }

  public JLabel getIdLabel() {
    return idLabel;
  }

  public JTextField getNameField() {
    return nameField;
  }

  public JTextField getIdField() {
    return idField;
  }

  public JButton getAddButton() {
    return addButton;
  }
}
