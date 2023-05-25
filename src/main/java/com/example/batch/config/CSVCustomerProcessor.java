package com.example.batch.config;

import com.example.batch.model.CSVCustomer;
import com.example.batch.model.Customer;
import org.springframework.batch.item.ItemProcessor;

public class CSVCustomerProcessor implements ItemProcessor<CSVCustomer, Customer> {
    @Override
    public Customer process(CSVCustomer csvCustomer) throws Exception {

        String fullName = csvCustomer.getFullName();
        if (fullName.equals("abcd")) {
            return null;
        }
        String[] s = fullName.split(" ");
        return new Customer(csvCustomer.getId(), s[0], s[1]);
    }
}
