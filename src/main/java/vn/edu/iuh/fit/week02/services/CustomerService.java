package vn.edu.iuh.fit.week02.services;

import vn.edu.iuh.fit.week02.models.Customer;
import vn.edu.iuh.fit.week02.repositories.CustomerRepository;

import java.util.List;

public class CustomerService {
    private CustomerRepository customerRepository;
    public  CustomerService()
    {
        customerRepository=new CustomerRepository();
    }
    public List<Customer> getAllCustomer()
    {
        return customerRepository.getAll();
    }
    public Customer getCustomerById(long id)
    {
        return customerRepository.get(id);
    }
    public boolean addCustomer(Customer customer)
    {
        return customerRepository.add(customer);
    }
    public boolean updateCustomer(Customer customer)
    {
        return customerRepository.update(customer);
    }
    public boolean deleteCustomer(long id)
    {
        return customerRepository.delete(id);
    }
}
