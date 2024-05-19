package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class MultiThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<List<String>> urls= CompletableFuture.supplyAsync(()->{
            List<String> r= new ArrayList<String>();
            return r;
        }).whenComplete((objects, throwable)->{
            if(throwable!=null){
                throw new RuntimeException("");
            }
        });
        urls.get();
    }
}
