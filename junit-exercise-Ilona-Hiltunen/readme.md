# Yksikkötestaus JUnit-työkalulla

Tämä repositorio sisältää Java-harjoituksia, joiden avulla harjoittelet yksikkötestausta [JUnit-työkalun](https://junit.org) avustuksella.

Aikaisemmista tehtävistä poiketen tässä tehtävässä ei ole valmiita testejä, vaan kirjoitat testit itse. Testattava Java-luokka sen sijaan on annettuna valmiina.

Voit suorittaa testisi joko koodieditorisi testaustyökalulla ([VS Code](https://code.visualstudio.com/docs/java/java-testing), [Eclipse](https://www.vogella.com/tutorials/JUnitEclipse/article.html)) tai [Gradle-automaatiotyökalulla](https://docs.gradle.org/current/userguide/java_testing.html).


## Tehtävän aloittaminen

Aloita kloonaamalla Git-repositorio omalle koneellesi. Harjoitus täytyy tehdä omassa kopiossasi, eli varmista, että repositorion osoitteessa on mukana oma GitHub-käyttäjätunnuksesi! Oman kopiosi saat luotua kurssitoteutuksesi tehtävänannon GitHub classroom -linkin kautta.

```sh
git clone https://github.com/varmista-etta-github-tunnuksesi-on-repositorion-osoitteessa.git
```

Kloonattuasi projektin omalle koneellesi, avaa se koodieditorissasi.


## Vastausten lähettäminen

Kun olet saanut osan tai kaikki tehtävistä ratkaistua ja commitoinut vastauksesi, lähetä ratkaisut arvioitavaksi `git push`-komennolla. Git push käynnistää automaattisesti GitHub actions -workflow:n, joka kääntää sekä testaa ratkaisusi ja antaa jokaisesta testistä joko hyväksytyn tai hylätyn tuloksen.

Kun GitHub Actions on saanut koodisi suoritettua, näet tuloksen GitHub-repositoriosi [Actions-välilehdellä](../../actions/workflows/classroom.yml). Arvioinnin valmistumiseen menee tyypillisesti pari minuuttia.

Klikkaamalla yllä olevan linkin takaa viimeisintä *"GitHub Classroom Workflow"* -suoritusta, saat tarkemmat tiedot tehtävän arvioinnista. Sivun alaosassa näkyy saamasi pisteet. Klikkaamalla "Autograding"-otsikkoa pääset katsomaan tarkemmin arvioinnissa suoritetut vaiheet ja niiden tulokset. Kuvitetun ohjeen aiheesta löydät GitHubin dokumentista [View autograding results (github.com)](https://docs.github.com/en/education/manage-coursework-with-github-classroom/learn-with-github-classroom/view-autograding-results).

💡 *Voit lähettää ratkaisusi arvioitavaksi niin monta kertaa kuin on tarpeen tehtävän määräaikaan asti. Varmista kuitenkin, että viimeisin suoritus tuottaa parhaat pisteet, koska vain viimeisimmät pisteet jäävät voimaan.*


## Tehtävä

Tässä tehtävässä sinun tulee kirjoittaa yksikkötestejä valmiille `PriceFormatter`-luokalle ja siellä olevalle `formatPrice`-metodille. Metodi saa parametrinaan liukuluvun ja se palauttaa sen merkkijonoksi muotoiltuna tiettyjen sääntöjen mukaisesti. Metodin kutsuminen onnistuu esim. seuraavasti:

```java
PriceFormatter formatter = new PriceFormatter();
String price = formatter.formatPrice(3.141592653589793); // Palauttaa "3,14 €"
```

Perustapauksessa metodin pitäisi muotoilla annettu liukuluku muotoon `"123 456,79 €"`. Muotoilun suhteen on seuraavat tarkentavat säännöt:

1. Tuhaterottimena on välilyönti.
1. Desimaalierottimena on pilkku.
1. Desimaaliosa on kahden numeron pituinen, seuraavin tarkennuksin:
    1. Desimaaliosa pyöristetään lähimpään sadasosaan (eli senttiin).
    1. Jos desimaaliosa on pyöristyksen jälkeen nolla, jätetään desimaaliosa kokonaan pois.
1. Hinnan lopussa on Euro-symboli `€`.

**Huomaa, että sinun ei tarvitse itse toteuttaa yllä esitettyä metodia tai siihen kuuluvia ehtoja.** Metodin toteuttamisen sijasta harjoittelemme valmiin metodin *testaamista*.


### Osa 1: JUnit-testien kirjoittaminen *(perusteet, 25 %)*

Toteuta tehtäväpohjan [PriceFormatterTest](./src/test/java/exercise/PriceFormatterTest.java)-luokkaan omat yksikkötestit, jotka varmistavat eri syötteiden avulla, että valmis `formatPrice`-metodi toimii edellä kuvatulla tavalla. Suosittelemme, että kirjoitat jokaista sääntöä kohden oman erillisen testimetodin.

Testattava `PriceFormatter`-luokka sijaitsee `price.formatter`-paketissa ja se tulee ottaa testiluokassa käyttöön `import`-komennolla:

```java
import price.formatter.PriceFormatter;
```

Tämän jälkeen kutsu testimetodeissasi `formatPrice`-metodia erilaisilla parametreilla ja varmista, että metodin palauttamat arvot ovat esitettyjen sääntöjen mukaisia:

```java
PriceFormatter formatter = new PriceFormatter();
String result = formatter.formatPrice(Math.PI); // pitäisi olla 3.14 €
```

Voit suorittaa testisi joko koodieditorisi testaustyökalulla ([VS Code](https://code.visualstudio.com/docs/java/java-testing), [Eclipse](https://www.vogella.com/tutorials/JUnitEclipse/article.html)) tai [Gradle-automaatiotyökalulla](https://docs.gradle.org/current/userguide/java_testing.html):

```
./gradlew test       # unix
.\gradlew.bat test   # windows
```

✅ Huomaa, että testiesi tulisi tässä vaiheessa mennä läpi, koska testattavassa metodissa ei *pitäisi* olla loogisia virheitä.

💡 *Metodin testaamiseksi sinun ei tarvitse perehtyä sen lähdekoodiin. Tärkeämpää on, että tiedossasi on yllä esitetyt metodin toimintaa koskevat **vaatimukset**.*

⛔ *Et saa tehdän lainkaan muutoksia `PriceFormatter`-luokkaan.*


### Osa 2: kattavampi testaus *(soveltaminen, 5 * 15 %)*

Se, että testit "menevät läpi", ei välttämättä tarkoita, että testit olisivat kattavat tai että testattavassa koodissa ei olisi bugeja. Jotta varmistamme, että testisi ovat kattavat, ajetaan testisi myös eri tavoin bugisia versioita vasten 😈. Kirjoittamiesi testien tulee löytää nämä bugit.

Jos kirjoitit kattavat testitapaukset kaikille aiemmin esitetyille muotoilusäännöille, tämä osa ei edellytä muutoksia testeihisi 😎. Mikäli testisi eivät löydä kaikkia bugeja GitHub classroomin automaattisessa tarkastuksessa, jatka [PriceFormatterTest](./src/test/java/exercise/PriceFormatterTest.java)-luokan kehittämistä ja varmista, että testisi tarkastavat kaikki ylempänä esitetyt muotoilusäännöt erilaisten syötteiden avulla.

💡 *Tässä osassa testisi ajetaan viiteen kertaan viittä eri tavoin bugista `formatPrice`-metodia vasten. Saat kustakin suorituksesta pisteet, mikäli buginen versio `formatPrice`-metodista **aiheuttaa virheen** vähintään yhdessä testimetodissasi. Jos testit menevät läpi, tarkoittaa se, että bugi jäi löytymättä. Tällöin myös pisteet jäävät saamatta.*

💡 *Näiden soveltavien testien suorittaminen edellyttää, että alkuperäinen toimiva versio `formatPrice`-metodista läpäisee ensin testisi.*

🚀 *Tehtävän tarkastuksessa sovelletaan menetelmää nimeltä mutaatiotestaus: "Mutation testing is used to design new software tests and evaluate the quality of existing software tests. Mutation testing involves modifying a program in small ways." [(Wikipedia)](https://en.wikipedia.org/wiki/Mutation_testing)*

## Lisenssi ja tekijät

Tämän tehtävän on kehittänyt Teemu Havulinna ja se on lisensoitu [Creative Commons BY-NC-SA -lisenssillä](https://creativecommons.org/licenses/by-nc-sa/4.0/).

Tehtävänannon, lähdekoodien ja testien toteutuksessa on hyödynnetty ChatGPT 3.5 -kielimallia sekä GitHub copilot -tekoälyavustinta.
