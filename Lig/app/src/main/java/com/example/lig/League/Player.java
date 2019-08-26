package com.example.lig.League;

import java.util.HashMap;
import java.util.Random;

//Oyuncuların mevkisi olacak savunma ve atak diye
//Fiziksel , mental tarzı özellikleri olacak
//Belirlenen özelliklere göre oyuncunun gücü belirlenecek

//kaleci ata , defans ata , forward ata gibi fonksiyonlarla çözebiliriz
//maplere ilk değer atamalarını yapmam gerekiyor

public class Player {

    private String playerName;
    private int Age;
    Position position;

    private int Mid; // orta saha gücünü tutar
    private int Def; // defans gücünü tutar
    private int Attack; // hücum gücünü tutar

    int GoalKeeping; // Eğer kaleci ise setlenecek

    Random rand = new Random();
    int i; // iterator

    HashMap<String, Integer> Defence = new HashMap<String, Integer>();
    HashMap<String, Integer> MidField = new HashMap<String, Integer>();
    HashMap<String, Integer> Forward = new HashMap<String, Integer>();

    public Player(String name, int age, Position pos) {
        Mid = 0;
        Def = 0;
        Attack = 0;
        playerName = name;
        Age = age;
        GoalKeeping = 0;
        position = pos;

        i = rand.nextInt(40) + 10;
        MidField.put("corners", i);
        i = rand.nextInt(40) + 10;
        MidField.put("crossing", i);
        i = rand.nextInt(40) + 10;
        MidField.put("dribbling", i);
        i = rand.nextInt(40) + 10;
        MidField.put("longshots", i);
        i = rand.nextInt(40) + 10;
        MidField.put("passing", i);
        i = rand.nextInt(40) + 10;
        MidField.put("technique", i);

        i = rand.nextInt(40) + 10;
        Forward.put("technique", i);
        i = rand.nextInt(40) + 10;
        Forward.put("passing", i);
        i = rand.nextInt(40) + 10;
        Forward.put("longshots", i);
        i = rand.nextInt(40) + 10;
        Forward.put("heading", i);
        i = rand.nextInt(40) + 10;
        Forward.put("finishing", i);
        i = rand.nextInt(40) + 10;
        Forward.put("firsttouch", i);

        i = rand.nextInt(40) + 10;
        Defence.put("firsttouch", i);
        i = rand.nextInt(40) + 10;
        Defence.put("heading", i);
        i = rand.nextInt(40) + 10;
        Defence.put("longthrows", i);
        i = rand.nextInt(40) + 10;
        Defence.put("marking", i);
        i = rand.nextInt(40) + 10;
        Defence.put("tackling", i);
        i = rand.nextInt(40) + 10;
        Defence.put("bravery", i);
        i = rand.nextInt(40) + 10;
        Defence.put("aggression", i);
        i = rand.nextInt(40) + 10;
        Defence.put("positioning", i);

        assignFeatures();
        calculateOverall();
    }

    // Oyuncuların bölgelerine göre özelliklerini random bir şekilde atıyoruz

    private void assignFeatures() {

        if (position == Position.MIDFIELD) {

            i = rand.nextInt(40) + 60;
            MidField.put("corners", i);
            i = rand.nextInt(40) + 60;
            MidField.put("crossing", i);
            i = rand.nextInt(40) + 60;
            MidField.put("dribbling", i);
            i = rand.nextInt(40) + 60;
            MidField.put("longshots", i);
            i = rand.nextInt(40) + 60;
            MidField.put("passing", i);
            i = rand.nextInt(40) + 60;
            MidField.put("technique", i);
        } else if (position == Position.FORWARD) {
            i = rand.nextInt(40) + 60;
            Forward.put("technique", i);
            i = rand.nextInt(40) + 60;
            Forward.put("passing", i);
            i = rand.nextInt(40) + 60;
            Forward.put("longshots", i);
            i = rand.nextInt(40) + 60;
            Forward.put("heading", i);
            i = rand.nextInt(40) + 60;
            Forward.put("finishing", i);
            i = rand.nextInt(40) + 60;
            Forward.put("firsttouch", i);
        } else if (position == Position.DEFENCE) {

            i = rand.nextInt(40) + 60;
            Defence.put("firsttouch", i);
            i = rand.nextInt(40) + 60;
            Defence.put("heading", i);
            i = rand.nextInt(40) + 60;
            Defence.put("longthrows", i);
            i = rand.nextInt(40) + 60;
            Defence.put("marking", i);
            i = rand.nextInt(40) + 60;
            Defence.put("tackling", i);
            i = rand.nextInt(40) + 60;
            Defence.put("bravery", i);
            i = rand.nextInt(40) + 60;
            Defence.put("aggression", i);
            i = rand.nextInt(40) + 60;
            Defence.put("positioning", i);

        } else {
            i = rand.nextInt(40) + 60;
            GoalKeeping = i;
        }
    }

    // Oyuncuların defans , ortasaha ve atak güçlerini hesaplıyoruz
    private void calculateOverall() {

        for (String key : MidField.keySet()) {
            Mid += MidField.get(key);
        }
        Mid /= MidField.size();

        for (String key : Forward.keySet()) {
            Attack += Forward.get(key);
        }
        Attack /= Forward.size();

        for (String key : Defence.keySet()) {
            Def += Defence.get(key);
        }
        Def /= Defence.size();
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getAge() {
        return Age;
    }

    public void setPlayerName(String name) {
        playerName = name;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public void setAttack(int attack) {
        Attack = attack;
    }

    public void setDef(int def) {
        Def = def;
    }

    public void setMid(int mid) {
        Mid = mid;
    }

    public int getAttack() {
        return Attack;
    }

    public int getMid() {
        return Mid;
    }

    public int getDef() {
        return Def;
    }

    public void setGoalKeeping(int goalkeeping) {
        GoalKeeping = goalkeeping;
    }

    public int getGoalKeeeping() {
        return GoalKeeping;
    }
}
