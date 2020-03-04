// 3/3/2020 GUI pick two card game
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TwoCardsGUI extends JFrame implements ActionListener  //implements wait for button clicks etc
{
	//Instance objects and variables for this class
	JLabel title = new JLabel("Pick Two Cards");
	JLabel playerLabel = new JLabel("Player's Card: ");
	JLabel compLabel = new JLabel("Computer's Card: ");
	JLabel playerResult = new JLabel(""); //empty string now, assign later when played game
	JLabel compResult = new JLabel("");

	JButton button = new JButton("Draw Card");

	JLabel winLose = new JLabel("");

	//Constructor for the TwoCardsGUI class
	public TwoCardsGUI()
	{
		//use the JFrame Constructor to construct THIS object
		super("Two Cards GUI"); //super looks to the parent constuctor...when you use the word extends
		setBounds(530, 250, 180, 240);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Color color1 = new Color(23, 138, 5);
		getContentPane().setBackground(color1);
		Font header = new Font("Arial", Font.BOLD, 21);
		Font players = new Font("Arial", Font.BOLD, 18);
		Font results = new Font("Arial", Font.BOLD, 14);
		Font endResult = new Font("Arial", Font.BOLD, 24);
		
		//Set the layout for the GUI
		setLayout(new FlowLayout());

		//Add instance objects on to the frame
		add(title);
		add(playerLabel);
		add(playerResult);
		add(compLabel);
		add(compResult);
		add(button);
		add(winLose);

		//Font and Style 
		title.setFont(header);
		playerLabel.setFont(players);
		playerResult.setFont(results);
		compLabel.setFont(players);
		compResult.setFont(results);
		winLose.setFont(endResult);
		winLose.setForeground(Color.orange);
		title.setForeground(Color.yellow);
		playerLabel.setForeground(Color.white);
		compLabel.setForeground(Color.white);
		playerResult.setForeground(Color.yellow);
		compResult.setForeground(Color.yellow);

		//Add the event listener so the button can be clicked on
		button.addActionListener(this);

		setVisible(true);
	}

	//actionPerformed details what should happen when the button is clicked on
	@Override
	public void actionPerformed(ActionEvent e)
	{
		playGame();
	}


	//Method that handles the actual pick two card game
	public void playGame()  //taken this from the game we previously made all COPY & PASTE but CHANGE output phase
	{
		//variables and constants
		int myValue;
		int comValue;
		final int CARDS_IN_SUIT = 13;

		//objects
		Card myCard = new Card();
		Card comCard = new Card();

		//Generate random numbers - Calculation Phase
		//Randomly generate 1 - 13 and assign it to myValue and comValue
		myValue = ((int)(Math.random() * CARDS_IN_SUIT + 1));
		comValue = ((int)(Math.random() * CARDS_IN_SUIT + 1));

		//Use the mutator methods to set the card's value to the random number generated for each player
		myCard.setValue(myValue);
		comCard.setValue(comValue);
		
		//Use random number to choose the suit from a random array of choices
		String[] cardSuits = {"Diamonds", "Hearts", "Clubs", "Spades"};
		myCard.setSuit(cardSuits[(int)(Math.random() * 4)]);
		comCard.setSuit(cardSuits[(int)(Math.random() * 4)]);

		//output phase -- we made new variables to hold values
		String playerMsg = myCard.getRank() + " of " + myCard.getSuit();
		String compMsg = comCard.getRank() + " of " + comCard.getSuit();

		if(myValue > comValue)
		{
			winLose.setText("YOU WIN!");
		}
		else if(myValue == comValue)
		{
			winLose.setText("IT'S A TIE!");
		}
		else
		{
			winLose.setText("YOU LOSE!");
		}

		playerResult.setText(playerMsg);
		compResult.setText(compMsg);

	}


	//Main method that starts the application, which creates an ojbect from the TwoCards GUI Class
	public static void main(String[] args)  //the main NEEDS to at least build one object from the class 
	{
		TwoCardsGUI game1 = new TwoCardsGUI();
	}

}