/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author Alex
 */
public class UserDatos {
    private String type;
    private String status;
    private int hits;
    private int attempts;
    private int idUser;

    public UserDatos() {
        type = "";
        status = "";
        hits = 0;
        attempts = 0;
    }

    public UserDatos(String type, String status, int hits, int attempts, int idUser) {
        this.type = type;
        this.status = status;
        this.hits = hits;
        this.attempts = attempts;
        this.idUser = idUser;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }
    
    public int getId() {
        return idUser;
    }

    public void setId(int idUser) {
        this.idUser = idUser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}
