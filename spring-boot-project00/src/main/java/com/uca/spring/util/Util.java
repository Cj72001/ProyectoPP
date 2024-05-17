package com.uca.spring.util;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.apache.poi.EncryptedDocumentException;
import com.uca.spring.model.Materia;
import com.uca.spring.model.MateriaAprobada;
import com.uca.spring.model.MateriaExcel;

import weka.classifiers.bayes.NaiveBayes;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.io.InputStream;

public class Util {

// Materias recomendadas
static List<MateriaExcel> materiasR = new ArrayList<>();

// Lista de materias que son prerrequisitos de las posibles
static String[] idsMateriasPosiblesPrerrequisitos = new String[0];
static int materiasPosiblesPrerrequisitosSize = 0;

// Nota minima
static double notaMinima = 7.0;

// Referente a
// ML:____________________________________________________________________________________________________
// Crear las instancias con los datos de entrenamiento
//Establecer que atributos evaluara ()
// Crear el atributo "materia" como nominal
//static List<String> valoresMaterias = Arrays.asList("1", "2", "3");
static Attribute atributoMateria = new Attribute("materiaId");

// Crear el atributo "notas" como nominal
//static List<String> valoresPrerreq = Arrays.asList("1", "2", "3");
static Attribute atributoPrerr = new Attribute("prerrequisitos");
// Crear el atributo "notas" como nominal
//static List<String> valoresNota = Arrays.asList("0.0", "1.0", "2.0");
static Attribute atributoMenorNotaPrerr = new Attribute("nota");

// Crear los valores discretos para el atributo recomendacion
static String valorRecomendado = "Recomendado";
static String valorNoRecomendado = "No Recomendado";
static Attribute atributoRecomendacion = new Attribute("recomendacion",
		Arrays.asList(valorRecomendado, valorNoRecomendado));

// Crear el arreglo de atributos que evaluara
static Attribute[] atributosArray = {atributoMateria, atributoPrerr, atributoMenorNotaPrerr, atributoRecomendacion };
static ArrayList<Attribute> atributosLista = new ArrayList<>(Arrays.asList(atributosArray));

// Crear el conjunto de datos vacío con los atributos
static Instances dataset = new Instances("RecomendacionMaterias", atributosLista, 0);

// Construir el clasificador Naive Bayes
static NaiveBayes clasificador = new NaiveBayes();

// ____________________________________________________________________________________________________________________

// metodo de aprendizaje
// public static void entrenarClasificador(){

// 	// Definir el atributo recomendacion como nominal con los valores discretos
// 	atributoRecomendacion.addStringValue(valorRecomendado);
// 	atributoRecomendacion.addStringValue(valorNoRecomendado);


// 	List<File> archivosExcelEstudiantes = new ArrayList<>();
// 	archivosExcelEstudiantes = Util.obtenerArchivosExcelEstudiantes();
	
// 	List<String> notasExcel = new ArrayList<>();
// 	archivosExcelEstudiantes.forEach(archivo ->{

// 		try {

// 			notasExcel.addAll(Util.getNotasExcel(archivo).values());

// 		} catch (EncryptedDocumentException | IOException e) {
// 			e.printStackTrace();
// 		}

// 	});

// 	notasExcel.forEach(nota -> {
// 		Instance instancia = new DenseInstance(2);

// 		double notaDouble = Double.valueOf(nota);
// 		instancia.setValue(atributos[0], notaDouble);

// 		if(notaDouble >= notaMinima){
// 			instancia.setValue(atributos[1], "Recomendado");
// 		}
// 		else{
// 			instancia.setValue(atributos[1], "No Recomendado");
// 		}

// 		dataset.add(instancia);
// 	});

// 	System.out.println("data set listo");

// 	// Entrenar el clasificador Naive Bayes
// 	dataset.setClass(atributoRecomendacion);

// 	try {
// 		clasificador.buildClassifier(dataset);
// 	} catch (Exception e) {
// 		e.printStackTrace();
// 	}
// }

static String prerrequisitosStr = "";
static double notaMinimaPrerrequisitos = 10.0;

public static void entrenarClasificador(){

	// Definir el atributo recomendacion como nominal con los valores discretos
	// atributoRecomendacion.addStringValue(valorRecomendado);
	// atributoRecomendacion.addStringValue(valorNoRecomendado);


	List<File> archivosExcelEstudiantes = new ArrayList<>();
	archivosExcelEstudiantes = Util.obtenerArchivosExcelEstudiantes();
	
	List<MateriaExcel> materiasPosiblesExcel = new ArrayList<>();
	archivosExcelEstudiantes.forEach(archivo ->{

		try {

			materiasPosiblesExcel.addAll(Util.getMateriasExcel(archivo));

		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}

	});


	// materiasPosiblesExcel.forEach(m -> {
	// 	Instance instancia = new DenseInstance(2);

	// 	double notaDouble = Double.valueOf(m.getNota());
	// 	instancia.setValue(atributos[0], notaDouble);

	// 	if(notaDouble >= notaMinima ){
	// 		instancia.setValue(atributos[1], "Recomendado");
	// 	}
	// 	else{
	// 		instancia.setValue(atributos[1], "No Recomendado");
	// 	}

	// 	dataset.add(instancia);
	// });

	materiasPosiblesExcel.forEach(m->{
		System.out.println("______________________________________________");
		System.out.println("Materia: "+ m.getIdMateria()+ ", " + m.getNota());
		m.getPreRequisito().forEach(m2->{

			System.out.println("PRERREQUISITOS:");
			System.out.println(m2.getIdMateria()+ ", " +m2.getNota());
		});

	});

	

	//Tomaremos las materias posibles del 
	//y evaluaremos las materias prerrequisito de cada materia de cada estudiante del DataSet 
	materiasPosiblesExcel.forEach(m->{
		Instance instancia = new DenseInstance(4);
		prerrequisitosStr = "";
		
		//Evaluamos el idMateria
		instancia.setValue(atributosArray[0], Integer.parseInt(m.getIdMateria()));

		//Evaluamos sus prerrequisitos
		m.getPreRequisito().forEach(m2->{

			//Evaluaremos sus prerrequisito, con el fin de obtener la nota minima de ellos
			//y poder registrar un hashCode relacionado a un Str relacionado a los prerrequisitos
			//Ej: 
			//notaMinimaPrerrequisitos = 7.0
			//prerrequisitoStr = "172210" => .hashCode()
			//Con el fin de que el clasificador aprenda a recomendar en funcion de una nota minima
			//Y su hashCode relacionado a los prerrquisitos 
			if(Double.parseDouble(m2.getNota()) <= notaMinimaPrerrequisitos){
				notaMinimaPrerrequisitos = Double.parseDouble(m2.getNota());
			}

			//Creando la Str relacionada a los prerrequisitos
			prerrequisitosStr += m2.getIdMateria();
		});

		//seteando el resultado de las cadenas prerrequisitosStr y la nota minima de los prerrequisitos
		instancia.setValue(atributosArray[1], prerrequisitosStr.hashCode());
		instancia.setValue(atributosArray[2], notaMinimaPrerrequisitos);

		//Si la nota minima de los prerrequisitos es menor a la recomendada
		//entonces el atributo de recomendacion sera "No Recomendado"
		//asociandolo al hashCode de las materias prerrequisito
		if(notaMinimaPrerrequisitos >= notaMinima){
			instancia.setValue(atributosArray[3], "Recomendado");
		}
		else{
			instancia.setValue(atributosArray[3], "No Recomendado");
		}

		notaMinimaPrerrequisitos = 10.0;

	});

	System.out.println("data set listo");

	

	// Entrenar el clasificador Naive Bayes
	dataset.setClass(atributoRecomendacion);

	try {
		clasificador.buildClassifier(dataset);
	} catch (Exception e) {
		e.printStackTrace();
	}
}

// public static List<Materia> materiasRecomendadas(List<Materia> materiasPosibles, List<Materia> materiasAprobadas,
// 		List<Double> notaAprobada) {

// 	// Una vez con la lista de materias recomendadas, se reinician las variables de
// 	// la clase:
// 	materiasR = new ArrayList<Materia>();
// 	idsMateriasPosiblesPrerrequisitos = new String[0];
// 	materiasPosiblesPrerrequisitosSize = 0;
// 	esRecomendada = false;


// 	// por cada materia posible iremos obteniendo sus materias prerrequisito para
// 	// evaluar la nota
// 	// y si las notas son aceptadas por el dataset, entonces esa materia posible se
// 	// agregara a
// 	// las recomendadas
// 	materiasPosibles.forEach(m -> {

// 		// guardando las materias prerrequisito de cada materia posible
// 		idsMateriasPosiblesPrerrequisitos = m.getPreRequisito().split(",");
// 		// size
// 		materiasPosiblesPrerrequisitosSize = idsMateriasPosiblesPrerrequisitos.length;

// 		// recorremos la lista de materias aprobadas y si el id es igual al de la
// 		// materia aprobada, entonces
// 		// tomaremos ese indice en materias aprobadas para evaluar la nota
// 		for (int i = 0; i < materiasPosiblesPrerrequisitosSize; i++) {

// 			for (int j = 0; j < materiasAprobadas.size(); j++) {

// 				// si los ids son iguales, entonces tomaremos el indice j, para evaluar la nota
// 				if (idsMateriasPosiblesPrerrequisitos[i]
// 						.equals(materiasAprobadas.get(j).getIdMateria().toString())) {

// 					// Crear una nueva instancia para hacer una recomendación
// 					Instance instanciaRecomendacion = new DenseInstance(2);

// 					//Seteando vaores a los atributos para ver si la materia puede ser recomendada
// 					instanciaRecomendacion.setValue(atributoNota, Double.valueOf(notaAprobada.get(j).toString()));
// 					instanciaRecomendacion.setDataset(dataset);

// 					// Realizar la clasificación/recomendación
// 					double resultado = 0.0;
// 					try {
// 						resultado = clasificador.classifyInstance(instanciaRecomendacion);
// 					} catch (Exception e) {
// 						e.printStackTrace();
// 					}

// 					// Obtener el valor de recomendación predicho
// 					String recomendacionPredicha = dataset.attribute("recomendacion").value((int) resultado);

// 					if (recomendacionPredicha.equals("Recomendado")) {
// 						esRecomendada = true;
// 					} else {
// 						esRecomendada = false;
// 					}

// 				}
// 			}

// 		}

// 		// Si la materia m cumplio con que todas las materias aprobadas que son
// 		// prerrequisito se aprobaron con
// 		// al menos la nota minima, entonces esta materia sera recomendada
// 		if (esRecomendada) {
// 			materiasR.add(m);

// 		}

// 	});

// 	return materiasR;
// }

public static List<MateriaExcel> materiasRecomendadas(File archivo) {

	//Limpiando la lista de materias recomendadas
	materiasR.clear();

	List<MateriaExcel> materiasPosiblesExcel = new ArrayList<>();

		try {

			materiasPosiblesExcel.addAll(Util.getMateriasExcel(archivo));

		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}

	Instance instanciaRecomendacion = new DenseInstance(4);
	prerrequisitosStr = "";

	materiasPosiblesExcel.forEach(m->{
		//Evaluamos el idMateria
		instanciaRecomendacion.setValue(atributosArray[0], Integer.parseInt(m.getIdMateria()));

		//Evaluamos sus prerrequisitos
		m.getPreRequisito().forEach(m2->{

				prerrequisitosStr += m2.getIdMateria();

				if(Double.parseDouble(m2.getNota()) < notaMinimaPrerrequisitos){
					notaMinimaPrerrequisitos = Double.parseDouble(m2.getNota());
				}
		
		});

		//seteando el resultado de las cadenas prerrequisitosStr y notasPrerreqsStr
		instanciaRecomendacion.setValue(atributosArray[1], prerrequisitosStr.hashCode());
		instanciaRecomendacion.setValue(atributosArray[2], notaMinimaPrerrequisitos);

		instanciaRecomendacion.setDataset(dataset);

					// Realizar la clasificación/recomendación
					double resultado = 0.0;
					try {
						resultado = clasificador.classifyInstance(instanciaRecomendacion);
					} catch (Exception e) {
						e.printStackTrace();
					}

					// Obtener el valor de recomendación predicho
					String recomendacionPredicha = dataset.attribute("recomendacion").value((int) resultado);

					if (recomendacionPredicha.equals("Recomendado")) {
						materiasR.add(m);
					} 

		notaMinimaPrerrequisitos = 10.0;

	});

					

	return materiasR;
}

//_________________________________________________________________________________________________
//Metodos independientes de la recomendacion:

