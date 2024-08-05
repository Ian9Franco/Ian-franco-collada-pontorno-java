# Proyecto Final de Java - Prototipo

**Autor:** Ian Franco Collada Pontorno

## Presentación

Este proyecto es el prototipo final para Java, desarrollado como parte de mi curso. La aplicación está diseñada para gestionar comprobantes, clientes y productos utilizando Spring Boot. Proporciona una API REST para realizar operaciones CRUD sobre estas entidades.

---

## Estructura de la Aplicación

La aplicación sigue una arquitectura en capas, estructurada de la siguiente manera:
- **Entidad**: Define los datos y las relaciones del modelo.
- **Repositorio**: Interfaz para interactuar con la base de datos.
- **Servicio**: Contiene la lógica de negocio.
- **Controlador**: Gestiona las solicitudes HTTP y devuelve respuestas.

---

## Uso

### Crear Comprobante
- **URL:** `/api/v1/receipts`
- **Método:** `POST`
- **Body:**
  ```json
  {
      "client": {
          "clientId": 1
      },
      "lines": [
          {
              "amount": 1,
              "product": {
                  "id": 1
              }
          }
      ]
  }

## Scripts de Creación de Tablas
  
A continuación se incluyen los scripts SQL para crear las tablas necesarias:

```sql
-- Crear base de datos
CREATE DATABASE mi_database_java;

-- Crear tabla de clientes
CREATE TABLE clients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(75),
    lastname VARCHAR(75),
    docnumber VARCHAR(11)
);

-- Crear tabla de productos
CREATE TABLE products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(150),
    code VARCHAR(50),
    stock INT,
    price DOUBLE
);

-- Crear tabla de comprobantes
CREATE TABLE receipts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    client_id INT,
    created_at DATETIME,
    total DOUBLE,
    FOREIGN KEY (client_id) REFERENCES clients(id)
);

-- Crear tabla de detalles de comprobantes
CREATE TABLE receipt_details (
    id INT AUTO_INCREMENT PRIMARY KEY,
    receipt_id INT,
    product_id INT,
    amount INT,
    price DOUBLE,
    FOREIGN KEY (receipt_id) REFERENCES receipts(id),
    FOREIGN KEY (product_id) REFERENCES products(id)
);

---


## Ejemplo de Respuesta de la API

Cuando se crea un comprobante, la respuesta de la API es similar a la siguiente:

```json
{
    "id": 1,
    "client": {
        "id": 1,
        "name": "John",
        "lastname": "Doe",
        "docnumber": "12345678901"
    },
    "createdAt": "2023-01-01T12:00:00",
    "total": 100.0,
    "details": [
        {
            "id": 1,
            "product": {
                "id": 1,
                "description": "Product 1",
                "code": "P001",
                "stock": 10,
                "price": 100.0
            },
            "amount": 1,
            "price": 100.0
        }
    ]
}

---


## Ejecución del Proyecto

Para ejecutar el proyecto, sigue estos pasos:

1. **Clona el repositorio:**
   ```bash
   git clone https://github.com/Ian9Franco/Ian-franco-collada-pontorno-java.git


./mvnw spring-boot:run
