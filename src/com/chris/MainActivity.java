package com.chris;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;

import com.chris.viewflipper.ViewFlipperTest;

public class MainActivity extends ListActivity implements OnItemClickListener {
	
	private String[] example = {"ViewFlipper"};
	private Class[] className = { ViewFlipperTest.class }; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setListAdapter(new ArrayAdapter<String>(
				this, android.R.layout.simple_list_item_1, example));
		getListView().setOnItemClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3) {
		Intent intent = new Intent(this, className[position]);
		startActivity(intent);
	}

}
