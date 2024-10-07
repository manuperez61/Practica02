1.- Estará basada en el Modelo Vista Controlador.
1.1.- Un paquete para cada tipo de clases: modelo, vista y controlador.
2.- Modelo (aunque contiene la estructura de datos): clase Empleado basada en práctica anterior:
2.1.- Las empleados estarán enlazadas por un atributo, formando una lista.
2.2.- Las inserciones o creaciones de nuevos elementos pueden ir en cualquier lugar.
2.3.- Tendrá los atributos: inicial (al primer empleado) y actual (al empleado a mostrar)
2.4.- Otros atributos serán:
- Número de empleado: generado por el sistema de forma creciente desde
- Fecha de nacimiento, de tipo GregorianCalendar.
- Sueldo de tipo real.
- Sueldo máximo, de tipo real.
- Otro de libre elección.
Nota: esta misma clase servirá de estructura de datos, no puede usarse un vector, collection o similar,
aunque pude ser modificada para su mejora, por ejemplo, con un doble enlace.
3.- Vista: Aplicación gráfica manual para gestionar los Empleados. Con las siguientes clases:
3.1.- Un JFrame de tamaño fijo y no redimensionable.
3.2.- Un menú (con su clase)
3.3.- Dos paneles: ver y altas (dos 2 clases).
3.4.- Panel informativo sobre el autor o autores y la aplicación.
4.- JMenuBar.
4.1.- Permitirá el cambio de paneles.
4.2.- Tendrá un “Acerca de” que cargará el panel informativo.
5.- Panel Ver: para mostrar los empleados.
5.1.- Visualizar empleados uno a uno.
5.2.- Con los botones: primero, avanzar, retroceder y último.
5.3.- Jlabel y TextFiel.
6.- Panel Alta: Permitirá insertar un empleado en la lista.
6.1.- Con los botones: cancelar o borrar y aceptar.
6.2.- Con JLabel y TextFiel.
7.- Controlador: clase estática para el control de errores.
7.1.- Controlará que los campos introducidos sean correctos:
a) Fecha de nacimiento correcta y entre 1900 y 2015.
b) Sueldos correctos (números reales) y sueldo debe ser menor que el sueldo máximo.
7.2.- Cuando salte un error se mostrara con un JLabel rojo
