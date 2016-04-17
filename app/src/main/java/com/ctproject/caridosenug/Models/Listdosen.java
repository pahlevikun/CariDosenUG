package com.ctproject.caridosenug.Models;

/**
 * Created by farhan on 2/29/16.
 */
import java.util.HashMap;
import java.util.Map;

public class Listdosen {
    //Variabel dalam json
    private Integer id;
    private String nama;
    private String situs;
    private String email;
    private String telepon;
    private String kantor;
    private String jabatan;
    private String matkul;
    private String foto;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    //getter dan setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getSitus() {
        return situs;
    }

    public void setSitus(String situs) { this.situs = situs; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getTelepon() { return telepon; }

    public void setTelepon(String telepon) { this.telepon = telepon; }

    public String getKantor() { return kantor; }

    public void setKantor(String kantor) { this.kantor = kantor; }

    public String getJabatan() { return jabatan; }

    public void setJabatan(String jabatan) { this.jabatan = jabatan; }

    public String getMatkul() { return matkul; }

    public void setMatkul(String matkul) { this.matkul = matkul; }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
