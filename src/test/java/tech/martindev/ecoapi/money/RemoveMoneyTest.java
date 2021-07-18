package tech.martindev.ecoapi.money;

import org.junit.Assert;
import org.junit.Test;
import tech.martindev.ecoapi.controller.EcoController;
import tech.martindev.ecoapi.service.EcoTable;

public class RemoveMoneyTest {

    @Test
    public void devePoderRemoverValores(){
        new EcoTable();
        String testUser = "userRM1";
        EcoController ecoController = new EcoController();
        ecoController.criarConta(testUser);
        ecoController.adicionar(testUser, 20);
        ecoController.diminuir(testUser, 10);
        Assert.assertEquals(10, ecoController.consultar(testUser).intValue());
    }

    @Test
    public void deveRetornarZeroAoTentarRemoverValoresNegativos(){
        new EcoTable();
        String testUser = "userRM2";
        EcoController ecoController = new EcoController();
        ecoController.criarConta(testUser);
        ecoController.adicionar(testUser, 20);
        ecoController.diminuir(testUser, -10);
        Assert.assertEquals(0, ecoController.consultar(testUser).intValue());
    }
}
