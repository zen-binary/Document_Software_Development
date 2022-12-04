/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Model.Students;
import Services.implement.QuanLySinhVienServiceImplement;
import ViewModel.QuanLySinhVienViewModel;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class QuanLySinhVienPanel extends javax.swing.JPanel {

    DefaultTableModel tblModel;
    QuanLySinhVienServiceImplement qlsvSeriImpl = new QuanLySinhVienServiceImplement();
    int index = -1;

    public QuanLySinhVienPanel() {
        initComponents();

        initTable();
        newForm();
        mewTim();
    }
    
    
    public void mewTim(){
        new Thread(){
            @Override
            public void run(){
                int index = 1;
                while (true) {                    
                    lblmew.setIcon(new ImageIcon("img\\mew\\"+index+".png"));
                    index++;
                    if (index == 21) {
                        index =1;
                    }
                    try {
                        Thread.sleep(150);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(QuanLySinhVienPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }.start();
    }

    public void initTable() {
        tblModel = (DefaultTableModel) tblSinhVien.getModel();
        String str[] = new String[]{
            "Mã Sv", "Họ Tên", "Email", "Số ĐT", "Giới Tính", "Địa Chỉ", "Hình"
        };
        tblModel.setColumnIdentifiers(str);
    }

    public void loadTable(ArrayList<QuanLySinhVienViewModel> qlsv) {
        tblModel.setRowCount(0);
        for (QuanLySinhVienViewModel s : qlsv) {
            tblModel.addRow(new Object[]{
                s.getMaSv(),
                s.getHoTen(),
                s.getEmail(),
                s.getSoDt(),
                s.isGioiTinh() ? "Nam" : "Nữ",
                s.getDiaChi(),
                s.getHinh()
            });
        }
    }

    public void newForm() {
        txtMa.setText("");
        txtMaSv.setText("");
        txtPhone.setText("");
        txtHoTen.setText("");
        txtEmail.setText("");
        txtDiaChi.setText("");
        rdoNam.setSelected(true);
        lblAnh.setText("");
        lblAnh.setIcon(null);
        loadTable(qlsvSeriImpl.getLst());
    }
    public void clickTable(){
        index = tblSinhVien.getSelectedRow();
        if (index == -1) {
            return;
        }
        viewTable(index);
    }
    
    public void viewTable(int index) {

        
        String ma = String.valueOf(tblSinhVien.getValueAt(index, 0));
        String hoTen = String.valueOf(tblSinhVien.getValueAt(index, 1));
        String email = String.valueOf(tblSinhVien.getValueAt(index, 2));
        String phone = String.valueOf(tblSinhVien.getValueAt(index, 3));
        String gt = String.valueOf(tblSinhVien.getValueAt(index, 4));
        String diaChi = String.valueOf(tblSinhVien.getValueAt(index, 5));
        String anh = String.valueOf(tblSinhVien.getValueAt(index, 6));

        txtMa.setText(ma);
        txtHoTen.setText(hoTen);
        txtEmail.setText(email);
        txtPhone.setText(phone);
        txtDiaChi.setText(diaChi);

        if (gt.equalsIgnoreCase("Nam")) {
            rdoNam.setSelected(true);
        }
        if (gt.equalsIgnoreCase("Nữ")) {
            rdoNu.setSelected(true);
        }
        viewAnh(anh);

    }

    public void viewAnh(String anh) {
        ImageIcon iicon = new ImageIcon("img//" + anh);
        Image image = iicon.getImage();
        ImageIcon icon = new ImageIcon(image.getScaledInstance(lblAnh.getWidth(), lblAnh.getHeight(), image.SCALE_FAST));
        lblAnh.setName(anh);
        lblAnh.setIcon(icon);
    }

    public void openHinh() {
        JFileChooser fChooser = new JFileChooser("img");
        int chs = fChooser.showOpenDialog(null);
        if (chs != JFileChooser.APPROVE_OPTION) {
            return;
        }
        try {
            File f = fChooser.getSelectedFile();
            if (!f.exists()) {
                JOptionPane.showMessageDialog(this, "Ảnh không tồn tại");
                return;

            }
            ImageIcon iicon = new ImageIcon(f.toString());
            Image image = iicon.getImage();
            ImageIcon icon = new ImageIcon(image.getScaledInstance(lblAnh.getWidth(), lblAnh.getHeight(), image.SCALE_FAST));

            String nameAnh = fChooser.getSelectedFile().getName();
            lblAnh.setName(nameAnh);
            lblAnh.setIcon(icon);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Students inputForm() {
        String ma = txtMa.getText();
        String ten = txtHoTen.getText();
        String email = txtEmail.getText();
        String sdt = txtPhone.getText();
        boolean gt = true;
        String diaChi = txtDiaChi.getText();
        String hinh = lblAnh.getName();

        String emailStr = "\\w+@\\w+(\\.\\w+){1,2}";

        if (ma.trim().length() == 0 || ten.trim().length() == 0 || email.trim().length() == 0 || sdt.trim().length() == 0 || diaChi.trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được để trống");
            return null;
        }
        

        try {
            Double so = Double.valueOf(sdt);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "SDT phải là số");
            e.printStackTrace();
            return null;
        }
        
        if(!txtEmail.getText().matches(emailStr)){
            JOptionPane.showMessageDialog(this, "Email chua dúng dinh dang");
            return null;
        }

        if (sdt.length() <= 10 || sdt.length() > 12) {
            JOptionPane.showMessageDialog(this, "SDT phải từ 10 - 12 số");
            return null;
        }

        if (rdoNam.isSelected()) {
            gt = true;
        }
        if (rdoNu.isSelected()) {
            gt = false;
        }

        Students s = new Students(ma, ten, email, sdt, gt, diaChi, hinh);
        return s;
    }

    public void saveSinhVien() {
        if (inputForm() == null) {
            return;
        }
        index = tblSinhVien.getSelectedRow();

        JOptionPane.showMessageDialog(this, qlsvSeriImpl.addLst(inputForm()));
        loadTable(qlsvSeriImpl.getLst());
    }

    public void deleteSinhVien() {
        String ma = txtMa.getText();
        index = tblSinhVien.getSelectedRow();
        if (index == -1 || ma.equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng chon sv càn xoa");
            return;
        }
        int chk = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa sinh viên có mã là " + qlsvSeriImpl.getLst().get(index).getMaSv(), "Delete", 1,1, new ImageIcon("src\\Icon\\delete.png"));
        if (chk != JOptionPane.YES_OPTION) {
            return;
        }

        JOptionPane.showMessageDialog(this, qlsvSeriImpl.deleteLst(ma));
        loadTable(qlsvSeriImpl.getLst());
        newForm();

    }

    public void updateSinhVien() {

        if (inputForm() == null) {
            return;
        }
        index = tblSinhVien.getSelectedRow();
        if (index == -1) {
            return;
        }
        if (inputForm().getMaSv().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sv cần sửa");
            return;
        }

        JOptionPane.showMessageDialog(this, qlsvSeriImpl.updateLst(inputForm().getMaSv(), inputForm(), index));
        loadTable(qlsvSeriImpl.getLst());
    }
    
    public void searchSinhVien(){
        String txtStr = txtMaSv.getText();
        if (txtStr.trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được để trống bạn có thể tìm theo tên hoặc msv");
            return;
        }
        if (!qlsvSeriImpl.searchLst(txtStr).isEmpty()) {
            loadTable(qlsvSeriImpl.searchLst(txtStr));
            viewTable(0);
            tblSinhVien.setRowSelectionInterval(0, 0);
            JOptionPane.showMessageDialog(this, "Tim ok");
        }else{
            JOptionPane.showMessageDialog(this, "Không tìm thấy");
        }
        
       
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDiaChi = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        lblAnh = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        txtMaSv = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblSinhVien = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lblmew = new javax.swing.JLabel();

        jLabel1.setText("Mã Sv:");

        txtMa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel6.setText("Họ Tên:");

        txtHoTen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel8.setText("Email:");

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel9.setText("Số ĐT:");

        txtPhone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel10.setText("Giới Tính:");

        jLabel11.setText("Địa Chỉ:");

        buttonGroup1.add(rdoNam);
        rdoNam.setText("Nam");

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");

        txtDiaChi.setColumns(20);
        txtDiaChi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDiaChi.setRows(5);
        jScrollPane2.setViewportView(txtDiaChi);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPhone)
                    .addComponent(txtEmail)
                    .addComponent(txtMa)
                    .addComponent(txtHoTen)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(rdoNam)
                        .addGap(18, 18, 18)
                        .addComponent(rdoNu)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(rdoNam)
                    .addComponent(rdoNu))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAnh.setText("Hình Ảnh");
        lblAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAnhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/add.png"))); // NOI18N
        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/savs.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/reload.png"))); // NOI18N
        btnDelete.setText("Update");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/delete.png"))); // NOI18N
        btnUpdate.setText("Delete");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSave)
                .addGap(18, 18, 18)
                .addComponent(btnDelete)
                .addGap(16, 16, 16)
                .addComponent(btnUpdate)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnNew, btnSave});

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnDelete, btnUpdate});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDelete)
                        .addComponent(btnSave)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnDelete, btnNew, btnSave, btnUpdate});

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/loupe.png"))); // NOI18N
        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(txtMaSv, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTimKiem)
                .addGap(33, 33, 33))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMaSv, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        tblSinhVien.setModel(new javax.swing.table.DefaultTableModel(
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
        tblSinhVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSinhVienMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblSinhVien);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblmew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblmew, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblmew, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(32, 32, 32))
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        newForm();
    }//GEN-LAST:event_btnNewActionPerformed

    private void lblAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnhMouseClicked
        openHinh();
    }//GEN-LAST:event_lblAnhMouseClicked

    private void tblSinhVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSinhVienMouseClicked
        clickTable();
    }//GEN-LAST:event_tblSinhVienMouseClicked

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        saveSinhVien();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        updateSinhVien();
        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        deleteSinhVien();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        searchSinhVien();
    }//GEN-LAST:event_btnTimKiemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JLabel lblmew;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblSinhVien;
    private javax.swing.JTextArea txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtMaSv;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
