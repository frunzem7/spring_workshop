package com.example.spring_workshop.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SpringWorkShopUtilsIT {

    public static String createURLWithPort(String url, int port) {
        return "http://localhost:" + port + url;
    }
}
