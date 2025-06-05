
public class Message {
    private int id,Etat;
    private String 	Adresse_exp,Sujet,Date_envoi,Contenu;

    public Message(int id, String Adresse_exp, String Sujet, String Date_envoi, String Contenu,int Etat) {
        this.id = id;
        this.Etat = Etat;
        this.Adresse_exp = Adresse_exp;
        this.Sujet = Sujet;
        this.Date_envoi = Date_envoi;
        this.Contenu = Contenu;
    }

    public Message(String Adresse_exp, String Sujet, String Date_envoi, String Contenu,int Etat) {
        this.Etat = Etat;
        this.Adresse_exp = Adresse_exp;
        this.Sujet = Sujet;
        this.Date_envoi = Date_envoi;
        this.Contenu = Contenu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEtat() {
        return Etat;
    }

    public void setEtat(int Etat) {
        this.Etat = Etat;
    }

    public String getAdresse_exp() {
        return Adresse_exp;
    }

    public void setAdresse_exp(String Adresse_exp) {
        this.Adresse_exp = Adresse_exp;
    }

    public String getSujet() {
        return Sujet;
    }

    public void setSujet(String Sujet) {
        this.Sujet = Sujet;
    }

    public String getDate_envoi() {
        return Date_envoi;
    }

    public void setDate_envoi(String Date_envoi) {
        this.Date_envoi = Date_envoi;
    }

    public String getContenu() {
        return Contenu;
    }

    public void setContenu(String Contenu) {
        this.Contenu = Contenu;
    }

    @Override
    public String toString() {
        return  "id=" + id + "\n Etat=" + Etat + "\n Adresse_exp=" + Adresse_exp + "\n Sujet=" + Sujet + "\n Date_envoi=" + Date_envoi + "\n Contenu=" + Contenu+"\n ----------------------------------------";
    }





}
