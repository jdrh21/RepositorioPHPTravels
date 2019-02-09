package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import pages.DemoGuruPOM;


/**
 *
 * @author Jose Daniel Restrepo
 */
public class DemoGuruTest {
        
    DemoGuruPOM Guru = new DemoGuruPOM();
    String id,id2;
    
    /*Este metodo se ejecuta antes de cada test y su función es abrir el navegador en la pagina
      Guru99, iniciar sesión con la cuenta creada y validar mediante un assert que la cuenta sea
      la correcta*/
    @Before
    public void setUp() {
        Guru.AbrirNavegador("http://demo.guru99.com/V4/index.php");
        Guru.HacerClick("btnReset");
        Guru.EnviarTexto("mngr176437", "uid");
        Guru.EnviarTexto("UrahynE", "password");
        Guru.HacerClick("btnLogin");
        String usuarioObtenido = Guru.CapturarElemento("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td");
        String usuarioEsperado = "Manger Id : mngr176437";
        Assert.assertEquals(usuarioObtenido, usuarioEsperado);
    }
    
    //Método que se ejecuta al final de cada test para cerrar el navegador
    @After
    public void tearDown() {
        Guru.CerrarNavegador();
    }
    
    /*Caso de prueba 1:
      Se crea un cliente ingresando nombre, genero, direccion, ciudad, telefono, pin, correo, contraseña
      y se valida mediante un assert que al crear el cliente, el nombre coincida con el esperado
    */
    
    @Test
    public void test_crearCustomer() {
        Guru.HacerClick2("/html/body/div[3]/div/ul/li[2]/a");
        Guru.HacerClick("res");
        Guru.EnviarTexto("Prueba", "name");
        Guru.HacerClick("rad1");
        Guru.EnviarTexto("2531993", "dob");
        Guru.EnviarTexto("Calle 19", "addr");
        Guru.EnviarTexto("Medellin", "city");
        Guru.EnviarTexto("Antioquia", "state");
        Guru.EnviarTexto("123412341234213", "pinno");
        Guru.EnviarTexto("2512451245", "telephoneno");
        String cadena = Guru.generateRandomText();
        String email = cadena.substring(0,7);
        Guru.EnviarTexto(email+"@hotmail.com", "emailid");
        Guru.EnviarTexto("asdas2424", "password");
        Guru.HacerClick("sub");
        id = Guru.CapturarElemento("//*[@id=\"customer\"]/tbody/tr[4]/td[2]");
        String nombreObtenido = Guru.CapturarElemento("//*[@id=\"customer\"]/tbody/tr[5]/td[2]");
        String nombreEsperado = "Prueba";
        Assert.assertEquals(nombreObtenido, nombreEsperado);

    }
    
    /*Caso de prueba 2:
      Se crea un cliente ingresando nombre, genero, direccion, ciudad, telefono, pin, correo, contraseña
      Luego se crea una cuenta ingresando el id de cliente generado al crearlo
      y se valida mediante un assert que al crear la cuenta, el nombre coincida con el esperado del cliente
    */
    
    @Test
    public void test_crearAccount() {
        Guru.HacerClick2("/html/body/div[3]/div/ul/li[2]/a");
        Guru.HacerClick("res");
        Guru.EnviarTexto("Prueba", "name");
        Guru.HacerClick("rad1");
        Guru.EnviarTexto("2531993", "dob");
        Guru.EnviarTexto("Calle 19", "addr");
        Guru.EnviarTexto("Medellin", "city");
        Guru.EnviarTexto("Antioquia", "state");
        Guru.EnviarTexto("123412341234213", "pinno");
        Guru.EnviarTexto("2512451245", "telephoneno");
        String cadena = Guru.generateRandomText();
        String email = cadena.substring(0,7);
        Guru.EnviarTexto(email+"@hotmail.com", "emailid");
        Guru.EnviarTexto("asdas2424", "password");
        Guru.HacerClick("sub");
        id = Guru.CapturarElemento("//*[@id=\"customer\"]/tbody/tr[4]/td[2]");
        Guru.HacerClick2("/html/body/div[3]/div/ul/li[5]/a");
        Guru.HacerClick("reset");
        Guru.EnviarTexto(id, "cusid");
        Guru.EnviarTexto("2121996", "inideposit");
        Guru.HacerClick("button2");
        id2 = Guru.CapturarElemento2("//*[@id=\"account\"]/tbody/tr[4]/td[2]");
        String nombreObtenido = Guru.CapturarElemento("//*[@id=\"account\"]/tbody/tr[6]/td[2]");
        String nombreEsperado = "Prueba";
        Assert.assertEquals(nombreObtenido, nombreEsperado);
    }
    
    /*Caso de prueba 3:
      Se crea un cliente ingresando nombre, genero, direccion, ciudad, telefono, pin, correo, contraseña
      Luego se crea una cuenta ingresando el id de cliente generado al crearlo
      se valida mediante un assert que al crear la cuenta, el nombre coincida con el esperado del cliente
      Luego se elimina la cuenta creada ingresando el numero de cuenta generado
    */
    
    @Test
    public void test_borrarAccount() {
        Guru.HacerClick2("/html/body/div[3]/div/ul/li[2]/a");
        Guru.HacerClick("res");
        Guru.EnviarTexto("Prueba", "name");
        Guru.HacerClick("rad1");
        Guru.EnviarTexto("2531993", "dob");
        Guru.EnviarTexto("Calle 19", "addr");
        Guru.EnviarTexto("Medellin", "city");
        Guru.EnviarTexto("Antioquia", "state");
        Guru.EnviarTexto("123412341234213", "pinno");
        Guru.EnviarTexto("2512451245", "telephoneno");
        String cadena = Guru.generateRandomText();
        String email = cadena.substring(0,7);
        Guru.EnviarTexto(email+"@hotmail.com", "emailid");
        Guru.EnviarTexto("asdas2424", "password");
        Guru.HacerClick("sub");
        id = Guru.CapturarElemento("//*[@id=\"customer\"]/tbody/tr[4]/td[2]");
        Guru.HacerClick2("/html/body/div[3]/div/ul/li[5]/a");
        Guru.HacerClick("reset");
        Guru.EnviarTexto(id, "cusid");
        Guru.EnviarTexto("2121996", "inideposit");
        Guru.HacerClick("button2");
        id2 = Guru.CapturarElemento2("//*[@id=\"account\"]/tbody/tr[4]/td[2]");
        String nombreObtenido = Guru.CapturarElemento("//*[@id=\"account\"]/tbody/tr[6]/td[2]");
        String nombreEsperado = "Prueba";
        Assert.assertEquals(nombreObtenido, nombreEsperado);
        Guru.HacerClick2("/html/body/div[3]/div/ul/li[7]/a");
        Guru.HacerClick("res");
        Guru.EnviarTexto(id2, "accountno");
        Guru.HacerClick("AccSubmit");
    }

}
