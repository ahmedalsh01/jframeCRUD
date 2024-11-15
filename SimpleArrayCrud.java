import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleArrayCrud extends JFrame {

    // Declare text fields
    private JTextField txtPatientID;
    private JTextField txtFirstName;
    private JTextField txtLastName;
    private JTextField txtAge;
    private JTextField txtPhoneNumber;
    private JTextField txtAddress;
    private JTextField txtDisease;

    // Buttons for CRUD operations
    private JButton btnCreate;
    private JButton btnRead;
    private JButton btnUpdate;
    private JButton btnDelete;

    // Table for displaying patients
    private JTable patientTable;
    private DefaultTableModel tableModel;

    public SimpleArrayCrud() {
        setTitle("Patient Form");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Form Panel
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(9, 2, 10, 10));

        // Initialize components
        JLabel lblPatientID = new JLabel("Patient ID:");
        txtPatientID = new JTextField();

        JLabel lblFirstName = new JLabel("First Name:");
        txtFirstName = new JTextField();

        JLabel lblLastName = new JLabel("Last Name:");
        txtLastName = new JTextField();

        JLabel lblAge = new JLabel("Age:");
        txtAge = new JTextField();

        JLabel lblPhoneNumber = new JLabel("Phone Number:");
        txtPhoneNumber = new JTextField();

        JLabel lblAddress = new JLabel("Address:");
        txtAddress = new JTextField();

        JLabel lblDisease = new JLabel("Disease:");
        txtDisease = new JTextField();

        btnCreate = new JButton("Create");
        btnRead = new JButton("Read");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");

        // Add components to the form panel
        formPanel.add(lblPatientID);
        formPanel.add(txtPatientID);
        formPanel.add(lblFirstName);
        formPanel.add(txtFirstName);
        formPanel.add(lblLastName);
        formPanel.add(txtLastName);
        formPanel.add(lblAge);
        formPanel.add(txtAge);
        formPanel.add(lblPhoneNumber);
        formPanel.add(txtPhoneNumber);
        formPanel.add(lblAddress);
        formPanel.add(txtAddress);
        formPanel.add(lblDisease);
        formPanel.add(txtDisease);
        formPanel.add(btnCreate);
        formPanel.add(btnRead);
        formPanel.add(btnUpdate);
        formPanel.add(btnDelete);

        // Table Panel
        String[] columnNames = {"Patient ID", "First Name", "Last Name", "Age", "Phone", "Address", "Disease"};
        tableModel = new DefaultTableModel(columnNames, 0);
        patientTable = new JTable(tableModel);

        JScrollPane tableScrollPane = new JScrollPane(patientTable);

        // Add action listeners to buttons
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createPatient();
            }
        });

        btnRead.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                readPatient();
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updatePatient();
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletePatient();
            }
        });

        // Add panels to the frame
        add(formPanel, BorderLayout.NORTH);
        add(tableScrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    // CRUD Operation Methods
    private void createPatient() {
        // Add patient to table
        String[] patientData = {
                txtPatientID.getText(),
                txtFirstName.getText(),
                txtLastName.getText(),
                txtAge.getText(),
                txtPhoneNumber.getText(),
                txtAddress.getText(),
                txtDisease.getText()
        };
        tableModel.addRow(patientData);

        JOptionPane.showMessageDialog(this, "Patient Created!");
        clearFields();
    }

    private void readPatient() {
        int selectedRow = patientTable.getSelectedRow();
        if (selectedRow != -1) {
            txtPatientID.setText((String) tableModel.getValueAt(selectedRow, 0));
            txtFirstName.setText((String) tableModel.getValueAt(selectedRow, 1));
            txtLastName.setText((String) tableModel.getValueAt(selectedRow, 2));
            txtAge.setText((String) tableModel.getValueAt(selectedRow, 3));
            txtPhoneNumber.setText((String) tableModel.getValueAt(selectedRow, 4));
            txtAddress.setText((String) tableModel.getValueAt(selectedRow, 5));
            txtDisease.setText((String) tableModel.getValueAt(selectedRow, 6));
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to read.");
        }
    }

    private void updatePatient() {
        int selectedRow = patientTable.getSelectedRow();
        if (selectedRow != -1) {
            tableModel.setValueAt(txtPatientID.getText(), selectedRow, 0);
            tableModel.setValueAt(txtFirstName.getText(), selectedRow, 1);
            tableModel.setValueAt(txtLastName.getText(), selectedRow, 2);
            tableModel.setValueAt(txtAge.getText(), selectedRow, 3);
            tableModel.setValueAt(txtPhoneNumber.getText(), selectedRow, 4);
            tableModel.setValueAt(txtAddress.getText(), selectedRow, 5);
            tableModel.setValueAt(txtDisease.getText(), selectedRow, 6);

            JOptionPane.showMessageDialog(this, "Patient Updated!");
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to update.");
        }
    }

    private void deletePatient() {
        int selectedRow = patientTable.getSelectedRow();
        if (selectedRow != -1) {
            tableModel.removeRow(selectedRow);
            JOptionPane.showMessageDialog(this, "Patient Deleted!");
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.");
        }
    }

    // Utility method to clear input fields
    private void clearFields() {
        txtPatientID.setText("");
        txtFirstName.setText("");
        txtLastName.setText("");
        txtAge.setText("");
        txtPhoneNumber.setText("");
        txtAddress.setText("");
        txtDisease.setText("");
    }

    public static void main(String[] args) {
        new SimpleArrayCrud();
    }
}
