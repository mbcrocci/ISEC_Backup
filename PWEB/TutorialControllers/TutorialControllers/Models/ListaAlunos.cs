using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using TutorialControllers.Models;

namespace TutorialControllers
{
    public class ListaAlunos
    {
        List<Alunos> lista;

        public ListaAlunos()
        {
            lista.Add(new Aluno(1, "ola"));
        }

        public void addAluno(Aluno a)
        {
           lista.Add(a);
        }

        public Aluno getAluno(int i)
        {
            return lista[i];
        }
    }
}
