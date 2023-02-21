/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
 import java.sql.PreparedStatement;

 


 
public class Order extends javax.swing.JFrame {

     
    public Order() {
        initComponents();
        SelectProd();
        SelectCust();
        GetToday();
    }
 Connection Con = null;
     Statement St = null;
    ResultSet Rs = null;
    public void SelectProd(){
      try {
           Class.forName("com.mysql.cj.jdbc.Driver");
    try{
        Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestiondestock","root","User");
        St = Con.createStatement();
        Rs = St.executeQuery("select * from producttab" );
        ProdcutTable.setModel(DbUtils.resultSetToTableModel(Rs));
    }catch(SQLException e)
    {
        e.printStackTrace();
    }
    }catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    public void SelectCust(){
      try {
           Class.forName("com.mysql.cj.jdbc.Driver");
    try{
        Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestiondestock","root","User");
        St = Con.createStatement();
        Rs = St.executeQuery("select * from customertbl" );
        Custtbl.setModel(DbUtils.resultSetToTableModel(Rs));
    }catch(SQLException e)
    {
        e.printStackTrace();
    }
    }catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
}
     private void GetToday()
     {
         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd  ");
         LocalDateTime now = LocalDateTime.now();
         //System.out.println(dtf.format(nom));
         Datelbl.setText( dtf.format(now));
                 
                 
     } 
      
     private  void update()
     { int newqty = oldqty - Integer.parseInt(Qtybtn.getText());
           try{
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestiondestock ","root","User");
            String UpdateQuery = "UPDATE gestiondestock.producttbl SET ProdQty= '" +newqty +  "' WHERE ProdId = '" + productid;

            Statement Add = Con.createStatement();
            Add.executeUpdate(UpdateQuery);
             //JOptionPane.showMessageDialog( this,"Update succefull");
            SelectProd();
                     }catch(Exception e) 
        {
           e.printStackTrace();  
        }  
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Custtbl = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ProdcutTable = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Billtbl = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        Qtybtn = new javax.swing.JTextField();
        Addbtn = new javax.swing.JButton();
        Addbtn1 = new javax.swing.JButton();
        Addbtn2 = new javax.swing.JButton();
        AddToOrd = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Billbtn = new javax.swing.JTextField();
        ToAmt = new javax.swing.JTextField();
        Datelbl = new javax.swing.JTextField();
        CustNamebtn = new javax.swing.JTextField();
        Pricebtn = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        AddToOrd1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 153, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(" Stock Managemnt");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Manage Order");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(383, 383, 383)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        Custtbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Custtbl.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        Custtbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CuStId", "CustName", "CustPhone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        Custtbl.setGridColor(new java.awt.Color(0, 102, 153));
        Custtbl.setSelectionBackground(new java.awt.Color(255, 255, 255));
        Custtbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CusttblMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Custtbl);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 204));
        jLabel9.setText(" Customers list");

        ProdcutTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ProdcutTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ProdcutTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ProdId", "Name", "Quantity", "Description", "Category"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        ProdcutTable.setGridColor(new java.awt.Color(0, 102, 153));
        ProdcutTable.setSelectionBackground(new java.awt.Color(0, 102, 153));
        ProdcutTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProdcutTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ProdcutTable);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 204));
        jLabel10.setText(" Product list");

        Billtbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Billtbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Billtbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                " Num", "Product", "Quantity", " Uprice", " Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        Billtbl.setGridColor(new java.awt.Color(0, 102, 153));
        Billtbl.setSelectionBackground(new java.awt.Color(255, 255, 255));
        Billtbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BilltblMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(Billtbl);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 204));
        jLabel5.setText(" Quantity");

        Qtybtn.setText(" ");
        Qtybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QtybtnActionPerformed(evt);
            }
        });

        Addbtn.setBackground(new java.awt.Color(0, 153, 204));
        Addbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Addbtn.setForeground(new java.awt.Color(255, 255, 255));
        Addbtn.setText("  Add Order");
        Addbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddbtnMouseClicked(evt);
            }
        });
        Addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddbtnActionPerformed(evt);
            }
        });

        Addbtn1.setBackground(new java.awt.Color(0, 153, 204));
        Addbtn1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Addbtn1.setForeground(new java.awt.Color(255, 255, 255));
        Addbtn1.setText("view Order");
        Addbtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Addbtn1MouseClicked(evt);
            }
        });

        Addbtn2.setBackground(new java.awt.Color(0, 153, 204));
        Addbtn2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Addbtn2.setForeground(new java.awt.Color(255, 255, 255));
        Addbtn2.setText(" Home");
        Addbtn2.setToolTipText("");
        Addbtn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Addbtn2MouseClicked(evt);
            }
        });

        AddToOrd.setBackground(new java.awt.Color(0, 153, 204));
        AddToOrd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        AddToOrd.setForeground(new java.awt.Color(255, 255, 255));
        AddToOrd.setText("Add To Order");
        AddToOrd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddToOrdMouseClicked(evt);
            }
        });
        AddToOrd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddToOrdActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 204));
        jLabel6.setText(" OrderId");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 204));
        jLabel7.setText("Customer Name");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 204));
        jLabel8.setText(" date");

        Billbtn.setText(" ");
        Billbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BillbtnActionPerformed(evt);
            }
        });

        ToAmt.setForeground(new java.awt.Color(0, 153, 204));
        ToAmt.setText("Amount");
        ToAmt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ToAmtActionPerformed(evt);
            }
        });

        Datelbl.setText(" ");
        Datelbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DatelblActionPerformed(evt);
            }
        });

        CustNamebtn.setForeground(new java.awt.Color(0, 153, 204));
        CustNamebtn.setText("name");
        CustNamebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustNamebtnActionPerformed(evt);
            }
        });

        Pricebtn.setText(" ");
        Pricebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PricebtnActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 153, 204));
        jLabel11.setText(" Price");

        AddToOrd1.setBackground(new java.awt.Color(0, 153, 204));
        AddToOrd1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        AddToOrd1.setForeground(new java.awt.Color(255, 255, 255));
        AddToOrd1.setText(" Print");
        AddToOrd1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddToOrd1MouseClicked(evt);
            }
        });
        AddToOrd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddToOrd1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CustNamebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Billbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Datelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(147, 147, 147))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 143, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Addbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95)
                        .addComponent(Addbtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Addbtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(166, 166, 166)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(28, 28, 28)
                                .addComponent(Pricebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Qtybtn, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(AddToOrd, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)))
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(ToAmt, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AddToOrd1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Qtybtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(Pricebtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(AddToOrd))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Billbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jLabel8))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(CustNamebtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(Datelbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Addbtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Addbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Addbtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ToAmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddToOrd1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(17, 17, 17))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CusttblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CusttblMouseClicked
        TableModel model = (DefaultTableModel)Custtbl.getModel();
        int Myindex = Custtbl.getSelectedRow();
       //CustNamebtn.setText(model.getValueAt( Myindex, 0).toString());
        CustNamebtn.setText( model.getValueAt( Myindex, 1).toString());
      //  CustPhone.setText( model.getValueAt( Myindex, 2).toString());

    }//GEN-LAST:event_CusttblMouseClicked
