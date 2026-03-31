package src;


import src.CLI.*;
import java.util.*;
import java.lang.IllegalArgumentException;


public class mainacv01


{




	public static Integer b64decode(Map<String, String[]> kwargs)


	{


		String message = CLI.getInput();
		// System.out.printf("%s", message);
		

		try


		{
			

			B64Encoding b64 = new B64Encoding(message);
			System.out.printf("%s\n", b64.decode());
			

		}  //  try 


		catch(java.lang.IllegalArgumentException e)


		{


			System.err.printf("The text provided was not encoded with base64.");


		}  //  catch(java.lang.IllegalArgumentException e)


		return 1;


	}  //  public static Integer b64decode(Map<String, String[]> kwargs)


	public static Integer b64encode(Map<String, String[]> kwargs)


	{


		String message = CLI.getInput();
		// System.out.printf("%s", message);
		B64Encoding b64 = new B64Encoding(message);
		System.out.printf("%s\n", b64.encode());
		return 1;


	}  //  public static Integer b64encode(Map<String, String[]> kwargs)


	public static void main(String[] args)


	{


		// kwargs.put("testCommand", new Command("testCommand", mainacv01::testCommand, 0));
		// System.out.printf("%s\n", CLI.getInput());
		Map<String, Command> commands = new HashMap<>();
		commands.put("encode", new Command(mainacv01::b64encode, 0, "Encode a string with base64."));
		commands.put("decode", new Command(mainacv01::b64decode, 0, "Decode base64 encoding."));
		CLI cli = new CLI(args, commands, "java final2WeeksProject.mainacv01");
		cli.run();


	}  //  public static void main(String[] args)


}  //  public class mainacv01

