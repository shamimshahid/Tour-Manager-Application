package com.nadxlib.dort;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PlaceDetails extends AppCompatActivity {
     Button hotel11,trans11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_details);
        String s = getIntent().getStringExtra("name");
        HashMap<String,List<PlaceInfo>> places = new HashMap<>();
        hotel11=findViewById(R.id.btn200);
        trans11=findViewById(R.id.btn100);
        //Bager Hat
        PlaceInfo khan_jahan = new PlaceInfo("Khan Jahan Alir Majar", R.drawable.khan_jahan_alir_majar, new LatLng(22.66133912475847, 89.76001913617972));
        PlaceInfo shat_gombuj = new PlaceInfo("Shat Gombuj Mosque",R.drawable.shat_gombuj_mosjid,new
                LatLng(22.674764174520266, 89.74185735451977)
        );
        PlaceInfo mongla_port = new PlaceInfo("Mongla Port",R.drawable.mongla_port, new
                LatLng(22.487270285971707, 89.60283915947277));

        List<PlaceInfo> bagerhat = new ArrayList<PlaceInfo>();
        bagerhat.add(khan_jahan);
        bagerhat.add(shat_gombuj);
        bagerhat.add(mongla_port);
            places.put("Bagerhat",bagerhat);

        //bandarban
        PlaceInfo golden_tample = new PlaceInfo("Bandarban Golden Temple Buddha Dhatu Jadi", R.drawable.buddha_dhatu_jadi,new
                LatLng(22.222749062511333, 92.19746786706665)
);
        PlaceInfo boga = new PlaceInfo("Boga Lake",R.drawable.boga_lake_bandarban,new
                LatLng(22.222749062511333, 92.19746786706665)
);
        PlaceInfo mata = new PlaceInfo("Matamuhuri",R.drawable.matamuhuri, new
                LatLng(21.766393577058157, 91.89735184696505)
);

        List<PlaceInfo> Bandarban = new ArrayList<PlaceInfo>();
        Bandarban.add(golden_tample);
        Bandarban.add(boga);
        Bandarban.add(mata);

        places.put("Bandarban",Bandarban);
        //barisal

        PlaceInfo dighi = new PlaceInfo("Durgasagor Dighi", R.drawable.durgasagor_dighi,new
                LatLng(22.761045445156075, 90.2895498129305)
        );
        PlaceInfo guti = new PlaceInfo("Gutiya Mosque",R.drawable.gutiya_mosque,new
                LatLng(22.783262318958283, 90.23871223991122)
        );
        PlaceInfo kitto = new PlaceInfo("Kittonkhola Nodi",R.drawable.kirtonkhola_nodi,new
                LatLng(22.70045309510455, 90.36987501210602)
        );

        List<PlaceInfo> Barisal = new ArrayList<PlaceInfo>();
        Barisal.add(dighi);
        Barisal.add(guti);
        Barisal.add(kitto);
        places.put("Barisal",Barisal);


        // Comilla

        PlaceInfo chondi = new PlaceInfo("Chondi Murra Tample", R.drawable.chondi_mura_temple_comilla,new
                LatLng(23.353555033411595, 91.13177449759516)
            );
        PlaceInfo gomti_river = new PlaceInfo("Gomti River",R.drawable.gomti_river_comilla,new
                LatLng(23.46535918364436, 91.17950238410715)
        );
        PlaceInfo shalbon = new PlaceInfo("Shalbon",R.drawable.shalbon_bihar,new
                LatLng(23.42626417412406, 91.13777765526976)
        );

        List<PlaceInfo> Comilla = new ArrayList<PlaceInfo>();
        Comilla.add(chondi);
        Comilla.add(gomti_river);
        Comilla.add(shalbon);
        places.put("Comilla",Comilla);


       // coxs bazar
        PlaceInfo adinath = new PlaceInfo("Adinath Tample", R.drawable.adinath_temple,new
                LatLng(21.528205210843765, 91.97481936872514)
        );
        PlaceInfo coxs = new PlaceInfo("Coxs Bazar",R.drawable.coxs_bazar,new
                LatLng(21.528205210843765, 91.97481936872514)
        );
        PlaceInfo himchori = new PlaceInfo("Shalbon",R.drawable.himchori_waterfall,new
                LatLng(21.355190252236124, 92.02623383988549)
        );

        List<PlaceInfo> coxsB = new ArrayList<PlaceInfo>();
        coxsB.add(adinath);
        coxsB.add(coxs);
        coxsB.add(himchori);
        places.put("Coxbazar",coxsB);


        //dhaka
        PlaceInfo ahsan = new PlaceInfo("Ahsan Manjil", R.drawable.ahsan_manzil,new
                LatLng(23.708797774731817, 90.40600739760191)
        );
        PlaceInfo dhake = new PlaceInfo("Dhakeshaweri Temple",R.drawable.dhakeshawari_temple_front,new
                LatLng(23.708797774731817, 90.40600739760191)
        );
        PlaceInfo lalbag = new PlaceInfo("Lalbag Fort",R.drawable.lalbagh_fort_mosque,new
                LatLng(23.7190274682488, 90.38811668225568)
        );

        List<PlaceInfo> dhaka = new ArrayList<PlaceInfo>();
        dhaka.add(ahsan);
        dhaka.add(dhake);
        dhaka.add(lalbag);
        places.put("Dhaka",dhaka);


        //gopalganj

        PlaceInfo samadhi = new PlaceInfo("Samadhi", R.drawable.bangabandhu_somadhi, new
                LatLng(22.906503592257994, 89.89633561293316))
                ;
        PlaceInfo boddo = new PlaceInfo("Boddhobhumi",R.drawable.boddhyobhumi,new
                LatLng(23.708797774731817, 90.40600739760191)
        );
        PlaceInfo thakur = new PlaceInfo("Thakur Bari",R.drawable.orakandi_thakur_bari,new
                LatLng(23.177774168652054, 89.82183062642842)
        );

        List<PlaceInfo> gopal = new ArrayList<PlaceInfo>();
        gopal.add(samadhi);
        gopal.add(boddo);
        gopal.add(thakur);
        places.put("Gopalganj",gopal);



        //jhalokathi
        PlaceInfo floati = new PlaceInfo("Floating Market", R.drawable.floating_market, new
                LatLng(22.75416231171196, 90.17336125168194));
        PlaceInfo gab = new PlaceInfo("Gabkhan Bridge",R.drawable.boddhyobhumi,new
                LatLng(22.641277408835485, 90.17897428619911)
        );
        PlaceInfo zam = new PlaceInfo("Kristipara Zamidar Bari",R.drawable.orakandi_thakur_bari,new
                LatLng(22.641277408835485, 90.17897428619911)
        );

        List<PlaceInfo> jhal = new ArrayList<PlaceInfo>();
        jhal.add(floati);
        jhal.add(gab);
        jhal.add(zam);
        places.put("Jhalokathi",jhal);


        //khagrachori

        PlaceInfo alu = new PlaceInfo("Alutila Cave", R.drawable.alutila_cave_khagrachari, new
                LatLng(23.10582533042092, 91.98043758224397));
        PlaceInfo hang = new PlaceInfo("Hanging Bridge",R.drawable.hangingi,new
                LatLng(23.10582533042092, 91.98043758224397)
        );
        PlaceInfo jh = new PlaceInfo("Risang Jharan",R.drawable.risang_jharna,new
                LatLng(23.066130827133264, 91.94365401293618)
        );

        List<PlaceInfo> khag = new ArrayList<PlaceInfo>();
        khag.add(alu);
        khag.add(hang);
        khag.add(jh);
        places.put("Khagrachori",khag);


        //khulna

            PlaceInfo aliSetu = new PlaceInfo("Khan Jahan Ali Setu", R.drawable.khan_jahan_alisetu, new
                    LatLng(22.777702422186046, 89.58422176874771));
            PlaceInfo shir = new PlaceInfo("Shoromoni Monument",R.drawable.shiromoni_monument,new
                    LatLng(22.91553103913274, 89.49269763328084)
            );
            PlaceInfo sun = new PlaceInfo("Sundarban",R.drawable.sundarban,new
                    LatLng(22.81918186330985, 89.56444378409495)
            );

            List<PlaceInfo> khulna = new ArrayList<PlaceInfo>();
            khulna.add(aliSetu);
            khulna.add(shir);
            khulna.add(sun);
            places.put("Khulna",khulna);


            //maymensingh


            PlaceInfo alCas = new PlaceInfo("Alexander Castle", R.drawable.alex, new
                    LatLng(24.76584040490545, 90.40202759762275));
            PlaceInfo kalu = new PlaceInfo("Kalu Sha Dighi",R.drawable.kalu_sha_dighi,new
                    LatLng(23.97031544830073, 90.03406808226052)
            );
            PlaceInfo surj = new PlaceInfo("Surjakanta Bari",R.drawable.surjakanta_bari,new
                    LatLng(24.677490133136633, 89.9523102841308)
            );

            List<PlaceInfo> may = new ArrayList<PlaceInfo>();
            may.add(alCas);
            may.add(kalu);
            may.add(surj);
            places.put("Mymensingh",may);



            //sylhet

            PlaceInfo bichana = new PlaceInfo("Bichanakandi", R.drawable.bichana, new
                    LatLng(25.176070828711683, 91.88658233995781));
            PlaceInfo shah = new PlaceInfo("Shah Jalal Majar",R.drawable.shah_jalal,new
                    LatLng(24.902749385085258, 91.86664581297194)
            );
            PlaceInfo jaflong = new PlaceInfo("Jaflong",R.drawable.jaflong,new
                    LatLng(24.902749385085258, 91.86664581297194)
            );

            List<PlaceInfo> syl = new ArrayList<PlaceInfo>();
            syl.add(bichana);
            syl.add(shah);
            syl.add(jaflong);
            places.put("Sylhet",syl);


            //Rangpur

            PlaceInfo begum = new PlaceInfo("Begum Rokeya Complex", R.drawable.rok, new
                    LatLng(25.71798490576795, 89.25922918532036));
            PlaceInfo town = new PlaceInfo("Town Hall",R.drawable.town_hall,new
                    LatLng(24.76220079250337, 90.39983689762266)
            );
            PlaceInfo dao = new PlaceInfo("Daoyan Bari",R.drawable.dao,new
                    LatLng(25.748513457449942, 89.27591150787205)
            );

            List<PlaceInfo> rang = new ArrayList<PlaceInfo>();
            rang.add(begum);
            rang.add(town);
            rang.add(dao);
            places.put("Rangpur",rang);


            //rajshahi
            PlaceInfo bagha = new PlaceInfo("Bagha Mosque", R.drawable.bagha, new
                    LatLng(24.19597498846154, 88.83940109761141));
            PlaceInfo padmaPar = new PlaceInfo("Padma Par",R.drawable.padma,new
                    LatLng(23.93385879711073, 89.20376157415492)
            );
            PlaceInfo puth = new PlaceInfo("Puthia Bari",R.drawable.put,new
                    LatLng(23.93385879711073, 89.20376157415492)
            );

            List<PlaceInfo> raj = new ArrayList<PlaceInfo>();
            raj.add(bagha);
            raj.add(padmaPar);
            raj.add(puth);
            places.put("Rajshahi",raj);


            //naryanganj
                PlaceInfo taj = new PlaceInfo("Taj Mahal", R.drawable.tajmahal, new
                LatLng(23.746369602944576, 90.56753689630713));
        PlaceInfo panam = new PlaceInfo("Panam Nagar ",R.drawable.panam,new
                LatLng(23.655959571561354,  90.60252491964236)
        );
        PlaceInfo haji = new PlaceInfo("Hajiganj Fort  ",R.drawable.haji,new
                LatLng(23.633798450322715, 90.51291845092405)
        );
                List<PlaceInfo> nar = new ArrayList<PlaceInfo>();
                nar.add(taj);
                nar.add(panam);
                nar.add(haji);
                places.put("Naryanganj",nar);


        //pabna
        PlaceInfo rabi = new PlaceInfo("Shilaidaha Kuthibari", R.drawable.rabi, new
                LatLng(23.920106983652335, 89.22000658919607));
        PlaceInfo har = new PlaceInfo("Hardinge Bridge",R.drawable.hardinge,new
                LatLng(23.655959571561354,  90.60252491964236)
        );
      //  PlaceInfo lalon = new PlaceInfo("Lalon Shah Bridge",R.drawable.lalon,new
        //        LatLng(23.633798450322715, 90.51291845092405)
       // );
        List<PlaceInfo> pab = new ArrayList<PlaceInfo>();
        pab.add(rabi);
        pab.add(har);
       // nar.add(lalon);
        places.put("Pabna",pab);


        //barguna
        PlaceInfo bibi = new PlaceInfo("Bibi Chini Mosque", R.drawable.bibi, new
                LatLng(22.473025739350934, 90.20075340071219));
        PlaceInfo lal = new PlaceInfo("Laldia Forest",R.drawable.laldia,new
                LatLng(22.258984925238234, 89.86078452102794)
        );
        PlaceInfo  sona = new PlaceInfo("Sonakata Beach",R.drawable.p120173,new
                LatLng(22.150706073668953, 90.0644743985733)
        );
        List<PlaceInfo> bar = new ArrayList<PlaceInfo>();
        bar.add(bibi);
        bar.add(lal);
        bar.add(sona);
        places.put("Barguna",bar);




        //jessore
        PlaceInfo mic = new PlaceInfo("Michael Madhusudan Memorial", R.drawable.mic, new
                LatLng(22.819409409821706, 89.16333258819347));
        PlaceInfo  god= new PlaceInfo("Godkhali Garden",R.drawable.god,new
                LatLng(23.067888918488183, 89.05972713167134)
        );
        PlaceInfo   shahi= new PlaceInfo("Shahi Mosque",R.drawable.shahi,new
                LatLng(22.150706073668953, 90.0644743985733)
        );
        List<PlaceInfo> jas = new ArrayList<PlaceInfo>();
        jas.add(mic);
        jas.add(god);
        jas.add(shahi);
        places.put("Jashore",jas);

        //faridpur

        PlaceInfo mus = new PlaceInfo("Faridpur Museum", R.drawable.mus, new
                LatLng(23.60523763499139, 89.84235514706658)
        );
        PlaceInfo  house= new PlaceInfo("Poet Jasimuddin Museum",R.drawable.poet,new
                LatLng(23.613345515850025, 89.81984140485724)
        );
        PlaceInfo  sheikh = new PlaceInfo("Sheikh Rasel Shishu Park",R.drawable.sheikh,new
                LatLng(22.942660199138494, 89.88886569798657)
        );
        List<PlaceInfo> far = new ArrayList<PlaceInfo>();
        far.add(mus);
        far.add(house);
        far.add(sheikh);
        places.put("Faridpur",far);

        //noakhali

        PlaceInfo baz = new PlaceInfo("Bazra Shahi Mosque", R.drawable.bazra, new
                LatLng(23.00430798722214, 91.0931879461373));
        PlaceInfo  niz= new PlaceInfo("Nijhum Dwip",R.drawable.niz,new
                LatLng(22.258984925238234, 89.86078452102794)
        );
        PlaceInfo  rajgonj = new PlaceInfo("Rajgonj Mia Bari",R.drawable.raj,new
                LatLng(22.890914470649882, 91.13002278173867)
        );
        List<PlaceInfo> noa = new ArrayList<PlaceInfo>();
        noa.add(baz);
        noa.add(niz);
        noa.add(rajgonj);
        places.put("Noakhali",noa);

        //khustia

           PlaceInfo lalon = new PlaceInfo("Lalon Shah's Mazar", R.drawable.lalonshah, new
                        LatLng(23.89602002759892, 89.15203756013527));
            PlaceInfo tagore = new PlaceInfo("Tagor Lodge",R.drawable.tagore,new
                        LatLng(23.90181277908125, 89.14622206151004)
                );
             //   PlaceInfo   = new PlaceInfo("Sonakata Beach",R.drawable.,new
               //         LatLng(22.150706073668953, 90.0644743985733)
               // );
                List<PlaceInfo> khu = new ArrayList<PlaceInfo>();
                khu.add(lalon);
                khu.add(tagore);
              //  bar.add();
                places.put("Khustia",khu);


        //tangail
         PlaceInfo moh = new PlaceInfo("Bibi Chini Mosque", R.drawable.mohera, new
                        LatLng(24.16283545710949, 90.04219217555912));
                PlaceInfo paku = new PlaceInfo("Pakutia Zamindar Bari",R.drawable.paku,new
                        LatLng(24.021510780310887, 89.98757564637188)
                );
                PlaceInfo  dhan = new PlaceInfo("Dhanbari Nawab Palace",R.drawable.dhan,new
                        LatLng(24.676628895814954, 89.9554880636917)
                );
                List<PlaceInfo> tan = new ArrayList<PlaceInfo>();
                tan.add(moh);
                tan.add(paku);
                tan.add(dhan);
                places.put("Tangail",tan);
        // jamalpur

         PlaceInfo luis = new PlaceInfo("Luis Village", R.drawable.luis, new
                        LatLng(24.898897544606815, 89.94784072350103));
                PlaceInfo lauch = new PlaceInfo("Lauchapara",R.drawable.lauch,new
                        LatLng(25.283342696447274, 89.9205811356298)
                );
              //  PlaceInfo   = new PlaceInfo("Sonakata Beach",R.drawable.p120173,new
                //        LatLng(22.150706073668953, 90.0644743985733)
              //  );
                List<PlaceInfo> jam = new ArrayList<PlaceInfo>();
                jam.add(luis);
                jam.add(lauch);
               // bar.add();
                places.put("Jamalpur",jam);
        // jaypurhat

         PlaceInfo  nan= new PlaceInfo("Nandail Dighi", R.drawable.nan, new
                        LatLng(25.06171876761039, 89.210482760263));
                PlaceInfo  lokma= new PlaceInfo("Lokma Jomidar Bari",R.drawable.lokma,new
                        LatLng(25.18819079793282, 89.01919123100362)
                );
                PlaceInfo  gopi = new PlaceInfo("Gopinathpur Mandir",R.drawable.gopi,new
                        LatLng(24.98078305264445, 89.09054054259475)
                );
                List<PlaceInfo> jay = new ArrayList<PlaceInfo>();
                jay.add(nan);
                jay.add(lokma);
                jay.add(gopi);
                places.put("Joypurhat",jay);

         //bramhan
         PlaceInfo  dhor= new PlaceInfo("Dhoronti Haor", R.drawable.dhor, new
                        LatLng(24.13196573955705, 91.13290607021152));
                PlaceInfo  hatir= new PlaceInfo("Hatir Pool",R.drawable.hatir,new
                        LatLng(24.05442560452662, 91.15106327247672)
                );
                PlaceInfo  hari = new PlaceInfo("Haripur Zamindar Bari",R.drawable.hari,new
                        LatLng(24.108740413847194, 91.2576904591691)
                );
                List<PlaceInfo> bram = new ArrayList<PlaceInfo>();
                bram.add(dhor);
                bram.add(hatir);
                bram.add(hari);
                places.put("Brahmanbaria",bram);
        // sirajganj
          PlaceInfo  banga= new PlaceInfo("Bangabandhu Bridge", R.drawable.banga, new
                        LatLng(24.400160016120882, 89.77705041798508));
                PlaceInfo  kacha= new PlaceInfo("Rabindranath Tagore's Kacharibari",R.drawable.kacha,new
                        LatLng(24.17561544114478, 89.59412769096309)
                );
                PlaceInfo  joy = new PlaceInfo("Joysagar Dighi",R.drawable.joy,new
                        LatLng(24.48034788952049, 89.44000298284695)
                );
                List<PlaceInfo> sir = new ArrayList<PlaceInfo>();
                sir.add(banga);
                sir.add(kacha);
                sir.add(joy);
                places.put("Sirajganj",sir);
        // sunamgnaj
        PlaceInfo tangu = new PlaceInfo("Tanguar Haor", R.drawable.tangu, new
                        LatLng(25.140276069388594, 91.08825270168785));
                PlaceInfo  hason= new PlaceInfo("Hason Raja Museum",R.drawable.hason,new
                        LatLng(24.895023357518347, 91.86727747849612)
                );
                PlaceInfo  kanda = new PlaceInfo("Kandar Haor",R.drawable.kanda,new
                        LatLng(25.07418235224599, 91.40099611659781)
                );
                List<PlaceInfo> su = new ArrayList<PlaceInfo>();
                su.add(tangu);
                su.add(hason);
                su.add(kanda);
                places.put("Sunamganj",su);
         // chitagong
        PlaceInfo pat= new PlaceInfo("Patenga Sea-Beach", R.drawable.pat, new
                LatLng(22.235721273707494, 91.7912949797005));
        PlaceInfo  foy= new PlaceInfo("Foy's Lake",R.drawable.foy,new
                LatLng(22.37285035088245, 91.79284750737868)
        );
        PlaceInfo   dula= new PlaceInfo("Dulahazra Safari Park",R.drawable.dula,new
                LatLng(21.703146431475258, 92.05208670934161)
        );
        List<PlaceInfo> chi = new ArrayList<PlaceInfo>();
        chi.add(pat);
        chi.add(foy);
        chi.add(dula);
        places.put("Chittagong",chi);
        //feni
        PlaceInfo chow= new PlaceInfo(" Chowdhuri Bari Masjid", R.drawable.chaw, new
                LatLng(23.011005974763986, 91.38223755637078));
        PlaceInfo bash = new PlaceInfo("Bashpara Temple",R.drawable.bash,new
                LatLng(23.04044975452289, 91.51186357364081)
        );
      //  PlaceInfo  pagla = new PlaceInfo("Pagla Miar Mazar",R.drawable.pagla,new
        //        LatLng(25.07418235224599, 91.40099611659781)
       // );
        List<PlaceInfo> fen = new ArrayList<PlaceInfo>();
        fen.add(chow);
        fen.add(bash);
        //fen.add(pagla);
        places.put("Feni",fen);

