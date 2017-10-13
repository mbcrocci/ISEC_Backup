using System;
using System.Collections.Generic;
            
namespace F1
{
    public class Pescador
    {
        private string nome;
        private int concorrente;
        private static int number = 0;

        private List<Peixe> pescaria;

        public Pescador(string n)
        {
            nome = n;
			number++;
            concorrente = number;

            pescaria = new List<Peixe>();
        }

        public string Nome { get; set ; }
        public int Number { get => concorrente; }

        public void InserePeixe (TipoPeixe tipo, int peso)
        {
            Peixe peixe = new Peixe(tipo, peso);
            pescaria.Add(peixe);

            Console.WriteLine($"A inserir peixe: {peixe.Tipo.Tipo}");
        }

        public int CalculaPontuacao()
        {
            int pontuacao = 0;

            foreach (Peixe peixe in pescaria)
                pontuacao += peixe.ObtemPontuacao();
            
            return pontuacao;
        }
    }
}
