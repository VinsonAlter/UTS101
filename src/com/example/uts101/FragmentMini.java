package com.example.uts101;

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
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.app.Fragment;
import android.app.FragmentManager;

public class FragmentMini extends Fragment{
	EditText ab;
	EditText ba;
	EditText ac;
	Button bclick;
	TextView ehasil1;
	TextView ehasil2;
	TextView ehasil3;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		View rootView = inflater.inflate(R.layout.fragment_mini, container, false);
		ab = (EditText)rootView.findViewById(R.id.etanda);
		ba = (EditText)rootView.findViewById(R.id.etanda2);
		ac = (EditText)rootView.findViewById(R.id.etanda3);
		bclick = (Button)rootView.findViewById(R.id.btnclick);
		ehasil1 = (TextView)rootView.findViewById(R.id.tvjwb1);
		ehasil2 = (TextView)rootView.findViewById(R.id.tvjwb2);
		ehasil3 = (TextView)rootView.findViewById(R.id.tvjwb3);
		
		bclick.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0){
				//TODO Auto-generated method stub
				String hasil = ab.getText().toString();
				if(hasil.equals("Yes")||hasil.equals("YES")||hasil.equals("yes")){
					ehasil1.setText("Salah");
				} else if (hasil.equals("No")||hasil.equals("NO")||hasil.equals("no")){
					ehasil1.setText("Benar");
				}
				
				String hasil1 = ba.getText().toString();
				if(hasil1.equals("Yes")||hasil1.equals("YES")||hasil1.equals("yes")){
					ehasil2.setText("Iya");
				} else if (hasil1.equals("No")||hasil1.equals("NO")||hasil1.equals("no")){
					ehasil2.setText("Salah");
				}
				
				String hasil2 = ac.getText().toString();
				if(hasil2.equals("Yes")||hasil2.equals("YES")||hasil2.equals("yes")){
					ehasil3.setText("benar");
				} else if (hasil2.equals("No")||hasil2.equals("NO")||hasil2.equals("no")){
					ehasil3.setText("tidak");
				}
				
			}
		});
		return rootView;
	}
}