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
		
		//获得
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
		//判断符合条件？
		if (etUserText==null || etPasswordText==null)
		{
			//提示不能为空
			Toast.makeText(this, "用户名或密码不能为空", 0).show();
			return false;
		}
		//判断是否记住密码，保存密码
		if (cbRememberPassword.isChecked())
		{
			//保存账号密码
			LoginServer.saveUserInfo(this,etUserText,etPasswordText);
			
			Toast.makeText(this, "保存用户信息成功", 0);
			
		}
		else
		{
			LoginServer.saveUserInfo(this,null,null);
		}
		//登陆
		if (etUserText.equals("chgchg") && etPasswordText.equals("123456"))
		{
			//提示登陆成功
			Toast.makeText(this, "登陆成功", 0).show();
			return true;
		}
		else
		{
			//提示错误
			Toast.makeText(this, "用户名或密码错误", 0).show();
			return false;
		}
	}
}
