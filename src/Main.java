

import java.util.*;
public class Main {


    public static void main(String[] args) {
        List<Message> LM;
        GestionMessage GM=new GestionMessage();
        // GM.Envoyer_MSG(new Message("kamili@uae.ac.ma", "TD BD", "2/5/2025", "Série de TD Numero 6", 0));
        //  GM.Envoyer_MSG(new Message("karami@ensi.ma", "Vacances", "30/04/2025", "Vacance premier Mai", 0));
        //GM.Modifier_Etat(5);
     /*  int annee=GM.Annee_Envoi(9);
       if(annee!=0)
           System.out.println("Année d'envo i: "+annee);
       else
           System.out.println("Message introuvable"); */
        GM.Supprimer_Msg_Lus();
        LM=GM.Lister();
        for(Message M:LM)
            System.out.println(M);


    }

}
