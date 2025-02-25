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
- Implementar un método `closeConnection()` para cerrar la conexión.
- Probar la conexión con una consulta simple en el método `main()`.
- Asegurarse de que la conexión funciona en otros métodos de prueba.

**Integración con el proyecto:**  
Esta clase será utilizada en todas las demás clases DAO para obtener y cerrar conexiones a la base de datos.

**Puntos a Evaluar:**
- La conexión se establece correctamente.
- Las excepciones se manejan adecuadamente.
- El método es reutilizable en otras clases.

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
- Añadir validación para que `nombre` no esté vacío y `anio` sea positivo.
- Preparar la clase para ser utilizada en `AlbumDAO`.

**Integración con el proyecto:**  
- Esta clase se utilizará en `AlbumDAO` y en la selección de álbum al añadir una nueva canción.

**Puntos a Evaluar:**
- La estructura de la clase es correcta.
- El método `toString()` muestra la información adecuadamente.
- La encapsulación se implementa correctamente.

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
- Crear un **constructor** con todos los atributos.
- Implementar métodos `Getters`, `Setters` y `toString()`.
- Añadir validaciones:
  - `nombre` e `interprete` no pueden estar vacíos.
  - `duracion` debe estar en formato `hh:mm:ss`.
- Implementar `Comparable<Cancion>` para permitir la **ordenación por nombre**.

**Integración con el proyecto:**  
- Esta clase se utilizará en `CancionDAO` y para mostrar canciones en las listas.

**Puntos a Evaluar:**
- La implementación de `Comparable` es correcta.
- `toString()` muestra la información correctamente.
- La encapsulación está bien implementada.

---

## 4. AlbumDAO.java (Alumno 4)
**Objetivo:**  
Acceso a datos para `Album`.

**Requisitos:**
- Crear una clase `AlbumDAO`.
- Implementar los métodos:
  - `List<Album> getAllAlbums()`
  - `Album getAlbumById(int id)`
  - `int addAlbum(Album album)`
- Utilizar `DatabaseConnection` para obtener la conexión.
- Implementar validaciones para evitar duplicados en la base de datos.

**Integración con el proyecto:**  
- Esta clase se utiliza al seleccionar o crear un álbum en `ComboBox`.

**Puntos a Evaluar:**
- Las consultas SQL son correctas.
- El uso de `PreparedStatement` es seguro contra **SQL Injection**.
- Se manejan las excepciones de manera adecuada.

---

## 5. CancionDAO.java (Alumno 5)
**Objetivo:**  
Acceso a datos para `Cancion`.

**Requisitos:**
- Crear una clase `CancionDAO`.
- Implementar los métodos:
  - `List<Cancion> getAllCanciones()` — Obtener todas las canciones para mostrar en la lista principal.
  - `int addCancion(Cancion cancion)` — Añadir una nueva canción.
  - `void deleteCancion(int idCancion)` — Mover la canción a `canciones_eliminadas`.
- Utilizar `DatabaseConnection` para la conexión.
- Implementar lógica para mover canciones eliminadas a `canciones_eliminadas`.
- Evitar duplicados en `canciones_eliminadas`.
- **IMPORTANTE:** Verificar que la canción no exista ya en `canciones_eliminadas`.

**Integración con el proyecto:**  
- La lógica de mostrar, añadir y eliminar canciones se basa en esta clase.
- La eliminación de canciones actualiza automáticamente la lista en la interfaz gráfica.

**Puntos a Evaluar:**
- Las consultas SQL funcionan correctamente.
- La manipulación de datos es segura.
- Se manejan correctamente las excepciones.

---

## 6. BuscarCancionService.java (Alumno 6)
**Objetivo:**  
Implementar la **búsqueda de canciones** por nombre.

**Requisitos:**
- Crear una clase `BuscarCancionService`.
- Implementar el método:
    ```java
    public List<Cancion> buscarPorNombre(String query)
    ```
- La búsqueda debe ser **insensible a mayúsculas/minúsculas**.
- Utilizar `LIKE` en la consulta SQL para búsqueda parcial.
    ```sql
    SELECT * FROM canciones WHERE LOWER(nombre) LIKE LOWER('%query%')
    ```
- Mostrar resultados en el área de resultados (`textResultBuscar`).
- Si no hay resultados, mostrar un mensaje indicando "No se encontraron resultados".

**Integración con el proyecto:**  
- La búsqueda se activa al pulsar el botón `Buscar`.
- La lista de resultados se actualiza dinámicamente.

**Puntos a Evaluar:**
- La búsqueda devuelve resultados correctos.
- La consulta SQL es eficiente.
- Se maneja correctamente cuando no hay resultados.

---

## 7. OrdenarCancionService.java (Alumno 7)
**Objetivo:**  
Implementar la **ordenación de canciones**.

