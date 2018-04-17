package test;

import java.io.FileNotFoundException;
import java.io.IOException;

import util.LogUtil;

public class TestIO {
	public static void main(String[] args) {
		LogUtil lu = new LogUtil();
		try {
			lu.read();
			lu.write();
			StringBuilder sb = new StringBuilder("hello");
			lu.log(sb.toString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				lu.destroy();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
