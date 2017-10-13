using System;
namespace Exercicio3
{
    public class Quadrado : Forma
    {
        private double comprimento;
        private double largura;

        public Quadrado()
        {
        }
        public Quadrado(double comprimento, double largura) {
            this.comprimento = comprimento;
            this.largura = largura;
        }

        public double CalculaArea() {
            return this.comprimento * this.largura;
        }
    }
}
