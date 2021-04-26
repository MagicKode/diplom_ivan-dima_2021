package tms.diplom_ivan_dima.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tms.diplom_ivan_dima.Model.User;
import tms.diplom_ivan_dima.Repositories.UserRepository;
import tms.diplom_ivan_dima.exceprions.UserNotFoundException;

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
        if (getUserById(id).equals(user)){
            userRepository.deleteById(id);
        }else {
            throw new UserNotFoundException("User is not found! Please, check userID!")
        }
    }

    public boolean isUserExistByUserName(String userName){ //проверка о наличии юзера по Имени
        User user = getUserByUserName(userName);
        if (getUserByUserName(userName).equals(user)){
            return userRepository.existUserByUserName(userName);
        }else {
            throw new UserNotFoundException("User is not found!");
        }
    }

    public boolean isUserExistById(long id){ // проверка на наличие юзера по ID
        User user = getUserByUserId(id);
        if (getUserByUserId(id).equals(user)){
            return userRepository.existsById(id);
        }else {
            throw new UserNotFoundException("User not found!  Chec userID!");
        }
    }

    public User getUserByUserName(String userName){ // найти Юзера по имени
        if (userRepository.getUserByUserName(userName)==null){
            throw new UserNotFoundException("User not found");
        }else {
            return userRepository.getUserByUserName(userName);
        }
    }

}
