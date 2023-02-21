package com.musdalifah.aplikasilaundry;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.room.Room;

import com.musdalifah.aplikasilaundry.database.AppDatabase;
import com.musdalifah.aplikasilaundry.database.models.Pesanan;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BuatPesananFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BuatPesananFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    
    private String mParam1;
    private String mParam2;

    Button btnIncKaos;
    Button btnDecKaos;
    EditText inputKaos;

    Button btnIncKemeja;
    Button btnDecKemeja;
    EditText inputKemeja;

    Button btnIncCelana;
    Button btnDecCelana;
    EditText inputCelana;

    Button btnIncSelimut;
    Button btnDecSelimut;
    EditText inputSelimut;

    Button btnIncPakaianDalam;
    Button btnDecPakaianDalam;
    EditText inputPakaianDalam;

    Button btnIncJaket;
    Button btnDecJaket;
    EditText inputJaket;

    Button btnAddData;
    private AppDatabase appDb;

    public BuatPesananFragment() {
        // Required empty public constructor
    }

    public static BuatPesananFragment newInstance(String param1, String param2) {
        BuatPesananFragment fragment = new BuatPesananFragment();
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

        appDb = Room.databaseBuilder(this.getContext(), AppDatabase.class, "aplikasi_laundry.db").allowMainThreadQueries().build();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnIncKaos = view.findViewById(R.id.btn_pesanan_inc_kaos);
        btnDecKaos = view.findViewById(R.id.btn_pesanan_dec_kaos);
        inputKaos = view.findViewById(R.id.input_pesanan_kaos);

        btnIncKemeja = view.findViewById(R.id.btn_pesanan_inc_kemeja);
        btnDecKemeja = view.findViewById(R.id.btn_pesanan_dec_kemeja);
        inputKemeja = view.findViewById(R.id.input_pesanan_kemeja);

        btnIncCelana = view.findViewById(R.id.btn_pesanan_inc_celana);
        btnDecCelana = view.findViewById(R.id.btn_pesanan_dec_celana);
        inputCelana = view.findViewById(R.id.input_pesanan_celana);

        btnIncSelimut = view.findViewById(R.id.btn_pesanan_inc_selimut);
        btnDecSelimut = view.findViewById(R.id.btn_pesanan_dec_selimut);
        inputSelimut = view.findViewById(R.id.input_pesanan_selimut);

        btnIncPakaianDalam = view.findViewById(R.id.btn_pesanan_inc_pakaian_dalam);
        btnDecPakaianDalam = view.findViewById(R.id.btn_pesanan_dec_pakaian_dalam);
        inputPakaianDalam = view.findViewById(R.id.input_pesanan_pakaian_dalam);

        btnIncJaket = view.findViewById(R.id.btn_pesanan_inc_jaket);
        btnDecJaket = view.findViewById(R.id.btn_pesanan_dec_jaket);
        inputJaket = view.findViewById(R.id.input_pesanan_jaket);

        btnAddData = view.findViewById(R.id.btn_add_data);

        btnDecKaos.setOnClickListener(v -> decreaseQuantity(inputKaos));
        btnDecCelana.setOnClickListener(v -> decreaseQuantity(inputCelana));
        btnDecJaket.setOnClickListener(v -> decreaseQuantity(inputJaket));
        btnDecKemeja.setOnClickListener(v -> decreaseQuantity(inputKemeja));
        btnDecPakaianDalam.setOnClickListener(v -> decreaseQuantity(inputPakaianDalam));
        btnDecSelimut.setOnClickListener(v -> decreaseQuantity(inputSelimut));

        btnIncKaos.setOnClickListener(v -> increaseQuantity(inputKaos));
        btnIncCelana.setOnClickListener(v -> increaseQuantity(inputCelana));
        btnIncJaket.setOnClickListener(v -> increaseQuantity(inputJaket));
        btnIncKemeja.setOnClickListener(v -> increaseQuantity(inputKemeja));
        btnIncPakaianDalam.setOnClickListener(v -> increaseQuantity(inputPakaianDalam));
        btnIncSelimut.setOnClickListener(v -> increaseQuantity(inputSelimut));

        btnAddData.setOnClickListener(v -> {
            savePesanan(
                    Integer.parseInt(inputKaos.getText().toString()),
                    Integer.parseInt(inputKemeja.getText().toString()),
                    Integer.parseInt(inputCelana.getText().toString()),
                    Integer.parseInt(inputSelimut.getText().toString()),
                    Integer.parseInt(inputPakaianDalam.getText().toString()),
                    Integer.parseInt(inputJaket.getText().toString())
            );
            Navigation.findNavController(v).navigate(R.id.action_buatPesananFragment_to_halamanUtamaFragment);
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_buat_pesanan, container, false);
    }

    private void increaseQuantity(EditText target) {
        int currentCount = Integer.parseInt(target.getText().toString());
        target.setText(Integer.toString(currentCount + 1), TextView.BufferType.EDITABLE);
    }
    private void decreaseQuantity(EditText target) {
        int currentCount = Integer.parseInt(target.getText().toString());
        if(currentCount > 0) {
            target.setText(Integer.toString(currentCount - 1), TextView.BufferType.EDITABLE);
        }
    }

    private void savePesanan(
            int kaos,
            int kemeja,
            int celana,
            int selimut,
            int pakaian_dalam,
            int jaket
    ) {
        Pesanan pesanan = new Pesanan();
        pesanan.setCelana(celana);
        pesanan.setJaket(jaket);
        pesanan.setKaos(kaos);
        pesanan.setKemeja(kemeja);
        pesanan.setSelimut(selimut);
        pesanan.setPakaianDalam(pakaian_dalam);

        appDb.pesananDao().insert(pesanan);
    }
}