package com.example.lig.League;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Team implements Comparable<Team>{

    private Character teamName;

    // lig bilgileri
    private Integer Point;
    private Integer Average;

    private int Goal;


    private int ConcadeGoal;
    // Performans bilgileri
    private Integer Overall;
    private int AttackPower;
    private int MidPower;
    private int DefencePower;

    Random rand = new Random();

    // oyuncu dizileri
    public Player[] goalKeepers = new Player[3];
    public Player[] defence = new Player[8];
    Player[] midfield = new Player[8];
    Player[] forward = new Player[6];

    public List<Character> Fixture = new ArrayList<Character>();

    public Team(char name) {

        // setter fonksiyonlar

        setTeamName(name);
        setDefencePower(0);
        setAttackPower(0);
        setMidPower(0);
        setOverall(0);

        Point = 0;
        Average = 0;

        for (int i = 0; i < goalKeepers.length; i++) {
            int Age = rand.nextInt(20) + 15;
            goalKeepers[i] = new Player("Yasin", Age, Position.GOALKEEPER);
        }

        for (int i = 0; i < defence.length; i++) {
            int Age = rand.nextInt(20) + 15;
            defence[i] = new Player("Yasin", Age, Position.DEFENCE);
        }

        for (int i = 0; i < midfield.length; i++) {
            int Age = rand.nextInt(20) + 15;
            midfield[i] = new Player("Yasin", Age, Position.MIDFIELD);
        }
        for (int i = 0; i < forward.length; i++) {
            int Age = rand.nextInt(20) + 15;
            forward[i] = new Player("Yasin", Age, Position.FORWARD);
        }

        calculateTeamPower();
    }

    private void calculateTeamPower() {
        for (int i = 0; i < goalKeepers.length; i++) {
            DefencePower += goalKeepers[i].getGoalKeeeping();
        }
        for (int i = 0; i < defence.length; i++) {
            DefencePower += defence[i].getDef();
        }
        for (int i = 0; i < midfield.length; i++) {
            AttackPower += midfield[i].getMid();
            MidPower += midfield[i].getMid();
        }
        for (int i = 0; i < forward.length; i++) {
            AttackPower += forward[i].getAttack();
        }

        DefencePower /= (defence.length + goalKeepers.length);
        AttackPower /= (midfield.length + forward.length);
        MidPower /= midfield.length;

        setOverall((DefencePower + AttackPower) / 2);
    }

    public int getGoal() {
        return Goal;
    }

    public void setGoal() {
        Goal++;
        Average++;
    }

    public int getConcadeGoal() {
        return ConcadeGoal;
    }

    public void setConcadeGoal() {
        ConcadeGoal++;
        Average--;
    }

    public Character getTeamName() {
        return teamName;
    }

    public void setTeamName(char teamName) {
        this.teamName = teamName;
    }

    public Integer getPoint() {
        return Point;
    }

    public void setPoint(int point) {
        Point += point;
    }

    public Integer getAverage() {
        return Average;
    }

    public void setAverage(int average) {
        Average += average;
    }

    public Integer getOverall() {
        return Overall;
    }

    public void setOverall(int overall) {
        Overall = overall;
    }

    public int getAttackPower() {
        return AttackPower;
    }

    public void setAttackPower(int attackPower) {
        AttackPower = attackPower;
    }

    public int getMidPower() {
        return MidPower;
    }

    public void setMidPower(int midPower) {
        MidPower = midPower;
    }

    public int getDefencePower() {
        return DefencePower;
    }

    public void setDefencePower(int defencePower) {
        DefencePower = defencePower;
    }

    @Override
    public String toString() {
        return "Team [teamName=" + teamName + ", Point=" + Point + ", Average=" + Average + ", Goal=" + Goal
                + ", ConcadeGoal=" + ConcadeGoal + ", Overall=" + Overall + ", AttackPower=" + AttackPower
                + ", MidPower=" + MidPower + ", DefencePower=" + DefencePower + ", rand=" + rand + ", goalKeepers="
                + Arrays.toString(goalKeepers) + ", defence=" + Arrays.toString(defence) + ", midfield="
                + Arrays.toString(midfield) + ", forward=" + Arrays.toString(forward) + ", Fixture=" + Fixture + "]";
    }

    @Override

    public int compareTo(Team a) {
        return toString().compareTo(a.toString());
    }
}
