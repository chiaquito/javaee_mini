package mini.usecase;

import java.util.List;

import javax.management.RuntimeErrorException;

import mini.usecase.input.CompanyCreateInput;
import mini.usecase.input.CompanyInput;
import mini.usecase.output.CompanyOutput;

public interface CompanyUsecase {
    // 会社を一覧表示する
    public List<CompanyOutput> find() throws RuntimeErrorException;
    // 会社の詳細を表示する
    public CompanyOutput getById(CompanyInput input) throws RuntimeErrorException;
    // 会社を登録する
    public void create(CompanyCreateInput input);
}
