package edu.hit.ninth.controller;

import lombok.extern.slf4j.Slf4j;



import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class Acontroller {
    private static final Logger logger = LoggerFactory.getLogger(Acontroller.class);
    public static void main(String[] args) {
        logger.info("This is an info level log message.");
    }
}
