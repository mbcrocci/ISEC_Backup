using System;
namespace Ficha2
{
    public class Pessoa
    {
        private DateTime dataNascimento;
        private string nome;

        public Pessoa()
        {}

        public Pessoa(int dia, int mes, int ano, string nome) {
            this.dataNascimento = (ano, mes, dia);
            this.nome = nome;
        }

        public DateTime DataNascimento { get; set; }
        public string nome { get; set; }

        public string ToString() {
            return $"{nome}: {dataNascimento}";
        }
    }
}
