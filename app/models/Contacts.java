package models;

import play.db.jpa.*;
import play.data.validation.*;
import javax.persistence.*;
/**
 * contacts model.
 * @author Neeraj
 *
 */
@Entity
@Table(name="contacts")
public class Contacts extends Model {
    
    @Required
    @MaxSize(100)
    public String firstname;
   
    @Required
    @MaxSize(100)
    public String lastname;
    
    @Required
    @MaxSize(100)
    public String email;
    
    @Required
    @MaxSize(10)
//    @Match(value="/^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/", message="Date format is wrong")
    public String dateofbirth;
    
    @MaxSize(10)
    public String mobilephone;
    
    @MaxSize(10)
    public String homephone;
    
    @MaxSize(200)
    public String address; 
    
    @Required
    @ManyToOne
    public User user;
    
    public String toString()  {
        return "Contact(" + firstname + ")" + lastname + dateofbirth;
    }
}
