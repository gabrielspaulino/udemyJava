package entities;

public class Aluguel {

    String name;
    String email;
    int room;

    public Aluguel(String name, String email, int room) {
        this.name = name;
        this.email = email;
        this.room = room;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getRoom() {
        return room;
    }
    
    public String toString(){
        return room + ": " + name + ", " + email;
    } 
}