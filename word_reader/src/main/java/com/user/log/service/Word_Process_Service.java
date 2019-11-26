package com.user.log.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class Word_Process_Service {
	private MultipartFile UploadedFile;
	public static String FileContent;

	public MultipartFile getUploadedFile() {
		return UploadedFile;
	}

	public void setUploadedFile(MultipartFile uploadedFile) {
		UploadedFile = uploadedFile;
	}

	public Map<String, Integer> UniqueWordsCounter() {
		BufferedReader br;

		HashMap<String, Integer> WordCount = new HashMap<>();
		Map<String, Integer> sorted = new HashMap<>();
		List<String> result = new ArrayList<>();
		try {

			String line;
			FileContent = "";
			InputStream is = UploadedFile.getInputStream();
			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				FileContent += line + " ";
				result.addAll(Arrays.asList(line.split(" ")));
			}

			for (String word : result) {
				if (!WordCount.containsKey(word))
					WordCount.put(word, 1);
				else
					WordCount.put(word, WordCount.get(word) + 1);
			}

			sorted = WordCount.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(
					Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		return sorted;
	}

}
