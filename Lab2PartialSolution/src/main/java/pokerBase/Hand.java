package pokerBase;

import java.util.ArrayList;

import pokerEnums.eCardNo;
import pokerEnums.eHandStrength;
import pokerEnums.eRank;
import pokerEnums.eSuit;

public class Hand {

	private static ArrayList<Card> CardsInHand;

	private ArrayList<Card> getCardsInHand() {
		return CardsInHand;
	}

	private static boolean isFlush(ArrayList<Card> cards) {

		boolean bIsFlush = false;
		
		for (int i = 1; i < 5; i++) {
			if(CardsInHand.get(eCardNo.FirstCard.getCardNo()).geteSuit() != CardsInHand.get(i).geteSuit()) {
				 bIsFlush = false;
			}
			else {
				 bIsFlush = true;
			}
		}
		return bIsFlush;
	}

	private static boolean isStraight(ArrayList<Card> cards, Card highCard) {
		
		boolean bIsStraight = false;
		
		if (CardsInHand.get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr() == 14) {
			if(CardsInHand.get(eCardNo.SecondCard.getCardNo()).geteRank().getiRankNbr() == 13
					&& CardsInHand.get(eCardNo.ThirdCard.getCardNo()).geteRank().getiRankNbr() == 12
					&& CardsInHand.get(eCardNo.FourthCard.getCardNo()).geteRank().getiRankNbr() == 11
					&& CardsInHand.get(eCardNo.FifthCard.getCardNo()).geteRank().getiRankNbr() == 10) 
			{
						bIsStraight = true;
			}
			else if (CardsInHand.get(eCardNo.FifthCard.getCardNo()).geteRank().getiRankNbr() == 2
							&& CardsInHand.get(eCardNo.FourthCard.getCardNo()).geteRank().getiRankNbr() == 3
							&& CardsInHand.get(eCardNo.ThirdCard.getCardNo()).geteRank().getiRankNbr() == 4
							&& CardsInHand.get(eCardNo.SecondCard.getCardNo()).geteRank().getiRankNbr() == 5)
			{
						bIsStraight = true;
			}
					else
					{
						bIsStraight = false;
					}
		}
		else if(CardsInHand.get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr() == CardsInHand.get(eCardNo.SecondCard.getCardNo()).geteRank().getiRankNbr()+1
				&& CardsInHand.get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr() == CardsInHand.get(eCardNo.ThirdCard.getCardNo()).geteRank().getiRankNbr()+2
				&& CardsInHand.get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr() == CardsInHand.get(eCardNo.FourthCard.getCardNo()).geteRank().getiRankNbr()+3
				&& CardsInHand.get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr() == CardsInHand.get(eCardNo.FifthCard.getCardNo()).geteRank().getiRankNbr()+4)
		{
			bIsStraight = true;
		} 
		else
		{
			bIsStraight = false;
		}
	
		return bIsStraight;
	}
	
	

	public static boolean isHandRoyalFlush(Hand h, HandScore hs) {

		boolean isRoyalFlush = false;
		// TODO implement method
		return isRoyalFlush;
	}
	
	

	public static boolean isHandStraightFlush(Hand h, HandScore hs) {
		
		boolean isStraightFlush = false;
		// TODO implement method
		return isStraightFlush;
	}
	
	

