/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import Repositories.SanPhamRepositories;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.SanPham;
import service.serviceSanPham;

/**
 *
 * @author Admin
 */
public class HomeFrm extends javax.swing.JFrame {
    
    DefaultTableModel tblModel;
    serviceSanPham svSanPham;
    int index = -1;
    String fileName = "san_pham.txt";
    public HomeFrm() {
        initComponents();
        setLocationRelativeTo(null);
        svSanPham = new serviceSanPham();
        initTable();
        initDoanhMuc();
        cleanForm();
        fakeData();
        loadTable();
        clockTime(lblTime);
    }

    /*
    
    *-Đơn giá phải là số dương 
    -Bổ sung ô nhập ngày san xuất 
    kiểm tra định dạng dd/MM/YYYY
     */
    public void initTable() {
        String[] str = new String[]{
            "Tên SP", "Mã SP", "Danh Mục", "Tình Trạng", "Đơn Giá", "Ngày Sản Xuất"
        };
        tblModel = (DefaultTableModel) tblSp.getModel();
        tblModel.setColumnIdentifiers(str);
    }
    
    public void initDoanhMuc() {
        String[] danhMuc = new String[]{
            "Laptop", "SmartPhone"
        };
        DefaultComboBoxModel<String> boxModel = new DefaultComboBoxModel<>(danhMuc);
        CboDanhMuc.setModel(boxModel);
    }
    
    public void fakeData() {
//        svSanPham.addLst(new SanPham("mac", "m1", "Laptop", true, 1000, "01/01/1990"));
//        svSanPham.addLst(new SanPham("mac", "m1", "Laptop", false, 1000, "01/01/1990"));
//        svSanPham.addLst(new SanPham("mac", "m1", "SmartPhone", true, 1000, "01/01/1990"));
    }
    
    public void loadTable() {
        tblModel.setRowCount(0);
        for (SanPham sp : svSanPham.getLst()) {
            tblModel.addRow(new Object[]{
                sp.getTenSp(),
                sp.getMaSp(),
                sp.getDoanhMuc(),
                sp.isTinhTrang() ? "Còn hàng" : "Hết Hàng",
                sp.getDonGia(),
                sp.getNgaySx()
            });
            
        }
    }
    
    public void clickForm() {
        index = tblSp.getSelectedRow();
        txtTen.setText(svSanPham.getLst().get(index).getTenSp());
        txtMa.setText(svSanPham.getLst().get(index).getMaSp());
        txtDonGia.setText(String.valueOf(svSanPham.getLst().get(index).getDonGia()));
        txtNgaySX.setText(svSanPham.getLst().get(index).getNgaySx());
        CboDanhMuc.setSelectedItem(svSanPham.getLst().get(index).getDoanhMuc());
        boolean tinhTrang = svSanPham.getLst().get(index).isTinhTrang();
        if (tinhTrang == true) {
            rdoConHang.setSelected(true);
        }
        if (tinhTrang == false) {
            rdoHetHang.setSelected(true);
        }
        
    }
    
    public void cleanForm() {
        txtTen.setText("");
        txtDonGia.setText("");
        txtMa.setText("");
        txtNgaySX.setText("");
        rdoConHang.setSelected(true);
        CboDanhMuc.setSelectedIndex(0);
    }
    
