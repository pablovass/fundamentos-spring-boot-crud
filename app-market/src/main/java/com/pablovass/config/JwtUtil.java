package com.pablovass.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class JwtUtil {
    private static String SECRET_KEY=  "pablovass_key";
    private static Algorithm ALGORITHM = Algorithm.HMAC256(SECRET_KEY);

    private String create(String username){
        return JWT.create()
                .withSubject(username)
                .withIssuer("pablovass-market")
                .withExpiresAt(new Date(System.currentTimeMillis()+ TimeUnit.DAYS.toMillis(15)))
                .sign(ALGORITHM);
    }
}
