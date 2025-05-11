# Guía para Ejecutar la Aplicación ReservaTuClase en un Entorno Local

Esta guía detalla los pasos necesarios para ejecutar la aplicación ReservaTuClase en un entorno local. Asegúrate de seguir cada paso cuidadosamente para garantizar una configuración exitosa.

---

## 1. Requisitos Previos

Antes de comenzar, asegúrate de tener instalados los siguientes componentes en tu máquina:

- **Java 17**: Descárgalo desde [Oracle](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html) o utiliza un administrador de paquetes como SDKMAN.
- **Maven**: Descárgalo desde [Maven](https://maven.apache.org/) o instálalo con un administrador de paquetes como Homebrew (macOS) o Chocolatey (Windows).
- **Git**: Necesario para clonar el repositorio. Descárgalo desde [Git](https://git-scm.com/).
- **MySQL**: Descárgalo desde [MySQL](https://dev.mysql.com/downloads/) e instálalo en tu máquina.

---

## 2. Clonar el Repositorio

1. Abre una terminal o consola de comandos.
2. Clona el repositorio del proyecto desde GitHub:
   ```bash
   git clone https://github.com/sand260391/reserva-tu-clase-backend
   ```
3. Navega al directorio del proyecto:
   ```bash
   cd reservatuclase
   ```

---

## 3. Configurar la Base de Datos MySQL

1. Asegúrate de que el servidor MySQL esté en ejecución.
2. Crea una nueva base de datos para la aplicación. Por ejemplo:
   ```bash
   mysql -u <usuario> -p -e "CREATE DATABASE reservatuclase;"
   ```
3. Importa la estructura de tablas necesaria utilizando el archivo `creacion_db.SQL`:
   ```bash
   mysql -u <usuario> -p reservatuclase < ruta/al/archivo/creacion_db.SQL
   ```
   Reemplaza `<usuario>` con tu usuario de MySQL y ajusta la ruta al archivo `creacion_db.SQL` según corresponda.
4. Configura las credenciales de acceso a la base de datos en el archivo `application.properties` o `application.yml` del proyecto. Por ejemplo:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/reservatuclase
   spring.datasource.username=<usuario>
   spring.datasource.password=<contraseña>
   ```

---

## 4. Construir el Proyecto

1. Asegúrate de estar en el directorio raíz del proyecto.
2. Ejecuta el siguiente comando para construir el proyecto con Maven:
   ```bash
   mvn clean install
   ```
   Esto descargará las dependencias necesarias y compilará el código fuente.

---

## 5. Ejecutar la Aplicación

1. Inicia la aplicación con el siguiente comando:
   ```bash
   mvn spring-boot:run
   ```
2. Una vez iniciada, la aplicación estará disponible en la siguiente URL:
   [http://localhost:8080](http://localhost:8080)