//        Rangamati
        PlaceInfo han= new PlaceInfo("Hanging Bridge", R.drawable.hang, new
                LatLng(22.627894844045922, 92.19002697704369));
        PlaceInfo  kap= new PlaceInfo("Kaptai Lake",R.drawable.kap,new
                LatLng(22.609900528714107, 92.21743765556259)
        );
      //  PlaceInfo  shuvo= new PlaceInfo("Shuvolong Waterfalls",R.drawable.shuvo,new
        //        LatLng(25.07418235224599, 91.40099611659781)
       // );
        List<PlaceInfo> ran = new ArrayList<PlaceInfo>();
        ran.add(han);
        ran.add(kap);
        //ran.add(shuvo);
        places.put("Rangamati",ran);

//        lakhsmipur
        PlaceInfo dalal= new PlaceInfo(" Dalal Zamindar Bari", R.drawable.dalal, new
                LatLng(22.968267001286662, 90.80468948694049));
        PlaceInfo  zeen= new PlaceInfo("Zeener Mosque",R.drawable.zeen,new
                LatLng(22.932816929405718, 90.81643674703047)
        );
//        PlaceInfo   hatia= new PlaceInfo("Hatia Island",R.drawable.hatia,new
//                LatLng(25.07418235224599, 91.40099611659781)
//        );
        List<PlaceInfo> lakh = new ArrayList<PlaceInfo>();
        lakh.add(dalal);
        lakh.add(zeen);
//        lakh.add(hatia);
        places.put("Lakshmipur",lakh);

        CA ca = new CA(this,places.get(s));
        ListView listView = findViewById(R.id.recyclerView);
        listView.setAdapter(ca);

        hotel11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),HotelDistrictPicker.class));
            }
        });
        trans11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),WV.class));
            }
        });




    }
}