# Diccionario de palabras

Aplicación que simula un diccionario de palabras con backend en Spring Boot y frontend en Angular.

## Requisitos

- Java 21
- Maven
- Node.js 18+ (para el frontend)
- npm

## Estructura de Carpetas

### Backend (Spring Boot)
- `back-end/diccionari/` - Aplicación Spring Boot
  - `src/main/java/ifc33b/dwesc/diccionari/` - Código fuente Java
    - `controller` - Controladores
    - `dto` - Modelos de transferencia entre front y back
    - `model` - Modelos Java
    - `repository` - JPA
    - `service` - Lógica de negocio
  - `src/main/resources/` - Recursos de la aplicación
  - `src/test/` - Tests unitarios
  - `pom.xml` - Dependencias Maven

### Frontend (Angular)
- `front-end/diccionari/` - Aplicación Angular
  - `src/app/` - Código Angular
    - `components/` - Componentes reutilizables
    - `models/` - Modelos TypeScript
    - `services/` - Servicios (comunicación con backend)
  - `src/` - Assets y configuración
  - `package.json` - Dependencias npm

## Instalación

### Backend

1. Acceder a la carpeta del backend:
```bash
cd back-end/diccionari
```

2. Compilar y ejecutar:
```bash
mvn spring-boot:run
```

El servidor estará disponible en `http://localhost:8080`

### Frontend

1. Acceder a la carpeta del frontend:
```bash
cd front-end/diccionari
```

2. Instalar dependencias:
```bash
npm install
```

3. Ejecutar servidor de desarrollo:
```bash
npm start
```

La aplicación estará disponible en `http://localhost:4200`

## Desarrollo

### Backend

El backend está construido con:
- **Spring Boot 3.x** - Framework web
- **Spring Data JPA** - Acceso a datos
- **Maven** - Gestor de dependencias

### Frontend

El frontend está construido con:
- **Angular 18+** - Framework de desarrollo
- **TypeScript** - Lenguaje de programación
- **SCSS** - Estilos
- **npm** - Gestor de dependencias

## Endpoints API

La API está disponible en `http://localhost:8080/api/diccionari`

### Tabla Resumen de Endpoints

| Método | Ruta | Descripción | Status |
|--------|------|-------------|--------|
| GET | `/api/diccionari` | Obtener todas las palabras | 200 |
| GET | `/api/diccionari/{palabra}` | Obtener una palabra exacta | 200 |
| POST | `/api/diccionari` | Crear una nueva palabra | 201 |

### 1. Obtener todas las palabras

**GET** `/api/diccionari`

Devuelve la lista de todas las palabras

**Response (200 OK):**
```json
[
  {
    "id": 1,
    "terme": "Palabra1",
    "definicio": "Deficinión de la Palabra1"
  }
  {
    "id": 2,
    "terme": "Palabra2",
    "definicio": "Deficinión de la Palabra2"
  }
]
```

---

### 2. Obtener una palabra exacta

**GET** `/api/diccionari/{palabra}`

Devuelve una palabra específica

**Response (200 OK):**
```json
[
  {
    "id": 1,
    "terme": "Palabra1",
    "definicio": "Deficinión de la Palabra1"
  }
]
```

---

### 3. Crear una nueva palabra

**POST** `/api/diccionari`

Crea una nueva palabra.

**Headers:**
```
Content-Type: application/json
```

**Request Body:**
```json
{
  "terme": "Palabra1",
  "definicio": "Definición de la palabra1"
}
```

**Parámetros requeridos:**
- `terme` (string, obligatorio): Nombre de la palabra
- `definicio` (string, obligatorio): Definición del significado de la palabra

**Response (201 Created):**
```json
{
  "id": 1,
  "terme": "Palabra1",
  "definicio": "Definición de la palabra1"
}
```

---

## Ejemplos de uso

### Con cURL

**Crear una palabra:**
```bash
curl -v -X POST "http://localhost:8080/api/diccionari"   -H "Content-Type: application/json; charset=UTF-8"   --data-raw '{"terme":"Palabra1","definicio":"Definicion de la Palabra1"}'
```

**Obtener todas las palabras**
```bash
curl -X GET "http://localhost:8080/api/diccionari"
```

**Obtener una palabra específica**
```bash
curl -X GET "http://localhost:8080/api/diccionari/Palabra1"
```

## Estructura del Proyecto

```
diccionari/
├── README.md
├── back-end/
│   └── diccionari/
│       ├── mvnw
│       ├── mvnw.cmd
│       ├── pom.xml
│       ├── src/
│       │   ├── main/
│       │   │   ├── java/ifc33b/dwesc/diccionari/
│       │   │   │   ├── DicciconariController.java
│       │   │   │   ├── controller/
│       │   │   │   │   └── DiccionariController.java
│       │   │   │   ├── dto/
│       │   │   │   │   ├── ParaulaRequest.java
│       │   │   │   │   └── ParaulaResponse.java
│       │   │   │   ├── model/
│       │   │   │   │   └── Paraula.java
│       │   │   │   ├── repository/
│       │   │   │   │   └──   ParaulaRepository.java
│       │   │   │   └── service/
│       │   │   │       └──  ParaulaService.java
│       │   │   └── resources/
│       │   │       └── application.properties
│       │   └── test/
│       │       └── java/ifc33b/dwesc/diccionari/
│       │           └── DicciconariController.java
│       └── target/ (generado por Maven)
└── front-end/
    └── diccionari/
        ├── angular.json
        ├── package.json
        ├── tsconfig.json
        ├── tsconfig.app.json
        ├── tsconfig.spec.json
        ├── README.md
        ├── public/
        ├── src/
        │   ├── index.html
        │   ├── main.ts
        │   ├── styles.scss
        │   └── app/
        │       ├── app.config.ts
        │       ├── app.html
        │       ├── app.routes.ts
        │       ├── app.scss
        │       ├── app.ts
        │       ├── app.spec.ts
        │       ├── components/
        │       │   ├── formulari-paraula/
        │       │   │   ├── formulari-paraula.html
        │       │   │   ├── formulari-paraula.scss
        │       │   │   ├── formulari-paraula.ts
        │       │   │   └── formulari-paraula.spec.ts
        │       │   └── llista-paraula/
        │       │       ├── llista-paraula.html
        │       │       ├── llista-paraula.scss
        │       │       ├── llista-paraula.ts
        │       │       └── llista-paraula.spec.ts
        │       ├── models/
        │       │   ├── index.ts
        │       │   ├── paraula.model.ts
        │       │   └── paraula.model.spec.ts
        │       └── services/
        │           ├── paraula.service.ts
        │           └── paraula.service.spec.ts
```