using System;
using System.Collections.Generic;

namespace F1
{
    class MainClass
    {
        public static void Main(string[] args)
        {
            Ex4();
        }

        public void Ex1()
        {
			string disciplina = "Programacao Web";
			Console.WriteLine($"Disciplina {disciplina}");

			Console.Write("Nome: ");
			string nome = Console.ReadLine();

			Console.WriteLine($"Bem Vindo {nome}");

			Console.Write("Idade: ");
			string idade = Console.ReadLine();

			Int32 idadeVal = Convert.ToInt32(idade);

			if (idadeVal < 10)
			{
				Console.WriteLine("Ainda es um miudo");

			}
			else if (18 < idadeVal && idadeVal < 30)
			{
				Console.WriteLine("Ja es um adulto");

			}
			else
			{
				Console.WriteLine("Es um adulto");
			}
		}

        public static void Ex2()
        {
            string[] alunos = { "Maria Antunes", "Carlos Franco", "Cristina Pereira" };

            Console.WriteLine($"Increveram-se {alunos.Length} alunos: ");
            for (int i = 0; i < alunos.Length; i++)
                Console.WriteLine(alunos[i]);

            foreach(string aluno in alunos)
                Console.WriteLine(aluno);
        }

        public static void Ex3()
        {
            Console.Write("Introduza 2 numero: ");
            int num1 = int.Parse(Console.ReadLine());
            int num2 = int.Parse(Console.ReadLine());

            try
            {
                int resultado = num1 / num2;
				Console.WriteLine("{0} / {1} = {2}", num1, num2, resultado);
			} catch (DivideByZeroException)
            {
                Console.WriteLine("Impossivel dividir por zero");
            } catch (InvalidOperationException)
            {
                Console.WriteLine("Numero invalido");
            } catch (FormatException)
            {
                Console.WriteLine("Numero invalido");
            } catch (Exception )
            {
                Console.WriteLine("Ocurreu uma excepcao");
            } finally
            {
                Console.WriteLine("Terminou");
            }
        }

        public static void Ex4()
        {
            TipoPeixe pescada = new TipoPeixe("pescada", 10);
			TipoPeixe robalo = new TipoPeixe("robalo", 20);
			TipoPeixe faneca = new TipoPeixe("faneca", 5);
			TipoPeixe garoupa = new TipoPeixe("garoupa", 10);

            List<Pescador> pescadores = new List<Pescador>();

            pescadores.Add(new Pescador("pesc1"));
            pescadores.Add(new Pescador("pesc2"));
            pescadores.Add(new Pescador("pesc3"));
            pescadores.Add(new Pescador("pesc4"));

            AdicionarPescaria(pescadores, 1, pescada, 50);
			AdicionarPescaria(pescadores, 1, robalo, 20);
            AdicionarPescaria(pescadores, 1, robalo, 100);
			AdicionarPescaria(pescadores, 1, garoupa, 50);

			AdicionarPescaria(pescadores, 2, faneca, 10);
			AdicionarPescaria(pescadores, 2, faneca, 15);

			AdicionarPescaria(pescadores, 3, robalo, 500);

			AdicionarPescaria(pescadores, 4, pescada, 30);
			AdicionarPescaria(pescadores, 4, faneca, 20);
            AdicionarPescaria(pescadores, 4, garoupa, 10);


            foreach(Pescador pescador in pescadores)
                Console.WriteLine($"Nome: {pescador.Nome} Numero: {pescador.Number} Pontuacao: {pescador.CalculaPontuacao()}");
		}

        public static void AdicionarPescaria(List<Pescador> pescadores, int concorrente, TipoPeixe tipo, int peso)
        {
            foreach (Pescador pescador in pescadores)
                if (pescador.Number == concorrente)
                    pescador.InserePeixe(tipo, peso);
        }

        public static void Ex5()
        {
            GestorTarefas gestor = new GestorTarefas();

            gestor.AddTarefa(new Tarefa("Tarefa 1", new DateTime(2017, 11, 10),
                                        "Baixa", "Concluida"));
            
        }
    }
}
