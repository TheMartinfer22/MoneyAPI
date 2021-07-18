package tech.martindev.ecoapi.money;

import org.junit.Assert;
import org.junit.Test;
import tech.martindev.ecoapi.controller.EcoController;
import tech.martindev.ecoapi.service.EcoTable;

public class AddMoneyTest {

    @Test
    public void deveAdicionarOSaldo() {
        new EcoTable();
        String testUser = "user1";
        EcoController ecoController = new EcoController();
        ecoController.criarConta(testUser);
        ecoController.adicionar(testUser, 20);
        Assert.assertEquals(20, ecoController.consultar(testUser).intValue());
    }

    @Test
    public void deveRetornarZeroAoAdicionarZero() {
        new EcoTable();
        String testUser = "user2";
        EcoController ecoController = new EcoController();
        ecoController.criarConta(testUser);
        ecoController.adicionar(testUser, 0);
        Assert.assertEquals(0, ecoController.consultar(testUser).intValue());
    }

    @Test
    public void deveRetornarMaisDeUmMilhaoAoAdicionarMaisDeUmMilhao() {
        new EcoTable();
        String testUser = "user4";
        EcoController ecoController = new EcoController();
        ecoController.criarConta(testUser);
        ecoController.adicionar(testUser, 1000000);
        Assert.assertEquals(1000000, ecoController.consultar(testUser).intValue());
    }

    @Test
    public void naoPodeAceitarNumerosQueSaoMenoresQueZero() {
        new EcoTable();
        String testUser = "user5";
        EcoController ecoController = new EcoController();
        ecoController.criarConta(testUser);
        ecoController.adicionar(testUser, -1);
        Assert.assertEquals(0, ecoController.consultar(testUser).intValue());
    }
}
