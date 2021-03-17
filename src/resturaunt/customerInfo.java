package resturaunt;

import java.sql.Timestamp;

public class customerInfo {
    private int id;
    private String customer_name;
    private String customerType;
    private int numberOfOrders;
    private String meal_title;
    private float total_bill;
    private int roll_id;
    private float money;
    private String username;
    private String password;
    private Timestamp reward_time;
    private float reward_amount;
    
    public customerInfo(int id, String customer_name, int numberOfOrders ) {
        this.id = id;
        this.customer_name = customer_name;
        this.customerType = customerType;
        this.numberOfOrders = numberOfOrders;
        
    }
    
    public customerInfo( int id, String customer_name, String customer_password, int number_of_orders, float money, String customer_type ) {
        
        this.id = id;
        this.customer_name = customer_name;
        this.customerType = customer_type;
        this.numberOfOrders = number_of_orders;
        this.money = money;
        this.password = customer_password;
        
    }
    
    public customerInfo(int id, String username, String password, int roll_id ) {
        this.id = id;
        this.roll_id = roll_id;
        this.username = username;
        this.password = password;
        
    }
    
    public customerInfo( int id, float reward_amount, Timestamp reward_time) {
        this.id = id;
        this.reward_amount = reward_amount;
        this.reward_time = reward_time;
    }
    
    public customerInfo(int id, String customer_name, int numberOfOrders, String meal_title, float total_bill) {
        this.id = id;
        this.customer_name = customer_name;
        this.numberOfOrders = numberOfOrders;
        this.meal_title = meal_title;
        this.total_bill = total_bill;
        
    }
    
    public int getid() {
        return id;
    }
    
    public String getCustomerName() {
        return customer_name;
    }
    
    public int getrollid() {
        return roll_id;
    }
    
    public float getmoney() {
        return money;
    }
    
    public String getusername() {
        return username;
    }
    
    public String getpassword() {
        return password;
    }
    
    public String getCustomerType() {
        return customerType;
    }
    
    public int getNumberOfOrders() {
        return numberOfOrders;
    }
    
    public String getMealTitle() {
        return meal_title;
    }
    
    public float getTotalBill() {
        return total_bill;
    }
    
    public float getRewardAmount() {
        return reward_amount;
    }
    
    public Timestamp getreward_time() {
        return reward_time;
    }
}