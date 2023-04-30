package TAF.taf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CSVUtility {
	
	public static final String DELIMITER = ",";
	
	public static List<TestData> readFile(File file ) {
		List<TestData> tests = null;
		try(Stream<String> stream = Files.lines(file.toPath())) {
			tests = stream.map(s->getData(s)).collect(Collectors.toList());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tests;
	}
	
	public static TestData getData(String line) {
		TestData data = new TestData();
		String[] split = line.split(DELIMITER);
		data.setType(split[0]);
		data.setInput(split[1]);
		if (split[2].contains("-")) {
			data.setOutput(Arrays.asList(split[2].split("-")));
		} else {
			char[] charArray = split[1].toCharArray();
			int[] output = new int[charArray.length];
			for(int i =0; i<charArray.length;i++) {
				output[i] = Integer.parseInt(String.valueOf(charArray[i]));
			}
			data.setOutput(NumberPadCombination.printWords(output));
		}
		
		data.setExpected(split[3]);
		return data;
	}

}
