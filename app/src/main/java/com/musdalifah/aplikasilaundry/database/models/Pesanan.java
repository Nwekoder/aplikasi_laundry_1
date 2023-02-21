package com.musdalifah.aplikasilaundry.database.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "pesanan")
public class Pesanan {
    @PrimaryKey(autoGenerate = true) public int Id;
    @ColumnInfo(name = "kaos") public int kaos;
    @ColumnInfo(name = "kemeja") public int kemeja;
    @ColumnInfo(name = "celana") public int celana;
    @ColumnInfo(name = "selimut") public int selimut;
    @ColumnInfo(name = "pakaian_dalam") public int pakaian_dalam;
    @ColumnInfo(name = "jaket") public int jaket;

    public void setKaos(int kaos) {
        this.kaos = kaos;
    }
    public void setKemeja(int kemeja) {
        this.kemeja = kemeja;
    }
    public void setCelana(int celana) {
        this.celana = celana;
    }
    public void setSelimut(int selimut) {
        this.selimut = selimut;
    }
    public void setPakaianDalam(int pakaian_dalam) {
        this.pakaian_dalam = pakaian_dalam;
    }
    public void setJaket(int jaket) {
        this.jaket = jaket;
    }

    public int getId() {
        return Id;
    }
}
