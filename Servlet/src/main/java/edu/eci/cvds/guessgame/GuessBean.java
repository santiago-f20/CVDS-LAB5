package edu.eci.cvds.guessgame;
import java.util.Random;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "guessBean")
@SessionScoped
public class GuessBean{
    private Random random;
    private int attemps = 0, prize = 100000, guess, numberToGuess = setNumber();
    private String gameState;

    public GuessBean(){
    }

    public int getNumber(){
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
    
    public void reset(){
        this.attemps = 0;
        this.prize = 100000;
        this.gameState = "";
        this.numberToGuess = setNumber();
    }

    public boolean guess(int nTG, int number){
        if(nTG == number){
            return true;
        }else{return false;}
    }

    public void main(){

        if(guess(numberToGuess, guess) == false && prize > 0){
            prize -= 10000;
            attemps += 1;
            setGState("FALLÓ");
        }else if(prize <= 0){
            try {
                Thread.sleep(3*1000);
                reset();
            } catch (Exception e) {
            }
        }else{
            setGState("GANÓ "+String.valueOf(prize));
        }
    }
}