package com.example.batch.config;

import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class Writer implements ItemWriter<String> {
    @Override
    public void write(List<? extends String> list) throws Exception {
            for(String s: list) {
                System.out.println(s);
            }
    }
}
