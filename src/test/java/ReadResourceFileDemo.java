import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.util.ResourceUtils;
 
public class ReadResourceFileDemo
{
    public static void main(String[] args) throws IOException
    {
        //String fileName = "downloadedTemplates/ESI REGISTRATION.xlsx";
        
        File file = ResourceUtils.getFile("classpath:downloadedTemplates/ESI REGISTRATION.xlsx");
        		 
        		//File is found
        		System.out.println("File Found : " + file.exists());
        		 
        		//Read File Content
        		String content = new String(Files.readAllBytes(file.toPath()));
        		System.out.println(content);
    }
}