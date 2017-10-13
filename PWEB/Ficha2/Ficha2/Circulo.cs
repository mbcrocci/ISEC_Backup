using System;
namespace Ficha2
{
    public class Circulo : Forma
    {
        private double raio;

        public Circulo() {}
        public Circulo(double raio) {
            this.raio = raio;
        }

        public double CalculateArea() {
            return 3.1416 * raio * raio;
        }
    }
}
