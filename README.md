# Proyecto Final de Java - Prototipo

**Autor:** Ian Franco Collada Pontorno

## Presentación

Este proyecto es mi prototipo de proyecto final para Java. El objetivo de esta aplicación es gestionar comprobantes, clientes y productos utilizando Spring Boot. La aplicación proporciona una API REST para realizar operaciones CRUD sobre estas entidades.

## Explicación

La aplicación está estructurada en varias capas, siguiendo el patrón de diseño de arquitectura en capas:
- **Entidad**: Representa los datos y las relaciones del modelo.
- **Repositorio**: Interfaz para interactuar con la base de datos.
- **Servicio**: Contiene la lógica de negocio.
- **Controlador**: Gestiona las solicitudes HTTP y devuelve respuestas.

## Uso

### Endpoints

#### Crear Comprobante
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
# Ejemplo de Respuesta de la API y Scripts de Creación de Tablas

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

# Scripts de Creación de Tablas

Para configurar la base de datos, utiliza los siguientes scripts SQL para crear las tablas necesarias:

```sql
CREATE DATABASE mi_database_java;

CREATE TABLE clients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(75),
    lastname VARCHAR(75),
    docnumber VARCHAR(11)
);

CREATE TABLE products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(150),
    code VARCHAR(50),
    stock INT,
    price DOUBLE
);

CREATE TABLE receipts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    client_id INT,
    created_at DATETIME,
    total DOUBLE,
    FOREIGN KEY (client_id) REFERENCES clients(id)
);

CREATE TABLE receipt_details (
    id INT AUTO_INCREMENT PRIMARY KEY,
    receipt_id INT,
    product_id INT,
    amount INT,
    price DOUBLE,
    FOREIGN KEY (receipt_id) REFERENCES receipts(id),
    FOREIGN KEY (product_id) REFERENCES products(id)
);


git clone https://github.com/Ian9Franco/Segunda-entrega-java-Ian-franco-collada-pontorno.git

cd Segunda-entrega-java-Ian-franco-collada-pontorno

./mvnw spring-boot:run


