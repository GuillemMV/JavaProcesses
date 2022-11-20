
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Test{
 
	public static void main(String[] args) throws IOException, InterruptedException {
		String cmd = "ls -ltr";
	    
	    ProcessBuilder builder = new ProcessBuilder();
		builder.command("sh","-c",cmd);
    
        Process result = builder.start();
        
        int exitcode=result.waitFor(); 
        if (exitcode == 0) {
			System.out.println("Success!");
		} else {
			System.out.println("Abnormal failure");
			System.out.println("Quitting the program");
			System.exit(1);
		}
        System.out.println("Exit code: " + exitcode);
        
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(result.getInputStream())); 
        String output; 
        while ((output = stdInput.readLine()) != null) 
        { 
            System.out.println(output); 
        }        
	}
}