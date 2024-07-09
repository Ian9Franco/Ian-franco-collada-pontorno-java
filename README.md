# API de Gestión de Productos y Clientes

Este proyecto es una API RESTful desarrollada con Spring Boot para gestionar productos y clientes.

## Instrucciones de Uso

### Pasos para Utilizar la API en Postman

1. **Clonar el Proyecto**

   Clona este repositorio en tu máquina local:



git clone https://github.com/Ian9Franco/Segunda-entrega-java-Ian-franco-collada-pontorno.git


2. **Configuración y Ejecución**

- Asegúrate de tener configurado Java y Maven en tu entorno de desarrollo.
- Importa el proyecto en tu IDE preferido (por ejemplo, IntelliJ IDEA).

3. **Compilación y Ejecución**

- Abre el proyecto en tu IDE y espera a que se resuelvan las dependencias.
- Ejecuta la clase principal `AbmpfApplication.java` para iniciar la aplicación Spring Boot.

4. **Acceder a la API desde Postman**

- Abre Postman en tu máquina.
- Utiliza las siguientes rutas para realizar las operaciones CRUD:

    - **POST** `/api/v1/products`: Crea un producto.
    - **GET** `/api/v1/products`: Obtiene todos los productos.
    - **GET** `/api/v1/products/{pid}`: Obtiene un producto por su ID.
    - **PUT** `/api/v1/products/{pid}`: Actualiza un producto por su ID.
    - **POST** `/api/v1/auth/register`: Registra un cliente.

5. **Enviar Solicitudes**

- Para cada solicitud, asegúrate de configurar correctamente el cuerpo (payload) y los parámetros necesarios.
- Ejecuta las solicitudes y verifica las respuestas recibidas.

## Repositorio en GitHub

Visita el repositorio en GitHub para más detalles y actualizaciones:

[https://github.com/Ian9Franco/Segunda-entrega-java-Ian-franco-collada-pontorno](https://github.com/Ian9Franco/Segunda-entrega-java-Ian-franco-collada-pontorno)

## Notas Adicionales

- Este proyecto utiliza Spring Boot, Lombok, Spring Data JPA y MySQL como base de datos.
