import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Pare {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		String command1 = "ls -la";
		String command2 = "ls | tr 'd' 'D'";
		
		ProcessBuilder p1 = new ProcessBuilder("/bin/bash","-c",command1); //Process 1.
		ProcessBuilder p2 = new ProcessBuilder("/bin/bash","-c",command2); //Process 2.

		Process fill1 = p1.start(); //Initialize the processes.
		Process fill2 = p2.start();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(fill1.getInputStream()));
		PrintStream ps = new PrintStream(fill1.getOutputStream());
		
		String line;
		while((line=br.readLine()) != null) {
			ps.flush();
			System.out.println(line);
		}
	}
}
