/*
 * MIT License
 *
 * Copyright (c) 2017 José Nascimento <joseaugustodearaujonascimento@gmail.com>
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
package br.edu.ifrn.teste;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Estatisticas {

    public static Estatisticas estatisticas(Object[] _args) {

        if (!_args.getClass().equals(Integer[].class))
            throw new IllegalArgumentException("Tipo deve ser Int[]");

        if (_args.length <= 0)
            throw new IllegalArgumentException(
                "Array deve ter tamanho maior que zero");

        Integer[] args = (Integer[]) _args;
        int min, max;
        double avg;

        avg = 0;
        min = args[0];
        max = args[0];

        for (Integer i : args) {

            if (i < min)
                min = i;

            if (i > max)
                max = i;

            avg = avg + i;

        }

        return new Estatisticas(min, max, avg / args.length, args.length);

    }

    final int menor;
    final int maior;
    final double media;
    final int tamanho;

    Estatisticas(int menor, int maior, double media, int tamanho) {

        this.menor = menor;
        this.maior = maior;
        this.media = media;
        this.tamanho = tamanho;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {

            return false;
        }

        if (obj.getClass().equals(Estatisticas.class)) {

            Estatisticas other = (Estatisticas) obj;

            return other.menor == this.menor
                && other.maior == this.maior
                && other.media == this.media
                && other.tamanho == this.tamanho;

        } else {

            return false;
        }

    }

}
