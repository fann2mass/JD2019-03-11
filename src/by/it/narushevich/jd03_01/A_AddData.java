package by.it.narushevich.jd03_01;

import java.sql.SQLException;
import java.sql.Statement;

public class A_AddData {

    public static void createCollection(Statement statement) throws SQLException {

        statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `narushevich_a` DEFAULT CHARACTER SET utf8 ;");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS `narushevich_a`.`teatag` (\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `trademark` VARCHAR(45) NULL,\n" +
                "  `subtitle` VARCHAR(45) NULL,\n" +
                "  `country` VARCHAR(25) NULL,\n" +
                "  `material` VARCHAR(10) NULL,\n" +
                "  `width_x_height` VARCHAR(10) NULL,\n" +
                "  `in_collection_since` YEAR(4) NULL,\n" +
                "  `fk_users` int(11) NULL,\n" +
                "  PRIMARY KEY (`id`))\n" +
                "ENGINE = InnoDB;");
        statement.executeUpdate("insert into teatag(id, trademark, subtitle, country, " +
                "material, width_x_height, in_collection_since, fk_users)" +
                "values (default,'AHMAD TEA','English Tea #1','Belarus','cardboard','28 x 32',2017, 1)");
        statement.executeUpdate("insert into teatag(id, trademark, subtitle, country, " +
                "material, width_x_height, in_collection_since, fk_users)" +
                "values (default,'AHMAD TEA','Cinnamon Haze','Poland','cardboard','28 x 32',2018,1)");
        statement.executeUpdate("insert into teatag(id, trademark, subtitle, country, " +
                "material, width_x_height, in_collection_since, fk_users)" +
                "values (default,'AHMAD TEA','Earl Grey','Belarus','cardboard','28 x 32',2002,1)");
        statement.executeUpdate("insert into teatag(id, trademark, subtitle, country, " +
                "material, width_x_height, in_collection_since, fk_users)" +
                "values (default,'AHMAD TEA','Earl Grey','Belarus','cardboard','28 x 32',2005,1)");
        statement.executeUpdate("insert into teatag(id, trademark, subtitle, country, " +
                "material, width_x_height, in_collection_since, fk_users)" +
                "values (default,'AHMAD TEA','Green Tea','Belarus','cardboard','28 x 32',2008,1)");
        statement.executeUpdate("insert into teatag(id, trademark, subtitle, country, " +
                "material, width_x_height, in_collection_since, fk_users)" +
                "values (default,'AHMAD TEA','English Breakfast','Belarus','cardboard','28 x 32',2001,1)");
        statement.executeUpdate("insert into teatag(id, trademark, subtitle, country, " +
                "material, width_x_height, in_collection_since, fk_users)" +
                "values (default,'AHMAD TEA','English Breakfast','Belarus','cardboard','28 x 32',1998,1)");
        statement.executeUpdate("insert into teatag(id, trademark, subtitle, country, " +
                "material, width_x_height, in_collection_since, fk_users)" +
                "values (default,'AHMAD TEA','Lemon & Lime Twist','Poland','cardboard','28 x 32',2018,1)");
        statement.executeUpdate("insert into teatag(id, trademark, subtitle, country, " +
                "material, width_x_height, in_collection_since, fk_users)" +
                "values (default,'AHMAD TEA','Classic black tea','Belarus','cardboard','28 x 32',2013,1)");
        statement.executeUpdate("insert into teatag(id, trademark, subtitle, country, " +
                "material, width_x_height, in_collection_since, fk_users)" +
                "values (default,'Lipton','Yellow Label tea','Belarus','cardboard','28 x 32',2012,1)");
        statement.executeUpdate("insert into teatag(id, trademark, subtitle, country, " +
                "material, width_x_height, in_collection_since, fk_users)" +
                "values (default,'Lipton','Yellow Label tea','Belarus','cardboard','28 x 32',2005,1)");
        statement.executeUpdate("insert into teatag(id, trademark, subtitle, country, " +
                "material, width_x_height, in_collection_since, fk_users)" +
                "values (default,'Lipton','Royal Ceylon','Belarus','cardboard','28 x 32',2003,1)");
        statement.executeUpdate("insert into teatag(id, trademark, subtitle, country, " +
                "material, width_x_height, in_collection_since, fk_users)" +
                "values (default,'Lipton','A moment to energise','Poland','cardboard','26 x 28',2017,1)");
        statement.executeUpdate("insert into teatag(id, trademark, subtitle, country, " +
                "material, width_x_height, in_collection_since, fk_users)" +
                "values (default,'Lipton','A moment to balance','Poland','cardboard','26 x 28',2017,1)");
        statement.executeUpdate("insert into teatag(id, trademark, subtitle, country, " +
                "material, width_x_height, in_collection_since, fk_users)" +
                "values (default,'Lipton','pure black ceylon','Belarus','paper','22 x 22',2007,1)");
        statement.executeUpdate("insert into teatag(id, trademark, subtitle, country, " +
                "material, width_x_height, in_collection_since, fk_users)" +
                "values (default,'Lipton','cherry morello','Belarus','paper','22 x 22',2007,1)");
        statement.executeUpdate("insert into teatag(id, trademark, subtitle, country, " +
                "material, width_x_height, in_collection_since, fk_users)" +
                "values (default,'Lipton','pear chocolate','Belarus','paper','22 x 22',2007,1)");
        statement.executeUpdate("insert into teatag(id, trademark, subtitle, country, " +
                "material, width_x_height, in_collection_since, fk_users)" +
                "values (default,'Lipton','flirty lady','Belarus','paper','20 x 20',2015,1)");
        statement.executeUpdate("insert into teatag(id, trademark, subtitle, country, " +
                "material, width_x_height, in_collection_since, fk_users)" +
                "values (default,'Lipton','blue fruit','Belarus','paper','22 x 22',2011,1)");
        statement.executeUpdate("insert into teatag(id, trademark, subtitle, country, " +
                "material, width_x_height, in_collection_since, fk_users)" +
                "values (default,'Lipton','Orange Jaipur','Belarus','paper','22 x 22',2006,1)");
        statement.executeUpdate("insert into teatag(id, trademark, subtitle, country, " +
                "material, width_x_height, in_collection_since, fk_users)" +
                "values (default,'Jaf Tea','temptation','Belarus','cardboard','23 x 28',2001,1)");
        statement.executeUpdate("insert into teatag(id, trademark, subtitle, country, " +
                "material, width_x_height, in_collection_since, fk_users)" +
                "values (default,'Greenfield','finelly selected speciality tea','Belarus','paper','20 x 28',2003,1)");
        statement.executeUpdate("insert into teatag(id, trademark, subtitle, country, " +
                "material, width_x_height, in_collection_since, fk_users)" +
                "values (default,'Princess Java','black','Belarus','paper','20 x 28',2000,1)");
        statement.executeUpdate("insert into teatag(id, trademark, subtitle, country, " +
                "material, width_x_height, in_collection_since, fk_users)" +
                "values (default,'Natursan','La via del te firenze','Belarus','paper','20 x 28',2005,1)");
        statement.executeUpdate("insert into teatag(id, trademark, subtitle, country, " +
                "material, width_x_height, in_collection_since, fk_users)" +
                "values (default,'Mistral','Cristmas tea','Chech Republik','cardboard','23 x 28',2017,1)");
        statement.executeUpdate("insert into teatag(id, trademark, subtitle, country, " +
                "material, width_x_height, in_collection_since, fk_users)" +
                "values (default,'Chelton','100% pure ceylon tea','Belarus','cardboard','28 x 32',2003,1)");
        statement.executeUpdate("insert into teatag(id, trademark, subtitle, country, " +
                "material, width_x_height, in_collection_since, fk_users)" +
                "values (default,'Auchan','Black tea','Poland','cardboard','28 x 32',2018,1)");
        statement.executeUpdate("insert into teatag(id, trademark, subtitle, country, " +
                "material, width_x_height, in_collection_since, fk_users)" +
                "values (default,'Lipton','Russian Earl Grey','Russia','cardboard','25 x 30',2010,1)");
        statement.executeUpdate("insert into teatag(id, trademark, subtitle, country, " +
                "material, width_x_height, in_collection_since, fk_users)" +
                "values (default,'AKBAR','English breakfast','Belarus','cardboard','28 x 32',2007,1)");
        statement.executeUpdate("insert into teatag(id, trademark, subtitle, country, " +
                "material, width_x_height, in_collection_since, fk_users)" +
                "values (default,'AKBAR','flavoured tea','Belarus','cardboard','28 x 32',2011,1)");
        statement.executeUpdate("insert into teatag(id, trademark, subtitle, country, " +
                "material, width_x_height, in_collection_since, fk_users)" +
                "values (default,'Lord Nelson','>Lemon & Ginger','Poland','cardboard','28 x 32',2015,1)");
        statement.executeUpdate("insert into teatag(id, trademark, subtitle, country, " +
                "material, width_x_height, in_collection_since, fk_users)" +
                "values (default,'Forest of Arden','2006','France','paper','20 x 28',2008,2)");
        statement.executeUpdate("insert into teatag(id, trademark, subtitle, country, " +
                "material, width_x_height, in_collection_since, fk_users)" +
                "values (default,'Mabroc','1001 night','France','paper','20 x 28',2010,2)");
        statement.executeUpdate("insert into teatag(id, trademark, subtitle, country, " +
                "material, width_x_height, in_collection_since, fk_users)" +
                "values (default,'Maitre de The','Noir','France','paper','23 x 28',2002,2)");
        statement.executeUpdate("insert into teatag(id, trademark, subtitle, country, " +
                "material, width_x_height, in_collection_since, fk_users)" +
                "values (default,'Messmer','Zitrone','Germany','cardboard','28 x 32',2009,2)");
        statement.executeUpdate("insert into teatag(id, trademark, subtitle, country, " +
                "material, width_x_height, in_collection_since, fk_users)" +
                "values (default,'Kakoo','Green tea bags','Japan','paper','25 x 28',2010,2)");
        statement.executeUpdate("insert into teatag(id, trademark, subtitle, country, " +
                "material, width_x_height, in_collection_since, fk_users)" +
                "values (default,'Tea','green','South Korea','paper','20 x 20',2010,2)");
        statement.executeUpdate("insert into teatag(id, trademark, subtitle, country, " +
                "material, width_x_height, in_collection_since, fk_users)" +
                "values (default,'ALATTAR','black','Siria','paper','25 x 28',2010,2)");
        statement.executeUpdate("insert into teatag(id, trademark, subtitle, country, " +
                "material, width_x_height, in_collection_since, fk_users)" +
                "values (default,'Dilmah','Lychee','Russia','paper','20 x 28',2012,3)");
        statement.executeUpdate("insert into teatag(id, trademark, subtitle, country, " +
                "material, width_x_height, in_collection_since, fk_users)" +
                "values (default,'Dilmah','Earl Grey','Russia','paper','20 x 28',2012,2)");
        statement.executeUpdate("insert into teatag(id, trademark, subtitle, country, " +
                "material, width_x_height, in_collection_since, fk_users)" +
                "values (default,'Dilmah','Strawberry tea','Russia','paper','20 x 28',2012,2)");
        statement.executeUpdate("insert into teatag(id, trademark, subtitle, country, " +
                "material, width_x_height, in_collection_since, fk_users)" +
                "values (default,'Dilmah','Natural green tea','Russia','paper','20 x 28',2012,2)");
        statement.executeUpdate("insert into teatag(id, trademark, subtitle, country, " +
                "material, width_x_height, in_collection_since, fk_users)" +
                "values (default,'Pickwick','finest tea','Belarus','paper','25 x 30',2006,2)");
        statement.executeUpdate("insert into teatag(id, trademark, subtitle, country, " +
                "material, width_x_height, in_collection_since, fk_users)" +
                "values (default,'Malwa','smak natury','Poland','paper','20 x 28',2016,3)");
        statement.executeUpdate("insert into teatag(id, trademark, subtitle, country, " +
                "material, width_x_height, in_collection_since, fk_users)" +
                "values (default,'Brooke Bond','history','Russia','cardboard','28 x 32',2008,2)");
        statement.executeUpdate("insert into teatag(id, trademark, subtitle, country, " +
                "material, width_x_height, in_collection_since, fk_users)" +
                "values (default,'Brooke Bond','history','Russia','cardboard', '28 x 32',2008,2)");
        statement.executeUpdate("insert into teatag(id, trademark, subtitle, country, " +
                "material, width_x_height, in_collection_since, fk_users)" +
                "values (default,'Brooke Bond','history','Russia','cardboard','28 x 32',2009,2)");
        statement.executeUpdate("insert into teatag(id, trademark, subtitle, country, " +
                "material, width_x_height, in_collection_since, fk_users)" +
                "values (default,'Golden Bowl','strawberry','Russia','paper','25 x 28',2011,2)");
        statement.executeUpdate("insert into teatag(id, trademark, subtitle, country, " +
                "material, width_x_height, in_collection_since, fk_users)" +
                "values (default,'Golden Bowl','green tea','Russia','cardboard','26 x 28',2010,2)");
        statement.executeUpdate("insert into teatag(id, trademark, subtitle, country, " +
                "material, width_x_height, in_collection_since, fk_users)" +
                "values (default,'Golden Bowl','black tea','Russia','cardboard','28 x 32',2007,2)");
        statement.executeUpdate("insert into teatag(id, trademark, subtitle, country, " +
                "material, width_x_height, in_collection_since, fk_users)" +
                "values (default,'Golden Bowl','indian','Russia','cardboard','26 x 28',2010,2)");
    }
}
