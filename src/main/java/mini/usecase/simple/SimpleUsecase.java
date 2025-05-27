package mini.usecase.simple;

import java.util.List;

import javax.management.RuntimeErrorException;

import mini.domain.model.Simple;

public interface SimpleUsecase {
    public List<Simple> get() throws RuntimeErrorException;
}
