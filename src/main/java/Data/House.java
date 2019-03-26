/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.HashMap;

/**
 *
 * @author Obaydah Mohamad
 */
public class House {
    private HashMap<String, Integer> SideW;
    private HashMap<String, Integer> sideL;
    private int height;
    private Bricks allBricks;
    
    public House(HashMap<String, Integer> sideW, HashMap<String, Integer> sideL, int height, Bricks allBricks){
        this.SideW = sideW;
        this.sideL = sideL;
        this.allBricks = allBricks;
        this.height = height;
    }
    
    public HashMap<String, Integer> getSideW() {
        return SideW;
    }
    
    public HashMap<String, Integer> getSideL() {
        return sideL;
    }

    public int getHeight() {
        return height;
    }

    public Bricks getAllBricks() {
        return allBricks;
    }    

    @Override
    public String toString() {
        return "House{" + "SideW=" + SideW + ", sideL=" + sideL + ", height=" + height + ", allBricks=" + allBricks + '}';
    }
    
    
}
