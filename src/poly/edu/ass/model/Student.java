/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.edu.ass.model;

/**
 *
 * @author admin
 */
public class Student {
    private String maSV;
    private String tenSV;
    private String email;
    private String soDT;
    private boolean gioiTinh;
    private String diaChi;
    private String hinhAnh;

    public Student() {
    }

    public Student(String maSV, String tenSV, String email, String soDT, boolean gioiTinh, String diaChi, String hinhAnh) {
        this.maSV = maSV;
        this.tenSV = tenSV;
        this.email = email;
        this.soDT = soDT;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.hinhAnh = hinhAnh;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    @Override
    public String toString() {
        return "SinhVien{" + "maSV=" + maSV + ", tenSV=" + tenSV + ", email=" + email + ", soDT=" + soDT + ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi + ", hinhAnh=" + hinhAnh + '}';
    }
    
    
}
