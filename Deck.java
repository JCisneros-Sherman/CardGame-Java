import java.util.Random;

public class Deck 
{
		
			static String[] suit = { "Clubs ", "Diamonds ", "Hearts ", "Spades " }; //possible suits
			static String[] rank = {"Ace ", "2 ", "3 ", "4 ", "5 ", "6 ", "7 ", "8 ", "9 ","10 ", "Jack ", "Queen ", "King ", }; //possible ranks
			static int SUITS = suit.length;	
			static int RANKS = rank.length;
			int sized = SUITS * RANKS;
			private int flagg;			//flag to keep track which player goes first 
		    private String[][] deck;	//2d array that populates deck
		    boolean equal;
		    PlayerDeckList<String> player1 = new PlayerDeckList<>(); //for player 1 deck
		    PlayerDeckList<String> player2 = new PlayerDeckList<>(); //for player 2 deck
		    PlayerDeckList<String> tabledeck = new PlayerDeckList<>();
		    int roundnum; //To keep track of the rounds played
//Default constructor		    
			public Deck() 
			{
				deck= new String[RANKS][SUITS]; //Creates deck as a 2d array
			}
		
//Method used to fill the deck of cards			
	public void filldeck()
	{
		for (int i = 0; i < RANKS; i++)
		{
			for (int j = 0; j < SUITS; j++)
			{
				deck[i][j] = rank[i] + " of " + suit[j];
			}
		}
	}		

//Methods used to shuffle cards on deck randomly 			
	public void Shuffledeck() 
	{
		Random random = new Random();
		 for (int i = RANKS -1; i > 0; i--) 
		 {
			 for (int j = SUITS - 1; j > 0; j--)
			   {
			       int m = random.nextInt(i + 1);
			       int n = random.nextInt(j + 1);
			       String temp = deck[i][j];
			       deck[i][j] = deck[m][n];
			       deck[m][n] = temp;
			     }
		 }
	}
		
//Method used to display contents of Deck		
	public void displaydeck()
	{
		System.out.println("--------------------------------------------------------------");
		if( flagg == 1) //flag = 1 when player 1 goes first
		{System.out.println("P1 card : " + player1.get(1));
		 System.out.println("P2 card : " + player2.get(1));
		}	
		else 
		{
		System.out.println("P2 card : " + player1.get(1));
		System.out.println("P1 card : " + player2.get(1));
		}
		
	}
//Method used to fill the 2D array deck with suits and ranks
	public void fillplayersdeck() 
	{
		for (int i = 0; i < RANKS; i++)
		{
			for (int j = 0; j < SUITS; j++)
			 {
				  if((j < (SUITS/2))&& (i < RANKS)) 
				  {
						player1.add(i, deck[i][j]);
				  }
						
				  else	player2.add(i, deck[i][j]);
			}
		}	
	}
	
//Method used to randomly select player that will begin game	
public int whoStarts()
{
	int temp = (Math.random() <= 0.5) ? 1 : 2; //uses Math.random
	System.out.println("Player "+ temp + " will go first");
	if((temp - 1 ) == 0)
	{ 
	  flagg = 1;
	 }
	else 
	{
	 flagg = 0;
	}
	displaydeck();
	return flagg;
}	
	
//Method used to compare cards of players		
public boolean CompareCards() 
{ 
	String s = player1.get(1);
	String ss =player2.get(1);
	//System.out.println(" comparing... "+ player1.get(1)  +" "+ player2.get(1));
	System.out.println(" comparing... ");
	if((s.contains("Spades"))&&(ss.contains("Spades")))
	{
		System.out.println(" Spades, it's a match!");
		equal = true;
	}
	
	else if((s.contains("Hearts"))&&(ss.contains("Hearts")))
	{
		System.out.println(" Hearts, it's a match!");
		equal = true;
		
	}
	else if((s.contains("Diamonds"))&&(ss.contains("Diamonds")))
	{
		System.out.println("Diamonds, it's a match");
		equal = true;
	
	}
	
	else if((s.contains("Clubs"))&&(ss.contains("Clubs")))
	{
		System.out.println("Clubs, it's a match!");
		equal = true;	
	}
	
	else {
		equal = false;		
	}
	
	return equal;
}
	
//Method used to add played cards into the table deck 
public void tabledeck() 
{
	if(flagg == 1) //if player 1 started the game
	{
		for(int i = 0; i <=10; i++ )
		{
				roundnum = i; //keep track of rounds 
				int ii = 0;
				System.out.println( "p1 deck " + player1);
				System.out.println( "p2 deck " + player2);
				tabledeck.add(0,player1.get(1));
				tabledeck.add(0,player2.get(1));
				System.out.println( "table deck " + tabledeck);
				CompareCards(); //Comparescards
				player1.remove(ii);
				player2.remove(ii);
				//System.out.println( "-----NEW DECKS----------------- ");
				//System.out.println( "P1 deck " + player1);
				//System.out.println( "P2 deck " + player2);
				//System.out.println( "table deck " + tabledeck);
			if(equal == false) //If Suits of cards do not match
				{
				System.out.println("No match! :(  Next round...");
				displaydeck();
				}
			else //When the suits of cards match
				{
				displaydeck();
				CompareCard();
				}		
			if( roundnum == 5) 
			{
				break;
			}
		}
	}
	
	if(flagg==0) //if player 2 started the game
	{
		for(int i = 0; i <=10; i++ )
		{	roundnum = i;
			int ii = 0;
			System.out.println( "p2 deck " + player1);
			System.out.println( "p1 deck " + player2);
			tabledeck.add(0,player1.get(1));
			tabledeck.add(0,player2.get(1));
			System.out.println( "table deck " + tabledeck);
			CompareCards(); //needs work
			player1.remove(ii);
			player2.remove(ii);
			//System.out.println( "---NEW DECKS-------------------- ");
			//System.out.println( "P2 deck " + player1);
			//System.out.println( "P1 deck " + player2);
			//System.out.println( "table deck " + tabledeck);
	      if(equal == false)
	      {
	    	  System.out.println("No match! :(  Next Round...");
			displaydeck();
	      }
	      else
	      {
	    	  displaydeck();
	    	  CompareCard();
	      }		

	      if( roundnum == 5) 
	      {
	    	  break;
	      }
		}	
	}
}		
//When cards match new table deck 
public void newtabledeck()
{
	if(flagg == 1) //if player one is first
	{
		for(int i = 0; i < 10; i++ )
		{
			PlayerDeckList<String> newtdeck = new PlayerDeckList<>();
			int ii = 0;
			roundnum = i;
			System.out.println( "p1 deck " + player1);
			System.out.println( "p2 deck " + player2);
			newtdeck.add(0,player1.get(1));
			newtdeck.add(0,player2.get(1));
			System.out.println( "table new deck " + newtdeck);
			CompareCards(); 
			//System.out.println( "---NEW DECKS---------------------- ");
			player1.remove(ii);
			player2.remove(ii);
		//	System.out.println( "p1 deck " + player1);
			//System.out.println( "p2 deck " + player2);
			//System.out.println( "table n deck " + newtdeck);

			if(equal == false) //If cards do not match
			{
				System.out.println("No match! :(  Next Card...");
				displaydeck();	
			}

			else
			{
				displaydeck();
				CompareCard();
			}
	
			if(roundnum == 5) 
			{
		
				break;
			}
		}	
		
	}
	if(flagg==0) //if player 2 goes first 
		for(int i = 0; i < 10; i++ )
		{
			PlayerDeckList<String> newtdeck = new PlayerDeckList<>();
			int ii = 0;
			roundnum = i;
			System.out.println( "p2 deck " + player1);
			System.out.println( "p1 deck " + player2);
			newtdeck.add(0,player1.get(1));
			newtdeck.add(0,player2.get(1));
			System.out.println( "table deck " + newtdeck);
			CompareCards(); //needs work
			//System.out.println( "-----------NEW DECKS-------------- ");
			player1.remove(ii);
			player2.remove(ii);
			//System.out.println( "p2 deck " + player1);
			//System.out.println( "p1 deck " + player2);
		//	System.out.println( "table n deck " + newtdeck);

		if(equal == false)
			{
				System.out.println("No match! :(  Next Round...");
				displaydeck();
			}
		else
			{
				//displaydeck();
				CompareCard();
			}
		if( roundnum == 5) 
			{
			break;
			}
		
		}		

}

//Method used to compare cards
public void CompareCard() 
{
		if(flagg==1) // If player 1 goes first
		{
			tabledeck.remove(0); //to remove null from current table deck 
			int temp = tabledeck.size()+1;
			System.out.println( "P2 gets cards: ");
			for(int i = 0; i < temp ; i++)
			{
				player2.add(0,tabledeck.remove(0));
			}
			//System.out.println("player 2 has now " + ( player2.size()-1));
			
			if(player2.size()== 52) //In case player reaches all the cards 
			{
				System.out.println(" player 2 wins ");
				return;
			}
			newtabledeck();
			}
		
		if(flagg == 0 ) 
		{
			tabledeck.remove(0); //to remove null from current table deck 
			int temp = tabledeck.size()+1;
			System.out.println( "P1 gets cards: ");
			for(int i = 0; i < temp ; i++)
				{
					
					player2.add(0,tabledeck.remove(0));
			 
				}
			//System.out.println("player 1 has now " + ( player2.size()-1));
			if(player2.size() == 52) 
				{
					System.out.println(" ");
					return;
				}
			newtabledeck();	
		}
}		

//Method shows winner of game
public int whoWins()
{	
	int wins = 0;
	int size1 = player1.size();
	int size2 = player2.size();
	
	if((flagg == 1))
	{	
		if(size1 > size2)
		{
			wins = 1;
			System.out.println("Player 1 Wins ! " );
			return wins;
		}
		if(size1<size2) 
		{
			wins = 1;
			System.out.println("Player 2 Wins ! " );
			return wins;
		}
		if(size1 == size2)
		{
			wins = 1;
			System.out.println("issa a tie ! " );
			return wins;
		}
	}
	if((flagg == 0))
	{	
		if(size1 > size2)
		{
			wins = 0;
			System.out.println("Player 2 Wins ! " );
			return wins;
		}
		if(size1<size2) 
		{
			wins = 0;
			System.out.println("Player 1 Wins ! " );
		}
		if(size1 == size2)
		{
			wins = 0;
			System.out.println("issa a tie ! " );
			return wins;
		}
	}
	
	return wins;
}

	
}	
	
	
	
	
	
	
	
	
	