String Prodname;
int flag = 0, productid , oldqty;
    private void ProdcutTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProdcutTableMouseClicked
           DefaultTableModel model = (DefaultTableModel)ProdcutTable.getModel();
        int Myindex = ProdcutTable.getSelectedRow();
          productid = Integer.valueOf(model.getValueAt( Myindex, 0).toString());
        Prodname =  model.getValueAt( Myindex, 1).toString() ;
       oldqty =Integer.valueOf(  model.getValueAt( Myindex, 2).toString());
       // ProdDesc.setText( model.getValueAt( Myindex, 3).toString());
       flag = 1;
    }//GEN-LAST:event_ProdcutTableMouseClicked

    private void BilltblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BilltblMouseClicked
       
    }//GEN-LAST:event_BilltblMouseClicked

    private void QtybtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QtybtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_QtybtnActionPerformed

    private void AddbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddbtnMouseClicked
        if(Billbtn.getText().isEmpty())
        {
             JOptionPane.showMessageDialog(this, "Enter the bill Id");
        }
        else{
            try{
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestiondestock ","root","User");
                 PreparedStatement add = (PreparedStatement) Con.prepareStatement("insert into ordertbl values(?,?,?,?)");
                 add.setInt(1, Integer.parseInt(Billbtn.getText().trim()));
                 add.setString( 2, CustNamebtn.getText());
                  add.setString( 3, Datelbl.getText());
                 add.setString(4,ToAmt.getText().trim());
                int row = add.executeUpdate() ;
                JOptionPane.showMessageDialog(this, "Order Succefully Added");
                Con.close();
                SelectCust();
            }catch(SQLException e)
            {
                e.printStackTrace();
            }}
         
    }//GEN-LAST:event_AddbtnMouseClicked

    private void Addbtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Addbtn1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Addbtn1MouseClicked

    private void Addbtn2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Addbtn2MouseClicked
        new HomePanel().setVisible( true);
        this.dispose();
    }//GEN-LAST:event_Addbtn2MouseClicked
int i = 1,Uprice, tot=0,total;
    private void AddToOrdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddToOrdMouseClicked
     if(flag==0 || Qtybtn.getText().isEmpty() || Pricebtn.getText().isEmpty() )
     {
         JOptionPane.showMessageDialog(this, "Select Product and Entre Qty!!");
     }
     else {
        Uprice = Integer.valueOf( Pricebtn.getText().trim());
       tot = Uprice* Integer.valueOf( Qtybtn.getText().trim());
        Vector v = new Vector();
         v.add(i);
         v.add(Prodname);
         v.add(Qtybtn.getText().trim());
         v.add(Uprice);
         v.add(tot);
          
         DefaultTableModel dt =   (DefaultTableModel)Billtbl.getModel();
         dt.addRow( v);;
         total = tot + total;
         ToAmt.setText(total+"DA");
         update();
         i++;}
    }//GEN-LAST:event_AddToOrdMouseClicked

    private void AddToOrdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddToOrdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddToOrdActionPerformed

    private void BillbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BillbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BillbtnActionPerformed

    private void ToAmtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ToAmtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ToAmtActionPerformed

    private void DatelblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DatelblActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DatelblActionPerformed

    private void CustNamebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustNamebtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CustNamebtnActionPerformed

    private void PricebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PricebtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PricebtnActionPerformed

    private void AddToOrd1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddToOrd1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_AddToOrd1MouseClicked

    private void AddToOrd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddToOrd1ActionPerformed
        try{
            Billtbl.print();
        }catch(Exception exp)
        {
            exp.printStackTrace();
        }
    }//GEN-LAST:event_AddToOrd1ActionPerformed

    private void AddbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddbtnActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Order().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddToOrd;
    private javax.swing.JButton AddToOrd1;
    private javax.swing.JButton Addbtn;
    private javax.swing.JButton Addbtn1;
    private javax.swing.JButton Addbtn2;
    private javax.swing.JTextField Billbtn;
    private javax.swing.JTable Billtbl;
    private javax.swing.JTextField CustNamebtn;
    private javax.swing.JTable Custtbl;
    private javax.swing.JTextField Datelbl;
    private javax.swing.JTextField Pricebtn;
    private javax.swing.JTable ProdcutTable;
    private javax.swing.JTextField Qtybtn;
    private javax.swing.JTextField ToAmt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
