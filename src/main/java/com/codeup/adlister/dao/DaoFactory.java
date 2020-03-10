package com.codeup.adlister.dao;
import com.codeup.adlister.util.Config;

public class DaoFactory {
    private static Contracts adsDao;
    private static Users usersDao;
    private static Config config = new Config();

    public static Contracts getContractsDao() {
        if (adsDao == null) {
            adsDao = new MySQLContractsDao(config);
        }
        return adsDao;
    }

    public static Users getUsersDao() {
        if (usersDao == null) {
            usersDao = new MySQLUsersDao(config);
        }
        return usersDao;
    }
}
