using System;
namespace F1
{
    public class Tarefa
    {
        private string prioridade; // { Baixa, Normal, Alta };
        private string categoria;   // { Pessoal, Trabalho };
        private string estado;     // { Executar, Execucao, Concluida };
        private string titulo;
        private DateTime dataLimite;

        public Tarefa(string titulo, DateTime dataLimite,
                      string prioridade = "Alta",
                      string categoria = "Trabalho",
                      string estado = "Por Executar")
        {
            this.prioridade = prioridade;
            this.categoria = categoria;
            this.estado = estado;
            this.titulo = titulo;
            this.dataLimite = dataLimite;
        }

        public string Prioridade { get; set; }
        public string Categoria { get; set; }
        public string Estado { get; set; }
        public string Titulo { get; set; }
        public DateTime DataLimite { get; set; }
    }
}