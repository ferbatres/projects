/**
 * 
 */
package com.javatest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * @author Fernando Batres
 * 
 *         2016/11/19
 * 
 *         version 1.0
 *
 */
public class JsonLoad {

	/**
	 * 
	 */
	public JsonLoad() {
	}

	public static final String JSON_PATH1 = "t1.json";
	public static final String JSON_PATH2 = "t2.json";
	public static final String JSON_PATH3 = "t3.json";

	@SuppressWarnings("unchecked")
	public void process() throws IOException, Exception {
		Gson gson = new Gson();
		Runtime rt = Runtime.getRuntime();
		Integer distinctVal = 0;
		String distinctJson = "";
		System.out.println("memory used at the begin of the process: " + (rt.totalMemory() - rt.freeMemory()));

		// Read T1 File
		BufferedReader br = new BufferedReader(new FileReader(JSON_PATH1));
		Type type = new TypeToken<List<T1>>() {
		}.getType();
		List<T1> models = gson.fromJson(br, type);

		// Read T2 File
		BufferedReader br2 = new BufferedReader(new FileReader(JSON_PATH2));
		Type type2 = new TypeToken<List<T2>>() {
		}.getType();
		List<T2> models2 = gson.fromJson(br2, type2);
		
		//Inner Join
		Map<String, List<T1>> tmp = models.stream().collect(Collectors.groupingBy(T1::getZ));
		List<T3> merge = models2.stream()
				.flatMap(m2 -> tmp.getOrDefault(m2.getZ(), Collections.emptyList()).stream().map(m1 -> new T3(m1, m2)))
				.collect(Collectors.toList());
		Integer countNoR = merge.size();
		
		// Group By x en t1 AND Order By desc
		Map<String, List<T3>> resultDef = merge.stream().sorted(Comparator.comparing(T3::getT1x).reversed())
				.collect(Collectors.groupingBy(T3::getT1x, LinkedHashMap::new, Collectors.toList()));
		// Selecting Distinct
		distinctVal = merge.stream().filter(distinctByKey(a -> a.getT1x())).collect(Collectors.toList()).size();
		Gson prettyJson = new GsonBuilder().setPrettyPrinting().create();
		distinctJson = prettyJson.toJson(resultDef);
		FileWriter fw = new FileWriter(JSON_PATH3);
		fw.write(distinctJson);
		fw.close();

		System.out.println("memory used at the end of the process: " + (rt.totalMemory() - rt.freeMemory()));
		System.out.println("total of rows: " + countNoR);
		System.out.println("total of distinct rows in 'x' : " + distinctVal);

	}

	//Looking for distinct key
	public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) throws Exception{
		Map<Object, Boolean> map = new ConcurrentHashMap<>();
		return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}
}
