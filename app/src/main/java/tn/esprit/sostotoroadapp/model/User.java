package tn.esprit.sostotoroadapp.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName ="user_table" )
public class User {
    @PrimaryKey(autoGenerate = true)
    private int id ;
    @ColumnInfo(name = "nameA")
    private String name ;
    @ColumnInfo(name = "emailA")
    private String email ;
    @ColumnInfo(name = "adresseA")
    private String adresse ;
    @ColumnInfo(name = "phoneA")
    private String phone ;
    @ColumnInfo(name = "passwordA")
    private String password ;

    @ColumnInfo(name = "flagt")
    private boolean flag;
    @ColumnInfo(name = "statut")
    private boolean statut;
    public User() {
    }

    public User(int id, String name, String email, String adresse, String phone, String password, boolean flag,boolean statut) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.adresse = adresse;
        this.phone = phone;
        this.password = password;
        this.flag = flag;
        this.statut = statut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean isStatut() {
        return statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", adresse='" + adresse + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", flag=" + flag +
                '}';
    }
}