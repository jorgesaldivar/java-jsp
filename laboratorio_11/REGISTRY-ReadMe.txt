
Para facilitar la ejecución de servidores RMI en Netbeans se recomienda
agregar al servidor RMI la línea:


    Registry registry = LocateRegistry.createRegistry( 1099 );


Antes de intentar hacer Naming.bind ó naming.rebind

ESTO EVITA TENER QUE HACER EL COMANDO rmiregistry.