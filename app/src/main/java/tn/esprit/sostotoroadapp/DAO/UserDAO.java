package tn.esprit.sostotoroadapp.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import tn.esprit.sostotoroadapp.model.User;

@Dao
public interface UserDAO {
    @Insert
    void insertUser(User user);

    @Query("SELECT * FROM user_table WHERE nameA = :name and passwordA = :password ")
    User LoginUser(String name,String password);

    @Query("SELECT * FROM user_table")
    List<User> getAll();
    @Query("SELECT * FROM user_table where flagt = 1")
    List<User> getAllfave();
    @Query("UPDATE user_table SET flagt = 1 WHERE id = :id")
    void updatefave(int id);
    @Query("UPDATE user_table SET statut = 1 WHERE id = :id")
    void updatestat(int id);
    @Query("SELECT * FROM user_table where statut = 1")
    List<User> getAllvalid();

}
