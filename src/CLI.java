package src;


import java.util.function.Function;
import java.util.*;
import java.io.*;


class Command


{


	// private String name;
	private Function<Map<String, String[]>, Integer> function;
	private int argsRequired;
	private String help;


	public Command(Function<Map<String, String[]>, Integer> function, int argsRequired)


	{


		this.help = "";
		this.function = function;
		this.argsRequired = argsRequired;


	}  //  public Command(Function<Map<String, String[]>, Integer> function, int argsRequired)


	public Command(Function<Map<String, String[]>, Integer> function, int argsRequired, String help)


	{


		this.help = help;
		this.function = function;
		this.argsRequired = argsRequired;


	}  //  public Command(Function<Map<String, String[]>, Integer> function, int argsRequired)


	public String getHelp()


	{


		return this.help;


	}  //  public String getHelp()


	public Integer runCommand(Map<String, String[]> args)


	{


		// System.out.printf("%d\n", args.size());
		if ( args.size() < this.argsRequired )
			return -1;
		return this.function.apply(args);


	}  //  public Integer runCommand(String arg)


	public int getArgsRequired()


	{

	
		return this.argsRequired;


	}


}  //  class Command


class CLI


{


	private Map<String, Command> commands;
	private String[] args;
	private String currentCommand;


	public CLI(String[] args, Map<String, Command> commands, String currentCommand)


	{


		this.commands = commands;
		this.args = args;
		this.currentCommand = currentCommand;


	}  //  public CLI(String[] args)


	public void usage()


	{


		System.out.printf("Usage: %s [command] [options]\n", this.currentCommand);
		System.out.printf("Commands:\n");
		for (Map.Entry<String, Command> entry : this.commands.entrySet())
			System.out.printf("\t%s: %s\n", entry.getKey(), entry.getValue().getHelp());


	}  //  public void usage()


	public String getCommandName()


	{


		return this.args[0];


	}  //  public String getCommandName()


	public static String getInput()


	{


		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Scanner scanner = new Scanner(System.in);
		StringBuilder stringBuilder = new StringBuilder();


		while ( scanner.hasNextLine() )


		{
			

			stringBuilder.append(scanner.nextLine());
			stringBuilder.append(System.lineSeparator());
			

		}  //  while ( scanner.hasNextLine() )


		stringBuilder.deleteCharAt((stringBuilder.length() - 1));
		scanner.close();
		String input = stringBuilder.toString();
		return input;


	}  //  public static String getInput()


	public void run()


	{


		if ( this.args.length == 0)


		{


			this.usage();
			return;


		}  //  if ( this.args.length == 0 )


		String commandName = this.getCommandName();


		if ( !this.commands.containsKey(commandName) )


		{


			System.out.printf("Error: no such command %s\n", commandName);
			this.usage();
			return;


		}  //  if ( this.commands.containsKey(commandName) )


		Command command = this.commands.get(commandName);
		Map<String, String[]> arguments = new HashMap<>();


		if ( this.args.length < command.getArgsRequired() )


		{


			System.out.printf("My commands don't have arguments for this project.");
			return;


		}  //  if ( this.args.length < command.getArgsRequired() )


		command.runCommand(arguments);


	}  //  public void run()


}  //  class CLI

