package practice01;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class FileUtil {
	public static final String PREFIX = "note_";
	public static final String FILE_EXT = ".txt";
	public static final String PATH = "C:/ssi/study/TestFiles";
	
	public static synchronized File getNoteFile() {
		StringBuffer sb = new StringBuffer(PREFIX);
		sb.append(DateUtil.getCurTimeAs8Digit());
		sb.append(FILE_EXT);
		File file = new File(PATH, sb.toString());
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return file;
	}
	
	public static String[] listFiles(String directory, final String prefix) {
		File dir = new File(directory);
		String[] files= dir.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				if (prefix == null) {
					return true;
				}
				return name.startsWith(prefix);
			}
		});
		
		if (files != null && files.length > 1) {
			Arrays.sort(files, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					return o1.compareTo(o2);
				}
			});
		}
		
		return files;
	}
}
