package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.adapter.ExpandableRecyclerAdapter;
import com.example.myapplication.adapter.MainMenuAdapter;
import com.example.myapplication.model.MainMenu;
import com.example.myapplication.model.MenuType;
import com.example.myapplication.model.ResponseModel;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private MainMenuAdapter adapter;
    private List<MainMenuAdapter.ListItem> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponentMenu();
    }

    private void initComponentMenu() {

        recycler = (RecyclerView) findViewById(R.id.main_recycler);

        adapter = new MainMenuAdapter(this, generateMenuItems(), new MainMenuAdapter.OnItemClickListener() {

            @Override

            public void onItemClick(View view, int itemId) {

                // onMenuItemSelected(itemId);
                Toast.makeText(getApplicationContext(), "Item "+ itemId + "Clicked",Toast.LENGTH_SHORT).show();

            }

        });

        adapter.setMode(ExpandableRecyclerAdapter.MODE_ACCORDION);

        recycler.setLayoutManager(new LinearLayoutManager(this));

        recycler.setNestedScrollingEnabled(false);

        recycler.setAdapter(adapter);

    }

    private List<MainMenuAdapter.ListItem> generateMenuItems() {

        items = new ArrayList<>();


        Gson gson = new Gson();

        ResponseModel responseModel = gson.fromJson(jsonString, ResponseModel.class);

        try {
            JSONObject jsonObject = new JSONObject(jsonString);

            JSONObject jsonObject1 = jsonObject.getJSONObject("mainMenus");
            JSONArray jsonArray = jsonObject1.getJSONArray("mainMenu");
            recursivelyParse(new MainMenu(), jsonArray);
        }
        catch (JSONException e){
            e.printStackTrace();
        }

        return items;

    }

    int k=100;

    private  int menuTypeTracker = 1;

    private void recursivelyParse(MainMenu menu, JSONArray jsonArray) throws JSONException {
        if (jsonArray.length()==0){
            menuTypeTracker--;
            return ;
        }

        for (int i=0; i<jsonArray.length(); i++){
            menu.setMenuItemCdDesc(jsonArray.getJSONObject(i).getString("menuItemCdDesc"));
            //menu.setSubMenu(jsonArray.getJSONObject(i).getJSONArray("subMenu"));
            if (menuTypeTracker==1){
                items.add(new MainMenuAdapter.ListItem(++k, menu.getMenuItemCdDesc(),R.drawable.ic_launcher_background, MenuType.HEADER));
            }
            else if (menuTypeTracker==2){
                items.add(new MainMenuAdapter.ListItem(++k, menu.getMenuItemCdDesc(),-1, MenuType.SUB_HEADER));

            }

            menuTypeTracker++;
            recursivelyParse(new MainMenu(), jsonArray.getJSONObject(i).getJSONArray("subMenu"));
        }
        menuTypeTracker--;
    }

    String jsonString = "{\n" +
            "  \"responseHeader\": {\n" +
            "    \"sessionId\": \"123456\",\n" +
            "    \"fedExId\": \"123456\",\n" +
            "    \"flightId\": \"39805\"\n" +
            "  },\n" +
            "  \"exception\": null,\n" +
            "  \"flightBodyType\": \"W\",\n" +
            "  \"ctmsStatus\": \"UP\",\n" +
            "  \"mainMenus\": {\n" +
            "    \"mainMenu\": [\n" +
            "      {\n" +
            "        \"comptCd\": \"AI\",\n" +
            "        \"menuItemCdDesc\": \"A/C INSPECTION\",\n" +
            "        \"userTrained\": \"Y\",\n" +
            "        \"chkReqFlg\": \"N\",\n" +
            "        \"subMenu\": [\n" +
            "          {\n" +
            "            \"comptCd\": \"PREC\",\n" +
            "            \"menuItemCdDesc\": \"PRE EXTERIOR CHECKLIST\",\n" +
            "            \"userTrained\": \"Y\",\n" +
            "            \"chkReqFlg\": \"Y\",\n" +
            "            \"subMenu\": []\n" +
            "          },\n" +
            "          {\n" +
            "            \"comptCd\": \"UDC\",\n" +
            "            \"menuItemCdDesc\": \"UD COMPARTMENT CHECKLIST\",\n" +
            "            \"userTrained\": \"Y\",\n" +
            "            \"chkReqFlg\": \"Y\",\n" +
            "            \"subMenu\": []\n" +
            "          },\n" +
            "          {\n" +
            "            \"comptCd\": \"FWDC\",\n" +
            "            \"menuItemCdDesc\": \"FWD COMPARTMENT CHECKLIST\",\n" +
            "            \"userTrained\": \"Y\",\n" +
            "            \"chkReqFlg\": \"Y\",\n" +
            "            \"subMenu\": []\n" +
            "          },\n" +
            "          {\n" +
            "            \"comptCd\": \"AFTC\",\n" +
            "            \"menuItemCdDesc\": \"AFT COMPARTMENT CHECKLIST\",\n" +
            "            \"userTrained\": \"Y\",\n" +
            "            \"chkReqFlg\": \"Y\",\n" +
            "            \"subMenu\": []\n" +
            "          },\n" +
            "          {\n" +
            "            \"comptCd\": \"ABKC\",\n" +
            "            \"menuItemCdDesc\": \"ABK COMPARTMENT CHECKLIST\",\n" +
            "            \"userTrained\": \"Y\",\n" +
            "            \"chkReqFlg\": \"Y\",\n" +
            "            \"subMenu\": []\n" +
            "          },\n" +
            "          {\n" +
            "            \"comptCd\": \"POEC\",\n" +
            "            \"menuItemCdDesc\": \"POST EXTERIOR CHECKLIST\",\n" +
            "            \"userTrained\": \"Y\",\n" +
            "            \"chkReqFlg\": \"N\",\n" +
            "            \"subMenu\": []\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      {\n" +
            "        \"comptCd\": \"SC\",\n" +
            "        \"menuItemCdDesc\": \"SECURITY CHECK\",\n" +
            "        \"userTrained\": \"Y\",\n" +
            "        \"chkReqFlg\": \"Y\",\n" +
            "        \"subMenu\": [\n" +
            "          {\n" +
            "            \"comptCd\": \"UDSC\",\n" +
            "            \"menuItemCdDesc\": \"UD COMPARTMENT CHECKLIST\",\n" +
            "            \"userTrained\": \"Y\",\n" +
            "            \"chkReqFlg\": \"Y\",\n" +
            "            \"subMenu\": []\n" +
            "          },\n" +
            "          {\n" +
            "            \"comptCd\": \"FWDSC\",\n" +
            "            \"menuItemCdDesc\": \"FWD COMPARTMENT CHECKLIST\",\n" +
            "            \"userTrained\": \"Y\",\n" +
            "            \"chkReqFlg\": \"Y\",\n" +
            "            \"subMenu\": []\n" +
            "          },\n" +
            "          {\n" +
            "            \"comptCd\": \"AFTSC\",\n" +
            "            \"menuItemCdDesc\": \"AFT COMPARTMENT CHECKLIST\",\n" +
            "            \"userTrained\": \"Y\",\n" +
            "            \"chkReqFlg\": \"Y\",\n" +
            "            \"subMenu\": []\n" +
            "          },\n" +
            "          {\n" +
            "            \"comptCd\": \"ABKSC\",\n" +
            "            \"menuItemCdDesc\": \"ABK COMPARTMENT CHECKLIST\",\n" +
            "            \"userTrained\": \"Y\",\n" +
            "            \"chkReqFlg\": \"Y\",\n" +
            "            \"subMenu\": []\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      {\n" +
            "        \"comptCd\": \"UD\",\n" +
            "        \"menuItemCdDesc\": \"UD ULD CHECK\",\n" +
            "        \"userTrained\": \"Y\",\n" +
            "        \"chkReqFlg\": \"N\",\n" +
            "        \"subMenu\": []\n" +
            "      },\n" +
            "      {\n" +
            "        \"comptCd\": \"UD\",\n" +
            "        \"menuItemCdDesc\": \"UD POS CHECK\",\n" +
            "        \"userTrained\": \"Y\",\n" +
            "        \"chkReqFlg\": \"N\",\n" +
            "        \"subMenu\": []\n" +
            "      },\n" +
            "      {\n" +
            "        \"comptCd\": \"FWDLD\",\n" +
            "        \"menuItemCdDesc\": \"FWD LD ULD CHECK\",\n" +
            "        \"userTrained\": \"Y\",\n" +
            "        \"chkReqFlg\": \"N\",\n" +
            "        \"subMenu\": []\n" +
            "      },\n" +
            "      {\n" +
            "        \"comptCd\": \"FWDLD\",\n" +
            "        \"menuItemCdDesc\": \"FWD LD POS CHECK\",\n" +
            "        \"userTrained\": \"Y\",\n" +
            "        \"chkReqFlg\": \"N\",\n" +
            "        \"subMenu\": []\n" +
            "      },\n" +
            "      {\n" +
            "        \"comptCd\": \"AFTLD\",\n" +
            "        \"menuItemCdDesc\": \"AFT LD ULD CHECK\",\n" +
            "        \"userTrained\": \"Y\",\n" +
            "        \"chkReqFlg\": \"N\",\n" +
            "        \"subMenu\": []\n" +
            "      },\n" +
            "      {\n" +
            "        \"comptCd\": \"AFTLD\",\n" +
            "        \"menuItemCdDesc\": \"AFT LD POS CHECK\",\n" +
            "        \"userTrained\": \"Y\",\n" +
            "        \"chkReqFlg\": \"N\",\n" +
            "        \"subMenu\": []\n" +
            "      },\n" +
            "      {\n" +
            "        \"comptCd\": \"BPC\",\n" +
            "        \"menuItemCdDesc\": \"BULK POS CHECK\",\n" +
            "        \"userTrained\": \"Y\",\n" +
            "        \"chkReqFlg\": \"N\",\n" +
            "        \"subMenu\": []\n" +
            "      },\n" +
            "      {\n" +
            "        \"comptCd\": \"AOS\",\n" +
            "        \"menuItemCdDesc\": \"AV ONE STEP\",\n" +
            "        \"userTrained\": \"Y\",\n" +
            "        \"chkReqFlg\": \"N\",\n" +
            "        \"subMenu\": []\n" +
            "      },\n" +
            "      {\n" +
            "        \"comptCd\": \"FD\",\n" +
            "        \"menuItemCdDesc\": \"FLIGHT DATA\",\n" +
            "        \"userTrained\": \"Y\",\n" +
            "        \"chkReqFlg\": \"N\",\n" +
            "        \"subMenu\": []\n" +
            "      },\n" +
            "      {\n" +
            "        \"comptCd\": \"FCJ\",\n" +
            "        \"menuItemCdDesc\": \"FLT CREW & J/S\",\n" +
            "        \"userTrained\": \"Y\",\n" +
            "        \"chkReqFlg\": \"N\",\n" +
            "        \"subMenu\": [\n" +
            "          {\n" +
            "            \"comptCd\": \"FJ\",\n" +
            "            \"menuItemCdDesc\": \"JUMPSEATERS\",\n" +
            "            \"userTrained\": \"Y\",\n" +
            "            \"chkReqFlg\": \"N\",\n" +
            "            \"subMenu\": []\n" +
            "          },\n" +
            "          {\n" +
            "            \"comptCd\": \"FC\",\n" +
            "            \"menuItemCdDesc\": \"FLIGHT CREW\",\n" +
            "            \"userTrained\": \"Y\",\n" +
            "            \"chkReqFlg\": \"N\",\n" +
            "            \"subMenu\": []\n" +
            "          },\n" +
            "          {\n" +
            "            \"comptCd\": \"CSC\",\n" +
            "            \"menuItemCdDesc\": \"FLT CREW SECURITY CHECK\",\n" +
            "            \"userTrained\": \"Y\",\n" +
            "            \"chkReqFlg\": \"N\",\n" +
            "            \"subMenu\": []\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      {\n" +
            "        \"comptCd\": \"FV\",\n" +
            "        \"menuItemCdDesc\": \"FINAL VERIFICATION\",\n" +
            "        \"userTrained\": \"Y\",\n" +
            "        \"chkReqFlg\": \"N\",\n" +
            "        \"subMenu\": []\n" +
            "      },\n" +
            "      {\n" +
            "        \"comptCd\": \"LM\",\n" +
            "        \"menuItemCdDesc\": \"LOAD MONITOR\",\n" +
            "        \"userTrained\": \"Y\",\n" +
            "        \"chkReqFlg\": \"N\",\n" +
            "        \"subMenu\": []\n" +
            "      }\n" +
            "    ],\n" +
            "    \"ctmsStatus\": null\n" +
            "  }\n" +
            "}";

}
