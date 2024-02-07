package Bo.custom;

import Bo.SuperBo;

import java.sql.SQLException;

public interface RegisterUserBo<T> extends SuperBo {
    boolean registerUser(T dto) throws SQLException, ClassNotFoundException;
}
