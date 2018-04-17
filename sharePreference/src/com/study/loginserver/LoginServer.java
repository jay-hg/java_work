package com.study.loginserver;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class LoginServer {
	public static void saveUserInfo(Context context,String userName, String password)
	{
		SharedPreferences sharedPreferences = context.getSharedPreferences("config", Context.MODE_PRIVATE);
		Editor e = sharedPreferences.edit();
		e.putString("userName", userName);
		e.putString("password", password);
		e.commit();
	}
	
	
}
