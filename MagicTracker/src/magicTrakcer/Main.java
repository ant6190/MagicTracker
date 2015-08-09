package magicTrakcer;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.*;


  public class Main {
	  public static JFrame jFrame = new JFrame();  
	  
	  public static void main(String[] args){
		  //jFrame.setPreferredSize(new Dimension(400,400));
		  //jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  //jFrame.setVisible(true);
		  Deck temp1 = new Deck("Splinter Twin", "Modern");
		  Deck temp2 = new Deck("Tron", "Modern");
		  Deck temp3 = new Deck("Jund", "Modern");
		  Deck temp4 = new Deck("Pod", "Modern");
		  Record.parseRecord(temp1, temp2, "2-1-0");
		  Record.parseRecord(temp2, temp1, "2-1-0");
		  System.out.println(Record.records.size());
		  for(int i =0; i < Record.records.size();i++){
			  System.out.println(Record.records.get(i));
		  }
	  }
	}
  
 


