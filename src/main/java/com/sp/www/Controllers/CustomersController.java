
package com.sp.www.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sp.www.Beans.Customers;
import com.sp.www.Services.CustomersService;

@RestController
public class CustomersController {

    @Autowired
    private CustomersService customersService;

    @GetMapping("/getAllCustomers")
    public List<Customers> getAllCustomers() {
        return customersService.getAllCustomers();
    }

    @GetMapping("/getCustomerById/{id}")
    public Customers getCustomerById(@PathVariable Integer id) {
        return customersService.getCustomerById(id);
    }

    @GetMapping("/getCustomerByName/{name}")
    public Customers getCustomerByName(@PathVariable String name) {
        return customersService.getCustomerByName(name);
    }

    @PostMapping("/addCustomer")
    public Customers addCustomer(@RequestBody Customers customer) {
        return customersService.addCustomer(customer);
    }

    @PutMapping("/updateCustomer")
    public Customers updateCustomer(@RequestBody Customers customer) {
        return customersService.updateCustomer(customer);
    }

    @DeleteMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable Integer id) {
        customersService.deleteCustomer(id);
        return "Customer deleted successfully";
    }
}
