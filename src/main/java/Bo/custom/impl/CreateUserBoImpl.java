package Bo.custom.impl;

import Bo.custom.CreateUserBo;
import dao.custom.CreateUserDao;
import dao.custom.Ipml.CreateUserDaoImpl;
import dto.CreateUserDto;
import entity.CreateUser;

public class CreateUserBoImpl implements CreateUserBo<CreateUserDto> {
    CreateUserDao createUserDao = new CreateUserDaoImpl();

    @Override
    public boolean saveCreateUser(CreateUserDto dto) {
        return createUserDao.save(new CreateUser(
                dto.getUserId(),
                dto.getName(),
                dto.getContactNo(),
                dto.getEmail(),
                dto.getPassword()
        ));
    }
}
