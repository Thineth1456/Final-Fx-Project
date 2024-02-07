package Bo.custom.impl;

import Bo.custom.CreateUserBo;
import dao.custom.CreateUserDao;
import dao.custom.Ipml.CreateUserDaoImpl;
import dto.CreateUserDto;
import entity.CreateUser;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CreateUserBoImpl implements CreateUserBo<CreateUserDto> {
    CreateUserDao createUserDao = new CreateUserDaoImpl();

    @Override
    public boolean saveCreateUser(CreateUserDto dto) throws SQLException, ClassNotFoundException {
        return createUserDao.save(new CreateUser(
                dto.getUserId(),
                dto.getName(),
                dto.getContactNo(),
                dto.getEmail(),
                dto.getPassword()
        ));
    }

    @Override
    public List<CreateUserDto> allUser() throws SQLException, ClassNotFoundException {
        List<CreateUser> entityList = createUserDao.getAll();
        List<CreateUserDto> list = new ArrayList<>();
        for (CreateUser createUser:entityList){
            list.add(new CreateUserDto(
                    createUser.getUserId(),
                    createUser.getName(),
                    createUser.getContactNo(),
                    createUser.getEmail(),
                    createUser.getPassword()
            ));
        }
        System.out.println(list);
        return list;
    }
    public String generateId() throws SQLException, ClassNotFoundException {

            CreateUserDto dto = createUserDao.getLastUser();
            if (dto!=null){
                String id = dto.getUserId();
                int num = Integer.parseInt(id.split("[R]")[1]);
                num++;
                return String.format("UR%03d",num);
            }else{
                return "UR001";
            }


    }

    @Override
    public boolean deleteUser(String id) throws SQLException, ClassNotFoundException {
        return createUserDao.delete(id);
    }

}
