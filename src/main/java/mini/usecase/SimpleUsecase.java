package mini.usecase;

import java.util.List;

import javax.management.RuntimeErrorException;

import mini.usecase.input.SimpleInput;
import mini.usecase.output.SimpleOutput;

public interface SimpleUsecase {
    public List<SimpleOutput> find() throws RuntimeErrorException;
    public SimpleOutput getById(SimpleInput input) throws RuntimeErrorException;
}
