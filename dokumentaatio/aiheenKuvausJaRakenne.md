**Aihe:** Kolmiuloitteinen 4x4x4-ristinollapeli. Tässä kahden pelaajan pelissä pelaajat merkitsevät vuorotellen itselleen jonkin 
peliruudun omaksi, minkä jälkeen ruutu pysyy hänelä pelin loppuun asti. Peli loppuu, kun jompi kumpi pelaajista saa neljän ruudun 
voittorivin. Peliin toteutetaan ehkä yksinpelimahdollisuus jonkinlaista tekoälyä vastaan.

**Käyttäjät:** pelaaja

**Pelaajan toiminnot:**
 * aloita peli  
 * laita pelimerkki ruutuun
 * lopeta peli

##Luokkakaavio
![kuva luokkakaaviosta](luokkakaavio4x4x4-ristinolla.png)

##Rakennekuvaus
Peli on ohjelman toiminnan tason toteuttava yleisluokka. Se säilöö kolmiulotteiseen taulukkoon pelin ruudut ja niihin pelatut ristit ja nollat. Luokassa peli hoitaa myös ruutujen täyttämisen ja vuorossa olevan pelaajan tietämisen ja sen, onko pelillä voittajaa. Voittaja saadaan selille voittorivi-olioiden avulla ja peliruutujen tunnistamisessa käytetään hyväksi vektori olioita. Peli käyttää voittorivigeneraattoria voittorivien alustamiseen.

Voittori-olio tietää aloitus paikkansa ja suunnan johon siitä jatketaan. Näiden perusteella se osaa kertoa kuuluuko ruutu siihen. Lisäksi voittorivi pitää kirjaa siinä olevien ristien ja nollien määrästä. Vektori-olio tallettaa kolmiulotteisen vektorin koordinaatit ja tarjoaa vektorien summan ja skalaaritulon.

##Sekvenssikaaviot
 - pelin aloittaminen
 ![sekvenssikaavio](AloitusSekvenssiKaavio.png)
 - pelimerkillä ruudun täyttäminen
 ![sekvenssikaavio](SekvenssiKaavio.png)
