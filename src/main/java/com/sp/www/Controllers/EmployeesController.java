
package com.sp.www.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sp.www.Beans.Employees;
import com.sp.www.Services.EmployeesService;

@RestController
public class EmployeesController {

    @Autowired
    private EmployeesService empService;

    @PostMapping("/register")
    public Employees register(@RequestBody Employees emp) {
        return empService.register(emp);
    }

    @PostMapping("/login")
    public String login(@RequestBody Employees emp) {
        return empService.verify(emp);
    }
}
