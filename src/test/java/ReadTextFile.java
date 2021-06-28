import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class ReadTextFile {

	public static void main(String[] args) throws Exception {
		/*String fileName = "D:/poiexcel/new.txt";
		File file = new File(fileName);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line;
		while((line = br.readLine()) != null){
		    System.out.println(line);
		}
*/
		try {

            File f = new File("D:/poiexcel/App.pdf");

            System.out.println("Reading files using Apache IO:");

            List<String> lines = FileUtils.readLines(f, "UTF-8");

            for (String line : lines) {
                System.out.println(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
	}


