package poly.edu.ass.views;


import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import poly.edu.ass.model.Student;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author admin
 */
public class QuanLySinhVien extends javax.swing.JFrame {
    private String header[] ={"Mã SV","Họ tên","Email","Số ĐT","Giới tính","Địa chỉ","Hình"};
    private static String URL = "jdbc:sqlserver://localhost:1433;databaseName=FPL_DaoTao;user=sa;password=123;encrypt=true;trustServerCertificate=true";
   DefaultTableModel tblModel = new DefaultTableModel(header,0);
   String namePic = "";
    String p_sdt = "0[0-9]{9}";
    private static final String P_EMAIL = "^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$";
   List<Student> list = new ArrayList<>();
    public QuanLySinhVien() {
        initComponents();
        setLocationRelativeTo(null);
        loadData();
    }
    
    void loadData(){
        Connection cn = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            cn = DriverManager.getConnection(URL);
            String sql="select*from Students";
            
            stm = cn.createStatement();
            rs =stm.executeQuery(sql);
            Vector sv = null;
            tblModel.setRowCount(0);
            if(rs.isBeforeFirst()==false){
                JOptionPane.showMessageDialog(this, "Chưa có sinh viên");
                return ;
            }
            while (rs.next()) {                
                sv= new Vector();
                sv.add(rs.getString("MASV"));
                sv.add(rs.getString("HOTEN"));
                sv.add(rs.getString("EMAIL"));
                sv.add(rs.getString("SODT"));
                sv.add(rs.getString("GIOITINH"));
                sv.add(rs.getString("DIACHI"));
                sv.add(rs.getString("HINH"));
                tblModel.addRow(sv);
            }
            tbl_thongtinsv.setModel(tblModel);
            cn.close();
            stm.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(QuanLySinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
    
        public void ShowDetal(int i) {
        txt_masv.setText(tbl_thongtinsv.getValueAt(i, 0).toString());
        txt_hoten.setText(tbl_thongtinsv.getValueAt(i, 1).toString());
        txt_email.setText(tbl_thongtinsv.getValueAt(i, 2).toString());
        txt_sodt.setText(tbl_thongtinsv.getValueAt(i, 3).toString());
        int gioitinh = Integer.parseInt(tbl_thongtinsv.getValueAt(i, 4).toString());
        if (gioitinh==1) {
            rdo_nam.setSelected(true);
        } else {
            rdo_nu.setSelected(true);
        }
        txt_diachi.setText(tbl_thongtinsv.getValueAt(i, 5).toString());
        UpHinh(tbl_thongtinsv.getValueAt(i, 6).toString());
    }
     public void UpHinh(String hinh){
        ImageIcon imgIcon = new ImageIcon("src\\images\\"+hinh);
        Image image = imgIcon.getImage();
        ImageIcon icon = new ImageIcon(image.getScaledInstance(lbl_anh.getWidth(), lbl_anh.getHeight(), image.SCALE_SMOOTH));
        lbl_anh.setIcon(icon);
        
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
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_masv = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_hoten = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_sodt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        rdo_nam = new javax.swing.JRadioButton();
        rdo_nu = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        scrollPane1 = new java.awt.ScrollPane();
        txt_diachi = new java.awt.TextArea();
        btn_new = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_thongtinsv = new javax.swing.JTable();
        lbl_anh = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Quản Lý Sinh Viên");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Mã SV:");

        txt_masv.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Họ tên:");

        txt_hoten.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_hoten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hotenActionPerformed(evt);
            }
        });

        txt_email.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Email:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Số ĐT:");

        txt_sodt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Giới tính:");

        buttonGroup1.add(rdo_nam);
        rdo_nam.setText("Nam");

        buttonGroup1.add(rdo_nu);
        rdo_nu.setText("Nữ");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Địa chỉ:");

        txt_diachi.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        scrollPane1.add(txt_diachi);

        btn_new.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btn_new.setForeground(new java.awt.Color(0, 0, 255));
        btn_new.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        btn_new.setText("New");
        btn_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newActionPerformed(evt);
            }
        });

        btn_save.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btn_save.setForeground(new java.awt.Color(0, 51, 255));
        btn_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Save.png"))); // NOI18N
        btn_save.setText("Save");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        btn_delete.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btn_delete.setForeground(new java.awt.Color(0, 51, 255));
        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Delete.png"))); // NOI18N
        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_update.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btn_update.setForeground(new java.awt.Color(0, 51, 255));
        btn_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Edit.png"))); // NOI18N
        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        tbl_thongtinsv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sv", "Họ Tên", "Email", "Số ĐT", "Giới Tính", "Địa Chỉ", "Hình"
            }
        ));
        tbl_thongtinsv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_thongtinsvMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_thongtinsv);

        lbl_anh.setText("ảnh");
        lbl_anh.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbl_anh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_anhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_new, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_update)
                            .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_masv, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(rdo_nam, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdo_nu, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_hoten, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_sodt, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(96, 96, 96)
                        .addComponent(lbl_anh, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(138, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txt_email, txt_hoten, txt_masv, txt_sodt});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_delete, btn_new, btn_save, btn_update});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txt_masv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txt_hoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txt_sodt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(rdo_nu)
                                    .addComponent(rdo_nam)))
                            .addComponent(lbl_anh, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn_new)
                                    .addComponent(btn_save))
                                .addGap(12, 12, 12)
                                .addComponent(btn_delete))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(btn_update)))
                        .addGap(279, 279, 279))))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txt_email, txt_hoten, txt_masv, txt_sodt});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_delete, btn_new, btn_save, btn_update});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_hotenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hotenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hotenActionPerformed

    private void lbl_anhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_anhMouseClicked
        // TODO add your handling code here:

            JFileChooser jfc = new JFileChooser();
            int result = jfc.showOpenDialog(null);
            if (result==JFileChooser.APPROVE_OPTION) {
                File file = jfc.getSelectedFile();
                String fullPath = file.getAbsolutePath();
                namePic = jfc.getSelectedFile().getName();
                UpHinh(fullPath);
                Path src = Paths.get(fullPath);
                Path dest = Paths.get("src\\images\\"+namePic);
                try {
                    Files.copy(src, dest,StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException ex) {
                    Logger.getLogger(QuanLySinhVien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
           
    }//GEN-LAST:event_lbl_anhMouseClicked

    private void btn_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newActionPerformed
        // TODO add your handling code here:
        reset();
        
    }//GEN-LAST:event_btn_newActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        // TODO add your handling code here:
        luu();
    }//GEN-LAST:event_btn_saveActionPerformed

    private void tbl_thongtinsvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_thongtinsvMouseClicked
        // TODO add your handling code here:
        int index = tbl_thongtinsv.getSelectedRow();
        ShowDetal(index);
    }//GEN-LAST:event_tbl_thongtinsvMouseClicked

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
        sua();
        
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        xoa();
    }//GEN-LAST:event_btn_deleteActionPerformed

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
            java.util.logging.Logger.getLogger(QuanLySinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLySinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLySinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLySinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLySinhVien().setVisible(true);
            }
        });
    }
    void reset(){
        txt_masv.setText("");
        txt_hoten.setText("");
        txt_email.setText("");
        txt_sodt.setText("");
        txt_diachi.setText("");
        rdo_nam.setSelected(true);
    }
        public boolean validateForm(){
        if (txt_masv.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập mã sinh viên");
            txt_masv.requestFocus(); 
            txt_masv.setBackground(Color.red);
            return false; 
        }else{
            txt_masv.setBackground(Color.white);
            
        }
        if (txt_hoten.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập họ tên");
            txt_hoten.requestFocus(); 
            txt_hoten.setBackground(Color.red);
            return false; 
        }else{
            txt_hoten.setBackground(Color.white);
            
        }
        if (txt_email.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Chưa nhập Email");
            txt_email.requestFocus(); 
            txt_email.setBackground(Color.red);
            return false;
        }else{
            if (txt_email.getText().matches(P_EMAIL)==false) {
                JOptionPane.showMessageDialog(this, "Email chưa đúng định dạng");
                txt_email.requestFocus();
                txt_email.setBackground(Color.blue);
                return false; 
            }
            txt_email.setBackground(Color.white);
        }
        if (txt_sodt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập số điện thoại");
            txt_sodt.requestFocus(); 
            txt_sodt.setBackground(Color.red);
            return false; 
        }else{
            if (txt_sodt.getText().matches(p_sdt)==false) {
                JOptionPane.showMessageDialog(this, "Số điện thoại sai định dạng");
                txt_sodt.requestFocus();
                txt_sodt.setBackground(Color.blue);
                return false; 
            }
            txt_sodt.setBackground(Color.white);
        }
        if (txt_diachi.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập địa chỉ");
            txt_diachi.requestFocus(); 
            txt_diachi.setBackground(Color.red);
            return false; 
        }else{
            txt_diachi.setBackground(Color.white);
            
        }
        return true;
    }
    void luu(){
        if (validateForm()) {
            try {
               Connection cn = DriverManager.getConnection(URL);
               String sql = "INSERT INTO Students(MASV,HOTEN,EMAIL,SODT,GIOITINH,DIACHI,HINH) VALUES (?,?,?,?,?,?,?)";
               PreparedStatement stm = cn.prepareStatement(sql);
               stm.setString(1, txt_masv.getText().trim());
               stm.setString(2, txt_hoten.getText().trim());
               stm.setString(3, txt_email.getText().trim());
               stm.setString(4, txt_sodt.getText().trim());
               String gt = "";
                if (rdo_nam.isSelected()) {
                    gt="1";
                }else{
                    gt ="0";
                }
               stm.setString(5, gt);
               stm.setString(6, txt_diachi.getText().trim());
               stm.setString(7, namePic.trim());
               
               
               stm.executeUpdate();
               stm.close();
               cn.close();
               loadData();
               ShowDetal(0);
            } catch (Exception e) {
            }
        }
    }
    void sua(){
        try {
            Connection cn = DriverManager.getConnection(URL);
            String sql = "UPDATE Students SET HOTEN=?,EMAIL=?, SODT=?, GIOITINH=?,DIACHI=?,HINH=? WHERE MASV=?  ";
            PreparedStatement stm = cn.prepareStatement(sql);
            stm.setString(1, txt_hoten.getText().trim());
            stm.setString(2, txt_email.getText().trim());
            stm.setString(3, txt_sodt.getText().trim());
            String gt = "";
             if (rdo_nam.isSelected()) {
                 gt="1";
             }else{
                 gt ="0";
             }
            stm.setString(4, gt);
            stm.setString(5, txt_diachi.getText().trim());
            stm.setString(6, namePic.trim());
            stm.setString(7, txt_masv.getText().trim());
            
            
            stm.executeUpdate();
            stm.close();
            cn.close();
            loadData();
            ShowDetal(0);
        } catch (SQLException ex) {
            Logger.getLogger(QuanLySinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    void xoa(){
        try {
            Connection cn = DriverManager.getConnection(URL);
            String sql = "DELETE FROM Students WHERE MASV = ?";
            PreparedStatement ps = null;
            ps= cn.prepareStatement(sql);
            ps.setString(1,txt_masv.getText().trim());
            ps.execute();
            loadData();
            JOptionPane.showMessageDialog(this, "Xóa thành công <3");
        } catch (SQLException ex) {
            Logger.getLogger(QuanLySinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_new;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_update;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_anh;
    private javax.swing.JRadioButton rdo_nam;
    private javax.swing.JRadioButton rdo_nu;
    private java.awt.ScrollPane scrollPane1;
    private javax.swing.JTable tbl_thongtinsv;
    private java.awt.TextArea txt_diachi;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_hoten;
    private javax.swing.JTextField txt_masv;
    private javax.swing.JTextField txt_sodt;
    // End of variables declaration//GEN-END:variables
}