package CompoundPattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CompoundStudentMGMT extends javax.swing.JFrame {

    DecimalFormat df = new DecimalFormat("###,###,###,###,###.00");
    String newline = System.getProperty("line.separator");

    public CompoundStudentMGMT() {
        initComponents();

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int choose = JOptionPane.showConfirmDialog(null,
                        "Do you really want to Logout ?",
                        "Confirm Logout", JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE);
                if (choose == JOptionPane.YES_OPTION) {
                    e.getWindow().dispose();
                    new Login().setVisible(true);
                }
            }
        });

    }

    class Student {

        private String name;
        private String stream;
        private String grade;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getStream() {
            return stream;
        }

        public void setStream(String stream) {
            this.stream = stream;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }
    }

    class StudentView {

        public void printStudentDetails(String studentName, String studentStream, String studentGrade) {

            String result = ("- Updated Records -"
                    + "\n Name: " + studentName
                    + "\n Stream: " + studentStream
                    + "\n Grade: " + studentGrade);

            JOptionPane.showMessageDialog(null, result);

            System.out.println("Student: ");
            System.out.println("Name: " + studentName);
            System.out.println("Stream: " + studentStream);
            System.out.println("Grade: " + studentGrade);


            Output.lblName.setText("Name : " + studentName);
            Output.lblStream.setText("Stream : " + studentStream);
            Output.lblGrade.setText("Grade : " + studentGrade);
        }
    }

    class StudentController {

        private Student model;
        private StudentView view;

        public StudentController(Student model, StudentView view) {
            this.model = model;
            this.view = view;
        }

        public void setStudentName(String name) {
            model.setName(name);
        }

        public String getStudentName() {
            return model.getName();
        }

        public void setStudentStream(String stream) {
            model.setStream(stream);
        }

        public String getStudentStream() {
            return model.getStream();
        }

        public void setStudentGrade(String grade) {
            model.setGrade(grade);
        }

        public String getStudentGrade() {
            return model.getGrade();
        }

        public void updateView() {
            view.printStudentDetails(model.getName(), model.getStream(), model.getGrade());
        }
    }

    private Student retriveStudentFromDatabase() {
        Student student = new Student();
        student.setName(txtStuName1.getText());
        student.setStream(comboStream1.getSelectedItem().toString());
        student.setGrade(txtGrade1.getText());
        return student;
    }

    private void InsertDataToRegisterTable() {

        if (isDataFilled()) {

            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.addRow(new Object[]{txtStuName.getText(), comboStream.getSelectedItem().toString(),
                txtGrade.getText()});

            DefaultTableModel dtm2 = (DefaultTableModel) jTable2.getModel();
            dtm2.addRow(new Object[]{txtStuName.getText(), comboStream.getSelectedItem().toString(),
                txtGrade.getText()});
            JOptionPane.showMessageDialog(null, "New Record Added!");
            txtStuName.grabFocus();

            txtStuName.setText("");
            comboStream.setSelectedIndex(0);
            txtGrade.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Please fill all the data to continue!");

        }
    }

    boolean isDataFilled() {
        if (!txtStuName.getText().equals("")
                && !txtGrade.getText().equals("")) {

            return true;
        } else {
            return false;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        cardMain = new javax.swing.JPanel();
        pnlCardRegister = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtCombinations2 = new javax.swing.JLabel();
        txtStuName = new javax.swing.JTextField();
        btnReg = new javax.swing.JButton();
        btnClearRegVehicle = new javax.swing.JButton();
        txtCombinations4 = new javax.swing.JLabel();
        comboStream = new javax.swing.JComboBox<>();
        btnFormat2 = new javax.swing.JButton();
        txtCombinations8 = new javax.swing.JLabel();
        txtGrade = new javax.swing.JTextField();
        pnlCardRegisterData = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        btnFormat4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        pnlCardUpdateRegisterData = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        btnFormat5 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        pnlCardUpdate = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtCombinations3 = new javax.swing.JLabel();
        txtStuName1 = new javax.swing.JTextField();
        btnReg1 = new javax.swing.JButton();
        btnClearRegVehicle1 = new javax.swing.JButton();
        txtCombinations5 = new javax.swing.JLabel();
        comboStream1 = new javax.swing.JComboBox<>();
        btnFormat3 = new javax.swing.JButton();
        txtCombinations9 = new javax.swing.JLabel();
        txtGrade1 = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        btnRegister = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnOutput = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Compound Student MGMT System (Compound Pattern)");
        setLocation(new java.awt.Point(0, 0));
        setSize(new java.awt.Dimension(0, 0));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Compound Student Management System");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(80, 80, 80));

        cardMain.setLayout(new java.awt.CardLayout());

        pnlCardRegister.setBackground(new java.awt.Color(51, 51, 51));
        pnlCardRegister.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Register Student");

        txtCombinations2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCombinations2.setForeground(new java.awt.Color(255, 255, 255));
        txtCombinations2.setText("Name");

        txtStuName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtStuName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtStuNameKeyPressed(evt);
            }
        });

        btnReg.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnReg.setText("Register");
        btnReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegActionPerformed(evt);
            }
        });

        btnClearRegVehicle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnClearRegVehicle.setText("Clear");
        btnClearRegVehicle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearRegVehicleActionPerformed(evt);
            }
        });

        txtCombinations4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCombinations4.setForeground(new java.awt.Color(255, 255, 255));
        txtCombinations4.setText("Stream");

        comboStream.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboStream.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Math", "Science", "ICT", "Other" }));
        comboStream.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                comboStreamKeyPressed(evt);
            }
        });

        btnFormat2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnFormat2.setText("View Data");
        btnFormat2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFormat2ActionPerformed(evt);
            }
        });

        txtCombinations8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCombinations8.setForeground(new java.awt.Color(255, 255, 255));
        txtCombinations8.setText("Grade");

        txtGrade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtGrade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtGradeKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout pnlCardRegisterLayout = new javax.swing.GroupLayout(pnlCardRegister);
        pnlCardRegister.setLayout(pnlCardRegisterLayout);
        pnlCardRegisterLayout.setHorizontalGroup(
            pnlCardRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCardRegisterLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addGroup(pnlCardRegisterLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(pnlCardRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFormat2)
                    .addGroup(pnlCardRegisterLayout.createSequentialGroup()
                        .addComponent(btnReg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClearRegVehicle))
                    .addGroup(pnlCardRegisterLayout.createSequentialGroup()
                        .addGroup(pnlCardRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCombinations2)
                            .addComponent(txtCombinations4)
                            .addComponent(txtCombinations8))
                        .addGap(43, 43, 43)
                        .addGroup(pnlCardRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStuName, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboStream, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 220, Short.MAX_VALUE))
        );
        pnlCardRegisterLayout.setVerticalGroup(
            pnlCardRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCardRegisterLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel13)
                .addGap(27, 27, 27)
                .addGroup(pnlCardRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCombinations2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStuName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCardRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCombinations4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboStream, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCardRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCombinations8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(pnlCardRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClearRegVehicle)
                    .addComponent(btnReg))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFormat2)
                .addContainerGap(142, Short.MAX_VALUE))
        );

        cardMain.add(pnlCardRegister, "card2");

        pnlCardRegisterData.setBackground(new java.awt.Color(51, 51, 51));
        pnlCardRegisterData.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Student Registration Data");

        btnFormat4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnFormat4.setText("Back");
        btnFormat4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFormat4ActionPerformed(evt);
            }
        });

        jScrollPane1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTable1.setForeground(new java.awt.Color(51, 51, 51));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Stream", "Grade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout pnlCardRegisterDataLayout = new javax.swing.GroupLayout(pnlCardRegisterData);
        pnlCardRegisterData.setLayout(pnlCardRegisterDataLayout);
        pnlCardRegisterDataLayout.setHorizontalGroup(
            pnlCardRegisterDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCardRegisterDataLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(213, 213, 213))
            .addGroup(pnlCardRegisterDataLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(pnlCardRegisterDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFormat4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 36, Short.MAX_VALUE))
        );
        pnlCardRegisterDataLayout.setVerticalGroup(
            pnlCardRegisterDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCardRegisterDataLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(btnFormat4)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        cardMain.add(pnlCardRegisterData, "card2");

        pnlCardUpdateRegisterData.setBackground(new java.awt.Color(51, 51, 51));
        pnlCardUpdateRegisterData.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Update Student Info");

        btnFormat5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnFormat5.setText("Update");
        btnFormat5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFormat5ActionPerformed(evt);
            }
        });

        jScrollPane3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTable2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTable2.setForeground(new java.awt.Color(51, 51, 51));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Stream", "Grade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);

        javax.swing.GroupLayout pnlCardUpdateRegisterDataLayout = new javax.swing.GroupLayout(pnlCardUpdateRegisterData);
        pnlCardUpdateRegisterData.setLayout(pnlCardUpdateRegisterDataLayout);
        pnlCardUpdateRegisterDataLayout.setHorizontalGroup(
            pnlCardUpdateRegisterDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCardUpdateRegisterDataLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(213, 213, 213))
            .addGroup(pnlCardUpdateRegisterDataLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(pnlCardUpdateRegisterDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFormat5)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 36, Short.MAX_VALUE))
        );
        pnlCardUpdateRegisterDataLayout.setVerticalGroup(
            pnlCardUpdateRegisterDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCardUpdateRegisterDataLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel18)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(btnFormat5)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        cardMain.add(pnlCardUpdateRegisterData, "card2");

        pnlCardUpdate.setBackground(new java.awt.Color(51, 51, 51));
        pnlCardUpdate.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Update Student");

        txtCombinations3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCombinations3.setForeground(new java.awt.Color(255, 255, 255));
        txtCombinations3.setText("Name");

        txtStuName1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtStuName1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtStuName1KeyPressed(evt);
            }
        });

        btnReg1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnReg1.setText("Update");
        btnReg1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReg1ActionPerformed(evt);
            }
        });

        btnClearRegVehicle1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnClearRegVehicle1.setText("Clear");
        btnClearRegVehicle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearRegVehicle1ActionPerformed(evt);
            }
        });

        txtCombinations5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCombinations5.setForeground(new java.awt.Color(255, 255, 255));
        txtCombinations5.setText("Stream");

        comboStream1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboStream1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Math", "Science", "ICT", "Other" }));
        comboStream1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                comboStream1KeyPressed(evt);
            }
        });

        btnFormat3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnFormat3.setText("View Data");
        btnFormat3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFormat3ActionPerformed(evt);
            }
        });

        txtCombinations9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCombinations9.setForeground(new java.awt.Color(255, 255, 255));
        txtCombinations9.setText("Grade");

        txtGrade1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtGrade1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtGrade1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout pnlCardUpdateLayout = new javax.swing.GroupLayout(pnlCardUpdate);
        pnlCardUpdate.setLayout(pnlCardUpdateLayout);
        pnlCardUpdateLayout.setHorizontalGroup(
            pnlCardUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCardUpdateLayout.createSequentialGroup()
                .addGroup(pnlCardUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCardUpdateLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCardUpdateLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(pnlCardUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnFormat3)
                            .addGroup(pnlCardUpdateLayout.createSequentialGroup()
                                .addComponent(btnReg1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnClearRegVehicle1))
                            .addGroup(pnlCardUpdateLayout.createSequentialGroup()
                                .addGroup(pnlCardUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCombinations3)
                                    .addComponent(txtCombinations5)
                                    .addComponent(txtCombinations9))
                                .addGap(43, 43, 43)
                                .addGroup(pnlCardUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtGrade1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtStuName1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboStream1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(220, 220, 220))
        );
        pnlCardUpdateLayout.setVerticalGroup(
            pnlCardUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCardUpdateLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel14)
                .addGap(27, 27, 27)
                .addGroup(pnlCardUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCombinations3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStuName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCardUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCombinations5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboStream1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCardUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCombinations9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGrade1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(pnlCardUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClearRegVehicle1)
                    .addComponent(btnReg1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFormat3)
                .addContainerGap(142, Short.MAX_VALUE))
        );

        cardMain.add(pnlCardUpdate, "card2");

        jPanel12.setBackground(new java.awt.Color(51, 51, 51));
        jPanel12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Dashboard");

        btnRegister.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnOutput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnOutput.setText("Output");
        btnOutput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOutputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addComponent(btnRegister)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnOutput)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cardMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cardMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(820, 566));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtGradeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGradeKeyPressed
        if (evt.getKeyCode() == 10) {

        }
    }//GEN-LAST:event_txtGradeKeyPressed

    private void btnFormat2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFormat2ActionPerformed
        pnlCardRegister.setVisible(false);
        pnlCardRegisterData.setVisible(true);
        pnlCardUpdate.setVisible(false);
        pnlCardUpdateRegisterData.setVisible(false);
    }//GEN-LAST:event_btnFormat2ActionPerformed

    private void comboStreamKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboStreamKeyPressed
        if (evt.getKeyCode() == 10) {
            txtGrade.grabFocus();
        }
    }//GEN-LAST:event_comboStreamKeyPressed

    private void btnClearRegVehicleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearRegVehicleActionPerformed
        txtStuName.setText("");
        comboStream.setSelectedIndex(0);
        txtGrade.setText("");

        JOptionPane.showMessageDialog(null, "All Fields Cleared!");
    }//GEN-LAST:event_btnClearRegVehicleActionPerformed

    private void btnRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegActionPerformed

        if (txtStuName.getText().isEmpty()
                || txtGrade.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Please Fill All the Fields!");

        } else {

            InsertDataToRegisterTable();


            JOptionPane.showMessageDialog(null, "Registration Successful!");
            pnlCardRegister.setVisible(false);
            pnlCardRegisterData.setVisible(true);
            pnlCardUpdate.setVisible(false);
            pnlCardUpdateRegisterData.setVisible(false);
        }
    }//GEN-LAST:event_btnRegActionPerformed

    private void txtStuNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStuNameKeyPressed
        if (evt.getKeyCode() == 10) {
            comboStream.setPopupVisible(true);
            comboStream.grabFocus();
        }
    }//GEN-LAST:event_txtStuNameKeyPressed

    private void btnFormat4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFormat4ActionPerformed
        pnlCardRegister.setVisible(true);
        pnlCardRegisterData.setVisible(false);
        pnlCardUpdate.setVisible(false);
        pnlCardUpdateRegisterData.setVisible(false);
    }//GEN-LAST:event_btnFormat4ActionPerformed

    private void btnFormat5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFormat5ActionPerformed
        pnlCardRegister.setVisible(false);
        pnlCardRegisterData.setVisible(false);
        pnlCardUpdate.setVisible(true);
        pnlCardUpdateRegisterData.setVisible(false);
    }//GEN-LAST:event_btnFormat5ActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        pnlCardRegister.setVisible(false);
        pnlCardRegisterData.setVisible(false);
        pnlCardUpdate.setVisible(false);
        pnlCardUpdateRegisterData.setVisible(true);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        pnlCardRegister.setVisible(true);
        pnlCardRegisterData.setVisible(false);
        pnlCardUpdate.setVisible(false);
        pnlCardUpdateRegisterData.setVisible(false);
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void txtStuName1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStuName1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStuName1KeyPressed

    private void btnReg1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReg1ActionPerformed
        Student model = retriveStudentFromDatabase();

        StudentView view = new StudentView();

        StudentController controller = new StudentController(model, view);
        
      
        

        Output.lblName1.setText("Name : "+ txtStuName.getText());
        Output.lblStream1.setText("Stream : "+ comboStream.getSelectedItem().toString());
        Output.lblGrade1.setText("Grade : "+ txtGrade.getText());

        controller.updateView();

        controller.setStudentName(txtStuName.getText());
        controller.setStudentStream(comboStream.getSelectedItem().toString());
        controller.setStudentGrade(txtGrade.getText());

