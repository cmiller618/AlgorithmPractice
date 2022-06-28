using System;

namespace C_Sharp_Practice_2
{
    class Practice
    {
        static void Main(string[] args)
        {
            Console.WriteLine(parse());
            ConvertString();
            int index = StringSearch();
            if(index >= 0)
            {
                Console.WriteLine("Character found at index " + index);
            }
            else
            {
                Console.WriteLine("Character not found");
            }
        }

        public static string parse()
        {
            string stringForFloat = "0.85"; // datatype should be float
            string stringForInt = "12345"; // datatype should be int

            float floatNumber = float.Parse(stringForFloat);
            int intString = Int32.Parse(stringForInt);

            return "Float: " + floatNumber + " Int: " + intString;
        }

        public static void ConvertString()
        {
            Console.WriteLine("Please Enter Your Name: ");
            string name = Console.ReadLine();
            Console.WriteLine(name.ToUpper() + "\n");
            Console.WriteLine(name.ToLower() + "\n");
            Console.WriteLine(name.Trim() + "\n");
            Console.WriteLine(name.Substring(0) + "\n");
        }

        public static int StringSearch()
        {
            Console.WriteLine("Please Enter Your String: ");
            string word = Console.ReadLine();
            Console.WriteLine("Please Enter Your character to search: ");
            char character = char.Parse(Console.ReadLine());

            char[] letters = word.ToCharArray();
            for (int i = 0; i < letters.Length; i++)
            {
                if (character == letters[i])
                    return i;
            }

            return -1;
        }
    }
}
