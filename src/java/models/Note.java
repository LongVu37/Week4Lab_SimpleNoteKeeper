/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 * JavaBean Note Model.
 * 
 * @author asoula21
 */
public class Note {
    private String title;
    private String content;

    public Note() {
    }

    /**
     * Initialize a note object with the given parameters.
     * 
     * @param title      the title of the note
     * @param content    the contents of the note
     */
    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    /**
     * Returns the title of the note.
     * 
     * @return    the note title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Updates the note title.
     * 
     * @param title     the new title to be updated
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the contents within a note
     * @return    the note contents
     */
    public String getContent() {
        return content;
    }

    /**
     * Updates the note contents.
     * 
     * @param content    the content to be updated
     */
    public void setContent(String content) {
        this.content = content;
    }
}