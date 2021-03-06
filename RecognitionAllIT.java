/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sf.javaanpr.test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import javax.xml.parsers.ParserConfigurationException;
import net.sf.javaanpr.imageanalysis.CarSnapshot;
import net.sf.javaanpr.intelligence.Intelligence;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.xml.sax.SAXException;

/**
 *
 * @author
 */
@RunWith(Parameterized.class)
public class RecognitionAllIT {
   
    public String snapshot;
    public String expectedPlate;
    
    public RecognitionAllIT(String ss, String ep){
        this.snapshot = ss;
        this.expectedPlate = ep;
    }
    
    
    
    @Parameters(name = "{index}: testEquals({0} == {1})")
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
            {"test_001.jpg", "PP587AO"},
            {"test_002.jpg", "RK755AJ"},
            {"test_003.jpg", "SI819AK"},
            {"test_004.jpg", "RK115AN"},
            {"test_005.jpg", "TS260AK"},
            {"test_006.jpg", "RK099AN"},
            {"test_007.jpg", "RK828AG"},
            {"test_008.jpg", "LM298AI"},
            {"test_009.jpg", "1T43213"},
            {"test_010.jpg", "RK248AH"},
            {"test_011.jpg", "RK346AL"},
            {"test_012.jpg", "RK291AT"},
            {"test_013.jpg", "RK857AI"},
            {"test_014.jpg", "RK576AH"},
            {"test_015.jpg", "RK019AF"},
            {"test_016.jpg", "BB751BH"},
            {"test_017.jpg", "RK876AD"},
            {"test_018.jpg", "RK884AL"},
            {"test_019.jpg", "RK865AC"},
            {"test_020.jpg", "RK906AJ"},
            {"test_021.jpg", "RK855AP"},
            {"test_022.jpg", "RK875AE"},
            {"test_023.jpg", "RK612AL"},
            {"test_024.jpg", "RK026AJ"},
            {"test_025.jpg", "RK896AO"},
            {"test_026.jpg", "RK492AU"},
            {"test_027.jpg", "RK776AI"},
            {"test_028.jpg", "LM633BD"},
            {"test_029.jpg", "LM010BE"},
            {"test_030.jpg", "RK819AM"},
            {"test_031.jpg", "RK619AS"},
            {"test_032.jpg", "RK763AS"},
            {"test_033.jpg", "RK082AL"},
            {"test_034.jpg", "SG47471"},
            {"test_035.jpg", "BA738DE"},
            {"test_036.jpg", "RK708AI"},
            {"test_037.jpg", "RK260AR"},
            {"test_038.jpg", "RK340A0"},
            {"test_039.jpg", "RK892AE"},
            {"test_040.jpg", "RK101AO"},
            {"test_041.jpg", "LM025BD"},
            {"test_042.jpg", "BA28IM"},
            {"test_043.jpg", "DK41AH"},
            {"test_044.jpg", "RK878AC"},
            {"test_045.jpg", "RK878AC"},
            {"test_046.jpg", "RK143AT"},
            {"test_047.jpg", "RK161AG"},
            {"test_048.jpg", "RK161AG"},
            {"test_049.jpg", "KMBORAK"},
            {"test_050.jpg", "BB135BO"},
            {"test_051.jpg", "RK605AB"},
            {"test_052.jpg", "BY649AG"},
            {"test_053.jpg", "RK715AA"},
            {"test_054.jpg", "RK22AH"},
            {"test_055.jpg", "NO450AM"},
            {"test_056.jpg", "RK300AG"},
            {"test_057.jpg", "RK300AS"},
            {"test_058.jpg", "RK485AF"},
            {"test_059.jpg", "BA302OZ"},
            {"test_060.jpg", "BA302OZ"},
            {"test_061.jpg", "MT456BJ"},
            {"test_062.jpg", "1B80338"},
            {"test_063.jpg", "1B25790"},
            {"test_064.jpg", "BZM2227"},
            {"test_065.jpg", "4B04979"},
            {"test_066.jpg", "BSE5579"},
            {"test_067.jpg", "1B70440"},
            {"test_068.jpg", "1B19839"},
            {"test_069.jpg", "4B40262"},
            {"test_070.jpg", "2T40211"},
            {"test_071.jpg", "1Z75233"},
            {"test_072.jpg", "4B39376"},
            {"test_073.jpg", "3B97236"},
            {"test_074.jpg", "3B29485"},
            {"test_075.jpg", "ZA834CO"},
            {"test_076.jpg", "4B21875"},
            {"test_077.jpg", "RK735AS"},
            {"test_078.jpg", "RK457AS"},
            {"test_079.jpg", "RK959AF"},
            {"test_080.jpg", "RK003AB"},
            {"test_081.jpg", "RK641AL"},
            {"test_082.jpg", "RK891AU"},
            {"test_083.jpg", "PD935BG"},
            {"test_084.jpg", "PD722BF"},
            {"test_085.jpg", "RK959AD"},
            {"test_086.jpg", "RK376AF"},
            {"test_087.jpg", "RK011AM"},
            {"test_088.jpg", "LM169AM"},
            {"test_089.jpg", "RK565AV"},
            {"test_090.jpg", "RK550AO"},
            {"test_091.jpg", "RK977AF"},
            {"test_092.jpg", "RK373AK"},
            {"test_093.jpg", "RK301AH"},
            {"test_094.jpg", "RK069AV"},
            {"test_095.jpg", "NO626AT"},
            {"test_096.jpg", "RK735AS"},
            {"test_097.jpg", "RK603AV"}
        });
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void RecognitionAllIT() throws Exception {
        final String image = snapshot;
        CarSnapshot carSnap = new CarSnapshot("snapshots/" + image);
        assertNotNull("carSnap is null", carSnap);
        assertNotNull("carSnap.image is null", carSnap.getImage());
        Intelligence intel = new Intelligence();
        assertNotNull(intel);
        String spz = intel.recognize(carSnap);
        assertNotNull("The licence plate is null - are you sure the image has the correct color space?", spz);
        assertEquals(expectedPlate, spz);
        carSnap.close();
    }
    
    @Test
    public void RecognitionAllITHamcrest() throws Exception {
        final String image = snapshot;
        CarSnapshot carSnap = new CarSnapshot("snapshots/" + image);
        assertThat(carSnap, is(notNullValue()));
        assertThat(carSnap.getImage(), is(notNullValue()));
        Intelligence intel = new Intelligence();
        assertThat(intel, is(notNullValue()));
        String spz = intel.recognize(carSnap);
        assertThat(spz, is(notNullValue()));
        assertThat(expectedPlate, is(equalTo(spz)));
        carSnap.close();
    }
}
