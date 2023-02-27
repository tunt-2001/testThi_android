package tuntph15511.fpoly.BaiThi.ui.activity;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import tuntph15511.fpoly.BaiThi.R;
import tuntph15511.fpoly.BaiThi.dao.SinhVienDao;
import tuntph15511.fpoly.BaiThi.model.SinhVien;


public class ThemSinhVienActivity extends AppCompatActivity {
    private EditText nameVatTu;
    private EditText giaVatTu;
    private EditText address;
    private Button add;
    private SinhVienDao dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_vat_tu);


        nameVatTu = (EditText) findViewById(R.id.nameVatTu);
        giaVatTu = (EditText) findViewById(R.id.giaVatTu);
        address = (EditText) findViewById(R.id.addressVatTu);
        add = (Button) findViewById(R.id.add);
        dao = new SinhVienDao(this);

        add.setOnClickListener(v->{
            String name = nameVatTu.getText().toString();
            String gia = giaVatTu.getText().toString();
            String addr = address.getText().toString();
            SinhVien sinhVien = new SinhVien();
            sinhVien.setName(name);
            sinhVien.setAge(Integer.parseInt(gia));
            sinhVien.setAddress(addr);

            if(dao.addVatTu(sinhVien) == true){
                Toast.makeText(this, "Them Thanh Cong", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ThemSinhVienActivity.this,MainActivity.class));
            }else {
                Toast.makeText(this, "Them bai", Toast.LENGTH_SHORT).show();
            }

        });
    }
}