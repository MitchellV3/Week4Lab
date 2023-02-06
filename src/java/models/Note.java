
package models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

/**
 *
 * @author Mitchell
 */
public class Note implements Serializable {

    private String title;
    
    private String body;
    
    public Note(){
        title = "";
        body = "";
    }
    
    public Note(String notePath) throws IOException {
        try (BufferedReader file = new BufferedReader(new FileReader(notePath))) {
            title = file.readLine();
            body = file.readLine();
        }
    }
    
    public Note(String title, String body, String notePath) throws IOException {
        PrintWriter file = new PrintWriter(new BufferedWriter(new FileWriter(notePath, false)));
        file.close();
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
