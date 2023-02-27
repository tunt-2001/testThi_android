package tuntph15511.fpoly.BaiThi.ui.adapter;


import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import java.util.List;

import tuntph15511.fpoly.BaiThi.R;
import tuntph15511.fpoly.BaiThi.dao.SinhVienDao;
import tuntph15511.fpoly.BaiThi.model.SinhVien;

public class SinhVienAdapter extends BaseAdapter {
    private List<SinhVien> data;
    private TextView nameVatTu;
    private TextView giaVatTu;
    private TextView edit;
    private TextView delete;
    private TextView address;
    private SinhVienDao dao;
    private Callback callback;

    public SinhVienAdapter(List<SinhVien> data, Callback callback) {
        this.data = data;
        this.callback = callback;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return data.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewVatTu;
        if (view == null) {
            viewVatTu = View.inflate(viewGroup.getContext(), R.layout.item_vattu, null);
        } else {
            viewVatTu = view;
        }
        nameVatTu = (TextView) viewVatTu.findViewById(R.id.nameVatTu);
        giaVatTu = (TextView) viewVatTu.findViewById(R.id.giaVatTu);
        edit = (TextView) viewVatTu.findViewById(R.id.edit);
        delete = (TextView) viewVatTu.findViewById(R.id.delete);
        address = (TextView) viewVatTu.findViewById(R.id.addressVatTu);
        SinhVien sinhVien = (SinhVien) getItem(i);

        nameVatTu.setText(sinhVien.getName());
        giaVatTu.setText(String.valueOf(sinhVien.getAge()));
        address.setText(String.valueOf(sinhVien.getAddress()));
        edit.setOnClickListener(v -> {
            callback.edit(sinhVien);
        });

        delete.setOnClickListener(v -> {
            callback.delete(sinhVien);
        });
        return viewVatTu;
    }

    public interface Callback{
        void delete(SinhVien sinhVien);
        void edit(SinhVien sinhVien);
    }
}

