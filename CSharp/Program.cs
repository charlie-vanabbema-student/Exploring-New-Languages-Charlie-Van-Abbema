using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;
public class Program
{
    public static void Main(string[] args)
    {
        // Console.WriteLine(AverageSecretMessage());
        // Console.WriteLine(DecodeSecretMessage());
        // foreach(var v in FizzBuzz(15))
        //     {
        //         Console.Write(v + " ");
        //     }

        Hangman();

        static float AverageSecretMessage()
        {
            string text = File.ReadAllText(@"../secretMessage.txt");
            string[] numberstext = text.Split(" ");
            int[] numbers = Array.ConvertAll(numberstext, s => int.Parse(s));
            int sum = 0;

            for (int i = 0; i < numbers.Length; i++)
            {
                sum += numbers[i];
            }
            return (float)sum / numbers.Length;
        }

        static string DecodeSecretMessage()
        {
            string text = File.ReadAllText(@"../secretMessage.txt");
            string[] numberstext = text.Split(" ");
            int[] numbers = Array.ConvertAll(numberstext, s => int.Parse(s));
            string secretmessage = "";
            foreach (char value in numbers)
            {
                secretmessage += Convert.ToChar(value);
            }
            return secretmessage;
        }

        static IList<string> FizzBuzz(int n)
        {
            var list = new List<string>(n);
            for (int i = 1; i <= n; i++)
            {
                string item = (i % 3 == 0, i % 5 == 0)
                switch
                {
                    (true, true) => "FizzBuzz",
                    (true, false) => "Fizz",
                    (false, true) => "Buzz",
                    (false, false) => i.ToString(),
                };
                list.Add(item);
            }
            return list;
        }

        static void Hangman()
        {
            string[] Renders =
            {
                #region Frames
                // 0
                @"      ╔═══╗   " + '\n' +
                @"      |   ║   " + '\n' +
                @"          ║   " + '\n' +
                @"          ║   " + '\n' +
                @"          ║   " + '\n' +
                @"     ███  ║   " + '\n' +
                @"    ══════╩═══",
                // 1
                @"      ╔═══╗   " + '\n' +
                @"      |   ║   " + '\n' +
                @"      O   ║   " + '\n' +
                @"          ║   " + '\n' +
                @"          ║   " + '\n' +
                @"     ███  ║   " + '\n' +
                @"    ══════╩═══",
                // 2
                @"      ╔═══╗   " + '\n' +
                @"      |   ║   " + '\n' +
                @"      O   ║   " + '\n' +
                @"      |   ║   " + '\n' +
                @"          ║   " + '\n' +
                @"     ███  ║   " + '\n' +
                @"    ══════╩═══",
                // 3
                @"      ╔═══╗   " + '\n' +
                @"      |   ║   " + '\n' +
                @"      O   ║   " + '\n' +
                @"      |\  ║   " + '\n' +
                @"          ║   " + '\n' +
                @"     ███  ║   " + '\n' +
                @"    ══════╩═══",
                // 4
                @"      ╔═══╗   " + '\n' +
                @"      |   ║   " + '\n' +
                @"      O   ║   " + '\n' +
                @"     /|\  ║   " + '\n' +
                @"          ║   " + '\n' +
                @"     ███  ║   " + '\n' +
                @"    ══════╩═══",
                // 5
                @"      ╔═══╗   " + '\n' +
                @"      |   ║   " + '\n' +
                @"      O   ║   " + '\n' +
                @"     /|\  ║   " + '\n' +
                @"       \  ║   " + '\n' +
                @"     ███  ║   " + '\n' +
                @"    ══════╩═══",
                // 6
                @"      ╔═══╗   " + '\n' +
                @"      |   ║   " + '\n' +
                @"      O   ║   " + '\n' +
                @"     /|\  ║   " + '\n' +
                @"     / \  ║   " + '\n' +
                @"     ███  ║   " + '\n' +
                @"    ══════╩═══",
                #endregion
            };
            string text = File.ReadAllText(@"../Hangman_Words.txt");
            string[] wordsarray = text.Split();
            string word = wordsarray[RandomNum(0, wordsarray.Length - 1)].ToLower();
            var validCharacters = new Regex("^[a-z]$");
            int lives = 6;
            int frame = 0;
            var letters = new List<string>();
            Console.WriteLine(Renders[frame]);

            while (lives != 0)
            {
                int charactersLeft = 0;

                // char guessedletter = Convert.ToChar(Console.ReadLine());
                // char.ToLower(guessedletter);
                foreach (char character in word)
                {
                    var letter = character.ToString();

                    if (letters.Contains(letter))
                    {
                        Console.Write(letter);
                    }
                    else
                    {
                        Console.Write("_");
                        charactersLeft++;
                    }
                }
                Console.WriteLine(string.Empty);

                if (charactersLeft == 0)
                {
                    break;
                }

                
                Console.Write("Guess a letter: ");
                

                var key = Console.ReadKey().Key.ToString().ToLower();
                Console.WriteLine(string.Empty);

                if (!validCharacters.IsMatch(key))
                {
                    Console.WriteLine($"{key} is invalid. Try again.");
                    // frame++;
                    Console.WriteLine(Renders[frame]);
                    continue;
                }

                if (letters.Contains(key))
                {
                    Console.WriteLine("Already guessed.");
                    Console.WriteLine(Renders[frame]);
                    continue;
                }

                letters.Add(key);

                if (!word.Contains(key))
                {
                    frame++;
                    lives--;
                    

                    if (lives > 0)
                    {
                        Console.WriteLine(Renders[frame]);
                    }
                }
            }

            if (lives > 0)
            {
                Console.WriteLine($"You won with {lives} {(lives == 1 ? "life" : "lives")} left!");
            }
            else
            {
                Console.WriteLine(Renders[frame]);
                Console.WriteLine($"You lost! The word was {word}.");
            }
        }

        static int RandomNum(int x, int n)
        {
            Random rnd = new Random();
            int num = rnd.Next(x, n);
            return num;
        }
    }
}