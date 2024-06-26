# Manual Técnico
[![uca.png](https://i.postimg.cc/44tV6yRT/uca.png)](https://postimg.cc/HjYrHpLS)

## Índice
 - [Manual Técnico](#Manualtécnico)
	- [Aspectos generales](#Aspectosgenerales)
 	-  [Modelos utilizados](#modelosutilizados) 
	-  [Guìa de instalaciòn](#guia)
	- [Tipos de error](#error1)
 - [Jira](#Jira) 
-  [Licencia de código](#Licencia) 


# Manual Técnico <a name="Manualtécnico"></a>

- [Aspectos generales](#Aspectosgenerales) 
	- [Objetivos del documento](#objetivos)
	- [Descripción general](#desc)
	- [Requerimientos del Sistema](#req)
	- [Software utilizado](#soft)
 - [Modelos utilizados](#modelosutilizados) 
	 - [Patrón de diseño MVC](#mvc)
	 - [Diagrama Relacional](#diagrama)
- [Guìa de instalación](#guia) 
- [Tipos de error](#error1)
 
 ## Aspectos generales 
 <a name="Aspectosgenerales"></a>
 
**Objetivos del documento**  <a name="objetivos"></a>
El presente manual técnico tiene como objetivo principal presentar y explicar de manera detallada los distintos aspectos y herramientas que se tomaron en cuenta para el desarrollo del sistema. Está dirigido tanto al equipo de desarrollo como al usuario final que utilizará la aplicación.

**Descripción general**  <a name="desc"></a>
El sistema es una solución innovadora que utiliza técnicas de Machine Learning para ayudar a los estudiantes de Ingeniería Informática de la Universidad Centroamericana José Simeón Cañas (UCA) a planificar y organizar de manera eficiente sus estudios. Con esta aplicación, los estudiantes pueden acceder fácilmente a un listado actualizado de las materias que pueden llevar en el próximo ciclo académico, evitando el proceso engorroso de consultar la malla curricular, esperar al sistema SIM o hacer una lista manualmente.

Gracias a la integración del Machine Learning, la aplicación puede ofrecer recomendaciones personalizadas basadas en el historial académico del estudiante y de otros roadmaps (DataSet), brindando una experiencia de planificación más precisa y adaptada a las necesidades individuales.
  
La aplicación se ha desarrollado utilizando tecnologías de desarrollo web, como Java para el backend, Spring y Spring Boot, y JSP (JavaServer Pages) para el estructurado y CSS para la interfaz gráfica. Además, se ha utilizado una base de datos relacional para almacenar la información de los estudiantes y sus notas.

Pudiendo acceder a la recomendación de materias por medio del uso de un clasificador NaiveBayes previamente modelado con archivos de "Tutoría Académica" de otros estudiantes y con el archivo que puede subir el estudiante en el apartado de materias hábiles.


**Requisitos del Sistema**  <a name="req"></a>

* **Requisitos del sistema operativo**
  - El sistema debe ser compatible con los sistemas operativos Windows o macOS.
  - Se recomienda tener la versión más reciente del sistema operativo instalada para garantizar la compatibilidad y el rendimiento óptimo de la aplicación.
  
* **Requerimientos de Hardware**
  - Procesador de al menos 1 GHz.
  - Memoria RAM de al menos 2 GB (requisito mínimo).
  - Se recomienda tener al menos 8 GB de RAM para un rendimiento óptimo.
  - Espacio de almacenamiento disponible de al menos 2 GB (requisito mínimo) para la instalación de la aplicación y los datos.
  - Espacio de almacenamiento disponible de al menos 10 GB para la instalación de la aplicación y los datos para tener rendimiento óptimo.
  - Se recomienda tener al menos 4 GB de espacio en disco duro para un funcionamiento adecuado.
  
* **Requerimientos de Software**
  - Se recomienda tener al menos Windows 7 o posterior para un funcionamiento óptimo.
  - Se recomienda utilizar la versión más reciente de Windows, como Windows 10, para aprovechar las últimas mejoras y actualizaciones de seguridad.
  - Java Development Kit (JDK) 8 o superior.
  - Un servidor de aplicaciones compatible, como 
  - Spring Boot Tool Suite 4 requiere Java 8 o una versión superior. Se recomienda tener la última versión estable de Java instalada.
  - Un navegador web actualizado, como Google Chrome, Mozilla Firefox o Microsoft Edge, para acceder a la interfaz gráfica de usuario.

 **Software utilizado** <a name="soft"></a>
 
  Para el desarrollo de la aplicación se utilizo Spring Boot Tool Suite (STS) 4 es un entorno de desarrollo integrado (IDE) basado en Eclipse, diseñado específicamente para el desarrollo de aplicaciones utilizando el framework Spring Boot. Proporciona un conjunto de herramientas y características que facilitan la creación, prueba y despliegue de aplicaciones Spring Boot.

También se utilizaron las siguientes tecnologías:

[![Tecnologias-Utilizadas.png](https://i.postimg.cc/R0HVk3RS/Tecnologias-Utilizadas.png)](https://postimg.cc/DW7TswHH)

 - **Java**: Lenguaje de programación utilizado para el desarrollo del sistema de Registro de Notas.

- **Spring Boot**: Framework de desarrollo de aplicaciones Java que proporciona un entorno simplificado para crear aplicaciones web.

- **Spring MVC**: Framework de Spring utilizado para desarrollar la capa de controladores y manejar las solicitudes HTTP.

- **Hibernate**: Framework de mapeo objeto-relacional utilizado para interactuar con la base de datos y realizar operaciones de persistencia.

- **Thymeleaf**: Motor de plantillas utilizado para generar las vistas HTML del sistema.

- **HTML/CSS**: Lenguajes de marcado utilizados para definir la estructura y el estilo de las páginas web.
  
- **Gestor de Base de datos**: PostgreSQL 15v.

- **JavaScript**: Lenguaje de programación utilizado para agregar interactividad y funcionalidad dinámica a las páginas web.

- **Github**: Sistema de control de versiones utilizado para gestionar y colaborar en el desarrollo del proyecto.

## Modelos utilizados <a name="modelosutilizados"></a>

**Patrón de diseño MVC**  <a name="mvc"></a>

La arquitectura del sistema se basa en el patrón de diseño Modelo-Vista-Controlador (MVC). Este patrón se utiliza para separar la lógica de negocio, la presentación de datos y la interacción con el usuario en tres componentes principales: el Modelo, la Vista y el Controlador.

La adopción del patrón MVC en nuestro sistema de Registro de Notas nos ha brindado varios beneficios. 
Por un lado, nos permite tener una separación clara de responsabilidades, lo cual facilita el mantenimiento y la evolución del sistema. Además, al separar la lógica de negocio de la presentación, se mejora la reutilización de componentes y la estructura del código. Esto nos permite realizar modificaciones y mejoras de forma más eficiente, permitiendonos tener un sistema bien estructurado, modular y fácilmente mantenible. La separación de responsabilidades entre el Modelo, la Vista y el Controlador nos brinda flexibilidad y escalabilidad, permitiendo adaptarnos a cambios futuros y proporcionando una experiencia de usuario mejorada.



 **Diagrama Relacional**  <a name="diagrama"></a>
 
[![Diagrama-BDD-P-gina-1.png](https://i.postimg.cc/vHMsgz9C/Diagrama-BDD-P-gina-1.png)](https://postimg.cc/4n8MjpW1)

Aclaracion: "materiasAprobadas" y "materiasPosibles" es un String compuesto por ids de la tabla "Materia", en la tabla "Carrera" se denota lo que el estudiante registra una vez subido su archivo excel.
## Guia de instalación 
<a name="guia"></a>
- Link de documento para guia de instalacion: https://drive.google.com/file/d/19E05F2ijNoN1BdImY_sMjmIkXBHGwwND/view?usp=sharing


## Compatibilidad de licencias

- Link de documento para la compatibilidad de Licencias: https://drive.google.com/file/d/1wKmUjBJ2ycym5XibQG-yzYKRpVllUoJh/view?usp=sharing

## **Tipos de error**  <a name="error1"></a>

La herramienta "Projects" de Github nos ha permitido organizar y dar seguimiento a cada error de manera estructurada, ay que cada  issue ha sido creado como una tarjeta en el tablero de proyectos, donde se ha asignado un título descriptivo, se han añadido etiquetas relevantes y se ha asignado un responsable para su solución.
Dicho tablero contiene un registro detallado de todos los problemas y errores encontrados durante el desarrollo y despliegue del aplicativo.

Cada issue ha sido creado con el objetivo de proporcionar una descripción clara y concisa del problema encontrado, incluyendo información relevante como el mensaje de error, el archivo o componente afectado, los pasos para reproducir el error, las causas identificadas y las acciones tomadas para solucionarlo. Además, se ha prestado especial atención a la claridad de los comentarios y soluciones proporcionados en cada issue. Se han utilizado términos comprensibles y se ha explicado el razonamiento detrás de cada solución implementada. Esto se ha hecho con el fin de garantizar que cualquier usuario que encuentre un error en el aplicativo pueda entender y seguir las instrucciones proporcionadas en el issue correspondiente.

Cabe destacar que todos los errores documentados han sido solucionados de manera satisfactoria. Los comentarios y soluciones brindados en los issues reflejan los pasos exactos tomados para resolver cada problema y asegurar el correcto funcionamiento del aplicativo. Se ha puesto un énfasis especial en la claridad y la exhaustividad de la documentación, con el objetivo de evitar confusiones y garantizar una experiencia fluida para los usuarios al momento de probar la aplicación.

- Link de Github Project: https://github.com/users/Cj72001/projects/2


 ## Jira 
 <a name="Jira"></a>
- Link de Jira: https://trello.com/invite/b/38tNahSa/ATTIdc4424b1f7e838c0e6ec614a72e07fa565EE6D48/codigo-abierto
 

