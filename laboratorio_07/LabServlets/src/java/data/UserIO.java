package data;

import java.io.*;
import business.User;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class UserIO
{
    public static int add(User user, String filepath) throws IOException
    {
        File file = new File(filepath);
        
        
        //create BufferedReader to read a file

        BufferedReader br = new BufferedReader( new FileReader(file));
        String strLine = "";
        StringTokenizer st = null;
        //int lineNumber = 0;
        boolean yaExiste = false;

        //lectura del archivo considerando el separador |

        while( (strLine = br.readLine()) != null)
        {
        //lineNumber++;
        st = new StringTokenizer(strLine, "|");
        //leer y desplegar los nombres
        String nombre=st.nextToken();
        //    System.out.println("Line # " + lineNumber + ", nombre=" + nombre);
            
            if(user.getName().equals(nombre)){
                yaExiste = true;
                return 0;
            }
        }

        PrintWriter out = new PrintWriter(
                new FileWriter(file, true));
               
        out.print(user.getName());
        
        for(int i = 0;i < user.getLanguages().size();i++)
                out.print("|" + user.getLanguages().get(i));        
        out.println();
        out.close();
        return 1;
    }
    
       public static String search(String language, String filepath) throws IOException
    {
        
         File file = new File(filepath);
        
        
        //create BufferedReader to read a file
         String languageReturn ="";
        BufferedReader br = new BufferedReader( new FileReader(file));
        String strLine = "";
        StringTokenizer st = null;
        //int lineNumber = 0;
        
        //lectura del archivo considerando el separador |

        while( (strLine = br.readLine()) != null)
        {
        //lineNumber++;
        st = new StringTokenizer(strLine, "|");
        //leer y desplegar los nombres
        String nombre=st.nextToken();
        //    System.out.println("Line # " + lineNumber + ", nombre=" + nombre);
           if(strLine.contains(language)){
               languageReturn += nombre + "<br />";
           
           }
               
        }
        
        
        //System.out.println(languageReturn);
        return languageReturn;
    }
    
}
