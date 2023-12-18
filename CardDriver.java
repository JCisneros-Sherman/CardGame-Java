//Josahandi Cisneros
//Project 1 Data Structures 
//References: 	stackoverflow.com/questions/21246696/generating-a-number-between-1-and-2-java-math-random/21246795
//				github.com/JaretWright/VisualDeckOfCards/commit/72e21f4dd56df34041134785e607ef3edf4a2c09
//				www.youtube.com/watch?v=_AUtutrnEP8
//				www.infoworld.com/article/2077217/card-engine-in-java.html
//
public class CardDriver {


	public static void main(String[] args) 
	{
		
		Deck d1 = new Deck();
		d1.filldeck();
		System.out.println( "Game Starts !" );
		System.out.println( "Shufflin deck now !" );
		d1.Shuffledeck();
		d1.fillplayersdeck();
		d1.whoStarts();
		d1.tabledeck();
		d1.whoWins();
		
		
		
	}

}
