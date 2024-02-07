package dao.custom.Ipml;

import dao.custom.CreateUserDao;
import dao.util.HibernateUtil;
import dto.CreateUserDto;
import entity.CreateUser;
import entity.RegisterUser;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class CreateUserDaoImpl implements CreateUserDao {

    @Override
    public boolean save(CreateUser entity)throws SQLException, ClassNotFoundException {


        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();

        return true;

    }

    @Override
    public CreateUserDto getLastUser() {
        Session session = HibernateUtil.getSession();
        Query query1 = session.createQuery("FROM CreateUser o ORDER BY o.userId asc");
        Query query2 = session.createQuery("FROM RegisterUser o ORDER BY o.userId asc");
        int siZe1 = query1.list().size()-1;
        int siZe2 = query2.list().size()-1;
        if (siZe1 >=0) {

            CreateUser createUser = (CreateUser) query1.list().get(siZe1);
            CreateUserDto createUserDto = new CreateUserDto(
                    createUser.getUserId(),
                    createUser.getName(),
                    createUser.getContactNo(),
                    createUser.getEmail(),
                    createUser.getPassword());
            session.close();
            return createUserDto;
        } else if (siZe2<0) {
         return null;
        }
        RegisterUser createUser = (RegisterUser) query2.list().get(siZe2);
            CreateUserDto createUserDto = new CreateUserDto(
                    createUser.getUserId(),
                    createUser.getName(),
                    createUser.getContactNo(),
                    createUser.getEmail(),
                    createUser.getPassword());
            session.close();
            return createUserDto;
    }

    public List<CreateUser> getAll() throws SQLException , ClassNotFoundException {


        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("from CreateUser");
        List<CreateUser> list = query.list();
        session.close();
        return list;
    }

    public boolean delete(String value) throws SQLException, ClassNotFoundException {

        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(session.find(CreateUser.class,value));
        transaction.commit();
        session.close();
        return true;
    }
}
