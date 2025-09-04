# Kata Números romanos
## Descripción
Implementación de un conversor bidireccional de números enteros a romanos y viceversa, desarrollado aplicando Test Driven Development (TDD) y expuesto como servicio REST.

### Rango Válido

- Números enteros (arábigos): 1 a 3999
- Números romanos: I a MMMCMXCIX

### Stack tecnológico
- Java 17
- Spring Boot 3.5.5
- Maven
- JUnit 5 + Mockito
- Spring Boot Test

### Estructura del proyecto
``` 
src/
├── main/java/com/possumus/
│   ├── controller/
│   │   └── ArabicRomanConverterController.java
│   ├── service/
│   │   └── ArabicRomanConverterService.java
│   ├── converter/
│   │   └── ArabicRomanConverter.java
│   ├── exception/
│   │   ├── InvalidArabicNumberException.java
│   │   ├── InvalidRomanNumberException.java
│   │   └── GlobalExceptionHandler.java
│   └── PossumusRomanNumbersApplication.java
└── test/java/com/possumus/
    ├── controller/
    │   └── ArabicRomanConverterControllerTest.java
    ├── converter/
    │   └── ArabicToRomanTest.java
    │   └── RomanToArabicTest.java
    └── PossumusRomanNumbersApplicationTests.java
```
## Instalación y ejecución
### 1. Clonar repositorio
```
git clone https://github.com/mateorodon/possumus-excercise.git
cd possumus-roman-numbers
```
### 2. Instalar dependencias
``` 
mvn clean install
```
### 3. Ejecutar aplicación
``` 
mvn spring-boot:run
```
La aplicación estará disponible en: http://localhost:8080
### 4. Correr los tests
``` 
mvn test 
```
Coverage:
- Tests unitarios para lógica de conversión
- Tests de integración para endpoints REST
- Border cases
- Excepciones
## API Endpoints
### Convertir Entero a Romano
``` GET /api/to-roman?number=<num>```
#### Parametros
- number (int): Número entero (arábigo) a convertir
### Convertir Romano a Entero
``` GET /api/to-arabic?number=<num>```
#### Parametros
- number (string): Número romano a convertir
### Ejemplos
``` bash
curl "http://localhost:8080/api/to-roman?number=21"
curl "http://localhost:8080/api/to-arabic?number=XXI"
```
### Validaciones y Manejo de Errores
#### Errores para Números Enteros (Arábigos)
Lanzan la excepción ```InvalidArabicNumberException```
- Rango inválido: ```400 Bad Request```
- Valor nulo: ```400 Bad Request```
#### Errores para Números Romanos
Lanzan la excepción ```InvalidRomanNumberException```
- Rango inválido: ```400 Bad Request```
- String vacío/nulo: ```400 Bad Request```

## Arquitectura y desarrollo
El proyecto sigue una arquitectura web en capas orientada al desarrollo de servicios REST:
- **Controller**: Manejo de requests HTTP y responses
- **Service**: Lógica de negocio
- **Converter**: Algoritmos puros de conversión
- **Exception**: Manejo centralizado de errores con @ControllerAdvice

Se buscó un código legible y escalable siguiendo los principios SOLID y DRY.