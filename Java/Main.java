import java.io.BufferedReader;
import java.io.CharConversionException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.management.ListenerNotFoundException;
import java.util.Scanner;

public class Main {
  // private static String[] words = {"terminator", "banana", "computer", "cow", "rain", "water" };
	private static String word = getRandomWord();
	private static String underscore = new String(new char[word.length()]).replace("\0", "_");
	private static int count = 0;

  public static void main(String[] args) throws Exception {
    List<String> lines = Collections.emptyList();
    try {
      lines =
        Files.readAllLines(
          Paths.get("../secretMessage.txt"),
          StandardCharsets.UTF_8
        );
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println(AverageSecretMessage(lines));
    System.out.println(DecodeSecretMessage(lines));
    System.out.println(FizzBuzz(15));
    // System.out.println(getRandomWord());


    Scanner sc = new Scanner(System.in);
		while (count < 7 && underscore.contains("_")) {
			System.out.println("Guess any letter in the word");
			System.out.println(underscore);
			String guess = sc.next();
			hang(guess);
		}
		sc.close();
  }

  public static int AverageSecretMessage(List<String> array) {
    List<String> lines = new ArrayList<String>();
    for (String str : array) for (String s : str.split(" ")) {
      lines.add(s);
    }

    int[] numbers = new int[lines.size()];
    for (int i = 0; i < lines.size(); i++) {
      numbers[i] = Integer.parseInt(lines.get(i));
    }
    int sum = 0;
    for (int i = 0; i < numbers.length; i++) {
      sum += numbers[i];
    }
    return sum / numbers.length;
  }
  public static String DecodeSecretMessage(List<String> array) {
    List<String> lines = new ArrayList<String>();
    for (String str : array) for (String s : str.split(" ")) {
      lines.add(s);
    }
    int[] numbers = new int[lines.size()];
    for (int i = 0; i < lines.size(); i++) {
      numbers[i] = Integer.parseInt(lines.get(i));
    }
    String secretMessage = "";
    for (int value : numbers) { 
      secretMessage += (char)value;
    }
    return secretMessage;
  }
  public static List<String> FizzBuzz(int n) {
    // List<String> list = new List<String>(n);
    // List<String> list;
    // List list = new List<String>();
    List list = new ArrayList<>();
    String item = "";
    for (int i = 1; i <= n; i++) {
      if ((i % 3 == 0) && (i % 5 == 0))
      item = "FizzBuzz";
      else if ((i % 3 == 0) && (i % 5 != 0))
      item = "Fizz";
      else if ((i % 3 != 0) && (i % 5 == 0))
      item = "Buzz";
      else
      item = String.valueOf(i);
      list.add(item);
    }
    return list;
  }

  public static String getRandomWord() {
    List<String> lines = Collections.emptyList();
    try {
      lines = 
        Files.readAllLines(
          Paths.get("../Hangman_Words.txt"),
          StandardCharsets.UTF_8
        );
    } catch (IOException e) {
      e.printStackTrace();
    }

    List<String> words = new ArrayList<String>();
    for (String str : lines) for (String s : str.split(" ")) {
      words.add(s);
    }
    // String word = words{(int) (Math.random() * words.length)};
    // Random rand = new Random();
    String word = words.get((int)(Math.random() * (words.size())));
    return word;
  }
	public static void hang(String guess) {
		String newunderscore = "";
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == guess.charAt(0)) {
				newunderscore += guess.charAt(0);
			} else if (underscore.charAt(i) != '_') {
				newunderscore += word.charAt(i);
			} else {
				newunderscore += "_";
			}
		}
		if (underscore.equals(newunderscore)) {
			count++;
			hangmanImage();
		} else {
			underscore = newunderscore;
		}
		if (underscore.equals(word)) {
			System.out.println("Correct! You win! The word was " + word);
		}
	}
	public static void hangmanImage() {
		if (count == 1) {
			System.out.println("Wrong guess, try again");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("___|___");
			System.out.println();
		}
		if (count == 2) {
			System.out.println("Wrong guess, try again");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (count == 3) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   | ");
			System.out.println("___|___");
		}
		if (count == 4) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (count == 5) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |           |");
			System.out.println("   |           |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (count == 6) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |           |");
			System.out.println("   |           |");
			System.out.println("   |          / \\ ");
			System.out.println("___|___      /   \\");
		}
		if (count == 7) {
			System.out.println("GAME OVER!");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |          _|_");
			System.out.println("   |         / | \\");
			System.out.println("   |          / \\ ");
			System.out.println("___|___      /   \\");
			System.out.println("GAME OVER! The word was " + word);
		}
	}
}
