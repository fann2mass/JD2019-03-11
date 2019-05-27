package by.it.zalesky.jd03_03.dao;

import by.it.zalesky.jd03_03.beans.Roles;
import by.it.zalesky.jd03_03.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class RolesDao extends AbstractDao<Roles>{
    @Override
    public boolean create(Roles roles) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "INSERT INTO " +
                        "`roles`(`role`) " +
                        "VALUES ('%s')",
                roles.getRole()
        );
        long id = executeCreate(sql);
        if (id > 0)
            roles.setId(id);
        return id > 0;
    }

    @Override
    public boolean update(Roles roles) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `roles` " +
                        "SET `role`='%s' WHERE `id`=%d",
                roles.getRole(), roles.getId()
        );
        return executeUpdate(sql);
    }

    @Override
    public boolean delete(Roles roles) throws SQLException {
        String sql = String.format(Locale.ENGLISH, "DELETE FROM `roles` WHERE `id`=%d", roles.getId());
        return executeUpdate(sql);
    }

    @Override
    public Roles read(long id) throws SQLException {
        String where=String.format(" WHERE `id`='%d' LIMIT 0,1", id);
        List<Roles> roles = getAll(where);
        if (roles.size() == 1)
            return roles.get(0);
        else
            return null;
    }

    @Override
    public List<Roles> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<Roles> getAll(String where) throws SQLException {
        List<Roles> roles = new ArrayList<>();
        String sql = String.format(Locale.ENGLISH,
                "SELECT * FROM `roles` %s", where
        );

        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Roles role = new Roles(
                        resultSet.getLong("id"),
                        resultSet.getString("role")
                );

                roles.add(role);
            }
        }
        return roles;
    }
}
