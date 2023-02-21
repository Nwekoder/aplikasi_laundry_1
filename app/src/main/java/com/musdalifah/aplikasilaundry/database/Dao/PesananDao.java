package com.musdalifah.aplikasilaundry.database.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.musdalifah.aplikasilaundry.database.models.Pesanan;

import java.util.List;

@Dao
public interface PesananDao {
    @Query("SELECT * FROM pesanan ORDER BY Id DESC")
    public List<Pesanan> getAll();

    @Query("DELETE FROM pesanan WHERE Id = :Id")
    public void deleteById(int Id);

    @Insert
    public Long insert(Pesanan pesanan);
}
