package com.wedding.pagesecond;

 

import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStream;

import java.io.InputStreamReader;

import java.io.UnsupportedEncodingException;

import java.util.List;

 

import org.apache.http.HttpEntity;

import org.apache.http.HttpResponse;

import org.apache.http.NameValuePair;

import org.apache.http.client.ClientProtocolException;

import org.apache.http.client.entity.UrlEncodedFormEntity;

import org.apache.http.client.methods.HttpGet;

import org.apache.http.client.methods.HttpPost;

import org.apache.http.client.utils.URLEncodedUtils;

import org.apache.http.impl.client.DefaultHttpClient;

import org.json.JSONException;

import org.json.JSONObject;

 

import android.util.Log;

 

public class JSONParser {

 

    static InputStream inputStream = null;

    static JSONObject jObject = null;

    static String jsonString = "";

 

    // constructor

    public JSONParser() {

 

    }

 

    // function get json from url

    // by making HTTP POST or GET mehtod

    public JSONObject makeHttpRequest(String url, String method,

            List<NameValuePair> params) {

 

        // Making HTTP request

        try {

 

            // check for request method

            if(method == "POST"){

                // request method is POST

                // defaultHttpClient

                DefaultHttpClient client = new DefaultHttpClient();

                HttpPost post = new HttpPost(url);

                post.setEntity(new UrlEncodedFormEntity(params));

 

                HttpResponse httpResponse = client.execute(post);

                HttpEntity entity = httpResponse.getEntity();

                inputStream = entity.getContent();

 

            }else if(method == "GET"){

                // request method is GET

                DefaultHttpClient httpClient = new DefaultHttpClient();

                String paramString = URLEncodedUtils.format(params, "utf-8");

                url += "?" + paramString;

                HttpGet httpGet = new HttpGet(url);

 

                HttpResponse httpResponse = httpClient.execute(httpGet);

                HttpEntity httpEntity = httpResponse.getEntity();

                inputStream = httpEntity.getContent();

            }          

 

        } catch (UnsupportedEncodingException e) {

            e.printStackTrace();

        } catch (ClientProtocolException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

 

        try {

            BufferedReader  bufferedReader = new BufferedReader(new InputStreamReader(

                    inputStream, "iso-8859-1"), 8);

            StringBuilder stringBuilder = new StringBuilder();

            String line = null;

            while ((line = bufferedReader.readLine()) != null) {

                stringBuilder.append(line + "\n");

            }

            inputStream.close();

            jsonString = stringBuilder.toString();

        } catch (Exception e) {

            Log.e("Buffer Error", "Error converting result " + e.toString());

        }

        Log.d("debug", "string: "+jsonString);

 

 

        // try parse the string to a JSON object

        try {

            jObject = new JSONObject(jsonString);

        } catch (JSONException e) {

            Log.e("JSON Parser", "Error parsing data " + e.toString());

        }

 

        // return JSON String

        return jObject;

 

    }

}