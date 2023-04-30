package TAF.taf;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TelephoneDialPadCSVTest {
	
	private TestData input;
	private List<String> expected;
	
	public TelephoneDialPadCSVTest(TestData input, List<String> expected) {
		this.input = input;
		this.expected = expected;
	}
	
	@Parameterized.Parameters
	public static Collection parameters() {
		File file = new File("C:\\taf\\taf\\src\\resources\\Sample.txt");
		List<TestData> readFile = CSVUtility.readFile(file);
						
		List<Object[]> collect = readFile.stream()
		.map(l->(convertToArray(l))).collect(Collectors.toList());
		
		Object[][] ob = new Object[collect.size()][2];
		for(int i=0;i<collect.size();i++) {
			for(int j=0;j<2;j++) {
				if(j==0) {
					ob[i][j] = readFile.get(i);
				} else {
					ob[i][j] = readFile.get(i).getOutput();
				}				
			}
		}
		
		return Arrays.asList(ob);
		
	}
	
	public static Object[] convertToArray(TestData data) {
		 Object arrayName[] = {data.getInput(),data.getOutput()};
		 return arrayName;
	}
	
	@Test
	public void addTest() {
		if (input.getExpected().equalsIgnoreCase("true")) {
			assertEquals(expected,TelephoneDialPad.retrieveCombinations(input.getInput()));
		} else if(input.getExpected().equalsIgnoreCase("false")) {
			assertNotSame(expected,
					TelephoneDialPad.retrieveCombinations(input.getInput())); 
		}
	}
}
