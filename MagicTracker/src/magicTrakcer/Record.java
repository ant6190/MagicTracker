package magicTrakcer;

import java.util.ArrayList;

public class Record {
	
	private Deck deckA;
	private Deck deckB;
	private int deckAwins;
	private int deckBwins;
	private int deckAMatchWins;
	private int deckBMatchWins;
	private int draws;
	
	public static ArrayList<Record> records = new ArrayList<Record>();
	
	public Record(Deck a, Deck b){
		deckA = a;
		deckB = b;
		deckAwins = 0;
		deckBwins = 0;
		draws = 0;
		records.add(this);
	}

	public Deck getDeckA() {
		return deckA;
	}

	public Deck getDeckB() {
		return deckB;
	}

	public int getDeckAwins() {
		return deckAwins;
	}

	public int getDeckBwins() {
		return deckBwins;
	}
	
	public int getDeckAMatchWins() {
		return deckAMatchWins;
	}

	public int getDeckBMatchWins() {
		return deckBMatchWins;
	}
	
	public int getDraws(){
		return draws;
	}
	
	public boolean containsDeck(String deckName){
		return deckName == deckA.getDeckName() || deckName == deckB.getDeckName();
	}
	
	public boolean containsDeck(Deck deckName){
		return deckName == deckA || deckName == deckB;
	}
	public static void parseRecord(String deck1, String deck2, String rec){
		for(int i = 0; i < records.size(); i++){
			if (records.get(i).containsDeck(deck1) && records.get(i).containsDeck(deck2)){
				if(records.get(i).getDeckB().getDeckName() == deck1){
					String temp = rec.substring(2, 3);
					temp += rec.substring(1,2);
					temp += rec.substring(0,1);
					temp += rec.substring(3);
					rec = temp;
				}
				records.get(i).parseWins(rec);
				break;
			}
			if(i == records.size()){
				Deck temp = null;
				Deck temp2 = null;
				for(int j = 0; j < Deck.decks.size(); j++){
					if (Deck.decks.get(j).getDeckName() == deck1){
						temp = Deck.decks.get(j);
					}
				}
				for(int h = 0; h < Deck.decks.size(); h++){
					if (Deck.decks.get(h).getDeckName() == deck1){
						temp2 = Deck.decks.get(h);
					}
				}
				Record tempRec = new Record(temp, temp2);
				tempRec.parseWins(rec);
			}
		}
	}
	
	public static void parseRecord(Deck deck1, Deck deck2, String rec){
		int sen = 0;
		for(int i = 0; i < records.size(); i++){
			if (records.get(i).containsDeck(deck1) && records.get(i).containsDeck(deck2)){
				System.out.println(i);
				if(records.get(i).getDeckB() == deck1){
					String temp = rec.substring(2, 3);
					temp += rec.substring(1,2);
					temp += rec.substring(0,1);
					temp += rec.substring(3);
					rec = temp;
				}
				records.get(i).parseWins(rec);
				break;
			}
			sen = i;
		}
		if(sen == records.size()){
			Record tempRec = new Record(deck1, deck2);
			tempRec.parseWins(rec);
		}
	}

	public void parseWins(String rec){
		if(rec.length() == 5){
			int tempA = Integer.parseInt(rec.substring(0, 1));
			int tempB = Integer.parseInt(rec.substring(2,3));
			int tempC = Integer.parseInt(rec.substring(4, 5));
			deckAwins += tempA;
			deckBwins += tempB;
			if(tempA > tempB)deckAMatchWins++;
			if(tempB > tempA)deckBMatchWins++;
			if(tempC != 0)draws++;
		}
	}
	
	public String toString(){
		String ans = deckA.getDeckName() + " vs. " + deckB.getDeckName() + "\n";
		ans += "Match Wins: " + deckAMatchWins + " - " + deckBMatchWins + "\n";
		ans += "Game Wins: " + deckAwins + " - " + deckBwins;
		return ans;
	}
}
