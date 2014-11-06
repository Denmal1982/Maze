/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Maze;

import java.util.ArrayList;

/**
 *
 * @author РўР­Рљ
 */
public class Matrix{
    public static ArrayList<Coord> array = new ArrayList();
    
  
     // находим оптимальный шаг относительно введенной ячейки и возвращаем ячейку nextStep 
    public static  Coord getSteps(Coord c){
    	Coord next = null; // результирующий
        ArrayList<Coord> nextSteps = new ArrayList();	// временный массив 
        ArrayList<Coord> minMatrix= new ArrayList();	// временный массив 
        
        
        
        // перебираем матрицу с ячейками
        for (Coord arr1 : array) {
            // если Х и У отличаются на 1 или равны 0            
            if((c.dX(arr1) <= 1) & ((c.dY(arr1)<= 1)) & (arr1.hashCode() != c.hashCode())) {
            	//добавляем в матрицу ячеки которые распологаются рядом
            	nextSteps.add(arr1);
            }     
        }
        
        // если не найденны соседние ячейки то возвращаем пустой next
        if(nextSteps.isEmpty()){
        	return next;
        } else 
        {
        	// находим наименьшую дистанцию
	        	int min = 1000;
	        	for(Coord nextStep : nextSteps){
		        	if(nextStep.distance(Main.end) < min){
		        		min = nextStep.distance(Main.end);	
		        	}
	        	}	 
		       
		        
		        
	            // создаем массив ячеек с минимальными значениями
		        for(Coord nextStep : nextSteps){
		        	if(nextStep.distance(Main.end) == min)
		        		minMatrix.add(nextStep);
		       	 }
		        
		        
		        // если массив имеет более одной ячейки
		        if(minMatrix.size() > 1){
		        	int minM = 1000;
		        	// находим минимальное расстояние предшествующих ячеек
		        	for(Coord minStep : minMatrix){
		        		if(minStep.getStepPath(minStep).distance(Main.end) < minM){
		        			minM = minStep.getStepPath(minStep).distance(Main.end);
		        		}
		        		if(minStep.getStepPath(minStep).distance(Main.end) == minM)
		        			//присваиваем к результату значение ячейки у которой растояние предшествующей будет меньше
		        			next = minStep;	
		        	}	
		        } else 
		        {
		        	//если значение в массиве единственное, то присваиваем его к результату
		        	next = minMatrix.get(0);
		        	// очищаем массив
		        	minMatrix.clear();
			    }
		        //System.out.println("ВЫБРАН - " + next.name);	
		        } 
        return next;
    	} 
 
    }
    
    

