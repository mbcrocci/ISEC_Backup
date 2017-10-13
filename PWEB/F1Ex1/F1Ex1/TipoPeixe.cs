using System;
namespace F1
{
    public class TipoPeixe
    {
		private string tipo;
		private int pontuacao;

		public TipoPeixe(string t, int p)
		{
			tipo = t;
			pontuacao = p;
		}

        public string Tipo { get; set; }
        public int Pontuacao { get; set; }
    }
}
