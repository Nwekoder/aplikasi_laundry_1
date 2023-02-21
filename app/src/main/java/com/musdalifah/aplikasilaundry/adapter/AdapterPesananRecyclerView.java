package com.musdalifah.aplikasilaundry.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.musdalifah.aplikasilaundry.R;
import com.musdalifah.aplikasilaundry.database.models.Pesanan;

import java.util.List;

public class AdapterPesananRecyclerView extends RecyclerView.Adapter<AdapterPesananRecyclerView.ViewHolder> {
    private List<Pesanan> daftarPesanan;

    public AdapterPesananRecyclerView(List<Pesanan> pesanans, Context ctx){
        daftarPesanan = pesanans;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv;

        ViewHolder(View v) {
            super(v);
            tv = v.findViewById(R.id.tv_main);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pesanan, parent, false);
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final String nama = "Pesanan " + daftarPesanan.get(position).getId();

        holder.tv.setText(nama);
    }

    @Override
    public int getItemCount() {
        return daftarPesanan.size();
    }
}
