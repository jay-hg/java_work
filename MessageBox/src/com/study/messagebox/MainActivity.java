package com.study.messagebox;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity implements OnClickListener{

	private String textPhoneNumber;
	private EditText etMessage;
	private String textMessage;
	private EditText etPhoneNumber;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button button = (Button) findViewById(R.id.buttonSend);
		button.setOnClickListener(this);
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
	
	@Override
	public void onClick(View v)
	{
		etPhoneNumber = (EditText) findViewById(R.id.etNumber);
		etMessage = (EditText) findViewById(R.id.etMessage);
		textPhoneNumber = etPhoneNumber.getText().toString();
		textMessage = etMessage.getText().toString();
		
		SmsManager messages = SmsManager.getDefault();
		ArrayList<String> contents = messages.divideMessage(textMessage);
		for (String str:contents)
		{
			messages.sendTextMessage(textPhoneNumber, null, str, null, null);
		}
		
	}
}
