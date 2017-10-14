using System;
namespace Ficha2
{
    namespace Exercicio3
    {
        public class Triangulo
        {
            private Double altura;
            private Double comprimentoBase;

            public Triangulo()
            { }

            public Triangulo(Double altura, Double comprimentoBase)
            {
                this.altura = altura;
                this.comprimentoBase = comprimentoBase;
            }

            public Double CalculaArea()
            {
                return (this.comprimentoBase * this.altura) / 2;
            }
        }
    }
}
