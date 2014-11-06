package Maze;

public class CheckFile {
	public String outResult;
	String file;
	ReadFile readFile;
	public int matrixX; //ширина лабиринта
	public int matrixY; //высота лабиринта
	public static int [][] matrix;
	
	
	
	CheckFile(String file){
		this.file = file;
		outResult = "";
		
		if(checking()){
			Main.checkFileBool = true;
		} else Main.checkFileBool = false;
		
		
		
	}
	
	public boolean checking(){
		if(nullCheck()){
			//System.out.println("nullCheck() = " + nullCheck());
			//проверим на содержание чисел
			if(checkString()){
				//System.out.println("checkString() = " + checkString());
				//проверяем по параметрам
				if(checkParam()){
					//System.out.println("checkParam()");
					// собираем параметры 
					getParamMatrix();
					if(checkMatrixParam()){
						//System.out.println("checkMatrixParam()");
						getParamCoord();
						createMatrix();
						// проверяем start и end на совпадение с препятствиями
						if(checkCoord()){
							return true;
						} else {
							outResult = "Неверные параметры координат";
							return false;
						}
						
					} else { 
						outResult = "Неверные параметры в файле";
						return false;
					}
					
				} else {
					outResult = "Неверные параметры в файле";
					return false;
				}
				
				
			} else {
				outResult = "Ошибка в содержании файла";
				return false;
			}
			
			
		} else {
			outResult = "Ошибка в содержании файла";
			return false;
		}
		
			
	}
	boolean checkCoord(){
		int i = 0;
		int endX = Main.end.x;
		int endY = Main.end.y;
		int startX = Main.start.x;
		int startY = Main.start.y;
		
		
		for(int y = 0; y < matrix.length ; y ++){
			for(int x = 0; x < matrix[y].length ; x++){
				
				
				if(matrix[x][y] == 1){
					if((endX == x) && (endY == y)){
						i++;
					}
					
					if((startX == x) && (startX  == y)){
						i++;
					}
					
				}	
			} 
		}
		
		if(i!=1){
			return true;
		}
		
		return false; 
		
	}
	
	// проверка на соответствие параметров с матрицей
	boolean checkMatrixParam(){
		//System.out.println("checkMatrixParam");
		int q = 0;
		//проверяем ширину матрицы в каждой строке
		for(int i = 1; i < readFile.array.length; i++){
			if(matrixX != readFile.array[i].length() ){
				q++;
			}
		}
		
		// проверяем высоту матрицы
		
		if(matrixY != (readFile.array.length - 1)){
			q++; 
		}
		if(q != 0){
			return false;
		}
		return true;
	}
	
	//проверка на содержание
	boolean nullCheck(){
		if(сheckFileTXT()){
			if(readFile.array.length != 0){
				return true;
			} else 
				return false;
		}
		return false;
	}
	
	
	
	
	void createMatrix(){
		//System.out.println("Создаем матрицу");
		matrix = new int[matrixX][matrixY];
		char [] m;
		for(int y = 0; y < matrixY ; y ++){
			m = readFile.array[y+1].toCharArray();
			for(int x = 0; x < matrixX ; x++){
				matrix[y][x] = Integer.parseInt(Character.toString(m[x]));
				outResult = outResult + matrix[y][x];
			} 
			outResult = outResult + "\n";
		} 
	}
	
	// добавляем размеры лабиринта
	void  getParamMatrix(){
		char [] param = readFile.array[0].toCharArray();
		this.matrixX = Integer.parseInt(Character.toString(param[0]));
		this.matrixY = Integer.parseInt(Character.toString(param[1]));
		//System.out.println("getParamMatrix()");
	}
	// добавляем кординаты 
	void getParamCoord(){
		//System.out.println("getParamCoord");
		char [] param = readFile.array[0].toCharArray();
		Main.start  = new Coord(Integer.parseInt(Character.toString(param[2])) - 1,Integer.parseInt(Character.toString(param[3])) - 1);
		Main.end  = new Coord(Integer.parseInt(Character.toString(param[4])) - 1 , Integer.parseInt(Character.toString(param[5])) - 1);
		//System.out.println("Параметры end = " + Main.end.name+ "  start = " + Main.start.name);
	}
	
	// проверяем параметры
	boolean checkParam(){
		int xM, yM, startX, startY ,endX, endY;
		
		if(readFile.array[0].length() == 6){
			char [] param = readFile.array[0].toCharArray();
			xM = Integer.parseInt(Character.toString(param[0]));
			yM = Integer.parseInt(Character.toString(param[1]));
			startX = Integer.parseInt(Character.toString(param[2]));
			startY = Integer.parseInt(Character.toString(param[3]));
			endX = Integer.parseInt(Character.toString(param[4]));
			endY = Integer.parseInt(Character.toString(param[5]));
			// если размеры лабиринта более 2
			if((param[0] > 2) & (param[1] > 2)){
				// проверим не выходят ли координаты за параметры матрицы
				if((startX <= xM) && (startY <= yM) && (endX <= xM) && (endY <= yM)){
					return true;
				}
			} else return false;
		} else {
			return false;
		}
		return false;
	}
	
	
	// проверка на формат
	public boolean сheckFileTXT(){
		String ext;
		int dotPos = file.lastIndexOf(".");
		ext = file.substring(dotPos + 1);
		if(ext.endsWith("txt")) {
			return true;
		}
		else
		return false;
	}
	
	
	// проверяем строки на содержание чисел
	boolean checkString() {
		for(String string : readFile.array){
			if (string == null || string.length() == 0){
				return false;
			}
	        char c;
	        for (int i = 0; i < string.length(); i++) {
	            c = string.charAt(i);
	            if (!(c >= '0' && c <= '9')) {
	                return false;
	            } 
	        }	
		}
		return true;
		
    }
	
	
	
}
