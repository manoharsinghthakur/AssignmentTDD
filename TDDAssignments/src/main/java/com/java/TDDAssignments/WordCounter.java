package com.java.TDDAssignments;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordCounter {
	
	public  Map  printUniqueWordsWithCount(String string){
		String[] stringArray = string.split(", ");
		List list=Arrays.stream(stringArray).collect(Collectors.toList());
		Map<String,Integer> mapOfUniqueWordsWithCount=new HashMap();
		list.forEach(word->mapOfUniqueWordsWithCount.merge( (String) word, 1, (V, newV)-> V+newV));
		
		return mapOfUniqueWordsWithCount;
	}

	

	
}
