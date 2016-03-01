**Kayttöohjeet**
Ajatuksena on ollut tehdä mahdollisimman selkeä ja intuitiivinen pelikello. Jos tänne on tarvinnut tulla, ollaan tavoitteessa hieman epäonnistuttu.

Alkuvalikossa on valittavissa kellojen määrä, minuuttien määrä, sekuntien määrä ja jokaiselle vuorolle lisättävä ajanmäärä sekunteissa(oletuksena nolla). Begin luo taulun kelloista, joiden aikaa voi yksittäin säätää lisäämällä tai poistamalla 15s. Start/Pause laittaa ensimmäisen kellon ajan kulumaan ja next antaa aina vuoron seuraavalle kellolle. 
Mikäli lisäaika/vuoro on vaihdettu nollasta johonkin muuhun sekunttimäärään, niin aina vuoron vaihtuessa aktiivinen kello saa halutun määrän sekuntteja lisää aikaa.

Hourglass 1v1 valinta alkuvalikossa huomioi ainoastaan minuuttien ja sekuntien määrän ja luo tiimalasin sen mukaan. Hourglass pelimuodossa aktiivisen pelaajan menettäessä aikaa, vastustaja saa hänen aikansa.
