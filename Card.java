public class Card
{
	//Instance variables for the class Card
	private String suit;
	private int value;
	private String rank;

	//Accessor Method for the cards suit
	public String getSuit()
	{
		return suit;
	}

	//Accessor method for the cards value
	public int getValue()
	{
		return value;
	}

	//Accessor Method for getting the cards Rank
	public String getRank()
	{
		return rank;
	}

	//Mutator method for changing the cards suit
	public void setSuit(String s)
	{
		suit = s;
	}

	//Mutator method for changing the value
	public void setValue(int v)
	{
		value = v;

		//Set rank based off numeric value
		switch(value)
		{
			case 1: 
			{
				rank = "Ace";
				break;
			}
			case 11:
			{
				rank = "Jack";
				break;
			}
			case 12:
			{
				rank = "Queen";
				break;
			}
			case 13:
			{
				rank = "King";
				break;
			}
			default:
			{
				rank = Integer.toString(value);
				break;
			}
		}
	}
}