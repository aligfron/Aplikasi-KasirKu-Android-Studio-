package com.example.projekpember.crud1;

public class Barang {
	private Integer id;
	private String nama_barang;
	private String merk;
	private String harga_beli;
	private String hargajual;
	private String jumlahbarang;
	
	public Barang() {
		super();
	}

	public Barang(Integer id, String nama_barang, String merk,
			String harga_beli, String hargajual, String jumlahbarang) {
		super();
		this.id = id;
		this.nama_barang = nama_barang;
		this.merk = merk;
		this.harga_beli = harga_beli;
		this.hargajual = hargajual;
		this.jumlahbarang = jumlahbarang;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNama_barang() {
		return nama_barang;
	}

	public void setNama_barang(String nama_barang) {
		this.nama_barang = nama_barang;
	}

	public String getMerk() {
		return merk;
	}

	public void setMerk(String merk) {
		this.merk = merk;
	}

	public String getHarga_beli() {
		return harga_beli;
	}

	public void setHarga_beli(String harga_beli) {
		this.harga_beli = harga_beli;
	}

	public String getHargajual() {
		return hargajual;
	}

	public void setHargajual(String hargajual) {
		this.hargajual = hargajual;
	}
	
	public String getJumlahbarang() {
		return jumlahbarang;
	}
	public void setJumlahbarang(String jumlahbarang) {
	this.jumlahbarang = jumlahbarang;
}
}