package com.example.prography_quest;

import android.content.ClipData;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Fragment_byscore extends Fragment{
    private String url = "https://ghibliapi.herokuapp.com/films";
    private String htmlstring;

    private RecyclerView recyclerView;
    //private RecyclerAdapter adapter;
    private ArrayList<ItemObject> list = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v1 = inflater.inflate(R.layout.fragment_byscore, container, false);
        recyclerView = (RecyclerView) v1.findViewById(R.id.recyclerview);

        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerAdapter);

        //AsyncTask 작동시킴(파싱)
        new JsoupAsync().execute();

        return v1;
    }

    private class JsoupAsync extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Document doc = Jsoup.connect(url).ignoreContentType(true).get();
                Log.e("여기까지 실행됨","여기이이 ");
                Elements elements = doc.select("body");

                for(Element link : elements){
                    htmlstring += link.text().trim() + "( )";
                    Log.e("link : ", String.valueOf(link));
                    break;
                }

                list.add(new ItemObject("proro","me", "i love crong", "100", "crong"));

            } catch (IOException e){
                e.printStackTrace();
                Log.e("여기는 ", "예외 걸림");
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            /*
            //ArrayList을 인자로해서 어답터와 연결한다
            RecyclerAdapter recyclerAdapter = new RecyclerAdapter(list);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(recyclerAdapter);
            */

            Log.e("htmlstring은 ", htmlstring);
        }
    }


}

