
import java.sql.*;
import java.util.*;
public class GestionMessage {
    private Connexion cnx;
    String req;
    public GestionMessage() {
        this.cnx=new Connexion("localhost", "gestion_courriers", "root", "2002");
    }

    public int Envoyer_MSG(Message M){
        req="insert into message(Adresse_exp,Sujet,Date_envoi,Contenu,Etat) values"
                + "('"+M.getAdresse_exp()+"','"+M.getSujet()+"','"+M.getDate_envoi()+"','"+M.getContenu()+"',0)";
        return this.cnx.IUD(req);
    }

    public int Supprimer_MSG(int id){
        req="delete from message where id="+id;
        return this.cnx.IUD(req);
    }

    public List<Message> Lister(){
        ResultSet RS;
        List<Message> LM=new ArrayList<>();
        req="select * from message";
        RS=this.cnx.Select(req);
        try{
            while(RS.next())
                LM.add(new Message(RS.getInt(1),RS.getString(2),RS.getString(3),RS.getString(4),RS.getString(5),RS.getInt(6)));
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return LM;
    }

    public List<Message> Msg_lus(){
        ResultSet RS;
        List<Message> LM=new ArrayList<>();
        req="select * from message where etat=1";
        RS=this.cnx.Select(req);
        try{
            while(RS.next())
                LM.add(new Message(RS.getInt(1),RS.getString(2),RS.getString(3),RS.getString(4),RS.getString(5),RS.getInt(6)));
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return LM;
    }

    public int Modifier_Etat(int id){
        req="update message set etat=1-etat where id="+id;
        return this.cnx.IUD(req);
    }

    public List<Message> Lister_Mois(int mois){
        ResultSet RS;
        List<Message> LM=new ArrayList<>();
        req="select * from message where month(str_to_date(Date_envoi,'%d/%m/%Y'))="+mois;
        RS=this.cnx.Select(req);
        try{
            while(RS.next())
                LM.add(new Message(RS.getInt(1),RS.getString(2),RS.getString(3),RS.getString(4),RS.getString(5),RS.getInt(6)));
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return LM;
    }

    public int Annee_Envoi(int id){
        ResultSet RS;
        req="select Year(str_to_date(Date_envoi,'%d/%m/%Y')) as annee from message where id="+id;
        RS=this.cnx.Select(req);
        try{
            if(RS.next())
                return RS.getInt(1);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return 0;
    }

    public int Supprimer_Msg_Lus(){
        req="delete from message where etat=1";
        return this.cnx.IUD(req);
    }

}
