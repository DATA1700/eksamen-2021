package oslomet.webprog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.PreparedStatement;

@RestController
public class PakkeController {

    @Autowired
    private JdbcTemplate db;

    private Logger logger = LoggerFactory.getLogger(PakkeController.class);

    @PostMapping("/lagre")
    @Transactional
    public void lagreMelding(Pakke p) {
        String regex1 = "[a-zæøåA-ZÆØÅ .\\-]{2,50}";
        String regex2= "[0-9]{4}";
        boolean fornavnOK = p.getFornavn().matches(regex1);
        boolean etternavnOK = p.getEtternavn().matches(regex1);
        boolean postnrOK = p.getPostnr().matches(regex2);
        if(fornavnOK & etternavnOK && postnrOK) {
            String sql1 = "INSERT INTO kunde (Fornavn,Etternavn,Adresse,Postnr,Telefonnr,Epost)" +
                    " VALUES(?,?,?,?,?,?)";
            String sql2 = "INSERT INTO pakke (KID,Volum,Vekt) VALUES(?,?,?)";
            KeyHolder id = new GeneratedKeyHolder();
            try {
                db.update(con -> {
                    PreparedStatement par = con.prepareStatement(sql1, new String[]{"KId"});
                    par.setString(1, p.getFornavn());
                    par.setString(2, p.getEtternavn());
                    par.setString(3, p.getAdresse());
                    par.setString(4, p.getPostnr());
                    par.setString(5, p.getTelefonnr());
                    par.setString(6, p.getEpost());
                    return par;
                }, id);
                int kid = id.getKey().intValue();
                db.update(sql2, kid, p.getVolum(), p.getVekt());
            } catch (Exception e) {
                logger.error("Feil i lagre pakke! " + e);
            }
        }
        else{
            logger.error("Feil i input validering! ");
        }
    }
    @GetMapping("/sjekkPostnr")
    public boolean lagreMelding(String postnr) {
        String sql = "SELECT count(*) FROM Poststed WHERE postnr = ?";
        int etPostSted  = db.queryForObject(sql,Integer.class,postnr);
        if(etPostSted > 0){
            return true;
        }
        return false;
    }
}
