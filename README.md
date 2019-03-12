# Codeicus-APP

Aplicacion para la evaluacion Fullstack de Codeicus
# Tabla de contenidos

- [Prerequisitos](#Prerequisitos)
- [Tecnologias](#Tecnologias)
- [Uso](#Uso)
- [Ejecucion](#Ejecucion)
- [Aclaraciones](#Aclaraciones)
# Prerequisitos
  - Java 1.8
  - Maven
  - MySQL
  - Angular CLI
 # Tecnologias
   ## Backend
   - Spring-Boot 2.1.3
   - Hibernate 5.3.7
   - MySQL 8.0.15
   - Apache Maven 3.6.0
   ## Frontend
   - Angular 7.3
      --RxJS
   - Typescript
   - Npm 6.4.1
   - Bootstrap 4
   
   ## Software
   - Spring Tool Suite
   - Visual Studio Code
   - Postman
   - GitHub Desktop
 
 # Uso
 La aplicacion cuenta con los siguientes servicios
 - Listar tareas
 - Crear nueva tarea
 - Editar una tarea ya existente
 - Borrar una tarea
 - Ver logs de la aplicacion
 
 # Ejecucion
 Una vez descargado el proyecto 
 - Abrir consola 1
 - Navegar hasta la carpeta Backend
 - Ejecutar mvn Spring-Boot:Run para ejecutar el proyecto Backend
 - Abrir consola 2
 - Navegar hasta la carpeta frontend
 - Ejecutar ng serve para ejecutar el frontend
 - Abrir un navegador e ir a http://localhost:4200
 
 # Aclaraciones
 - Si bien el enuncia explicitaba que la base de datos debia ser SQL Server 2008, se utilizo MySQL por un problema al momento de instalacion y configuracion de SQL Server, igualmente se especificaron las dependencias a SQL Server dentro del proyecto, por lo cual solo habria que configurar la conexion para un posterior uso.
 - No es necesario crear previamente las tablas en la BD
