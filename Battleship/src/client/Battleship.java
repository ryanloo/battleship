package client;

import java.util.Scanner;
import javax.swing.*;
import entity.Player;
import entity.Board;
import entity.Ship;
import entity.shipCounter;
import entity.readyTimer;
import adt.CircularLinkedList;

public class Battleship {
    static Scanner input = new Scanner(System.in);
    
    public static Player initGame(int plyrNo){
        System.out.print("Player " + plyrNo +" Name: ");
        String name = input.nextLine();
        Player tempPlyr = new Player(name);
        return tempPlyr;
    }
    
    public static void initBoard(Player p,int x){
        Board plyrBoard = p.getBoard();
        
        int ch = -1;
        int rh = -1;
        int ct = -1;
        int rt = -1;
        
        
        
        for (int i = 1;i <= 5; i++){
            System.out.println("");
            Ship tempShip = p.ship.get(i);
            JFrame frame = new JFrame("Battleship");
            frame.setSize(500,500);
            System.out.println("Set position for "+ tempShip.getShipName());
            boolean flag = true;
            
            plyrBoard.showYourBoard(frame,x);
            while(flag){
                flag = false;
                System.out.print("Col Head:");
                try{
                    ch = input.nextInt();
                }
                catch(Exception ex){
                    flag = true;
                }
                System.out.print("Row Head:");
                try{
                   rh = input.nextInt();
                }
                catch(Exception ex){
                    flag = true;
                }
                System.out.print("Col Tail:");
                try{
                    ct = input.nextInt();
                }
                catch(Exception ex){
                    flag = true;
                }
                System.out.print("Row Tail:");
                try{
                    rt = input.nextInt();
                }
                catch(Exception ex){
                    flag = true;
                }
                if(ch < ct){
                    int temp;
                    temp = ch;
                    ch = ct;
                    ct = temp;
                }
                if(rh < rt){
                    int temp;
                    temp = rh;
                    rh = rt;
                    rt = temp;
                }
                if(ch < 0 | ch > 9| rh < 0 | rh > 9 |ct < 0|ct > 9 | rt < 0 | rt > 9){
                    flag = true;
                }
                if (ch != ct & rh != rt){
                    flag = true;
                }
                if(Math.abs(ch - ct) != (tempShip.getLength()-1)& Math.abs(rh - rt) != (tempShip.getLength()-1)){
                    flag = true;
                }
                if(ch > 0 & ch < 9 & rh > 0 & rh < 9 & ct > 0&ct < 9 & rt > 0 & rt < 9){
                    for(int r = rt;r <= rh;r++){
                        for(int c = ct;c <= ch;c++ ){
                            if(plyrBoard.hasShip(r, c)) {
                                flag = true;
                            }      
                        }
                    }
                }
                if (flag){
                    System.out.println("Invalid input\n");
                }
            }
            tempShip.setShipHead(rh,ch);
            tempShip.setShipTail(rt,ct);

            for(int r = rt;r <= rh;r++){
                for(int c = ct;c <= ch;c++ ){
                    plyrBoard.setShip(r, c);
                }
            }
            ch = -1;
            rh = -1;
            ct = -1;
            rt = -1;
            flag = true;
            frame.dispose();
        }
    }
    
    public static void mainGame(Player currPly,Player oppPly,int x){
        int targetCol = -1;
        int targetRow = -1;
        boolean flag = true;
        JFrame frame = new JFrame("Battleship");
        frame.setSize(500,800);
        System.out.println("Current score: You = " + currPly.shipsLeft()+", Opp = " + oppPly.shipsLeft());
            oppPly.getBoard().showBombBoard(frame);
            currPly.getBoard().showYourBoard(frame,x);
            while(flag){
                flag = false;
                System.out.print("Target Column: ");
                try{
                    targetCol = input.nextInt();
                }
                catch(Exception ex){
                    flag = true;
                }
                System.out.print("Target Row: ");
                targetRow = input.nextInt();
                if(targetCol < 0 |targetCol > 9| targetRow < 0 | targetRow > 9){
                    flag = true;
                }
                if(!(targetCol > 0 & targetCol < 9 & targetRow > 0 & targetRow < 9)){
                    if(oppPly.getBoard().hasBombed(targetRow, targetCol)){
                        flag = true;
                    }
                }
                if (flag){
                    System.out.println("Invalid input\n");
                }
            }
            oppPly.getBoard().setBomb(targetRow, targetCol);
            frame.dispose();
    }
    
    public static void main(String[] args) {
        
        Player p1 = initGame(1);
        Player p2 = initGame(2);
        readyTimer timer = new readyTimer();
        int x;
        
        System.out.println("");
        System.out.println("Player 1 Set Board:");
        System.out.println("Ready in");
        timer.startTimer();
        initBoard(p1,1);
        System.out.println("");
        System.out.println("Player 2 Set Board:");
        System.out.println("Ready in");
        timer.startTimer();
        initBoard(p2,2);
        System.out.println("");
        
        CircularLinkedList<Player> turn = new CircularLinkedList<>();
        turn.insert(p1);
        turn.insert(p2);
        
        
        while(p1.shipsLeft() != 0 & p2.shipsLeft() != 0 ){
            System.out.println("");
            Player currPly = turn.getCurr();
            if(currPly == p1){
                System.out.println("Player 1 Turn:");
                x= 1;
            }
            else {
                System.out.println("Player 2 Turn:");
                x = 2;
            }
            System.out.println("Ready in");
            timer.startTimer();
            turn.nextNode();
            Player oppPly = turn.getCurr();
            mainGame(currPly,oppPly,x);
        }
        
        if (p1.shipsLeft() == 0){
            System.out.println("Player 2 Wins.");
        }
        else{
            System.out.println("Player 1 Wins.");
        }
    }    
}
