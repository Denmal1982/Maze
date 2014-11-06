/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Maze;

public class Path {
    public Matrix matrix;
    static Coord next = null; // следующая клетка
	static Coord early; // предыдущая клетка
	public Coord step; // текущая клетка
	public static String result = "";
    
    public Path(){
        matrix = new Matrix(); // массив свободных клеток
        step = Main.start; // текущая клетка
        early = Main.start; // предыдущая ячейка
        result = Main.start.name; // строка результата,  начинаем с начальной точки
        Main.resultBool = false;
       
        
        
        // создаем массив со нулевыми значениями лабиранта
        System.out.println(CheckFile.matrix.length);
        for(int i = 0; i < CheckFile.matrix.length ;i++){
            for(int j = 0; j < CheckFile.matrix[i].length; j++){
                if(CheckFile.matrix[i][j] != 1){
                    matrix.array.add(new Coord(i,j));    
                }
            }
        }      
        // запускаем поиск  
        findPath();  
    }
    
    
    
    // ищем кратчайший путь 
    public String findPath(){
    	// определяем следующий шаг
    	next = matrix.getSteps(step);
    	if(next != null){
    		result = result + "-" +  next.name;
    		
    		if((next.hashCode() == Main.end.hashCode())){
    			//System.out.println(result);
    			Main.resultBool = true;
    			return result;
    		} else {
    			if((next.hashCode() == early.hashCode())){
    				for(int a = 0; a < matrix.array.size(); a++){
        				if(matrix.array.get(a).hashCode() == step.hashCode()){
        					//System.out.println("Удаление " + matrix.array.get(a).name);
        					matrix.array.remove(a);
        					result = Main.start.name;  // обнуляем результат  			
		    				//System.out.println("Стартуем заново");
		        			step = Main.start; // присваиваем текущей start
		        			early = Main.start;
        				}
        			} findPath();
    			} else {
    				// если слудующая ячейка не равня конечной 
	    			early = step; //присваиваем  присваиваем early текущую ячейку
	    			//System.out.println("присваиваем  early = " + early.name);/
	    			step = next; //текущей  ячейки присваиваем next 
	    			//System.out.println("ПЕРЕХОДИМ step = " + step.name);
	    			findPath(); // запускаем заново поиск	
    			}
    		} 
    	} else {
    		Main.resultBool = false;
    		result = "Нету пути"; 
    	}
		return "";
    			
    }
}
