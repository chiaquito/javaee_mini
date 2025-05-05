package mini.usecase;

import javax.management.RuntimeErrorException;

public interface SimpleUsecase {
    public String get() throws RuntimeErrorException;
}
