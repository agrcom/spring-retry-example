package com.agrcom.springretry;

import com.agrcom.springretry.exception.RepositoryException;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ExampleService implements SomeService {

    @Getter
    private int counterRepositoryException;
    @Getter
    private int counterRuntimeException;

    public void doSomething(int magicValue) throws RepositoryException {
        log.info("doSomething has been called");
        if (magicValue < 42) {
            counterRepositoryException++;
            throw new RepositoryException("Magic Value is different than i expected!");
        }
    }

    @Override
    public void doUncaughtException() {
        log.info("Request has been called");
        counterRuntimeException++;
        throw new RuntimeException("request method thrown exception");
    }

    @Override
    public void recover(RepositoryException e) {
        log.info("Recover for RepositoryException has been called");
    }

    @Override
    public void recoverForRuntimeException(RuntimeException e) {
        log.info("Recover for RuntimeException has been called");
    }

}
