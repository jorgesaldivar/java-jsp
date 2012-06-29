package Servlet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;
public class ParseFileExample {
public static void main(String[] args) {
try
{
 
//Archivo que contiene los datos (ajustar dependiendo del direcorio que utilice)

String strFile ="Candidatos.txt";


//create BufferedReader to read a file

BufferedReader br = new BufferedReader( new FileReader(strFile));
String strLine = "";
StringTokenizer st = null;
int lineNumber = 0;

//lectura del archivo considerando el separador |

while( (strLine = br.readLine()) != null)
{
  lineNumber++;
  st = new StringTokenizer(strLine, "|");
  //leer y desplegar los nombres
  String nombre=st.nextToken();
    System.out.println("Line # " + lineNumber +
", nombre=" + nombre);
}
}
catch(Exception e)
{
System.out.println("Exception while reading file: " + e);
}
}
}