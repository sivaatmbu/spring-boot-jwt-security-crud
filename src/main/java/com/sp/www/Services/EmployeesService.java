
package com.sp.www.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sp.www.Beans.Employees;
import com.sp.www.Repositories.EmployeesRepo;

@Service
public class EmployeesService {

    @Autowired
    private EmployeesRepo employeesRepo;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JWTService jwtService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public Employees register(Employees emp) {
        emp.setPassword(encoder.encode(emp.getPassword()));
        return employeesRepo.save(emp);
    }

    public String verify(Employees emp) {
        try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            emp.getName(), emp.getPassword()));

            if (authentication.isAuthenticated()) {
                return jwtService.generateToken(emp.getName());
            }

            return "Authentication Failed";

        } catch (AuthenticationException e) {
            return "Authentication Failed";
        }
    }
}
