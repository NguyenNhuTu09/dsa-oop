package com.example.DesignPatterns;

import java.util.Stack;

// 🧱 Các lớp chính:
// TextEditor: Originator, quản lý nội dung.

// EditorMemento: Memento, lưu trạng thái nội dung.

// History: Caretaker, lưu danh sách các memento.


// Memento
class EditorMemento {
    private final String content;

    public EditorMemento(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

// Originator
class TextEditor {
    private String content = "";

    public void type(String words) {
        content += words;
    }

    public EditorMemento save() {
        return new EditorMemento(content);
    }


    public void restore(EditorMemento memento) {
        content = memento.getContent();
    }

    public String getContent() {
        return content;
    }
}

// Caretaker
class History {
    private final Stack<EditorMemento> history = new Stack<>();

    public void save(EditorMemento memento) {
        history.push(memento);
    }

    public EditorMemento undo() {
        return history.pop();
    }
}
public class Memento {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        History history = new History();

        editor.type("Hello ");
        history.save(editor.save());

        editor.type("World!");
        history.save(editor.save());

        editor.type(" This is a mistake.");
        System.out.println("Before Undo: " + editor.getContent());

        // Undo
        editor.restore(history.undo());
        System.out.println("After Undo: " + editor.getContent());
    }
}
