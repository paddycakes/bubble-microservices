package com.bubble.knowledge.query.web;

import org.springframework.beans.factory.annotation.Value;

public class AbstractQueryControllerTests {

    @Value("${local.server.port}")
    int port;

    String getUrl(String path) {
        return "http://localhost:" + this.port + path;
    }

}
