package edu.eci.cvds.guessgame;
import java.util.Random;
import java.util.Scanner;

import javax.enterprise.context.SessionScoped;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "guessBean")
@SessionScoped
public class GuessBean{
    private Random random;
    private double numberToGuess;
    private int attemps = 0, prize = 100000, guess;
    private String gameState;
    private String gameState2;

    public GuessBean(){
    }

    public double getNumber(){
        return numberToGuess;
    }

    public int getGuess(){
        return guess;
    }

    public int getAttemps(){
        return attemps;
    }

    public int getPrize(){
        return prize;
    }

    public String getState(){
        return gameState;
    }

    public String getMoney(){
        return gameState2;
    }

    public int setNumber(){
        random = new Random();
        return random.nextInt(20);
    }

    public void setAttemps(int number){
        this.attemps = number;
    }

    public void setPrize(int number){
        this.prize = number;
    }
    
    public void setGuess(int number){
        this.guess = number;
    }

    public void setGState(String state){
        this.gameState = state;
    }

    public void setGState2(String state){
        this.gameState2 = state;
    }

    
    public void reset(){
        this.attemps = 0;
        this.prize = 100000;
        this.gameState = "EN JUEGO";
        this.numberToGuess = setNumber();
    }

    public void guess(){
        this.numberToGuess = setNumber();
        Scanner userGuess = new Scanner(System.in);
        guess = userGuess.nextInt();
        while(prize > 0){
            if(guess != numberToGuess){
                prize -= 10000;
                attemps += 1;
                guess = userGuess.nextInt();
            }else{
                setGState("GANÓ");
                setGState2(String.valueOf(prize));
                break;
            }
        }
        reset();
    }
}