package resturaunt;

import java.sql.Timestamp;

 public class mealsInfo {
    private int id;
    private String meal_title;
    private String descreption;
    private float price;
    private float meal_price;
    private float total_price;
    private Timestamp order_time;
    
    public mealsInfo (int id, String meal_title, String descreption, float price) {
        this.id = id;
        this.meal_title = meal_title;
        this.descreption = descreption;
        this.price = price;
    }
    
    public mealsInfo(String meal_title, String descreption, float meal_price, float total_bill, Timestamp order_time ){
             this.meal_title = meal_title;
             this.descreption = descreption;
             this.meal_price = meal_price;
             this.total_price = total_bill;
             this.order_time = order_time;
    }
    
    public int getid() {
        return id;
    }
    
    public String getmeal() {
        return meal_title;
    }
    
    public String getdescription() {
        return descreption;
    }
    
    public float getprice() {
        return price;
    }
    
    public String getMealTitle() {
        return meal_title;
    }
    
    public String getDescreption() {
        return descreption;
    }
    
    public float getMealPrice() {
        return meal_price;
    }
    
    public float getTotalBill() {
        return total_price;
    }
    
    public Timestamp getOrderTime() {
        return order_time;
    }
}