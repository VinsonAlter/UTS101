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

public class Aritmetika extends Fragment{
	EditText lm;
	Button clo;
	TextView di;
	
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
View rootView = inflater.inflate(R.layout.layout_aritmetika, container, false);
lm = (EditText)rootView.findViewById(R.id.ethasil);
clo = (Button)rootView.findViewById(R.id.btnsubmit);
di = (TextView)rootView.findViewById(R.id.tvjelas);

clo.setOnClickListener(new View.OnClickListener(){

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		int ok = Integer.parseInt(lm.getText().toString());
		if (ok==10){
			di.setText("anda benar");
		} else{
			di.setText("Anda salah");
		}
		}
	});
	return rootView;
	
}
}
