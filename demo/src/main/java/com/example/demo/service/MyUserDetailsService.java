package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.UserDetails;

@Service
public class MyUserDetailsService {

    public List<UserDetails> getUserDetails (){

        List <UserDetails> list = new ArrayList<>();

        UserDetails details1= new UserDetails("Rahul",23,"Bangalore");
        UserDetails details2= new UserDetails("Ricky",45,"Australia");
        UserDetails details3= new UserDetails("Hugh",33,"USA");

        list.add(details1);
        list.add(details2);
        list.add(details3);
        return list;
    }

    
}
