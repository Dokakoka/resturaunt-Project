package resturaunt;

public class reportInfo {
    private int id;
    private String username;
    private String email;
   
    
    public reportInfo(int id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
        
    }
        
    public int getid() {
        return id;
    }
    
    public String getusername() {
        return username;
    }
    
    public String getemail() {
        return email;
    }
}
