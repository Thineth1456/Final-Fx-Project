package dao.custom;

import dao.CrudDao;
import dto.CreateUserDto;
import entity.CreateUser;

import java.sql.SQLException;
import java.util.List;

public interface CreateUserDao extends CrudDao<CreateUser> {

    CreateUserDto getLastUser();
    boolean delete(String value) throws SQLException, ClassNotFoundException;

    List<CreateUser> getAll() throws SQLException, ClassNotFoundException;
}
