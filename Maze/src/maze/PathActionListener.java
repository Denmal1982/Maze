package Maze;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
// обработка кнопок
public class PathActionListener implements ActionListener{
	Path path;
	Panel panel;
	ReadFile readF;
	public File file;
	Writer writer = null;
	JFileChooser choose;
	Matrix matrix;
	
	
	PathActionListener(Panel panel){
		this.panel = panel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton click = (JButton)e.getSource();
		String clickAction = click.getText();
		
		
		switch(clickAction){
			case("Открыть файл"):
				choose = new JFileChooser("Открыть");
				int f = choose.showDialog(null, "open");
				file = choose.getSelectedFile();
				if(file != null){
					//считываем файл
					readF = new ReadFile(file);
					// проверяем файл
					CheckFile c =  new CheckFile(file.getName());
					//panel.textA.append("matrix");
					if(Main.checkFileBool){
						c.outResult += " Начальная клетка - " + Main.start.name + "\n";
						c.outResult += " Конечная клетка - " + Main.end.name;
					}
					
					panel.setDisplayValue(c.outResult);
					
					file.delete();
				} else {
					panel.setDisplayValue("Файл не выбран");
				}
			break;
			
			case("Найти путь"): 
				if(Main.checkFileBool){
					path = new Path();
					Main.checkFileBool = false;
					panel.setDisplayValue(path.result);
					matrix.array.clear(); 
				} else {
					panel.setDisplayValue("Отсутсвие исходного файла");
				}		
			break;
			
			case("Сохранить результат"): 
				if(Main.resultBool){
					choose.setFileFilter(new FileNameExtensionFilter("*.txt","*.*"));
					choose.setSelectedFile(new File("result.txt"));
					if(choose.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
						try {
						writer = new FileWriter(choose.getSelectedFile());
						writer.write(Path.result);
						writer.close();
						panel.setDisplayValue("Файл сохранен");
						} catch (IOException e1) {
							
							e1.printStackTrace();
						}
					}
				} else {
					panel.setDisplayValue("Еще нет результата");
				}
			break;
			
		}
		
		
		
		
	}

}
