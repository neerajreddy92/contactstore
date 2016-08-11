package models;

import play.db.jpa.*;
import play.data.validation.*;
import javax.persistence.*;
/**
 * user model.
 * @author Neeraj
 *
 */
@Entity
@Table(name="user")
public class User extends Model {
    
    @Required
    @MaxSize(10)
    @MinSize(4)
    public String username;
    
    @Required
    @MaxSize(20)
    @MinSize(5)
    public String password;
    
    @Required
    @MaxSize(100)
    public String firstname;
   
    @Required
    @MaxSize(100)
    public String lastname;
    
    @Required
    @MaxSize(100)
    public String email;
    
    
    public User(String firstname,String lastname, String username, String password,String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.username = username;
        this.email = email;
    }

    public String toString()  {
        return "User(" + username + ")";
    }
    
}
