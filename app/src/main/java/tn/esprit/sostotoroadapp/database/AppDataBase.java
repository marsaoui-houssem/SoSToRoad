package tn.esprit.sostotoroadapp.database;

import android.content.Context;


import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


import tn.esprit.sostotoroadapp.DAO.UserDAO;
import tn.esprit.sostotoroadapp.model.User;

@Database(entities = {User.class},version = 3,exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {
    private static AppDataBase instance;
    public abstract UserDAO userDAO();

    public static AppDataBase getAppDataBAse (Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),AppDataBase.class,"databasepersonne")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }


}