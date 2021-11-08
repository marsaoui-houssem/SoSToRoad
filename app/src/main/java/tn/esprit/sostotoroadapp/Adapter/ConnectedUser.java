package tn.esprit.sostotoroadapp.Adapter;

public class ConnectedUser {

    private String name;
    private String password;

    public ConnectedUser() {
    }

    public ConnectedUser(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
