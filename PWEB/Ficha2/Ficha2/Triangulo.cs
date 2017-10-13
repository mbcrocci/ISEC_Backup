using System;
namespace Ficha2
{
    public class Triangulo
    {
        private double altura;
        private double comprimentoBase;

        public Triangulo()
        {}

        public Triangulo(double altura, double comprimentoBase) {
            this.altura = altura;
            this.comprimentoBase = comprimentoBase;
        }

        public double CalculaArea() {
            return ( this.comprimentoBase * this.altura ) / 2;
        }
    }
}
