package com.study.login;

import java.util.Map;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.study.loginserver.LoginServer;

public class MainActivity extends ActionBarActivity {

	private EditText etUser;
	private EditText etPassword;
	private CheckBox cbRememberPassword;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//���
		etUser = (EditText)findViewById(R.id.etUser);
		etPassword = (EditText)findViewById(R.id.etPassword);
		cbRememberPassword = (CheckBox)findViewById(R.id.cbRememberPassword);
		
		
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
	
	public boolean logIn(View view)
	{
		String etUserText = etUser.getText().toString();
		String etPasswordText = etPassword.getText().toString();
		//�жϷ���������
		if (etUserText==null || etPasswordText==null)
		{
			//��ʾ����Ϊ��
			Toast.makeText(this, "�û��������벻��Ϊ��", 0).show();
			return false;
		}
		//�ж��Ƿ��ס���룬��������
		if (cbRememberPassword.isChecked())
		{
			//�����˺�����
			LoginServer.saveUserInfo(this,etUserText,etPasswordText);
			
			Toast.makeText(this, "�����û���Ϣ�ɹ�", 0);
			
		}
		else
		{
			LoginServer.saveUserInfo(this,null,null);
		}
		//��½
		if (etUserText.equals("chgchg") && etPasswordText.equals("123456"))
		{
			//��ʾ��½�ɹ�
			Toast.makeText(this, "��½�ɹ�", 0).show();
			return true;
		}
		else
		{
			//��ʾ����
			Toast.makeText(this, "�û������������", 0).show();
			return false;
		}
	}
}
