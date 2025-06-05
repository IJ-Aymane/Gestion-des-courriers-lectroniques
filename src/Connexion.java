import java.sql.*;

public class Connexion {

    private Connection con = null;
    private Statement stm = null;

    public Connexion(String server, String db_name, String user, String password) {
        try {
            // Charger le driver JDBC MySQL (nécessite mysql-connector-java dans les bibliothèques)
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("✔️ Chargement du driver réussi");

            // Construire l'URL de connexion
            String url = "jdbc:mysql://" + server + ":3306/" + db_name + "?useSSL=false&serverTimezone=UTC";

            // Établir la connexion
            con = DriverManager.getConnection(url, user, password);
            System.out.println("✔️ Connexion établie avec succès");

        } catch (ClassNotFoundException e) {
            System.out.println("❌ Driver JDBC non trouvé : " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("❌ Erreur SQL de connexion : " + e.getMessage());
        }
    }

    // Méthode pour INSERT / UPDATE / DELETE
    public int IUD(String sql) {
        try {
            stm = con.createStatement();
            return stm.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("❌ Erreur IUD : " + ex.getMessage());
        }
        return 0;
    }

    // Méthode pour SELECT
    public ResultSet Select(String sql) {
        try {
            stm = con.createStatement();
            return stm.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println("❌ Erreur SELECT : " + ex.getMessage());
        }
        return null;
    }

    // Fermer les ressources (sécurité mémoire)
    public void Fermeture_espaces() {
        try {
            if (stm != null) stm.close();
            if (con != null) con.close();
        } catch (SQLException ex) {
            System.out.println("❌ Erreur fermeture : " + ex.getMessage());
        }
    }
}
