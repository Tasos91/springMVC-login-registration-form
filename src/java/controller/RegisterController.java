package controller;

import Helpers.BCrypt;
import dao.UserDao;
import java.io.IOException;
import model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {
    
   
     @Autowired
     private UserDao userDao;
    
   //Registration Controller
     
    @RequestMapping(value="/registrationFormController.htm", method=RequestMethod.GET)
    public String adduser(ModelMap map) throws IOException{
        Users user= new Users();
        map.addAttribute("emptyuser", user);
        return "Form";
    }
    
    @RequestMapping(value="/formhandling.htm", method=RequestMethod.POST)
    public String insertUser(@ModelAttribute("emptyuser") Users u ,ModelMap map) throws IOException{
        Boolean i=userDao.findUser(u);
        Boolean k=userDao.validatePassword(u);
        if((k)&&(!i)){      //gia boolean times mono me auto to tropo tha tis tsekarw mesa se mia if
            String hashed = BCrypt.hashpw(u.getPassword(), BCrypt.gensalt());
            u.setPassword(hashed);
            userDao.addUserToDatabase(u);
            return "Success";
        }
        return "Failure";
    }
    
    
    
   
    
    
}
