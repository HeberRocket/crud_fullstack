package com.icodeapp.crudfullstack.crud_fullstack_angular.service;

import com.icodeapp.crudfullstack.crud_fullstack_angular.entity.Customer;
import com.icodeapp.crudfullstack.crud_fullstack_angular.exception.ResourceNotFoundException;
import com.icodeapp.crudfullstack.crud_fullstack_angular.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CostumerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    public CostumerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Integer id) {
        Customer customer = customerRepository.findById(id).orElseThrow(
                () -> {
                    throw new ResourceNotFoundException("Customer con id: "+id+" no fue encontrado.");
                }
        );
        //return customerRepository.findById(id).get();
        return customer;
    }

    @Override
    public void deleteById(Integer id) {
        customerRepository.deleteById(id);

    }

    @Override
    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }
}
