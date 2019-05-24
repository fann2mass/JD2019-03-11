package by.it.akhmelev.project05.java;

import by.it.akhmelev.project05.java.beans.User;
import by.it.akhmelev.project05.java.dao.Dao;
import by.it.akhmelev.project05.java.utils.FormHelper;
import by.it.akhmelev.project05.java.utils.Validator;

import javax.servlet.http.HttpServletRequest;

public class CmdSignup extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {

        if (FormHelper.isPost(req)) {
            User user = new User(
                    0,
                    Validator.getString(req, "login", "[a-zA-Z0-9]{4,}"),
                    Validator.getString(req, "password"),
                    Validator.getString(req, "email"),
                    2
            );

            Dao dao = Dao.getDao();
            if (dao.user.create(user)) {
                return Actions.LOGIN.command;
            }
        }
        return null;
    }
}
