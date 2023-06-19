import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String trashPath = "C:\\Users\\SonJunHyeok\\Desktop\\test\\trash";
		String testPath = "C:"+File.separator+"Users"+File.separator+"SonJunHyeok"+File.separator+"Desktop"+File.separator+"test"+File.separator+"trash";
		String separator = "\\";
		if(separator.equals(File.separator)) {
			System.out.println("same");
		}
		else {
			System.out.println("deffirent");
		}
		
//		String filePath = Paths.get("C:","Users","SonJunHyeok","Desktop","test","trash").toString();
		String filePath = "C:/Users/SonJunHyeok/Desktop/test/trash";
		File file = new File(testPath);
		if(file.exists())System.out.println("exist");
		
		System.out.println(file.getPath().replaceAll("\\\\", "/"));
		System.out.println(trashPath);
		System.out.println(testPath);
//		testPath = testPath.replaceAll(File.separator, Matcher.quoteReplacement(File.separator));
		testPath = testPath.replaceAll("\\\\", "/");
		System.out.println(testPath);
		String[] paths = testPath.split("/");
		for(String path : paths) {
			System.out.println(path+", ");
		}
	}

}
