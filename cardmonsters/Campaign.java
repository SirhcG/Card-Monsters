package HW3;
//Huaqing Liu
//this class will dynamically construct each level with PlayerFactory and use CardFacotry give it cards
import gamebase.CardBase;
import tyrantunleashed.*;
import gamebase.Player.StrategyType;
import java.util.ArrayList;
import java.util.Random;

import cardmonsters.PlayerFactory;
import cardmonsters.Card;
import cardmonsters.CardFactory;
public class Campaign {

	private Level l;
	private ArrayList<Level> cam; // this will store each level
	private PlayerFactory pf;
	private CardFactory cf;
	
	public Campaign()
	{
		l = new Level();
		pf = new PlayerFactory();
		cf = new CardFactory();
		cam = new ArrayList<Level>();
	}
	
	public ArrayList<Level> getCam()
	{
		return cam;
	}
	//There will be 5 level
	//each level will have an opponent with 10 cards in hand
	public void setUpCam()
	{
		String cardType[] = {"Melee", "Ranger", "Healer", "Heal", "Reach"};
		for(int i = 0;i<5;i++)
		{
			ArrayList<Card> cards = new ArrayList<Card>();
			for(int n = 0;i<10;i++)
			{
				cards.add(cf.getCard(cardType[new Random().nextInt(cardType.length)]));
				
			}
			cam.get(i).setOP(pf.getPlayer("Opponent"));
			cam.get(i).getOP().setCards(cards);
		}
	}
	
	
	
	
	
}
