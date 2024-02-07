package dao.custom.Ipml;

import dao.custom.RegisterUserDao;
import dao.util.HibernateUtil;
import entity.CreateUser;
import entity.RegisterUser;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;

public class RegisterUserDaoImpl implements RegisterUserDao {


    @Override
    public boolean save(RegisterUser entity) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();

        return true;
    }
}
