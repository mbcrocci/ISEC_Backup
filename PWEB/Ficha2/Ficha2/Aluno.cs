using System;
namespace Ficha2
{
    namespace Exercicio4
    {
        public class Aluno
        {
            private int numAluno;

            public Aluno(int numAluno)
            {
                this.numAluno = numAluno;
            }

            public int NumAluno { get; set; }

            public override string ToString()
            {
                return string.Format("[Aluno: NumAluno={0}]", NumAluno);
            }
        }
    }
}
