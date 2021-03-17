package resturaunt;

import java.sql.Timestamp;
import java.time.LocalTime;

public class ordersInfo {
    private int id;
    private String meal_title;
    private int customer_id;
    private float total_bill;
    private Timestamp order_time;
    
    public ordersInfo(int id, String meal_title, int customer_id, float total_bill, Timestamp order_time ) {
        this.id = id;
        
        this.meal_title = meal_title;
        this.customer_id = customer_id;
        this.total_bill = total_bill;
        this.order_time = order_time;
    }
    public int getid() {
        return id;
    }
    
    public String getmealtitle() {
        return meal_title;
    }    
    
    public int getcustomerid() {
        return customer_id;
    }
    
    public float gettotalbill() {
        return total_bill;
    }
    
    public Timestamp order_time() {
        return order_time;
    }
}