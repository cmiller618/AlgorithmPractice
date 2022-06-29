using System;

namespace HighScore
{
    class Program
    {
        static int highscore = 0;
        static string highplayer = "";
        static void Main(string[] args)
        {
            int score;
            do
            {
                Console.WriteLine("Enter the player");
                string player = Console.ReadLine();
                Console.WriteLine("Enter the score (enter negative number to exit");
                score = Int32.Parse(Console.ReadLine());
                if(score != -1)
                {
                    HighScore(score, player);
                }

            } while (score < 0);
        }

        static void HighScore(int score, string player)
        {
            if (score > highscore)
            {
                highscore = score;
                highplayer = player;
                Console.WriteLine("Player " + highplayer + " has taken the top spot with a score of " + highscore);
            }
            else
            {
                Console.WriteLine("Player " + player + "'s " + score + " did not overtake Player " + highplayer + "'s " + score);
                Console.WriteLine("Player " + highplayer + " still has the highscore");
            }
        }
    }
}
