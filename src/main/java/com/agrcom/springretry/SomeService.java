package com.agrcom.springretry;

import com.agrcom.springretry.exception.RepositoryException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;

public interface SomeService {

    @Retryable(value = RepositoryException.class, maxAttempts = 3)
    void doSomething(int magicValue) throws RepositoryException;

    @Retryable(value = RuntimeException.class, maxAttempts = 7, backoff = @Backoff(delay = 100))
    void doUncaughtException();

    @Recover
    void recover(RepositoryException e);

    @Recover
    void recoverForRuntimeException(RuntimeException e);
}
