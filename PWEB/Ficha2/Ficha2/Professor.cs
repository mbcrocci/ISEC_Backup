using System;
namespace Ficha2
{
    namespace Exercicio4
    {
        public class Professor
        {
            private string habilitacoes;

            public Professor(string habilitacoes = "Licenciatura")
            {
                this.habilitacoes = habilitacoes;
            }

            public override string ToString()
            {
                return string.Format("[Professor]");
            }
        }
    }
}
