package CompositePattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class CompositeSalaryCalculator extends javax.swing.JFrame {

    DefaultTreeModel model;

    public CompositeSalaryCalculator() {
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

        Load();
    }

    DefaultMutableTreeNode employee = new DefaultMutableTreeNode("Employee");

    public void Load() {
        DefaultMutableTreeNode managerNode = new DefaultMutableTreeNode("Manager");
        DefaultMutableTreeNode andrewNode = new DefaultMutableTreeNode("Andrew");

        DefaultMutableTreeNode projectManagerNode = new DefaultMutableTreeNode("Project Manager");
        DefaultMutableTreeNode rayanNode = new DefaultMutableTreeNode("Rayan");
        DefaultMutableTreeNode softwareDevNode1 = new DefaultMutableTreeNode("Software Developer T1");
        DefaultMutableTreeNode brayanNode = new DefaultMutableTreeNode("Brayan");

        DefaultMutableTreeNode kathrinaNode = new DefaultMutableTreeNode("Kathrina");
        DefaultMutableTreeNode softwareDevNode2 = new DefaultMutableTreeNode("Software Developer T2");
        DefaultMutableTreeNode nevilNode = new DefaultMutableTreeNode("Nevil");
        DefaultMutableTreeNode rohanNode = new DefaultMutableTreeNode("Rohan");

        DefaultMutableTreeNode donaldNode = new DefaultMutableTreeNode("Donald");
        DefaultMutableTreeNode softwareDevNode3 = new DefaultMutableTreeNode("Software Developer T3");
        DefaultMutableTreeNode keethNode = new DefaultMutableTreeNode("Keeth");

        employee.add(managerNode);
        managerNode.add(andrewNode);

        andrewNode.add(projectManagerNode);
        projectManagerNode.add(rayanNode);
        rayanNode.add(softwareDevNode1);
        softwareDevNode1.add(brayanNode);

        projectManagerNode.add(kathrinaNode);
        kathrinaNode.add(softwareDevNode2);
        softwareDevNode2.add(nevilNode);
        softwareDevNode2.add(rohanNode);

        projectManagerNode.add(donaldNode);
        donaldNode.add(softwareDevNode3);
        softwareDevNode3.add(keethNode);

        model = (DefaultTreeModel) jTree1.getModel();
        model.setRoot(employee);
        jTree1.setModel(model);
    }

    public interface Employee {

        public double showEmployeeDetails();
    }

    public class Manager implements Employee {

        private double salary;

        public Manager(double salary) {
            this.salary = salary;
        }

        @Override
        public double showEmployeeDetails() {
            lblComboSalary.setText(salary + " LKR");
            return 0;
        }
    }

    public class ProjectManager implements Employee {

        private double salary;

        public ProjectManager(double salary) {
            this.salary = salary;
        }

        @Override
        public double showEmployeeDetails() {
            lblComboSalary.setText(salary + " LKR");
            return 0;

        }
    }

    public class Developer implements Employee {

        private double salary;

        public Developer(double salary) {
            this.salary = salary;
        }

        @Override
        public double showEmployeeDetails() {
            lblComboSalary.setText(salary + " LKR");
            return 0;
        }
    }

    class CompanyDirectory implements Employee {

        private List<Double> employeeSalaryList = new ArrayList<>();

        @Override
        public double showEmployeeDetails() {

            try {

                double sum = 0;
                for (Double num : employeeSalaryList) {
                    sum = sum + num;

                }

                DecimalFormat df = new DecimalFormat("###,###,###,###,###.00");

                lblComboSalary.setText(df.format(sum) + " LKR");

                StringBuilder sb = new StringBuilder();

            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

            return 0;

        }

        public double addEmployee(Double emp) {
            employeeSalaryList.add(emp);
            return 0;
        }

        public double removeEmployee(Double emp) {
            employeeSalaryList.remove(emp);
            return 0;
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
        jPanel7 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jPanel8 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        comboSalary = new javax.swing.JComboBox<>();
        lblComboSalary = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Allion Software Solutions PVT LTD (Composite Pattern)");
        setLocation(new java.awt.Point(0, 0));
        setSize(new java.awt.Dimension(0, 0));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Allion Software Solutions PVT LTD");

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

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));
        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Employee");

        jScrollPane1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jTree1.setBackground(new java.awt.Color(51, 51, 51));
        jTree1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTree1.setForeground(new java.awt.Color(51, 51, 51));
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTree1.setToolTipText("");
        jTree1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTree1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTree1);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));
        jPanel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Salary");

        comboSalary.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboSalary.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Name" }));
        comboSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSalaryActionPerformed(evt);
            }
        });

        lblComboSalary.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        lblComboSalary.setForeground(new java.awt.Color(255, 255, 255));
        lblComboSalary.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblComboSalary.setText("0 LKR");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Total Salary");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblComboSalary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(comboSalary, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(11, 11, 11)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(comboSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblComboSalary))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        setSize(new java.awt.Dimension(756, 555));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTree1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTree1MouseClicked
        try {

            employee = (DefaultMutableTreeNode) jTree1.getSelectionPath().getLastPathComponent();

            String select = employee.getUserObject().toString();

            if (select.equals("Employee")) {
                comboSalary.removeAllItems();
                comboSalary.addItem("All Employee");
                comboSalary.addItem("Managers + Project Managers");
                comboSalary.addItem("Manager");
            }

            if (select.equals("Manager")) {
                comboSalary.removeAllItems();
                comboSalary.addItem("Managers");
                comboSalary.addItem("Managers + Project Managers");
                comboSalary.addItem("Managers + PMs +  Software Devs");
            }

            if (select.equals("Andrew")) {
                comboSalary.removeAllItems();
                comboSalary.addItem("Andrew (Manager)");
                comboSalary.addItem("Andrew (Manager) + Project Managers");
                comboSalary.addItem("Managers + PMs +  Software Devs");
            }

            if (select.equals("Project Manager")) {
                comboSalary.removeAllItems();
                comboSalary.addItem("Project Managers");
                comboSalary.addItem("Project Managers + Software Devs");
            }

            if (select.equals("Rayan")) {
                comboSalary.removeAllItems();
                comboSalary.addItem("Rayan (PM)");
                comboSalary.addItem("Rayan (PM) + Software Developer T1");
            }

            if (select.equals("Software Developer T1")) {
                comboSalary.removeAllItems();
                comboSalary.addItem("Software Developer T1");
            }

            if (select.equals("Kathrina")) {
                comboSalary.removeAllItems();
                comboSalary.addItem("Kathrina (PM)");
                comboSalary.addItem("Kathrina (PM) + Software Developer T2");
            }

            if (select.equals("Software Developer T2")) {
                comboSalary.removeAllItems();
                comboSalary.addItem("Software Developer T2");
            }

            if (select.equals("Donald")) {
                comboSalary.removeAllItems();
                comboSalary.addItem("Donald (PM)");
                comboSalary.addItem("Donald (PM) + Software Developer T3");
            }

            if (select.equals("Software Developer T3")) {
                comboSalary.removeAllItems();
                comboSalary.addItem("Software Developer T3");
            }

            if (select.equals("Brayan")) {
                comboSalary.removeAllItems();
                comboSalary.addItem("Briyan (SD)");
            }

            if (select.equals("Nevil")) {
                comboSalary.removeAllItems();
                comboSalary.addItem("Nevil (SD)");
            }

            if (select.equals("Rohan")) {
                comboSalary.removeAllItems();
                comboSalary.addItem("Rohan (SD)");
            }

            if (select.equals("Keeth")) {
                comboSalary.removeAllItems();
                comboSalary.addItem("Keeth (SD)");
            }
        } catch (NullPointerException e) {
        }


    }//GEN-LAST:event_jTree1MouseClicked

    private void comboSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSalaryActionPerformed
        Manager manager1 = new Manager(250000);

        ProjectManager projectManager1 = new ProjectManager(180000);
        ProjectManager projectManager2 = new ProjectManager(180000);
        ProjectManager projectManager3 = new ProjectManager(180000);

        Developer developer1 = new Developer(100000);

        Developer developer2 = new Developer(100000);
        Developer developer3 = new Developer(100000);
        
        Developer developer4 = new Developer(100000);

        CompanyDirectory managerDirectory = new CompanyDirectory();
        managerDirectory.addEmployee(manager1.salary);

        CompanyDirectory projectManagerDirectory = new CompanyDirectory();
        projectManagerDirectory.addEmployee(projectManager1.salary);
        projectManagerDirectory.addEmployee(projectManager2.salary);
        projectManagerDirectory.addEmployee(projectManager3.salary);

        CompanyDirectory managerDir_projectManagerDirDirectory = new CompanyDirectory();
        managerDir_projectManagerDirDirectory.addEmployee(manager1.salary);
        managerDir_projectManagerDirDirectory.addEmployee(projectManager1.salary);
        managerDir_projectManagerDirDirectory.addEmployee(projectManager2.salary);
        managerDir_projectManagerDirDirectory.addEmployee(projectManager3.salary);

        CompanyDirectory developerDirectory = new CompanyDirectory();
        developerDirectory.addEmployee(developer1.salary);
        developerDirectory.addEmployee(developer2.salary);
        developerDirectory.addEmployee(developer3.salary);
        developerDirectory.addEmployee(developer4.salary);

        CompanyDirectory projectManagerDir_developerDirDirectory = new CompanyDirectory();
        projectManagerDir_developerDirDirectory.addEmployee(projectManager1.salary);
        projectManagerDir_developerDirDirectory.addEmployee(projectManager2.salary);
        projectManagerDir_developerDirDirectory.addEmployee(projectManager3.salary);

        projectManagerDir_developerDirDirectory.addEmployee(developer1.salary);
        projectManagerDir_developerDirDirectory.addEmployee(developer2.salary);
        projectManagerDir_developerDirDirectory.addEmployee(developer3.salary);
        projectManagerDir_developerDirDirectory.addEmployee(developer4.salary);

        CompanyDirectory rayanDirectory = new CompanyDirectory();
        rayanDirectory.addEmployee(projectManager1.salary);

        CompanyDirectory kathrinaDirectory = new CompanyDirectory();
        kathrinaDirectory.addEmployee(projectManager2.salary);

        CompanyDirectory donaldDirectory = new CompanyDirectory();
        donaldDirectory.addEmployee(projectManager3.salary);

        CompanyDirectory rayanDir_devT1DirDirectory = new CompanyDirectory();
        rayanDir_devT1DirDirectory.addEmployee(projectManager1.salary);
        rayanDir_devT1DirDirectory.addEmployee(developer1.salary);

        CompanyDirectory kathrinaDir_devT2DirDirectory = new CompanyDirectory();
        kathrinaDir_devT2DirDirectory.addEmployee(projectManager2.salary);
        kathrinaDir_devT2DirDirectory.addEmployee(developer2.salary);
        kathrinaDir_devT2DirDirectory.addEmployee(developer3.salary);

        CompanyDirectory donaldDir_devT3DirDirectory = new CompanyDirectory();
        donaldDir_devT3DirDirectory.addEmployee(projectManager3.salary);
        donaldDir_devT3DirDirectory.addEmployee(developer4.salary);

        CompanyDirectory developerT1Directory = new CompanyDirectory();
        developerT1Directory.addEmployee(developer1.salary);

        CompanyDirectory developerT2Directory = new CompanyDirectory();
        developerT2Directory.addEmployee(developer2.salary);
        developerT2Directory.addEmployee(developer3.salary);

        CompanyDirectory developerT3Directory = new CompanyDirectory();
        developerT3Directory.addEmployee(developer4.salary);

        CompanyDirectory brayanDirectory = new CompanyDirectory();
        brayanDirectory.addEmployee(developer1.salary);

        CompanyDirectory nevilDirectory = new CompanyDirectory();
        nevilDirectory.addEmployee(developer2.salary);

        CompanyDirectory rohanDirectory = new CompanyDirectory();
        rohanDirectory.addEmployee(developer3.salary);

        CompanyDirectory keethDirectory = new CompanyDirectory();
        keethDirectory.addEmployee(developer4.salary);

        CompanyDirectory employeeDirectory = new CompanyDirectory();
        employeeDirectory.addEmployee(manager1.salary);
        employeeDirectory.addEmployee(projectManager1.salary);
        employeeDirectory.addEmployee(projectManager2.salary);
        employeeDirectory.addEmployee(projectManager3.salary);
        employeeDirectory.addEmployee(developer1.salary);
        employeeDirectory.addEmployee(developer2.salary);
        employeeDirectory.addEmployee(developer3.salary);
        employeeDirectory.addEmployee(developer4.salary);

        if (comboSalary.getSelectedItem() == "All Employee") {
            employeeDirectory.showEmployeeDetails();
        }
        if (comboSalary.getSelectedItem() == "Managers + Project Managers") {
            managerDir_projectManagerDirDirectory.showEmployeeDetails();
        }
        if (comboSalary.getSelectedItem() == "Manager") {
            managerDirectory.showEmployeeDetails();
        }
        if (comboSalary.getSelectedItem() == "Managers") {
            managerDirectory.showEmployeeDetails();
        }
        if (comboSalary.getSelectedItem() == "Managers + PMs +  Software Devs") {
            employeeDirectory.showEmployeeDetails();
        }
        if (comboSalary.getSelectedItem() == "Andrew (Manager)") {
            managerDirectory.showEmployeeDetails();
        }
        if (comboSalary.getSelectedItem() == "Andrew (Manager) + Project Managers") {
            managerDir_projectManagerDirDirectory.showEmployeeDetails();
        }
        if (comboSalary.getSelectedItem() == "Project Managers") {
            projectManagerDirectory.showEmployeeDetails();
        }
        if (comboSalary.getSelectedItem() == "Project Managers + Software Devs") {
            projectManagerDir_developerDirDirectory.showEmployeeDetails();
        }
        if (comboSalary.getSelectedItem() == "Rayan (PM)") {
            rayanDirectory.showEmployeeDetails();
        }
        if (comboSalary.getSelectedItem() == "Rayan (PM) + Software Developer T1") {
            rayanDir_devT1DirDirectory.showEmployeeDetails();
        }
        if (comboSalary.getSelectedItem() == "Software Developer T1") {
            developerT1Directory.showEmployeeDetails();
        }
        if (comboSalary.getSelectedItem() == "Kathrina (PM)") {
            kathrinaDirectory.showEmployeeDetails();
        }
        if (comboSalary.getSelectedItem() == "Kathrina (PM) + Software Developer T2") {
            kathrinaDir_devT2DirDirectory.showEmployeeDetails();
        }
        if (comboSalary.getSelectedItem() == "Software Developer T2") {
            developerT2Directory.showEmployeeDetails();
        }
        if (comboSalary.getSelectedItem() == "Donald (PM)") {
            donaldDirectory.showEmployeeDetails();
        }
        if (comboSalary.getSelectedItem() == "Donald (PM) + Software Developer T3") {
            donaldDir_devT3DirDirectory.showEmployeeDetails();
        }
        if (comboSalary.getSelectedItem() == "Software Developer T3") {
            developerT3Directory.showEmployeeDetails();
        }
        if (comboSalary.getSelectedItem() == "Briyan (SD)") {
            brayanDirectory.showEmployeeDetails();
        }
        if (comboSalary.getSelectedItem() == "Nevil (SD)") {
            nevilDirectory.showEmployeeDetails();
        }
        if (comboSalary.getSelectedItem() == "Rohan (SD)") {
            rohanDirectory.showEmployeeDetails();
        }
        if (comboSalary.getSelectedItem() == "Keeth (SD)") {
            keethDirectory.showEmployeeDetails();
        }
    }//GEN-LAST:event_comboSalaryActionPerformed

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
            java.util.logging.Logger.getLogger(CompositeSalaryCalculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CompositeSalaryCalculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CompositeSalaryCalculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CompositeSalaryCalculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CompositeSalaryCalculator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> comboSalary;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree jTree1;
    private javax.swing.JLabel lblComboSalary;
    // End of variables declaration//GEN-END:variables
}
