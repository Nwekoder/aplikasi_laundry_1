package com.musdalifah.aplikasilaundry.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.musdalifah.aplikasilaundry.database.Dao.PesananDao;
import com.musdalifah.aplikasilaundry.database.models.Pesanan;

@Database(entities = {Pesanan.class}, version = 1)
abstract public class AppDatabase extends RoomDatabase  {
    public abstract PesananDao pesananDao();
}
