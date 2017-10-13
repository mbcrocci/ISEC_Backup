using System;

namespace Ficha2
{
    class MainClass
    {
        public static void Main(string[] args)
        {
            Forma circulo = new Circulo(10.12);

            Console.WriteLine($"Area do circulo: {circulo.CalcularArea()}");
        }
    }
}
