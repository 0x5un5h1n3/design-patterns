package AntiPatterns;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AntiPatternTrafficControlSystem extends javax.swing.JFrame {

    public AntiPatternTrafficControlSystem() {
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

    public abstract class Driver {

        protected trafficcontrolmediator mediator;
        protected String vehicleno;
        protected String msg;

        public Driver(trafficcontrolmediator med, String vehicleno) {
            this.mediator = med;
            this.vehicleno = vehicleno;

        }
    }

    interface trafficcontrolmediator {

        public void sendinfo(String vehicleno, Driver driver);

        void addDriver(Driver driver);
    }

    private void InsertDataToRegisterTable() {

        if (isDataFilled()) {

            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.addRow(new Object[]{txtDriverName.getText(), comboType.getSelectedItem().toString(),
                txtNumberPlate.getText(), txtChassisNo.getText()});
            JOptionPane.showMessageDialog(null, "New Record Added!");
            txtDriverName.grabFocus();

            txtDriverName.setText("");
            comboType.setSelectedIndex(0);
            txtNumberPlate.setText("");
            txtChassisNo.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Please fill all the data to continue!");

        }
    }

    boolean isDataFilled() {
        if (!txtDriverName.getText().equals("")
                && !txtNumberPlate.getText().equals("")
                && !txtChassisNo.getText().equals("")) {

            return true;
        } else {
            return false;
        }
    }

    private void InsertDataToLaneTrafficTable() {

        DefaultTableModel dtm2 = (DefaultTableModel) jTable2.getModel();

        TrafficControlMediator tfc = new TrafficControl();
        String a = txtDisplayDriverName.getText();
        String b = lblNumberPlate.getText();
        DriverInfo c = new DriverInfo(tfc, a, b);

        tfc.addDriver(c);

        if (comboLanes.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Select a Lane!");
        }
        if (comboLanes.getSelectedIndex() == 1) {
            dtm2.addRow(new Object[]{"Open", "Lane 1", "Medium"});

            String result = c.request(""
                    + "\n- Status: Open"
                    + "\n- Lane: Lane 1"
                    + "\n- Traffic: Medium");
            JOptionPane.showMessageDialog(null, result);
        }
        if (comboLanes.getSelectedIndex() == 2) {
            dtm2.addRow(new Object[]{"Open", "Lane 2", "High"});

            String result = c.request(""
                    + "\n- Status: Open"
                    + "\n- Lane: Lane 2"
                    + "\n- Traffic: High");
            JOptionPane.showMessageDialog(null, result);
        }
        if (comboLanes.getSelectedIndex() == 3) {
            dtm2.addRow(new Object[]{"Closed", "Lane 3", "N/A"});

            String result = c.request(""
                    + "\n- Status: Closed"
                    + "\n- Lane: Lane 3"
                    + "\n- Traffic: N/A");
            JOptionPane.showMessageDialog(null, result);
        }
        if (comboLanes.getSelectedIndex() == 4) {
            dtm2.addRow(new Object[]{"Open", "Lane 4", "Low"});

            String result = c.request(""
                    + "\n- Status: Open"
                    + "\n- Lane: Lane 4"
                    + "\n- Traffic: Low");
            JOptionPane.showMessageDialog(null, result);
        }
        if (comboLanes.getSelectedIndex() == 5) {
            dtm2.addRow(new Object[]{"Open", "Lane 5", "High"});

            String result = c.request(""
                    + "\n- Status: Open"
                    + "\n- Lane: Lane 5"
                    + "\n- Traffic: High");
            JOptionPane.showMessageDialog(null, result);
        }
        if (comboLanes.getSelectedIndex() == 6) {
            dtm2.addRow(new Object[]{"Open", "Lane 6", "High"});

            String result = c.request(""
                    + "\n- Status: Open"
                    + "\n- Lane: Lane 6"
                    + "\n- Traffic: High");
            JOptionPane.showMessageDialog(null, result);
        }
        if (comboLanes.getSelectedIndex() == 7) {
            dtm2.addRow(new Object[]{"Open", "Lane 7", "Low"});

            String result = c.request(""
                    + "\n- Status: Open"
                    + "\n- Lane: Lane 7"
                    + "\n- Traffic: Low");
            JOptionPane.showMessageDialog(null, result);
        }
        if (comboLanes.getSelectedIndex() == 8) {
            dtm2.addRow(new Object[]{"Closed", "Lane 8", "N/A"});

            String result = c.request(""
                    + "\n- Status: Closed"
                    + "\n- Lane: Lane 8"
                    + "\n- Traffic: N/A");
            JOptionPane.showMessageDialog(null, result);
        }
        if (comboLanes.getSelectedIndex() == 9) {
            dtm2.addRow(new Object[]{"Open", "Lane 9", "High"});

            String result = c.request(""
                    + "\n- Status: Open"
                    + "\n- Lane: Lane 9"
                    + "\n- Traffic: High");
            JOptionPane.showMessageDialog(null, result);
        }
        if (comboLanes.getSelectedIndex() == 10) {
            dtm2.addRow(new Object[]{"Open", "Lane 10", "Medium"});

            String result = c.request(""
                    + "\n- Status: Open"
                    + "\n- Lane: Lane 10"
                    + "\n- Traffic: Medium");
            JOptionPane.showMessageDialog(null, result);
        }
        if (comboLanes.getSelectedIndex() == 11) {
            dtm2.addRow(new Object[]{"Open", "Lane 11", "Low"});

            String result = c.request(""
                    + "\n- Status: Open"
                    + "\n- Lane: Lane 11"
                    + "\n- Traffic: Low");
            JOptionPane.showMessageDialog(null, result);
        }
        if (comboLanes.getSelectedIndex() == 12) {
            dtm2.addRow(new Object[]{"Closed", "Lane 12", "N/A"});

            String result = c.request(""
                    + "\n- Status: Closed"
                    + "\n- Lane: Lane 12"
                    + "\n- Traffic: N/A");
            JOptionPane.showMessageDialog(null, result);
        }
        if (comboLanes.getSelectedIndex() == 13) {
            dtm2.addRow(new Object[]{"Open", "Lane 13", "Medium"});

            String result = c.request(""
                    + "\n- Status: Open"
                    + "\n- Lane: Lane 13"
                    + "\n- Traffic: Medium");
            JOptionPane.showMessageDialog(null, result);
        }
        if (comboLanes.getSelectedIndex() == 14) {
            dtm2.addRow(new Object[]{"Open", "Lane 14", "High"});
            
            String result = c.request(""
                    + "\n- Status: Open"
                    + "\n- Lane: Lane 14"
                    + "\n- Traffic: High");
            JOptionPane.showMessageDialog(null, result);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        cardMain = new javax.swing.JPanel();
        pnlCardRegister = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtCombinations2 = new javax.swing.JLabel();
        txtDriverName = new javax.swing.JTextField();
        btnFormat = new javax.swing.JButton();
        btnClearRegVehicle = new javax.swing.JButton();
        txtCombinations4 = new javax.swing.JLabel();
        txtCombinations5 = new javax.swing.JLabel();
        comboType = new javax.swing.JComboBox<>();
        txtChassisNo = new javax.swing.JTextField();
        btnFormat2 = new javax.swing.JButton();
        txtCombinations8 = new javax.swing.JLabel();
        txtNumberPlate = new javax.swing.JTextField();
        pnlCardRegisterData = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        btnFormat4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        pnlCardTrafficInfo = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        comboLanes = new javax.swing.JComboBox<>();
        txtCombinations10 = new javax.swing.JLabel();
        btnRequestInfo = new javax.swing.JButton();
        txtCombinations9 = new javax.swing.JLabel();
        txtDisplayDriverName = new javax.swing.JTextField();
        txtCombinations11 = new javax.swing.JLabel();
        lblNumberPlate = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        btnClear1 = new javax.swing.JButton();
        btnClear3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Mediator Traffic Control System (Mediator Pattern)");
        setLocation(new java.awt.Point(0, 0));
        setSize(new java.awt.Dimension(0, 0));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Anti Pattern Traffic Control System");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)
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
        jLabel13.setText("Register Vehicle");

        txtCombinations2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCombinations2.setForeground(new java.awt.Color(255, 255, 255));
        txtCombinations2.setText("Driver's Name");

        txtDriverName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDriverName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDriverNameKeyPressed(evt);
            }
        });

        btnFormat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnFormat.setText("Register");
        btnFormat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFormatActionPerformed(evt);
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
        txtCombinations4.setText("Type");

        txtCombinations5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCombinations5.setForeground(new java.awt.Color(255, 255, 255));
        txtCombinations5.setText("Chassis No");

        comboType.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Car", "Bike", "Bus", "Van", "Other" }));
        comboType.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                comboTypeKeyPressed(evt);
            }
        });

        txtChassisNo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtChassisNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtChassisNoKeyPressed(evt);
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
        txtCombinations8.setText("Number Plate");

        txtNumberPlate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNumberPlate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNumberPlateKeyPressed(evt);
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
                        .addComponent(btnFormat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClearRegVehicle))
                    .addGroup(pnlCardRegisterLayout.createSequentialGroup()
                        .addGroup(pnlCardRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCombinations2)
                            .addComponent(txtCombinations4)
                            .addComponent(txtCombinations8)
                            .addComponent(txtCombinations5))
                        .addGap(24, 24, 24)
                        .addGroup(pnlCardRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtChassisNo, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumberPlate, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDriverName, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboType, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 196, Short.MAX_VALUE))
        );
        pnlCardRegisterLayout.setVerticalGroup(
            pnlCardRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCardRegisterLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel13)
                .addGap(27, 27, 27)
                .addGroup(pnlCardRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCombinations2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDriverName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCardRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCombinations4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCardRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCombinations8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumberPlate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCardRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtChassisNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCombinations5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(pnlCardRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClearRegVehicle)
                    .addComponent(btnFormat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFormat2)
                .addContainerGap(98, Short.MAX_VALUE))
        );

        cardMain.add(pnlCardRegister, "card2");

        pnlCardRegisterData.setBackground(new java.awt.Color(51, 51, 51));
        pnlCardRegisterData.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Register Vehicle Data");

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
                "Driver's Name", "Type", "Number Plate", "Chassis No."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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

        pnlCardTrafficInfo.setBackground(new java.awt.Color(51, 51, 51));
        pnlCardTrafficInfo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Traffic Information");

        btnReset.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        jScrollPane2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTable2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTable2.setForeground(new java.awt.Color(51, 51, 51));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Status", "Lane", "Traffic"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setToolTipText("");
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        comboLanes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboLanes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Lane 1", "Lane 2", "Lane 3", "Lane 4", "Lane 5", "Lane 6", "Lane 7", "Lane 8", "Lane 9", "Lane 10", "Lane 11", "Lane 12", "Lane 13", "Lane 14" }));

        txtCombinations10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCombinations10.setForeground(new java.awt.Color(255, 255, 255));
        txtCombinations10.setText("Select Lane");

        btnRequestInfo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRequestInfo.setText("Request Info");
        btnRequestInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestInfoActionPerformed(evt);
            }
        });

        txtCombinations9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCombinations9.setForeground(new java.awt.Color(255, 255, 255));
        txtCombinations9.setText("Driver's Name");

        txtDisplayDriverName.setEditable(false);
        txtDisplayDriverName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDisplayDriverName.setEnabled(false);

        txtCombinations11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCombinations11.setForeground(new java.awt.Color(255, 255, 255));
        txtCombinations11.setText("Driver's Name");

        lblNumberPlate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNumberPlate.setForeground(new java.awt.Color(51, 51, 51));
        lblNumberPlate.setText("Number Plate");

        javax.swing.GroupLayout pnlCardTrafficInfoLayout = new javax.swing.GroupLayout(pnlCardTrafficInfo);
        pnlCardTrafficInfo.setLayout(pnlCardTrafficInfoLayout);
        pnlCardTrafficInfoLayout.setHorizontalGroup(
            pnlCardTrafficInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCardTrafficInfoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(213, 213, 213))
            .addGroup(pnlCardTrafficInfoLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(pnlCardTrafficInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnlCardTrafficInfoLayout.createSequentialGroup()
                        .addComponent(btnRequestInfo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReset)
                        .addGap(103, 103, 103)
                        .addComponent(lblNumberPlate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlCardTrafficInfoLayout.createSequentialGroup()
                        .addComponent(txtCombinations11, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDisplayDriverName, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCombinations10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboLanes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 36, Short.MAX_VALUE))
            .addGroup(pnlCardTrafficInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlCardTrafficInfoLayout.createSequentialGroup()
                    .addGap(124, 124, 124)
                    .addComponent(txtCombinations9, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(362, Short.MAX_VALUE)))
        );
        pnlCardTrafficInfoLayout.setVerticalGroup(
            pnlCardTrafficInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCardTrafficInfoLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addGroup(pnlCardTrafficInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCardTrafficInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboLanes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCombinations10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCardTrafficInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtCombinations11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDisplayDriverName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(pnlCardTrafficInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReset)
                    .addComponent(btnRequestInfo)
                    .addComponent(lblNumberPlate, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(pnlCardTrafficInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlCardTrafficInfoLayout.createSequentialGroup()
                    .addGap(199, 199, 199)
                    .addComponent(txtCombinations9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(200, Short.MAX_VALUE)))
        );

        cardMain.add(pnlCardTrafficInfo, "card2");

        jPanel12.setBackground(new java.awt.Color(51, 51, 51));
        jPanel12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Traffic Control");

        btnClear1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnClear1.setText("Register");
        btnClear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClear1ActionPerformed(evt);
            }
        });

        btnClear3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnClear3.setText("Request Info");
        btnClear3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClear3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnClear3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnClear1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 14, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addComponent(btnClear1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnClear3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cardMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cardMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
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

        setSize(new java.awt.Dimension(838, 565));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void btnFormatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFormatActionPerformed

        if (txtDriverName.getText().isEmpty()
                || txtNumberPlate.getText().isEmpty()
                || txtChassisNo.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Please Fill All the Fields!");

        } else {
            txtDisplayDriverName.setText(txtDriverName.getText());
            lblNumberPlate.setText(txtNumberPlate.getText());
            InsertDataToRegisterTable();
            JOptionPane.showMessageDialog(null, "Registration Successful!");
            pnlCardRegister.setVisible(false);
            pnlCardRegisterData.setVisible(false);
            pnlCardTrafficInfo.setVisible(true);
        }
    }//GEN-LAST:event_btnFormatActionPerformed

    private void btnClearRegVehicleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearRegVehicleActionPerformed
        txtDriverName.setText("");
        comboType.setSelectedIndex(0);
        txtNumberPlate.setText("");
        txtChassisNo.setText("");

        JOptionPane.showMessageDialog(this, "All Fields Cleared!");
    }//GEN-LAST:event_btnClearRegVehicleActionPerformed

    private void txtDriverNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDriverNameKeyPressed
        if (evt.getKeyCode() == 10) {
            comboType.setPopupVisible(true);
            comboType.grabFocus();
        }
    }//GEN-LAST:event_txtDriverNameKeyPressed

    private void btnClear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClear1ActionPerformed
        pnlCardRegister.setVisible(true);
        pnlCardTrafficInfo.setVisible(false);
    }//GEN-LAST:event_btnClear1ActionPerformed

    private void comboTypeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboTypeKeyPressed
        if (evt.getKeyCode() == 10) {
            txtNumberPlate.grabFocus();
        }
    }//GEN-LAST:event_comboTypeKeyPressed

    private void txtChassisNoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtChassisNoKeyPressed
        if (evt.getKeyCode() == 10) {
            if (txtDriverName.getText().isEmpty()
                    || txtNumberPlate.getText().isEmpty()
                    || txtChassisNo.getText().isEmpty()) {

                JOptionPane.showMessageDialog(null, "Please Fill All the Fields!");

            } else {
                txtDisplayDriverName.setText(txtDriverName.getText());
                lblNumberPlate.setText(txtNumberPlate.getText());
                InsertDataToRegisterTable();
                JOptionPane.showMessageDialog(null, "Registration Successful!");
                pnlCardRegister.setVisible(false);
                pnlCardRegisterData.setVisible(false);
                pnlCardTrafficInfo.setVisible(true);
            }
        }

    }//GEN-LAST:event_txtChassisNoKeyPressed

    private void btnClear3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClear3ActionPerformed
        if (!(txtDisplayDriverName.getText().equals(""))) {
            pnlCardRegister.setVisible(false);
            pnlCardRegisterData.setVisible(false);
            pnlCardTrafficInfo.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Register First!");
            txtDriverName.setText("");
            comboType.setSelectedIndex(0);
            txtNumberPlate.setText("");
            txtChassisNo.setText("");

            pnlCardRegister.setVisible(true);
            pnlCardRegisterData.setVisible(false);
            pnlCardTrafficInfo.setVisible(false);
        }

    }//GEN-LAST:event_btnClear3ActionPerformed

    private void btnFormat2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFormat2ActionPerformed
        pnlCardRegister.setVisible(false);
        pnlCardRegisterData.setVisible(true);
        pnlCardTrafficInfo.setVisible(false);
    }//GEN-LAST:event_btnFormat2ActionPerformed

    private void btnFormat4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFormat4ActionPerformed
        pnlCardRegister.setVisible(true);
        pnlCardRegisterData.setVisible(false);
        pnlCardTrafficInfo.setVisible(false);
    }//GEN-LAST:event_btnFormat4ActionPerformed

    private void txtNumberPlateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumberPlateKeyPressed
        if (evt.getKeyCode() == 10) {
            txtChassisNo.grabFocus();
        }
    }//GEN-LAST:event_txtNumberPlateKeyPressed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        comboLanes.setSelectedIndex(0);
        DefaultTableModel dtm2 = (DefaultTableModel) jTable2.getModel();
        dtm2.setNumRows(0);
    }//GEN-LAST:event_btnResetActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        String newline = System.getProperty("line.separator");

        String f1 = ((String) jTable2.getValueAt(jTable2.getSelectedRow(), 0));
        String f2 = ((String) jTable2.getValueAt(jTable2.getSelectedRow(), 1));
        String f3 = ((String.valueOf(jTable2.getValueAt(jTable2.getSelectedRow(), 2))));

        String row = "Status: " + f1 + newline
                + "Lane: " + f2 + newline
                + "Traffic: " + f3;

        JOptionPane.showMessageDialog(this, row);
    }//GEN-LAST:event_jTable2MouseClicked

    private void btnRequestInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestInfoActionPerformed
        InsertDataToLaneTrafficTable();

    }//GEN-LAST:event_btnRequestInfoActionPerformed

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
            java.util.logging.Logger.getLogger(AntiPatternTrafficControlSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AntiPatternTrafficControlSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AntiPatternTrafficControlSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AntiPatternTrafficControlSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new AntiPatternTrafficControlSystem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear1;
    private javax.swing.JButton btnClear3;
    private javax.swing.JButton btnClearRegVehicle;
    private javax.swing.JButton btnFormat;
    private javax.swing.JButton btnFormat2;
    private javax.swing.JButton btnFormat4;
    private javax.swing.JButton btnRequestInfo;
    private javax.swing.JButton btnReset;
    private javax.swing.JPanel cardMain;
    private javax.swing.JComboBox<String> comboLanes;
    private javax.swing.JComboBox<String> comboType;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblNumberPlate;
    private javax.swing.JPanel pnlCardRegister;
    private javax.swing.JPanel pnlCardRegisterData;
    private javax.swing.JPanel pnlCardTrafficInfo;
    private javax.swing.JTextField txtChassisNo;
    private javax.swing.JLabel txtCombinations10;
    private javax.swing.JLabel txtCombinations11;
    private javax.swing.JLabel txtCombinations2;
    private javax.swing.JLabel txtCombinations4;
    private javax.swing.JLabel txtCombinations5;
    private javax.swing.JLabel txtCombinations8;
    private javax.swing.JLabel txtCombinations9;
    private javax.swing.JTextField txtDisplayDriverName;
    private javax.swing.JTextField txtDriverName;
    private javax.swing.JTextField txtNumberPlate;
    // End of variables declaration//GEN-END:variables
}
