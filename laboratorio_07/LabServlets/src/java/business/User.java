package business;

import java.util.ArrayList;

public class User
{
    private String name;
    private ArrayList languages = new ArrayList();
    
    public User()
    {}
    
    public User(String name, ArrayList languages)
    {
        this.name = name;
        this.languages = languages;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    { 
        return name; 
    }
 
    public void setLanguages(ArrayList  languages)
    {
        this.languages = languages;
    }

    public ArrayList getLanguages()
    { 
        return languages; 
    }
}
