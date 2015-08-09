package magicTrakcer;

import java.util.ArrayList;

public class Deck {
	 private String deckName;
	 private String format;
	  public static ArrayList<Deck> decks = new ArrayList<Deck>();
	 
	 public Deck(String deckName, String format){
		 this.deckName = deckName;
		 this.format = format;
		 decks.add(this);
	 }
	 
	 public String getDeckName(){
		 return deckName;
	 }
	 
	 public String getFormat(){
		 return format;
	 }
	 
	 public String toString(){
		 return deckName;
	 }
}
