**Aihe** Lautapelikello. Toteutetaan mm. lautapeleissä käytettävä kello, jolla voidaan rajoittaa, sekä hallita pelaajien ajankäyttöä. Yksinkertaisimmillaan tämä olisi monen pelaajan shakkikello, mutta lisäominaisuuksia kelloon voidaan lisätä valtavasti.

**Käyttäjät** Esim. lautapelien pelaajat eli ihmiset, joilla on tarve kontrolloida ryhmän ajankäyttöä

**Käyttäjän toiminnot** 
* Valittavissa on pelaajien lukumäärä
* ajanottotyyli
* ajanmäärä

**Luokkakaavio**
SwingUi on käyttöliittymä, joka vastaa muiden luokkien käynnistymisestä. Käyttöliittymän tärkein paneeli käyttävää cardlayouttia ja näkyvä card näyttää aina joko asetukset tai käytössä oleva kellon.

Itse logiikka tarvitsee ainoastaan tiedon Clockgroupista, johon kuuluu mikä sisältää listan SimpleTimereita. Logiikka antaa SimpleTimereille käskyjä loopin kuluessa käyttäjän painallukset huomioiden.

Yksittäinen SimpleTimer on yksinkertainen luokka joka tietää oman minuutti ja sekuntti määränsä ja sillä on useita metodeja näiden muokkaamiseksi. SimpleTimer on laajennus JTextFieldistä, joten kaikilla SimpleTimereilla on oma JTextField, jota ne osaavat päivittää.
![kaavio](chart.png)
![sekkaavio](sekvenssikaavio1.png)
![sekkaavio](sekvenssikaavio2.png)
