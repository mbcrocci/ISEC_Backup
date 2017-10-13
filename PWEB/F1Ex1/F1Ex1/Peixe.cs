using System;
namespace F1
{
    public class Peixe
    {
        private TipoPeixe tipo;
        private int peso;
        private bool valido;

        public Peixe(TipoPeixe t, int p)
        {
            tipo = t;
            peso = p;
            valido = true;
        }
        public Peixe( TipoPeixe t, int p, bool v)
        {
            tipo = t;
            peso = p;
            valido = v;
        }

        public TipoPeixe Tipo { get => tipo; }
        public int Peso { get; set; }
        public bool Valido { get; set; }

        public int ObtemPontuacao()
        {
            return tipo.Pontuacao;
        }
    }
}
