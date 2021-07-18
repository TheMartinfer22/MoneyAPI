package tech.martindev.ecoapi.controller;

import tech.martindev.ecoapi.service.EcoService;

public class EcoController {
    EcoService ecoService = new EcoService();

    /**
     * Você irá criar a conta do player
     * passando apenas o nome do jogador
     *
     * @param player String
     */
    public void criarConta(String player){
        ecoService.criarConta(player);
    }

    /**
     * Você irá deletar a conta do player
     * passando apenas o nome do jogador
     *
     * @param player String
     */
    public void deletarConta(String player){
        ecoService.deletarConta(player);
    }

    /**
     * Irá consultar o saldo da conta do jogador que é passado como string e
     * irá retornar o valor de saldo.
     *
     * @param player String
     * @return
     */
    public Integer consultar(String player){
        return ecoService.consultar(player);
    }

    /**
     * Irá passar no primeiro parâmetro o player como string e no segundo
     * o valor que irá ser acrescentado.
     *
     * @param player String
     * @param saldo Integer
     */
    public void adicionar(String player, Integer saldo){
        ecoService.adicionar(player, saldo);
    }

    /**
     * Irá passar no primeiro parâmetro o player como string e no segundo
     * o valor que irá ser decrementado.
     *
     * @param player String
     * @param saldo Integer
     */
    public void diminuir(String player, Integer saldo){
        ecoService.diminuir(player, saldo);
    }
}
