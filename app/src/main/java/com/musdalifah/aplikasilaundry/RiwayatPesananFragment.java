package com.musdalifah.aplikasilaundry;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.musdalifah.aplikasilaundry.adapter.AdapterPesananRecyclerView;
import com.musdalifah.aplikasilaundry.database.AppDatabase;
import com.musdalifah.aplikasilaundry.database.models.Pesanan;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RiwayatPesananFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RiwayatPesananFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private RecyclerView rv;
    private RecyclerView.Adapter adapter;
    private AppDatabase appDatabase;
    private List<Pesanan> pesananList;

    public RiwayatPesananFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RiwayatPesananFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RiwayatPesananFragment newInstance(String param1, String param2) {
        RiwayatPesananFragment fragment = new RiwayatPesananFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        appDatabase = Room.databaseBuilder(this.getContext(), AppDatabase.class, "aplikasi_laundry.db").allowMainThreadQueries().build();
        pesananList = appDatabase.pesananDao().getAll();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup view,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        adapter = new AdapterPesananRecyclerView(pesananList, this.getContext());

        return inflater.inflate(R.layout.fragment_riwayat_pesanan, view, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rv = view.findViewById(R.id.rv_main);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this.getContext()));
        rv.setAdapter(adapter);
    }
}