package ChainOfResponsibilityPattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class ChainOfResponsibilityATM extends javax.swing.JFrame {

    DecimalFormat df = new DecimalFormat("###,###,###,###,###.00");
    String newline = System.getProperty("line.separator");

    ATM chain;

    public ChainOfResponsibilityATM() {
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

    private void buildChain() {
        chain = new CardType(
                new ExpDate(
                        new DepositBalance(
                                new WithdrawBalance(
                                        new CheckBalance(null)))));
    }

    public void cardTypeValidation(CardTypeValidation request) {
        chain.cardTypeValidation(request);
    }

    public void cardExpDateValidation(CardExpDateValidation request) {
        chain.cardExpDateValidation(request);
    }

    public void cardPinNoValidation(CardPinNoValidation request) {
        chain.cardPinNoValidation(request);
    }

    public void process(Balance request) {
        chain.process(request);
    }

    //handler
    abstract class ATM {

        private ATM nextValidation;
        private ATM nextProcess;

        public ATM(ATM nextProcess) {
            this.nextProcess = nextProcess;
        }

        public void process(Balance request) {
            if (nextProcess != null) {
                nextProcess.process(request);
            }
        }

        public void cardTypeValidation(CardTypeValidation validate) {
            if (nextValidation != null) {
                nextValidation.cardTypeValidation(validate);
            }
        }

        public void cardExpDateValidation(CardExpDateValidation validate) {
            if (nextValidation != null) {
                nextValidation.cardExpDateValidation(validate);
            }
        }

        public void cardPinNoValidation(CardPinNoValidation validate) {
            if (nextValidation != null) {
                nextValidation.cardPinNoValidation(validate);
            }
        }

    }

    class CardTypeValidation {

        private final String cardType;

        public CardTypeValidation(String cardType) {
            this.cardType = cardType;
        }

        public String getCardType() {
            return cardType;
        }

    }

    class CardExpDateValidation {

        private final String expDate;

        public CardExpDateValidation(String expDate) {
            this.expDate = expDate;
        }

        public String getExpDate() {
            return expDate;
        }

    }

    class CardPinNoValidation {

        private final int pinNo;

        public CardPinNoValidation(int pinNo) {
            this.pinNo = pinNo;
        }

        public int getPinNo() {
            return pinNo;
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

    class CardType extends ATM {

        public CardType(ATM nextProcess) {
            super(nextProcess);
        }

        @Override
        public void cardTypeValidation(CardTypeValidation request) {
            if (null == request.getCardType()) {
                super.cardTypeValidation(request);
            } else switch (request.getCardType()) {
                case "Visa":
                    JOptionPane.showMessageDialog(getParent(), "Card Type : Visa Accepted!");
                    break;
                case "Mastercard":
                    JOptionPane.showMessageDialog(getParent(), "Card Type : Mastercard Accepted!");
                    break;
                default:
                    super.cardTypeValidation(request);
                    break;
            }
        }
    }

    class ExpDate extends ATM {

        public ExpDate(ATM nextProcess) {
            super(nextProcess);
        }

        @Override
        public void cardExpDateValidation(CardExpDateValidation request) {
            if (("".equals(request.getExpDate()))) {
                JOptionPane.showMessageDialog(getParent(), "Invalid Exp. Date!");
            } else {
                super.cardExpDateValidation(request);
            }
        }
    }

    class PinNo extends ATM {

        public PinNo(ATM nextProcess) {
            super(nextProcess);
        }

        @Override
        public void cardPinNoValidation(CardPinNoValidation request) {
            if (("".equals(request.getPinNo()))) {
                JOptionPane.showMessageDialog(getParent(), "Invalid Pin Number!");
            } else {
                super.cardPinNoValidation(request);
            }
        }
    }

    class currentBalance extends ATM {

        public currentBalance(ATM nextProcessor) {
            super(nextProcessor);

        }

        @Override
        public void process(Balance request) {
            if (!(request.getBalance() == 0.00)) {
                double total = Double.parseDouble(txtCurrentBalance.getText());
                JOptionPane.showMessageDialog(getParent(), "Total Balance : " + df.format(total) + " LKR");
                txtTotal.setText("Total Balance: " + df.format(total) + " LKR");
                txtCurrentBalance.setText(df.format(total));
            } else {
                super.process(request);
            }
        }
    }

    class DepositBalance extends ATM {

        public DepositBalance(ATM nextProcessor) {
            super(nextProcessor);

        }

        @Override
        public void process(Balance request) {
            if (!(request.getBalance() == 0 || "0.00".equals(txtDepositMoney.getText()))) {
                double total = Double.parseDouble(txtCurrentBalance.getText()) + request.getBalance();
                JOptionPane.showMessageDialog(getParent(), "Total Balance : " + df.format(total) + " LKR");
                txtTotal.setText("Total Balance: " + df.format(total) + " LKR");
                txtCurrentBalance.setText(df.format(total));
            } else {
                super.process(request);
            }
        }
    }

    class WithdrawBalance extends ATM {

        public WithdrawBalance(ATM nextProcessor) {
            super(nextProcessor);
        }

        @Override
        public void process(Balance request) {
            if (!(request.getBalance() == 0) || "0.00".equals(txtDepositMoney.getText())) {
                double total = Double.parseDouble(txtCurrentBalance.getText()) - request.getBalance();
                JOptionPane.showMessageDialog(getParent(), "Total Balance : " + df.format(total) + " LKR");
                txtTotal.setText("Total Balance: " + df.format(total) + " LKR");
                txtCurrentBalance.setText(df.format(total));
            } else {
                super.process(request);
            }
        }
    }

    class CheckBalance extends ATM {

        public CheckBalance(ATM nextProcessor) {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        pnlCardInputs = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtExpDate = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        comboCardType = new javax.swing.JComboBox<>();
        pwdPin = new javax.swing.JPasswordField();
        pnlCurrentBalance = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtCurrentBalance = new javax.swing.JTextField();
        btnCurBalanceNext = new javax.swing.JButton();
        btnCurBalancePrev = new javax.swing.JButton();
        pnlOptions = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        btnOptionsNext = new javax.swing.JButton();
        radioDeposit = new javax.swing.JRadioButton();
        radioWithdraw = new javax.swing.JRadioButton();
        btnOptionsPrev = new javax.swing.JButton();
        pnlDashboard = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        txtTotal = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnViewReceipt = new javax.swing.JButton();
        btnEjectCard = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        pnlDepositMoney = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtDepositMoney = new javax.swing.JTextField();
        btnDeposit = new javax.swing.JButton();
        pnlWithdrawMoney = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtWithdrawMoney = new javax.swing.JTextField();
        btnWithdraw = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Chain of Responsibility ATM (Chain of Responsibility Pattern)");
        setLocation(new java.awt.Point(0, 0));
        setSize(new java.awt.Dimension(0, 0));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Chain of Responsibility ATM");

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

        jPanel8.setLayout(new java.awt.CardLayout());

        pnlCardInputs.setBackground(new java.awt.Color(80, 80, 80));

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Card Validation");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Card Type");

        btnSubmit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Exp. Date");

        txtExpDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtExpDate.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtExpDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtExpDateKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtExpDateKeyTyped(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Pin No.");

        comboCardType.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboCardType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Visa", "Mastercard" }));
        comboCardType.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                comboCardTypeKeyPressed(evt);
            }
        });

        pwdPin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pwdPin.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        pwdPin.setMinimumSize(new java.awt.Dimension(14, 28));
        pwdPin.setPreferredSize(new java.awt.Dimension(14, 28));
        pwdPin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pwdPinKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pwdPinKeyTyped(evt);
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
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSubmit)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtExpDate)
                                    .addComponent(comboCardType, 0, 192, Short.MAX_VALUE)
                                    .addComponent(pwdPin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(comboCardType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(txtExpDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pwdPin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addComponent(btnSubmit)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlCardInputsLayout = new javax.swing.GroupLayout(pnlCardInputs);
        pnlCardInputs.setLayout(pnlCardInputsLayout);
        pnlCardInputsLayout.setHorizontalGroup(
            pnlCardInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCardInputsLayout.createSequentialGroup()
                .addContainerGap(167, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(167, Short.MAX_VALUE))
        );
        pnlCardInputsLayout.setVerticalGroup(
            pnlCardInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCardInputsLayout.createSequentialGroup()
                .addContainerGap(87, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        jPanel8.add(pnlCardInputs, "card2");

        pnlCurrentBalance.setBackground(new java.awt.Color(80, 80, 80));

        jPanel14.setBackground(new java.awt.Color(51, 51, 51));
        jPanel14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Current Balance");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("LKR");

        txtCurrentBalance.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCurrentBalance.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtCurrentBalance.setText("0.00");
        txtCurrentBalance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCurrentBalanceMouseClicked(evt);
            }
        });
        txtCurrentBalance.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCurrentBalanceKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCurrentBalanceKeyTyped(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(txtCurrentBalance))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGap(0, 90, Short.MAX_VALUE)
                                .addComponent(btnCurBalancePrev, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCurBalanceNext, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel28)
                        .addGap(41, 41, 41))))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel27)
                .addGap(57, 57, 57)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(txtCurrentBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCurBalanceNext)
                    .addComponent(btnCurBalancePrev))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlCurrentBalanceLayout = new javax.swing.GroupLayout(pnlCurrentBalance);
        pnlCurrentBalance.setLayout(pnlCurrentBalanceLayout);
        pnlCurrentBalanceLayout.setHorizontalGroup(
            pnlCurrentBalanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCurrentBalanceLayout.createSequentialGroup()
                .addContainerGap(178, Short.MAX_VALUE)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(178, Short.MAX_VALUE))
        );
        pnlCurrentBalanceLayout.setVerticalGroup(
            pnlCurrentBalanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCurrentBalanceLayout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        jPanel8.add(pnlCurrentBalance, "card2");

        pnlOptions.setBackground(new java.awt.Color(80, 80, 80));

        jPanel15.setBackground(new java.awt.Color(51, 51, 51));
        jPanel15.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Choose an option");

        btnOptionsNext.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnOptionsNext.setText("Next");
        btnOptionsNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOptionsNextActionPerformed(evt);
            }
        });

        radioDeposit.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup1.add(radioDeposit);
        radioDeposit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radioDeposit.setForeground(new java.awt.Color(255, 255, 255));
        radioDeposit.setText("Deposit Money");

        radioWithdraw.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup1.add(radioWithdraw);
        radioWithdraw.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radioWithdraw.setForeground(new java.awt.Color(255, 255, 255));
        radioWithdraw.setText("Withdraw Money");

        btnOptionsPrev.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnOptionsPrev.setText("Previous");
        btnOptionsPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOptionsPrevActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(203, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(radioDeposit)
                        .addGroup(jPanel15Layout.createSequentialGroup()
                            .addComponent(radioWithdraw)
                            .addGap(126, 126, 126)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addComponent(btnOptionsPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOptionsNext, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59))))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel29)
                .addGap(40, 40, 40)
                .addComponent(radioDeposit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radioWithdraw)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOptionsNext)
                    .addComponent(btnOptionsPrev))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout pnlOptionsLayout = new javax.swing.GroupLayout(pnlOptions);
        pnlOptions.setLayout(pnlOptionsLayout);
        pnlOptionsLayout.setHorizontalGroup(
            pnlOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlOptionsLayout.createSequentialGroup()
                .addContainerGap(178, Short.MAX_VALUE)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(178, Short.MAX_VALUE))
        );
        pnlOptionsLayout.setVerticalGroup(
            pnlOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOptionsLayout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        jPanel8.add(pnlOptions, "card2");

        pnlDashboard.setBackground(new java.awt.Color(80, 80, 80));

        jPanel11.setBackground(new java.awt.Color(51, 51, 51));
        jPanel11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        txtTotal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(255, 255, 255));
        txtTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTotal.setText("Total Balance: 0.00 LKR");
        txtTotal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Transaction Status");

        btnViewReceipt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnViewReceipt.setText("View Receipt");
        btnViewReceipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewReceiptActionPerformed(evt);
            }
        });

        btnEjectCard.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEjectCard.setText("Eject Card");
        btnEjectCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjectCardActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                            .addComponent(btnViewReceipt, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnEjectCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnViewReceipt)
                    .addComponent(btnEjectCard))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setLayout(new java.awt.CardLayout());

        pnlDepositMoney.setBackground(new java.awt.Color(51, 51, 51));
        pnlDepositMoney.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Deposit Money");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("LKR");

        txtDepositMoney.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDepositMoney.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtDepositMoney.setText("0.00");
        txtDepositMoney.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDepositMoneyMouseClicked(evt);
            }
        });
        txtDepositMoney.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDepositMoneyKeyTyped(evt);
            }
        });

        btnDeposit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDeposit.setText("Deposit");
        btnDeposit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepositActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDepositMoneyLayout = new javax.swing.GroupLayout(pnlDepositMoney);
        pnlDepositMoney.setLayout(pnlDepositMoneyLayout);
        pnlDepositMoneyLayout.setHorizontalGroup(
            pnlDepositMoneyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDepositMoneyLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnDeposit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
            .addGroup(pnlDepositMoneyLayout.createSequentialGroup()
                .addGroup(pnlDepositMoneyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDepositMoneyLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(txtDepositMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12))
                    .addGroup(pnlDepositMoneyLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45))
        );
        pnlDepositMoneyLayout.setVerticalGroup(
            pnlDepositMoneyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDepositMoneyLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(pnlDepositMoneyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtDepositMoney, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(btnDeposit)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jPanel3.add(pnlDepositMoney, "card2");

        pnlWithdrawMoney.setBackground(new java.awt.Color(51, 51, 51));
        pnlWithdrawMoney.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Withdraw Money");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("LKR");

        txtWithdrawMoney.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtWithdrawMoney.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtWithdrawMoney.setText("0.00");
        txtWithdrawMoney.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtWithdrawMoneyMouseClicked(evt);
            }
        });
        txtWithdrawMoney.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtWithdrawMoneyKeyTyped(evt);
            }
        });

        btnWithdraw.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnWithdraw.setText("Withdraw");
        btnWithdraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWithdrawActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlWithdrawMoneyLayout = new javax.swing.GroupLayout(pnlWithdrawMoney);
        pnlWithdrawMoney.setLayout(pnlWithdrawMoneyLayout);
        pnlWithdrawMoneyLayout.setHorizontalGroup(
            pnlWithdrawMoneyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlWithdrawMoneyLayout.createSequentialGroup()
                .addGroup(pnlWithdrawMoneyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlWithdrawMoneyLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlWithdrawMoneyLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(pnlWithdrawMoneyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlWithdrawMoneyLayout.createSequentialGroup()
                                .addComponent(txtWithdrawMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel13)
                                .addGap(17, 17, 17))
                            .addComponent(btnWithdraw, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30))
        );
        pnlWithdrawMoneyLayout.setVerticalGroup(
            pnlWithdrawMoneyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlWithdrawMoneyLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(pnlWithdrawMoneyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtWithdrawMoney, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(btnWithdraw)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jPanel3.add(pnlWithdrawMoney, "card3");

        javax.swing.GroupLayout pnlDashboardLayout = new javax.swing.GroupLayout(pnlDashboard);
        pnlDashboard.setLayout(pnlDashboardLayout);
        pnlDashboardLayout.setHorizontalGroup(
            pnlDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDashboardLayout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        pnlDashboardLayout.setVerticalGroup(
            pnlDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDashboardLayout.createSequentialGroup()
                .addContainerGap(112, Short.MAX_VALUE)
                .addGroup(pnlDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(111, Short.MAX_VALUE))
        );

        jPanel8.add(pnlDashboard, "card2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE))
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

        setSize(new java.awt.Dimension(762, 521));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        if ((txtExpDate.getText().isEmpty() || pwdPin.getText().isEmpty())) {
            JOptionPane.showMessageDialog(this, "Input Card Details!");
        } 
        
        if (pwdPin.getText().length() != 4) {
            JOptionPane.showMessageDialog(this, "Invalid Pin Number!");
            pwdPin.grabFocus();
            pwdPin.setText("");
        }else{
            pnlCardInputs.setVisible(false);
            pnlCurrentBalance.setVisible(true);
            pnlOptions.setVisible(false);
            pnlDashboard.setVisible(false);
            pnlDepositMoney.setVisible(false);
            pnlWithdrawMoney.setVisible(false);

            String cardTypeString = comboCardType.getSelectedItem().toString();
            String expDateString = txtExpDate.getText();
            int pinNoString = Integer.parseInt(pwdPin.getText());

            chain.cardTypeValidation(new CardTypeValidation(cardTypeString));
            chain.cardExpDateValidation(new CardExpDateValidation(expDateString));
            chain.cardPinNoValidation(new CardPinNoValidation(pinNoString));
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void txtDepositMoneyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDepositMoneyKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            if (c != '.') {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtDepositMoneyKeyTyped

    private void btnDepositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepositActionPerformed
        chain.process(new Balance(Double.parseDouble(txtDepositMoney.getText())));
    }//GEN-LAST:event_btnDepositActionPerformed

    private void txtWithdrawMoneyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtWithdrawMoneyKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            if (c != '.') {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtWithdrawMoneyKeyTyped

    private void btnWithdrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWithdrawActionPerformed
        chain.process(new Balance(Double.parseDouble(txtWithdrawMoney.getText())));
    }//GEN-LAST:event_btnWithdrawActionPerformed

    private void txtExpDateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtExpDateKeyPressed
        if (evt.getKeyCode() == 10) {
            pwdPin.grabFocus();
        }
    }//GEN-LAST:event_txtExpDateKeyPressed

    private void pwdPinKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pwdPinKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || pwdPin.getText().length() == 4) {
            evt.consume();
        }
    }//GEN-LAST:event_pwdPinKeyTyped

    private void comboCardTypeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboCardTypeKeyPressed
        if (evt.getKeyCode() == 10) {
            txtExpDate.grabFocus();
        }
    }//GEN-LAST:event_comboCardTypeKeyPressed

    private void pwdPinKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pwdPinKeyPressed
        if (evt.getKeyCode() == 10) {
            if (!(txtExpDate.getText().isEmpty() || pwdPin.getText().isEmpty())) {
                pnlCardInputs.setVisible(false);
                pnlDashboard.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Input Card Details!");

            }
        }
    }//GEN-LAST:event_pwdPinKeyPressed

    private void txtExpDateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtExpDateKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            if ((c != '/') && (c != '-') && (c != '.')) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtExpDateKeyTyped

    private void txtDepositMoneyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDepositMoneyMouseClicked
        txtDepositMoney.setText("");
    }//GEN-LAST:event_txtDepositMoneyMouseClicked

    private void txtWithdrawMoneyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtWithdrawMoneyMouseClicked
        txtWithdrawMoney.setText("");
    }//GEN-LAST:event_txtWithdrawMoneyMouseClicked

    private void btnViewReceiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewReceiptActionPerformed
        if (!(txtDepositMoney.getText().equals("0.00"))) {
            JOptionPane.showMessageDialog(this,
                    "Deposit amount : " + txtDepositMoney.getText() + " LKR"
                    + newline + "Total Balance : " + txtCurrentBalance.getText() + " LKR");
        }

        if (!(txtWithdrawMoney.getText().equals("0.00"))) {
            JOptionPane.showMessageDialog(this,
                    "Withdraw amount : " + txtWithdrawMoney.getText() + " LKR"
                    + newline + "Total Balance : " + txtCurrentBalance.getText() + " LKR");
        }
    }//GEN-LAST:event_btnViewReceiptActionPerformed

    private void btnEjectCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjectCardActionPerformed
        int choose = JOptionPane.showConfirmDialog(null,
                "Confirm Eject Card ?",
                "Confirmation", JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE);
        if (choose == JOptionPane.YES_OPTION) {

            txtCurrentBalance.setText("0.00");
            txtDepositMoney.setText("0.00");
            txtWithdrawMoney.setText("0.00");
            txtTotal.setText("Total Balance: 0.00 LKR");
            
            comboCardType.setSelectedIndex(0);
            txtExpDate.setText("");
            pwdPin.setText("");

            pnlDashboard.setVisible(false);
            pnlCardInputs.setVisible(true);
        }


    }//GEN-LAST:event_btnEjectCardActionPerformed

    private void txtCurrentBalanceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCurrentBalanceMouseClicked
        txtCurrentBalance.setText("");
    }//GEN-LAST:event_txtCurrentBalanceMouseClicked

    private void txtCurrentBalanceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCurrentBalanceKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCurrentBalanceKeyPressed

    private void txtCurrentBalanceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCurrentBalanceKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCurrentBalanceKeyTyped

    private void btnCurBalanceNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCurBalanceNextActionPerformed
        if (!(txtCurrentBalance.getText().isEmpty())) {
            pnlCardInputs.setVisible(false);
            pnlCurrentBalance.setVisible(false);
            pnlOptions.setVisible(true);
            pnlDashboard.setVisible(false);
            pnlDepositMoney.setVisible(false);
            pnlWithdrawMoney.setVisible(false);
            txtTotal.setText("Total Balance : " + txtCurrentBalance.getText() + " LKR");
        } else {
            JOptionPane.showMessageDialog(this, "Input Current Balance!");
            txtCurrentBalance.grabFocus();
        }
    }//GEN-LAST:event_btnCurBalanceNextActionPerformed

    private void btnOptionsNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOptionsNextActionPerformed
        if (radioDeposit.isSelected()) {
            pnlCardInputs.setVisible(false);
            pnlCurrentBalance.setVisible(false);
            pnlOptions.setVisible(false);
            pnlDashboard.setVisible(true);
            pnlDepositMoney.setVisible(true);
            pnlWithdrawMoney.setVisible(false);

        }
        if (radioWithdraw.isSelected()) {
            pnlCardInputs.setVisible(false);
            pnlCurrentBalance.setVisible(false);
            pnlOptions.setVisible(false);
            pnlDashboard.setVisible(true);
            pnlDepositMoney.setVisible(false);
            pnlWithdrawMoney.setVisible(true);
        }
    }//GEN-LAST:event_btnOptionsNextActionPerformed

    private void btnCurBalancePrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCurBalancePrevActionPerformed
        pnlCardInputs.setVisible(true);
        pnlCurrentBalance.setVisible(false);
        pnlOptions.setVisible(false);
        pnlDashboard.setVisible(false);
        pnlDepositMoney.setVisible(false);
        pnlWithdrawMoney.setVisible(false);
    }//GEN-LAST:event_btnCurBalancePrevActionPerformed

    private void btnOptionsPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOptionsPrevActionPerformed
        pnlCardInputs.setVisible(false);
        pnlCurrentBalance.setVisible(true);
        pnlOptions.setVisible(false);
        pnlDashboard.setVisible(false);
        pnlDepositMoney.setVisible(false);
        pnlWithdrawMoney.setVisible(false);
    }//GEN-LAST:event_btnOptionsPrevActionPerformed

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
            java.util.logging.Logger.getLogger(ChainOfResponsibilityATM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChainOfResponsibilityATM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChainOfResponsibilityATM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChainOfResponsibilityATM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChainOfResponsibilityATM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCurBalanceNext;
    private javax.swing.JButton btnCurBalancePrev;
    private javax.swing.JButton btnDeposit;
    private javax.swing.JButton btnEjectCard;
    private javax.swing.JButton btnOptionsNext;
    private javax.swing.JButton btnOptionsPrev;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnViewReceipt;
    private javax.swing.JButton btnWithdraw;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> comboCardType;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel pnlCardInputs;
    private javax.swing.JPanel pnlCurrentBalance;
    private javax.swing.JPanel pnlDashboard;
    private javax.swing.JPanel pnlDepositMoney;
    private javax.swing.JPanel pnlOptions;
    private javax.swing.JPanel pnlWithdrawMoney;
    private javax.swing.JPasswordField pwdPin;
    private javax.swing.JRadioButton radioDeposit;
    private javax.swing.JRadioButton radioWithdraw;
    private javax.swing.JTextField txtCurrentBalance;
    private javax.swing.JTextField txtDepositMoney;
    private javax.swing.JTextField txtExpDate;
    private javax.swing.JLabel txtTotal;
    private javax.swing.JTextField txtWithdrawMoney;
    // End of variables declaration//GEN-END:variables
}
