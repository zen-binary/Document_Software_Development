/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.NhanVien;
import multi.MultiThreading;
import service.ServiceNhanVien;

/**
 *
 * @author Admin
 */
public class HomeFrm extends javax.swing.JFrame {

    ServiceNhanVien svNhanVien = new ServiceNhanVien();
    DefaultTableModel tblModel;
    int index = -1;
    String fileName = "NhanVien.txt";

    public HomeFrm() {
        initComponents();
        setLocationRelativeTo(null);
//        fakeDate();
//        TimeThread time = TimeThread(lblTime);
//        Thread t1 = new Thread(time);
//        t1.start();
        cleanForm();
        initTable();
        loadTable();
        record();
        clockTime(lblTime);

    }

//    public void fakeDate() {
//        svNhanVien.addLst(new NhanVien("a1", "abc", 5, "abc@abc.com", 1000));
//        svNhanVien.addLst(new NhanVien("a1", "abc", 5, "abc@abc.com", 1000));
//        svNhanVien.addLst(new NhanVien("a1", "abc", 5, "abc@abc.com", 1000));
//    }
    public void initTable() {
        String[] str = new String[]{
            "Mã", "Họ Tên", "Tuổi", "Email", "Lương"
        };
        tblModel = (DefaultTableModel) tblNhanVien.getModel();
        tblModel.setColumnIdentifiers(str);

    }

    public void loadTable() {
        tblModel.setRowCount(0);
        for (NhanVien nv : svNhanVien.getLst()) {
            tblModel.addRow(new Object[]{
                nv.getMa(),
                nv.getHoTen(),
                nv.getTuoi(),
                nv.getEmail(),
                nv.getLuong()
            });
        }
    }

    public int getIndex() {
        return index = tblNhanVien.getSelectedRow();
    }

    public void viewForm(int index) {
        String ma = tblNhanVien.getValueAt(index, 0).toString();
        String hoTen = tblNhanVien.getValueAt(index, 1).toString();
        String tuoi = tblNhanVien.getValueAt(index, 2).toString();
        String email = tblNhanVien.getValueAt(index, 3).toString();
        String luong = tblNhanVien.getValueAt(index, 4).toString();

        txtMa.setText(ma);
        txtHoTen.setText(hoTen);
        txtTuoi.setText(tuoi);
        txtEmail.setText(email);
        txtLuong.setText(luong);
    }

    public void clickTable() {
        index = getIndex();
        viewForm(index);
        record();

    }

    public void cleanForm() {
        txtMa.setText("");
        txtHoTen.setText("");
        txtTuoi.setText("");
        txtEmail.setText("");
        txtLuong.setText("");

    }

    public NhanVien getForm() {
        String ma = txtMa.getText();
        String hoTen = txtHoTen.getText();
        String tuoiStr = txtTuoi.getText();
        String email = txtEmail.getText();
        String luongStr = txtLuong.getText();
        int tuoi;
        double luong;
        String chkEmail = "\\w+@\\w+(\\.\\w+){1,2}";

        if (ma.trim().length() == 0 || hoTen.trim().length() == 0 || tuoiStr.trim().length() == 0 || email.trim().length() == 0 || luongStr.trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được để trống");
            return null;
        }
        
        

        try {
            tuoi = Integer.parseInt(tuoiStr);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Tuổi phải là số");
            return null;
        }
        if (tuoi <16 || tuoi >55) {
            JOptionPane.showMessageDialog(this, "Tuổi phải từ 16 - 55");
            return null;
        }
        
        if(!email.matches(chkEmail)){
            JOptionPane.showMessageDialog(this, "Email không đúng định dạng");
            return null;
        }

        try {
            luong = Double.valueOf(luongStr);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Luong phải là số phải là số");
            return null;
        }
        
        if (luong <5000000) {
            JOptionPane.showMessageDialog(this, "Luong phải trên 5tr");
            return null;
        }

        NhanVien nv = new NhanVien(ma, hoTen, tuoi, email, luong);

        return nv;
    }

    public void addNv(NhanVien nv) {

        svNhanVien.addLst(nv);
        loadTable();

    }

    public void updateNv(NhanVien nv) {
        svNhanVien.updateLst(index, nv);
        loadTable();
    }

    public void saveNv() {
        if (getForm() == null) {
            return;
        }

        if (index == -1) {
            for (NhanVien nv : svNhanVien.getLst()) {
            if (nv.getMa().equalsIgnoreCase(txtMa.getText())) {
                JOptionPane.showMessageDialog(this, "Không được trùng mã");
                return;
            }
        }
            addNv(getForm());
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            record();

        } else {
            updateNv(getForm());
            JOptionPane.showMessageDialog(this, "Sửa thành công");

        }

    }