   	public static boolean materiaAprobadaAgregada = false;
	public static List<File> obtenerArchivosExcelEstudiantes() {
		materiaAprobadaAgregada = false;

        List<File> archivosExcelEstudiantes = new ArrayList<>();

		String rutaCarpeta = "src/main/java/com/uca/spring/data";
        File carpeta = new File(rutaCarpeta);
        if (carpeta.exists() && carpeta.isDirectory()) {
            File[] archivos = carpeta.listFiles();
            if (archivos != null) {
                for (File archivo : archivos) {
                    if (archivo.isFile() && archivo.getName().endsWith(".xlsx")) {
                        archivosExcelEstudiantes.add(archivo);
                    }
                }
            }
        } else {
            System.err.println("La ruta especificada no es una carpeta válida.");
        }
        return archivosExcelEstudiantes;
    }



	//Obtener notas del excel de tutorias
	public static List<MateriaExcel> getMateriasExcel(File f) throws EncryptedDocumentException, IOException{

	// String pathExcel = "C:\\Users\\omarf\\Downloads\\notas2.xlsx"; 	
	// File f = new File(pathExcel);
    InputStream inp = new FileInputStream(f);
    Workbook wb = WorkbookFactory.create(inp);
    Sheet sheet = wb.getSheetAt(0);

	// se empezara desde la fila 6 porque desde ahi empiezan los datos 
	// los datos llegan hasta la fila 49
    int rowInit = 6, rowLimit = 50;
	
	//Pos de la fila
	int rowPos = rowInit;

    Row row = sheet.getRow(rowPos);

	//En el siguiente map se almacenaran (numeroCorrelativo, nota)
	//HashMap<String, String> notasExcel = new HashMap<>();
	List<MateriaExcel> materiasExcelPosible = new ArrayList<>();
	List<MateriaExcel> materiasExcelAprobadas = new ArrayList<>();

      while(rowPos != rowLimit){
		Cell codigoMateriaCell = row.getCell(1),
		prerreqMateriaCell = row.getCell(2),
		notaMateriaCell = row.getCell(7);
		//nombreMateriaCell = row.getCell(3),
		//unidadesValorativasMateriaCell = row.getCell(6),

		String codigoMateriaValue = codigoMateriaCell.toString(),
		notaMateriaValue = notaMateriaCell.toString();

		MateriaExcel newMateria = new MateriaExcel();
					 newMateria.setIdMateria(getCorrelativoByCodigo(codigoMateriaValue).toString());
					 newMateria.setNota(notaMateriaValue);


		//vamos a ignorar los casos donde no existen prerrequisitos: prerreqMateriaCell.toString() == "-"
		if(notaMateriaValue == "" && !prerreqMateriaCell.toString().equals("-")){

			String prerreqMateriaStr = prerreqMateriaCell.toString();
			List<String> prerreqMateriaValue = Arrays.asList(prerreqMateriaStr.split(","));
			List<String> prerreqMateria = new ArrayList<>();

			prerreqMateriaValue.forEach(p->{
				prerreqMateria.add(Util.getCorrelativoByCodigo(p).toString());
			});

			List<String> idsMateriasAprobadasExcel = new ArrayList<>();

			materiasExcelAprobadas.forEach(m->{
				idsMateriasAprobadasExcel.add(m.getIdMateria());
			});

			boolean idsPrerrequisitosAprobados = false;

			if(idsMateriasAprobadasExcel.containsAll(prerreqMateria)){
				idsPrerrequisitosAprobados = true;
			}


			if(idsPrerrequisitosAprobados){
				
				materiasExcelAprobadas.forEach(m->{
					prerreqMateria.forEach(m2->{

						if(m.getIdMateria().equals(m2) && !newMateria.getPreRequisito().contains(m)){

							newMateria.getPreRequisito().add(m);

							
						}
						
					});
				});

				materiasExcelPosible.add(newMateria);
			}
		}

		
		if( !(notaMateriaValue == "") && !(prerreqMateriaCell.toString().equals("-")) ){
			
			


			materiasExcelAprobadas.forEach(m->{
				if(m.getIdMateria().equals(newMateria.getIdMateria())){
					materiaAprobadaAgregada = true;
				}
			});

			if(!materiaAprobadaAgregada){
				materiasExcelAprobadas.add(newMateria);
			}

		   }
		   
          
          rowPos++;  
          row = sheet.getRow(rowPos);
      }

	  return materiasExcelPosible;
	}

