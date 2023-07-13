package com.practical.practical_bulletin_board_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class PracticalBulletinBoardProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticalBulletinBoardProjectApplication.class, args);
    }

}
