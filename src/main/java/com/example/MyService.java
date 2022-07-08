package com.example;

import javax.inject.Singleton;
import java.util.UUID;

@Singleton
public class MyService {

    public String getProtocol(){
        return UUID.randomUUID().toString();
    }

}
