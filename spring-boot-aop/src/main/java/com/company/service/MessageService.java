package com.company.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public String msg(String param){
        System.out.println("Method msg verdi , param= "+param);
        return param;
    }
}
