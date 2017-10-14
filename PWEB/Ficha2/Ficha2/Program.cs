using System;
using Ficha2.Exercicio3;
using Ficha2.Exercicio4;
using System.Collections.Generic;

namespace Ficha2
{
 
    
    class MainClass
    {
        public static void Main(string[] args)
        {
            Forma circulo = new Circulo(10.12);

            Console.WriteLine($"Area do circulo: {circulo.CalcularArea()}");
        }

        public static Pessoa InserirPessoa()
        {
            Console.Write("Nome: ");
            string nome = Console.ReadLine();

            Console.WriteLine("Data de nascimento");

            Console.Write("Dia: ");
            int dia = int.Parse(Console.ReadLine());

            Console.Write("Dia: ");
            int mes = int.Parse(Console.ReadLine());

            Console.Write("Dia: ");
            int ano = int.Parse(Console.ReadLine());

            return new Pessoa(dia, mes, ano, nome);
        }

        public static void MostraDadosPessoa(Pessoa pessoa)
        {
            Console.WriteLine(pessoa.ToString());
        }

        public static void MostraPessoas(List<Pessoa> pessoas)
        {
            foreach (var pessoa in pessoas)
            {
                MostraDadosPessoa(pessoa);
            }
        }
    }
}
