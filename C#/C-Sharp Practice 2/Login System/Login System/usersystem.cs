using System;
using System.Collections.Generic;

namespace Login_System
{
    // A very basic login system
    class UserSystem
    {
        static List<string> usernames = new List<string>();
        static List<string> passwords = new List<string>();
        static void Main(string[] args)
        {
            MainMenu();
        }

        public static void MainMenu()
        {
            int option = 0;

            while(option != 3)
            {
                Console.WriteLine("1. Create User");
                Console.WriteLine("2. Login");
                Console.WriteLine("3. Exit");
                option = Int32.Parse(Console.ReadLine());
                switch (option)
                {
                    case 1:
                        EnterLoginCredentials(option);
                        break;
                    case 2:
                        EnterLoginCredentials(option);
                        break;
                    case 3:
                        Console.WriteLine("Exiting Login System");
                        break;
                    default:
                        Console.WriteLine("Enter a valid number");
                        break;

                }

            }
            
        }

        public static void EnterLoginCredentials(int option)
        {
            if (option == 1)
            {
                Console.WriteLine("Create a user\n");
            }
            else
            {
                Console.WriteLine("Login\n");
            }

            Console.Write("Enter the username: ");
            string username = Console.ReadLine();
            Console.Write("Enter the password: ");
            string password = Console.ReadLine();

            if (option == 1)
            {
                if(!CreateUser(username, password))
                {
                    Console.WriteLine(username + " already exists as a user!");
                }
                else
                {
                    Console.WriteLine(username + " has been added! You may login");
                }
            }
            else
            {
                if (LoginSystem(username, password))
                {
                    Console.WriteLine("You have logged in successfully!");
                }
                else
                {
                    Console.WriteLine("Could not find the username and password combination!");
                }
            }

        }

        public static Boolean LoginSystem(string username, string password)
        {
            if (!usernames.Contains(username))
            {
                return false;
            }

            for (int i = 0; i < usernames.Capacity; i++)
            {
                if (usernames[i].Equals(username)){
                    return passwords[i].Equals(password);
                }
            }
            
            return false;
        }

        public static Boolean CreateUser(string username, string password)
        {
            if (usernames.Contains(username.Trim()))
            {
                return false;
            }

            usernames.Add(username);
            passwords.Add(password);
            return true;
        }
    }
}
