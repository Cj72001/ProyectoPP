package com.uca.spring.util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.uca.spring.model.Materia;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.hibernate.mapping.Map;

import java.io.InputStream;

public class Util {


	// Materias recomendadas
	static List<Materia> materiasR = new ArrayList<Materia>();

	// Lista de materias que son prerrequisitos de las posibles
	static String[] idsMateriasPosiblesPrerrequisitos = new String[0];
	static int materiasPosiblesPrerrequisitosSize = 0;
	
	//Bandera para cocnluir si una materia es agregada a las recomendadas
	static boolean esRecomendada = false;
	
	//Nota minima
	static double notaMinima = 7.0;

	public static List<Materia> materiasRecomendadas(List<Materia> materiasPosibles, List<Materia> materiasAprobadas,
			List<Double> notaAprobada) {
		
		//Una vez con la lista de materias recomendadas, se reinician las variables de la clase:
		materiasR = new ArrayList<Materia>();
		idsMateriasPosiblesPrerrequisitos = new String[0];
		materiasPosiblesPrerrequisitosSize = 0;
		esRecomendada = false;
		notaMinima = 7.0;

		// por cada materia posible iremos obteniendo sus materias prerrequisito para
		// evaluar la nota
		// y si las notas son mayor a 7.0, entonces esa materia posible se agregara a
		// las recomendadas
		materiasPosibles.forEach(m -> {

			// guardando las materias prerrequisito de cada materia posible
			idsMateriasPosiblesPrerrequisitos = m.getPreRequisito().split(",");
			// size
			materiasPosiblesPrerrequisitosSize = idsMateriasPosiblesPrerrequisitos.length;
			
			//recorremos la lista de materias aprobadas y si el id es igual al de la materia aprobada, entonces 
			//tomaremos ese indice en materias aprobadas para evaluar la nota
			for(int i=0; i<materiasPosiblesPrerrequisitosSize; i++) {
				
				for(int j=0; j<materiasAprobadas.size(); j++) {
					
					//si los ids son iguales, entonces tomaremos el indice j, para evaluar la nota
					if(idsMateriasPosiblesPrerrequisitos[i].equals(materiasAprobadas.get(j).getIdMateria().toString())) {
						
						//Si la nota de la materia prerrequisito aprobada es mayor a la nota minima, entonces la bandera se volvera 
						//true si no false
						if(Double.valueOf(notaAprobada.get(j).toString()) > notaMinima) {
							esRecomendada = true;
						}
						else {
							esRecomendada = false;
						}
						
					}
				}
				
			}
			
			//Si la materia m cumplio con que todas las materias aprobadas que son prerrequisito se aprobaron con 
			//al menos la nota minima, entonces esta materia sera recomendada
			if(esRecomendada) {
				materiasR.add(m);
				
			}
			
		});
		
		

		return materiasR;
		
	}



	//Obtener notas del excel de tutorias
	public static HashMap<String, String> getNotasExcel(String pathExcel) throws EncryptedDocumentException, IOException{

	File f = new File(pathExcel);
    InputStream inp = new FileInputStream(f);
    Workbook wb = WorkbookFactory.create(inp);
    Sheet sheet = wb.getSheetAt(0);

	// se empezara desde la fila 6 porque desde ahi empiezan los datos 
	// los datos llegan hasta la fila 49
    int rowInit = 6, rowLimit = 50;
	
	//Pos de la fila
	int rowPos = rowInit;

    Row row = sheet.getRow(rowPos);

	//En el siguiente map se almacenaran (codigo, nota)
	HashMap<String, String> notasExcel = new HashMap<>();

      while(rowPos != rowLimit){
		Cell codigoMateriaCell = row.getCell(1),
		notaMateriaCell = row.getCell(7);

		String codigoMateriaValue = codigoMateriaCell.toString();
		String notaMateriaValue = notaMateriaCell.toString();
		
		   if(!(notaMateriaValue == "")){
			Integer numeroCorrelativo = getCorrelativoByCodigo(codigoMateriaValue);
			notasExcel.put( numeroCorrelativo.toString(), notaMateriaValue);
		   }
          
          rowPos++;  
          row = sheet.getRow(rowPos);
      }

	  return notasExcel;
	}


	public static int getCorrelativoByCodigo(String codigo){
		
		//Diccionario donde se relacionara (numeroCorrelativo, codigo)

		ArrayList<String> c = new ArrayList<String>();
		c.add(0, "0");
		c.add(1, "010180");
		c.add(2, "997701");
		c.add(3, "010142");
		c.add(4, "190153");
		c.add(5, "010112");
		c.add(6, "010181");
		c.add(7, "190154");
		c.add(8, "010143");
		c.add(9, "200068");
		c.add(10, "010182");
		c.add(11, "190175");
		c.add(12, "190155");
		c.add(13, "200084");
		c.add(14, "010183");
		c.add(15, "190156");
		c.add(16, "190157");
		c.add(17, "992501");
		c.add(18, "010141");
		c.add(19, "190158");
		c.add(20, "190159");
		c.add(21, "190160");
		c.add(22, "200069");
		c.add(23, "992601");
		c.add(24, "190161");
		c.add(25, "190162");
		c.add(26, "010118");
		c.add(27, "190163");
		c.add(28, "190166");
		c.add(29, "190164");
		c.add(30, "190165");
		c.add(31, "190176");
		c.add(32, "992701");
		c.add(33, "190166");
		c.add(34, "190167");
		c.add(35, "190168");
		c.add(36, "250055");
		c.add(37, "992801");
		c.add(38, "997402");
		c.add(39, "190169");
		c.add(40, "190170");
		c.add(41, "997403");
		c.add(42, "190171");
		c.add(43, "992901");
		c.add(44, "190172");
		
		return c.indexOf(codigo);
	}

	
}
