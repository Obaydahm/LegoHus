/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.Bricks;
import Data.House;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Obaydah Mohamad
 */
public class Calculator {
    public House buildHouse(int height, int width, int length){
        House house = null;
        HashMap<String, Integer> sideW = new HashMap<String, Integer>();        
        HashMap<String, Integer> sideL = new HashMap<String, Integer>();
        
        int four = 0;
        int two = 0;
        int one = 0;
        
        int fourW = 0;
        int fourL = 0;
        int twoW = 0;
        int twoL = 0;
        int oneW = 0;
        int oneL = 0;
        
        int width_ = 0;
        int length_ = 0;
        
        for(int i = 0; i < height; i++){
            if(i % 2 == 0){
                width_ = width - 4;
                length_ = length;
            }else{
                width_ = width;
                length_ = length - 4;
            }
            
            fourW += ((width_ / 4) * 2);
            fourL += ((length_ / 4) * 2);
            twoW += (((width_ % 4) / 2) * 2);
            twoL += (((length_ % 4) / 2) * 2);
            oneW += (((width_ % 4) % 2) * 2);
            oneL += (((length_ % 4) % 2) * 2);
            
            four += ((width_ / 4) * 2) + ((length_ / 4) * 2);
            two += (((width_ % 4) / 2) * 2) + (((length_ % 4) / 2) * 2);
            one += (((width_ % 4) % 2) * 2) + (((length_ % 4) % 2) * 2);
        }
        
        sideW.put("4", fourW);
        sideW.put("2", twoW);
        sideW.put("1", oneW);      
               
        sideL.put("4", fourL);
        sideL.put("2", twoL);
        sideL.put("1", oneL);
        System.out.println("calc 4: " + four);
        System.out.println("calc 2: " + two);
        System.out.println("calc 1: " + one);
        
        house = new House(sideW, sideL, height, new Bricks(four, two, one));
        return house;
    }
}
