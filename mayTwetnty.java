import java.util.TreeMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class mayTwetnty
{
	TreeMap<String, Integer> charFrequency = new TreeMap<String, Integer>();

	public mayTwetnty()
	{
		charFrequency.put("a", 0);
		charFrequency.put("b", 0);
		charFrequency.put("c", 0);
		charFrequency.put("d", 0);
		charFrequency.put("e", 0);
		charFrequency.put("f", 0);
		charFrequency.put("g", 0);
		charFrequency.put("h", 0);
		charFrequency.put("i", 0);
		charFrequency.put("j", 0);
		charFrequency.put("k", 0);
		charFrequency.put("l", 0);
		charFrequency.put("m", 0);
		charFrequency.put("n", 0);
		charFrequency.put("o", 0);
		charFrequency.put("p", 0);
		charFrequency.put("q", 0);
		charFrequency.put("r", 0);
		charFrequency.put("s", 0);
		charFrequency.put("t", 0);
		charFrequency.put("u", 0);
		charFrequency.put("v", 0);
		charFrequency.put("w", 0);
		charFrequency.put("x", 0);
		charFrequency.put("y", 0);
		charFrequency.put("z", 0);


		try{
			BufferedReader reader = new BufferedReader(new FileReader("LOTR - Fellowship.txt"));
			String temp;

			while((temp=reader.readLine())!=null){
				String[] pieces=temp.split("");

				for(int i = 0; i < pieces.length; i++)
				{
					String lowerCase = pieces[i].toLowerCase();
					for(String str : charFrequency.keySet())
					{
						if(lowerCase.equals(str)){
							charFrequency.put(str, charFrequency.get(str)+1);
						}
					}
				}
			}
		}catch(Exception e){

		}

		for(String str: charFrequency.keySet())
		{
			System.out.println(str + ": " + charFrequency.get(str));
		}
			System.out.println();
			System.out.println();
			System.out.println();
		



		ArrayList<String> avg = new ArrayList<String>();
		for(String str : charFrequency.keySet())
		{
			Double d = ((double)charFrequency.get(str)/26)/100;
			avg.add((String.valueOf(d)));
		}
			System.out.println();
			System.out.println();
			System.out.println();
	}

	public static void main(String[]args)
	{
		mayTwetnty may = new mayTwetnty();
	}
}