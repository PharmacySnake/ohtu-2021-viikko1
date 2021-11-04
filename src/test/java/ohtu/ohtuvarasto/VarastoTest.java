package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisaaTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void varastostaOttaminenEiMuutaSaldoaNegatiiviseksi() {
        varasto.lisaaVarastoon(8);
        varasto.otaVarastosta(10);

        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void varastonSaldoEiYlitäTilavuutta() {
        varasto.lisaaVarastoon(20);
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void varastonSaldoOnNollaTaiPositiivinen() {
        varasto.lisaaVarastoon(-1);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void tulostaaOikeanTiedonVarastosta() {
        //varasto.lisaaVarastoon(1);
        assertEquals("saldo = " + varasto.getSaldo() + ", vielä tilaa " + varasto.paljonkoMahtuu(), varasto.toString());
    }

    @Test
    public void eiVoiLuodaVarastoaJollaNegatiivinenTilavuus() {
        Varasto v = new Varasto(-5);
        assertEquals(0, v.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void varastostaNegatiivinenOttamninen() {
        varasto.lisaaVarastoon(8);
        varasto.otaVarastosta(-5);
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void alkusaldoKonstruktoriLuoToimivanVaraston() {
        Varasto v = new Varasto(5, 5);
        assertEquals(0, v.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void alkusaldoKonstruktoriNegatiivinenSaldoKielletty() {
        Varasto v = new Varasto(5, -5);
        assertEquals(0, v.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void alkusaldoKonstruktoriSaldoEiYlitäTilavuutta() {
        Varasto v = new Varasto(5, 6);
        double tilaaJaljella = v.getTilavuus()-v.getSaldo();
        assertEquals(0, tilaaJaljella, vertailuTarkkuus);
    }

}