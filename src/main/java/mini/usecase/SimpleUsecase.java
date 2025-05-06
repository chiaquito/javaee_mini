package mini.usecase;

import java.util.List;

import javax.management.RuntimeErrorException;

import mini.model.Simple;

public interface SimpleUsecase {
    public List<Simple> get() throws RuntimeErrorException;
}
