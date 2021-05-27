package oslomet.webprog;

public class Pakke {
    private String fornavn;
    private String etternavn;
    private String adresse;
    private String postnr;
    private String telefonnr;
    private String epost;
    private String volum;
    private String vekt;

    // konstruktører og get/set metoder er ikke nødvendig å kode


    public Pakke(String fornavn, String etternavn, String adresse, String postnr,
                 String telefonnr, String epost, String volum, String vekt) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.adresse = adresse;
        this.postnr = postnr;
        this.telefonnr = telefonnr;
        this.epost = epost;
        this.volum = volum;
        this.vekt = vekt;
    }

    public Pakke() {
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPostnr() {
        return postnr;
    }

    public void setPostnr(String postnr) {
        this.postnr = postnr;
    }

    public String getTelefonnr() {
        return telefonnr;
    }

    public void setTelefonnr(String telefonnr) {
        this.telefonnr = telefonnr;
    }

    public String getEpost() {
        return epost;
    }

    public void setEpost(String epost) {
        this.epost = epost;
    }

    public String getVolum() {
        return volum;
    }

    public void setVolum(String volum) {
        this.volum = volum;
    }

    public String getVekt() {
        return vekt;
    }

    public void setVekt(String vekt) {
        this.vekt = vekt;
    }
}
