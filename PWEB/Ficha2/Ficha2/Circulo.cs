using System;
namespace Ficha2
{
    namespace Exercicio3 {
        
        public class Circulo : Forma
        {
            private Double raio;

            public Circulo() { }
            public Circulo(Double raio)
            {
                this.raio = raio;
            }

            public override Double CalcularArea()
            {
                return 3.1416 * raio * raio;
            }
        }
    }
}
