package com.codingelab.FinalAndroidProject;

import android.os.AsyncTask;

import org.json.JSONException;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;


public class managePhp extends AsyncTask<String,Void,String> {

    ArrayList<HashMap<String, String>> Items = new ArrayList<HashMap<String, String>>();
    @Override
    protected String doInBackground(String ... params) {
        if(params.length>0){
            if(params[0].equalsIgnoreCase("managePhp")){
                try {
                    onSyn(params);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }else if(params[0].equalsIgnoreCase("insert")){
               return onInsert(params);
            }else if(params[0].equalsIgnoreCase("update")){
                return onUpdate(params);
            }else if(params[0].equalsIgnoreCase("delete")){
                return onDelete(params);
            }else if(params[0].equalsIgnoreCase("read")){
                return Read(params);
            }
        }
        return null;
    }
    private String onInsert(String ... params){
        String phpPageULR="http://192.168.43.67:80/sqli/mysql_write.php";
        try {

            URL url=new URL(phpPageULR);

            HttpURLConnection channel=(HttpURLConnection) url.openConnection();

            channel.setRequestMethod("POST");
            channel.setDoOutput(true);

            OutputStream subChannel=channel.getOutputStream();

            OutputStreamWriter pen=new OutputStreamWriter(subChannel,"UTF-8");

            BufferedWriter student =new BufferedWriter(pen);

            String userid = URLEncoder.encode("userid", "UTF-8") + "=" + URLEncoder.encode("-1", "UTF-8");
            String name = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(params[1], "UTF-8");
            String phone = URLEncoder.encode("phone", "UTF-8") + "=" + URLEncoder.encode(params[2], "UTF-8");
            String email = URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(params[3], "UTF-8");
            String operation = URLEncoder.encode("operation", "UTF-8") + "=" + URLEncoder.encode("insert", "UTF-8");
            String information=userid+"&"+name+"&"+phone+"&"+email+"&"+operation;

            student.write(information);

            student.flush();

            student.close();
            System.out.println(params[1]);
            System.out.println(params[2]);
            System.out.println(params[3]);

            subChannel.close();
            InputStream serverResponse = channel.getInputStream();
            serverResponse.close();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Insert data to MySQL";
    }

    private String onSyncInsert(String ... params){
        String phpPageULR="http://192.168.43.67:80/sqli/mysql_write.php";
        try {

            URL url=new URL(phpPageULR);

            HttpURLConnection channel=(HttpURLConnection) url.openConnection();

            channel.setRequestMethod("POST");
            channel.setDoOutput(true);

            OutputStream subChannel=channel.getOutputStream();

            OutputStreamWriter pen=new OutputStreamWriter(subChannel,"UTF-8");

            BufferedWriter student =new BufferedWriter(pen);

            String userid = URLEncoder.encode("userid", "UTF-8") + "=" + URLEncoder.encode(params[1], "UTF-8");
            String name = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(params[2], "UTF-8");
            String phone = URLEncoder.encode("phone", "UTF-8") + "=" + URLEncoder.encode(params[3], "UTF-8");
            String email = URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(params[4], "UTF-8");
            String operation = URLEncoder.encode("operation", "UTF-8") + "=" + URLEncoder.encode("insert", "UTF-8");
            String information=userid+"&"+name+"&"+phone+"&"+email+"&"+operation;

            student.write(information);

            student.flush();

            student.close();
            System.out.println(params[1]);
            System.out.println(params[2]);
            System.out.println(params[3]);

            subChannel.close();
            InputStream serverResponse = channel.getInputStream();
            serverResponse.close();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Insert data to MySQL";
    }




    private String onUpdate(String ... params){
        String phpPageULR="http://192.168.43.67:80/sqli/mysql_write.php";
        try {

            URL url=new URL(phpPageULR);
            HttpURLConnection channel=(HttpURLConnection) url.openConnection();
            channel.setRequestMethod("POST");
            channel.setDoOutput(true);

            OutputStream subChannel=channel.getOutputStream();
            OutputStreamWriter pen=new OutputStreamWriter(subChannel,"UTF-8");
            BufferedWriter student =new BufferedWriter(pen);
            String userid = URLEncoder.encode("userid", "UTF-8") + "=" +URLEncoder.encode(params[4], "UTF-8");
            String name = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(params[1], "UTF-8");
            String phone = URLEncoder.encode("phone", "UTF-8") + "=" + URLEncoder.encode(params[2], "UTF-8");
            String email = URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(params[3], "UTF-8");
            String operation = URLEncoder.encode("operation", "UTF-8") + "=" + URLEncoder.encode("update", "UTF-8");
            String information=userid+"&"+name+"&"+phone+"&"+email+"&"+operation;
            student.write(information);
            student.flush();
            student.close();
            System.out.println(params[1]);
            System.out.println(params[2]);
            System.out.println(params[3]);
            subChannel.close();
            InputStream serverResponse = channel.getInputStream();
            serverResponse.close();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Data Updated";
    }
    private String onDelete(String ... params){
        String phpPageULR="http://192.168.43.67:80/sqli/mysql_write.php";
        try {
            URL url=new URL(phpPageULR);
            HttpURLConnection channel=(HttpURLConnection) url.openConnection();
            channel.setRequestMethod("POST");
            channel.setDoOutput(true);
            OutputStream subChannel=channel.getOutputStream();
            OutputStreamWriter pen=new OutputStreamWriter(subChannel,"UTF-8");
            BufferedWriter student =new BufferedWriter(pen);
            String userid = URLEncoder.encode("userid", "UTF-8") + "=" + URLEncoder.encode(params[1], "UTF-8");
            String operation = URLEncoder.encode("operation", "UTF-8") + "=" + URLEncoder.encode("delete", "UTF-8");

            String information=userid+"&"+operation;

            student.write(information);

            student.flush();

            student.close();
            System.out.println("--ID-->"+params[1]);

            subChannel.close();
            InputStream serverResponse = channel.getInputStream();
            serverResponse.close();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Delete data from MySQL";
    }


    private String Read(String ... params){
        String phpPageULR="http://192.168.43.67:80/sqli/mysql_read.php";
        try {
            URL url=new URL(phpPageULR);
            HttpURLConnection channel=(HttpURLConnection) url.openConnection();
            channel.setRequestMethod("POST");
            channel.setDoOutput(true);

            OutputStream subChannel=channel.getOutputStream();
            OutputStreamWriter pen=new OutputStreamWriter(subChannel,"UTF-8");
            BufferedWriter student =new BufferedWriter(pen);
            String delete = URLEncoder.encode("delete", "UTF-8") + "=" + URLEncoder.encode(params[1], "UTF-8");
            String information=delete;
            student.write(information);
            student.flush();
            student.close();
            System.out.println("--ID-->"+params[1]);
            subChannel.close();
            InputStream serverResponse = channel.getInputStream();
            serverResponse.close();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Delete data from MySQL";
    }


    private void onSyn(String ... params) throws JSONException {

            String idd = params[1];
            //map.put("id",idd);
            String name = params[2];
            //map.put("name",name);
            String phone = params[3];
            //map.put("phone",phone);
            String email = params[4];
            //map.put("email",email);
            //Items.add(map);

        onSyncInsert("insert", idd, name, phone, email);





    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
    }
}