	//Obtener notas del excel de tutorias
	public static HashMap<String, String> getNotasExcel(File f) throws EncryptedDocumentException, IOException{

		// String pathExcel = "C:\\Users\\omarf\\Downloads\\notas2.xlsx"; 	
		// File f = new File(pathExcel);
		InputStream inp = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(inp);
		Sheet sheet = wb.getSheetAt(0);
	
		// se empezara desde la fila 6 porque desde ahi empiezan los datos 
		// los datos llegan hasta la fila 49
		int rowInit = 6, rowLimit = 50;
		
		//Pos de la fila
		int rowPos = rowInit;
	
		Row row = sheet.getRow(rowPos);
	
		//En el siguiente map se almacenaran (numeroCorrelativo, nota)
		HashMap<String, String> notasExcel = new HashMap<>();
	
		  while(rowPos != rowLimit){
			Cell codigoMateriaCell = row.getCell(1),
			notaMateriaCell = row.getCell(7);
	
			String codigoMateriaValue = codigoMateriaCell.toString();
			String notaMateriaValue = notaMateriaCell.toString();
			
			   if(!(notaMateriaValue == "")){
				notasExcel.put( getCorrelativoByCodigo(codigoMateriaValue).toString(), notaMateriaValue);
			   }
			  
			  rowPos++;  
			  row = sheet.getRow(rowPos);
		  }
	
		  return notasExcel;
		}


