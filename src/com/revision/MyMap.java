package com.revision;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MyMap<K, V> {
	int capacity;
	Entry<K, V> buckets[];
	int size;
	double lf=0.75;

	public MyMap(int size) {
		this.capacity = size;
		buckets = new Entry[this.capacity];
	}

	public static void main(String[] args) {
		MyMap<String, String> myMap = new MyMap<>(3);
		myMap.put("USA", "Washington DC");
		myMap.put("Nepal", "Kathmandu");
		myMap.put("India", "New Delhi");
		myMap.put("Australia", "Sydney");
		myMap.put("USA", "Washington");
		List<Integer> li=new ArrayList<Integer>();
		Collections.synchronizedCollection(li);
		System.out.println(myMap.get("USA"));
	}


	private void put(K key, V value) {
		if(size>=lf*capacity) {
			Entry<K, V> old[]=buckets;
			capacity*=2;
		buckets=new Entry[capacity];
			for(Entry<K, V> s:old) {
				while(s!=null) {
					put(s.key,s.value);
					s=s.next;

				}
				
			}
		}
		Entry<K, V> newValue = new Entry<>(key, value, null);
		int bucket = getHash(key) % bucket();
		Entry<K, V> essentials = buckets[bucket];

		if (essentials == null) {
			buckets[bucket] = newValue;
			size++;
		} else {
			while (essentials.next != null) {
				if (essentials.key.equals(key)) {
					essentials.value = value;
				}
				essentials = essentials.next;
			}
			if (essentials.key.equals(key)) {
				essentials.value = value;

			} else {
				essentials.next = new Entry<>(key, value, null);
				size++;
			}
		}

	}

	public V get(K key) {
		int bucket = getHash(key) %bucket();
		Entry<K, V> find = buckets[bucket];
		
			while (find != null) {
				
				if (find.key.equals(key)) {
					return find.value;
				}
				find = find.next;
			}
			
		return null;
	}

	private int bucket() {
		return buckets.length;
	}

	private int getHash(K key) {
		return (key == null) ? 0 : Math.abs(key.hashCode());
	}

	public static class Entry<K, V> {
		private K key;
		private V value;
		Entry<K, V> next;

		public Entry(K key, V value, Entry<K, V> next) {
			this.key = key;
			this.value = value;
			this.next = next;

		}

		public K getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}

		@Override
		public boolean equals(Object keyObject) {
			if (keyObject instanceof Entry) {
				Entry ent = (Entry) keyObject;
				return ent.getKey().equals(key) && ent.getValue().equals(value);
			}
			return false;

		}

	}
}
