package model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ofk on 11/4/17.
 */
public class Cities {
    HashMap<String,List> districts;
    List cities;
    public Cities(){
        districts = new HashMap<String,List>();
        cities = Arrays.asList("Adana", "Adıyaman", "Afyon", "Ağrı", "Amasya", "Ankara", "Antalya", "Artvin",
                "Aydın", "Balıkesir", "Bilecik", "Bingöl", "Bitlis", "Bolu", "Burdur", "Bursa", "Çanakkale",
                "Çankırı", "Çorum", "Denizli", "Diyarbakır", "Edirne", "Elazığ", "Erzincan", "Erzurum", "Eskişehir",
                "Gaziantep", "Giresun", "Gümüşhane", "Hakkari", "Hatay", "Isparta", "Mersin", "İstanbul", "İzmir",
                "Kars", "Kastamonu", "Kayseri", "Kırklareli", "Kırşehir", "Kocaeli", "Konya", "Kütahya", "Malatya",
                "Manisa", "Kahramanmaraş", "Mardin", "Muğla", "Muş", "Nevşehir", "Niğde", "Ordu", "Rize", "Sakarya",
                "Samsun", "Siirt", "Sinop", "Sivas", "Tekirdağ", "Tokat", "Trabzon", "Tunceli", "Şanlıurfa", "Uşak",
                "Van", "Yozgat", "Zonguldak", "Aksaray", "Bayburt", "Karaman", "Kırıkkale", "Batman", "Şırnak",
                "Bartın", "Ardahan", "Iğdır", "Yalova", "Karabük", "Kilis", "Osmaniye", "Düzce");
        List adana =Arrays.asList("Aladağ","Ceyhan","Çukurova","Feke","İmamoğlu","Karaisalı","Karataş","Kozan","Pozantı","Saimbeyli","Sarıçam","Seyhan","Tufanbeyli","Yumurtalık","Yüreğir");
        List adiyaman =Arrays.asList("Adıyaman","Besni","Çelikhan","Gerger","Gölbaşı","Kâhta","Samsat","Sincik","Tut");
        List afyon =Arrays.asList("Afyonkarahisar","Başmakçı","Bayat","Bolvadin","Çay","Çobanlar","Dazkırı","Dinar","Emirdağ","Evciler","Hocalar","İhsaniye","İscehisar","Kızılören","Sandıklı","Sinanpaşa","Sultandağı","Şuhut");
        List agri =Arrays.asList("Ağrı","Diyadin","Doğubayazıt","Eleşkirt","Hamur","Patnos","Taşlıçay","Tutak");
        List aksaray =Arrays.asList("Ağaçören","Aksaray","Eskil","Gülağaç","Güzelyurt","Ortaköy","Sarıyahşi");
        List amasya =Arrays.asList("Amasya","Göynücek","Gümüşhacıköy","Hamamözü","Merzifon","Suluova","Taşova");
        List ankara =Arrays.asList("Akyurt","Altındağ","Ayaş","Balâ","Beypazarı","Çamlıdere","Çankaya","Çubuk","Elmadağ","Etimesgut","Evren","Gölbaşı","Güdül","Haymana","Kalecik","Kahramankazan","Keçiören","Kızılcahamam","Mamak","Nallıhan","Polatlı","Pursaklar","Sincan","Şereflikoçhisar","Yenimahalle");
        List antalya =Arrays.asList("Akseki","Aksu","Alanya","Döşemealtı","Elmalı","Finike","Gazipaşa","Gündoğmuş","İbradı","Demre","Kaş","Kemer","Kepez","Konyaaltı","Korkuteli","Kumluca","Manavgat","Muratpaşa","Serik");
        List artvin= Arrays.asList("Ardanuç","Arhavi","Artvin","Borçka","Hopa","Murgul","Şavşat","Yusufeli");
        List balikesir =Arrays.asList("Altıeylül","Ayvalık","Balya","Bandırma","Bigadiç","Burhaniye","Dursunbey","Edremit","Erdek","Gömeç","Gönen","Havran","İvrindi","Karesi","Kepsut","Manyas","Marmara","Savaştepe","Sındırgı","Susurluk");
        List bilecik =Arrays.asList("Bilecik","Bozüyük","Gölpazarı","İnhisar","Osmaneli","Pazaryeri","Söğüt","Yenipazar");
        List bingöl =Arrays.asList("Adaklı","Bingöl","Genç","Karlıova","Kiğı","Solhan","Yayladere","Yedisu");
        List bitlis =Arrays.asList("Adilcevaz","Ahlat","Bitlis","Güroymak","Hizan","Mutki","Tatvan");
        List bolu =Arrays.asList("Bolu","Dörtdivan","Gerede","Göynük","Kıbrıscık","Mengen","Mudurnu","Seben","Yeniçağa");
        List burdur =Arrays.asList("Ağlasun","Altınyayla","Bucak","Burdur","Çavdır","Çeltikçi","Gölhisar","Karamanlı","Kemer","Tefenni","Yeşilova");
        List bursa =Arrays.asList("Büyükorhan","Gemlik","Gürsu","Harmancık","İnegöl","İznik","Karacabey","Keles","Kestel","Mudanya","Mustafakemalpaşa","Nilüfer","Orhaneli","Orhangazi","Osmangazi","Yenişehir","Yıldırım");
        List canakkale =Arrays.asList("Ayvacık","Bayramiç","Biga","Bozcaada","Çan","Çanakkale","Eceabat","Ezine","Gelibolu","Gökçeada","Lapseki","Yenice");
        List cankiri =Arrays.asList("Atkaracalar","Bayramören","Çankırı","Çerkeş","Eldivan","Ilgaz","Kızılırmak","Korgun","Kurşunlu","Orta","Şabanözü","Yapraklı");
        List corum =Arrays.asList("Alaca","Bayat","Boğazkale","Çorum","Dodurga","İskilip","Kargı","Laçin","Mecitözü","Oğuzlar","Ortaköy","Osmancık","Sungurlu","Uğurludağ");
        List denizli =Arrays.asList("Acıpayam","Babadağ","Baklan","Bekilli","Beyağaç","Bozkurt","Buldan","Çal","Çameli","Çardak","Çivril","Güney","Honaz","Kale","Merkezefendi","Pamukkale","Sarayköy","Serinhisar","Tavas");
        List diyarbakir =Arrays.asList("Bağlar","Bismil","Çermik","Çınar","Çüngüş","Dicle","Eğil","Ergani","Hani","Hazro","Kayapınar","Kocaköy","Kulp","Lice","Silvan","Sur","Yenişehir");
        List edirne =Arrays.asList("Enez","Havsa","İpsala","Keşan","Lalapaşa","Meriç","Merkez","Süloğlu","Uzunköprü");
        List elazig =Arrays.asList("Ağın","Alacakaya","Arıcak","Baskil","Elâzığ","Karakoçan","Keban","Kovancılar","Maden","Palu","Sivrice");
        List erzincan =Arrays.asList("Çayırlı","Erzincan","İliç","Kemah","Kemaliye","Otlukbeli","Refahiye","Tercan","Üzümlü");
        List erzurum =Arrays.asList("Aşkale","Aziziye","Çat","Hınıs","Horasan","İspir","Karaçoban","Karayazı","Köprüköy","Narman","Oltu","Olur","Palandöken","Pasinler","Pazaryolu","Şenkaya","Tekman","Tortum","Uzundere","Yakutiye");
        List eskisehir =Arrays.asList("Alpu","Beylikova","Çifteler","Günyüzü","Han","İnönü","Mahmudiye","Mihalgazi","Mihalıççık","Odunpazarı","Sarıcakaya","Seyitgazi","Sivrihisar","Tepebaşı");
        List gaziantep =Arrays.asList("Araban","İslahiye","Karkamış","Nizip","Nurdağı","Oğuzeli","Şahinbey","Şehitkâmil","Yavuzeli");
        List giresun =Arrays.asList("Alucra","Bulancak","Çamoluk","Çanakçı","Dereli","Doğankent","Espiye","Eynesil","Giresun","Görele","Güce","Keşap","Piraziz","Şebinkarahisar","Tirebolu","Yağlıdere");
        List gümüshane =Arrays.asList("Gümüşhane","Kelkit","Köse","Kürtün","Şiran","Torul");
        List hakkari =Arrays.asList("Çukurca","Hakkâri","Şemdinli","Yüksekova");
        List hatay =Arrays.asList("Altınözü","Antakya","Arsuz","Belen","Defne","Dörtyol","Erzin","Hassa","İskenderun","Kırıkhan","Kumlu","Payas","Reyhanlı","Samandağ","Yayladağı");
        List isparta =Arrays.asList("Aksu","Atabey","Eğirdir","Gelendost","Gönen","Isparta","Keçiborlu","Senirkent","Sütçüler","Şarkikaraağaç","Uluborlu","Yalvaç","Yenişarbademli");
        List mersin =Arrays.asList("Akdeniz","Anamur","Aydıncık","Bozyazı","Çamlıyayla","Erdemli","Gülnar","Mezitli","Mut","Silifke","Tarsus","Toroslar","Yenişehir");
        List istanbul =Arrays.asList("Adalar","Arnavutköy","Ataşehir","Avcılar","Bağcılar","Bahçelievler","Bakırköy","Başakşehir","Bayrampaşa","Beşiktaş","Beykoz","Beylikdüzü","Beyoğlu","Büyükçekmece","Çatalca","Çekmeköy","Esenler","Esenyurt","Eyüp","Fatih","Gaziosmanpaşa","Güngören","Kadıköy","Kağıthane","Kartal","Küçükçekmece","Maltepe","Pendik","Sancaktepe","Sarıyer","Silivri","Sultanbeyli","Sultangazi","Şile","Şişli","Tuzla","Ümraniye","Üsküdar","Zeytinburnu");
        List izmir =Arrays.asList("Aliağa","Balçova","Bayındır","Bayraklı","Bergama","Beydağ","Bornova","Buca","Çeşme","Çiğli","Dikili","Foça","Gaziemir","Güzelbahçe","Karabağlar","Karaburun","Karşıyaka","Kemalpaşa","Kınık","Kiraz","Konak","Menderes","Menemen","Narlıdere","Ödemiş","Seferihisar","Selçuk","Tire","Torbalı","Urla");
        List kars =Arrays.asList("Akyaka","Arpaçay","Digor","Kağızman","Kars","Sarıkamış","Selim","Susuz");
        List kastamanou =Arrays.asList("Abana","Ağlı","Araç","Azdavay","Bozkurt","Cide","Çatalzeytin","Daday","Devrekani","Doğanyurt","Hanönü","İhsangazi","İnebolu","Kastamonu","Küre","Pınarbaşı","Seydiler","Şenpazar","Taşköprü","Tosya");
        List kayseri =Arrays.asList("Akkışla","Bünyan","Develi","Felahiye","Hacılar","İncesu","Kocasinan","Melikgazi","Özvatan","Pınarbaşı","Sarıoğlan","Sarız","Talas","Tomarza","Yahyalı","Yeşilhisar");
        List kırklareli =Arrays.asList("Bahşılı","Balışeyh","Çelebi","Delice","Karakeçili","Keskin","Kırıkkale","Sulakyurt","Yahşihan");
        List kırsehir =Arrays.asList("Akçakent","Akpınar","Boztepe","Çiçekdağı","Kaman","Kırşehir","Mucur");
        List kocaeli =Arrays.asList("Başiskele","Çayırova","Darıca","Derince","Dilovası","Gebze","Gölcük","İzmit","Kandıra","Karamürsel","Kartepe","Körfez");
        List konya =Arrays.asList("Ahırlı","Akören","Akşehir","Altınekin","Beyşehir","Bozkır","Cihanbeyli","Çeltik","Çumra","Derbent","Derebucak","Doğanhisar","Emirgazi","Ereğli","Güneysınır","Hadım","Halkapınar","Hüyük","Ilgın","Kadınhanı","Karapınar","Karatay","Kulu","Meram","Sarayönü","Selçuklu","Seydişehir","Taşkent","Tuzlukçu","Yalıhüyük","Yunak");
        List kütahya =Arrays.asList("Altıntaş","Aslanapa","Çavdarhisar","Domaniç","Dumlupınar","Emet","Gediz","Hisarcık","Kütahya","Pazarlar","Şaphane","Simav","Tavşanlı");
        List malatya =Arrays.asList("Akçadağ","Arapgir","Arguvan","Battalgazi","Darende","Doğanşehir","Doğanyol","Hekimhan","Kale","Kuluncak","Pütürge","Yazıhan","Yeşilyurt");
        List manisa =Arrays.asList("Ahmetli","Akhisar","Alaşehir","Demirci","Gölmarmara","Gördes","Kırkağaç","Köprübaşı","Kula","Salihli","Sarıgöl","Saruhanlı","Selendi","Soma","Şehzadeler","Turgutlu","Yunusemre");
        List kahramanmaraş =Arrays.asList("Afşin","Andırın","Çağlayancerit","Dulkadiroğlu","Ekinözü","Elbistan","Göksun","Nurhak","Onikişubat","Pazarcık","Türkoğlu");
        List mardin =Arrays.asList("Artuklu","Dargeçit","Derik","Kızıltepe","Mazıdağı","Midyat","Nusaybin","Ömerli","Savur","Yeşilli");
        List mugla =Arrays.asList("Bodrum","Dalaman","Datça","Fethiye","Kavaklıdere","Köyceğiz","Marmaris","Menteşe","Milas","Ortaca","Seydikemer","Ula","Yatağan");
        List mus =Arrays.asList("Bulanık","Hasköy","Korkut","Malazgirt","Muş","Varto");
        List nevsehir =Arrays.asList("Acıgöl","Avanos","Derinkuyu","Gülşehir","Hacıbektaş","Kozaklı","Nevşehir","Ürgüp");
        List nigde =Arrays.asList("Altunhisar","Bor","Çamardı","Çiftlik","Niğde","Ulukışla");
        List ordu =Arrays.asList("Akkuş","Altınordu","Aybastı","Çamaş","Çatalpınar","Çaybaşı","Fatsa","Gölköy","Gülyalı","Gürgentepe","İkizce","Kabadüz","Kabataş","Korgan","Kumru","Mesudiye","Perşembe","Ulubey","Ünye");
        List rize =Arrays.asList("Ardeşen","Çamlıhemşin","Çayeli","Derepazarı","Fındıklı","Güneysu","Hemşin","İkizdere","İyidere","Kalkandere","Pazar","Rize");
        List sakarya =Arrays.asList("Adapazarı","Akyazı","Arifiye","Erenler","Ferizli","Geyve","Hendek","Karapürçek","Karasu","Kaynarca","Kocaali","Pamukova","Sapanca","Serdivan","Söğütlü","Taraklı");
        List samsun =Arrays.asList("Alaçam","Asarcık","Atakum","Ayvacık","Bafra","Canik","Çarşamba","Havza","İlkadım","Kavak","Ladik","Ondokuzmayıs","Salıpazarı","Tekkeköy","Terme","Vezirköprü","Yakakent");
        List siirt =Arrays.asList("Siirt","Tillo","Baykan","Eruh","Kurtalan","Pervari","Şirvan");
        List sinop =Arrays.asList("Ayancık","Boyabat","Dikmen","Durağan","Erfelek","Gerze","Saraydüzü","Sinop","Türkeli");
        List sivas =Arrays.asList("Akıncılar","Altınyayla","Divriği","Doğanşar","Gemerek","Gölova","Hafik","İmranlı","Kangal","Koyulhisar","Sivas","Suşehri","Şarkışla","Ulaş","Yıldızeli","Zara","Gürün");
        List tekirdağ =Arrays.asList("Çerkezköy","Çorlu","Ergene","Hayrabolu","Kapaklı","Malkara","Marmara Ereğlisi","Muratlı","Saray","Süleymanpaşa","Şarköy");
        List tokat =Arrays.asList("Almus","Artova","Başçiftlik","Erbaa","Niksar","Pazar","Reşadiye","Sulusaray","Tokat","Turhal","Yeşilyurt","Zile");
        List trabzon =Arrays.asList("Akçaabat","Araklı","Arsin","Beşikdüzü","Çarşıbaşı","Çaykara","Dernekpazarı","Düzköy","Hayrat","Köprübaşı","Maçka","Of","Ortahisar","Sürmene","Şalpazarı","Tonya","Vakfıkebir","Yomra");
        List tunceli =Arrays.asList("Çemişgezek","Hozat","Mazgirt","Nazımiye","Ovacık","Pertek","Pülümür","Tunceli");
        List sanliurfa =Arrays.asList("Akçakale","Birecik","Bozova","Ceylanpınar","Eyyübiye","Halfeti","Haliliye","Harran","Hilvan","Karaköprü","Siverek","Suruç","Viranşehir");
        List usak =Arrays.asList("Banaz","Eşme","Karahallı","Sivaslı","Ulubey","Uşak");
        List van =Arrays.asList("Bahçesaray","Başkale","Çaldıran","Çatak","Edremit","Erciş","Gevaş","Gürpınar","İpekyolu","Muradiye","Özalp","Saray","Tuşba");
        List yozgat =Arrays.asList("Akdağmadeni","Aydıncık","Boğazlıyan","Çandır","Çayıralan","Çekerek","Kadışehri","Saraykent","Sarıkaya","Sorgun","Şefaatli","Yenifakılı","Yerköy","Yozgat");
        List zonguldak =Arrays.asList("Alaplı","Çaycuma","Devrek","Gökçebey","Kilimli","Kozlu","Karadeniz Ereğli","Zonguldak");
        List aydin =Arrays.asList("Bozdoğan","Buharkent","Çine","Didim","Efeler","Germencik","İncirliova","Karacasu","Karpuzlu","Koçarlı","Köşk","Kuşadası","Kuyucak","Nazilli","Söke","Sultanhisar","Yenipazar");
        List bayburt =Arrays.asList("Aydıntepe","Bayburt (İl merkezi)","Demirözü");
        List karaman =Arrays.asList("Ayrancı","Başyayla","Ermenek","Karaman","Kazımkarabekir","Sarıveliler");
        List kirikkale =Arrays.asList("Bahşılı","Balışeyh","Çelebi","Delice","Karakeçili","Keskin","Kırıkkale","Sulakyurt","Yahşihan");
        List batman =Arrays.asList("Batman","Beşiri","Gercüş","Hasankeyf","Kozluk","Sason");
        List sirnak =Arrays.asList("Beytüşşebap","Cizre","Güçlükonak","İdil","Silopi","Şırnak","Uludere");
        List bartin =Arrays.asList("Amasra","Bartın","Kurucaşile","Ulus");
        List ardahan =Arrays.asList("Ardahan","Çıldır","Damal","Göle","Hanak","Posof");
        List iğdir =Arrays.asList("Aralık","Iğdır","Karakoyunlu","Tuzluca");
        List yalova =Arrays.asList("Altınova","Armutlu","Çınarcık","Çiftlikköy","Termal","Yalova");
        List karabük =Arrays.asList("Eflani","Eskipazar","Karabük","Ovacık","Safranbolu","Yenice");
        List kilis =Arrays.asList("Elbeyli","Kilis","Musabeyli","Polateli");
        List osmaniye =Arrays.asList("Bahçe","Düziçi","Hasanbeyli","Kadirli","Osmaniye","Sumbas","Toprakkale");
        List düzce =Arrays.asList("Akçakoca","Cumayeri","Çilimli","Düzce","Gölyaka","Gümüşova","Kaynaşlı","Yığılca");
        districts.put("Adana",adana);
        districts.put("Adıyaman",adiyaman);
        districts.put("Afyon",afyon);
        districts.put("Ağrı",agri);
        districts.put("Amasya",amasya);
        districts.put("Ankara",ankara);
        districts.put("Antalya",antalya);
        districts.put("Artvin",artvin);
        districts.put("Aydın",aydin);
        districts.put("Balıkesir",balikesir);
        districts.put("Bilecik",bilecik);
        districts.put("Bingöl",bingöl);
        districts.put("Bitlis",bitlis);
        districts.put("Bolu",bolu);
        districts.put("Burdur",burdur);
        districts.put("Bursa",bursa);
        districts.put("Çanakkale",canakkale);
        districts.put("Çankırı",cankiri);
        districts.put("Çorum",corum);
        districts.put("Denizli",denizli);
        districts.put("Diyarbakır",diyarbakir);
        districts.put("Edirne",edirne);
        districts.put("Elazığ",elazig);
        districts.put("Erzincan",erzincan);
        districts.put("Erzurum",erzurum);
        districts.put("Eskişehir",eskisehir);
        districts.put("Gaziantep",gaziantep);
        districts.put("Giresun",giresun);
        districts.put("Gümüşhane",gümüshane);
        districts.put("Hakkari",hakkari);
        districts.put("Hatay",hatay);
        districts.put("Isparta",isparta);
        districts.put("Mersin",mersin);
        districts.put("İstanbul",istanbul);
        districts.put("İzmir",izmir);
        districts.put("Kars",kars);
        districts.put("Kastamonu",kastamanou);
        districts.put("Kayseri",kayseri);
        districts.put("Kırklaeri",kırklareli);
        districts.put("Kırşehir",kırsehir);
        districts.put("Kocaeli",kocaeli);
        districts.put("Konya",konya);
        districts.put("Kütahya",kütahya);
        districts.put("Malatya",malatya);
        districts.put("Manisa",manisa);
        districts.put("Kahramanmaraş",kahramanmaraş);
        districts.put("Mardin",mardin);
        districts.put("Muğla",mugla);
        districts.put("Muş",mus);
        districts.put("Nevşehir",nevsehir);
        districts.put("Niğde",nigde);
        districts.put("Ordu",ordu);
        districts.put("Rize",rize);
        districts.put("Sakarya",sakarya);
        districts.put("Samsun",samsun);
        districts.put("Siirt",siirt);
        districts.put("Sinop",sinop);
        districts.put("Sivas",sivas);
        districts.put("Tekirdağ",tekirdağ);
        districts.put("Tokat",tokat);
        districts.put("Trabzon",trabzon);
        districts.put("Tunceli",tunceli);
        districts.put("Şanlıurfa",sanliurfa);
        districts.put("Uşak",usak);
        districts.put("Van",van);
        districts.put("Yozgat",yozgat);
        districts.put("Zonguldak",zonguldak);
        districts.put("Aksaray",aksaray);
        districts.put("Bayburt",bayburt);
        districts.put("Karaman",karaman);
        districts.put("Kırıkkale",kirikkale);
        districts.put("Batman",batman);
        districts.put("Şırnak",sirnak);
        districts.put("Bartın",bartin);
        districts.put("Ardahan",ardahan);
        districts.put("Iğdır",iğdir);
        districts.put("Yalova",yalova);
        districts.put("Karabük",karabük);
        districts.put("Kilis",kilis);
        districts.put("Osmaniye",osmaniye);
        districts.put("Düzce",düzce);
    }
    public List getCities(){return cities;}
    public List getDistrict(String city){return districts.get(city);}
}
