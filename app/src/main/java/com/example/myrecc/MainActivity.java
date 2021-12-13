package com.example.myrecc;

import android.content.Context;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    List<Soiree> lesSoirees = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Verification de l'existance du fichier donnees.txt

        String donnee = this.readFromFile(getApplicationContext());
        Log.i("Donn","Donnees : "+donnee);
        if (donnee.isEmpty()){
            CompteUtilisateur cu1 = new CompteUtilisateur("Pesquet", "Thomas", 50, "rue spatial", 17000, "thomas@nasa.com", "toto", "123");
            CompteUtilisateur cu2 = new CompteUtilisateur("Hollande", "François", 55, "rue de la république", 54211, "holland@elysé.com", "president", "000");
            CompteUtilisateur cu3 = new CompteUtilisateur("Quiroule", "Pierre", 22, "rue de la grotte", 56000, "pierre@tombe.com", "pepe", "456");
            CompteUtilisateur cu4 = new CompteUtilisateur("Lateur", "Venti", 64, "rue du vent", 14700, "vent@souffle.com", "fort", "999");
            CompteUtilisateur cu5 = new CompteUtilisateur("Mie", "Calline", 12, "rue de la boulangerie", 64000, "boulan@gerie.com", "boubou", "200");
            CompteUtilisateur cu6 = new CompteUtilisateur("Mortred", "Anthony", 19, "13 rue de la moelle", 16954, "anthony@mortred.com", "Anth0nyM0", "oui");

            Soiree so1 = new Soiree(cu2, "14 rue des collombes", "Paris", 93000, "30 Novembre", "20h00", "Soiree sympa pour faire des potes", 1, 1);
            Soiree so2 = new Soiree(cu2, "25 rue des flammes", "Aix", 13080, "2 Décembre", "21h00", "Soiree pour se faire du bien, pour oublier nos problèmes", 1, 1);
            Soiree so3 = new Soiree(cu2, "78 place des Agences", "Bordeaux", 30072, "3 Décembre", "19h00", "Soiree pour passer un bon temps, pas de souci, pas trop de monde", 0, 0);
            Soiree so4 = new Soiree(cu2, "44 rue Pierre Loti", "Rochefort", 17300, "25 Décembre", "00h00", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.", 1, 0);
            Soiree so5 = new Soiree(cu2, "11 rue de Gaule", "Saintes", 26000, "12 Décembre", "17h30", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.", 0, 1);
            Soiree so6 = new Soiree(cu2, "40 Place du centre", "Surgères", 14004, "4 Janvier", "22h30", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.", 0, 0);
            Soiree so7 = new Soiree(cu2, "22 rue du collisé", "Tours", 50200, "22 Février", "12h00", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.", 1, 1);
            Soiree so8 = new Soiree(cu3, "Avenue de la liberté", "Lille", 54000, "19 Juin", "22:15", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.", 0, 1);
            Soiree so9 = new Soiree(cu3, "Les champs elysées", "Paris", 93000, "31 Decembre", "21:30", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.", 0, 0);
            Soiree so10 = new Soiree(cu4, "95 rue du metro", "Brest", 59000, "16 Aout", "19:30", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.", 1, 0);
            Soiree so11 = new Soiree(cu5, "113 rue Robespierre", "Toulouse", 94989, "25 Novembre", "17:30", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.", 1, 1);
            Soiree so12 = new Soiree(cu6, "13 rue de la moelle", "Rochefort", 16954, "17 Mars", "21:30", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.", 1, 1);

            String data ="{\"lesSoiree\":["+
                    so1.toString()+
                            so2.toString()+","+
                            so3.toString()+","+
                            so4.toString()+","+
                            so5.toString()+","+
                            so6.toString()+","+
                            so7.toString()+","+
                            so8.toString()+","+
                            so9.toString()+","+
                            so10.toString()+","+
                            so11.toString()+","+
                            so12.toString();

            this.writeToFile(data,getApplicationContext());

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
        }
        String données = this.readFromFile(getApplicationContext());
        Log.i("Donn","Donnees : "+données);

        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        Bundle extra = getIntent().getExtras();
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        layoutManager =  new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //Initialisation des données en brut
        if(lesSoirees.isEmpty()){
            Log.i("reset", "reset des données");
            //this.Initialisation();
            this.recupJSON();
        }


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
        recyclerView.setAdapter(adapter);


        if(extra!=null){
            if(extra.get("detail")!=null){
                Fragment detailSoiree = new DetailSoireeFragment();
                Bundle bundle = new Bundle();
                Log.i("position", "position n°"+extra.get("position"));

                String desc = extra.get("detail").toString();
                bundle.putString("desc",desc);

                detailSoiree.setArguments(bundle);

                ///navController.navigate(R.id.detailDeSoiree);

                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_main, detailSoiree).commit();
            }
        }
        else {
            adapter = new SoireeAdapter(lesSoirees);
        }
        recyclerView.setAdapter(adapter);
//
//        if(extra!=null){
//            if(extra.get("detail")!=null){
//                Fragment detailSoiree = new DetailSoireeFragment();
//                Bundle bundle = new Bundle();
//                Log.i("position", "position n°"+extra.get("position"));
//
//                String desc = extra.get("detail").toString();
//                bundle.putString("desc",desc);
//
//                detailSoiree.setArguments(bundle);
//
//                ///navController.navigate(R.id.detailDeSoiree);
//
//                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_main, detailSoiree).commit();
//            }
//        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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
            //Fragment creerSoiree = new SecondFragment();
            //getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_main, creerSoiree).commit();
            navController.navigate(R.id.creerUneSoiree);
            return true;
        }
        else if (id == R.id.action_recherchesoiree) {
            //Fragment rechercheSoiree = new FirstFragment();
            //getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_main, rechercheSoiree).commit();
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
    private String readFromFile(Context context) {

        String ret = "";

        try {
            InputStream inputStream = context.openFileInput("donnees.json");

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append("\n").append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }

        return ret;
    }
    private void writeToFile(String data,Context context) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("donnees.json", Context.MODE_PRIVATE));
            outputStreamWriter.write(data+"]}");
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }


    public JSONObject recupJSON() {
        String donnee = this.readFromFile(getApplicationContext());
        lesSoirees.clear();
        JSONObject obj  = null;
        try {
            obj = new JSONObject(donnee);
            JSONArray soirees = obj.getJSONArray("lesSoiree ");
            for (int i = 0; i < soirees.length(); i++) {
//                    CompteUtilisateur orga, String adresse, String ville,int CP, String date, String heure, String description, int alcool, int soireeOuverte
                lesSoirees.add(new Soiree(
                        //soirees.getJSONObject(i).get("Organisateur"),
                        new CompteUtilisateur("Pesquet", "Thomas", 50, "rue spatial", 17000, "thomas@nasa.com", "toto", "123"),
                        soirees.getJSONObject(i).getString("adresse"),
                        soirees.getJSONObject(i).getString("ville"),
                        soirees.getJSONObject(i).getInt("CP"),
                        soirees.getJSONObject(i).getString("date"),
                        soirees.getJSONObject(i).getString("heure"),
                        soirees.getJSONObject(i).getString("description"),
                        soirees.getJSONObject(i).getInt("alcool"),
                        soirees.getJSONObject(i).getInt("soireeOuverte")
                        ));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return obj;
    }

}