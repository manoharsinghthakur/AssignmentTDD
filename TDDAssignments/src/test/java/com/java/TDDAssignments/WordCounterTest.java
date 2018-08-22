package com.java.TDDAssignments;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class WordCounterTest {
	public static WordCounter createWordCounter(){
		return new WordCounter();
	}
	@Test
	public void shouldReturnUniqueStringWithCount(){
		Map map = new HashMap();
		map.put("boom", 2);
		map.put("bang", 1);
		map.put("abc", 3);

		Assert.assertEquals(map,createWordCounter().printUniqueWordsWithCount("boom, bang, boom, abc, abc, abc"));
	}
}
