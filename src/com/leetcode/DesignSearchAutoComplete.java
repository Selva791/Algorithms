package com.leetcode;

import java.util.*;

public class DesignSearchAutoComplete {
    public static void main(String[] args) {
        String [] sen={"i love you","island","iroman","i love leetcode"};
        int []time={5,3,2,2};
        DesignSearchAutoComplete d=new DesignSearchAutoComplete(sen,time);
        System.out.println(d.input('i'));
        System.out.println(d.input(' '));
        System.out.println(d.input('a'));
        System.out.println(d.input('#'));
        System.out.println(d.input('i'));
        System.out.println(d.input(' '));
        System.out.println(d.input('a'));
        System.out.println(d.input('#'));
        System.out.println(d.input('i'));
        System.out.println(d.input(' '));
        System.out.println(d.input('a'));
        System.out.println(d.input('#'));
    }
    Trie trie;
    Map<String,Integer> called;
    class Trie{
        Trie[] dict;
        boolean isEnd=false;
        Trie(){
            dict=new Trie[27];
        }

    }
    public DesignSearchAutoComplete(String[] sentences, int[] times) {
        trie=new Trie();
        called=new HashMap<>();
        sb=new StringBuilder();
        buildString(sentences,times,trie);
        temp=trie;

    }
    void buildString(String[] sentences, int[] times,Trie trie){
        for(int j=0;j<sentences.length;j++){
            String str=sentences[j];
            Trie temp=trie;
            called.put(str,called.getOrDefault(str,0)+times[j]);
            for(int i=0;i<str.length();i++){
                char c=str.charAt(i);
                if(c>='a'&&c<='z'&&temp.dict[c-'a']==null){
                    temp.dict[c-'a']=new Trie();
                    temp=temp.dict[c-'a'];
                }else if(c==' '&&temp.dict[26]==null){
                    int v=26;
                    temp.dict[26]=new Trie();
                    temp=temp.dict[26];
                }else if(c>='a'&&c<='z'&&temp.dict[c-'a']!=null){
                    temp=temp.dict[c-'a'];
                }else if(c==' '&&temp.dict[26]!=null){
                    temp=temp.dict[26];
                }

                if(i==str.length()-1)temp.isEnd=true;
            }
        }
    }
    Trie temp=null;
    StringBuilder sb;
    public List<String> input(char c) {

        List<String> r=new ArrayList<>();
        if(c=='#'){
            temp=trie;
            buildString(new String[]{sb.toString()},new int[]{1},trie);
            sb=new StringBuilder();
            return r;
        }
        if(c>='a'&&c<='z'&&temp.dict[c-'a']==null){
            sb.append(c+"");
            return r;
        }
        if(c>='a'&&c<='z'&&temp.dict[c-'a']!=null){
            temp=temp.dict[c-'a'];
            sb.append(c+"");
        }else if(c==' '){
            temp=temp.dict[26];
            sb.append(c+"");
        }
    //    System.out.println(sb);
        List<String> res=new ArrayList<>();
        getAllStrings(temp,sb,res);
        return getTopWords(res,called);
    }
    class Pair{
        String str;
        int key;
        Pair(String str, int key){
            this.str=str;
            this.key=key;
        }
    }
    public List<String> getTopWords(List<String> res,Map<String,Integer> mp){
        List<String> ans=new ArrayList<>();
        PriorityQueue<Pair> pq=new PriorityQueue<>((a, b)->a.key==b.key?a.str.compareTo(b.str):b.key-a.key);
        for(String s:res){
            if(mp.get(s)!=null){
                int k=mp.get(s);
                pq.offer(new Pair(s,k));
            }
        }
        int c=0;
        while(!pq.isEmpty()&&c<3){
            ans.add(pq.poll().str);
            c++;
        }
        return ans;
    }
    public void getAllStrings(Trie temp, StringBuilder sb,List<String> res){
        if(temp.isEnd){
            res.add(sb.toString());
        }
        for(int i=0;i<27;i++){
            if(temp.dict[i]!=null){
                char c='a';
                if(i<26){
                    c=(char)(c+i);
                }
                else{
                    c=' ';
                }
                sb.append(c+"");
                getAllStrings(temp.dict[i], sb,res);
                sb.deleteCharAt(sb.length()-1);

            }
        }


    }

}
