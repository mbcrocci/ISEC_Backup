using System;
namespace Ficha2
{
    public class Quadrado : Forma
    {
        private Double comprimento;
        private Double largura;

        public Quadrado()
        {
        }
        public Quadrado(double comprimento, double largura) {
            this.comprimento = comprimento;
            this.largura = largura;
        }

        public override Double CalcularArea() {
            return this.comprimento * this.largura;
        }
    }
}
