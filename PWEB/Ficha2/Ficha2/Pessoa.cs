using System;
namespace Ficha2
{
    namespace Exercicio4
    {
        public class Pessoa
        {
            protected DateTime dataNascimento;
            protected string nome;

            public Pessoa()
            { }

            public Pessoa(int dia, int mes, int ano, string nome = "Deconhecido")
            {
                this.dataNascimento = new DateTime(ano, mes, dia);
                this.nome = nome;
            }
            public Pessoa (string nome = "Desconhecido")
            {
                this.dataNascimento = new DateTime();
                this.nome = nome;
            }

            public DateTime DataNascimento { get; set; }
            public string Nome { get; set; }

            public override string ToString()
            {
                return string.Format("[Pessoa: DataNascimento={0}, Nome={1}]", DataNascimento, Nome);
            }

        }
    }
}
