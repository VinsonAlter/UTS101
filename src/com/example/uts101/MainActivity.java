package com.example.uts101;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.ActionBarDrawerToggle;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.MenuItem;

public class MainActivity extends Activity {
	

	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;
	private String mtitle = "";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mtitle = "menu";
        getActionBar().setTitle(mtitle);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mDrawerList = (ListView)findViewById(R.id.drawer_list);
        mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout, R.drawable.ic_drawer, R.drawable.ic_drawer, R.drawable.ic_drawer){
        		public void onDrawerClosed(View view){
        			getActionBar().setTitle(mtitle);
        			invalidateOptionsMenu(); 
        		}
        		public void onDrawerOpened(View drawerView){
        			getActionBar().setTitle("Menu");
        			invalidateOptionsMenu();
        		}
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
        		getBaseContext(),R.layout.drawer_list,getResources().getStringArray(R.array.menus));
        mDrawerList.setAdapter(adapter);
        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        
        mDrawerList.setOnItemClickListener(new OnItemClickListener(){
        	public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        		String[] menuItems = getResources().getStringArray(R.array.menus);
        		mtitle = menuItems[position];
        		if(mtitle.equals("Profile")){
        			FragmentProfile fragmentprofile = new FragmentProfile();
        			FragmentManager fragmentManager = getFragmentManager();
        			FragmentTransaction ft = fragmentManager.beginTransaction();
        			ft.replace(R.id.content_frame, fragmentprofile);
        			ft.commit();
        		}
        		else if(mtitle.equals("Mini Questions")){
        			FragmentMini fragmentmini = new FragmentMini();
        			FragmentManager fragmentManager = getFragmentManager();
        			FragmentTransaction ft = fragmentManager.beginTransaction();
        			ft.replace(R.id.content_frame, fragmentmini);
        			ft.commit();
        		}
        		else if(mtitle.equals("Math Questions")){
        			FragmentMath fragmentmath = new FragmentMath();
        			FragmentManager fragmentManager = getFragmentManager();
        			FragmentTransaction ft = fragmentManager.beginTransaction();
        			ft.replace(R.id.content_frame, fragmentmath);
        			ft.commit();
        		}
        		else if(mtitle.equals("Exit")){
        			finish();
        		}
        		mDrawerLayout.closeDrawer(mDrawerList);
        	}
        }); 
        FragmentProfile fragmentprofile = new FragmentProfile();
        FragmentManager fragmentManager = getFragmentManager();
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
    	if(mDrawerToggle.onOptionsItemSelected(item)){
    		return true;
    	}
    	return super.onOptionsItemSelected(item);
    }
    
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
    	// If the drawer is open, hide action item related to the content view
    	boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
    	menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
    	return super.onPrepareOptionsMenu(menu);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
