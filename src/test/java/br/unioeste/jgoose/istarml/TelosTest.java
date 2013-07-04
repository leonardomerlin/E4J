package br.unioeste.jgoose.istarml;

import br.unioeste.jgoose.istarml.parser.telos.TelosFilenameFilter;
import br.unioeste.jgoose.model.TokensOpenOME;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * Unit Test for TokensOpenOME.
 * @author Leonardo Merlin - leonardo.merlin at unioeste.br
 */
@RunWith(Parameterized.class)
public class TelosTest {

    private static Logger LOG = Logger.getLogger("console");
    //
    private static final String EXPECTED_ELEMENTS = "elements";
    private static final String EXPECTED_ACTORS = "actors";
    private static final String EXPECTED_AGENTS = "agents";
    private static final String EXPECTED_ROLES = "roles";
    private static final String EXPECTED_POSITIONS = "positions";
    private static final String EXPECTED_LINKS = "links";
    //
    private static final String EXPECTED_COVERS = "covers";
    private static final String EXPECTED_PLAYS = "plays";
    private static final String EXPECTED_INS = "ins";
    private static final String EXPECTED_ISA = "isa";
    private static final String EXPECTED_ISPARTOF = "ispartof";
    private static final String EXPECTED_OCCUPIES = "occupies";
    //
    private static final String EXPECTED_CONTRIBUTIONS = "contributions";
    //
    private TokensOpenOME ome;
    //
    private File telos;
    private Properties expectedValues;

    public TelosTest(File inputTelosFile, Properties expectedValues) {
        this.telos = inputTelosFile;
        this.expectedValues = expectedValues;
        this.ome = new TokensOpenOME();

        LOG.debug("testing file: " + this.telos);
    }

    @Parameterized.Parameters
    public static Collection params() throws ParserConfigurationException, TransformerConfigurationException, TransformerException {
        File telosFolder = new File("src/test/resources/telos");
        File[] inputTelosFiles = telosFolder.listFiles(new TelosFilenameFilter());
        LOG.debug("total files:" + inputTelosFiles.length);

        Properties defaults = new Properties();
        defaults.put(EXPECTED_ELEMENTS, 0);
        defaults.put(EXPECTED_LINKS, 0);
        //
        defaults.put(EXPECTED_ACTORS, 0);
        defaults.put(EXPECTED_AGENTS, 0);
        defaults.put(EXPECTED_ROLES, 0);
        defaults.put(EXPECTED_POSITIONS, 0);
        //

        Properties prop;
        List<Object[]> result = new ArrayList<>();

        prop = (Properties) defaults.clone();
        result.add(new Object[]{new File("src/test/resources/telos/test-empty.tel"), prop});

        prop = (Properties) defaults.clone();
        prop.put(EXPECTED_ACTORS, 1);
        result.add(new Object[]{new File("src/test/resources/telos/test-actor-A.tel"), prop});

        prop = (Properties) defaults.clone();
        prop.put(EXPECTED_AGENTS, 1);
        result.add(new Object[]{new File("src/test/resources/telos/test-actor-B.tel"), prop});

        prop = (Properties) defaults.clone();
        prop.put(EXPECTED_ROLES, 1);
        result.add(new Object[]{new File("src/test/resources/telos/test-actor-C.tel"), prop});

        prop = (Properties) defaults.clone();
        prop.put(EXPECTED_POSITIONS, 1);
        result.add(new Object[]{new File("src/test/resources/telos/test-actor-D.tel"), prop});

        return result;
    }

    /**
     * Load files and map to the ome/jgoose structure
     */
    @Before
    public void setUp() {
        String outputFilename = this.telos.getName() + ".out";

        // open files and set the Streamers
        this.ome.abrirArquivo(this.telos, new File(outputFilename));

        // read the telos file and construct the jgoose structure
        this.ome.procuraArquivo();
    }

    @Ignore("Not implemented yet")
    @Test
    public void countAllElements() {
        int total = 0;
        total += this.ome.getActors().size();
        total += this.ome.getAgents().size();
        total += this.ome.getContributions().size();
        total += this.ome.getContribution().size();
        Assert.assertEquals(this.expectedValues.get(EXPECTED_ACTORS), total);
    }
    
    @Test
    public void countActors() {
        int total = this.ome.getActors().size();
        Assert.assertEquals(this.expectedValues.get(EXPECTED_ACTORS), total);
    }
    
    @Test
    public void countAgents() {
        int total = this.ome.getAgents().size();
        Assert.assertEquals(this.expectedValues.get(EXPECTED_AGENTS), total);
    }
    
    @Test
    public void countRoles() {
        int total = this.ome.getRoles().size();
        Assert.assertEquals(this.expectedValues.get(EXPECTED_ROLES), total);
    }
    
    @Test
    public void countPosition() {
        int total = this.ome.getPositions().size();
        Assert.assertEquals(this.expectedValues.get(EXPECTED_POSITIONS), total);
    }
    
    @Test
    public void countContributions() {
        int total = this.ome.getContributions().size();
        Assert.assertEquals(this.expectedValues.get(EXPECTED_CONTRIBUTIONS), total);
    }
    
    @Test
    public void countCovers() {
        int total = this.ome.getCovers().size();
        Assert.assertEquals(this.expectedValues.get(EXPECTED_COVERS), total);
    }
}