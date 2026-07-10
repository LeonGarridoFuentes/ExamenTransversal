# ExamenTransversal

Crear proyecto Spring Boot con configuración YAML mediante Spring Initializr.

Añadir las dependencias básicas (incluyendo Eureka Client, Lombok, Spring Data JPA, Validation, MySQL Driver y Liquibase Migration).

Inicializar el repositorio en Git, añadir los archivos base creados y realizar el primer commit.

Diseñar la arquitectura de clases y microservicios.

Crear los packages para los 10 microservicios (cada uno debe contener internamente sus capas de: model, repository, service y controller).

Dar lógica al archivo application.yaml principal, agregando las líneas de configuración que servirán posteriormente para Docker.

Realizar un commit y push con la estructura de directorios y configuraciones base generadas.

Crear la base de datos local MySQL a través de Laragon/HeidiSQL, asegurando la conexión por el puerto por defecto 3306.

Crear un nuevo proyecto para el Servidor de Eureka utilizando la dependencia específica de Eureka Server.

Crear un repositorio de Git independiente exclusivo para el servidor de Eureka.

Configurar la clase principal de Eureka añadiendo la anotación @EnableEurekaServer.

Configurar el archivo application.yaml de Eureka definiendo su puerto (8761) y desactivando la autoregistración.

Implementar la lógica completa de la primera clase (Especialidades), elegida por no tener dependencias de otras entidades.

Ejecutar los servicios en orden: iniciar primero el Servidor de Eureka y posteriormente el proyecto principal.

Verificar el funcionamiento de los endpoints de Especialidades realizando peticiones HTTP en Postman.

Comprobar la persistencia en la base de datos local para asegurar que las tablas y registros se crean correctamente.

Verificar el método PUT por ID en Postman.

Comprobar el cambio del PUT en la base de datos.

Verificar el método DELETE por ID en Postman.

Corroborar su eliminación en la base de datos.

Añadir la anotación @EnableDiscoveryClient en la clase principal del proyecto para permitir que las APIs se conecten y comuniquen entre sí.

Ir a Edit Configurations en IntelliJ y duplicar la aplicación asignándole un perfil activo (especialidad).

Activar la opción Store as project file en IntelliJ para que se guarde en el repositorio.

Configurar puertos únicos por perfil en el application.yaml (separando por el momento la instancia original de la de especialidad en el puerto 8081).

Crear una configuración de tipo Compound en IntelliJ para poder ejecutar todos los microservicios de forma simultánea con un solo clic.

Ejecutar los microservicios en conjunto y comprobar su correcto registro en el dashboard de Eureka y Postman.

Visualizar el JSON de respuesta directo en el navegador web para pruebas rápidas.

Desactivar el modo de autopreservación en el panel de Eureka si es necesario para evitar mantener instancias "fantasma" caídas de forma prolongada.

Añadir la dependencia de Swagger (springdoc-openapi-starter-webmvc-ui) al archivo pom.xml.

Agregar las rutas correspondientes de Swagger en el archivo application.yaml.

Hacer el commit correspondiente con la suite de documentación integrada.

Crear el microservicio de Médicos y establecer la relación @ManyToOne para enlazarla con la entidad Especialidad.

Desarrollar el controlador de Médicos con sus métodos CRUD por ID utilizando RestTemplate para la comunicación interservicio.

Configurar e integrar Spring Cloud Gateway en el YAML: la entidad de médicos se transforma mediante un Gateway, se importa la dependencia necesaria, se redirige al puerto principal y se asigna su puerto propio (8082).

Añadir el microservicio de Médicos al grupo Compound (ejecutar todo) de IntelliJ.

Realizar pruebas integrales de la comunicación en Postman, la interfaz de Swagger y el panel de Eureka.

Personalizar Swagger creando una clase de configuración (SwaggerConfig) para asignar títulos personalizados al proyecto.

Mejorar los controladores añadiendo anotaciones @Tag y descripciones legibles a cada uno de los endpoints.

Visualizar la documentación final en la interfaz gráfica de Swagger UI.

Detener la ejecución de todos los microservicios de manera segura utilizando el comando Stop All en el IDE.

Realizar el commit