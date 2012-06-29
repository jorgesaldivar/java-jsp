package rmi;

import java.net.MalformedURLException;
import java.rmi.*;

public class cliente {

  public cliente(){}
public static String metodo(int a) throws NotBoundException, MalformedURLException{
String respuesta="s";
    try{
     Salida h = (Salida) Naming.lookup("pat");
	
     respuesta=h.getSalida(a);
	
      }
	catch (RemoteException re) {
      System.out.println("Exception in HelloImpl.main: " + re);
    }
    catch (MalformedURLException e) {
      System.out.println("MalformedURLException in HelloImpl.main: " + e);
    }
return respuesta;
}
  

  }


