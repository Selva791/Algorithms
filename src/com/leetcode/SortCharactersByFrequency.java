package com.leetcode;

import java.util.HashMap;
import java.util.Map;
//very slow but working code own code
public class SortCharactersByFrequency {
	public static void main(String[] args) {
		SortCharactersByFrequency st = new SortCharactersByFrequency();
		System.out.println(
				//st.frequencySort("Mymommaalwayssaid,\"Lifewaslikeaboxofchocolates.Youneverknowwhatyou'regonnaget."));
				st.frequencySort("aaaaaaa     hh  dddd"));
		char p = '!';
		int i = 0;
		while (i < 96) {
			i++;
			System.out.print(p);
			p++;
		}
	}

	public String frequencySort(String s) {
		Map<Character, Integer> frequency = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (!frequency.containsKey(s.charAt(i))) {
				frequency.put(s.charAt(i), 1);

			} else {
				frequency.put(s.charAt(i), frequency.get(s.charAt(i)) + 1);
			}

		}
		String v = "";
		for (int i = 0; i <=frequency.size(); i++) {
			char index = '0';
			int temp = -1;
			int c = 0;
			char j = '!';
			int u = 0;
			while (u < 96) {
					
				if (c == frequency.size())
					break;

				if (frequency.get(j) != null&&frequency.get(j) > temp) {
					c++;
					if (frequency.get(j) > temp) {
						temp = frequency.get(j);
						index = j;

					}
					j++;
					u++;
				}

				else if (frequency.get(' ') != null&&frequency.get(' ') > temp) {
					c++;
					if (frequency.get(' ') > temp) {

						temp = frequency.get(' ');
						index = ' ';

					}
				}else {
					j++;
					u++;
				}
				
			}

			if (index != '0') {
				frequency.put(index, -1);

				for (int k = 0; k < temp; k++) {
					
						v += index;

					
				}

				
			}
			if(v.length()==s.length()) break;
		}
		return v;
	}
}

//below efficient code

/* public String frequencySort(String S) {
// Make HashMap of Character And Frequency

    HashMap<Character, Integer> map = new  HashMap<Character, Integer>();
    for(int i=0;i<S.length();i++){
        if(!map.containsKey(S.charAt(i))){
            map.put(S.charAt(i),1);
        }else
            map.put(S.charAt(i), map.get(S.charAt(i))+1);
    }
	// Build Max Heap to get Max Freq character at Top of Heap.
	
    PriorityQueue<Pair> pq = new PriorityQueue<>((Pair a, Pair b)->{
        return b.freq - a.freq; 
    }); 
    
	// Iterate on HashMap keys and Insert All entries into Heap
    // Insert Map entries as Pair(character, Freq)
	
	for(char c : map.keySet()){
        //System.out.println(c + " ---- " +map.get(c));
        pq.add(new Pair(c,map.get(c)));
    }
	//String Builder for String Formation
	
    StringBuilder str = new StringBuilder();
    while(pq.size() !=0){
        Pair p = pq.poll();
        while(p.freq >0){
            str.append(p.ch);
            p.freq--;
        }
    }
return str.toString();

}
}
class Pair{
char ch ;
int freq;
Pair(char ch, int val){
this.ch = ch;
this.freq = val;
}
}*/
