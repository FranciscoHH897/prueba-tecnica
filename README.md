Examen Teórico-Práctico de Java para Programadores Senior (Java 11 / Java 17)
Nombre: Francisco Hernandez Hernandez
 Fecha: 30/05/2025	
Sección 1: Preguntas Teóricas
1.	¿Cuál es la diferencia entre var y un tipo explícito en Java 11 y Java 17?
La palabra clave var permite declarar variables sin especificar el tipo directamente, ya que el compilador lo infiere automáticamente. No hay diferencias entre cómo funciona var en Java 11 y en Java 17, su comportamiento es el mismo. La diferencia principal es que en Java 17 se usa con más frecuencia.
2.	Explique la diferencia entre un Record y una Class tradicional en Java.
Un record es una estructura que representa una clase inmutable diseñada para contener datos, un record genera automáticamente métodos como el constructor, los accesores, y los métodos equals, hashCode y toString. Es ideal para estructuras simples de solo datos
3.	¿Qué es un sealed class en Java 17? ¿Cómo se usa y qué ventajas ofrece?
Una sealed class es una clase que restringe qué otras clases pueden heredarla. Esto permite tener un mayor control sobre las jerarquías de herencia, es útil para modelar jerarquías cerradas donde solo un conjunto específico de subclases está permitido.
4.	En Java 11, se introdujo la API HttpClient. Explica sus principales características. ¿Cómo se realiza una solicitud GET en un servidor usando la API HttpClient en Java 11?
HttpClient permite realizar solicitudes HTTP de forma más sencilla y moderna. Esta API facilita el manejo de solicitudes sin necesidad de bibliotecas externas y permite tanto llamadas síncronas como asíncronas
5.	¿Qué mejoras importantes introdujo Java 17 respecto a Java 11 en términos de rendimiento y nuevas características?
Introducción de records para simplificar la creación de clases inmutables.
Clases selladas (sealed classes) que controlan la herencia.
Mejoras de rendimiento como optimizaciones en el recolector de basura y reducción del consumo de memoria.
6.	En Java, ¿cuál es la diferencia entre HashMap y ConcurrentHashMap?
HashMap no está diseñada para usarse en entornos con múltiples hilos, ya que no es segura frente a la concurrencia, ConcurrentHashMap está diseñada para permitir múltiples accesos concurrentes, se recomienda usar HashMap en aplicaciones de un solo hilo y ConcurrentHashMap en aplicaciones multihilo o concurrentes.
7.	¿Cómo se implementan y gestionan los Streams en Java 11 y 17?
Los Streams permiten procesar colecciones de forma declarativa, facilitando operaciones como filtrado, transformación y agrupamiento. No hay diferencias en cómo se usan los Streams entre Java 11 y 17.
8.	Explica cómo funciona el sistema de módulos en Java 9 y su evolución hasta Java 17.
El sistema de módulos, introducido en Java 9 y vigente hasta Java 17, permite dividir una aplicación en partes más organizadas y controladas. Cada módulo puede especificar qué otros módulos requieren y qué paquetes expone.
9.	¿Qué es un Pattern Matching en Java 17 y cómo mejora la legibilidad del código?
El Pattern Matching en Java 17 permite simplificar expresiones, la comprobación de tipo con la declaración de variables en una sola línea. 
