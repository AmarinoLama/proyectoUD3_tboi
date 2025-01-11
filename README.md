# PROYECTO UNIDAD 3 - TBOI

## Autores

- Aman Lama Vilariño
- Sergio Prieto García

## Índice

1. [Introducción](#1-introducción)
2. [Descripción de la base de datos](#2-descripción-de-la-base-de-datos)
3. [Estructura del código](#3-estructura-del-código)
4. [Supuesto](#4-supuesto)
5. [Diagrama clases_y_CFM](#5-diagrama-clases-y-CFM)
6. [Manual técnico para desarrolladores](#6-manual-técnico-para-desarrolladores)
7. [Manual de usuario](#7-manual-de-usuario)
8. [Reparto de tareas](#8-reparto-de-tareas)
9. [GitHub](#9-github)
10. [Extras](#10-extras)
11. [Propuestas de mejora](#11-propuestas-de-mejora)
12. [Conclusión](#12-conclusión)


## 1. Introducción

En este proyecto se realiza una BBDD sobre el juego TBOI (The Binging of Isaac) desarrollado por Edmund McMillen y Florian Himsl. El juego es un roguelike de acción y aventura con elementos de RPG. El jugador controla un personaje con el cuál a medida que va avanzando va consiguiendo objetos para mejorar sus estadísticas y habilidades.

Gracias a esta lógica hemos diseñado un menú con una selección de personajes con el cual podrás interactuar con los diferentes objetos que se encuentran en la base de datos para experimentar con las diferentes combinaciones de objetos y ver como afectan a las estadísticas del personaje.

## 2. Descripción de la base de datos

La base de datos cuenta con múltiples tablas donde estan todas girando entorno a los objetos y su especialización. En el juego la primera opción que realizas antes de empezar una partida es seleccionar un personaje por eso hemos diseñado una tabla con algunos de los personajes disponibles en el juego y sus estadísticas iniciales. A continuación como hemos decidido centrarnos en la relación de los personajes y objetos hemos creado una tabla objetos con una especialización en tres tipos:

- `Activo` : Son objetos que se activan con un botón y tienen un tiempo de recarga.


- `Pasivo` : Son objetos que modifican las estadísticas del personaje.


- `Consumible` : Son objetos que se utilizan una vez y tienen una duración finita.

Por otra parte, existe la relación de los objetos con los personajes, ya que cada personaje tiene una serie de objetos que le benefician más que a otros, gracias a esto podemos ver como afectan los objetos a las estadísticas de los personajes y van aumentando o disminuyendo conforme los objetos que este tenga. A causa de los objetos activos y consumibles hemos tenido que añadir un atributo que se llame fechaInsercion para controlar la última inserción de estos objetos para mostrarlos en el menú principal.

Cada objeto pertenece a una Pool que es una categoría de objetos que se pueden encontrar en el juego, por ejemplo, la pool de objetos de la sala del tesoro, la pool de objetos de la sala de jefes, etc. Estas pools son importantes ya que en el juego se pueden encontrar objetos en diferentes salas y cada sala tiene una pool de objetos asignada. Eso significa que si encuentras un objeto en una sala de jefes no podrás encontrarlo en una sala de tesoro. Por lo que para desarrollar esta lógica hemos decidido crear dos tablas la de pools, donde se recolecta el nombre de la pool y la habitación donde esta se encuentra.

Finalmente, debido a que los objetos pueden aparecer en múltiples pools hemos tenido que diseñar la relación de muchos a muchos entre objetos y pools. Para ello hemos creado una tabla intermedia que se llama objetos_pools donde se relacionan los objetos con las pools.

En resumen, la base de datos cuenta con las siguientes tablas:

- `Personajes` : Tabla con los personajes del juego y sus estadísticas iniciales.


- `Objetos` : Tabla con los objetos del juego y su especialización.
  - `Activo` : Objetos que se activan con un botón y tienen un tiempo de recarga.
  - `Pasivo` : Objetos que modifican las estadísticas del personaje.
  - `Consumible` : Objetos que se utilizan una vez y tienen una duración finita.


- `Pools` : Tabla con las pools de objetos del juego.


- `Habitaciones` : Tabla con las habitaciones del juego.


- `Objetos_pools` : Tabla intermedia que relaciona los objetos con las pools.


- `Personajes_objetos` : Tabla intermedia que relaciona los personajes con los objetos.

y estás son el número de relaciones de cada tipo:

- `N:M` : Existen dos relaciones de muchos a muchos **pool_objetos** y **personajes_objetos**.


- `N:1` : Existen cuatro relaciones de uno a muchos la especialización de objetos **activo**, **pasivo** y **consumible** y la relación de habitaciones y pools.


- `1:1` : Existe una relación de uno a uno entre los objetos de cada tipo (activo, pasivo y consumible) y la tabla de objetos.

Finalmente esta es una representación visual de la base de datos:

![diagramaBBDD.png](src%2Fmain%2Fresources%2Fimg%2Freadme%2FdiagramaBBDD.png)

## 3. Estructura del código

El código se ha ido creando con los patrones MVC y DAO. En el controlador están todos los controllers de cada fichero FXML, en el modelo están todas las clases que representan las tablas de la base de datos dentro de la carpeta Entity y en la carpeta DAO están todas las clases que se encargan de realizar las operaciones con la base de datos. Por otra parte, en la carpeta View está la clase que se encarga de gestionar las ventanas emergentes que se muestran en la aplicación.

En cuanto al CRUD que se ha implementado en la aplicación se ha aplicado sobre las clases Personaje y Personaje Objeto de forma incompleta ya que no se ha implementado la parte de actualización de los datos. Por otra parte, en la clase de consumibles se ha diseñado un crud completo con la posibilidad de añadir, eliminar y modificar los consumibles de la base de datos. No hemos podido hacer el CRUD completo en las dos primeras clases mencionadas debido a que no planteamos la aplicación para que se puedan modificar los personajes y los objetos que este tiene en su inventario.

Cabe destacar que la creación de una relación entre Personaje y Objeto se ha partido en dos, esto quiere hacer que primero se crea la relación con las dos id y después se le añade la fecha de inserción mediante un update para usar más

Finalmente, respecto a las querys en JPSQL se han realizado las siguientes querys:

- `Tipos objetos` : Se han hecho 4 querys para seleccionar objetos de cada tipo (activo, pasivo, consumible) y todos los objetos.


- `Habitaciones` : Se ha realizado una query multiuso (sirve para cada tipo de habitación) para seleccionar las habitaciones de la base de datos.


- `Inventario` : Se han diseñado tres querys distintas para cargar todos los objetos del inventario y para cargar el último objeto activo y consumible.


- `Personajes` : Se ha realizado una query para cargar el personaje seleccionado en el menú principal.


- `Consumible` : Se ha realizado tres querys para cargar los datos con el nombre, para comprobar si existe un consumible y para ver si el consumible está en el inventario.

A continuación se muestra una imagen de la estructura de carpetas del proyecto:

![estructuraCarpetas.png](src%2Fmain%2Fresources%2Fimg%2Freadme%2FestructuraCarpetas.png)

## 4. Supuesto

Para usar esta aplicación debes seleccionar un personaje entre los ocho que hay para elegir y darle a aceptar, una vez seleccionado se te abrirá un menú con todos los objetos existentes para añadir o quitar de tu inventario. 

Este menú está organizado de la siguiente forma:

![menuPrincipal.png](src%2Fmain%2Fresources%2Fimg%2Freadme%2FmenuPrincipal.png)

Tiene esta estructura para que se asemeje a una partida cualquiera en el juego normal, el cual tiene la siguiente estructura:

![partidaIsaac.png](src%2Fmain%2Fresources%2Fimg%2Freadme%2FpartidaIsaac.png)

Como se puede apreciar a la izquierda aparecen las estadísticas, arriba a la izquierda se encuentra el objeto activo junto a sus cargas. Por otra parte en el lado derecho se encuentran los objetos del inventario y finalemtne en la parte inferior se encuentran el consumible.

Después de entender la lógica de la estructura del menú principal puedes empezar a añadir objetos a tu inventario y ver como afectan a las estadísticas de tu personaje. Para ello debes seleccionar un objeto y darle a añadir, si quieres quitar un objeto debes seleccionar el objeto y darle a quitar. Si seleccionas un activo aparecerá en su lugar correspondiente al igual que el consumible. En cambio si seleccionas un pasivo verás como se actualizan las estadísticas del personaje, si intenas sacar un objeto te darás cuenta de que las estadísticas no se modifican, ya que en el juego las estadísticas nunca pueden bajar.

Si estás interesado en ver los objetos de las diferentes pools puedes seleccionar la opción de habitaciones y verás una lista con todas las habitaciones existentes en el juego. Si seleccionas una habitación verás una lista con todos los objetos que pertenecen a esa habitación.

Por otra parte, si quieres interactuar con la creación, modificación y eliminación de consumibles puedes seleccionar la opción de consumibles y verás una lista con todos los consumibles existentes en la base de datos. Si quieres añadir un consumible debes seleccionar la opción de añadir y rellenar los campos correspondientes. Si quieres eliminar un consumible debes copiar su nombre y comprobar que existe para borrarlo y si deseas modificarlo deberás hacer lo mismo pero para comprobar que existe debes usar la lupa para que cargue sus datos en el caso de que este exista.

Finalmente, quieres cambiar de personaje puedes seleccionar la opción de personajes y seleccionar otro personaje para ver como cambian las estadísticas de este. Al presionar ese botón, se borrará el personaje actual y su inventario para poder seleccionar otro personaje.

## 5. Diagrama clases y CFM

En la siguiente imagen se puede apreciar el diagrama de CFM:

![Diagrama CFM](./images/CFM.png)

Este diagrama muestra la relación entre las clases de la aplicación y como se relacionan entre ellas. La explicación de la bbdd se encuentra en el apartado 2.

Los atributos de cada tabla se mostrarán a continuación:

- Personajes
  - Id
  - Nombre
  - Descripción
  - SaludBase
  - DanoBase
  

- Objeto
  - Id
  - Nombre
  - Efecto
  - Tipo


- Objeto Pasivo
    - mejoraDano
    - mejoraSalud
    - mejoraVelocidad
    - mejoraLagrimas
    - mejoraRango
    - mejoraVelocidadLagrimas
    - mejoraSuerte


- Objeto Activo
    - tiempoRecarga


- Objeto Consumible
    - duracion


- Personaje_Objeto
    - Id
    - PersonajeId
    - ObjetoId
    - FechaInsercion


- Objeto_Pool
    - Id
    - ObjetoId
    - PoolId


- Pool
    - Id
    - Nombre
    - Habitacion


- Habitacion
    - Id
    - Nombre
    - TipoHabitacion
  

En la siguiente imagen se puede apreciar el diagrama de clases:

![diagramaClases.png](src%2Fmain%2Fresources%2Fimg%2Freadme%2FdiagramaClases.png)

Como se puede apreciar todas las clases giran entorno a los controladores de los fxml, estos así mismo llaman a las clases DAO que se encargan de realizar las operaciones con la base de datos. Por otra parte, las clases Entity son las que representan las tablas de la base de datos y se encargan de almacenar los datos de la base de datos.

Por otra parte cuando se lanza algún error se llama a la clase Alertas que se encarga de mostrar los mensajes de error en la aplicación.

Finalemente están las clases de Entity que se encargan de representar las tablas de la base de datos y almacenar sus respectivos datos, como son tantas clases se ha decidido no mostrarlas en la imagen. Estas clases se pueden ver de una forma más clara en el anterior diagrama de CFM.

## 6. Manual técnico para desarrolladores

Para poder ejecutar la aplicación es necesario tener instalado Java 11 y Maven. Una vez que se tengan estas dos herramientas se debe clonar el repositorio y abrirlo con un IDE que soporte Java. Para realizar esta acción deberás abrir la terminal y escribir el siguiente comando:

```bash
mkdir proyectoUD3_tboi
```

Para crear la carpeta donde se guardará el proyecto.

```bash
cd proyectoUD3_tboi
```

Para entrar en la carpeta que acabamos de crear.

```bash
git clone https://github.com/AmarinoLama/proyectoUD3_tboi.git
```

Para clonar el repositorio en la carpeta que acabamos de crear.

A continuación deberemos instalar MySQL y ejecutar el script que se encuentra en la carpeta `src/main/resources/bbddIsaac.sql` para crear la base de datos e insertar los datos. Una vez que se haya creado la base de datos deberemos modificar el archivo `persistence.xml` que se encuentra en la carpeta `src/main/resources/META-INF` y cambiar el puerto por el que uses en tu ordenador, junto a la contraseña y el usuario.

Una vez realizado todo esto ya tendremos nuestro proyecto en nuestro ordenador y podremos abrirlo con nuestro IDE. Para ejecutar la aplicación deberemos abrir el archivo `Main.java` y ejecutarlo. Una vez que se haya ejecutado la aplicación se abrirá una ventana con la selección de personajes y podremos empezar a interactuar con la aplicación.

## 7. Manual de usuario

En este apartado hemos realizado un video tutorial para que se vea todo más claro:

[Video tutorial](https://youtu.be/1Q6J9Z9Z9Z4)

## 8. Reparto de tareas

El reparto de tareas se ha realizado de la siguiente forma, Sergio se ha centrado más en el CRUD de todo la obtención de los datos para cargar las tablas y de los casos test y Aman se ha centrado en utilizar los controllers de forma correcta, hacer el README y las consultas JPQL (algunas de ellas).

A continuación se muestra una tabla con el reparto de tareas:

### **Tareas Sergio**

- Crear personajes (Isaac, Magdalena, Caín, Judas, ???, Eva, Sansón, Azazel).
- Comprobar las tablas para verificar si hay errores.
- Modificar clase de objetos para que gestione las estadísticas que mejoran:
  - 👞 Velocidad
  - ⚔ Daño
  - 💧 Lágrimas
  - 🏹 Alcance
  - 💦 Velocidad de proyectil
  - 🍀 Suerte
  - ❤ Vida
- Actualizar personajes para cambiar el daño inicial por un multiplicador inicial.
- Crear CRUD de personajes.
- Crear items.
- Eliminar personaje al cambiar de personaje.
- Crear query para obtener el último personaje activo.
- Crear query para obtener el último consumible.
- Crear CRUD del objeto consumible.
- Realizar pruebas con JUnit
- Diseñar la estructura de DAO
- Revisar las clases generadas por el IDE
- Crear algunas querys JPQL

### **Tareas Aman**

- Crear menú de personajes.
- Asignar botones y llamar a funciones con el nombre correspondiente.
- Diseñar un menú de estadísticas básico con los siguientes parámetros:
  - 👞 Velocidad
  - ⚔ Daño
  - 💧 Lágrimas
  - 🏹 Alcance
  - 💦 Velocidad de proyectil
  - 🍀 Suerte
  - ❤ Vida
- Añadir botones para agregar y quitar objetos, junto con un combobox para seleccionar el tipo de habitación.
- Implementar filtrado por "pool" y añadir un botón para este propósito.
- Mostrar los items seleccionados al lado de la tabla.
- Cargar la tabla de objetos y mostrar sus estadísticas junto con el nombre y descripción.
- Vincular los botones de añadir y eliminar objetos con la tabla correspondiente:
  - Pasivos en la tabla principal.
  - Activos en la parte superior.
  - Consumibles en la parte inferior.
- Cargar datos seleccionados en el inventario.
- Realizar una query compleja para obtener objetos relacionados con "objetoPool" y asignar habitaciones según su nombre.
- Añadir una columna en las tablas `objetosActivo` y `objetosConsumible` para mostrar la fecha de inserción.
- Diseñar un submenú para crear y borrar objetos.
- Implementar un sistema de actualización con asignación de tiempo.
- Revisar y crear los mensajes emergentes.
- Optimizar el código eliminando métodos innecesarios.

## 9. GitHub

El enlace al repositorio de GitHub es el siguiente:

[Repositorio GitHub](https://github.com/AmarinoLama/proyectoUD3_tboi.git)

Hemos utilizado dos ramas, la rama main y la rama dev. En la rama main se encuentra la versión final de la aplicación y en la rama dev se encuentra la versión de desarrollo de la aplicación. Hemos usado ambas ramas para el desarrollo de la aplicación y para la entrega final.

No necesitamos más ramas ya que hemos trabajado en conjunto y hemos ido subiendo los cambios a la rama dev para que el otro pudiera ver los cambios realizados. Una vez que hemos terminado de realizar los cambios hemos subido los cambios a la rama main para que se vea la versión final de la aplicación.

## 10. Extras

Hemos realizado los extras de usar JavaFX en nuestro proyecto y realizar casos test con JUnit. En cuanto a JavaFX hemos realizado una interfaz gráfica que simula el menú de selección de personajes y objetos del juego The Binding of Isaac. Por otra parte, en cuanto a los casos test hemos realizado una serie de casos test para comprobar que las querys JPQL funcionan a la perfección y que los métodos de las clases DAO funcionan correctamente.

## 11. Propuestas de mejora

Algunas de las propuestas de mejora son las siguientes:

- Añadir un sistema de guardado de partidas.
- Implementar el CRUD de todos los tipos de objetos.
- Cargar las stats iniciales y los objetos iniciales de cada personaje.
- Guardar en un JSON los personajes y su información correspondiente.
- Cargar más personajes.
- Poder cargar la última partida.
- Añadir más objetos y pools.

## 12. Conclusión

En conclusión, hemos realizado una aplicación que simula el menú de selección de personajes y objetos del juego The Binding of Isaac. Hemos creado una base de datos con las tablas necesarias para almacenar los datos de los personajes y objetos y hemos creado una aplicación que interactúa con la base de datos para mostrar los datos en una interfaz gráfica. 

Hemos implementado un CRUD completo para los consumibles y un CRUD incompleto para los personajes y objetos. Hemos realizado una serie de querys JPQL para obtener los datos de la base de datos y hemos implementado un sistema de alertas para mostrar los errores en la aplicación.

Cabe destacar, que nos ha llevado mucho tiempo el hecho de cargar los datos en la tabla y nos ha limitado en ciertos aspectos, ya que solo nos permitía mostrar un tipo objeto al mismo tiempo y no podíamos usar inner joins para cargar las pools.

Dado que es el tercer proyecto que realizamos ya estamos más sueltos con nuestra creatividad y el control de javaFX y bases de datos, aunque todavía nos queda mucho por aprender y mejorar.

Por último, le hemos dedicado unas 45 horas entre ambos para realizar este proyecto y creemos que nuestra nota es de un 8'25.