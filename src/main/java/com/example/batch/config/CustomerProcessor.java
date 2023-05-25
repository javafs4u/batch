package com.example.batch.config;

import com.example.batch.model.Customer;
import org.springframework.batch.item.ItemProcessor;

public class CustomerProcessor  implements ItemProcessor<Customer, Customer> {
    @Override
    public Customer process(Customer customer) throws Exception {
        System.out.println(customer);
        return customer;
    }
}
