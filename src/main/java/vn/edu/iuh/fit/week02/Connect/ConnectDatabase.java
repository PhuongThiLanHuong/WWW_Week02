package vn.edu.iuh.fit.week02.Connect;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnectDatabase {
   private static ConnectDatabase instance;
    private EntityManagerFactory emf;

    private ConnectDatabase()
    {

        emf= Persistence.createEntityManagerFactory("week02");
    }
    public EntityManagerFactory getEmf()
    {
        return emf;
    }
    public static ConnectDatabase getInstance()
    {
        if(instance==null)
            instance=new ConnectDatabase();
        return instance;
    }
}
