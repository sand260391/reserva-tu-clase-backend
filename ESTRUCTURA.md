# ESTRUCTURA DEL PROYECTO

Este documento describe la estructura del proyecto `ReservaTuClase`, incluyendo los paquetes Java y las clases más importantes.

## Estructura de Paquetes

### `com.sandraom.reservatuclase`
Este es el paquete raíz del proyecto. Contiene la clase principal que inicia la aplicación.

- **Clase `ReservatuclaseApplication`**: 
  - Es la clase principal de la aplicación.
  - Contiene el método `main` que ejecuta la aplicación Spring Boot.

### `com.sandraom.reservatuclase.controller`
Este paquete contiene las clases controladoras que manejan las solicitudes HTTP y definen los endpoints de la API.

### `com.sandraom.reservatuclase.service`
Este paquete contiene las clases de servicio que implementan la lógica de negocio de la aplicación.

### `com.sandraom.reservatuclase.repository`
Este paquete contiene las interfaces de repositorio que interactúan con la base de datos.

### `com.sandraom.reservatuclase.model`
Este paquete contiene las clases de modelo que representan las entidades de la base de datos.

### `com.sandraom.reservatuclase.config`
Este paquete contiene las clases de configuración de la aplicación.

- **Clases principales**:
  - `SecurityConfig`: Configuración de seguridad para la aplicación.

### `com.sandraom.reservatuclase.dto`
Este paquete contiene las clases de transferencia de datos (DTOs) que se utilizan para intercambiar información entre las capas de la aplicación.

### `com.sandraom.reservatuclase.security`
Este paquete contiene las clases relacionadas con la seguridad de la aplicación.

- **Clases principales**:
  - `JwtFiltroAutenticacion`: Filtro de autenticación JWT que valida los tokens y establece la autenticación en el contexto de seguridad.

### `com.sandraom.reservatuclase.util`
Este paquete contiene clases utilitarias que proporcionan funcionalidades comunes y reutilizables.

- **Clases principales**:
  - `JwtUtil`: Utilidad para la generación, validación y extracción de información de tokens JWT.

## Notas Adicionales
- La estructura sigue las mejores prácticas de Spring Boot, separando las responsabilidades en controladores, servicios, repositorios, modelos, DTOs, seguridad y utilidades.
- Cada paquete tiene un propósito claro, lo que facilita el mantenimiento y la escalabilidad del proyecto.