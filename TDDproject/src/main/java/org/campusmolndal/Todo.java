package org.campusmolndal;

import org.bson.Document;

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

    public static Todo fromDoc(Document doc){

        String _id=doc.getString("_id");
        String text=doc.getString("text");
        boolean done=doc.getBoolean("done");

        return new Todo (_id, text, done);
    }

    public Document toDoc() {
        Document doc = new Document();
        doc.append("_id", _id);
        doc.append("text", text);
        doc.append("done", done);
        return doc;
    }

    public String get_id() {
        return _id;
    }

    public String getText() {
        return text;
    }

    public boolean isDone() {
        return done;
    }

    public String toString() {
        return text + ", " + done + ", " + _id;
    }



}



