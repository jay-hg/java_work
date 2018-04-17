import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CatchEmail {

	public static void main(String[] args) {
		new CatchEmail().launch();
	}
	
	public void launch() {
		File file = new File("E:/java_work/Test/” œ‰Õ¯“≥/email.txt");
		String line = null;
		Pattern p = Pattern.compile("[\\w||-]+@[\\w]+\\.[\\w]+");
		Matcher m = null;
		try {
			BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			while((line = bf.readLine()) != null) {
				m = p.matcher(line);
				while (m.find()) {
					System.out.println(m.group());
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Ω· ¯");
	}

}
