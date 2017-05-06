package com.example.mehakmeet.newsapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class Intented_Activity extends AppCompatActivity {

    ImageView dow_img;
    TextView title;
    TextView desc;
    public class DownloadImageTask extends AsyncTask<String,Void,Bitmap> {

        @Override
        protected Bitmap doInBackground(String... urls) {

            try {

                URL url = new URL(urls[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                connection.connect();
                InputStream is = connection.getInputStream();
                Bitmap image = BitmapFactory.decodeStream(is);
                return image;

            } catch (MalformedURLException e) {

                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;

        }
    }
    public class DownloadTask extends AsyncTask<String,Void,String>
    {

        @Override
        protected String doInBackground(String... urls) {

            URL url;
            HttpURLConnection urlConnection=null;
            String result="";

            try {

                url=new URL(urls[0]);
                urlConnection=(HttpURLConnection)url.openConnection();
                InputStream is=urlConnection.getInputStream();
                InputStreamReader reader=new InputStreamReader(is);

                int data=reader.read();

                while(data!=-1)
                {
                    char current=(char) data;
                    result+=current;
                    data=reader.read();

                }

                return result;

            } catch (MalformedURLException e) {

                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        title=(TextView)findViewById(R.id.title);
        desc=(TextView)findViewById(R.id.desc);
        dow_img=(ImageView)findViewById(R.id.image);
        DownloadImageTask imageTask=new DownloadImageTask();

        DownloadTask task=new DownloadTask();
        String result=null;
        Intent i1=getIntent();
        String position_s=i1.getStringExtra(MainActivity.Extra);
        int pos=Integer.parseInt(position_s);
        if(pos==0) {//International news

            try {

                result = task.execute("https://newsapi.org/v1/articles?source=google-news&sortBy=top&apiKey=52182fd1efaa487f9d395eb5f1418aa6").get();

                {
                    try {
                        Bitmap img;
                        JSONObject jsonObject = new JSONObject(result);
                        String info = jsonObject.getString("articles");
                        JSONArray a = new JSONArray(info);
                        JSONObject jsonPart = a.getJSONObject(0);
                        img=imageTask.execute(jsonPart.getString("urlToImage")).get();
                        dow_img.setImageBitmap(img);
                        title.setText(jsonPart.getString("title"));
                        desc.setText(jsonPart.getString("description"));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            } catch (InterruptedException e) {

                e.printStackTrace();

            } catch (ExecutionException e) {

                e.printStackTrace();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(pos==1) {//National

            try {

                result = task.execute("https://newsapi.org/v1/articles?source=the-hindu&sortBy=top&apiKey=52182fd1efaa487f9d395eb5f1418aa6").get();

                {
                    try {
                        Bitmap img;
                        JSONObject jsonObject = new JSONObject(result);
                        String info = jsonObject.getString("articles");
                        JSONArray a = new JSONArray(info);
                        JSONObject jsonPart = a.getJSONObject(0);

                        img=imageTask.execute(jsonPart.getString("urlToImage")).get();
                        dow_img.setImageBitmap(img);
                        title.setText(jsonPart.getString("title"));
                        desc.setText(jsonPart.getString("description"));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            } catch (InterruptedException e) {

                e.printStackTrace();

            } catch (ExecutionException e) {

                e.printStackTrace();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }if(pos==2) {//Sports

            try {

                result = task.execute(" https://newsapi.org/v1/articles?source=espn&sortBy=top&apiKey=52182fd1efaa487f9d395eb5f1418aa6").get();

                {
                    try {
                        Bitmap img;
                        JSONObject jsonObject = new JSONObject(result);
                        String info = jsonObject.getString("articles");
                        JSONArray a = new JSONArray(info);
                        JSONObject jsonPart = a.getJSONObject(0);

                        img=imageTask.execute(jsonPart.getString("urlToImage")).get();
                        dow_img.setImageBitmap(img);
                        title.setText(jsonPart.getString("title"));
                        desc.setText(jsonPart.getString("description"));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            } catch (InterruptedException e) {

                e.printStackTrace();

            } catch (ExecutionException e) {

                e.printStackTrace();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }if(pos==3) {//Business

            try {

                result = task.execute("https://newsapi.org/v1/articles?source=fortune&sortBy=top&apiKey=52182fd1efaa487f9d395eb5f1418aa6").get();

                {
                    try {
                        Bitmap img;
                        JSONObject jsonObject = new JSONObject(result);
                        String info = jsonObject.getString("articles");
                        JSONArray a = new JSONArray(info);
                        JSONObject jsonPart = a.getJSONObject(0);

                        img=imageTask.execute(jsonPart.getString("urlToImage")).get();
                        dow_img.setImageBitmap(img);
                        title.setText(jsonPart.getString("title"));
                        desc.setText(jsonPart.getString("description"));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            } catch (InterruptedException e) {

                e.printStackTrace();

            } catch (ExecutionException e) {

                e.printStackTrace();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }if(pos==4) {//Entertainment

            try {

                result = task.execute("https://newsapi.org/v1/articles?source=mashable&sortBy=top&apiKey=52182fd1efaa487f9d395eb5f1418aa6").get();

                {
                    try {
                        Bitmap img;
                        JSONObject jsonObject = new JSONObject(result);
                        String info = jsonObject.getString("articles");
                        JSONArray a = new JSONArray(info);
                        JSONObject jsonPart = a.getJSONObject(0);

                        img=imageTask.execute(jsonPart.getString("urlToImage")).get();
                        dow_img.setImageBitmap(img);
                        title.setText(jsonPart.getString("title"));
                        desc.setText(jsonPart.getString("description"));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            } catch (InterruptedException e) {

                e.printStackTrace();

            } catch (ExecutionException e) {

                e.printStackTrace();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }if(pos==5) {//Weather

            try {

                result = task.execute("").get();

                {
                    try {
                        Bitmap img;
                        JSONObject jsonObject = new JSONObject(result);
                        String info = jsonObject.getString("articles");
                        JSONArray a = new JSONArray(info);
                        JSONObject jsonPart = a.getJSONObject(0);

                        img=imageTask.execute(jsonPart.getString("urlToImage")).get();
                        dow_img.setImageBitmap(img);
                        title.setText(jsonPart.getString("title"));
                        desc.setText(jsonPart.getString("description"));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            } catch (InterruptedException e) {

                e.printStackTrace();

            } catch (ExecutionException e) {

                e.printStackTrace();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(pos==6) {//Techno

            try {

                result = task.execute("https://newsapi.org/v1/articles?source=hacker-news&sortBy=top&apiKey=52182fd1efaa487f9d395eb5f1418aa6").get();

                {
                    try {
                        Bitmap img;
                        JSONObject jsonObject = new JSONObject(result);
                        String info = jsonObject.getString("articles");
                        JSONArray a = new JSONArray(info);
                        JSONObject jsonPart = a.getJSONObject(3);

                        img=imageTask.execute(jsonPart.getString("urlToImage")).get();
                        dow_img.setImageBitmap(img);
                        title.setText(jsonPart.getString("title"));
                        desc.setText(jsonPart.getString("description"));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            } catch (InterruptedException e) {

                e.printStackTrace();

            } catch (ExecutionException e) {

                e.printStackTrace();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
