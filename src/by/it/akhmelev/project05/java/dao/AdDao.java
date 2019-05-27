package by.it.akhmelev.project05.java.dao;


import by.it.akhmelev.project05.java.beans.Ad;

/**
 * instance in singleton
 */
@SuppressWarnings("all")
public class AdDao extends UniversalDAO<Ad> {
    public AdDao() {
        super(new Ad(), "ads");
    }
}
