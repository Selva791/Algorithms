package com.revision;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.function.BiConsumer;


public class Solution {

  class Point {
    int x,y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  void solve() throws IOException {
    int t = nextInt();
    for (int testCase=0;testCase<t;testCase++) {
      int r=nextInt();
      int c=nextInt();
      boolean[][] visited = new boolean[r][c];
      int[][] ans=new int[r][c];
      int[][] ways = new int[r][c];
      for (int i=0;i<r;i++){
        for (int j=0;j<c;j++) {
          for (int i1=0;i1<r;i1++){
            for (int j1=0;j1<c;j1++) {
              if (check(i,j,i1,j1))ways[i][j]++;
            }
          }
        }
      }
      BiConsumer<Point, Integer> go = (start, inc) -> {
        Point current = start;
        int val = 1;
        while (true) {
          Point next = null;
          int curWays = -1;
          for (int i=0;i<r;i++) {
            for (int j=0;j<c;j++) {
              if (check(current.x, current.y, i, j) && !visited[i][j]) {
                if (curWays == -1 || curWays > ways[i][j]) {
                  next=new Point(i,j);
                  curWays=ways[i][j];
                }
              }
            }
          }
          if (next==null) {
            break;
          }
          visited[next.x][next.y]=true;
          val+=inc;
          ans[next.x][next.y]=val;
          current=next;
          for (int i=0;i<r;i++) {
            for (int j=0;j<c;j++) {
              if (check(next.x, next.y, i, j)) {
                ways[i][j]--;
              }
            }
          }
        }
      };
      visited[0][0]=true;
      ans[0][0]=1;
      for (int i=0;i<r;i++) {
        for (int j=0;j<c;j++) {
          if (check(0, 0, i, j)) {
            ways[i][j]--;
          }
        }
      }
      go.accept(new Point(0, 0), 1);
      go.accept(new Point(0, 0), -1);

      TreeMap<Integer, Point> resMap = new TreeMap<>();
      for (int i =0;i<r;i++){
        for (int j=0;j<c;j++) {
          if (visited[i][j]){
            resMap.put(ans[i][j], new Point (i, j));
          }
        }
      }
      if (resMap.size() == c*r) {
        out.printf("Case #%d: POSSIBLE\n", testCase + 1);
        resMap.forEach((key, point) -> out.println((point.x + 1) + " " + (point.y + 1)));
      } else {
        out.printf("Case #%d: IMPOSSIBLE\n", testCase + 1);
      }
      out.flush();
    }
  }

  boolean check(int x, int y, int x1, int y1) {
    return x!=x1 && y!=y1 && x-y != x1-y1 && x+y != x1+y1;
  }

  public static void main(String[] args) throws IOException {
    new Solution().run();
  }

  void run() throws IOException {
    reader = new BufferedReader(new InputStreamReader(System.in));
//		reader = new BufferedReader(new FileReader("input.txt"));
    tokenizer = null;
    out = new PrintWriter(new OutputStreamWriter(System.out));
//		out = new PrintWriter(new FileWriter("output.txt"));
    solve();
    reader.close();
    out.flush();

  }

  BufferedReader reader;
  StringTokenizer tokenizer;
  PrintWriter out;

  int nextInt() throws IOException {
    return Integer.parseInt(nextToken());
  }

  long nextLong() throws IOException {
    return Long.parseLong(nextToken());
  }

  double nextDouble() throws IOException {
    return Double.parseDouble(nextToken());
  }

  String nextToken() throws IOException {
    while (tokenizer == null || !tokenizer.hasMoreTokens()) {
      tokenizer = new StringTokenizer(reader.readLine());
    }
    return tokenizer.nextToken();
  }
}