package com.business.ventas.controller;

import com.business.ventas.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/v1")
public class UserController {


    @RequestMapping(value = "/user", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<User>> getDoctor() {

        List<User> usuarios = new ArrayList<User>(){{
            add(new User(){{setId(1); setUsername("jose"); setPassword("123456"); setEnable(1);}});
            add(new User(){{setId(2); setUsername("daniel"); setPassword("12345"); setEnable(1);}});
            add(new User(){{setId(3); setUsername("marcial"); setPassword("123456"); setEnable(1);}});
        }};

        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

}