		public static Integer getCorrelativoByCodigo(String codigo) {
			switch (codigo) {
				case "0":
					return 0;
				case "010180":
				case "010180.0":
					return 1;
				case "997701":
				case "997701.0":
					return 2;
				case "010142":
				case "010142.0":
					return 3;
				case "190153":
				case "190153.0":
					return 4;
				case "010112":
				case "010112.0":
					return 5;
				case "010181":
				case "010181.0":
					return 6;
				case "190154":
				case "190154.0":
					return 7;
				case "010143":
				case "010143.0":
					return 8;
				case "200068":
				case "200068.0":
					return 9;
				case "010182":
				case "010182.0":
					return 10;
				case "190175":
				case "190175.0":
					return 11;
				case "190155":
				case "190155.0":
					return 12;
				case "200084":
				case "200084.0":
					return 13;
				case "010183":
				case "010183.0":
					return 14;
				case "190156":
				case "190156.0":
					return 15;
				case "190157":
				case "190157.0":
					return 16;
				case "992501":
				case "992501.0":
					return 17;
				case "010141":
				case "010141.0":
					return 18;
				case "190158":
				case "190158.0":
					return 19;
				case "190159":
				case "190159.0":
					return 20;
				case "190160":
				case "190160.0":
					return 21;
				case "200069":
				case "200069.0":
					return 22;
				case "992601":
				case "992601.0":
					return 23;
				case "190161":
				case "190161.0":
					return 24;
				case "190162":
				case "190162.0":
					return 25;
				case "010118":
				case "010118.0":
					return 26;
				case "190163":
				case "190163.0":
					return 27;
				case "190065":
				case "190065.0":
					return 28;
				case "190164":
				case "190164.0":
					return 29;
				case "190165":
				case "190165.0":
					return 30;
				case "190176":
				case "190176.0":
					return 31;
				case "992701":
				case "992701.0":
					return 32;
				case "190166":
				case "190166.0":
					return 33;
				case "190167":
				case "190167.0":
					return 34;
				case "190168":
				case "190168.0":
					return 35;
				case "250055":
				case "250055.0":
					return 36;
				case "992801":
				case "992801.0":
					return 37;
				case "997402":
				case "997402.0":
					return 38;
				case "190169":
				case "190169.0":
					return 39;
				case "190170":
				case "190170.0":
					return 40;
				case "997403":
				case "997403.0":
					return 41;
				case "190171":
				case "190171.0":
					return 42;
				case "992901":
				case "992901.0":
					return 43;
				case "190172":
				case "190172.0":
					return 44;
				default:
					return -1;
			}
		}
		

	
}
