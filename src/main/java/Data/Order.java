/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author Obaydah Mohamad
 */
public class Order {
    private int id;
    private int height;
    private int width;
    private int length;
    private String datePlaced;
    private String dateShipped;
    private House house;

    public Order(int id, int height, int width, int length, String datePlaced, String dateShipped) {
        this.id = id;
        this.height = height;
        this.width = width;
        this.length = length;
        this.datePlaced = datePlaced;
        this.dateShipped = dateShipped;
    }    
    
    public Order(int id, int height, int width, int length, String datePlaced, String dateShipped, House house) {
        this.id = id;
        this.height = height;
        this.width = width;
        this.length = length;
        this.datePlaced = datePlaced;
        this.dateShipped = dateShipped;
        this.house = house;
    }

    public int getId() {
        return id;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public String getDatePlaced() {
        return datePlaced;
    }

    public String getDateShipped() {
        return dateShipped;
    }

    public House getHouse() {
        return house;
    }
    
    

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", height=" + height + ", width=" + width + ", length=" + length + ", datePlaced=" + datePlaced + ", dateShipped=" + dateShipped + '}';
    }
    
    
}
