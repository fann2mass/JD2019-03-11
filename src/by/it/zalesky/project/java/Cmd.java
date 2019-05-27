package by.it.zalesky.project.java;

import javax.servlet.http.HttpServletRequest;

abstract class Cmd {

    abstract Cmd execute(HttpServletRequest req) throws Exception;

    public String getJsp(){
        return "/"+this.toString()+".jsp";
    }

    @Override
    public String toString() {
        String nameCommand = this
                .getClass()
                .getSimpleName()
                .replace("Cmd", "")
                .toLowerCase();
        return nameCommand;
    }
}
