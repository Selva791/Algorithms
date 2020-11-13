package com.Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FavouriteGenre {
public static void main(String[] args) {
	Map<String, List<String>> userMap=new HashMap<>();
	Map<String, List<String>> genreMap=new HashMap<>();
	userMap.put("David", Arrays.asList("song1", "song2", "song3", "song4", "song8"));
	userMap.put("Emma", Arrays.asList("song5", "song6", "song7"));
	
	//genreMap.put("Rock", Arrays.asList("song1", "song3"));
	//genreMap.put("Dubstep", Arrays.asList("song7"));
	//genreMap.put("Techno", Arrays.asList("song2", "song4"));
//	genreMap.put("Pop", Arrays.asList("song5", "song6"));
	//genreMap.put("Jazz", Arrays.asList("song8", "song9"));

	FavouriteGenre f=new FavouriteGenre();
	System.out.println(f.favoritegenre(userMap, genreMap));
}
public Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
   	Map<String, List<String>> res = new HashMap<>();
   	Map<String, String> songstogenre = new HashMap<>();
   	
   	for(String genre : genreMap.keySet()) {
   		List<String> songs = genreMap.get(genre);
   		for(String song : songs) {
   			songstogenre.put(song, genre);
   		}
   	}
       Map<String, Integer> count = new HashMap();
   	int max = 0;
   	for(String user : userMap.keySet()) {
           count = new HashMap();
           max = 0;
           res.put(user, new ArrayList());
   		List<String> songs = userMap.get(user);
   		for(String song : songs) {
   			String genre = songstogenre.get(song);
   			int c = count.getOrDefault(genre, 0) + 1;
   			count.put(genre, c);
               max = Math.max(c, max);
   		}
           for (String key : count.keySet()) {
               if (key!=null&&count.get(key) == max) {
            	
                   res.get(user).add(key);
               }
           }
   	}
   	return res;
   }
}
