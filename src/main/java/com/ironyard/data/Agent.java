package com.ironyard.data;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by osmanidris on 1/25/17.
 */
public class Agent {
    private String coverName;
    private String realName;
    private int accessLevel;

    public static ArrayList<Agent> loadPattern(){
        ArrayList<Agent> agentList = new ArrayList<>();
        Gson gson = new Gson();
        JsonParser jsonParser = new JsonParser();
        try {
            BufferedReader br = new BufferedReader(new FileReader(Agent.class.getClassLoader().getResource(Constants.jason_filename).getFile()));
            JsonElement jsonElement = jsonParser.parse(br);

            //Create generic type
            Type type = new TypeToken<ArrayList<Agent>>() {}.getType();
            br.close();
            return gson.fromJson(jsonElement, type);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return agentList;
    }

    public String getCoverName() {
        return coverName;
    }

    public void setCoverName(String coverName) {
        this.coverName = coverName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }
}
