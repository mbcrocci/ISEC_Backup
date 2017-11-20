using System;

namespace TutorialControllers.Models
{
    public class Aluno
    {
        public string nome { get; set; }
        public int numero { get; set; }
        public Aluno(int num, String nome)
        {
            this.numero = num;
            this.nome = nome;
        }
    }
}
