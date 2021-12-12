/**
 * MIT License
 *
 * Copyright(c) 2021 João Caram <caram@pucminas.br>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

import java.util.Objects;
import java.util.Scanner;

/** Classe Sanduíche, herda de Comida */
public class Sanduiche extends Comida implements IFlyWeight{

    /** Preço base do sanduíche */
    private static final double PRECO_SANDUICHE = 12.0;
    /** Máximo de adicionais de um sanduíche */
    private static final int MAX_ADICIONAIS = 7;

    /** Regra própria: pode ter o dobro de carne */
    private boolean dobroDeCarne;

    private boolean sanduicheExtra = false;
    private final double valorExtra = 1.5;

    /**
     * Construtor: indica se tem o dobro de carne
     */
    public Sanduiche(boolean dobro){
        super(PRECO_SANDUICHE, MAX_ADICIONAIS); //construtor da classe mãe
        this.setDescricao("Sanduíche ");
        this.dobroDeCarne = dobro;
        String chave;
        if(this.dobroDeCarne)
            this.descricao += "com duas carnes ";

        System.out.println("Deseja um sanduiche igual o seu por metade do preço? (y/n)");
        Scanner teclado = new Scanner(System.in);
        chave = teclado.nextLine();
        if (Objects.equals(chave, "y") || Objects.equals(chave, "Y")){
            this.sanduicheExtra = true;
            operacao();
        }
        else if (Objects.equals(chave, "n") || Objects.equals(chave, "N"))
            this.sanduicheExtra = false;
        else
            System.out.println("Comando não reconhecido. Tratando como falso.");
    }

    /**
     * Calcula o preço final, com a regra própria do dobro de carne
     */
    @Override
    public double precoFinal() {
        double precoFinal = precoBase+(this.qtAdicionais * VALOR_ADICIONAL);
        if(this.dobroDeCarne)
            precoFinal+=5.0;

        if (this.sanduicheExtra)
            precoFinal *= valorExtra;
        return precoFinal;
    }

    public void operacao(){
        System.out.println("Adicionando sanduiche");
    }
}