//        controller.updateView();
    }//GEN-LAST:event_btnReg1ActionPerformed

    private void btnClearRegVehicle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearRegVehicle1ActionPerformed
        txtStuName1.setText("");
        comboStream1.setSelectedIndex(0);
        txtGrade1.setText("");
    }//GEN-LAST:event_btnClearRegVehicle1ActionPerformed

    private void comboStream1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboStream1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboStream1KeyPressed

    private void btnFormat3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFormat3ActionPerformed
        pnlCardRegister.setVisible(false);
        pnlCardRegisterData.setVisible(false);
        pnlCardUpdate.setVisible(false);
        pnlCardUpdateRegisterData.setVisible(true);
    }//GEN-LAST:event_btnFormat3ActionPerformed

    private void txtGrade1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrade1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGrade1KeyPressed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked

        String f1 = ((String) jTable2.getValueAt(jTable2.getSelectedRow(), 0));
        String f2 = ((String) jTable2.getValueAt(jTable2.getSelectedRow(), 1));
        String f3 = ((String.valueOf(jTable2.getValueAt(jTable2.getSelectedRow(), 2))));

        txtStuName.setText(f1);
        comboStream.setSelectedItem(f2);
        txtGrade.setText(f3);

        txtStuName1.setText(f1);
        comboStream1.setSelectedItem(f2);
        txtGrade1.setText(f3);

    }//GEN-LAST:event_jTable2MouseClicked

    private void btnOutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOutputActionPerformed
        Output frame = Output.getInstance();
        frame.setVisible(true);
    }//GEN-LAST:event_btnOutputActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CompoundStudentMGMT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CompoundStudentMGMT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CompoundStudentMGMT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CompoundStudentMGMT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CompoundStudentMGMT().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClearRegVehicle;
    private javax.swing.JButton btnClearRegVehicle1;
    private javax.swing.JButton btnFormat2;
    private javax.swing.JButton btnFormat3;
    private javax.swing.JButton btnFormat4;
    private javax.swing.JButton btnFormat5;
    private javax.swing.JButton btnOutput;
    private javax.swing.JButton btnReg;
    private javax.swing.JButton btnReg1;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel cardMain;
    private javax.swing.JComboBox<String> comboStream;
    private javax.swing.JComboBox<String> comboStream1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JPanel pnlCardRegister;
    private javax.swing.JPanel pnlCardRegisterData;
    private javax.swing.JPanel pnlCardUpdate;
    private javax.swing.JPanel pnlCardUpdateRegisterData;
    private javax.swing.JLabel txtCombinations2;
    private javax.swing.JLabel txtCombinations3;
    private javax.swing.JLabel txtCombinations4;
    private javax.swing.JLabel txtCombinations5;
    private javax.swing.JLabel txtCombinations8;
    private javax.swing.JLabel txtCombinations9;
    private javax.swing.JTextField txtGrade;
    private javax.swing.JTextField txtGrade1;
    private javax.swing.JTextField txtStuName;
    private javax.swing.JTextField txtStuName1;
    // End of variables declaration//GEN-END:variables
}
