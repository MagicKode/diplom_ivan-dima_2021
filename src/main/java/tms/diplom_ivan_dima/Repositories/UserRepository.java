package tms.diplom_ivan_dima.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tms.diplom_ivan_dima.Model.User;

public interface UserRepository extends JpaRepository<User,Long> {

    boolean existUserByUserName(String userName);
    void deleteUserByUserName(String userName);
    User getUserByUserName(String userName);
    User getUserByUserId(long id);
}
