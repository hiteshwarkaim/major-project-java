
import com.bookstore.dao.DB_Connection;
import com.bookstore.entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class UserTest {
        public static void main(String[] args) {
            List<User> usersList=new ArrayList<>();
        try {
            Connection con=DB_Connection.getConnection();
            String query="select * from users";
            PreparedStatement ps=con.prepareStatement(query);
            
            ResultSet rs = ps.executeQuery();
            
            int id=0;
            String name=null;
            String email=null;
            
            if(rs.next()){
                 User user=new User();
                 
                 user.setId(rs.getInt("user_id"));
                 user.setName(rs.getString("full_name"));
                 user.setEmail(rs.getString("email"));
                 
                 usersList.add(user);
                 
                 
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        for(User u:usersList)
                 {
                     System.out.println(u.getName());
                 }
        
    }
}   
