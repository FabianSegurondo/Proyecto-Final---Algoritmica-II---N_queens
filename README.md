# Proyecto-Final: Algoritmica-II (N_queens)

## Contenido
- Integrantes
- Resumen
- Instalación
  
## Integrantes
- Nicole Góngora Rodríguez
- Fabian Segurondo Ferrel

## Resumen
Proyecto final de la materia de Algoritmica II, que soluciona el algoritmo de N queens, dadas 1 a 3 reinas iniciales. 
Este problema se resuelve con backtracking, y con límite de matriz 4-20 cuadrados, debido a la complejidad del problema al hallar todas las soluciones posibles

## Instalación
Si bien ha resultado la ejecución del código fuente en varias versiones de Eclipse, no podemos asegurar que funcione en todos los sistemas Operativos aparte de Windows 10 y con ciertas versiones fuera de una versión de Eclipse Juno proporcionada por la Universidad Privada Boliviana para las materias de Programación I y II.

- Descargar una versión zip de [Eclipse Juno](http://skynet.lp.upb.edu/alexis/progra1/eclipse.zip) proporcionada por la UPB.
- Descomprimir el programa en la carpeta de su elección con la ayuda de Winrar con su opción **Extraer**, colocando este formato: **_Disco:/carpeta/eclipse._** Ej: _D:/trabajos/eclipse_ (creará la carpeta _eclipse_ en el directorio _trabajos_)
- Una vez descomprimido el programa, vaya a **la misma dirección a la que transladó el contenido del zip de Eclipse**, y cree una carpeta llamada _"workspace"_. Esta será necesaria pra guardar los proyectos a realizar e importar en ella.
- Vaya al directorio _eclipse_ **_(en la dirección donde se descomprimió la carpeta)_**, entre en él y ejecute el programa _eclipse.exe_. 
- Como es la primera vez en la que se ejecuta la IDE, se le preguntará de donde quiere llevar los proyectos. Para esto, copie la dirección **_Disco:/carpeta/workspace._** (en la que creó el directorio _workspace_) y presione OK, para así configurar su entorno de trabajo.
- A continuación, cuando el programa abra, vaya a la opción **_Help->Install New Software_**, para instalar la extensión que permitirá ver los formatos de la interfaz gráfica del proyecto.
- En la pestaña de texto que dice **Work with:**, ingrese este link: Juno - http://download.eclipse.org/releases/juno para acceder a las librerías de complementos compatibles con esta versión de Eclipse.
- Los softwares disponibles aparecerán en grupos según su funcionalidad. Abra (no seleccione!) el conjunto **General Purpose Tools**, y haga check SÓLO en todos aquellos complementos que empiecen con **SWT** y **WindowBuilder**. Luego, presione Next dos veces, acepte los terminos de las Licencias afiliadas a ellos, y espere a que instalen los complementos. Posteriormente, se pedirá que reinicie la IDE, por lo que pulse en **Ok** y espere a que el programa ejecute de nuevo.
- A continuación, descargue o haga pull del contenido en el main de este repositorio, colocando lo obtenido en un directorio de su agrado.
- En Eclipse, haga click en **_File->Import->_General->Existing Proyects Into Workspace_**, presione OK, en **Select Root Directory** ponga la dirección en la que hizo pull o descarga (y descomprimido de zip) del repositorio, haga click en Enter, y seleccione el proyecto **Nqueens** que aparece en la ventana de proyectos, para poner luego **Finish** e importarlo totalmente
- El código estará ya importado y listo para ver...Sin embargo, es posible que en los archivos MenuMain.java y Nqueenframe.java dentro de la carpeta **src** no se vean sus opciones de _Source/Design_, las cuales cambian el modo de vista de la interfaz. De lo que quiera verlos, para cada uno de estos archivos, copie el código, borre el archivo, cree uno nuevo al hacer clic derecho en el paquete **(default package)**, y seleccionando **_New->Other->WindowBuilder->Swing Designer->JFrame_**, y dandole el nombre del archivo borrado **_de manera exacta a la anterior_**. Luego, pegue el código antes copiado, y esta vez las pestañas  _Source/Design_ deberían de aparecer al inferior de la ventana de algoritmo.
- Nota: Si hay lineas en el algoritmo que dan error, puede resolverlo mediante cambiar el JRE de entorno de Eclipse a 1.5, accediendo a **_Window->Preferences->Java,->Installed_JREs_**. Si no tiene el JDK 1.5 instalado en el entorno, hágalo [accediendo a este link](https://www.oracle.com/java/technologies/java-archive-javase5-downloads.html) (descargando el archivo *_Windows Offline Installation_* del grupo _Java SE Development Kit 5.0u22_, aceptando la licencia y creandote una cuenta temporal en Oracle para poder acceder al archivo, iniciar sesión y descargarlo), y en la ventana que hemos abierto anteriormente, pulse **_Add->Standard VM_** y en **_JRE Home_**, ingrese el directorio donde 
se hizo la descarga del JDK, y presionar OK. A continuación en la misma ventana de preferencias, vaya a **_Java->Compiler_** y ponga el Compiler Compliance Level en 1.5, pulse en *Apply*, salga con *Ok* y lo tendrá!
