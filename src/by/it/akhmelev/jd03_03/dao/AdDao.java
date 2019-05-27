package by.it.akhmelev.jd03_03.dao;

import by.it.akhmelev.jd03_03.beans.Ad;

/**
 * instance in singleton
 */
@SuppressWarnings("all")
public class AdDao extends UniversalDAO<Ad> {
    public AdDao() {
        super(new Ad(), "ads");
    }
}
