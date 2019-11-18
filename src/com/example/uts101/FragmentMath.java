package com.example.uts101;

import android.os.Bundle;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.app.Fragment;
import android.app.FragmentManager;





public class FragmentMath extends Fragment{
	
	ListView lprofil;
	String[] profil = {"Aritmetika Dasar", "Bangun Datar", "Baris dan Deret"};
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
	View rootView = inflater.inflate(R.layout.fragment_math, container, false);

		
	lprofil = (ListView)rootView.findViewById(R.id.ld);
	ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,profil);
    lprofil.setAdapter(adapter);
    lprofil.setOnItemClickListener(listview);
    return rootView;
	}
	
	
	







private AdapterView.OnItemClickListener listview = new AdapterView.OnItemClickListener(){

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
	 		if(arg2 == 0){
	 			Aritmetika aritmetika = new Aritmetika();
	 			FragmentManager fragmentManager = getFragmentManager();
	 			FragmentTransaction ft = fragmentManager.beginTransaction();
	 			ft.replace(R.id.content_frame, aritmetika);
		 		ft.commit();
	 		}else if(arg2 == 1){
	 			Toast.makeText(getActivity(), "Bukan tugas saya", Toast.LENGTH_SHORT).show();
	 		}
	 		else if(arg2 == 2){
	 			Toast.makeText(getActivity(), "Bukan tugas saya", Toast.LENGTH_SHORT).show();
	 		}

	}
};

}






