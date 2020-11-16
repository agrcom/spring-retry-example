package com.agrcom.springretry;

import com.agrcom.springretry.exception.RepositoryException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ExampleServiceTest {

    @Autowired
    private ExampleService service;

    @Test
    void doSomething() throws RepositoryException {
        service.doSomething(1);
        assert service.getCounterRepositoryException() == 3;
    }

    @Test
    void doUncaughtException() {
        service.doUncaughtException();
        assert service.getCounterRuntimeException() == 7;
    }
}