    public void deleteNv() {
        if (getIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nv cần xóa");
            return;
        }
        int chk = JOptionPane.showConfirmDialog(this, "Bạn có chắc chă xóa");
        if (chk != JOptionPane.YES_OPTION) {
            return;
        }

        svNhanVien.deleteLst(getIndex());
        loadTable();
        JOptionPane.showMessageDialog(this, "Xóa thành công");
        record();

    }

    public NhanVien find(String ma) {
        for (NhanVien nv : svNhanVien.getLst()) {
            if (nv.getMa().equalsIgnoreCase(ma)) {
                return nv;
            }
        }
        return null;
    }

    public void findMa() {

        NhanVien nv = find(txtMa.getText());

        if (nv == null) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy");
            return;
        }
        txtMa.setText(nv.getMa());
        txtHoTen.setText(nv.getHoTen());
        txtTuoi.setText(String.valueOf(nv.getTuoi()));
        txtEmail.setText(nv.getEmail());
        txtLuong.setText(String.valueOf(nv.getLuong()));

    }

    public void ghiFile() {

        try {
            JOptionPane.showMessageDialog(this, svNhanVien.ghiFile(fileName));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ghi thất bại");
            e.printStackTrace();
        }

    }

    public void docFile() {

        try {
            JOptionPane.showMessageDialog(this, svNhanVien.docFile(fileName));
            loadTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Đọc thất bại");
            e.printStackTrace();
        }

    }

    public void pre() {
        index = 0;
        viewForm(index);
        tblNhanVien.setRowSelectionInterval(index, index);
        record();

    }

    public void last() {
        index = svNhanVien.getLst().size() - 1;
        viewForm(index);
        tblNhanVien.setRowSelectionInterval(index, index);
        record();
    }

    public void next() {
        index++;
        if (index >= svNhanVien.getLst().size()) {
            index = 0;
        }
        viewForm(index);
        tblNhanVien.setRowSelectionInterval(index, index);
        record();
    }

    public void back() {
        index--;
        if (index < 0) {
            index = svNhanVien.getLst().size() - 1;
        }
        viewForm(index);
        tblNhanVien.setRowSelectionInterval(index, index);
        record();
    }

    public void record() {
        lblRecord.setText("Record: " + (index + 1) + " of " + svNhanVien.getLst().size());
    }

    public void clockTime(JLabel lbl) {
        MultiThreading mt = new MultiThreading(lbl);
        Thread t = new Thread(mt);
        t.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtHoTen = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTuoi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtLuong = new javax.swing.JTextField();
        btnPre = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        lblRecord = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnFind = new javax.swing.JButton();
        btnOpen = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        lblTime = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("QUẢN LÝ NHÂN VIÊN");

        jLabel2.setText("MÃ NHÂN VIÊN");

        jLabel3.setText("HỌ VÀ TÊN");

        jLabel4.setText("TUỔI");

        jLabel5.setText("EMAIL");

        jLabel6.setText("LƯƠNG");

        btnPre.setText("|<");
        btnPre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreActionPerformed(evt);
            }
        });

        btnBack.setText("<<");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnNext.setText(">>");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setText(">|");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhanVien);

        lblRecord.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblRecord.setForeground(new java.awt.Color(255, 0, 0));
        lblRecord.setText("Record: 1 of 10");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnFind.setText("Find");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        btnOpen.setText("Open");
        btnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                    .addComponent(btnSave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFind, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOpen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnNew)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFind)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnOpen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExit)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        lblTime.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTime.setForeground(new java.awt.Color(255, 0, 0));
        lblTime.setText("00:00 AM");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btnPre, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(lblRecord)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addGroup(layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTime)
                .addGap(52, 52, 52))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblTime))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPre)
                            .addComponent(btnBack)
                            .addComponent(btnNext)
                            .addComponent(btnLast)
                            .addComponent(lblRecord)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        cleanForm();
        index = -1;
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        saveNv();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        clickTable();
    }//GEN-LAST:event_tblNhanVienMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        deleteNv();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        ghiFile();
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenActionPerformed
        docFile();
    }//GEN-LAST:event_btnOpenActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        next();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreActionPerformed
        pre();
    }//GEN-LAST:event_btnPreActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        findMa();
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        last();
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        back();
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(HomeFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnOpen;
    private javax.swing.JButton btnPre;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblRecord;
    private javax.swing.JLabel lblTime;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtLuong;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtTuoi;
    // End of variables declaration//GEN-END:variables

}
