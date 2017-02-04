package com.github.joraclista;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;

/**
 * Created by Alisa
 * version 1.0.
 */
@Slf4j
public class Task {

    @SneakyThrows(InterruptedException.class)
    public void performDuring(Duration duration) {
        log.info("Starting performing complex task with duration = {}", duration);
        Thread.sleep(duration.toMillis());
        log.info("Finished performing complex task");
    }
}
