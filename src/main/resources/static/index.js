function regPakke() {
    const pakke = {
        fornavn : $("#fornavn").val(),
        etternavn : $("#etternavn").val(),
        adresse : $("#adresse").val(),
        postnr : $("#postnr").val(),
        telefonnr : $("#telefonnr").val(),
        epost : $("#epost").val(),
        volum : $("#volum").val(),
        vekt : $("#vekt").val()
    };

    // merk: må ha et kall til server her. det går ikke å bruke den vanlige validerPostnr() her, pga. asykrone kall
    const url = "/sjekkPostnr?postnr="+$("#postnr").val();
    $.get( url, function( OKPostnr ) {
        if(OKPostnr && validerFornavn() && validerEtternavn()){
            $.post("/lagre", pakke, function(){

            });
        }
    });
}


