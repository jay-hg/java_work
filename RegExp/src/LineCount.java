import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class LineCount {
	DataInputStream dis = null;
	long normalLines;
	long commentLines;
	long blankLines;
	
	public static void main(String[] args) {
		new LineCount().launch();
	}
	
	public void launch() {
		File file = new File("E:/java_work/TankWar2.8/src/com/game/tankwar");
		File files[] = file.listFiles();
		for (int i=0; i<files.length; i++) {
			if(files[i].getName().matches(".*\\.java$")) {
				System.out.println(files[i]);
				parse(files[i]);
			}
		}
		
		System.out.println();
		System.out.println("normalLines"+normalLines);
		System.out.println("commentLines"+commentLines);
		System.out.println("blankLines"+blankLines);
	}

	private void parse(File file) {
		try {
			dis = new DataInputStream(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		String s;
		long blankLine = 0;
		long normalLine = 0;
		long commentLine = 0;
		boolean commentStart = false;
		try {
			while((s = dis.readLine()) != null) {
				s = s.trim();
				if (s.matches("^[\\s]*")) {
					blankLine ++;
				} else if (s.startsWith("/*") && s.endsWith("*/")){
					commentLine ++;
				} else if (s.startsWith("/*") && !s.endsWith("*/")) {
					commentStart = true;
				} else if (s.endsWith("*/")) {
					commentLine ++;
					commentStart = false;
				} else if (s.startsWith("//")){
					commentLine ++;
				}else {
					if (!commentStart) {
						normalLine ++;
					}
				}
					
				if (commentStart) {
					commentLine ++;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("blankLine count:"+blankLine);
		System.out.println("commentLine count:"+commentLine);
		System.out.println("normalLine count:"+normalLine);

		normalLines += normalLine;
		commentLines += commentLine;
		blankLines += blankLine;
	}
}
