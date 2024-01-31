package com.example.projekpember.crud1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.projekpember.R;

import java.util.ArrayList;
import java.util.List;

public class ListAdapterBarang extends BaseAdapter implements Filterable{
	private Context context;
	private List<Barang> list, filterd;
	
	public ListAdapterBarang(Context context, List<Barang> list) {
		this.context = context;
		this.list = list;
		this.filterd = this.list;
	}
	
	@Override
	public int getCount() {
		return filterd.size();
	}

	@Override
	public Object getItem(int position) {
		return filterd.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(convertView == null){
			LayoutInflater inflater = LayoutInflater.from(this.context);
			convertView = inflater.inflate(R.layout.list_row, null);
		}
		Barang mhs = filterd.get(position);
		TextView textNama = (TextView) convertView.findViewById(R.id.text_nama);
		textNama.setText(mhs.getNama_barang());
		
		TextView textNis = (TextView) convertView.findViewById(R.id.text_nis);
		textNis.setText(mhs.getMerk());
		
		return convertView;
	}
	
	@Override
	public Filter getFilter() {
		SiswaFilter filter = new SiswaFilter();
		return filter;
	}
	
	/** Class filter untuk melakukan filter (pencarian) */
	private class SiswaFilter extends Filter{
			
		@Override
		protected FilterResults performFiltering(CharSequence constraint) {
			List<Barang> filteredData = new ArrayList<Barang>(); 
			FilterResults result = new FilterResults();
			String filterString = constraint.toString().toLowerCase();
			for(Barang mhs: list){
				if(mhs.getNama_barang().toLowerCase().contains(filterString) || mhs.getMerk().toLowerCase().contains(filterString)){
					filteredData.add(mhs);
				}
			}
			result.count = filteredData.size();
			result.values =  filteredData;
			return result;
		}

		@Override
		protected void publishResults(CharSequence constraint, FilterResults results) {
			filterd = (List<Barang>) results.values;
			notifyDataSetChanged();
		}

	}

}