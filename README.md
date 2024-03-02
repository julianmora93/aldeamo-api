API Rest de prueba

Configuración del proyecto:
  - SpringBoot Project Maven
  - Lenguaje Java
  - Java 17.0.10
  - Packaging War
  - Dependencias:
    > Spring Web
    > Spring Data JPA
    > MySQL Driver
  - Desplegado en:
    > Servidor AWS EC2
    > Apache Tomcat 10.1.15
  - Base de datos:
    > Amazon RDS
    > MySQL 8.0.35
  - Uso de AWS VPC para la configuración de red de la Instancia EC2 y el RDS

Configuraicon del proyecto inicial con Spring Initializr

![image](https://github.com/julianmora93/aldeamo-api/assets/133082144/28cf07da-9f4a-4161-a6fc-22e91203a947)



Configuración VPC

![image](https://github.com/julianmora93/aldeamo-api/assets/133082144/87755b23-ce0f-485b-b710-289865be1897)



Configuración Instancia EC2

![image](https://github.com/julianmora93/aldeamo-api/assets/133082144/2602a30f-cb6d-44aa-80d3-f818aff055eb)



Paquetes del proyecto

![image](https://github.com/julianmora93/aldeamo-api/assets/133082144/9ab462b8-1903-4319-9a7f-426ef325ecb5)



Para la solución del problema se agregaron los datos de prueba del ejemplo y se agregó un método que genera la traza de seguimiento como en el ejemplo:


> Table de base de datos

![image](https://github.com/julianmora93/aldeamo-api/assets/133082144/75fbd753-b919-447d-af2e-eba68edd28f2)



> Ejemplo > Q1

![Q1](https://github.com/julianmora93/aldeamo-api/assets/133082144/9a9227a8-a811-4b75-bc89-bf22301989e2)



> Ejemplo > Q2

![Q2](https://github.com/julianmora93/aldeamo-api/assets/133082144/087bdc7b-dd36-434a-a2db-48f4b5e82c0a)



> Ejemplo > Q3

![Q3](https://github.com/julianmora93/aldeamo-api/assets/133082144/4f1f26bd-82ac-4106-b122-49f29190dc84)



> Ejemplo > Response

![Response](https://github.com/julianmora93/aldeamo-api/assets/133082144/d428ea68-3ef0-4596-b0a2-c054b12a8851)




Para completar el objetivo que es el retorno de los valores de respuesta, se agregó otro método que obtiene esa respuesta:

![image](https://github.com/julianmora93/aldeamo-api/assets/133082144/c5481862-c6ef-4842-bd90-11599996a83c)
