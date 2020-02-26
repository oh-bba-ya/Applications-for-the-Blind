package com.example.blind_project_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CSVFile {
    InputStream inputStream;

    public CSVFile(InputStream inputStream){
        this.inputStream = inputStream;
    }
    public String[] read(){
        String[] resultList = new String[20000];
        String[] record = new String[2];
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try{
            String csvLine;
            int i=0;
            while((csvLine = reader.readLine()) != null){
                record = csvLine.split(",");
                resultList[i]=record[0];
                resultList[i+1]=record[1];
                i+=2;
            }
        }

                catch (IOException ex){
                    throw new RuntimeException("Error in reading CSV file: "+ex);
                }

                finally{
                    try{
                        inputStream.close();
                    }
                    catch (IOException e){
                        throw new RuntimeException("Error while closing input stream: "+e);
                    }
                }

                return resultList;
    }
}
