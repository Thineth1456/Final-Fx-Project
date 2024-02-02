package dao;

public interface CrudDao<T> extends SuperDao {
    boolean save(T entity);

}
