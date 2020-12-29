package entity;

import javax.swing.*;
import java.awt.*;
import adt.ArrayGrid;

public class Board {
    ArrayGrid<Box> board;
    public static final int ROW_NUM = 10;
    public static final int COL_NUM = 10;

    public Board() {
        board= new ArrayGrid<>(ROW_NUM,COL_NUM);
        for (int r = 0;r < board.getNumRows();r++){
            for (int c = 0;c < board.getNumCols();c++){
                Box temp = new Box();
                board.insert(new Location(r,c),temp);

            }
        }
    }
    
    public void setBomb(int row,int col){
        board.get(new Location(row,col)).setBomb();
    }
    
    public void setShip(int row,int col){
        board.get(new Location(row,col)).setShip();
    }
    
    public boolean hasBombed(int row,int col) {
        return board.get(new Location(row,col)).hasBombed();
    }
    
    public boolean hasHit(int row,int col) {
        return board.get(new Location(row,col)).hasHit();
    }
    
    public boolean hasShip(int row,int col){
         return board.get(new Location(row,col)).hasShip();
    }
    
    public void showBombBoard(JFrame frame){
       GridLayout boardLayout = new GridLayout(0,12);
       frame.setLayout(boardLayout);
       JLabel label[][] = new JLabel[12][12];
       boardLayout.setHgap(2);
       boardLayout.setVgap(2);
       
       for (int r = 0;r < 12;r++){
            for (int c = 0;c < 12;c++){
               if((r == 0 && c == 0)|| r == 11 || c == 11){
                   label[r][c] = new JLabel("");
               }
               else if(r == 0){
                   label[r][c] = new JLabel("      "+Integer.toString(c-1));
               }
               else if(c == 0){
                   label[r][c] = new JLabel ("      "+Integer.toString(r-1));
               }
               else{
                  label[r][c] = new JLabel("");
                  label[r][c].setOpaque(true);
                  if(this.hasHit(r-1, c-1))label[r][c].setBackground(Color.RED);
                  else if (this.hasBombed(r-1, c-1)) label[r][c].setBackground(Color.BLACK);
                  else label[r][c].setBackground(Color.BLUE);
               }
               frame.add(label[r][c]);
            }
       }
       frame.setVisible(true);
    }
    
    public void showYourBoard(JFrame frame,int x){
       GridLayout boardLayout = new GridLayout(0,12);
       frame.setLayout(boardLayout);
       JLabel label[][] = new JLabel[12][12];
       boardLayout.setHgap(2);
       boardLayout.setVgap(2);
       
       
       for (int r = 0;r < 12;r++){
            for (int c = 0;c < 12;c++){
               if((r == 0 && c == 0)|| r == 11 || c == 11){
                   label[r][c] = new JLabel("");
               }
               else if(r == 0){
                   label[r][c] = new JLabel("      "+Integer.toString(c-1));
               }
               else if(c == 0){
                   label[r][c] = new JLabel ("      "+Integer.toString(r-1));
               }
               else{
                  label[r][c] = new JLabel("");
                  label[r][c].setOpaque(true);
                  if(this.hasHit(r-1, c-1))label[r][c].setBackground(Color.RED);
                  else if (this.hasShip(r-1, c-1)) label[r][c].setBackground(Color.GREEN);
                  else label[r][c].setBackground(Color.BLUE);
               }
               frame.add(label[r][c]);
            }
       }
       frame.setVisible(true);
    }
}
