package com.hui.life;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

@Slf4j
public class ShutdownListener implements ApplicationListener<ContextClosedEvent> {
    @SneakyThrows
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        String msg = """

                ******************************************************************
                            Hui Life is shutting down. Bye!            \s
                ******************************************************************
                """;
        log.info(msg);
    }
}