	public static boolean isHandFourOfAKind(Hand h, HandScore hs) {

		boolean bHandCheck = false;

		if (h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank() == h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()).geteRank()) {
			bHandCheck = true;
			hs.setHandStrength(eHandStrength.FourOfAKind.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()));
			hs.setKickers(kickers);

		} 
		else if (h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()).geteRank() == h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()).geteRank()) {
			bHandCheck = true;
			hs.setHandStrength(eHandStrength.FourOfAKind.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()));
			hs.setKickers(kickers);
		}

		return bHandCheck;
	}
	
	

	public static boolean isHandFullHouse(Hand h, HandScore hs) {
		
		boolean isFullHouse = false;
		
		if (h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank() == h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()).geteRank() && h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()).geteRank() == h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()).geteRank() ) 
		{
			isFullHouse = true;
			hs.setHandStrength(eHandStrength.FullHouse.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			hs.setKickers(kickers);
			
		} 
		else if (h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank() == h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()).geteRank() && h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()).geteRank() == h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()).geteRank()) 
		{
			isFullHouse =true;
			hs.setHandStrength(eHandStrength.FullHouse.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			hs.setKickers(kickers);
		
		} 
		return isFullHouse; 
	}
	
	

	public static boolean isHandFlush(Hand h, HandScore hs) {

		boolean bIsFlush = false;
		// TODO Implement this method
		//Still dont understand
		return bIsFlush;
	}
	
	

	public static boolean isHandStraight(Hand h, HandScore hs) {

		boolean bIsStraight = false;
		// TODO Implement this method
		//SOS Help
		return bIsStraight = false;
	}
	
	

	public static boolean isHandThreeOfAKind(Hand h, HandScore hs) {

		boolean isThreeOfAKind = false;
		
		if (h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank() == h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()).geteRank()) 
		{
			isThreeOfAKind = true;
			hs.setHandStrength(eHandStrength.ThreeOfAKind.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()));
			kickers.add(h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()));
			hs.setKickers(kickers);
		} 
		else if (h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()).geteRank() == h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()).geteRank()) {
			isThreeOfAKind =true;
			hs.setHandStrength(eHandStrength.ThreeOfAKind.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()));
			kickers.add(h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()));
			hs.setKickers(kickers);
		}
		else if (h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()).geteRank() == h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()).geteRank()) 
		{
			isThreeOfAKind =true;
			hs.setHandStrength(eHandStrength.ThreeOfAKind.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()));
			kickers.add(h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()));
			hs.setKickers(kickers);
		}
		return isThreeOfAKind;
	}
	
	

	public static boolean isHandTwoPair(Hand h, HandScore hs) {

		boolean isTwoPair = false;
		

		if (h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank() == h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()).geteRank() && h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()).geteRank() == h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()).geteRank()) 
		{
			isTwoPair =true;
			hs.setHandStrength(eHandStrength.TwoPair.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()));
			hs.setKickers(kickers);
			
		} 
		else if (h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank() == h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()).geteRank() && h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()).geteRank() == h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()).geteRank()) 
		{
			isTwoPair =true;
			hs.setHandStrength(eHandStrength.TwoPair.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()));
			hs.setKickers(kickers);
		}
		else if (h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()).geteRank() == h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()).geteRank() && h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()).geteRank() == h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()).geteRank()) 
		{
			isTwoPair =true;
			hs.setHandStrength(eHandStrength.TwoPair.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()));
			hs.setKickers(kickers);
		}
		
		return isTwoPair;
	}
	
	

	public static boolean isHandPair(Hand h, HandScore hs) {
		
		boolean isPair = false;
		
		if (h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank() == h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()).geteRank()) 
		{
			isPair = true;
			hs.setHandStrength(eHandStrength.Pair.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()));
			kickers.add(h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()));
			kickers.add(h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()));
			hs.setKickers(kickers);
			
		}
		else if (h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()).geteRank() == h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()).geteRank()) 
		{
			isPair =true;
			hs.setHandStrength(eHandStrength.Pair.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()));
			kickers.add(h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()));
			kickers.add(h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()));
			hs.setKickers(kickers);
		}
		else if (h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()).geteRank() == h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()).geteRank()) 
		{
			isPair =true;
			hs.setHandStrength(eHandStrength.Pair.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()));
			kickers.add(h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()));
			kickers.add(h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()));
			hs.setKickers(kickers);
		}
		else if (h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()).geteRank() == h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()).geteRank()) 
		{
			isPair =true;
			hs.setHandStrength(eHandStrength.Pair.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()));
			kickers.add(h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()));
			kickers.add(h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()));
			hs.setKickers(kickers);
		}
		return isPair;
	}
	
	

	public static boolean isHandHighCard(Hand h, HandScore hs) 
	{
		hs.setHandStrength(eHandStrength.HighCard.getHandStrength());
		hs.setHiHand(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr());
		hs.setLoHand(0);
		ArrayList<Card> kickers = new ArrayList<Card>();
		kickers.add(h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()));
		kickers.add(h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()));
		kickers.add(h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()));
		kickers.add(h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()));
		hs.setKickers(kickers);
		
		return true;
	}
}
//Still need to figure go through to see if it is obvious its plagarized.
//SOS this is so hard omg

