package Bo.custom.impl;

import Bo.custom.RegisterUserBo;
import dao.custom.CreateUserDao;
import dao.custom.Ipml.CreateUserDaoImpl;
import dao.custom.Ipml.RegisterUserDaoImpl;
import dao.custom.RegisterUserDao;
import dto.RegisterUserDto;
import entity.RegisterUser;

import java.sql.SQLException;

public class RegisterUserBoImpl implements RegisterUserBo<RegisterUserDto>{

    RegisterUserDao registerUserDao = new RegisterUserDaoImpl();



    @Override
    public boolean registerUser(RegisterUserDto dto) throws SQLException, ClassNotFoundException {
        return registerUserDao.save(new RegisterUser(
                dto.getUserId(),
                dto.getName(),
                dto.getContactNo(),
                dto.getEmail(),
                dto.getPassword()
        ));
    }
}
