/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.SinhVien;
import serice.ServiceSinhVien;

/**
 *
 * @author Admin
 */
public class HomeFrm extends javax.swing.JFrame {

    DefaultTableModel tblModel;
    ServiceSinhVien svService = new ServiceSinhVien();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
    public HomeFrm() {
        initComponents();
        setLocationRelativeTo(null);
        fakeData();
        initTable();
        initNganh();
        cleanForm();
        loadTable();
    }

    public void initTable() {
        String[] str = new String[]{
            "Họ Và Tên", "Điểm", "Ngành", "Học Lực", "Thưởng", "Giới Tính", "Ngày Sinh"
        };
        tblModel = (DefaultTableModel) tblSV.getModel();
        tblModel.setColumnIdentifiers(str);
    }

    public void initNganh() {
        String[] nganh = new String[]{
            "Thiết Kế Trang Web", "Ứng Dụng Phần Mềm", "Lập Trình Mobile"
        };
        DefaultComboBoxModel<String> boxModel = new DefaultComboBoxModel<>(nganh);
        cboNganh.setModel(boxModel);
    }
    
    public Date date(String text){
        
        try {
            return sdf.parse(text);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return  null;
    }

    public void fakeData() {
//        svService.addLst(new SinhVien("abc", 6, "Ứng Dụng Phần Mềm", "Khá", true, 01/01/1990, false));
//        svService.addLst(new SinhVien("abc", 6, "Ứng Dụng Phần Mềm", "Khá", false, 01/01/1990, true));
//        svService.addLst(new SinhVien("abc", 6, "Lập Trình Mobile", "Khá", true, 01/01/1990, false));
//        

            svService.addLst(new SinhVien("abc", 6, "Lập Trình Mobile", "Khá", true, date("01/01/1990") , false));
            svService.addLst(new SinhVien("abc", 6, "Lập Trình Mobile", "Khá", true, date("01/01/1990") , false));
            svService.addLst(new SinhVien("abc", 6, "Lập Trình Mobile", "Khá", true, date("01/01/1990") , false));
    }

    public void loadTable() {
        tblModel.setRowCount(0);
        for (SinhVien sv : svService.getLst()) {
            tblModel.addRow(new Object[]{
                sv.getHoTen(),
                sv.getDiem(),
                sv.getNganh(),
                sv.getHocLuc(),
                sv.isThuong(),
                sv.isGioiTinh()?"Nam":"Nữ",
                sdf.format(sv.getdate()) 

            });

        }
    }

    public int getIndex() {
        int index = tblSV.getSelectedRow();
        return index;
    }

    public void clickTable() {
        if (getIndex() == -1) {
            JOptionPane.showMessageDialog(this, "vui lòng chọn sv");
            return;
        }
        String hoTen = tblSV.getValueAt(getIndex(), 0).toString();
        String diem = tblSV.getValueAt(getIndex(), 1).toString();
        String nganh = tblSV.getValueAt(getIndex(), 2).toString();
        String hocLuc = tblSV.getValueAt(getIndex(), 3).toString();
        String thuongStr = tblSV.getValueAt(getIndex(), 4).toString();
        String gtStr = tblSV.getValueAt(getIndex(), 5).toString();
        String ngaySinh = tblSV.getValueAt(getIndex(), 6).toString();
        String gt;
        boolean thuong = false;

        if (thuongStr.equalsIgnoreCase("true")) {
            thuong = true;
        }
        if (thuongStr.equalsIgnoreCase("false")) {
            thuong = false;
        }
        if(gtStr.equalsIgnoreCase("Nam")){
            rdoNam.setSelected(true);
        }
        if(gtStr.equalsIgnoreCase("Nữ")){
            rdoNu.setSelected(true);
        }

        txtHoTen.setText(hoTen);
        txtDiem.setText(diem);
        txtHocLuc.setText(hocLuc);
        txtNgaySinh.setText(ngaySinh);
        cboNganh.setSelectedItem(nganh);
        ckbPhanThuong.setSelected(thuong);

    }

    public void cleanForm() {

        txtHoTen.setText("");
        txtDiem.setText("");
        txtHocLuc.setText("");
        cboNganh.setSelectedIndex(0);
        ckbPhanThuong.setSelected(false);
        rdoNam.setSelected(true);
        txtNgaySinh.setText("");
    }

    public SinhVien inputForm() {

        String hoTen = txtHoTen.getText();
        String hocLuc = txtHocLuc.getText();
        String diemStr = txtDiem.getText();
        String nganh = cboNganh.getSelectedItem().toString();
        boolean chkThuong = ckbPhanThuong.isSelected();
        double diem;
        
        String ngaySinh = txtNgaySinh.getText();
        boolean gt = rdoNam.isSelected();
        
        

        if (hoTen.trim().length() == 0 || hocLuc.trim().length() == 0 || diemStr.trim().length() == 0 || ngaySinh.trim().length() == 0   ) {
            JOptionPane.showMessageDialog(this, "Khong đc để trống");
            return null;
        }
            Date d;
        try {
            d = sdf.parse(ngaySinh);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng ngày sinh dd/MM/YYYY");
            e.printStackTrace();
            return null;
        }
        
        
        
        try {
            diem = Double.parseDouble(diemStr);
            if (diem < 0 || diem > 10) {
                JOptionPane.showMessageDialog(this, "Điểm phải từ 0-10");
                return null;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Điểm phải là số");
            e.printStackTrace();
            return null;

        }
        

        if (!hocLuc.equalsIgnoreCase("Giỏi") && !hocLuc.equalsIgnoreCase("Khá") && !hocLuc.equalsIgnoreCase("Yếu") && !hocLuc.equalsIgnoreCase("Trung Bình")) {
            JOptionPane.showMessageDialog(this, "Học lực phải là (Giỏi,Khá,Yếu,Trung Bình)");
            return null;

        }
        
        SinhVien sv = new SinhVien(hoTen, diem, nganh, hocLuc, chkThuong, d , gt);
        System.out.println(date(txtNgaySinh.getText()));

        return sv;
    }

    public void addSvVaride() {
        if (inputForm() == null) {
            return;
        }
        svService.addLst(inputForm());
        loadTable();
        cleanForm();
        JOptionPane.showMessageDialog(this, "Thêm thành công");

    }

    public void deleteSv() {
        if (getIndex() == -1) {
            JOptionPane.showMessageDialog(this, "vui lòng chọn sv");
            return;
        }
        int chk = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa");
        if (chk != JOptionPane.YES_OPTION) {
            return;
        }
        svService.deleteLst(getIndex());

        loadTable();
        cleanForm();
        JOptionPane.showMessageDialog(this, "Xóa thành công");
    }

    public void updateSv() {
        if (getIndex() == -1) {
            JOptionPane.showMessageDialog(this, "vui lòng chọn sv");
            return;
        }

        if (inputForm() == null) {
            return;
        }

        svService.updateLst(getIndex(), inputForm());
        loadTable();
        cleanForm();
        JOptionPane.showMessageDialog(this, "Cập nhật thành công");
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDiem = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cboNganh = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtHocLuc = new javax.swing.JTextField();
        ckbPhanThuong = new javax.swing.JCheckBox();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtNgaySinh = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSV = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("QUẢN LÝ SINH VIÊN");

        jLabel2.setText("Họ Và Tên");

        jLabel3.setText("Điểm");

        jLabel4.setText("Ngành");

        cboNganh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Học Lực");

        ckbPhanThuong.setText("Có phần thưởng?");

        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setText("Cập Nhật");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnReset.setText("Nhập Mới");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnExit.setText("Thoát");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        jLabel6.setText("Ngày Sinh");

        jLabel7.setText("Giới Tính");

        buttonGroup1.add(rdoNam);
        rdoNam.setText("Nam");

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnAdd)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                            .addComponent(txtDiem, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                            .addComponent(txtHocLuc, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                            .addComponent(ckbPhanThuong, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(btnDelete)
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdate)
                                .addGap(18, 18, 18)
                                .addComponent(btnReset)
                                .addGap(18, 18, 18)
                                .addComponent(btnExit))
                            .addComponent(cboNganh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgaySinh)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(rdoNam)
                                .addGap(28, 28, 28)
                                .addComponent(rdoNu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(rdoNam)
                    .addComponent(rdoNu))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cboNganh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtHocLuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ckbPhanThuong)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnDelete)
                    .addComponent(btnUpdate)
                    .addComponent(btnReset)
                    .addComponent(btnExit))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblSV.setModel(new javax.swing.table.DefaultTableModel(
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
        tblSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSV);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(238, 238, 238))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void tblSVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSVMouseClicked
        clickTable();
    }//GEN-LAST:event_tblSVMouseClicked

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        cleanForm();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        addSvVaride();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        deleteSv();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        updateSv();
    }//GEN-LAST:event_btnUpdateActionPerformed

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
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cboNganh;
    private javax.swing.JCheckBox ckbPhanThuong;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblSV;
    private javax.swing.JTextField txtDiem;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtHocLuc;
    private javax.swing.JTextField txtNgaySinh;
    // End of variables declaration//GEN-END:variables
}
