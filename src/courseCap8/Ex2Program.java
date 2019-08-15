package courseCap8;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import entities.Ex2Comment;
import entities.Ex2Post;

public class Ex2Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Ex2Comment c1 = new Ex2Comment("Have a nice treip!");
		Ex2Comment c2 = new Ex2Comment("Woh that's aewsome!");
		Ex2Post p1 = new Ex2Post(sdf.parse("21/06/20018 13:5:44"), 
				"Traveling to New Zealand",
				"I'm going to visit this wonderful cointry!",
				12);
		p1.addComment(c1);
		p1.addComment(c2);
		
		Ex2Comment c3 = new Ex2Comment("Good Night!");
		Ex2Comment c4 = new Ex2Comment("May the Force be with you!");
		Ex2Post p2 = new Ex2Post(sdf.parse("28/07/20018 23:55:44"), 
				"Good nbight my guys",
				"See you Tomorrow!",
				5);
		p2.addComment(c3);
		p2.addComment(c4);
		
		System.out.println(p1);
		System.out.println(p2);
	}

}
