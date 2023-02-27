package tuntph15511.fpoly.BaiThi.ui.activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


import tuntph15511.fpoly.BaiThi.R;
import tuntph15511.fpoly.BaiThi.dao.SinhVienDao;
import tuntph15511.fpoly.BaiThi.model.SinhVien;
import tuntph15511.fpoly.BaiThi.ui.adapter.SinhVienAdapter;

public class MainActivity extends AppCompatActivity implements SinhVienAdapter.Callback{
    private ListView listview;
    private List<SinhVien> data;
    private SinhVienAdapter sinhVienAdapter;
    private SinhVienDao sinhVienDao;
    private EditText nameVatTu;
    private EditText giaVatTu;
    private EditText address;
    private Button edit1;
    private Button cancel;
    private Button them;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        them = (Button) findViewById(R.id.them);


        listview = (ListView) findViewById(R.id.listview);
        data = new ArrayList<>();
        them.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, ThemSinhVienActivity.class));
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        showData();
    }

    private void showData() {
        sinhVienDao = new SinhVienDao(this);
        data = sinhVienDao.getListAllVatTu();
        sinhVienAdapter = new SinhVienAdapter(data, this);
        listview.setAdapter(sinhVienAdapter);
    }

    @Override
    public void delete(SinhVien sinhVien) {

        sinhVienDao.deleteVatTu(sinhVien.getId());
        Toast.makeText(this, "Xoa thanh coong", Toast.LENGTH_SHORT).show();
        showData();
    }

    @Override
    public void edit(SinhVien sinhVien) {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_edit);

        dialog.setCancelable(false);

        Window window = dialog.getWindow();
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        if (dialog != null && dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }

        nameVatTu = (EditText) dialog.findViewById(R.id.nameVatTu);
        giaVatTu = (EditText) dialog.findViewById(R.id.giaVatTu);
        address = (EditText) dialog.findViewById(R.id.addressVatTu);
        edit1 = (Button) dialog.findViewById(R.id.edit);
        cancel = (Button) dialog.findViewById(R.id.cancel);

        edit1.setOnClickListener(v -> {
            String name = nameVatTu.getText().toString();
            String age = giaVatTu.getText().toString();
            String addr = address.getText().toString();

            SinhVien sinhVien1 = new SinhVien(sinhVien.getId(), name, Integer.parseInt(age),addr);

            if (sinhVienDao.editVatTu(sinhVien1) == true) {
                Toast.makeText(this, "Sua thanh cong", Toast.LENGTH_SHORT).show();
                showData();
                dialog.cancel();
            } else {
                Toast.makeText(this, "Sua bai", Toast.LENGTH_SHORT).show();
            }
        });

        cancel.setOnClickListener(v -> {
            dialog.cancel();
        });

        dialog.show();


    }
}