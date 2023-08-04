package Services;

import Reposetories.IReposetory;

import java.util.List;

public interface IService<T> {

    public List<T> getAll();

    public T getObjById(long id);

    public T getObjByMa(String ma);

    public boolean save(T entity);

    public boolean update(T entity);

    public boolean delete(T entity);
}
