package resturaunt;

public class employeeInfos {
    private int id;
    private String username;
    private String password;
    private int roll_id;
   
    
    public employeeInfos(int id, String username, String password, int roll_id ) {
        this.id = id;
        this.roll_id = roll_id;
        this.username = username;
        this.password = password;
        
    }
        
    public int getid() {
        return id;
    }
    
    public int getrollid() {
        return roll_id;
    }
    
    public String getusername() {
        return username;
    }
    
    public String getpassword() {
        return password;
    }   
}