package com.study.sdsearch;

import java.io.File;

import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.support.v7.app.ActionBarActivity;
import android.text.format.Formatter;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//TextView tv = findViewById(R.id.tv);
		
		File path = Environment.getExternalStorageDirectory();
		StatFs stat = new StatFs(path.getPath());
		int blockSize = stat.getBlockSize();
		int blockCount = stat.getBlockCount();
		int avilableBlocks = stat.getAvailableBlocks();
		
		long size = (long)(blockCount*blockSize);
		long avilable = (long)(blockSize*avilableBlocks);
		
		String s1 = Formatter.formatFileSize(this, size);
		String s2 = Formatter.formatFileSize(this, avilable);
		
		Log.v("MainActivity", s1);
		Log.v("MainActivity", s2);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
