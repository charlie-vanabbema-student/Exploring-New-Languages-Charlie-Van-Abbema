using System;
public class Program
{
    public static void Main(string[] args)
    {
        string text = File.ReadAllText(@"../secretMessage.txt");
        Console.WriteLine(AverageSecretMessage(text));
        static float AverageSecretMessage(string text)
        {
            string[] numberstext = text.Split(" ");
            int[] numbers = Array.ConvertAll(numberstext, s => int.Parse(s));
            int sum = 0;
            
            for (int i = 0; i < numbers.Length; i++)
            {
                sum += numbers[i];
            }
            return (float)sum / numbers.Length;
        }

        static string DecodeSecretMessage(int[] arr)
        {
            string secretmessage = "";
            foreach (char value in arr)
            {
                secretmessage += Convert.ToChar(value);
            }
            return secretmessage;
        }
        
        
    }
}