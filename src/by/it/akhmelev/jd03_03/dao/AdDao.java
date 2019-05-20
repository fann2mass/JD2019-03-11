package by.it.akhmelev.jd03_03.dao;

import by.it.akhmelev.jd03_03.beans.Ad;

public class AdDao extends UniversalDAO<Ad> {
    public AdDao() {
        super(new Ad(), "ads");
    }
}
