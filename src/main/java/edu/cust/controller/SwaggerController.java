package edu.cust.controller;

import edu.cust.bean.Student;
import edu.cust.bean.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ApiOperation("SwaggerController")
public class SwaggerController {

    @GetMapping("/getUser")
    public User getUser(@ApiParam("用户ID") String username) {
        System.out.println(username);
        return new User();
    }

}