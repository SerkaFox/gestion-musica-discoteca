# Proyecto: Gestión de Música en Discoteca 🎵

Este proyecto tiene como objetivo gestionar música en una discoteca mediante una interfaz gráfica en Java.  
Cada alumno tiene una tarea específica para contribuir al desarrollo del sistema.

---

## 📚 Funcionalidades:
- Mostrar listas de Álbumes, Canciones y Canciones Eliminadas.
- Buscar canciones por nombre.
- Ordenar canciones por Nombre, Duración o Álbum.
- Añadir nuevas canciones con Nombre, Intérprete, Duración y selección de Álbum.
  - El álbum se selecciona de una lista existente o se crea uno nuevo con un botón adicional.
- Eliminar canciones con traslado a `canciones_eliminadas`.

---

## 🔧 Tecnologías Utilizadas:
- **Java 8+**
- **MySQL 8.0+**
- **JDBC** para la conexión a la base de datos.

---

# 📂 Tareas (1 por alumno):

## 1. DatabaseConnection.java (Alumno 1)
**Objetivo:**  
Gestionar la conexión a la base de datos MySQL.

**Requisitos:**
- Crear una clase llamada `DatabaseConnection`.
- Definir las constantes para la conexión.
- Implementar el método:
    ```java
    public static Connection getConnection() throws SQLException
    ```
- Manejar excepciones utilizando `try-catch`.

---

## 2. Album.java (Alumno 2)
**Objetivo:**  
Crear el modelo para la entidad `Album`.

**Requisitos:**
- Crear una clase `Album` con los siguientes atributos:
  - `int id_album`
  - `String nombre`
  - `int anio`
- Crear un **constructor** con todos los atributos.
- Implementar métodos `Getters`, `Setters` y `toString()`.

---

## 3. Cancion.java (Alumno 3)
**Objetivo:**  
Crear el modelo para la entidad `Cancion`.

**Requisitos:**
- Crear una clase `Cancion` con los siguientes atributos:
  - `int id_cancion`
  - `String nombre`
  - `String interprete`
  - `Time duracion`
  - `int albumId`
- Implementar `Comparable<Cancion>` para ordenar por nombre.

---

## 4. AlbumDAO.java (Alumno 4)
**Objetivo:**  
Acceso a datos para `Album`.

**Requisitos:**
- Implementar los métodos:
  - `List<Album> getAllAlbums()`
  - `Album getAlbumById(int id)`
  - `int addAlbum(Album album)`
- Si no existe el álbum, permitir crear uno nuevo.

---

## 5. CancionDAO.java (Alumno 5)
**Objetivo:**  
Acceso a datos para `Cancion`.

**Requisitos:**
- Implementar los métodos:
  - `List<Cancion> getAllCanciones()`
  - `int addCancion(Cancion cancion)`
  - `void deleteCancion(int idCancion)`

---

## 6. BuscarCancionService.java (Alumno 6)
**Objetivo:**  
Implementar la **búsqueda de canciones**.

**Requisitos:**
- Implementar el método:
    ```java
    public List<Cancion> buscarPorNombre(String query)
    ```
- Utilizar `LIKE` en la consulta SQL para búsqueda parcial.

---

## 7. OrdenarCancionService.java (Alumno 7)
**Objetivo:**  
Implementar la **ordenación de canciones**.

**Requisitos:**
- Implementar métodos:
  - `List<Cancion> ordenarPorNombre()`
  - `List<Cancion> ordenarPorDuracion()`
  - `List<Cancion> ordenarPorAlbum()`

---

## 8. Validaciones.java (Alumno 8)
**Objetivo:**  
Implementar validaciones de entrada.

**Requisitos:**
- Validar que los campos:
  - `Nombre` e `Intérprete` no estén vacíos.
  - `Duración` tenga formato correcto (hh:mm:ss).
  - `Álbum` esté seleccionado o se cree uno nuevo.

---

## 9. CancionEliminadaDAO.java (Alumno 9)
**Objetivo:**  
Gestionar `canciones_eliminadas`.

**Requisitos:**
- Crear métodos:
  - `List<Cancion> getAllEliminadas()`
  - `void restoreCancion(int id)`
  - `void deletePermanently(int id)`

---

## 10. Integración y Testing (Alumno 10)
**Objetivo:**  
**Integrar** todos los módulos y realizar **pruebas unitarias**.

**Requisitos:**
- Integrar funcionalidades en `DiscoForm`.
- Implementar pruebas con **JUnit** para:
  - La búsqueda.
  - La ordenación.
  - La adición y eliminación de canciones.

---

## 📥 Instalación y Ejecución
1. Clonar el repositorio:
    ```bash
    git clone https://github.com/tu-usuario/discoteca.git
    ```
2. Importar el proyecto en tu IDE (IntelliJ, Eclipse, etc.).
3. Configurar la conexión a la base de datos en `DatabaseConnection.java`.
4. Ejecutar el proyecto.

---

## 📝 Notas importantes:
- Asegúrate de utilizar **branches** para tus cambios (`git checkout -b nombre-del-alumno`).
- Realiza **Pull Requests** solo cuando hayas probado tu parte.
- Todos deben hacer **Code Review** antes de hacer merge en la rama principal.

---

## ❓ ¿Dudas?
Si tienes dudas sobre tu tarea, pregunta en el grupo de trabajo o revisa la documentación del proyecto.

---

¡Feliz codificación! 🚀
