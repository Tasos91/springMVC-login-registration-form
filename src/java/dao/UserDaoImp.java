package dao;

import Helpers.BCrypt;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Users;
import org.apache.tomcat.jni.User;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImp implements UserDao{
    
    @PersistenceContext
    private EntityManager em;
    
    @Transactional 
     public Boolean findUser(Users user){
         Boolean i=true;
         String formUsername=user.getUsername();
         Users user1 = em.find(Users.class, formUsername);
         if(user1 == null){
             i=false;
         }
         else{
             i=true;
         }
         return i;
     }
     
     @Transactional
     public void addUserToDatabase(Users user){
        //em.getTransaction().begin();
        em.persist(user);
     }
     
     public Boolean validatePassword(Users user){
        Boolean i = false;
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        if(user.getPassword().equals(user.getPassword_confirm())){
            i=true;
        }
        return i;
     }
     
     public String userHashedPasswordThatExistInDatabase(Users user){
         
         String formUsername=user.getUsername();
         Users user1 = em.find(Users.class, formUsername);
         String hashed=null;
           if(user1 == null){
             hashed=null;
         }
         else{
          hashed=user1.getPassword();
         }
         return hashed;
     }
     
     public String userUsernameThatExistInDatabase(Users user){
         
         String formUsername=user.getUsername();
         Users user1 = em.find(Users.class, formUsername);
           String username=null;
         if(user1 == null){
             username=null;
         }
         else{
          username=user1.getUsername();
         }
          
         
         return username;
     }
     
     public List selectAllUsers(){
       
         Query q=em.createNativeQuery("SELECT * FROM users" );
         List<Users> users = q.getResultList();
         
         
         return users;
     }
     
}
