package hooks;

import java.nio.file.*;
import java.util.regex.*;  


public class PreCommit {
  public static String readFileAsString(String fileName) throws Exception {
    String data = "";
    data = new String(Files.readAllBytes(Paths.get(fileName)));
    return data;
  }

  public static void main(String[] args) throws Exception {
    String data = readFileAsString(args[0]);

    Pattern p = Pattern.compile("^.*\\(.+,*\\): [a-zA-Z0-9 ]*$");
    Matcher m = p.matcher(data);  
    boolean b = m.find();  

    if(b)
      System.exit(0);
    else
      System.exit(1);  
  }
}
