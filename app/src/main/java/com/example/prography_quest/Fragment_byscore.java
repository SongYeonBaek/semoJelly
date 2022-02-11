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
    private ArrayList<ItemObject> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v1 = inflater.inflate(R.layout.fragment_byscore, container, false);
        recyclerView = (RecyclerView) v1.findViewById(R.id.recyclerview);

        //AsyncTask execute (url 파싱)
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
                //url 연결
                Document doc = Jsoup.connect(url).ignoreContentType(true).get();
                Elements elements = doc.select("body");

                for(Element link : elements){
                    htmlstring += link.text().trim() + "( )";
                    Log.e("link ", String.valueOf(link));
                    break;
                }
                //파싱한 결과를 Recycler view에 넣는 것을 실패하여
                //Log로 출력을 대신했습니다!
                Log.e("파싱한 결과 ", htmlstring);

            } catch(IOException e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            //이 부분에서 오류가 나서 AVD가 돌아가지 않아 주석처리했습니다.
            /*
            //ArrayList을 인자로해서 어답터와 연결
            RecyclerAdapter recyclerAdapter = new RecyclerAdapter(list);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(recyclerAdapter);

             */
        }
    }


}

