## ProyectoCiclo3UdeA
# Repositorio del proyecto final del ciclo 3 UdeA
Se recomienda utilizar un gestor de cambios como [**SourceTree**](https://www.sourcetreeapp.com/ "SourceTree") e [**IntelliJ**](https://www.jetbrains.com/es-es/idea/download/#section=windows "IntelliJ") como entorno de desarrollo (IDE).

# Arquitectura de la solución
![image](https://user-images.githubusercontent.com/6804880/186027115-c20e3f8a-8fe7-436b-94b2-ff03dfd6b042.png)

# Diagrama Entidad - Relación
![image](https://user-images.githubusercontent.com/6804880/186027264-a1bf5b7a-f8ed-4a51-9d7c-47d5fa232028.png)

# Changelog

- 16/08/2022 Creación de la rama release.
- 18/08/2022 Creación del proyecto Spring Boot con dependencias Spring Web, Spring DevTools, OAuth2 Client, PostgreSQL Driver y Sping Data JPA en Maven mediante [**Spring Initializr**](https://start.spring.io "Spring Initializr").
- 21/08/2022 Creación de la Clase Enterprise con atributos Name, Address, Phone y Document de acuerdo con el diagrama de Entidad - Relación.
- 22/08/2022 Se ajustan los nombres de los paquetes de acuerdo con la arquitectura propuesta. Creación de Enum RoleName y las Clases Enterprise, Employee y Transaction de acuerdo con el diagrama de Entidad - Relación. Se crea el controlador projectController para el manejo de los servicios y los Get mapping de los métodos pruebaEmpresa, pruebaEmpleado y pruebaMovimiento. Se crea la interfaz EnterpriseRepository en el paquete correspondiente y el servicio EnterpriseService.
- 24/08/2022 Se modifica el archivo pom.xml con las dependencias de Bootstrap y Thymeleaf, se crea la interfaz gráfica del index.html agregando en la carpeta templates en resources, así como los archivos de estilos css, javascript e imagenes en la carpeta static, se crea la clase MainController para visualizar el index.html, se agrega la línea spring.jpa.properties.hibernate.show_sql=show en application.properties para visualizar los cambios en la BD PostgreSQL en consola.
- 25/08/2022 Se crean los archivos de frontend en la carpeta resources, la cual con tiene el index.html, las carpetas static con los estilos css, imágenes y javascript, así como la carpeta templates con la carpeta fragments con los fragmentos de encabezado, sidebar y foorter, y pages, con las páginas html de cada opción. Se actualiza el projectController para poder enviar cambios mediante [**Postman**](https://www.postman.com/ "Postman").
- 27/08/2022 Se actualiza application.properties con comentarios y se modifica el parámetro spring.jpa.properties.hibernate.show_sql=show a spring.jpa.properties.hibernate.show_sql=true. Se crea el repositorio EnterpriseRepository extendiendo CrudRepository, para probarlo se crean las pruebas unitarias de CRUD en la clase EnterpriseRepositoryTests en la carpeta test mediante los métodos testAddNew(), testListAll(), testUpdate(), testGet() y testDelete(). Se inserta la dependencia en Maven <groupId>org.assertj</groupId> para poder utilizar el método assertThat() en las pruebas unitarias. Se vincula Bootstrap CSS en el fragmento html_head.html. Se actualiza la vesion de la dependencia PostgeSQL en pom.xml a 42.5.0.
- 28/08/2022 Se organiza la estructura de las carpetas en controllers (front y rest), entities, repositories y services (employee, enterprise y transaction), se crea el controlador enterpriseRestController con los Mapping para GET, POST, PATCH y DELETE, se separan los controladores de frontend en el paquete front, se reorganizan los estilos CSS por carpetas al igual que las páginas, se crea el frontend del CRUD para empresas y su controlador correspondiente.