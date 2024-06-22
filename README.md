<table>
<colgroup>
<col style="width: 30%" />
<col style="width: 69%" />
</colgroup>
<thead>
<tr class="header">
<th><strong>PROJEKT</strong></th>
<th><strong><span class="smallcaps">symulacja siatki opóźnień pociągów<br />
w grafie spójnym stacji docelowych</span></strong></th>
</tr>
</thead>
<tbody>
</tbody>
</table>

*  
Krzysztof Wiłnicki ­­– opracowanie dokumentacji  
Kacper Wilgus – pomoc w opracowaniu dokumentacji*

<img src="media/image1.png" style="width:6.26389in;height:5.23809in" />

**DDS – delay distribution simulation**

# **<span class="smallcaps">Spis treści</span>**

[INICJACJA [5](#inicjacja)](#inicjacja)

[Założenie projektu. [5](#założenie-projektu.)](#założenie-projektu.)

[1. Opóźnienie. [5](#opóźnienie.)](#opóźnienie.)

[1.1. Opóźnienia losowe awaryjne.
[5](#opóźnienia-losowe-awaryjne.)](#opóźnienia-losowe-awaryjne.)

[1.1.1. Awaria części składu.
[5](#awaria-części-składu.)](#awaria-części-składu.)

[1.1.2. Awaria urządzeń w trasie [5](#_Toc169955628)](#_Toc169955628)

[1.2. Opóźnienia losowe wypadkowe.
[5](#opóźnienia-losowe-wypadkowe.)](#opóźnienia-losowe-wypadkowe.)

[1.2.1. Przypadek A. [5](#przypadek-a.)](#przypadek-a.)

[1.3. Omówienie zależności.
[6](#omówienie-zależności.)](#omówienie-zależności.)

[Informacje dla punktu 1.4.
[6](#informacje-dla-punktu-1.4.)](#informacje-dla-punktu-1.4.)

[1.4. Karta charakterystyki zależności czasowych.
[8](#karta-charakterystyki-zależności-czasowych.)](#karta-charakterystyki-zależności-czasowych.)

[1.5. Opóźnienie w kontekście *pociągu*.
[9](#opóźnienie-w-kontekście-pociągu.)](#opóźnienie-w-kontekście-pociągu.)

[2. Pociąg. [9](#pociąg.)](#pociąg.)

[2.1. Kierunek poruszania.
[9](#kierunek-poruszania.)](#kierunek-poruszania.)

[2.2. Przepustowość. [9](#przepustowość.)](#przepustowość.)

[2.3. Pasażerowie. [10](#pasażerowie.)](#pasażerowie.)

[2.4. Oznaczenie. [10](#oznaczenie.)](#oznaczenie.)

[2.5. Aktualne opóźnienie.
[10](#aktualne-opóźnienie.)](#aktualne-opóźnienie.)

[2.6. Dodatkowe informacje.
[11](#dodatkowe-informacje.)](#dodatkowe-informacje.)

[3. Stacja. [12](#stacja.)](#stacja.)

[3.1. Parametryzacja obiektu typu *stacja*.
[12](#parametryzacja-obiektu-typu-stacja.)](#parametryzacja-obiektu-typu-stacja.)

[3.2. Pozostałe pola. [13](#pozostałe-pola.)](#pozostałe-pola.)

[4. Szlak. [13](#szlak.)](#szlak.)

[5. Uwagi dodatkowe. [13](#uwagi-dodatkowe.)](#uwagi-dodatkowe.)

[IMPLEMENTACJA [14](#implementacja)](#implementacja)

[6. Diagramy sytuacyjne.
[14](#diagramy-sytuacyjne.)](#diagramy-sytuacyjne.)

[6.1. Diagram przypadków użycia.
[14](#diagram-przypadków-użycia.)](#diagram-przypadków-użycia.)

[6.2. Diagram obiektów. [16](#diagram-obiektów.)](#diagram-obiektów.)

[7. Przygotowanie środowiska.
[17](#przygotowanie-środowiska.)](#przygotowanie-środowiska.)

[8. Hierarchia klas. [18](#hierarchia-klas.)](#hierarchia-klas.)

[8.1. *BaseDelay*. [19](#_Toc169955653)](#_Toc169955653)

[8.2. *TrainFailureDelay*. [19](#_Toc169955654)](#_Toc169955654)

[8.3. *LineFailureDelay*. [19](#_Toc169955655)](#_Toc169955655)

[8.4. *RandomSituationDelay*. [19](#_Toc169955656)](#_Toc169955656)

[8.5. *BaseTrain*. [19](#_Toc169955657)](#_Toc169955657)

[8.6. *Train*. [19](#_Toc169955658)](#_Toc169955658)

[8.7. *PassengerTrain*. [19](#_Toc169955659)](#_Toc169955659)

[8.8. *FreightTrain*. [19](#_Toc169955660)](#_Toc169955660)

[8.9. *Initialization*. [19](#_Toc169955661)](#_Toc169955661)

[8.10. *ApplicationWindow*. [19](#_Toc169955662)](#_Toc169955662)

[8.11. *MainSceneController*. [19](#_Toc169955663)](#_Toc169955663)

[8.12. *EntrySceneController*. [19](#_Toc169955664)](#_Toc169955664)

[9. Symulacja. [20](#symulacja.)](#symulacja.)

[SIMULATE **1****−****1****−****30****−****x**
[20](#_Toc169955666)](#_Toc169955666)

[SIMULATE **2****−****1****−****50****−****x**
[20](#_Toc169955667)](#_Toc169955667)

[SIMULATE **3****−****1****−****70****−****x**
[20](#_Toc169955668)](#_Toc169955668)

[SIMULATE **4****−****5****−****30****−****x**
[20](#_Toc169955669)](#_Toc169955669)

[SIMULATE **5****−****5****−****50****−****x**
[20](#_Toc169955670)](#_Toc169955670)

[SIMULATE **6****−****5****−****70****−****x**
[20](#_Toc169955671)](#_Toc169955671)

[SIMULATE **7****−****10****−****30****−****x**
[20](#_Toc169955672)](#_Toc169955672)

[SIMULATE **8****−****10****−****50****−****x**
[20](#_Toc169955673)](#_Toc169955673)

[SIMULATE **9****−****10****−****70****−****x**
[20](#_Toc169955674)](#_Toc169955674)

[SIMULATE **10****−****30****−****30****−****x**
[20](#_Toc169955675)](#_Toc169955675)

[SIMULATE **11****−****30****−****50****−****x**
[20](#_Toc169955676)](#_Toc169955676)

[SIMULATE **12****−****30****−****70****−****x**
[20](#_Toc169955677)](#_Toc169955677)

[SIMULATE **13****−****50****−****30****−****x**
[21](#_Toc169955678)](#_Toc169955678)

[SIMULATE **14****−****50****−****50****−****x**
[21](#_Toc169955679)](#_Toc169955679)

[SIMULATE **15****−****50****−****70****−****x**
[21](#_Toc169955680)](#_Toc169955680)

[SIMULATE **16****−****100****−****30****−****x**
[21](#_Toc169955681)](#_Toc169955681)

[SIMULATE **17****−****100****−****50****−****x**
[21](#_Toc169955682)](#_Toc169955682)

[SIMULATE **18****−****100****−****70****−****x**
[21](#_Toc169955683)](#_Toc169955683)

[SIMULATE **19****−****200****−****30****−****x**
[21](#_Toc169955684)](#_Toc169955684)

[SIMULATE **20****−****200****−****50****−****x**
[21](#_Toc169955685)](#_Toc169955685)

[SIMULATE **21****−****200****−****70****−****x**
[21](#_Toc169955686)](#_Toc169955686)

[SIMULATE **22****−****500****−****30****−****x**
[21](#_Toc169955687)](#_Toc169955687)

[SIMULATE **23****−****500****−****50****−****x**
[21](#_Toc169955688)](#_Toc169955688)

[SIMULATE **24****−****500****−****70****−****x**
[21](#_Toc169955689)](#_Toc169955689)

# 

**<span class="smallcaps">Spis rysunków</span>**

[Rysunek 1. Wizualizacja przedstawiająca bieg pociągów w czasie
rzeczywistym naniesionych na mapę obiegów stacyjnych.
[10](#_Toc166269977)](#_Toc166269977)

[Rysunek 2. Wizualizacja przedstawiająca bieg pociągów w czasie
rzeczywistym naniesionych na niepoprawnie zaprojektowaną mapę.
[11](#_Toc168867722)](#_Toc168867722)

[Rysunek 3. Diagram przypadków użycia dla zakwalifikowanych przypadków
opóźnień – obraz zminimalizowany. [13](#_Toc168867723)](#_Toc168867723)

[Rysunek 4. Diagram przypadków użycia dla zakwalifikowanych przypadków
opóźnień – część lewa. [14](#_Toc168867724)](#_Toc168867724)

[Rysunek 5. Diagram przypadków użycia dla zakwalifikowanych przypadków
opóźnień – część prawa. [14](#_Toc168867725)](#_Toc168867725)

[Rysunek 6. Diagram obiektów dla przypadkowego układu symulacyjnego –
przypadek losowy AL. [15](#_Toc166451189)](#_Toc166451189)

[Rysunek 7. Diagram obiektów dla przypadkowego układu symulacyjnego –
przypadek losowy ZWA. [15](#_Toc168867727)](#_Toc168867727)

[Rysunek 8. Przytoczenie potrzebnych bibliotek do poprawnego zbudowania
projektu. [16](#_Toc168867728)](#_Toc168867728)

[Rysunek 9. Diagram klas w projekcie z widocznym podziałem na podgrupy
działania. [17](#_Toc168867729)](#_Toc168867729)

**  
**

**Tym kolorem (CZERWONYM) OZNACZONE ZOSTAŁY elementy / założenia
plano-wane, JEDNOCZEŚNIE MAJĄCE NISKI PRIORYTET WYKONANIA.**

**NIE ZOSTAŁY ONE ZAKWALIFIKOWANE DO ADAPTACJI W ostatecznej WERSJI
PROJEKTU!**

**może ich nie być lub nie będą IMPLEMENTOWANE w ostatecznej wersji
PROJEKTU!**

# INICJACJA

## **Założenie projektu.**

Założeniem projektu jest przedstawienie skutków niedokładnego (względnie
losowego) planowania ruchu pociągów, a także pokazanie złożoności
opóźnień wynikających z wypadków losowych  
i ich wpływu na całą sieć połączeń.

Symulacja zakłada bardzo uproszczony model siatki połączeń składający
się ze stacji początkowych  
i końcowych, linii jedno- i dwutorowych o różnych parametrach oraz
składów pociągów o różnych parametrach.

## **Opóźnienie.**

Kluczowym parametrem wpływającym na płynność przeprowadzania symulacji i
różnicę między wynikami rzeczywistymi a oczekiwanymi będą rodzaje
opóźnień, wszystkie 10 z nich zostało przybliżone poniżej. Opóźnienia
stają się tym samym głównym agentem opisywanej symulacji.

1.  ### Opóźnienia losowe awaryjne.

    1.  ####  Awaria części składu.

        -   **AL** awaria lokomotywy

> *uszkodzenie hamulca pomocniczego, uszkodzenie silników tyrystorowych,
> uszkodzenie pantografu etc.*

-   **AW<sub>P </sub>**awaria wagonu <sub>poważna</sub>

> *uszkodzenie przewodu pneumatycznego, uszkodzenie sprzęgu
> podstawowego, uszkodzenie wózka etc.*

-   **AW<sub>S </sub>**awaria wagonu <sub>symboliczna</sub>

> *uszkodzenie węzła AC, uszkodzenie szafy automatyki etc.*

2.  <span id="_Toc169955628" class="anchor"></span>Awaria urządzeń w
    trasie.

    -   **ASRK** awaria urządzeń sterowania ruchem kolejowym

    -   **ASEM** awaria semafora dowolnego typu

> *jazda na sygnał zastępczy bądź z pominięciem syngału S1 „Stój”*

2.  ### Opóźnienia losowe wypadkowe.

    1.  ####  Przypadek A.

        -   **WCZ** wypadek z udziałem człowieka / zwierzęcia

        -   **WPO** wypadek z udziałem pojazdu

        -   **ZWA** złe warunki atmosferyczne

        -   **PRZ** przyczyny związane z działalnością przewoźnika
            kolejowego

        -   **ZIN** przyczyny związane z działalnością zarządcy
            infrastruktury

3.  ### Omówienie zależności.

> Każde z opóźnień posiada swoją charakterystykę uproszczoną do 4
> podstawowych składowych:

-   wypadkowej czasu

> *wskaźnik WYP – WYPADKOWA dla pojazdu dotkniętego  
> oraz innych (zależność opisana w przykładzie nr 2 poniżej)  
> *

-   prawdopodobieństwa wystąpienia

> *wskaźnik PROB*

-   spadku priorytetu trasowego

> *wskaźnik SPT*

-   dodatkowych uwag.

> UWAGA! W czasie symulacji odwoływanie pociągów przewiduje się
> **wyłącznie** w sytuacji przekroczenia całkowitej ilości opóźnienia
> dla danego pociągu **powyżej 500** **minut**, **niezależnie od
> długości planowej trasy** – każdy inny skład wykonuje pracę przewozową
> na bazie swoich dwóch stacji krańcowych: początkowej i końcowej bez
> możliwości ich zmiany.
>
> ***Przykład nr 1**:*
>
> *Awaria lokomotywy jest jedną z poważniejszych przyczyn, taka sytuacja
> wymaga bowiem zastąpienia lokomotywy pierwotnej, przy tym zapewnienia
> nowej drużyny trakcyjnej. Optymalne rozwiązanie nakłada tym samym na
> skład względnie duże opóźnienie. Dodatkowo pociąg taki blokuje przez
> pewien czas szlak główny, generując opóźnienie innych składów.*
>
> ***Koniec przykładu nr 1.***
>
> Wszystkie opóźnienia ze względu na mechanikę działania będą
> rejestrowane w danych wynikowych. Dokładna informacja dotycząca
> mechanizmu zliczania opóźnień znajduje się  
> w punkcie 5. dokumentu.

### Informacje dla punktu 1.4.

> W punkcie 1.4 przygotowana została karta charakterystyki zależności
> czasowych dla poszczególnych typów opóźnień. Przedstawia ona wpływ
> danego opóźnienia na pojazd dotknięty opóźnieniem, jak i pojazdy
> znajdujące się na tym samym szlaku za pojazdem dotkniętym w kierunku
> poruszania się tego pojazdu.
>
> Przykładowe obliczenie wypadkowej czasu danego opóźnienia zostało
> przedstawione poniżej:

***  
***

> ***Przykład nr 2**:*
>
> *Pociąg Axxxxx uległ **awarii lokomotywy** z **prawdopodobieństwem**
> równym **0.08**. Podstawowy całkowity czas przejazdu ze stacji A do
> stacji D wyniósł*
>
> **T**<sub>**C**</sub>**=****120** **min** *.*
>
> *Opóźnienie wydłuży czas przejazdu o wypadkową*
>
> $\\mathbf{\\text{WYP}} = \\frac{\\mathbf{1}}{\\mathbf{2}}\\mathbf{\*}\\mathbf{T}\_{\\mathbf{C}}\\mathbf{= 60\\ min}$*.*
>
> ***Symulacja zatrzymuje** przejazd* pociągu *do momentu odliczenia
> **równowartości WYP**. Stąd wynika,  
> że całkowity czas przejazdu pociągu dotkniętego opóźnieniem wyniesie
> końcowo*
>
> **T**<sub>**C**</sub>**+**WYP = 120 + 60 = **180** **min** *.*
>
> *Zgodnie z tabelą charakterystyki, kolejne trzy* pociągi *w tej samej
> relacji* **oznaczone kolejnością** **k** **1** **−** **3** *(jeśli
> takowe występują) także zostaną opóźnione – **symulacja NIE
> zatrzymuje** ich przejazdu w kierunku stacji docelowej – opóźnienie to
> wyniesie*
>
> $\\text{WYP}\_{1 - 3} = \\left\\lceil \\frac{\\mathbf{1}}{\\mathbf{7}}\\mathbf{\*}\\mathbf{\\ }\\mathbf{\\text{WYP}}\_{\\mathbf{\\text{PD}}} \\right\\rceil\\mathbf{=}\\mathbf{9}\\mathbf{\\ }\\mathbf{\\min}$***.***
>
> *Stąd wynika, że całkowity czas przejazdu trzech kolejnych pociągów (k
> 1-3) w tej samej relacji dotkniętego opóźnieniem wyniesie końcowo*

**T**<sub>**C**</sub>**+**WYP<sub>**1****−****3**</sub> = *X* + 9 \[min\],

*g**d**z**i**e* *X* − *T*<sub>*C*</sub> *p**o**c**i**ą**g**ó**w* *k* 1 − 3.

> *Dla tego typu awarii obliczyć należy kolejne (ostatnie) opóźnienia –
> tym razem dla kolejnych trzech* pociągów *w tej samej relacji, lecz
> **oznaczonych kolejnością *****k** **4** **−** **6** *(jeśli takowe
> występują). Tak samo jak powyżej, **symulacja NIE zatrzymuje** ich
> przejazdu w kierunku stacji docelowej, a opóźnienie wyniesie*
>
> $\\text{WYP}\_{4 - 6} = \\left\\lceil \\frac{\\mathbf{1}}{\\mathbf{14}}\\mathbf{\*}\\mathbf{\\ }\\mathbf{\\text{WYP}}\_{\\mathbf{\\text{PD}}} \\right\\rceil\\mathbf{=}\\mathbf{5}\\mathbf{\\ }\\mathbf{\\min}$***.***
>
> *Stąd wynika, że całkowity czas przejazdu trzech kolejnych pociągów (k
> 1-3) w tej samej relacji dotkniętego opóźnieniem wyniesie końcowo*

**T**<sub>**C**</sub>**+**WYP<sub>**4****−****6**</sub> = *X* + 5 \[min\],

*g**d**z**i**e* *X* − *T*<sub>*C*</sub> *p**o**c**i**ą**g**ó**w* *k* 4 − 6.

> ***Koniec przykładu nr 2.***
>
> Skrótowe oznaczenia dla powyższego przykładu, jak i tabeli danych w
> punkcie 1.4 zostały sklasyfikowane poniżej:
>
> \* oznaczenie poważnego opóźnienia  
> *T*<sub>*C*</sub> \[min\] czas całkowity przejazdu pociągu \[w
> minutach\] \[parametr pociągu\]  
> *WYP* wypadkowa czasu opóźnienia  
> *PD* pojazd dotknięty  
> *WYP<sub>PD</sub>* oznaczenie zastępcze dla wyrażenia «WYPADKOWA CZ.
> OPÓŹ. dla PD»  
> *k* *n* − *m* n, m numeruje kolejne *pociągi* za PD  
> *min max* minimalna i maksymalna wartość wskaźnika  
> *mini* minimalna wartość priorytetu
>
> Wszystkie ułamki widoczne w tabeli zaokrąglane są w górę sufitowo (tak
> jak wskazane w przykładzie nr 2) do najbliższej liczby całkowitej. *  
> *

###  Karta charakterystyki zależności czasowych.

<table>
<colgroup>
<col style="width: 10%" />
<col style="width: 18%" />
<col style="width: 8%" />
<col style="width: 18%" />
<col style="width: 8%" />
<col style="width: 6%" />
<col style="width: 6%" />
<col style="width: 21%" />
</colgroup>
<thead>
<tr class="header">
<th rowspan="2"></th>
<th colspan="3"><strong>WYPADKOWA</strong></th>
<th colspan="2"><strong>PROB</strong></th>
<th rowspan="2"><strong>SPT</strong></th>
<th rowspan="2"><em>uwagi</em></th>
</tr>
<tr class="odd">
<th><em>WYP<sub>PD</sub></em></th>
<th colspan="2"><em>inne (w tym samym kierunku)</em></th>
<th><em>min</em></th>
<th><em>max</em></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td rowspan="2"><strong>AL*</strong></td>
<td rowspan="2"><span class="math display">$$\frac{1}{2}*T_{C}\ \lbrack\min\rbrack$$</span></td>
<td>k 1-3</td>
<td><span class="math display">$$\frac{1}{7}\text{WYP}_{\text{PD}}\ \lbrack\min\rbrack$$</span></td>
<td rowspan="2">0.05</td>
<td rowspan="2">0.1</td>
<td rowspan="2"><em><strong>mini</strong></em></td>
<td rowspan="2">dla linii jednotorowych, wypadkową należy<br />
przemnożyć przez <strong>1,5</strong></td>
</tr>
<tr class="even">
<td>k 4-6</td>
<td><span class="math display">$$\frac{1}{14}\text{WYP}_{\text{PD}}\ \lbrack\min\rbrack$$</span></td>
</tr>
<tr class="odd">
<td rowspan="2"><strong>AWP</strong></td>
<td rowspan="2"><span class="math display">$$\frac{1}{6}*T_{C}\ \lbrack\min\rbrack$$</span></td>
<td>k 1-2</td>
<td><span class="math display">$$\frac{1}{5}\text{WYP}_{\text{PD}}\ \lbrack\min\rbrack$$</span></td>
<td rowspan="2">0.02</td>
<td rowspan="2">0.04</td>
<td rowspan="2"><strong>-1</strong></td>
<td rowspan="2">dla przepustowości<br />
klasy poniżej <strong>II</strong>, wypadkową należy przemnożyć przez <strong>1,1</strong></td>
</tr>
<tr class="even">
<td>k 3-4</td>
<td><span class="math display">$$\frac{1}{8}\text{WYP}_{\text{PD}}\ \lbrack\min\rbrack$$</span></td>
</tr>
<tr class="odd">
<td rowspan="2"><strong>AWS</strong></td>
<td rowspan="2"><span class="math display">20 <em>m</em><em>i</em><em>n</em></span></td>
<td>k 1-2</td>
<td><span class="math display">10 <em>m</em><em>i</em><em>n</em></span></td>
<td rowspan="2">0.15</td>
<td rowspan="2">0.25</td>
<td rowspan="2"></td>
<td rowspan="2"></td>
</tr>
<tr class="even">
<td>k 3</td>
<td><span class="math display">5 <em>m</em><em>i</em><em>n</em></span></td>
</tr>
<tr class="odd">
<td rowspan="2"><strong>ASRK</strong></td>
<td rowspan="2"><span class="math display">20 <em>m</em><em>i</em><em>n</em></span></td>
<td>k 1</td>
<td><span class="math display">10 <em>m</em><em>i</em><em>n</em></span></td>
<td rowspan="2">0.3</td>
<td rowspan="2">0.35</td>
<td rowspan="2"><strong>-1</strong></td>
<td rowspan="2"></td>
</tr>
<tr class="even">
<td>k 2-3</td>
<td><span class="math display">5 <em>m</em><em>i</em><em>n</em></span></td>
</tr>
<tr class="odd">
<td rowspan="2"><strong>ASEM</strong></td>
<td rowspan="2"><span class="math display">10 <em>m</em><em>i</em><em>n</em></span></td>
<td>k 1</td>
<td><span class="math display">7 <em>m</em><em>i</em><em>n</em></span></td>
<td rowspan="2">0.45</td>
<td rowspan="2">0.5</td>
<td rowspan="2"></td>
<td rowspan="2"></td>
</tr>
<tr class="even">
<td>k 2</td>
<td><span class="math display">3 <em>m</em><em>i</em><em>n</em></span></td>
</tr>
<tr class="odd">
<td rowspan="2"><strong>WCZ*</strong></td>
<td rowspan="2"><span class="math display">2 * <em>T</em><sub><em>C</em></sub> [<em>m</em><em>i</em><em>n</em>]</span></td>
<td>k 1-4</td>
<td><span class="math display">$$\frac{1}{12}\text{WYP}_{\text{PD}}\ \lbrack\min\rbrack$$</span></td>
<td rowspan="2">0.01</td>
<td rowspan="2">0.05</td>
<td rowspan="2"><em><strong>mini</strong></em></td>
<td rowspan="2">dla linii jednotorowych, wypadkową należy<br />
przemnożyć przez 2</td>
</tr>
<tr class="even">
<td>k 5-8</td>
<td><span class="math display">$$\frac{1}{24}\text{WYP}_{\text{PD}}\ \lbrack\min\rbrack$$</span></td>
</tr>
<tr class="odd">
<td rowspan="3"><strong>WPO*</strong></td>
<td rowspan="3"><span class="math display">$$\frac{3}{2}*T_{C}\ \lbrack\min\rbrack$$</span></td>
<td>k 1-3</td>
<td><span class="math display">$$\frac{1}{12}\text{WYP}_{\text{PD}}\ \lbrack\min\rbrack$$</span></td>
<td rowspan="3">0.005</td>
<td rowspan="3">0.01</td>
<td rowspan="3"><em><strong>mini</strong></em></td>
<td rowspan="3">dla przepustowości<br />
klasy poniżej <strong>II</strong>, wypadkową należy przemnożyć przez <strong>1,3</strong></td>
</tr>
<tr class="even">
<td>k 4-6</td>
<td><span class="math display">$$\frac{1}{18}\text{WYP}_{\text{PD}}\ \lbrack\min\rbrack$$</span></td>
</tr>
<tr class="odd">
<td>k 7-8</td>
<td><span class="math display">$$\frac{1}{24}\text{WYP}_{\text{PD}}\ \lbrack\min\rbrack$$</span></td>
</tr>
<tr class="even">
<td><strong>ZWA</strong></td>
<td><span class="math display">$$\frac{1}{6}*T_{C}\ \lbrack\min\rbrack$$</span></td>
<td>k 1-3</td>
<td><span class="math display">10 <em>m</em><em>i</em><em>n</em></span></td>
<td>0.2</td>
<td>0.3</td>
<td></td>
<td></td>
</tr>
<tr class="odd">
<td rowspan="2"><strong>PRZ</strong></td>
<td rowspan="2"><span class="math display">$$\frac{1}{15}*T_{C}\ \lbrack\min\rbrack$$</span></td>
<td>k 1-2</td>
<td><span class="math display">$$\frac{1}{12}\text{WYP}_{\text{PD}}\ \lbrack\min\rbrack$$</span></td>
<td rowspan="2">0.75</td>
<td rowspan="2">0.8</td>
<td rowspan="2"></td>
<td rowspan="2"></td>
</tr>
<tr class="even">
<td>k 3</td>
<td><span class="math display">$$\frac{1}{18}\text{WYP}_{\text{PD}}\ \lbrack\min\rbrack$$</span></td>
</tr>
<tr class="odd">
<td rowspan="2"><strong>ZIN</strong></td>
<td rowspan="2"><span class="math display">$$\frac{1}{14}*T_{C\ }\lbrack\min\rbrack$$</span></td>
<td>k 1-2</td>
<td><span class="math display">$$\frac{1}{12}\text{WYP}_{\text{PD}}\ \lbrack\min\rbrack$$</span></td>
<td rowspan="2">0.75</td>
<td rowspan="2">0.8</td>
<td rowspan="2"></td>
<td rowspan="2"></td>
</tr>
<tr class="even">
<td>k 3</td>
<td><span class="math display">$$\frac{1}{18}\text{WYP}_{\text{PD}}\ \lbrack\min\rbrack$$</span></td>
</tr>
</tbody>
</table>

Tabela 1. Przedstawienie karty charakterystyki zależności czasowych.

### Opóźnienie w kontekście *pociągu*.

> Jako iż w kolejnym punkcie omówieniu ulega obiekt typu *pociąg,*
> należy przedstawić wszystkie możliwe sposoby zobrazowania zebranego
> opóźnienia przez wszystkie tego typu obiekty  
> w toku trwania symulacji.
>
> Opóźnienie w zamyśle obiektu typu *pociąg* dotyczy obliczania
> dodatkowego czasu przejazdu względem początkowo ustalonego całkowitego
> czasu przejazdu *T*<sub>*C*</sub>. Na koniec symulacji opóźnienie dla
> każdego *pociągu* przedstawiane jest na cztery sposoby:

-   liczbowa wartość opóźnienia w minutach (oraz jej stopień
    > zaawansowania),

-   całkowity czas przejazdu po uwzględnieniu opóźnienia,

-   różnica względna wyrażana w procencie *T*<sub>*C*</sub>,

-   odchylenie od średniego opóźnienia wszystkich pociągów na koniec
    > symulacji.

## **Pociąg.**

Obiektami nominalizowalnymi przez opóźnienia-agentów, poruszającymi się
po wirtualnej mapie obiegów stacyjnych (z założenia początkowego) są
*pociągi*. Każdy z tego typu obiektów posiada następujący zestaw
parametrów wpływający na płynność jazdy, efektywność rozkładową oraz
ostateczną moc opóźnienia:

### Kierunek poruszania.

> Każdy *pociąg* bezwzględnie potrzebuje parametru kierunku poruszania
> ze względu  
> na determinację opóźnień kolejnych jednostek powodowanych przez niego
> samego. Jeżeli  
> dwa pociągi znajdują się w na tej samej linii w tej samej trasie, będą
> na siebie oddziaływać liniowo z każdym przeskokiem czasowym symulacji.
> Kierunek określany jest na zasadzie rachunku kodów stacji – jeśli

\|*W*<sub>1<sub>*A*</sub></sub>−*W*<sub>1<sub>*B*</sub></sub>\| = \|*W*<sub>2<sub>*A*</sub></sub>−*W*<sub>2<sub>*B*</sub></sub>\| 

*a* *B* *t**o* *n**a**j**b**l**i**ż**s**z**a* *s**t**a**c**j**a* *n**a**s**t**ę**p**n**a* *z**g**o**d**n**i**e* *z* *p**l**a**n**o**w**y**m* *b**i**e**g**i**e**m* *p**o**c**i**ą**g**u*)

> to znaczy, że pociągi poruszają się **w tej samej relacji** – na tym
> samym szlaku w tym samym kierunku.
>
> **WAŻNE! Graf wynikowy zostaje stworzony w taki sposób, aby żadna z
> relacji nie posiadała tej samej wartości identyfikacyjnej (aby
> działanie wartości bezwzględnej z różnicy dwóch kodów stacji zwracało
> taki sam wynik).**

### Przepustowość.

> Każdy *pociąg* symbolizuje liczbowo ilość przystanków pośrednich
> (niewliczanych do danych symulacyjnych) oraz średni czas postoju na
> takowych. Dane te w pierwotnej wersji wprowadzane są losowo, a na ich
> podstawie wyliczana jest względna przepustowość końca szlaku (ilość
> kilometrów pozostająca za *pociągiem* na szlaku wg parametryzacji
> priorytetowej) wg poniższego wzoru:

$$P\_{\\max} = \\frac{V\_{\\max}}{S\_{P}\*\\ T\_{P}}$$

> *gdzie* *V*<sub>max</sub> − *p**r**ę**d**k**o**ś**ć* *m**a**k**s**y**m**a**l**n**a*,  S<sub>*P*</sub>− *i**l**o**ś**ć* *p**r**z**y**s**t**a**n**k**ó**w* *p**o**ś**r**e**d**n**i**c**h*,  T<sub>*P*</sub>− *ś**r**e**d**n**i* *c**z**a**s* *p**o**s**t**o**j**u*
>
> Ilość kilometrów konwertowana jest następnie na wektor odległościowy
> za pojazdem wstrzymujący kolejny pojazd w kolei od najechania nań.
> Przepustowość ostatecznie  
> nie wpływa na zmianę czasu opóźnienia obiektu poszkodowanego, a raczej
> obiektów nieposzkodowanych.

### Pasażerowie.

> Każdy *pociąg* posiada 3 parametry opisujące jego nabytą frekwencję.
> Są to:

-   średnia ilość pasażerów – wyznaczana losowo dla każdego generowanego
    obiektu

-   maksymalna pojemność (wytyczona) – jako parametr domyślny ładunku
    pasażerskiego

-   frekwencja względna wyznaczana wg poniższego wzoru:

$$Q\_{F} = \\frac{\\text{PAS}}{\\text{PAS}\_{\\max}}\*100\\%$$

> *gdzie*
> *P**A**S* − *ś**r**e**d**n**i**a* *i**l**o**ś**ć* *p**a**s**a**ż**e**r**ó**w*,  PAS<sub>max </sub> − *m**a**k**s**y**m**a**l**n**a* *p**o**j**e**m**n**o**ś**ć* *p**o**j**a**z**d**u*
>
> Dodatkowo, w oknie dialogowym dodatkowej informacji (punkt 2.4,
> rysunek 1.) pokazywana będzie symboliczna *gwiazdkowana* ocena ruchu
> pociągu (wyliczana prostym algorytmem zmiany ze względu na nabyte
> opóźnienia – ilość i łączny czas niedogodności.

### Oznaczenie.

> Oznaczenie *pociągu* opierać się będzie na symbolicznym
> przyporządkowaniu go do kategorii stanowiącej charakterystykę
> przewozową. Nazwy i skrótowce komunikacyjne nadawane będą w sposób
> określony realnymi wytycznymi planowania ruchu przewozowego wg
> *Instrukcji  
> o prowadzeniu ruchu pociągowego* Ir-1 (PKP PLK SA). Nazwa rozkładowa
> pociągu składa się w takim wypadku z 2 członów alfanumerycznych.
> Pierwszy człon oznacza typ handlowy  
> i przewozowy pociągu (przykładowo *pociąg towarowy* bądź *pociąg
> pasażerski* – zgodnie  
> z wymagani). Drugi człon odpowiada 5-cyfrowemu numerowi handlowemu –
> dokładne złożenie numeru opisane jest wg wspomnianej *Instrukcji*
> Ir-1.
>
> **Oznaczenia te nie będą wykorzystywane w docelowej logice
> symulacyjnej, a jedynie pomogą w odróżnieniu konkretnych obiektów!**

### Aktualne opóźnienie.

> Opóźnienie zebrane w trakcie biegu *pociągu* zgodnie z zasadami
> określonymi w punkcie 1.4 dokumentu będzie wyświetlane w czasie
> rzeczywistym symulacji w sposób wizualnie zrozumiały.
>
> *Proces identyfikacji obrazowej nie został dotychczas określony. W
> momencie aktualizacji symulacji znany będzie także powód opóźnienia
> wstrzymujący* pociąg *od ruchu.*

<img src="media/image2.png" style="width:6.84792in;height:4.59306in" />Prototyp
wizualizacji obrazującej ww. zasady symulacji wygląda następująco:

<span id="_Toc166269977" class="anchor"></span>Rysunek 1. Wizualizacja
przedstawiająca bieg pociągów w czasie rzeczywistym naniesionych na mapę
obiegów stacyjnych.

Na rysunku zauważamy także element charakterystyczny dla *pociągu* –
okno dodatkowej informacji. Dedykowane dla każdego *pociągu*, generowane
w czasie rzeczywistym.

### Dodatkowe informacje.

> Dodatkowe informacje obejmują stację początkową biegu, stację końcową,
> aktualną prędkość akutalizowaną schematycznie z każdą sekundą
> symulacji, aktualny kierunek biegu pociągu oraz wskaźnik PRI –
> wskazanie względne priorytetu w momencie aktualizacji.

**  
**

## **Stacja.** 

<img src="media/image3.png" style="width:6.81736in;height:3.60556in" />Pojęcie
grafu spójnego *stacji* docelowych oznacza jednoznacznie sieć, w której
wierzchołkami są *stacje*, z żadnej z których nie wybiega półprosta do
stacji niewidocznej na schemacie, a nieprawidłowym  
jest także pozostawienie *stacji* bez jakiegokolwiek połączenia
(wierzchołek izolowany). Poprawna sytuacja przedstawiona została na
rysunku 1. w punkcie 2.4. Poniżej zobrazowana jest przykładowa
niepoprawna sytuacja: niepoprawne:

### Parametryzacja obiektu typu *stacja*.

> Parametryzacja stacji opiera się o 4 główne składniki:

-   CODE kod stacji w zapisie liczbowym (0 ≤ *N*≤ 1000),

-   S ilość pociągów obecnych w momencie aktualizacji

> (z założeniem *S*\< *K* − 1)

-   *C*<sub>max  </sub> maksymalna pojemność stacji na godzinę jako
    ilość cykli wymiany

> pasażerskiej przy założeniu pełnego obłożenia krawędzi peronowych oraz
> 2-minutowego czasu wymiany krawędziowej,
>
> wyznaczana za pomocą wzoru

$$C\_{\\max\\ } = \\frac{60}{T\_{\\text{wym}} + 2}\*(K - 1)$$

> *gdzie*
> *K* − *i**l**o**ś**ć* *k**r**a**w**ę**d**z**i* *p**e**r**o**n**o**w**y**c**h*,  *T*<sub>wym</sub>\[min\] − *ś**r**e**d**n**i* *c**z**a**s* *w**y**m**i**a**n**y* *p**a**s**a**ż**e**r**s**k**i**e**j*.
>
> Parametry te jednak nie są – na chwilę obecną – parametrami aktywnymi
> w sensie symulacji. Prawidłowa implementacja przewidziana jest w
> momencie utworzenia poprawnego algorytmu wzajemnego śledzenia między
> *pociągami*.

### Pozostałe pola.

> Na chwilę obecną przewiduje się wprowadzenie pola nazwy stacji dla
> poprawnego odróżniania kolejnych obiektów w toku trwania symulacji w
> kontekście użytkownika.

## **Szlak.**

Wszystkie linie kolejowe zaznaczone na wizualizacji symulacyjnej są
zbudowane w ten sam sposób  
z odróżnieniem linii jedno- i dwutorowych. Pierwsze zaznaczane są jedną
linią odcinkową między kolejnymi stacjami – drugie kreślone zostają
poprzez dwa równoległe odcinki międzystacyjne. Rozróżnienie widać to na
rysunkach 1. do 3.

Ponadto, linie kolejowe posiadają własną klasyfikację przepustowości,
której klasami interfejsu jest priorytetowość przejazdów:

<table>
<colgroup>
<col style="width: 10%" />
<col style="width: 22%" />
<col style="width: 66%" />
</colgroup>
<thead>
<tr class="header">
<th>priorytet</th>
<th>sytuacja użytkowania</th>
<th>opis szczegółowy</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>S</td>
<td>priorytet bezklasowy</td>
<td>priorytetyzuje się tylko pociągi o V<sub>max</sub> &gt; 160 km/h (bez kategoryzacji opóźnień), reszta pojazdów jedzie zgodnie z kolejnością pozarozkładową</td>
</tr>
<tr class="even">
<td>Y</td>
<td>priorytet klasowy zerowy</td>
<td>priorytetyzuje się tylko pociągi o V<sub>max</sub> &gt; 160 km/h (bez kategoryzacji opóźnień), reszta pojazdów jedzie zgodnie z kolejnością pozarozkładową</td>
</tr>
<tr class="odd">
<td>Y<sub>A</sub></td>
<td>priorytet klasowy A</td>
<td>priorytetyzuje się pociągi o V<sub>max</sub> &gt; 120 km/h i pociągi nieopóźnione, reszta pojazdów jedzie zgodnie z kolejnością pozarozkładową</td>
</tr>
<tr class="even">
<td>Y<sub>D</sub></td>
<td>priorytet klasowy D</td>
<td>priorytetyzuje się pociągi o V<sub>max</sub> &gt; 100 km/h i pociągi nieopóźnione, reszta pojazdów jedzie zgodnie z kolejnością pozarozkładową</td>
</tr>
<tr class="odd">
<td>WW</td>
<td>status nadzwyczajny</td>
<td>priorytetyzuje się tylko pociągi o statusie nadzwyczajnym i V<sub>max</sub> &gt; 100 km/h, reszta pojazdów jedzie zgodnie z kolejnością pozarozkładową<br />
(bez uwzględnienia opóźnień)</td>
</tr>
<tr class="even">
<td>Z</td>
<td>priorytet bezklasowy awaryjny</td>
<td>używany w przypadku awarii urządzeń SRK</td>
</tr>
</tbody>
</table>

Klasyfikacja priorytetowa nie będzie używana w pierwotnie zamówionej
wersji symulacji.

## **Uwagi dodatkowe.**

Opóźnienia rejestrowane są w oparciu o ilość ich wystąpień – zasada
doliczania do względnej reprezentacji danych wygląda następująco:

do końcowego zestawienia danych zliczane są jedynie opóźnienia powyżej 5
minut wynikowych (dodanych do całkowitego planowego czasu przejazdu
pociągu). **Wynika to z oficjalnej klasyfikacji opóźnień – wg raportów
m.in. Urzędu Transportu Kolejowego, większość przewoźników nie wlicza do
swoich klasyfikacji obsunięć czasowych względem rozkładu jazdy
mniejszych od 5 minut.**  
Tym samym powyższa teoria symulacji również takie zachowanie uwzględnia.

# IMPLEMENTACJA

Wybranym językiem programowania (platformą wykonawczą) jest język **Java
(wersja stabilna jdk 19.0.1)** z wykorzystaniem biblioteki **JavaFX
(wersja stabilna 22.0.1)**. Narzędziem umożliwiającym automatyczne
budowanie oprogramowania i zarządzanie zależnościami w projekcie obrany
został **Gradle (wersja stabilna 8.2)**. Wykaz dodatkowych zależności,
importowanych bibliotek etc. znajduje się w dalszej części dokumentacji.

Przed przystąpieniem do właściwej implementacji w ww. wybranym języku
programowania, przygotować należy dokumentację wykonawczą. W kolejnych
punktach przedstawiona zostanie  
z wykorzystaniem realnego planu realizacji, wizualizacji planowego
przebiegu symulacji i końcowych wyników przeprowadzonej symulacji.

Opisy rozwiązań zawarte będą w plikach źródłowych projektu w formie
proponowanej przez typ komentarza **Javadoc**. Odnośniki do opisów będą
zarówno interaktywnymi linkami do strony zewnętrznej, zrzutami ekranu ze
środowiska programistycznego, jak i wycinkami kodu.

6.  ## **Diagramy sytuacyjne.**

    1.  ### Diagram przypadków użycia.

> Diagram ten przedstawia funkcjonalność systemu zaprezentowanego
> teoretycznie w fazie **INICJACJI** wraz z jego otoczeniem. Pozwala on
> na graficzne zaprezentowanie własności systemu tak, jak są one
> widziane po stronie użytkownika aplikacji symulacyjnej. Poniżej
> pokazujemy widok ogólny:
>
> <img src="media/image4.png" style="width:5.75839in;height:2.77391in" alt="Obraz zawierający tekst, diagram, linia, Plan Opis wygenerowany automatycznie" />
>
> <span id="_Toc168867723" class="anchor"></span>Rysunek 3. Diagram
> przypadków użycia dla zakwalifikowanych przypadków opóźnień – obraz
> zminimalizowany.
>
> Na kolejnej stronie znajdują się przybliżone części powyższego
> diagramu przypadków użycia – kolejno strony: lewa i prawa.

<img src="media/image5.png" style="width:4.9375in;height:4.98474in" />

> <span id="_Toc168867724" class="anchor"></span>Rysunek 4. Diagram
> przypadków użycia dla zakwalifikowanych przypadków opóźnień – część
> lewa.

<img src="media/image6.png" style="width:5.5625in;height:3.91707in" />

> <span id="_Toc168867725" class="anchor"></span>Rysunek 5. Diagram
> przypadków użycia dla zakwalifikowanych przypadków opóźnień – część
> prawa.

### Diagram obiektów.

> Ten typ diagramu jest z kolei wizualizacją hipotetycznego stanu
> systemu podczas jego działania. Służy do tworzenia przykładów
> pomagających zrozumieć diagram klas a przede wszystkim powiązań w nim
> występujących. Poniższe przedstawiają sytuację z **zatrzymania klatki
> w toku symulacji dla dwóch (lub więcej) *pociągów*** – jednego typu PD
> i innych w tej samej relacji znajdującego się za nim.

<img src="media/image7.png" style="width:5.54861in;height:3.317in" />

<span id="_Toc166451189" class="anchor"></span>Rysunek 6. Diagram
obiektów dla przypadkowego układu symulacyjnego – przypadek losowy AL.

<img src="media/image8.png" style="width:5.65972in;height:4.06596in" />

<span id="_Toc168867727" class="anchor"></span>Rysunek 7. Diagram
obiektów dla przypadkowego układu symulacyjnego – przypadek losowy ZWA.

## **Przygotowanie środowiska.**

Projekt – tak jak zostało to wspomniane w początku rozdziału
***IMPLEMENTACJA** –* zbudowany został przy wykorzystaniu narzędzia
Gradle. Poza plikami i katalogami potrzebnymi do prawidłowego budowania
i uruchamiania projektu z poziomu narzędzi wbudowanych, w folderze
***root*** projektu (katalogu, który znajduje się na szczycie drzewka
katalogów) znajdują się ponadto **inne foldery i pliki**. Ważniejsze z
nich zostały wymienione poniżej:

-   (folder) **docs** = tutaj umiejscowiona jest dokumentacja, jej
    poszczególne elementy graficzne oraz podstawa przygotowania emdletu
    README.md;

-   (folder) **src** – jest to podstawa drzewa katalogów z kodem
    źródłowym i zależnościami (dodatkowymi plikami obrazów / pliki z
    rozszerzeniem FXML) potrzebnymi do zbudowania  
    i uruchomienia końcowej aplikacji;

-   (plik) **build.gradle** – plik ten przechowuje informacje związane z
    dołączaniem paczek zależności, komunikacją między serwerem wymiany
    plików **Maven,** a także informacje (m.in. o głównej klasie
    projektu) potrzebne do zainicjalizowania projektu.

Ze względu na specyfikę pracy w środowisku Gradle, ważne było
**odpowiednie skonfigurowanie biblioteki JavaFX**. Dzięki temu każdy
następujący po sobie etapie nie jest obarczony ryzykiem krytycznych
błędów inicjalizowania projektu, czy też możliwe jest skutecznie
efektywne budowanie osobnej gałęzi konfiguracji – pliku .jar.

<img src="media/image9.png" style="width:5.0007in;height:3.17753in" alt="Obraz zawierający tekst, zrzut ekranu, Czcionka, oprogramowanie Opis wygenerowany automatycznie" />

<span id="_Toc168867728" class="anchor"></span>Rysunek 8. Przytoczenie
potrzebnych bibliotek do poprawnego zbudowania projektu.

Na powyższym rysunku zauważyć możemy dwa wyróżniające się typy
bibliotek: *junit-jupiter* oraz *openjfx-javafx*. Aby skrótowo opisać
obie biblioteki posłużę się odnośnikami do już istniejących, dokładnych
opisów:

-   *openjfx-javafx* – biblioteka JavaFX v19.0.2 –
    [link](https://openjfx.io/javadoc/19/)

-   *junit-jupiter* – biblioteka potrzebna do wykonywania testów
    jednostkowych – [link](https://junit.org/junit5/docs/current/api/)

<img src="media/image10.png" style="width:6.26806in;height:2.72292in" alt="Obraz zawierający zrzut ekranu, tekst, Czcionka, linia Opis wygenerowany automatycznie" />

Rysunek 9. Diagram modułów zależności potrzebnych do poprawnego
zbudowania projektu.

## **Hierarchia klas.**

Projekt dzieli się abstrakcyjnie na dwie podgrupy klas – klasy
odpowiadające za działanie części logicznej oraz klasy odpowiedzialne za
UI (*user interface* – prezentację wizualną). Na poniższym diagramie
zostały one oddzielone czerwoną przerywaną linią, przy czym **klasa
*Initialization* stanowi pewnego rodzaju *middleware***[^1] **dla obu
podgrup klas**.

<img src="media/image11.png" style="width:6.26806in;height:3.93403in" alt="Obraz zawierający tekst, zrzut ekranu, oprogramowanie, Oprogramowanie multimedialne Opis wygenerowany automatycznie" />

<span id="_Toc168867729" class="anchor"></span>Rysunek 10. Diagram klas
w projekcie[^2] z widocznym podziałem na podgrupy działania.

Działanie każdej z klas omówione zostało dzięki wygenerowaniu bazy
wiedzy wg protokołu Javadoc. Poniżej znajdują się przykładowe opisy dla
kilku wybranych klas.

**  
**

## **Symulacja.**

Poniżej zostaną przedstawione wyniki symulacji przeprowadzone w formie
testów szczegółowych konfiguracji. Każde dane przytoczone w punkcie 9.
opisane będą w następujący sposób:

*S**I**M**U**L**A**T**E* *k* − *m* − *v*,

gdzie k – numer porządkowy przeprowadzonej symulacji,  
m – współczynnik wariacji generowanych wartości losowych dla opóźnień
(*m*:*m* *ϵ* \[1,  500\]),  
v – ilość pociągów w symulacji.

***UWAGA!** Współczynnik m symbolizuje grupę czynników niezależnych
takich, jak*

***dostępność drużyn trakcyjnych**, **dostępność zapasowych pojazdów
trakcyjnych** **efektywność pracy przewozowej** czy **likwidowania
skutków awarii**.*

SIMULATE 1 − 10 − 35 − *x*

abc

SIMULATE 2 − 10 − 70 − *x*

abc

SIMULATE 3 − 20 − 35 − *x*

abc

SIMULATE 4 − 20 − 70 − *x*

abc

SIMULATE 5 − 50 − 35 − *x*

abc

SIMULATE 6 − 50 − 70 − *x*

abc

SIMULATE 7 − 100 − 35 − *x*

abc

SIMULATE 8 − 100 − 70 − *x*

abc

SIMULATE 9 − 200 − 35 − *x*

abc

SIMULATE 10 − 200 − 70 − *x*

abc

SIMULATE 11 − 500 − 35 − *x*

abc

SIMULATE 12 − 500 − 70 − *x*

[^1]: middleware (ang. oprogramowanie pośredniczące) – rodzaj
    oprogramowania (w naszym przypadku zestaw metod jednej klasy)
    umożliwiający komunikację pomiędzy różnymi systemami (podgrupami
    klas)

[^2]: zgodny ze stanem z dnia 22 czerwca 2024 r.
