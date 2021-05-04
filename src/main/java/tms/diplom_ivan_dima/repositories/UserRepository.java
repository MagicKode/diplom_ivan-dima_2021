package tms.diplom_ivan_dima.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tms.diplom_ivan_dima.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existUserByUserName(String userName);

    void deleteUserByUserName(String userName);

    User getUserByUserName(String userName);

    User getUserByUserId(long id);
}
