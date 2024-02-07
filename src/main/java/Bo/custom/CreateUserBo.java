package Bo.custom;

import Bo.SuperBo;
import dao.custom.CreateUserDao;
import dto.CreateUserDto;

import java.sql.SQLException;
import java.util.List;

public interface CreateUserBo<T> extends SuperBo {
    boolean saveCreateUser(T dto) throws SQLException, ClassNotFoundException;
    List<CreateUserDto> allUser() throws SQLException, ClassNotFoundException;
    String generateId() throws SQLException, ClassNotFoundException;
    boolean deleteUser(String id) throws SQLException, ClassNotFoundException;
}
