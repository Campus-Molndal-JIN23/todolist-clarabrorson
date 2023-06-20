package org.campusmolndal;

public class Todo {

    String _id;
    String text;
    boolean done;

    // skapa en konstruktor
    public Todo(String _id, String text, boolean done) {
        this._id = _id;
        this.text = text;
        this.done = done;
    }
 // Skapa getters och setters
    public String get_id() {
        return _id;
    }

    public String getText() {
        return text;
    }

    public boolean isDone() {
        return done;
    }

}



