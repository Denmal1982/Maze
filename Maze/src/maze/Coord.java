/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Maze;


public class Coord {
    int x;
    int y;
    String name;
    
    Coord(int x, int y){
        this.x = x;
        this.y = y;
        this.name = "(" + (x + 1) + "," + (y + 1) + ")";
    }
    // расстояние по Х
     int dX(Coord c){
        return Math.abs(this.x - c.x);
    } 
    // расстояние по У
     int dY(Coord c){
        return Math.abs(this.y - c.y);
    } 
    //  растояние до конечной точки
    int distance(Coord c){
        return dX(c)+dY(c);
    }
    
    @Override
    public int hashCode(){
        String hash;
        hash = this.x + "" + this.y;
        return Integer.parseInt(hash);
    }
    
    
    
    public Coord getStepPath(Coord c){
    	return Matrix.getSteps(c);
    }
    
    // координатs
    public String name(){
        return this.name;
    }
}
