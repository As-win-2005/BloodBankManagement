package BloodBank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {
    Connection c;
    Statement s;
    public conn(){
        try {
            c = DriverManager.getConnection("jdbc:mySql://localhost:3306/Blood", "root", "Ashwin@05");
            s = c.createStatement();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
