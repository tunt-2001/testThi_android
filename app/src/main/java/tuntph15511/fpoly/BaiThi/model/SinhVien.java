package tuntph15511.fpoly.BaiThi.model;


import java.io.Serializable;

public class SinhVien implements Serializable {
    private int id;
    private String name;
    private int age;
    private String address;

    public SinhVien() {
    }

    public SinhVien(int id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

