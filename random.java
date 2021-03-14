package jsoup;
import org.jsoup.Connection;
import java.math.*;
import org.jsoup.Connection.Method;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.FormElement;
import org.jsoup.select.Elements;
import java.io.*;
import java.lang.System.*;
import java.util.*;
import java.util.logging.*;
public class random {
	public static void main(String [] args) throws IOException{
		String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.183 Safari/537.36";
	    Connection.Response res = Jsoup.connect("https://mybookie.ag/sportsbook/soccer/")
	    		.userAgent(USER_AGENT)
	    		 .method(Connection.Method.GET)
	             .execute();
	  ArrayList<Double> parlay = new ArrayList<Double>();
	    Document doc = res.parse();
	   
	    Elements bttn = doc.select("button[data-wager-type=ml]");
	    
	    for(Element elem : bttn) {
	    	if(elem.attr("data-team").contentEquals("FRANCE")) {
		    	break;
		    }
	   
	    String teamname = elem.attr("data-team");
	    String ml = elem.attr("data-odds");
	    double value = Double.valueOf(ml);
	    if(value < 0) {
	    	double x = value  * -1;
	    	x = (100/x) + 1;
	    	   System.out.println(teamname + " " + x);
	    	   parlay.add(x);
	    }
	    else {
	    	value =  (value/100) + 1;
	   	   System.out.println(teamname + " " + value);
	    	   parlay.add(value);
	    }
	 
	   if(elem.attr("data-team").equals( "DRAW")) {
		   System.out.println("----------");
		   	
	   			}
	    }
//	    System.out.println(adder(parlay) );


	}
	static double adder(ArrayList<Double> h) {
double d = 0;
		   for(int p = 0; p < h.size(); p = p + 2) {
			
			   if(p != h.size() - 4) {
				//   System.out.println(h.get(p));
				   d =  h.get(p) * h.get(p+2);;
			
			   }
			   else {
				   return d;
			   }
			   
		   }
		   return d;
		
	}
	}


