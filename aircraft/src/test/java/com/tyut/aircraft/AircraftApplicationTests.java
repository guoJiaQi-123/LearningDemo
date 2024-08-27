package com.tyut.aircraft;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class AircraftApplicationTests {

    @Autowired
    BCryptPasswordEncoder encoder;

    @Test
    void contextLoads() {
        String encode = encoder.encode("root");
        System.out.println(encode);
        boolean matches = encoder.matches("root", "$2a$10$ILM2UH6uDucnsTahOUcbR.o1Nk.AdwUulsRu4lwLRSpQVVCCgW7Wy");
        System.out.println(matches);
    }

}
