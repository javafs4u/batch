package com.example.batch.config;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class Reader implements ItemReader<String> {

    private int MAX = 100;
    private int count = 0;

    private final String prefix;

    public Reader(String prefix) {
        this.prefix=prefix;
    }

    @Override
    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if (count < MAX) {
            return prefix + count++;
        } else {
            count = 0;
        }
        return null;
    }
}
