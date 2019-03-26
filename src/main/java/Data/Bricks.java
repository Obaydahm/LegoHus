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
public class Bricks {
    private int four;
    private int two;
    private int one;

    public Bricks(int four, int two, int one) {
        this.four = four;
        this.two = two;
        this.one = one;
    }
    
    

    public int getFour() {
        return four;
    }

    public int getTwo() {
        return two;
    }

    public int getOne() {
        return one;
    }
    
    public void addBricks(int four, int two, int one){
        this.four = four;
        this.two = two;
        this.one = one;
    }

    @Override
    public String toString() {
        return "Bricks{" + "four=" + four + ", two=" + two + ", one=" + one + '}';
    }
    
    
}
