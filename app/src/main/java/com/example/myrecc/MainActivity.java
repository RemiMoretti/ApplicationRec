package com.example.myrecc;

import android.content.Intent;
import android.os.Bundle;

import com.example.myrecc.metier.CompteUtilisateur;
import com.example.myrecc.metier.Soiree;
import com.example.myrecc.support.SoireeAdapter;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myrecc.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private List<Soiree> lesSoirees = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        /*recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        layoutManager =  new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);*/

        //Initialisation des données en brut
        /*if(lesSoirees.isEmpty()){
            Log.i("reset", "reset des données");
            this.Initialisation();
        }

        //récupération des extras (si jamais on doit faire une opération depuis un fragment vers un autre)
        Bundle extra = getIntent().getExtras();

        //Si on vient d'un autre fragment
        if(extra != null){

            //Si on effectue une recherche de ville
            if (extra.get("ville") != null) {
                List<Soiree> soireesRecherchees = new ArrayList<>();
                for (Soiree soiree : lesSoirees){
                    Log.i("foreach hors if", "ville de la soiree ->"+soiree.getVille().toLowerCase() + " valeur du extra ->" + extra.getString("ville").toLowerCase());
                    if(soiree.getVille().trim().equalsIgnoreCase(extra.getString("ville").trim())){
                        Log.i("foreach dans if", "ville de la soiree ->"+soiree.getVille());
                        soireesRecherchees.add(soiree);
                    }
                }

                //si il y a des soirées dans la ville indiquée on affiche le résultat de la recherche
                if(!soireesRecherchees.isEmpty()) {
                    adapter = new SoireeAdapter(soireesRecherchees);
                    Log.i("adapter", "l'adapter existe");
                }
                else {
                    adapter = new SoireeAdapter(lesSoirees);
                }
            }

            //Si on veut voir les détails d'une soirée
            else if(extra.get("detail")!=null){

                Fragment detailSoiree = new DetailSoireeFragment();
                Bundle bundle = new Bundle();
                Log.i("position", "position n°"+extra.get("position"));

                String desc = extra.get("detail").toString();
                bundle.putString("desc",desc);

                detailSoiree.setArguments(bundle);

                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_main, detailSoiree).commit();

            }
            else if(extra.get("creer")!=null){
                Fragment creerSoiree = new SecondFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_main, creerSoiree).commit();
            }

        }

        //Si on arrive sur la page de recherche
        else {
            adapter = new SoireeAdapter(lesSoirees);
        }
        recyclerView.setAdapter(adapter);*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void Initialisation(){
        //Création des faux utilisateurs
        CompteUtilisateur cu1  = new CompteUtilisateur("Pesquet","Thomas",50,"rue spatial",17000,"thomas@nasa.com","toto"	,"123");
        CompteUtilisateur cu2  = new CompteUtilisateur("Hollande","François",55,"rue de la république",54211,"holland@elysé.com","president","000");
        CompteUtilisateur cu3  = new CompteUtilisateur("Quiroule","Pierre",22,"rue de la grotte",56000,"pierre@tombe.com","pepe"	,"456");
        CompteUtilisateur cu4  = new CompteUtilisateur("Lateur","Venti",64,"rue du vent",14700,"vent@souffle.com","fort","999");
        CompteUtilisateur cu5  = new CompteUtilisateur("Mie","Calline",12,"rue de la boulangerie",64000,"boulan@gerie.com","boubou","200");
        CompteUtilisateur cu6  = new CompteUtilisateur("Mortred","Anthony",19,"13 rue de la moelle",16954,"anthony@mortred.com","Anth0nyM0","oui");
        CompteUtilisateur cu7  = new CompteUtilisateur("Deutté","Victor",25,"rue du leuleu",28500,"victor@deuxtt.com","vivi","125");
        CompteUtilisateur cu8  = new CompteUtilisateur("Lepen","Marine",62,"rue sombre",93000,"marine@migre.com","help","008");
        CompteUtilisateur cu9  = new CompteUtilisateur("Dwayne","TheRock",47,"rue du block",45600,"Rock@fort.com","The","692");
        CompteUtilisateur cu10 = new CompteUtilisateur("Mickey","Dance",26,"Avenue de Disney",92600,"Chateau@souris.com","dingo","172");
        CompteUtilisateur cu11 = new CompteUtilisateur("Donald","Trump",75,"allée maison blanche",46900,"maison@blanche.com","dodo","019");
        CompteUtilisateur cu12 = new CompteUtilisateur("Papier","Bulle",32,"rue du pet",64200,"bulle@dair.com","bubu","432");
        CompteUtilisateur cu13 = new CompteUtilisateur("Corail","Abdoul",25,"3me rue du primordial",45998,"Abdoul@Corail.com","@bd0ulC0","oui");
        CompteUtilisateur cu14 = new CompteUtilisateur("Mayonai","Camille",23,"456 Boulevard des enfers",94921,"Camille@Mayonaise.com","KmyMay0","oui");
        CompteUtilisateur cu15 = new CompteUtilisateur("Ivoire","Lucas",24,"974 rue du bitcoin",32164,"Lucas@Ivoire.com","LuKIvoir","oui");
        CompteUtilisateur cu16 = new CompteUtilisateur("Lyra","Mathis",19,"Avenue du Carolina Reaper",79485,"Mathis@Lyra.com","M4t1sLyr4","oui");
        CompteUtilisateur cu17 = new CompteUtilisateur("Xmas","Enyhra",22,"17 du Chadelinity",82648,"Enyhra@Xmas.com","3nyhr4Xm@s","oui");
        CompteUtilisateur cu18 = new CompteUtilisateur("Relax","Jabaoud",21,"94 allée d'Anvers",93000,"Jabaoud@Relax.com","J@b@o0dR3lx","oui");
        CompteUtilisateur cu19 = new CompteUtilisateur("Xmas","Enyhra",22,"17 du Chadelinity",82648,"Enyhra@Xmas.com","3nyhr4Xm@s","oui");
        CompteUtilisateur cu20 = new CompteUtilisateur("Relax","Jabaoud",21,"94 allée d'Anvers",93000,"Jabaoud@Relax.com","J@b@o0dR3lx","oui");


        //Création des soirées
        Soiree so1  = new Soiree(cu2, "14 rue des collombes","Paris", 93000,"30 Novembre", "20h00", "Soiree sympa pour faire des potes",1,1);
        Soiree so2  = new Soiree(cu2, "25 rue des flammes","Aix", 13080,"2 Décembre", "21h00", "Soiree pour se faire du bien, pour oublier nos problèmes",1,1);
        Soiree so3  = new Soiree(cu2, "78 place des Agences","Bordeaux", 30072,"3 Décembre", "19h00", "Soiree pour passer un bon temps, pas de souci, pas trop de monde",0,0);
        Soiree so4  = new Soiree(cu2, "44 rue Pierre Loti","Rochefort", 17300,"25 Décembre", "00h00", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",1,0);
        Soiree so5  = new Soiree(cu2, "11 rue de Gaule","Saintes", 26000,"12 Décembre", "17h30", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",0,1);
        Soiree so6  = new Soiree(cu2, "40 Place du centre","Surgères", 14004,"4 Janvier", "22h30", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",0,0);
        Soiree so7  = new Soiree(cu2, "22 rue du collisé","Tours", 50200,"22 Février", "12h00", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",1,1);
        Soiree so8  = new Soiree(cu3, "Avenue de la liberté","Lille", 54000,"19 Juin", "22:15", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",0,1);
        Soiree so9  = new Soiree(cu3, "Les champs elysées","Paris", 93000,"31 Decembre", "21:30", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",0,0);
        Soiree so10 = new Soiree(cu4, "95 rue du metro","Brest", 59000,"16 Aout", "19:30", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",1,0);
        Soiree so11 = new Soiree(cu5, "113 rue Robespierre","Toulouse", 94989,"25 Novembre", "17:30", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",1,1);
        Soiree so12 = new Soiree(cu6, "13 rue de la moelle","Rochefort", 16954,"17 Mars", "21:30", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",1,1);


        //création de la liste des soirées
        lesSoirees.add(so1);
        lesSoirees.add(so2);
        lesSoirees.add(so3);
        lesSoirees.add(so4);
        lesSoirees.add(so5);
        lesSoirees.add(so6);
        lesSoirees.add(so7);
        lesSoirees.add(so8);
        lesSoirees.add(so9);
        lesSoirees.add(so10);
        lesSoirees.add(so11);
        lesSoirees.add(so12);
<<<<<<< HEAD


        //récupération des extras (si jamais on doit faire une opération depuis un fragment vers un autre)
        Bundle extra = getIntent().getExtras();
        Bundle.putInt("position", Integer.parseInt(extra.get("position").toString()));


        //Si on vient d'un autre fragment
        if(extra != null){

            //Si on effectue une recherche de ville
            if (extra.get("ville") != null) {
                List<Soiree> soireesRecherchees = new ArrayList<>();
                for (Soiree soiree : lesSoirees){
                    Log.i("foreach hors if", "ville de la soiree ->"+soiree.getVille().toLowerCase() + " valeur du extra ->" + extra.getString("ville").toLowerCase());
                    if(soiree.getVille().trim().equalsIgnoreCase(extra.getString("ville").trim())){
                        Log.i("foreach dans if", "ville de la soiree ->"+soiree.getVille());
                        soireesRecherchees.add(soiree);
                    }
                }
                //si il y a des soirées dans la ville indiquée on affiche le résultat de la recherche
                if(!soireesRecherchees.isEmpty()) {
                    adapter = new SoireeAdapter(soireesRecherchees);
                    Log.i("adapter", "l'adapter existe");
                }
            }

            //Si on veut voir les détails d'une soirée
            else if(extra.get("detail")!=null){
                navController.navigate(R.id.detailDeSoiree);

                TextView tvDescSoiree = findViewById(R.id.tvDescSoiree);
                Log.i("descSoiree", "tvDescSoiree ->"+tvDescSoiree);
              //tvDescSoiree.setText(extra.get("detail").toString());
            }
        }

        //Si on arrive sur la page de recherche
        else {
            adapter = new SoireeAdapter(lesSoirees);
        }
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
=======
>>>>>>> main
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        int id = item.getItemId();

        //Afficher la page de création de soirée quand on clique sur le bouton dans le menu déroulé
        if (id == R.id.action_creersoiree) {
            /*Intent create = new Intent(this.getApplicationContext(), MainActivity.class);
            create.putExtra("creer", 1);
            startActivity(create);*/
            //Fragment creerSoiree = new SecondFragment();ut.fragment_first)
            //getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_main, creerSoiree).commit();
            navController.navigate(R.id.creerUneSoiree);
            return true;
        }
        else if (id == R.id.action_recherchesoiree) {
            navController.navigate(R.id.rechercheUneSoiree);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }



}