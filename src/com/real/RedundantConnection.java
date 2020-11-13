package com.real;
// disjoint or union find and path compression
public class RedundantConnection {
public static void main(String[] args) {
	RedundantConnection r=new RedundantConnection();
	//[[1,5],[3,4],[3,5],[4,5],[2,4]]
	int ed[][]= {{1,5}, {3,4}, {3,5},{4,5},{2,4}};
	int s[]=r.findRedundantConnection(ed);
	System.out.println(s);
	
}
public int[] findRedundantConnection(int[][] edges) {
    int parent[]=new int[10];
    for(int i=0;i<10;i++){
        parent[i]=i;
        
    }
    for(int a[]:edges){
        int p1=findSet(parent,a[0]);
        int p2=findSet(parent,a[1]);
    if(p1==p2) return a;
        
      union(parent ,a[0],a[1]);  
    }
    return new int[]{};
}
public void union(int p[],int a,int b){
    a=findSet(p,a);
    b=findSet(p,b);
    
    p[b]=a;
    
}
public int findSet(int p[],int a){
    while(p[a]!=a){
      a=p[a];
    }
    return a;
}
}
