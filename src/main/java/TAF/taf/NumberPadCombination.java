package TAF.taf;
import java.util.*;
import java.lang.*;
import java.io.*;
public class NumberPadCombination {
	
	//class NumberPadString{
	      
	static Character[][] numberToCharMap;
	 
	private static List<String> printWords(int[] numbers,
	                                       int len,
	                                       int numIndex,
	                                       String s)
	{
	  if(len == numIndex)
	  {
	    return new ArrayList<>(Collections.singleton(s));
	  }
	   
	  List<String> stringList = new ArrayList<>();
	   
	  for(int i = 0;
	          i < numberToCharMap[numbers[numIndex]].length; i++)
	  {
	    String sCopy =
	           String.copyValueOf(s.toCharArray());
	    sCopy = sCopy.concat(
	            numberToCharMap[numbers[numIndex]][i].toString());
	    stringList.addAll(printWords(numbers, len,
	                                 numIndex + 1,
	                                 sCopy));
	  }
	  return stringList;
	}
	     
	public static List<String> printWords(int[] numbers)
	{
	  generateNumberToCharMap();
	  List<String> stringList =
	       printWords(numbers, numbers.length, 0, "");	  
	  return stringList;
	}
	 
	
	private static void generateNumberToCharMap()
	{
	  numberToCharMap = new Character[10][5];
	  numberToCharMap[0] = new Character[]{'0'};
	  numberToCharMap[1] = new Character[]{'1'};
	  numberToCharMap[2] = new Character[]{'A','B','C'};
	  numberToCharMap[3] = new Character[]{'D','E','F'};
	  numberToCharMap[4] = new Character[]{'G','H','I'};
	  numberToCharMap[5] = new Character[]{'J','K','L'};
	  numberToCharMap[6] = new Character[]{'M','N','O'};
	  numberToCharMap[7] = new Character[]{'P','Q','R','S'};
	  numberToCharMap[8] = new Character[]{'T','U','V'};
	  numberToCharMap[9] = new Character[]{'W','X','Y','Z'};
	}
	  
	public static void main(String[] args)
	{
	  
	  String readLine;
      String inFilePath = "C:\\Users\\Afsha\\Desktop\\Sample.txt"; 
      String outFilePath = "C:\\Users\\Afsha\\Desktop\\Output1.txt";

      try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inFilePath))) {
    	  try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                  new FileOutputStream(outFilePath), "utf-8"))) {
    		  
      while ((readLine = bufferedReader.readLine()) != null) {
          
          String[] splitInput = readLine.split("/",0);        
	 
          int parseInt = Integer. parseInt(splitInput[1]); 
          
          String temp = Integer.toString(parseInt);
          int[] number = new int[temp.length()];
          for (int i = 0; i < temp.length(); i++) {
        	  number[i] = temp.charAt(i) - '0';
          }
          
	  List<String> printWords = printWords(number);
	  
	  String join = String.join(", ", printWords);
	  StringBuilder strb = new StringBuilder();
	  strb.append(readLine).append("/").append(join);
      writer.write(String.format(strb.toString()));
      writer.write("\n");
      
          }
      bufferedReader.close();

    	  }      
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	}
	