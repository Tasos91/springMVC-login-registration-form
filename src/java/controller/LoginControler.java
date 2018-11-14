
package controller;

import Helpers.BCrypt;
import dao.UserDao;
import java.io.IOException;
import java.util.List;
import model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginControler {
    
    @Autowired
     private UserDao userDao;
    
    //Login Controller
    @RequestMapping(value="/LoginController.htm", method=RequestMethod.GET)
    public String showLogin(ModelMap map) throws IOException{
        Users user= new Users();
        map.addAttribute("emptyuser", user);
       
        return "Login";
    }
    
    @RequestMapping(value="/succeessfulLogin.htm", method=RequestMethod.POST)
    public String doLogin(@ModelAttribute("emptyuser") Users u ,ModelMap map) throws IOException{
        
        String username=userDao.userUsernameThatExistInDatabase(u);
        String hashed=userDao.userHashedPasswordThatExistInDatabase(u);
        
        if(username!=null&&hashed!=null){
            String formpassword=u.getPassword();
            if(BCrypt.checkpw(formpassword, hashed)){
                List<Users> myusers=userDao.selectAllUsers();
                map.addAttribute("users",myusers);
                return "LoginDatabase";
            }
            else{
                return "FailureLogin";
            }
        
        }
        return "FailureLogin";
    }
        
        
    }

