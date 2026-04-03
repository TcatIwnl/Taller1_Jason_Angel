# Taller POO 1 - Registro de Actividades de Ocio

## Descripción del Proyecto
Este proyecto consiste en un sistema en Java que permite registrar, modificar, eliminar y analizar actividades de ocio realizadas por distintos usuarios.

El sistema funciona mediante lectura y escritura de archivos de texto (`Usuarios.txt` y `Registros.txt`), permitiendo guardar la información de manera permanente.

Se implementaron dos menús principales:
- Menú de usuario (gestión de actividades)
- Menú de análisis (estadísticas sobre actividades)

---

## Integrantes

- Angel Eduardo Olivares Flores  
  RUT: 22.338.590-7  
  GitHub: TcatIwnl

- Jason Alexander Tapia Castro  
  RUT: 22.382.028-K  
  GitHub: jtapia-code

---

## Estructura del Proyecto

- Paquete principal: `logica`
- Clase principal: `Main.java`

### Archivos utilizados:
- `Usuarios.txt`: almacena usuarios y contraseñas
- `Registros.txt`: almacena actividades registradas

### Arreglos principales:
- `usuariosId[]`
- `usuariosPass[]`
- `regUsuario[]`
- `regFecha[]`
- `regHoras[]`
- `regActividad[]`

---

## Funcionalidades

### Menú de Usuario:
- Registrar actividad
- Modificar actividad
- Eliminar actividad
- Cambiar contraseña

### Menú de Análisis:
- Actividad más realizada (global)
- Actividad más realizada por usuario
- Usuario con mayor procrastinación
- Ver todos los registros

---

## Instrucciones de Ejecución

1. Abrir el proyecto en Eclipse.
2. Asegurarse de que los archivos:
   - `Usuarios.txt`
   - `Registros.txt`
   estén en la raíz del proyecto.
3. Ejecutar la clase `Main.java`.
4. Ingresar credenciales válidas desde el archivo `Usuarios.txt`.
5. Utilizar los menús para interactuar con el sistema.

---

## Observaciones

- Se utilizaron arreglos en lugar de estructuras más avanzadas debido a las restricciones del taller.
- Los datos se guardan automáticamente en archivos de texto.
- Se implementaron validaciones para:
  - Formato de fecha (dd/mm/yyyy, febrero hasta 28)
  - Horas positivas
  - Actividad no vacía