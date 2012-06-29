package business;

public class User
{
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String career;
    public User()
    {}
    
    public User(String firstName, String lastName, String emailAddress, String career)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
         this.career = career;
    }
    
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getFirstName()
    { 
        return firstName; 
    }
    
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getLastName()
    { 
        return lastName; 
    }
    
    public void setEmailAddress(String emailAddress)
    {
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress()
    { 
        return emailAddress; 
    }
    
     public void setCareer(String career)
    {
        this.firstName = career;
    }

    public String getCareer()
    { 
        return career; 
    }
}
