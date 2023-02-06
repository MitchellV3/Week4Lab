
package models;

import java.io.Serializable;

/**
 *
 * @author Mitchell
 */
public class Note implements Serializable {

    private String title;
    
    private String body;
    
    public Note() {
        title = "";
        body = "";
    }
    
    public Note(String title, String body) {
        this.title = title;
        this.body = body;
    } 
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    

}
