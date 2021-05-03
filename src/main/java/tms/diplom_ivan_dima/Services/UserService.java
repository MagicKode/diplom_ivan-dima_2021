package tms.diplom_ivan_dima.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tms.diplom_ivan_dima.Model.User;
import tms.diplom_ivan_dima.Repositories.UserRepository;
import tms.diplom_ivan_dima.exceptions.UserNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(User user) {  //добавление Юзера
        userRepository.save(user);
    }

    public void deleteUserByUserName(String userName) { //удаление Юзера по имени
        User user = getUserByUserName(userName);
        if (user.getUserName().equals(userName)) {
            userRepository.deleteUserByUserName(userName);
        } else {
            throw new UserNotFoundException("User is not found! Please, check userName!");
        }
    }

    public void deleteUserById(long id) { //удаление юзера по ID
        User user = getUserById(id);
        if (getUserById(id).equals(user)) {
            userRepository.deleteById(id);
        } else {
            throw new UserNotFoundException("User is not found! Please, check userID!")
        }
    }

    public boolean isUserExistByUserName(String userName) { //проверка о наличии юзера по Имени
        User user = getUserByUserName(userName);
        if (getUserByUserName(userName).equals(user)) {
            return userRepository.existUserByUserName(userName);
        } else {
            throw new UserNotFoundException("User is not found!");
        }
    }

    public boolean isUserExistById(long id) { // проверка на наличие юзера по ID
        User user = getUserByUserId(id);
        if (getUserByUserId(id).equals(user)) {
            return userRepository.existsById(id);
        } else {
            throw new UserNotFoundException("User not found!  Chec userID!");
        }
    }

    public User getUserByUserName(String userName) { // найти Юзера по имени
        if (userRepository.getUserByUserName(userName) == null) {
            throw new UserNotFoundException("User not found");
        } else {
            return userRepository.getUserByUserName(userName);
        }
    }

    public User getUserById(long id) {
        if (userRepository.getUserById(id) == null) {
            throw new UserNotFoundException("User is not found");
        } else {
            return userRepository.getOne(id);
        }
    }

    public void updateUserPasswordByUsername(String username, String newPassword) {
        User user = getUserByUserName(username);
        if (getUserByUserName(username).equals(user)) {
            userRepository.getUserByUsername(username).setPassword(newPassword);
        } else {
            throw new UserNotFoundException("User is not found");
        }
    }

    public void updateUserPasswordById(long id, String newPassword) {
        User user = getUserById(id);
        if (getUserById(id).equals(user)) {
            userRepository.getUserById(id).setPassword(newPassword);
        } else {
            throw new UserNotFoundException("User is not found");
        }
    }

    public void updateUserNameByUsername(String username, String newUsername) {
        User user = getUserByUserName(username);
        if (getUserByUserName(username).equals(user)) {
            userRepository.getUserByUsername(username).setUsername(newUsername);
        } else {
            throw new UserNotFoundException("User is not found");
        }
    }

    public void updateUserNameById(long id, String newUsername) {
        User user = getUserById(id);
        if (getUserById(id).equals(user)) {
            userRepository.getUserById(id).setUsername(newUsername);
        } else {
            throw new UserNotFoundException("User is not found");
        }
    }

    public boolean isPasswordCorrect(String username, String password) {
        return getUserByUserName(username).getPassword().equals(password);
    }

}
