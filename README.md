## ProyectoCiclo3UdeA
# Repositorio del proyecto final del ciclo 3 UdeA
Se recomienda utilizar un gestor de cambios como [**SourceTree**](https://www.sourcetreeapp.com/ "SourceTree") e [**IntelliJ**](https://www.jetbrains.com/es-es/idea/download/#section=windows "IntelliJ") como entorno de desarrollo (IDE).

# Changelog

- 16/08/2022 Creación de la rama release
- 18/08/2022 Creación del proyecto Spring Boot con dependencias Spring Web, Spring DevTools, OAuth2 Client, PostgreSQL Driver y Sping Data JPA en Maven mediante [**Spring Initializr**](https://start.spring.io "Spring Initializr")
- 21/08/2022 Creación de la Clase Enterprise con atributos Name, Address, Phone y Document de acuerdo con el diagrama de Entidad - Relación
- 22/08/2022 Se ajustan los nombres de los paquetes de acuerdo con la arquitectura propuesta. Creación de Enum RoleName y las Clases Enterprise, Employee y Transaction de acuerdo con el diagrama de Entidad - Relación. Se crea el controlador projectController para el manejo de los servicios y los Get mapping de los métodos pruebaEmpresa, pruebaEmpleado y pruebaMovimiento. Se crea la interfaz EnterpriseRepository en el paquete correspondiente y el servicio EnterpriseService