    public void deleteSp() {
        index = tblSp.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sp cần xóa");
            return;
        }
        int chk = JOptionPane.showConfirmDialog(this, "Bạn có đồng ý xóa");
        if (chk != JOptionPane.YES_OPTION) {
            return;
        }
        svSanPham.deleteLst(index);
        loadTable();
        cleanForm();
        JOptionPane.showMessageDialog(this, "Xóa thành công");
        
    }
    
    public void updateSp() {
        index = tblSp.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sp cần sửa");
            return;
        }
        if (inputForm() == null) {
            return;
        }
        
        
        svSanPham.updateLst(txtMa.getText(), inputForm());
        loadTable();
        JOptionPane.showMessageDialog(this, "Sửa thành công");
    }
    
    public void addSp() {
        if (inputForm() == null) {
            return;
        }
        SanPhamRepositories sps = new SanPhamRepositories();
        sps.Add(inputForm());
//        svSanPham.addLst(inputForm());
        loadTable();
        JOptionPane.showMessageDialog(this, "Thêm thành công");
    }
    
    public SanPham inputForm() {
        
        if (txtTen.getText().trim().length() == 0 || txtMa.getText().trim().length() == 0 || txtDonGia.getText().trim().length() == 0 || txtNgaySX.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được để trống");
            return null;
        }
        try {
            double donGia = Double.valueOf(txtDonGia.getText());
            if (donGia < 0) {
                JOptionPane.showMessageDialog(this, "Đơn giá không đc đưới âm");
                return null;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Đơn giá phải là số");
            e.printStackTrace();
            return null;
            
        }
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("dd/MM/YYYY");
        try {
            Date d = sdf.parse(txtNgaySX.getText());
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sai định dạng ngày sản xuât dd/MM/YYYY");
            ex.printStackTrace();
            return null;
            
        }
        
        return new SanPham(txtTen.getText(), txtMa.getText(), CboDanhMuc.getSelectedItem().toString(), rdoConHang.isSelected(), Double.parseDouble(txtDonGia.getText()), txtNgaySX.getText());
        
    }
    
    public void clockTime(JLabel lbl) {
        new Thread() {
            @Override
            public void run() {
                while (true) {                    
                    SimpleDateFormat sdf = new SimpleDateFormat();
                    Date d = new Date();
                    sdf.applyPattern("hh:mm:ss");
                    lbl.setText(sdf.format(d));
                    try {
                        Thread.sleep(1000);
                        
                    } catch (InterruptedException ex) {
                        
                    }
                }
                
            }
        }.start();
        
    }
    
    
    
    public void ghiFile(){
        ArrayList<SanPham> ds = svSanPham.getLst();
        File f = new File(fileName);
//        if (f.exists() == false) {
//            JOptionPane.showMessageDialog(this, "File không tồn tại");
//            
//            
//        }
        
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ds);
            oos.close();
            JOptionPane.showMessageDialog(this, "Ghi thành công");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    
    public void docFile(){
        File f = new File(fileName);
        if (f.exists() == false) {
            JOptionPane.showMessageDialog(this, "File không tồn tại");
            return;
            
        }
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<SanPham>  ds = (ArrayList<SanPham>) ois.readObject();
            ois.close();
            svSanPham.setLst(ds);
            loadTable();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        CboDanhMuc = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        rdoConHang = new javax.swing.JRadioButton();
        rdoHetHang = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        txtNgaySX = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnXoaForm = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnGhi = new javax.swing.JButton();
        btnDoc = new javax.swing.JButton();
        lblTime = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSp = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Tên SP");

        jLabel2.setText("Mã Sp");

        jLabel3.setText("Danh mục");

        CboDanhMuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Đơn Giá");

        jLabel5.setText("Tình trạng");

        buttonGroup1.add(rdoConHang);
        rdoConHang.setText("Còn hàng");

        buttonGroup1.add(rdoHetHang);
        rdoHetHang.setText("Hết Hàng");
        rdoHetHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoHetHangActionPerformed(evt);
            }
        });

        jLabel6.setText("Ngày S/X");

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnXoaForm.setText("Xóa Form");
        btnXoaForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaFormActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnGhi.setText("Ghi File");
        btnGhi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGhiActionPerformed(evt);
            }
        });

        btnDoc.setText("Đọc File");
        btnDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDocActionPerformed(evt);
            }
        });

        lblTime.setText("00:00:00");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMa))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CboDanhMuc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdoConHang)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rdoHetHang)
                                .addGap(4, 4, 4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNgaySX, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(51, 51, 51))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnGhi)
                                .addGap(18, 18, 18)
                                .addComponent(btnDoc))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnThem)
                                .addGap(18, 18, 18)
                                .addComponent(btnSua)
                                .addGap(18, 18, 18)
                                .addComponent(btnXoa)
                                .addGap(18, 18, 18)
                                .addComponent(btnXoaForm)
                                .addGap(18, 18, 18)
                                .addComponent(btnExit))
                            .addComponent(lblTime))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(rdoConHang)
                    .addComponent(rdoHetHang))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CboDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(txtNgaySX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnXoaForm)
                    .addComponent(btnExit))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGhi)
                    .addComponent(btnDoc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(lblTime)
                .addContainerGap())
        );

        tblSp.setModel(new javax.swing.table.DefaultTableModel(
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
        tblSp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSpMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSp);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(204, 204, 204))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdoHetHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoHetHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoHetHangActionPerformed

    private void tblSpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSpMouseClicked
        clickForm();
    }//GEN-LAST:event_tblSpMouseClicked

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnXoaFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaFormActionPerformed
        cleanForm();
    }//GEN-LAST:event_btnXoaFormActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        deleteSp();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        addSp();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        updateSp();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnGhiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGhiActionPerformed
        ghiFile();
    }//GEN-LAST:event_btnGhiActionPerformed

    private void btnDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDocActionPerformed
        docFile();
    }//GEN-LAST:event_btnDocActionPerformed

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
    private javax.swing.JComboBox<String> CboDanhMuc;
    private javax.swing.JButton btnDoc;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnGhi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoaForm;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTime;
    private javax.swing.JRadioButton rdoConHang;
    private javax.swing.JRadioButton rdoHetHang;
    private javax.swing.JTable tblSp;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtNgaySX;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables

}