**Requisitos:**
- Crear una clase `OrdenarCancionService`.
- Implementar métodos:
  - `List<Cancion> ordenarPorNombre()` — Ordenar canciones alfabéticamente por nombre.
  - `List<Cancion> ordenarPorDuracion()` — Ordenar canciones por duración (ascendente).
  - `List<Cancion> ordenarPorAlbum()` — Ordenar canciones por nombre de álbum.
- Utilizar **Comparator** para realizar las comparaciones.
    ```java
    Collections.sort(lista, Comparator.comparing(Cancion::getNombre));
    ```
- Integrar la ordenación con el ComboBox `Ordenar por` y el botón `Ordenar`.
- Al ordenar, actualizar la lista de canciones mostrada en el `JList`.

**Integración con el proyecto:**  
- La ordenación se activa al seleccionar una opción en el ComboBox y pulsar el botón `Ordenar`.
- La lista de canciones se actualiza automáticamente.

**Puntos a Evaluar:**
- La ordenación es correcta en cada criterio.
- La integración con el ComboBox funciona sin errores.
- La interfaz de usuario se actualiza correctamente.

---

## 8. Validaciones.java (Alumno 8)
**Objetivo:**  
Implementar **validaciones de entrada** en el formulario de añadir canción.

**Requisitos:**
- Crear una clase `Validaciones`.
- Implementar métodos para validar:
  - `String validarNombre(String nombre)` — Debe ser obligatorio (no vacío).
  - `String validarInterprete(String interprete)` — Debe ser obligatorio (no vacío).
  - `Time validarDuracion(String duracion)` — Formato correcto `hh:mm:ss`.
  - `int validarAlbum(int albumId)` — Debe seleccionarse un álbum válido.
- Mostrar mensajes de error en un cuadro de diálogo (`JOptionPane.showMessageDialog()`).
- Evitar que se añadan canciones si alguna validación falla.

**Integración con el proyecto:**  
- Las validaciones se realizan antes de llamar a `addCancion()` en `CancionDAO`.
- Se muestran mensajes de error en caso de datos incorrectos.

**Puntos a Evaluar:**
- Las validaciones funcionan correctamente.
- Los mensajes de error son claros y específicos.
- La integridad de los datos se mantiene en la base de datos.

---

## 9. CancionEliminadaDAO.java (Alumno 9)
**Objetivo:**  
Gestionar las canciones eliminadas en la tabla `canciones_eliminadas`.

**Requisitos:**
- Crear una clase `CancionEliminadaDAO`.
- Implementar métodos:
  - `List<Cancion> getAllEliminadas()` — Obtener todas las canciones eliminadas.
  - `void restoreCancion(int id)` — Restaurar una canción a la lista principal.
  - `void deletePermanently(int id)` — Eliminar definitivamente una canción.
- Utilizar `DatabaseConnection` para obtener la conexión.
- Asegurarse de que una canción restaurada no aparezca en ambas listas.
- Implementar la lógica para actualizar la lista de canciones y la de eliminadas.

**Integración con el proyecto:**  
- La restauración se activa con un doble clic en la canción de la lista de eliminadas.
- La eliminación permanente se activa con el botón `Eliminar`.

**Puntos a Evaluar:**
- Las canciones se restauran correctamente.
- La eliminación permanente funciona sin errores.
- Las listas se actualizan automáticamente.

---

## 10. Integración del Proyecto (Alumno 10)
**Objetivo:**  
**Integrar** todos los módulos y clases en un único proyecto funcional.

**Requisitos:**
- Reunir todos los archivos de clases y DAO en un único proyecto.
- **Conectar** correctamente los métodos DAO con la interfaz gráfica.
- **Implementar la navegación**:
  - Al seleccionar `Albums` en el ComboBox de Tipo, mostrar la lista de Álbumes.
  - Al seleccionar `Canciones`, mostrar la lista de Canciones.
  - Al seleccionar `Canciones Eliminadas`, mostrar la lista de canciones eliminadas.
- Asegurarse de que los botones funcionan correctamente:
  - `Mostrar` actualiza la lista según la selección.
  - `Buscar` filtra la lista de Canciones.
  - `Ordenar` organiza la lista según el criterio seleccionado.
  - `Añadir` agrega una nueva canción usando `CancionDAO`.
  - `Quitar` mueve la canción seleccionada a `canciones_eliminadas`.
- **Validar** la interacción de todas las clases para evitar errores.

**Integración con el proyecto:**  
- Esta tarea conecta todas las funcionalidades en la interfaz gráfica.
- El alumno debe verificar que todas las acciones en la interfaz gráfica estén correctamente vinculadas a la lógica del proyecto.

**Puntos a Evaluar:**
- La integración se realiza sin errores.
- Todas las funciones están disponibles y funcionan correctamente.
- La navegación y actualización de listas es fluida y sin retrasos.

---

## 📥 Instalación y Ejecución
1. Clonar el repositorio:
    ```bash
    git clone https://github.com/SerkaFox/gestion-musica-discoteca.git
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
