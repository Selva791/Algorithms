package com.revision;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Tutorial {
public static void main(String[] args) {
	List<String> st=new ArrayList<String>();
	st.add("Paul");
	st.add("Dhoni");
	st.add("Beckam");
	st.add("GOod");
	Map<String, Integer> map8 = st.stream().collect(Collectors.toMap(s -> s,s->0));

}
}
