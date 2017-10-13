using System;
using System.Collections.Generic;
namespace F1
{
    public class GestorTarefas
    {
        private List<Tarefa> tarefas;

        public GestorTarefas()
        {
        }

        public List<Tarefa> Tarefas { get => tarefas; }

        public void AddTarefa(Tarefa tarefa) 
        {
            tarefas.Add(tarefa);
        }

        public void RemoveTarefa(Tarefa tarefa)
        {
            bool result = tarefas.Remove(tarefa);
            if (!result)
                Console.WriteLine("Can't remove Tarefa");
        }

        public void ListaTarefas()
        {
            tarefas.Sort();
            foreach (Tarefa tarefa in tarefas)
            {
                Console.WriteLine($"Tarefa: {tarefa.Titulo}");
                Console.WriteLine($"\tPrioridade: {tarefa.Prioridade}");
                Console.WriteLine($"\tCategoria: {tarefa.Categoria}");
                Console.WriteLine($"\tEstado: {tarefa.Estado}");
            }
        }

        public List<Tarefa> TarefasAtrasadas()
        {
            DateTime agora = DateTime.Now;
            List<Tarefa> tarefasAtrasadas = new List<Tarefa>();

            foreach (Tarefa tarefa in tarefas)
                if (tarefa.DataLimite < agora)
                    tarefasAtrasadas.Add(tarefa);

            return tarefasAtrasadas;
        }

        public void RemoverTarefasConcluidas()
        {
            foreach (Tarefa tarefa in tarefas)
            {
                if (tarefa.Estado == "Concluida")
                    tarefas.Remove(tarefa);
            }
        }
    }
}
