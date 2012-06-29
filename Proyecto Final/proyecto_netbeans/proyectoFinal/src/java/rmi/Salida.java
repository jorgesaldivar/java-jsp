package rmi;

import java.rmi.*;

public interface Salida extends Remote {

  public String getSalida(int valor) throws java.rmi.RemoteException;

  
}
