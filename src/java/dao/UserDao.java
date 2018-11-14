package dao;

import java.util.List;
import model.Users;



public interface UserDao {
    
    public Boolean findUser(Users user);
    
    public void addUserToDatabase(Users user);
    
    public Boolean validatePassword(Users user);
    
    public String userHashedPasswordThatExistInDatabase(Users user);
    
    public String userUsernameThatExistInDatabase(Users user);
    
    public List selectAllUsers();

}
