package org.example.Classes;

import jakarta.servlet.http.HttpServletRequest;
import org.example.Model.Model;

public abstract class Command {
    protected Model model;
    protected HttpServletRequest request;
    protected Directory backup;
    public Command(Model model, HttpServletRequest request) {
        this.model = model;
        this.request = request;
    }
    protected void saveBackUp() {
        backup = model.getMainDirectory();
    }
    public void undo() {
        model.setMainDirectory(backup);
    }
    abstract void execute();
}
