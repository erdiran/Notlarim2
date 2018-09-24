package notlarim.erdioran.com.notlarim;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class FragmentMenu extends Fragment{

    /**

     public class FragmentMenu extends android.app.Fragment {
     private String menuItem[] = {"Yayın Akışı", "Uydu Bilgileri", "Bize Yazın"};
     private ListView listView;


     @Override
     public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


     View view = inflater.inflate(R.layout.fragment_menu, container, false);
     listView = (ListView) view.findViewById(R.id.list);

     ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, menuItem);
     listView.setAdapter(adapter);
     listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
     @Override
     public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
     switch (position) {
     case 0:
     startActivity(new Intent(getActivity(), YayinAkisiActivity.class));
     break;
     case 1:
     startActivity(new Intent(getActivity(), UyduBilgileriActivity.class));
     break;
     case 2:
     startActivity(new Intent(getActivity(), BizeYazinActivity.class));
     break;
     }
     }
     });
     return view;
     }


     }
     **/



    //////////////////////////////////////////////////////////


     /**
     private ListView listView;
     private ArrayList<String> menuItem = new ArrayList<>();


     @Override
     public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
          View view = inflater.inflate(R.layout.fragment_menu, container, false);
          menuItem.add("Uydu Bilgileri");
          menuItem.add("Bize Yazın");
          try {
               TurquazGDPRView.CheckConfig checkConfig = new TurquazGDPRView.CheckConfig().get(getActivity());
               menuItem.add(checkConfig.title);
          } catch (Exception e) {
          }


          listView = (ListView) view.findViewById(R.id.list);

          ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, menuItem);
          listView.setAdapter(adapter);
          listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
               @Override
               public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    switch (position) {

                         case 0:
                              try {
                                   TurquazGDPRView.CheckConfig checkConfig = new TurquazGDPRView.CheckConfig().get(getActivity());
                                   String url = checkConfig.url;
                                   Intent intent2 = new Intent(getActivity(), UyduBilgileriActivity.class);
                                   intent2.putExtra("url", url);
                                   startActivity(intent2);
                              } catch (Exception e) {
                              }

                              break;
                         case 1:
                              try {
                                   Intent intent1 = new Intent(getActivity(), WebViewActivity.class);
                                   intent1.putExtra("url", "https://bizeulasin.tmgrup.com.tr/ContactUs/form?pid=83");
                                   startActivity(intent1);
                              } catch (Exception e) {
                              }
                              break;
                         case 2:
                              try {
                                   TurquazGDPRView.CheckConfig checkConfig = new TurquazGDPRView.CheckConfig().get(getActivity());
                                   String url = checkConfig.url;
                                   Intent intent5 = new Intent(getActivity(), VeriPolitikasiActivity.class);
                                   intent5.putExtra("url", url);
                                   startActivity(intent5);
                              } catch (Exception e) {
                              }
                              break;


                    }
               }
          });
          return view;
     }
    **/

}
