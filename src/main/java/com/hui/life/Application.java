package com.hui.life;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@SpringBootApplication
@MapperScan(basePackages = "com.hui.life.db")
public class Application implements CommandLineRunner {
    public static void main(String[] args) {
        ConfigurableApplicationContext appCtx = SpringApplication.run(Application.class, args);
        appCtx.addApplicationListener(new ShutdownListener());
    }

    @Override
    public void run(String... args) throws Exception {
        String msg = """
				\s
				*************************************************************
				                Hui Life started               \s
				*************************************************************
				""";
        log.info(msg);
    }
}