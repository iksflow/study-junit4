package practice01;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class TestFileUtil {
	@Test	
	public void testScenario1() {
		File file = FileUtil.getNoteFile();
		assertNotNull(file);
		
		String today = DateUtil.getCurTimeAs8Digit();
		assertNotNull(today);
		assertEquals("20200316", today);
		
		String[] fileNames = FileUtil.listFiles(FileUtil.PATH, FileUtil.PREFIX);
		assertNotNull(fileNames);
		for (String fileName : fileNames) {
			System.out.println("File name : " + fileName);
		}
	}
}
