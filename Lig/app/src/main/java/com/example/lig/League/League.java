package com.example.lig.League;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

//Fikstürü belirlerken 2 aşamalı olmalı

//TO DO


public class League {



    private String leagueName;



    Team[] teams = new Team[18];
    int teamAscii = 65; // takımın isimlerini string yerine harf olarak tutmak mantıklı geldi

    private int countWeek;
    private int tempWeek;

    List<Character> tempList = new ArrayList<Character>();  // Bu liste takımların isimlerini tutar
    List<Character> tempList2 = new ArrayList<Character>();

    Random rand = new Random();

    public League() {
        countWeek = 0;
        tempWeek = 0;
        for (int i = 0; i < teams.length; i++) {
            teams[i] = new Team((char) teamAscii);
            teamAscii++;
        }
        drawFixture();
    }



    private void drawFixture() {

        for (int i = 0; i < teams.length - 1; i++) {
            // İlk tur atamaları
            if (i == 0) {
                for (int j = 0; j < teams.length / 2; j++) {
                    teams[j].Fixture.add(teams[teams.length - j - 1].getTeamName());
                    teams[teams.length - j - 1].Fixture.add(teams[j].getTeamName());
                    tempList.add(teams[j].getTeamName());
                    tempList.add(teams[teams.length - j - 1].getTeamName());
                }
            } else {
                char lastTeam = tempList.get(teams.length - 1); // sonuncu elemanı alıyoruz

                if (i % 2 == 1) {
                    tempList2.add(teams[teams.length - 1].getTeamName()); //
                    tempList2.add(lastTeam);
                    teams[teams.length - 1].Fixture.add(lastTeam);
                    teams[findIndex(lastTeam)].Fixture.add(teams[teams.length - 1].getTeamName());
                }

                else {
                    tempList2.add(lastTeam);
                    tempList2.add(teams[teams.length - 1].getTeamName());
                    teams[teams.length - 1].Fixture.add(lastTeam);
                    teams[findIndex(lastTeam)].Fixture.add(teams[teams.length - 1].getTeamName());
                }

                tempList.remove(tempList.size() - 1);
                tempList.remove(tempList.indexOf(teams[teams.length - 1].getTeamName()));

                // burada ekleme yapmam lazım
                while (!tempList.isEmpty()) {

                    char temp;
                    char temp2;

                    temp2 = tempList.get(tempList.size() - 1);
                    tempList.remove(tempList.size() - 1);

                    temp = tempList.get(tempList.size() - 1);
                    tempList.remove(tempList.size() - 1);

                    tempList2.add(temp);
                    tempList2.add(temp2);

                    teams[findIndex(temp)].Fixture.add(temp2);
                    teams[findIndex(temp2)].Fixture.add(temp);
                }
                for (int j = 0; j < teams.length; j++) {
                    tempList.add(tempList2.get(j));
                }
                tempList2.clear();
            }
        }
    }



    private int findIndex(char ch) {
        int ret = 0;
        for (int i = 0; i < teams.length; i++) {
            if (teams[i].getTeamName() == ch) {
                ret = i;
                break;
            }
        }
        return ret;
    }


    //kod tekrarı oluyor bunu çöz

    public void Match() {
        int counter = 0;
        int len = 9;

        int awayGoal = 0;
        int homeGoal = 0;

        int homeAvantage = 7;
        int awayAvantage = 0;


        if(countWeek % 2 == 1) {
            counter = 9;
            len = 18;
        }

        if(countWeek > 16 ) {
            tempWeek = 0;
            homeAvantage = 0;
            awayAvantage = 7;
        }

        for (int i = counter ; i < len; i++) {

            int homeMidPower = teams[i].getMidPower() + homeAvantage;
            int awayMidPower = teams[findIndex(teams[i].Fixture.get(tempWeek))].getMidPower() + awayAvantage;

            List <Character> bag = new ArrayList<Character>();
            List <Character> goalChance = new ArrayList<Character>();

            for (int j = 0; j < homeMidPower; j++) {
                bag.add('E');
            }
            for (int j = 0; j < awayMidPower; j++) {
                bag.add('D');
            }

            for (int j = 0; j < teams[i].getAttackPower() + homeAvantage ; j++) {
                goalChance.add('G');
            }

            for (int j = 0; j < teams[findIndex(teams[i].Fixture.get(tempWeek))].getDefencePower() + awayAvantage; j++) {
                goalChance.add('N');
            }

            Collections.shuffle(bag);
            Collections.shuffle(goalChance);

            for (int j = 0; j < 10; j++){
                int selection = rand.nextInt(homeMidPower + awayMidPower);
                char ch = bag.get(selection);

                if(ch == 'E') {

                    int randomIndex = rand.nextInt(teams[i].getAttackPower() + teams[findIndex(teams[i].Fixture.get(tempWeek))].getDefencePower() + homeAvantage + awayAvantage);
                    char isGoal = goalChance.get(randomIndex);

                    if(isGoal == 'G') {
                        homeGoal++;
                        teams[i].setGoal();
                        teams[findIndex(teams[i].Fixture.get(tempWeek))].setConcadeGoal();
                    }

                }
                else {
                    int randomIndex = rand.nextInt(teams[i].getAttackPower() + teams[findIndex(teams[i].Fixture.get(tempWeek))].getDefencePower() + homeAvantage + awayAvantage);
                    char isGoal = goalChance.get(randomIndex);

                    if(isGoal == 'G') {
                        teams[i].setConcadeGoal();
                        teams[findIndex(teams[i].Fixture.get(tempWeek))].setGoal();
                        awayGoal++;
                    }
                }
            }
            if(awayGoal > homeGoal) {
                teams[findIndex(teams[i].Fixture.get(tempWeek))].setPoint(3);
            }
            else if(homeGoal > awayGoal) {
                teams[i].setPoint(3);
            }
            else{
                teams[findIndex(teams[i].Fixture.get(tempWeek))].setPoint(1);
                teams[i].setPoint(1);
            }
            awayGoal = 0;
            homeGoal = 0;
            bag.clear();
            goalChance.clear();
        }
        tempWeek++;
        countWeek++;
    }

    public void sortPoint() {
        Arrays.sort(teams , new Comparator<Team>() {
            @Override
            public int compare(Team b , Team a) {
                if (a.getPoint() == b.getPoint()) {
                    return a.getAverage().compareTo(b.getAverage());
                }

                return a.getPoint().compareTo(b.getPoint());
            }
        });
    }
    public void sortOverall() {
        Arrays.sort(teams , new Comparator<Team>() {
            @Override
            public int compare(Team b , Team a) {
                return a.getOverall().compareTo(b.getOverall());
            }
        });
    }
    public void sortAverage() {
        Arrays.sort(teams , new Comparator<Team>() {
            @Override
            public int compare(Team b , Team a) {
                return a.getAverage().compareTo(b.getAverage());
            }
        });
    }
    public void sortName() {
        Arrays.sort(teams , new Comparator<Team>() {
            @Override
            public int compare(Team b , Team a) {
                return b.getTeamName().compareTo(a.getTeamName());
            }
        });
    }

    public Team getTeam(int i) {
        return teams[i];
    }
    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }
    public int getLength(){ return  teams.length ;}


}
