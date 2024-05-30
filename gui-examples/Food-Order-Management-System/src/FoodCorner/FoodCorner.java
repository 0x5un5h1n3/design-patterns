/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FoodCorner;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FoodCorner extends javax.swing.JFrame {

    String newline = System.getProperty("line.separator");

    OrderStep chain;

    DecimalFormat df = new DecimalFormat("###,###,###,###,###.00");

    String Type = "N/A";
    String Name = "N/A";
    String Packing = "N/A";
    double Price = 0.0;

    public FoodCorner() {

        initComponents();
        buildChain();

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

    public FoodCorner(String type, String name, String packing, double price) {

        this.Type = type;
        this.Name = name;
        this.Packing = packing;
        this.Price = price;
    }

    @Override
    public String toString() {
        String newline = System.getProperty("line.separator");
        return "Meal Type: " + Type + newline
                + "Meal Name: " + Name + newline
                + "Meal Packing: " + Packing + newline
                + "Meal Price: " + Price;
    }

    //---------------------------------------------------------
    //Mediator Pattern
    public abstract class Colleague {

        protected OrderMediator mediator;
        protected String phone;
        protected String msg;

        public Colleague(OrderMediator med, String phone) {
            this.mediator = med;
            this.phone = phone;

        }
    }

    interface OrderMediator {

        public void sendinfo(String vehicleno, Colleague customer);

        void addCustomer(Colleague customer);
    }

    boolean isDataFilled() {
        if (!txtCustomerName.getText().equals("")
                && !txtPhone.getText().equals("")) {

            return true;
        } else {
            return false;
        }
    }

    private void InsertDataToCustomerTable() {

        if (isDataFilled()) {

            DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
            dtm.addRow(new Object[]{txtCustomerName.getText(), comboMembership.getSelectedItem().toString(),
                txtPhone.getText()});
            JOptionPane.showMessageDialog(null, "New Customer Saved!");
            txtCustomerName.grabFocus();

            txtCustomerName.setText("");
            comboMembership.setSelectedIndex(0);
            txtPhone.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Please fill all the data to continue!");

        }
    }

    private void InsertDataToOrderTable() {
        DefaultTableModel dtm2 = (DefaultTableModel) jTable3.getModel();
        OrderControlMediator orderControlMediator = new OrderControl();
        String customer = txtDisplayCustomerName.getText();
        String phone = lblPhone.getText();
        CustomerInfo customerInfo = new CustomerInfo(orderControlMediator, customer, phone);

        orderControlMediator.addCustomer(customerInfo);

        String[][] orders = {
            {"ORD001", chooseRandomAvailability(), "Cheese Burger"},
            {"ORD002", chooseRandomAvailability(), "Big Mac"},
            {"ORD003", chooseRandomAvailability(), "Foot Long"},
            {"ORD004", chooseRandomAvailability(), "Pizza"},
            {"ORD005", chooseRandomAvailability(), "Pizza"},
            {"ORD006", chooseRandomAvailability(), "Chicken sandwich"},
            {"ORD007", chooseRandomAvailability(), "Chicken sandwich"},
            {"ORD008", chooseRandomAvailability(), "Nachos"},
            {"ORD009", chooseRandomAvailability(), "Fried chicken"},
            {"ORD010", chooseRandomAvailability(), "Sushi rolls"},
            {"ORD011", chooseRandomAvailability(), "Tacos"},
            {"ORD012", chooseRandomAvailability(), "Pasta"},
            {"ORD013", chooseRandomAvailability(), "Milkshake"},
            {"ORD014", chooseRandomAvailability(), "Iced tea"}
        };

        int selectedIndex = comboLanes.getSelectedIndex();
        if (selectedIndex < 1 || selectedIndex > orders.length) {
            JOptionPane.showMessageDialog(null, "Select an Order!");
        } else {
            String[] selectedOrder = orders[selectedIndex - 1];
            dtm2.addRow(selectedOrder);

            String result = customerInfo.request(getOrderDetails(selectedOrder));
            JOptionPane.showMessageDialog(null, result);
        }
    }

    private String chooseRandomAvailability() {
        Random random = new Random();
        boolean isReady = random.nextBoolean();
        return isReady ? "Ready" : "Not Ready";
    }

    private String getOrderDetails(String[] order) {
        return String.format(
                "\n- Order No: %s"
                + "\n- Availability: %s"
                + "\n- Order Detail: %s",
                order[0], order[1], order[2]
        );
    }

    public abstract class Customer {

        protected OrderControlMediator mediator;
        protected String name;
        protected String phone;
        protected String msg;

        public Customer(OrderControlMediator med, String name, String phone) {
            this.mediator = med;
            this.name = name;
            this.phone = phone;

        }

        public abstract String request(String msg);

    }

    public class CustomerInfo extends Customer {

        public String msg;

        public CustomerInfo(OrderControlMediator med, String name, String phone) {
            super(med, name, phone);
        }

        public String getMsg() {
            return msg;
        }

        @Override
        public String request(String msg) {

            return "Requested By"
                    + "\n- Name : " + name + " "
                    + "\n- Phone : " + phone + "\n"
                    + "\nOrder Information" + msg + "\n";
        }

    }

    class OrderControl implements OrderControlMediator {

        private List<Customer> customer;

        public OrderControl() {
            this.customer = new ArrayList<>();
        }

        @Override
        public void addCustomer(Customer customer) {
            this.customer.add(customer);
        }

        @Override
        public void sendInfo(String msg, Customer customer) {
            for (Customer u : this.customer) {

                if (u != customer) {
                    u.request(msg);
                }
            }
        }

    }

    public interface OrderControlMediator {

        public void sendInfo(String msg, Customer customer);

        void addCustomer(Customer customer);
    }

    //-------------------------------------------------------
    //FlyWeight Pattern
    interface Ingredient {

        public void Topping(String topping);

        public void customize();
    }

    class ConcreteIngredient implements Ingredient {

        //Intrinsic Attribute
        private final String name;
        private final String portion;

        //Extrinsic Attribute
        private String topping;

        public ConcreteIngredient() {
            name = FoodCorner.comboName.getSelectedItem().toString();
            portion = FoodCorner.comboPortion.getSelectedItem().toString();
        }

        @Override
        public void Topping(String topping) {
            this.topping = topping;
        }

        @Override
        public void customize() {

            lblName.setText("Name : " + name);
            lblPortion.setText("Portion : " + portion);
            lblTopping.setText("Topping : " + topping);

            JOptionPane.showMessageDialog(null,
                    "Name : " + name
                    + newline + "Portion : " + portion);

            if (!checkExtraCheese.isSelected() && !checkExtraLettuce.isSelected() && !checkOnions.isSelected()) {
                JOptionPane.showMessageDialog(null, "The Ingredient has No Topping");
            } else {
                JOptionPane.showMessageDialog(null, "Topping : " + topping);
            }

        }
    }

    //----------------------------------------------------
    //Interpreter Pattern
    interface Expression {

        public abstract String interpret(OrderInterpreter orderInterpreter);
    }

    class OrderInterpreter {

        public String command1(String inputData) {
            String[] tokens = interpret(inputData);

            if (true) {
                return "Large Plate";

            }
            return null;
        }

        public String command2(String inputData) {

            if (true) {
                return "Small Plate";

            }
            return null;
        }

        public String command3(String inputData) {

            if (true) {
                return "Medium Plate";

            }
            return null;
        }

        private String[] interpret(String inputData) {
            String tempInputData = inputData.replaceAll("[ ]", " ");
            tempInputData = tempInputData.replaceAll("( )+", " ").trim();
            String[] inputDatatokens = tempInputData.split(" ");
            return inputDatatokens;
        }
    }

    class ExtraExpression implements Expression {

        private final String expression;

        public ExtraExpression(String expression) {
            this.expression = expression;
        }

        @Override
        public String interpret(OrderInterpreter orderInterpreter) {
            return orderInterpreter.command1(expression);
        }
    }

    class LessExpression implements Expression {

        private final String expression;

        public LessExpression(String expression) {
            this.expression = expression;
        }

        @Override
        public String interpret(OrderInterpreter interpreterEngine) {
            return interpreterEngine.command2(expression);
        }
    }

    class MediumExpression implements Expression {

        private final String expression;

        public MediumExpression(String expression) {
            this.expression = expression;
        }

        @Override
        public String interpret(OrderInterpreter interpreterEngine) {
            return interpreterEngine.command3(expression);
        }
    }

    class Interpret {

        private final OrderInterpreter orderInterpreter;

        public Interpret(OrderInterpreter orderInterpreter) {
            this.orderInterpreter = orderInterpreter;
        }

        public String interpret(String inputData) throws Exception {
            Expression expression = null;

            String[] extraWords = {"extra", "more", "additional"};
            String[] lessWords = {"without", "less", "no"};
            String[] mediumWords = {"medium", "with", "and"};

            boolean isValidExpression = false;

            for (String extraWord : extraWords) {
                if (inputData.toLowerCase().contains(extraWord)) {
                    expression = new ExtraExpression(inputData);
                    isValidExpression = true;
                    break;
                }
            }

            if (!isValidExpression) {
                for (String lessWord : lessWords) {
                    if (inputData.toLowerCase().contains(lessWord)) {
                        expression = new LessExpression(inputData);
                        isValidExpression = true;
                        break;
                    }
                }
            }

            if (!isValidExpression) {
                for (String mediumWord : mediumWords) {
                    if (inputData.toLowerCase().contains(mediumWord)) {
                        expression = new MediumExpression(inputData);
                        isValidExpression = true;
                        break;
                    }
                }
            }

            if (!isValidExpression) {
                try {
                    JOptionPane.showMessageDialog(null, "'" + inputData + "'" + " is an Invalid Expression!");
                } catch (HeadlessException e) {
                }
            }
            try {
                String result = expression.interpret(orderInterpreter);
                return result;
            } catch (Exception e) {
            }
            return null;
        }
    }

    //-------------------------------------------------------------
    //Chain of Responsibility Pattern
    private void buildChain() {
        chain = new AcceptingStep(
                new CookingStep(
                        new PackingStep(
                                new HandoverStep(
                                        new CheckBalance(null)))));
    }

    public void cardTypeValidation(AcceptingStepValidation request) {
        chain.acceptingStep(request);
    }

    public void cardExpDateValidation(CookingStepValidation request) {
        chain.cookingStepValidation(request);
    }

    public void cardPinNoValidation(PackingStepValidation request) {
        chain.packingStepValidation(request);
    }

    public void process(Balance request) {
        chain.process(request);
    }

    //handler
    abstract class OrderStep {

        private OrderStep nextStep;
        private OrderStep nextProcess;

        public OrderStep(OrderStep nextProcess) {
            this.nextProcess = nextProcess;
        }

        public void process(Balance request) {
            if (nextProcess != null) {
                nextProcess.process(request);
            }
        }

        public void acceptingStep(AcceptingStepValidation validate) {
            if (nextStep != null) {
                nextStep.acceptingStep(validate);
            }
        }

        public void cookingStepValidation(CookingStepValidation validate) {
            if (nextStep != null) {
                nextStep.cookingStepValidation(validate);
            }
        }

        public void packingStepValidation(PackingStepValidation validate) {
            if (nextStep != null) {
                nextStep.packingStepValidation(validate);
            }
        }

    }

    class AcceptingStepValidation {

        private final String acceptingStep;

        public AcceptingStepValidation(String acceptingStep) {
            this.acceptingStep = acceptingStep;
        }

        public String getAcceptingStep() {
            return acceptingStep;
        }

    }

    class CookingStepValidation {

        private final String cookingStep;

        public CookingStepValidation(String cookingStep) {
            this.cookingStep = cookingStep;
        }

        public String getCookingStep() {
            return cookingStep;
        }

    }

    class PackingStepValidation {

        private final String packingStep;

        public PackingStepValidation(String packingStep) {
            this.packingStep = packingStep;
        }

        public String getPackingStep() {
            return packingStep;
        }

    }

    class Balance {

        private double balance;

        public Balance(double balance) {
            this.balance = balance;
        }

        public double getBalance() {
            return balance;
        }

    }

    class AcceptingStep extends OrderStep {

        public AcceptingStep(OrderStep handleStep) {
            super(handleStep);
        }

        @Override
        public void acceptingStep(AcceptingStepValidation request) {
            if (null == request.getAcceptingStep()) {
                super.acceptingStep(request);
            } else {
                switch (request.getAcceptingStep()) {
                    case "Accept":
                        JOptionPane.showMessageDialog(getParent(), "Accepting Step : Accepted!");
                        break;
                    case "Decline":
                        JOptionPane.showMessageDialog(getParent(), "Accepting Step : Declined!");
                        break;
                    default:
                        super.acceptingStep(request);
                        break;
                }
            }
        }
    }

    class CookingStep extends OrderStep {

        public CookingStep(OrderStep nextProcess) {
            super(nextProcess);
        }

        @Override
        public void cookingStepValidation(CookingStepValidation request) {
            if (("".equals(request.getCookingStep()))) {
                JOptionPane.showMessageDialog(getParent(), "Cooking Step : Uncooked!");
            } else {
                super.cookingStepValidation(request);
                JOptionPane.showMessageDialog(getParent(), "Cooking Step : Cooked!");
            }
        }
    }

    class PackingStep extends OrderStep {

        public PackingStep(OrderStep nextProcess) {
            super(nextProcess);
        }

        @Override
        public void packingStepValidation(PackingStepValidation request) {
            if (("".equals(request.getPackingStep()))) {
                JOptionPane.showMessageDialog(getParent(), "Packing Step : Unpacked!");
            } else {
                super.packingStepValidation(request);
                JOptionPane.showMessageDialog(getParent(), "Packing Step : Packed!");
            }
        }
    }

    class HandoverStep extends OrderStep {

        public HandoverStep(OrderStep nextProcessor) {
            super(nextProcessor);

        }

        @Override
        public void process(Balance request) {
            if ((request.getBalance() == 0.00)) {
                double total = Double.parseDouble(txtBalance.getText());
                JOptionPane.showMessageDialog(getParent(), "Total Balance : " + df.format(total) + " LKR");
                lblTotalBalance.setText("Total Balance: " + df.format(total) + " LKR");
                txtBalance.setText(df.format(total));
            } else {
                super.process(request);
                JOptionPane.showMessageDialog(getParent(), "Handover Step : Handedover");
            }
        }
    }

    class CheckBalance extends OrderStep {

        public CheckBalance(OrderStep nextProcessor) {
            super(nextProcessor);
        }

        @Override
        public void process(Balance request) {
            super.process(request);
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnPrepare = new javax.swing.JButton();
        comboMealType = new javax.swing.JComboBox<>();
        comboMealName = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        comboMealPacking = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtMealPrice = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel29 = new javax.swing.JPanel();
        lblItem = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        lblPacking = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        lblItem1 = new javax.swing.JLabel();
        lblPacking1 = new javax.swing.JLabel();
        lblPrice1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        checkExtraCheese = new javax.swing.JCheckBox();
        checkExtraLettuce = new javax.swing.JCheckBox();
        checkOnions = new javax.swing.JCheckBox();
        jLabel15 = new javax.swing.JLabel();
        pnlCheese = new javax.swing.JPanel();
        pnlLettuce = new javax.swing.JPanel();
        pnlOnions = new javax.swing.JPanel();
        btnCustomize = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblPortion = new javax.swing.JLabel();
        lblTopping = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txtCombinations1 = new javax.swing.JLabel();
        txtCombinations2 = new javax.swing.JLabel();
        comboName = new javax.swing.JComboBox<>();
        comboPortion = new javax.swing.JComboBox<>();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        lblOutput = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        textAreaOutput = new javax.swing.JTextArea();
        jPanel17 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        txtCombinations4 = new javax.swing.JLabel();
        txtInput = new javax.swing.JTextField();
        btnFormat = new javax.swing.JButton();
        btnClear1 = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        cardMain = new javax.swing.JPanel();
        pnlCardRegister = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        txtCombinations5 = new javax.swing.JLabel();
        txtCustomerName = new javax.swing.JTextField();
        btnRegister = new javax.swing.JButton();
        btnClearRegVehicle = new javax.swing.JButton();
        txtCombinations6 = new javax.swing.JLabel();
        comboMembership = new javax.swing.JComboBox<>();
        btnFormat2 = new javax.swing.JButton();
        txtCombinations8 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        pnlCardCustomerData = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        btnFormat4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        pnlCardOrderInfo = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        comboLanes = new javax.swing.JComboBox<>();
        txtCombinations10 = new javax.swing.JLabel();
        btnRequestInfo = new javax.swing.JButton();
        txtCombinations9 = new javax.swing.JLabel();
        txtDisplayCustomerName = new javax.swing.JTextField();
        txtCombinations11 = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        btnClear2 = new javax.swing.JButton();
        btnClear3 = new javax.swing.JButton();
        jPanel22 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        pnlAccepting = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        comboAcceptingStep = new javax.swing.JComboBox<>();
        pnlCooking = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        btnCurBalanceNext = new javax.swing.JButton();
        btnCurBalancePrev = new javax.swing.JButton();
        comboCookingStep = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        pnlPacking = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        btnOptionsNext = new javax.swing.JButton();
        btnOptionsPrev = new javax.swing.JButton();
        comboPackingStep = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        pnlHandover = new javax.swing.JPanel();
        pnlPaidAmount = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        txtPaidAmount = new javax.swing.JTextField();
        btnDeposit = new javax.swing.JButton();
        jPanel27 = new javax.swing.JPanel();
        lblTotalBalance = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        btnViewReceipt = new javax.swing.JButton();
        btnNewOrder = new javax.swing.JButton();
        txtBalance = new javax.swing.JTextField();
        pnlDuePayAmount = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        txtDuePayAmount = new javax.swing.JTextField();
        btnDuePay = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Syzygy Food Corner");
        setBackground(new java.awt.Color(80, 80, 80));
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Meal Builder");

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
        jLabel12.setText("Prepare Meal");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Meal Type");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Name");

        btnPrepare.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnPrepare.setText("Prepare");
        btnPrepare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrepareActionPerformed(evt);
            }
        });

        comboMealType.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboMealType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Veg Meal", "Non-Veg Meal" }));
        comboMealType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMealTypeActionPerformed(evt);
            }
        });
        comboMealType.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                comboMealTypeKeyPressed(evt);
            }
        });

        comboMealName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboMealName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        comboMealName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMealNameActionPerformed(evt);
            }
        });
        comboMealName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                comboMealNameKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Packing");

        comboMealPacking.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboMealPacking.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", " " }));
        comboMealPacking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMealPackingActionPerformed(evt);
            }
        });
        comboMealPacking.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                comboMealPackingKeyPressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Price");

        txtMealPrice.setEditable(false);
        txtMealPrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMealPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMealPriceKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboMealType, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboMealName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboMealPacking, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMealPrice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnPrepare, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 23, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel12)
                .addGap(50, 50, 50)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboMealType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboMealName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(comboMealPacking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtMealPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(btnPrepare)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));
        jPanel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Data");

        jScrollPane1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTable1.setForeground(new java.awt.Color(51, 51, 51));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Type", "Name", "Packing", "Price"
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel29.setBackground(new java.awt.Color(51, 51, 51));
        jPanel29.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        lblItem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblItem.setForeground(new java.awt.Color(255, 255, 255));
        lblItem.setText("N/A");

        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Receipt");

        lblPacking.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPacking.setForeground(new java.awt.Color(255, 255, 255));
        lblPacking.setText("N/A");

        lblPrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPrice.setForeground(new java.awt.Color(255, 255, 255));
        lblPrice.setText("0.0");

        lblItem1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblItem1.setForeground(new java.awt.Color(255, 255, 255));
        lblItem1.setText("Item : ");

        lblPacking1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPacking1.setForeground(new java.awt.Color(255, 255, 255));
        lblPacking1.setText("Packing : ");

        lblPrice1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPrice1.setForeground(new java.awt.Color(255, 255, 255));
        lblPrice1.setText("Total Cost : ");

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addComponent(lblPrice1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel29Layout.createSequentialGroup()
                            .addComponent(lblPacking1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblPacking, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel29Layout.createSequentialGroup()
                            .addComponent(lblItem1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblItem, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblItem1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblItem, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPacking1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPacking, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrice1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Builder", jPanel1);

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Ingredient Customizer");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel13)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(80, 80, 80));

        jPanel10.setBackground(new java.awt.Color(51, 51, 51));
        jPanel10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        checkExtraCheese.setBackground(new java.awt.Color(51, 51, 51));
        checkExtraCheese.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        checkExtraCheese.setForeground(new java.awt.Color(255, 255, 255));
        checkExtraCheese.setText("Extra Cheese");
        checkExtraCheese.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkExtraCheeseMouseClicked(evt);
            }
        });

        checkExtraLettuce.setBackground(new java.awt.Color(51, 51, 51));
        checkExtraLettuce.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        checkExtraLettuce.setForeground(new java.awt.Color(255, 255, 255));
        checkExtraLettuce.setText("Extra Lettuce");
        checkExtraLettuce.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkExtraLettuceMouseClicked(evt);
            }
        });

        checkOnions.setBackground(new java.awt.Color(51, 51, 51));
        checkOnions.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        checkOnions.setForeground(new java.awt.Color(255, 255, 255));
        checkOnions.setText("Extra Onions");
        checkOnions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkOnionsMouseClicked(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Topping");

        pnlCheese.setBackground(new java.awt.Color(102, 102, 102));
        pnlCheese.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        javax.swing.GroupLayout pnlCheeseLayout = new javax.swing.GroupLayout(pnlCheese);
        pnlCheese.setLayout(pnlCheeseLayout);
        pnlCheeseLayout.setHorizontalGroup(
            pnlCheeseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlCheeseLayout.setVerticalGroup(
            pnlCheeseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlLettuce.setBackground(new java.awt.Color(102, 102, 102));
        pnlLettuce.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        javax.swing.GroupLayout pnlLettuceLayout = new javax.swing.GroupLayout(pnlLettuce);
        pnlLettuce.setLayout(pnlLettuceLayout);
        pnlLettuceLayout.setHorizontalGroup(
            pnlLettuceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 93, Short.MAX_VALUE)
        );
        pnlLettuceLayout.setVerticalGroup(
            pnlLettuceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlOnions.setBackground(new java.awt.Color(102, 102, 102));
        pnlOnions.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        javax.swing.GroupLayout pnlOnionsLayout = new javax.swing.GroupLayout(pnlOnions);
        pnlOnions.setLayout(pnlOnionsLayout);
        pnlOnionsLayout.setHorizontalGroup(
            pnlOnionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 93, Short.MAX_VALUE)
        );
        pnlOnionsLayout.setVerticalGroup(
            pnlOnionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        btnCustomize.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCustomize.setText("Customize");
        btnCustomize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomizeActionPerformed(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(checkExtraCheese)
                            .addComponent(checkExtraLettuce, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(checkOnions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlOnions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(pnlLettuce, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pnlCheese, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(btnCustomize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(checkExtraCheese, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(pnlCheese, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlLettuce, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(checkExtraLettuce, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(checkOnions, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(pnlOnions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(49, 49, 49)
                .addComponent(btnCustomize)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnClear)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(51, 51, 51));
        jPanel11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        lblName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblName.setForeground(new java.awt.Color(255, 255, 255));
        lblName.setText("Name : N/A");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Customized Ingredient");

        lblPortion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPortion.setForeground(new java.awt.Color(255, 255, 255));
        lblPortion.setText("Portion : N/A");

        lblTopping.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTopping.setForeground(new java.awt.Color(255, 255, 255));
        lblTopping.setText("Topping : N/A");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPortion, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                            .addComponent(lblTopping, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPortion, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTopping, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(51, 51, 51));
        jPanel12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Ingredient");

        txtCombinations1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCombinations1.setForeground(new java.awt.Color(255, 255, 255));
        txtCombinations1.setText("Name");

        txtCombinations2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCombinations2.setForeground(new java.awt.Color(255, 255, 255));
        txtCombinations2.setText("Portion");

        comboName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Cheese", "Lettuce" }));
        comboName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                comboNameKeyPressed(evt);
            }
        });

        comboPortion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboPortion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Small", "Medium", "Large" }));
        comboPortion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                comboPortionKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(txtCombinations2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboPortion, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(txtCombinations1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboName, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCombinations1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCombinations2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboPortion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Flyweight", jPanel5);

        jPanel14.setBackground(new java.awt.Color(51, 51, 51));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Interpret Order");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel18)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel15.setBackground(new java.awt.Color(80, 80, 80));

        jPanel16.setBackground(new java.awt.Color(51, 51, 51));
        jPanel16.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        lblOutput.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        lblOutput.setForeground(new java.awt.Color(255, 255, 255));
        lblOutput.setText("N/A");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Output");

        textAreaOutput.setBackground(new java.awt.Color(51, 51, 51));
        textAreaOutput.setColumns(20);
        textAreaOutput.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        textAreaOutput.setForeground(new java.awt.Color(255, 255, 255));
        textAreaOutput.setRows(5);
        textAreaOutput.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 51, 51)));
        jScrollPane4.setViewportView(textAreaOutput);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(lblOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(18, 18, 18)
                        .addComponent(lblOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel17.setBackground(new java.awt.Color(51, 51, 51));
        jPanel17.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Place Order");

        txtCombinations4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCombinations4.setForeground(new java.awt.Color(255, 255, 255));
        txtCombinations4.setText("Input");

        txtInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtInputKeyPressed(evt);
            }
        });

        btnFormat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnFormat.setText("Place the Order");
        btnFormat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFormatActionPerformed(evt);
            }
        });

        btnClear1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnClear1.setText("Clear");
        btnClear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClear1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(txtCombinations4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtInput, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnFormat, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnClear1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel20)
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCombinations4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFormat)
                    .addComponent(btnClear1))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap(89, Short.MAX_VALUE)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Interpreter", jPanel13);

        jPanel19.setBackground(new java.awt.Color(51, 51, 51));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Pick Up Food Order");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 841, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel21)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel20.setBackground(new java.awt.Color(80, 80, 80));

        cardMain.setLayout(new java.awt.CardLayout());

        pnlCardRegister.setBackground(new java.awt.Color(51, 51, 51));
        pnlCardRegister.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Register Customer");

        txtCombinations5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCombinations5.setForeground(new java.awt.Color(255, 255, 255));
        txtCombinations5.setText("Customer Name");

        txtCustomerName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCustomerName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCustomerNameKeyPressed(evt);
            }
        });

        btnRegister.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        btnClearRegVehicle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnClearRegVehicle.setText("Clear");
        btnClearRegVehicle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearRegVehicleActionPerformed(evt);
            }
        });

        txtCombinations6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCombinations6.setForeground(new java.awt.Color(255, 255, 255));
        txtCombinations6.setText("Membership");

        comboMembership.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboMembership.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bronze Level", "Silver Level", "Gold Level", "Platinum Level" }));
        comboMembership.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                comboMembershipKeyPressed(evt);
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
        txtCombinations8.setText("Phone");

        txtPhone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPhoneKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout pnlCardRegisterLayout = new javax.swing.GroupLayout(pnlCardRegister);
        pnlCardRegister.setLayout(pnlCardRegisterLayout);
        pnlCardRegisterLayout.setHorizontalGroup(
            pnlCardRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCardRegisterLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addGroup(pnlCardRegisterLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(pnlCardRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFormat2)
                    .addGroup(pnlCardRegisterLayout.createSequentialGroup()
                        .addComponent(btnRegister)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClearRegVehicle))
                    .addGroup(pnlCardRegisterLayout.createSequentialGroup()
                        .addGroup(pnlCardRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCombinations5)
                            .addComponent(txtCombinations6)
                            .addComponent(txtCombinations8))
                        .addGap(24, 24, 24)
                        .addGroup(pnlCardRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboMembership, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 170, Short.MAX_VALUE))
        );
        pnlCardRegisterLayout.setVerticalGroup(
            pnlCardRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCardRegisterLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel22)
                .addGap(27, 27, 27)
                .addGroup(pnlCardRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCombinations5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCardRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCombinations6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboMembership, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCardRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCombinations8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(pnlCardRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClearRegVehicle)
                    .addComponent(btnRegister))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFormat2)
                .addContainerGap(134, Short.MAX_VALUE))
        );

        cardMain.add(pnlCardRegister, "card2");

        pnlCardCustomerData.setBackground(new java.awt.Color(51, 51, 51));
        pnlCardCustomerData.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Customer Data");

        btnFormat4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnFormat4.setText("Back");
        btnFormat4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFormat4ActionPerformed(evt);
            }
        });

        jScrollPane2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTable2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTable2.setForeground(new java.awt.Color(51, 51, 51));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer Name", "Membership", "Phone"
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
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout pnlCardCustomerDataLayout = new javax.swing.GroupLayout(pnlCardCustomerData);
        pnlCardCustomerData.setLayout(pnlCardCustomerDataLayout);
        pnlCardCustomerDataLayout.setHorizontalGroup(
            pnlCardCustomerDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCardCustomerDataLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(213, 213, 213))
            .addGroup(pnlCardCustomerDataLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(pnlCardCustomerDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFormat4)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 33, Short.MAX_VALUE))
        );
        pnlCardCustomerDataLayout.setVerticalGroup(
            pnlCardCustomerDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCardCustomerDataLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel23)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(btnFormat4)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        cardMain.add(pnlCardCustomerData, "card2");

        pnlCardOrderInfo.setBackground(new java.awt.Color(51, 51, 51));
        pnlCardOrderInfo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Order Information");

        btnReset.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        jScrollPane3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTable3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTable3.setForeground(new java.awt.Color(51, 51, 51));
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order No.", "Availability", "Order Details"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.setToolTipText("");
        jTable3.getTableHeader().setReorderingAllowed(false);
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        comboLanes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboLanes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Order 1", "Order 2", "Order 3", "Order 4", "Order 5", "Order 6", "Order 7", "Order 8", "Order 9", "Order 10", "Order 11", "Order 12", "Order 13", "Order 14" }));

        txtCombinations10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCombinations10.setForeground(new java.awt.Color(255, 255, 255));
        txtCombinations10.setText("Select Order");

        btnRequestInfo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRequestInfo.setText("Request order");
        btnRequestInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestInfoActionPerformed(evt);
            }
        });

        txtCombinations9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCombinations9.setForeground(new java.awt.Color(255, 255, 255));
        txtCombinations9.setText("Driver's Name");

        txtDisplayCustomerName.setEditable(false);
        txtDisplayCustomerName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDisplayCustomerName.setEnabled(false);

        txtCombinations11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCombinations11.setForeground(new java.awt.Color(255, 255, 255));
        txtCombinations11.setText("Customer");

        lblPhone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPhone.setForeground(new java.awt.Color(51, 51, 51));
        lblPhone.setText("Number Plate");

        javax.swing.GroupLayout pnlCardOrderInfoLayout = new javax.swing.GroupLayout(pnlCardOrderInfo);
        pnlCardOrderInfo.setLayout(pnlCardOrderInfoLayout);
        pnlCardOrderInfoLayout.setHorizontalGroup(
            pnlCardOrderInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCardOrderInfoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(213, 213, 213))
            .addGroup(pnlCardOrderInfoLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(pnlCardOrderInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnlCardOrderInfoLayout.createSequentialGroup()
                        .addComponent(btnRequestInfo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReset)
                        .addGap(103, 103, 103)
                        .addComponent(lblPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlCardOrderInfoLayout.createSequentialGroup()
                        .addComponent(txtCombinations11, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDisplayCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCombinations10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboLanes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlCardOrderInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlCardOrderInfoLayout.createSequentialGroup()
                    .addGap(124, 124, 124)
                    .addComponent(txtCombinations9, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(350, Short.MAX_VALUE)))
        );
        pnlCardOrderInfoLayout.setVerticalGroup(
            pnlCardOrderInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCardOrderInfoLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel24)
                .addGap(18, 18, 18)
                .addGroup(pnlCardOrderInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCardOrderInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboLanes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCombinations10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCardOrderInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtCombinations11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDisplayCustomerName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(pnlCardOrderInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReset)
                    .addComponent(btnRequestInfo)
                    .addComponent(lblPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(pnlCardOrderInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlCardOrderInfoLayout.createSequentialGroup()
                    .addGap(199, 199, 199)
                    .addComponent(txtCombinations9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(200, Short.MAX_VALUE)))
        );

        cardMain.add(pnlCardOrderInfo, "card2");

        jPanel21.setBackground(new java.awt.Color(51, 51, 51));
        jPanel21.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Order Control");

        btnClear2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnClear2.setText("Register");
        btnClear2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClear2ActionPerformed(evt);
            }
        });

        btnClear3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnClear3.setText("Pickup Orders");
        btnClear3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClear3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnClear3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnClear2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 14, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel25)
                .addGap(18, 18, 18)
                .addComponent(btnClear2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnClear3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cardMain, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cardMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Mediator", jPanel18);

        jPanel23.setBackground(new java.awt.Color(51, 51, 51));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Food Order Processing");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel26)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel24.setLayout(new java.awt.CardLayout());

        pnlAccepting.setBackground(new java.awt.Color(80, 80, 80));

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Accepting Step");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Order Step");

        btnSubmit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        comboAcceptingStep.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboAcceptingStep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Accept", "Decline" }));
        comboAcceptingStep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                comboAcceptingStepKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSubmit)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addGap(20, 20, 20)
                                .addComponent(comboAcceptingStep, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel27)
                .addGap(52, 52, 52)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(comboAcceptingStep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addComponent(btnSubmit)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlAcceptingLayout = new javax.swing.GroupLayout(pnlAccepting);
        pnlAccepting.setLayout(pnlAcceptingLayout);
        pnlAcceptingLayout.setHorizontalGroup(
            pnlAcceptingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAcceptingLayout.createSequentialGroup()
                .addContainerGap(236, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(236, Short.MAX_VALUE))
        );
        pnlAcceptingLayout.setVerticalGroup(
            pnlAcceptingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAcceptingLayout.createSequentialGroup()
                .addContainerGap(120, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
        );

        jPanel24.add(pnlAccepting, "card2");

        pnlCooking.setBackground(new java.awt.Color(80, 80, 80));

        jPanel25.setBackground(new java.awt.Color(51, 51, 51));
        jPanel25.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        jPanel25.setPreferredSize(new java.awt.Dimension(417, 256));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Cooking Step");

        btnCurBalanceNext.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCurBalanceNext.setText("Next");
        btnCurBalanceNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCurBalanceNextActionPerformed(evt);
            }
        });

        btnCurBalancePrev.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCurBalancePrev.setText("Previous");
        btnCurBalancePrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCurBalancePrevActionPerformed(evt);
            }
        });

        comboCookingStep.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboCookingStep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cook", "Uncook" }));
        comboCookingStep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                comboCookingStepKeyPressed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Order Step");

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(btnCurBalancePrev, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCurBalanceNext, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addGap(20, 20, 20)
                        .addComponent(comboCookingStep, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 66, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel31)
                .addGap(43, 43, 43)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(comboCookingStep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCurBalanceNext)
                    .addComponent(btnCurBalancePrev))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlCookingLayout = new javax.swing.GroupLayout(pnlCooking);
        pnlCooking.setLayout(pnlCookingLayout);
        pnlCookingLayout.setHorizontalGroup(
            pnlCookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCookingLayout.createSequentialGroup()
                .addContainerGap(236, Short.MAX_VALUE)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(236, Short.MAX_VALUE))
        );
        pnlCookingLayout.setVerticalGroup(
            pnlCookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCookingLayout.createSequentialGroup()
                .addContainerGap(121, Short.MAX_VALUE)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
        );

        jPanel24.add(pnlCooking, "card2");

        pnlPacking.setBackground(new java.awt.Color(80, 80, 80));

        jPanel26.setBackground(new java.awt.Color(51, 51, 51));
        jPanel26.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        jPanel26.setPreferredSize(new java.awt.Dimension(417, 256));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Packing Step");

        btnOptionsNext.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnOptionsNext.setText("Next");
        btnOptionsNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOptionsNextActionPerformed(evt);
            }
        });

        btnOptionsPrev.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnOptionsPrev.setText("Previous");
        btnOptionsPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOptionsPrevActionPerformed(evt);
            }
        });

        comboPackingStep.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboPackingStep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pack", "Unpack" }));
        comboPackingStep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                comboPackingStepKeyPressed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Order Step");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(btnOptionsPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOptionsNext, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel26Layout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel26Layout.createSequentialGroup()
                            .addGap(70, 70, 70)
                            .addComponent(jLabel30)
                            .addGap(20, 20, 20)
                            .addComponent(comboPackingStep, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel33)
                .addGap(47, 47, 47)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(comboPackingStep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOptionsNext)
                    .addComponent(btnOptionsPrev))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout pnlPackingLayout = new javax.swing.GroupLayout(pnlPacking);
        pnlPacking.setLayout(pnlPackingLayout);
        pnlPackingLayout.setHorizontalGroup(
            pnlPackingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPackingLayout.createSequentialGroup()
                .addContainerGap(236, Short.MAX_VALUE)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(236, Short.MAX_VALUE))
        );
        pnlPackingLayout.setVerticalGroup(
            pnlPackingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPackingLayout.createSequentialGroup()
                .addContainerGap(121, Short.MAX_VALUE)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
        );

        jPanel24.add(pnlPacking, "card2");

        pnlHandover.setBackground(new java.awt.Color(80, 80, 80));

        pnlPaidAmount.setBackground(new java.awt.Color(51, 51, 51));
        pnlPaidAmount.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Paid Amount");

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("LKR");

        txtPaidAmount.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPaidAmount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtPaidAmount.setText("0.00");
        txtPaidAmount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPaidAmountMouseClicked(evt);
            }
        });
        txtPaidAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPaidAmountKeyTyped(evt);
            }
        });

        btnDeposit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDeposit.setText("Submit");
        btnDeposit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepositActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPaidAmountLayout = new javax.swing.GroupLayout(pnlPaidAmount);
        pnlPaidAmount.setLayout(pnlPaidAmountLayout);
        pnlPaidAmountLayout.setHorizontalGroup(
            pnlPaidAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPaidAmountLayout.createSequentialGroup()
                .addGroup(pnlPaidAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPaidAmountLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlPaidAmountLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(pnlPaidAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDeposit, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(txtPaidAmount))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel36)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlPaidAmountLayout.setVerticalGroup(
            pnlPaidAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPaidAmountLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel35)
                .addGap(18, 18, 18)
                .addGroup(pnlPaidAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(txtPaidAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(btnDeposit)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel27.setBackground(new java.awt.Color(51, 51, 51));
        jPanel27.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        lblTotalBalance.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTotalBalance.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalBalance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalBalance.setText("Total Balance: 0.00 LKR");
        lblTotalBalance.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Transaction Status");

        btnViewReceipt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnViewReceipt.setText("View Receipt");
        btnViewReceipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewReceiptActionPerformed(evt);
            }
        });

        btnNewOrder.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnNewOrder.setText("New Order");
        btnNewOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewOrderActionPerformed(evt);
            }
        });

        txtBalance.setEditable(false);
        txtBalance.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBalance.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtBalance.setText("0.00");
        txtBalance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBalanceMouseClicked(evt);
            }
        });
        txtBalance.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBalanceKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel34)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(btnViewReceipt, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNewOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblTotalBalance, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                    .addComponent(txtBalance))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel34)
                .addGap(18, 18, 18)
                .addComponent(lblTotalBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnViewReceipt)
                    .addComponent(btnNewOrder))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlDuePayAmount.setBackground(new java.awt.Color(51, 51, 51));
        pnlDuePayAmount.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Due Pay Amount");

        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("LKR");

        txtDuePayAmount.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDuePayAmount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtDuePayAmount.setText("0.00");
        txtDuePayAmount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDuePayAmountMouseClicked(evt);
            }
        });
        txtDuePayAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDuePayAmountKeyTyped(evt);
            }
        });

        btnDuePay.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDuePay.setText("Due Pay");
        btnDuePay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDuePayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDuePayAmountLayout = new javax.swing.GroupLayout(pnlDuePayAmount);
        pnlDuePayAmount.setLayout(pnlDuePayAmountLayout);
        pnlDuePayAmountLayout.setHorizontalGroup(
            pnlDuePayAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDuePayAmountLayout.createSequentialGroup()
                .addGroup(pnlDuePayAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDuePayAmountLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDuePayAmountLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(pnlDuePayAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDuePay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDuePayAmount, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel41)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        pnlDuePayAmountLayout.setVerticalGroup(
            pnlDuePayAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDuePayAmountLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel40)
                .addGap(18, 18, 18)
                .addGroup(pnlDuePayAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(txtDuePayAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(btnDuePay)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlHandoverLayout = new javax.swing.GroupLayout(pnlHandover);
        pnlHandover.setLayout(pnlHandoverLayout);
        pnlHandoverLayout.setHorizontalGroup(
            pnlHandoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHandoverLayout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(pnlHandoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlDuePayAmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlPaidAmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
        );
        pnlHandoverLayout.setVerticalGroup(
            pnlHandoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHandoverLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(pnlHandoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlHandoverLayout.createSequentialGroup()
                        .addComponent(pnlDuePayAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlPaidAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        jPanel24.add(pnlHandover, "card2");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Chain of Responsibility", jPanel22);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 855, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Builder");

        setSize(new java.awt.Dimension(871, 621));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrepareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrepareActionPerformed
        PrepareMeal();
        InsertDataToTable();
    }//GEN-LAST:event_btnPrepareActionPerformed

    private void comboMealTypeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboMealTypeKeyPressed
        if (evt.getKeyCode() == 10) {
            comboMealName.setPopupVisible(true);
            comboMealName.grabFocus();

            switch (comboMealType.getSelectedIndex()) {
                case 1:
                    comboMealName.removeAllItems();
                    comboMealName.addItem("Select");
                    comboMealName.addItem("Veg Burger");
                    comboMealName.addItem("Coke");
                    comboMealName.addItem("Pepsi");

                    break;
                case 2:
                    comboMealName.removeAllItems();
                    comboMealName.addItem("Select");
                    comboMealName.addItem("Chicken Burger");
                    comboMealName.addItem("Coke");
                    comboMealName.addItem("Pepsi");
                    break;
                default:
                    comboMealName.removeAllItems();
                    comboMealName.addItem("Select");
                    break;
            }
        }
    }//GEN-LAST:event_comboMealTypeKeyPressed

    private void comboMealNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboMealNameKeyPressed
        if (evt.getKeyCode() == 10) {
            comboMealPacking.setPopupVisible(true);
            comboMealPacking.grabFocus();

            switch (comboMealName.getSelectedIndex()) {
                case 1:
                    comboMealPacking.removeAllItems();
                    comboMealPacking.addItem("Select");
                    comboMealPacking.addItem("Wrap");
                    break;
                case 2:

                    comboMealPacking.removeAllItems();
                    comboMealPacking.addItem("Select");
                    comboMealPacking.addItem("Bottle");
                    break;
                case 3:
                    comboMealPacking.removeAllItems();
                    comboMealPacking.addItem("Select");
                    comboMealPacking.addItem("Bottle");
                    break;
                default:
                    comboMealPacking.removeAllItems();
                    comboMealPacking.addItem("Select");
                    break;
            }
        }
    }//GEN-LAST:event_comboMealNameKeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        String newline = System.getProperty("line.separator");

        String f1 = ((String) jTable1.getValueAt(jTable1.getSelectedRow(), 0));
        String f2 = ((String) jTable1.getValueAt(jTable1.getSelectedRow(), 1));
        String f3 = ((String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 2))));
        String f4 = ((String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 3))));

        String row = "Meal Type: " + f1 + newline
                + "Meal Name: " + f2 + newline
                + "Meal Packing: " + f3 + newline
                + "Meal Price: " + f4;

        JOptionPane.showMessageDialog(this, row);
    }//GEN-LAST:event_jTable1MouseClicked

    private void checkExtraCheeseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkExtraCheeseMouseClicked
        checkExtraCheese.setSelected(true);
        checkExtraLettuce.setSelected(false);
        checkOnions.setSelected(false);

        pnlCheese.setBackground(new Color(255, 255, 0));
        pnlLettuce.setBackground(new Color(102, 102, 102));
        pnlOnions.setBackground(new Color(102, 102, 102));
    }//GEN-LAST:event_checkExtraCheeseMouseClicked

    private void checkExtraLettuceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkExtraLettuceMouseClicked
        checkExtraCheese.setSelected(false);
        checkExtraLettuce.setSelected(true);
        checkOnions.setSelected(false);

        pnlCheese.setBackground(new Color(102, 102, 102));
        pnlLettuce.setBackground(new Color(118, 220, 40));
        pnlOnions.setBackground(new Color(102, 102, 102));
    }//GEN-LAST:event_checkExtraLettuceMouseClicked

    private void checkOnionsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkOnionsMouseClicked
        checkExtraCheese.setSelected(false);
        checkExtraLettuce.setSelected(false);
        checkOnions.setSelected(true);

        pnlCheese.setBackground(new Color(102, 102, 102));
        pnlLettuce.setBackground(new Color(102, 102, 102));
        pnlOnions.setBackground(new Color(110, 40, 220));
    }//GEN-LAST:event_checkOnionsMouseClicked

    private void btnCustomizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomizeActionPerformed

        if ((comboName.getSelectedIndex() == 0)
                || (comboPortion.getSelectedIndex() == 0)) {
            JOptionPane.showMessageDialog(this, "Please Customize your Ingredient!");
            comboName.grabFocus();

        } else {

            Ingredient ingredient = new ConcreteIngredient();

            if (checkExtraCheese.isSelected()) {
                ingredient.Topping("Extra Cheese");
            }
            if (checkExtraLettuce.isSelected()) {
                ingredient.Topping("Extra Lettuce");
            }
            if (checkOnions.isSelected()) {
                ingredient.Topping("Onions");
            }

            ingredient.customize();
            if (!checkExtraCheese.isSelected() && !checkExtraLettuce.isSelected() && !checkOnions.isSelected()) {
                JOptionPane.showMessageDialog(this, "Customized with No Topping");
            } else {
                JOptionPane.showMessageDialog(this, "Customized Successfully!");
            }
        }
    }//GEN-LAST:event_btnCustomizeActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed

        comboName.setSelectedIndex(0);
        comboPortion.setSelectedIndex(0);

        lblName.setText("Name : N/A");
        lblPortion.setText("Portion : N/A");
        lblTopping.setText("Topping : N/A");

        checkExtraCheese.setSelected(false);
        checkExtraLettuce.setSelected(false);
        checkOnions.setSelected(false);

        pnlCheese.setBackground(new Color(102, 102, 102));
        pnlLettuce.setBackground(new Color(102, 102, 102));
        pnlOnions.setBackground(new Color(102, 102, 102));

        JOptionPane.showMessageDialog(this, "All Fields Cleared!");
    }//GEN-LAST:event_btnClearActionPerformed

    private void comboNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboNameKeyPressed
        if (evt.getKeyCode() == 10) {
            comboPortion.grabFocus();
        }
    }//GEN-LAST:event_comboNameKeyPressed

    private void txtInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtInputKeyPressed
        if (evt.getKeyCode() == 10) {
            OrderInterpreter orderInterpreter = new OrderInterpreter();

            Interpret interpret = new Interpret(orderInterpreter);
            try {
                JOptionPane.showMessageDialog(this, "Plate Size : " + interpret.interpret(txtInput.getText()));

                lblOutput.setText(interpret.interpret(txtInput.getText()));
                textAreaOutput.setText(txtInput.getText().trim() + " on a " + (interpret.interpret(txtInput.getText())));
            } catch (Exception ex) {
            }
        }
    }//GEN-LAST:event_txtInputKeyPressed

    private void btnFormatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFormatActionPerformed

        OrderInterpreter orderInterpreter = new OrderInterpreter();

        Interpret interpreter = new Interpret(orderInterpreter);
        try {
            textAreaOutput.setText(txtInput.getText());
            JOptionPane.showMessageDialog(this, "Plate Size : " + interpreter.interpret(txtInput.getText()));

            lblOutput.setText(interpreter.interpret(txtInput.getText()));
            textAreaOutput.setText(txtInput.getText().trim() + " on a " + (interpreter.interpret(txtInput.getText())));
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnFormatActionPerformed

    private void btnClear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClear1ActionPerformed
        txtInput.setText("");
        lblOutput.setText("N/A");
        textAreaOutput.setText("");

        JOptionPane.showMessageDialog(this, "All Fields Cleared!");
    }//GEN-LAST:event_btnClear1ActionPerformed

    private void txtCustomerNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCustomerNameKeyPressed
        if (evt.getKeyCode() == 10) {
            comboMembership.setPopupVisible(true);
            comboMembership.grabFocus();
        }
    }//GEN-LAST:event_txtCustomerNameKeyPressed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed

        if (txtCustomerName.getText().isEmpty()
                || txtPhone.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Please Fill All the Fields!");

        } else {
            txtDisplayCustomerName.setText(txtCustomerName.getText());
            lblPhone.setText(txtPhone.getText());
            InsertDataToCustomerTable();
            JOptionPane.showMessageDialog(null, "Registration Successful!");
            pnlCardRegister.setVisible(false);
            pnlCardCustomerData.setVisible(false);
            pnlCardOrderInfo.setVisible(true);
        }
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnClearRegVehicleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearRegVehicleActionPerformed
        txtCustomerName.setText("");
        comboMembership.setSelectedIndex(0);
        txtPhone.setText("");

        JOptionPane.showMessageDialog(this, "All Fields Cleared!");
    }//GEN-LAST:event_btnClearRegVehicleActionPerformed

    private void comboMembershipKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboMembershipKeyPressed
        if (evt.getKeyCode() == 10) {
            txtPhone.grabFocus();
        }
    }//GEN-LAST:event_comboMembershipKeyPressed

    private void btnFormat2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFormat2ActionPerformed
        pnlCardRegister.setVisible(false);
        pnlCardCustomerData.setVisible(true);
        pnlCardOrderInfo.setVisible(false);
    }//GEN-LAST:event_btnFormat2ActionPerformed

    private void txtPhoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneKeyPressed
        if (evt.getKeyCode() == 10) {
            if (txtCustomerName.getText().isEmpty()
                    || txtPhone.getText().isEmpty()) {

                JOptionPane.showMessageDialog(null, "Please Fill All the Fields!");

            } else {
                txtDisplayCustomerName.setText(txtCustomerName.getText());
                lblPhone.setText(txtPhone.getText());
                InsertDataToCustomerTable();
                JOptionPane.showMessageDialog(null, "Registration Successful!");
                pnlCardRegister.setVisible(false);
                pnlCardCustomerData.setVisible(false);
                pnlCardOrderInfo.setVisible(true);
            }
        }
    }//GEN-LAST:event_txtPhoneKeyPressed

    private void btnFormat4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFormat4ActionPerformed
        pnlCardRegister.setVisible(true);
        pnlCardCustomerData.setVisible(false);
        pnlCardOrderInfo.setVisible(false);
    }//GEN-LAST:event_btnFormat4ActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        comboLanes.setSelectedIndex(0);
        DefaultTableModel dtm2 = (DefaultTableModel) jTable3.getModel();
        dtm2.setNumRows(0);
    }//GEN-LAST:event_btnResetActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        String newline = System.getProperty("line.separator");

        String f1 = ((String) jTable3.getValueAt(jTable3.getSelectedRow(), 0));
        String f2 = ((String) jTable3.getValueAt(jTable3.getSelectedRow(), 1));
        String f3 = ((String.valueOf(jTable3.getValueAt(jTable3.getSelectedRow(), 2))));

        String row = "Order No: " + f1 + newline
                + "Availability: " + f2 + newline
                + "Order Detail: " + f3;

        JOptionPane.showMessageDialog(this, row);
    }//GEN-LAST:event_jTable3MouseClicked

    private void btnRequestInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestInfoActionPerformed
        InsertDataToOrderTable();
    }//GEN-LAST:event_btnRequestInfoActionPerformed

    private void btnClear2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClear2ActionPerformed
        pnlCardRegister.setVisible(true);
        pnlCardOrderInfo.setVisible(false);
    }//GEN-LAST:event_btnClear2ActionPerformed

    private void btnClear3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClear3ActionPerformed
        if (!(txtDisplayCustomerName.getText().equals(""))) {
            pnlCardRegister.setVisible(false);
            pnlCardCustomerData.setVisible(false);
            pnlCardOrderInfo.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Register First!");
            txtCustomerName.setText("");
            comboMembership.setSelectedIndex(0);
            txtPhone.setText("");

            pnlCardRegister.setVisible(true);
            pnlCardCustomerData.setVisible(false);
            pnlCardOrderInfo.setVisible(false);
        }
    }//GEN-LAST:event_btnClear3ActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        if (comboAcceptingStep.getSelectedIndex() == 1) {
            JOptionPane.showMessageDialog(this, "Order Declined!");

        } else {
            pnlAccepting.setVisible(false);
            pnlCooking.setVisible(true);
            pnlPacking.setVisible(false);
            pnlHandover.setVisible(false);

            String acceptingStatus = comboAcceptingStep.getSelectedItem().toString();

            chain.acceptingStep(new AcceptingStepValidation(acceptingStatus));
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void comboAcceptingStepKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboAcceptingStepKeyPressed
        if (evt.getKeyCode() == 10) {

            String acceptingStatus = comboAcceptingStep.getSelectedItem().toString();

            chain.acceptingStep(new AcceptingStepValidation(acceptingStatus));
        }
    }//GEN-LAST:event_comboAcceptingStepKeyPressed

    private void btnCurBalanceNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCurBalanceNextActionPerformed
        if (comboCookingStep.getSelectedIndex() == 1) {
            JOptionPane.showMessageDialog(this, "Order Uncooked!");

        } else {
            pnlAccepting.setVisible(false);
            pnlCooking.setVisible(false);
            pnlPacking.setVisible(true);
            pnlHandover.setVisible(false);
        }
    }//GEN-LAST:event_btnCurBalanceNextActionPerformed

    private void btnCurBalancePrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCurBalancePrevActionPerformed
        pnlAccepting.setVisible(true);
        pnlCooking.setVisible(false);
        pnlPacking.setVisible(false);
        pnlHandover.setVisible(false);
    }//GEN-LAST:event_btnCurBalancePrevActionPerformed

    private void btnOptionsNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOptionsNextActionPerformed
        if (comboPackingStep.getSelectedIndex() == 1) {
            JOptionPane.showMessageDialog(this, "Order Unpacked!");

        } else {
            pnlAccepting.setVisible(false);
            pnlCooking.setVisible(false);
            pnlPacking.setVisible(false);
            pnlHandover.setVisible(true);

        }
    }//GEN-LAST:event_btnOptionsNextActionPerformed

    private void btnOptionsPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOptionsPrevActionPerformed
        pnlAccepting.setVisible(false);
        pnlCooking.setVisible(true);
        pnlPacking.setVisible(false);
        pnlHandover.setVisible(false);
    }//GEN-LAST:event_btnOptionsPrevActionPerformed

    private void btnViewReceiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewReceiptActionPerformed
        if (!(txtPaidAmount.getText().equals("0.00"))) {
            JOptionPane.showMessageDialog(this,
                    "Paid amount : " + txtPaidAmount.getText() + " LKR"
                    + newline + "Total Balance : " + txtBalance.getText() + " LKR");
        }
    }//GEN-LAST:event_btnViewReceiptActionPerformed

    private void btnNewOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewOrderActionPerformed
        int choose = JOptionPane.showConfirmDialog(null,
                "Confirm New Order ?",
                "Confirmation", JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE);
        if (choose == JOptionPane.YES_OPTION) {

            txtBalance.setText("0.00");
            txtPaidAmount.setText("0.00");
            txtDuePayAmount.setText("0.00");
            lblTotalBalance.setText("Total Balance: 0.00 LKR");

            comboAcceptingStep.setSelectedIndex(0);

            pnlHandover.setVisible(false);
            pnlAccepting.setVisible(true);
        }

    }//GEN-LAST:event_btnNewOrderActionPerformed

    private void txtPaidAmountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPaidAmountMouseClicked
        txtPaidAmount.setText("");
    }//GEN-LAST:event_txtPaidAmountMouseClicked

    private void txtPaidAmountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaidAmountKeyTyped
        if (evt.getKeyCode() == 10) {
            double balance = Double.parseDouble(txtPaidAmount.getText())
                    - Double.parseDouble(txtDuePayAmount.getText());
            txtBalance.setText(Double.toString(balance));
            lblTotalBalance.setText("Total Balance: " + balance + " LKR");
            chain.process(new Balance(balance));
        }

        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            if (c != '.') {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtPaidAmountKeyTyped

    private void btnDepositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepositActionPerformed
        double balance = Double.parseDouble(txtPaidAmount.getText())
                - Double.parseDouble(txtDuePayAmount.getText());
        txtBalance.setText(Double.toString(balance));
        lblTotalBalance.setText("Total Balance: " + balance + " LKR");
        chain.process(new Balance(balance));
    }//GEN-LAST:event_btnDepositActionPerformed

    private void comboMealPackingKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboMealPackingKeyPressed
        if (evt.getKeyCode() == 10) {

            PrepareMeal();
            InsertDataToTable();

            switch (comboMealName.getSelectedItem().toString()) {
                case "Veg Burger":
                    txtMealPrice.setText("25.0");
                    break;
                case "Chicken Burger":
                    txtMealPrice.setText("50.5");
                    break;
                case "Coke":
                    txtMealPrice.setText("30.0");
                    break;
                case "Pepsi":
                    txtMealPrice.setText("35.0");
                    break;
                default:
                    txtMealPrice.setText("0.0");
                    break;
            }
        }
    }//GEN-LAST:event_comboMealPackingKeyPressed

    private void txtMealPriceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMealPriceKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMealPriceKeyPressed

    private void comboMealTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMealTypeActionPerformed

        switch (comboMealType.getSelectedIndex()) {
            case 1:
                comboMealName.removeAllItems();
                comboMealName.addItem("Select");
                comboMealName.addItem("Veg Burger");
                comboMealName.addItem("Coke");
                comboMealName.addItem("Pepsi");

                break;
            case 2:
                comboMealName.removeAllItems();
                comboMealName.addItem("Select");
                comboMealName.addItem("Chicken Burger");
                comboMealName.addItem("Coke");
                comboMealName.addItem("Pepsi");
                break;
            default:
                comboMealName.removeAllItems();
                comboMealName.addItem("Select");
                break;
        }
    }//GEN-LAST:event_comboMealTypeActionPerformed

    private void comboMealNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMealNameActionPerformed
        switch (comboMealName.getSelectedIndex()) {
            case 1:
                comboMealPacking.removeAllItems();
                comboMealPacking.addItem("Select");
                comboMealPacking.addItem("Wrap");
                break;
            case 2:

                comboMealPacking.removeAllItems();
                comboMealPacking.addItem("Select");
                comboMealPacking.addItem("Bottle");
                break;
            case 3:
                comboMealPacking.removeAllItems();
                comboMealPacking.addItem("Select");
                comboMealPacking.addItem("Bottle");
                break;
            default:
                comboMealPacking.removeAllItems();
                comboMealPacking.addItem("Select");
                break;
        }
    }//GEN-LAST:event_comboMealNameActionPerformed

    private void comboMealPackingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMealPackingActionPerformed
        try {
            switch (comboMealName.getSelectedItem().toString()) {
                case "Veg Burger":
                    txtMealPrice.setText("25.0");
                    break;
                case "Chicken Burger":
                    txtMealPrice.setText("50.5");
                    break;
                case "Coke":
                    txtMealPrice.setText("30.0");
                    break;
                case "Pepsi":
                    txtMealPrice.setText("35.0");
                    break;
                default:
                    txtMealPrice.setText("0.0");
                    break;
            }
        } catch (NullPointerException e) {
        }
    }//GEN-LAST:event_comboMealPackingActionPerformed

    private void comboPortionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboPortionKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboPortionKeyPressed

    private void comboCookingStepKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboCookingStepKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboCookingStepKeyPressed

    private void comboPackingStepKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboPackingStepKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboPackingStepKeyPressed

    private void txtDuePayAmountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDuePayAmountMouseClicked
        txtDuePayAmount.setText("");
    }//GEN-LAST:event_txtDuePayAmountMouseClicked

    private void txtDuePayAmountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDuePayAmountKeyTyped
        if (evt.getKeyCode() == 10) {
            txtPaidAmount.grabFocus();
            txtPaidAmount.setText("");
        }
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            if (c != '.') {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtDuePayAmountKeyTyped

    private void btnDuePayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDuePayActionPerformed
        if ((txtDuePayAmount.getText().isEmpty())) {

            JOptionPane.showMessageDialog(this, "Input Due Pay Amount!");
        } else {
            txtPaidAmount.grabFocus();
            txtPaidAmount.setText("");
        }

    }//GEN-LAST:event_btnDuePayActionPerformed

    private void txtBalanceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBalanceMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBalanceMouseClicked

    private void txtBalanceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBalanceKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBalanceKeyTyped

    private void PrepareMeal() {

        if (comboMealType.getSelectedItem() == "Veg Meal") {
            Type = "Veg Meal";
        } else if ((comboMealType.getSelectedItem() == "Non-Veg Meal")) {
            Type = "Non-Veg Meal";
        }

        if ((comboMealName.getSelectedItem() == "Veg Burger")) {
            Name = "Veg Burger";
        } else if ((comboMealName.getSelectedItem() == "Chicken Burger")) {
            Name = "Chicken Burger";
        } else if ((comboMealName.getSelectedItem() == "Coke")) {
            Name = "Coke";
        } else if ((comboMealName.getSelectedItem() == "Pepsi")) {
            Name = "Pepsi";
        } else {
            Name = "N/A";
        }

        if (comboMealPacking.getSelectedItem() == "Wrap") {
            Packing = "Wrap";
        } else if ((comboMealPacking.getSelectedItem() == "Bottle")) {
            Packing = "Bottle";
        } else {
            Packing = "N/A";
        }

        if ("".equals(txtMealPrice.getText())) {
            Price = 0.0;
        } else {
            Price = Double.parseDouble(txtMealPrice.getText());
        }

        FoodCorner meal = new Item()
                .setType(Type)
                .setName(Name)
                .setPacking(Packing)
                .setPrice(Price)
                .getItem();
        JOptionPane.showMessageDialog(this, meal.toString());
    }

    private void InsertDataToTable() {

        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.addRow(new Object[]{Type, Name, Packing, Price});
        JOptionPane.showMessageDialog(null, "New Row Added!");

        if (lblItem.getText().equals("N/A")) {
            lblItem.setText(Name.toString());
        } else {
            String currentText = lblItem.getText().replace(" + ", "");
            lblItem.setText(currentText + " + " + Name.toString());
        }

        if (lblPacking.getText().equals("N/A")) {
            lblPacking.setText(Packing.toString());
        } else {
            String currentText = lblPacking.getText().replace(" + ", "");
            lblPacking.setText(currentText + " + " + Packing.toString());
        }

        try {
            if (lblPrice.getText().equals("0.0")) {
                lblPrice.setText(Double.toString(Price));
            } else {
                String currentText = Double.toString(Double.parseDouble(lblPrice.getText()) + Price);
                lblPrice.setText(currentText);
            }
        } catch (NumberFormatException e) {
        }

        comboMealType.grabFocus();

        comboMealType.setSelectedIndex(0);
        comboMealName.setSelectedIndex(0);
        comboMealPacking.setSelectedIndex(0);
        txtMealPrice.setText("0.0");
    }

    class Item {

        private String type;
        private String name;
        private String packing;
        private double price;

        public Item setType(String type) {
            this.type = type;
            return this;
        }

        public Item setName(String name) {
            this.name = name;
            return this;
        }

        public Item setPacking(String packing) {
            this.packing = packing;
            return this;
        }

        public Item setPrice(double price) {
            this.price = price;
            return this;
        }

        public FoodCorner getItem() {
            return new FoodCorner(type, name, packing, price);
        }
    }

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
            java.util.logging.Logger.getLogger(FoodCorner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FoodCorner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FoodCorner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FoodCorner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FoodCorner().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClear1;
    private javax.swing.JButton btnClear2;
    private javax.swing.JButton btnClear3;
    private javax.swing.JButton btnClearRegVehicle;
    private javax.swing.JButton btnCurBalanceNext;
    private javax.swing.JButton btnCurBalancePrev;
    private javax.swing.JButton btnCustomize;
    private javax.swing.JButton btnDeposit;
    private javax.swing.JButton btnDuePay;
    private javax.swing.JButton btnFormat;
    private javax.swing.JButton btnFormat2;
    private javax.swing.JButton btnFormat4;
    private javax.swing.JButton btnNewOrder;
    private javax.swing.JButton btnOptionsNext;
    private javax.swing.JButton btnOptionsPrev;
    private javax.swing.JButton btnPrepare;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnRequestInfo;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnViewReceipt;
    private javax.swing.JPanel cardMain;
    public static javax.swing.JCheckBox checkExtraCheese;
    public static javax.swing.JCheckBox checkExtraLettuce;
    public static javax.swing.JCheckBox checkOnions;
    private javax.swing.JComboBox<String> comboAcceptingStep;
    private javax.swing.JComboBox<String> comboCookingStep;
    private javax.swing.JComboBox<String> comboLanes;
    private javax.swing.JComboBox<String> comboMealName;
    private javax.swing.JComboBox<String> comboMealPacking;
    private javax.swing.JComboBox<String> comboMealType;
    private javax.swing.JComboBox<String> comboMembership;
    public static javax.swing.JComboBox<String> comboName;
    private javax.swing.JComboBox<String> comboPackingStep;
    public static javax.swing.JComboBox<String> comboPortion;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    public static javax.swing.JLabel lblItem;
    public static javax.swing.JLabel lblItem1;
    public static javax.swing.JLabel lblName;
    private javax.swing.JLabel lblOutput;
    public static javax.swing.JLabel lblPacking;
    public static javax.swing.JLabel lblPacking1;
    private javax.swing.JLabel lblPhone;
    public static javax.swing.JLabel lblPortion;
    public static javax.swing.JLabel lblPrice;
    public static javax.swing.JLabel lblPrice1;
    public static javax.swing.JLabel lblTopping;
    private javax.swing.JLabel lblTotalBalance;
    private javax.swing.JPanel pnlAccepting;
    private javax.swing.JPanel pnlCardCustomerData;
    private javax.swing.JPanel pnlCardOrderInfo;
    private javax.swing.JPanel pnlCardRegister;
    private javax.swing.JPanel pnlCheese;
    private javax.swing.JPanel pnlCooking;
    private javax.swing.JPanel pnlDuePayAmount;
    private javax.swing.JPanel pnlHandover;
    private javax.swing.JPanel pnlLettuce;
    private javax.swing.JPanel pnlOnions;
    private javax.swing.JPanel pnlPacking;
    private javax.swing.JPanel pnlPaidAmount;
    private javax.swing.JTextArea textAreaOutput;
    private javax.swing.JTextField txtBalance;
    private javax.swing.JLabel txtCombinations1;
    private javax.swing.JLabel txtCombinations10;
    private javax.swing.JLabel txtCombinations11;
    private javax.swing.JLabel txtCombinations2;
    private javax.swing.JLabel txtCombinations4;
    private javax.swing.JLabel txtCombinations5;
    private javax.swing.JLabel txtCombinations6;
    private javax.swing.JLabel txtCombinations8;
    private javax.swing.JLabel txtCombinations9;
    private javax.swing.JTextField txtCustomerName;
    private javax.swing.JTextField txtDisplayCustomerName;
    private javax.swing.JTextField txtDuePayAmount;
    private javax.swing.JTextField txtInput;
    public static javax.swing.JTextField txtMealPrice;
    private javax.swing.JTextField txtPaidAmount;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
