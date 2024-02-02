package Bo.custom;

import Bo.SuperBo;

public interface CreateUserBo<T> extends SuperBo {
    boolean saveCreateUser(T dto);
}
