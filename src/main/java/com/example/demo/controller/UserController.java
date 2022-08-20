package com.example.demo.controller;

import com.example.demo.constant.TodoPagesConstant;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Objects;

@Controller
@RequestMapping( "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;


    @GetMapping("/register")
    public String register() {
        return TodoPagesConstant.REGISTER;
    }

    @GetMapping("/login")
    public String login() {
        return TodoPagesConstant.LOGIN;
    }

    //    yeni üye olma servisi
    @PostMapping("/addRegister")
    public ResponseEntity<String> addRegister(@Valid @RequestBody User user) {

        if (BooleanUtils.isTrue(Objects.equals(user.getPass(), user.getPass2()))) {
            final String rawPassword = user.getPass();
            final String encodedPassword = bCryptPasswordEncoder.encode(rawPassword);
            user.setPass(encodedPassword);
            user.setPass2(encodedPassword);
            User createdUser = userService.createUser(user);

            try {
                final Authentication authentication = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                user.getUsername(),
                                rawPassword
                        )
                );

                SecurityContextHolder.getContext().setAuthentication(authentication);
                return new ResponseEntity<>("OK", HttpStatus.CREATED);

            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
            }
        }
        return new ResponseEntity<>("ERROR", HttpStatus.OK);

    }

    //spring security kontrolü yapıyor.
    //login user-password kontrolü
    @PostMapping("/controlLogin")
    public ResponseEntity<String> controlLogin(@RequestBody User user,HttpServletRequest request){
        final String rawPassword = user.getPass();
        final String encodedPassword = bCryptPasswordEncoder.encode(rawPassword);
        User loginUser = userService.getFindUsernameAndPass(user.getUsername(), encodedPassword);
        if (loginUser!=null){
            final Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            user.getUsername(),
                            user.getPass()
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return new ResponseEntity<>("OK", HttpStatus.OK);
        }
        return new ResponseEntity<>("ERROR", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/logout")
    public String logOut(HttpServletRequest request, final HttpServletResponse response){
        request.getSession().removeAttribute("userId");

        return TodoPagesConstant.LOGIN;
    }

    @PostMapping("/checkUsername")
    public ResponseEntity<String> checkUsername(@RequestBody User user){
        User foundUser=userService.getFindUsername(user.getUsername());
        if (foundUser!=null){
            return new ResponseEntity<>("OK", HttpStatus.OK);
        }
        return new ResponseEntity<>("ERROR", HttpStatus.OK);
    }

}

