package rmi;

import java.rmi.*;
import java.rmi.server.*;
import java.net.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server extends UnicastRemoteObject implements Salida {

  public Server() throws RemoteException {
    super();
	
  }
    String[] opciones={"Operacion realizada con exito", "Hubo fallas en el proceso"};

  public String getSalida(int valor) throws java.rmi.RemoteException{
  return opciones[valor];
  
  }

   
  public static void main(String args[]) {

    
	
    try {
	Registry registry = LocateRegistry.createRegistry( 1099 );
      Server h1 = new Server();
      Naming.rebind("pat", h1);
      System.out.println("Sistema escolar listo.");
    }
     catch (RemoteException re) {
      System.out.println("Exception in Casa.main: " + re);
    }
    catch (MalformedURLException e) {
      System.out.println("MalformedURLException in Casa.main: " + e);
    }

  }

}
