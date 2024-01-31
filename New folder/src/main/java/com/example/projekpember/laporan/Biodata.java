package com.example.projekpember.laporan;

public class Biodata extends Koneksi {
	String URL = "http://127.0.0.1/kopsis/serverlaptransall.php";
	String url = "";
	String response = "";

	public String tampilBiodata() {
		try {
			url = URL + "?operasi=view";
			System.out.println("URL Tampil Biodata: " + url);
			response = call(url);
		} catch (Exception e) {
		}
		return response;
	}

	public String tampilTotal() {
		try {
			url = URL + "?operasi=total";
			System.out.println("URL Tampil Biodata: " + url);
			response = call(url);
		} catch (Exception e) {
		}
		return response;
	}
	
	public String inserBiodata(Integer total_harga, Integer bayar, Integer kembalian) {
		try {
			url = URL + "?operasi=insert&total_harga=" + total_harga + "&bayar=" + bayar + "&kembalian=" + kembalian;
			System.out.println("URL Insert Biodata : " + url);
			response = call(url);
		} catch (Exception e) {
		}
		return response;
	}

	public String deleteBiodata() {
		try {
			url = URL + "?operasi=delete";
			System.out.println("URL Insert Biodata : " + url);
			response = call(url);
		} catch (Exception e) {
		}
		return response;
	}

}
