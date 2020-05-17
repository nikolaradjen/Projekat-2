package excel_and_txt;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TxtUtils {
	static Properties prop = new Properties();

	public static void initTxtReader() throws IOException {

		FileInputStream fi = new FileInputStream("src/locators.txt");
		prop.load(fi);

	}

	public static String readLocator(String key) {

		return prop.getProperty(key);

	}

}
