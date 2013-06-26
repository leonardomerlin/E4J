package br.unioeste.leonardomerlin.tcc.istarml.tag;

import br.unioeste.leonardomerlin.tcc.istarml.ActorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import static junit.framework.Assert.assertTrue;
import junit.framework.TestCase;

public class IStarMLRootTest extends TestCase {

    private IStarMLRoot istarml;
    private Marshaller jaxbMarshaller;
    private Unmarshaller jaxbUnmarshaller;

    public IStarMLRootTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        // Common elements

        // iStarML: Root Tag of XML
        this.istarml = new IStarMLRoot();

        // For XML annotation
        JAXBContext jaxbContext = JAXBContext.newInstance(
                IStarMLRoot.class, DiagramTag.class, ActorImpl.class);
        this.jaxbMarshaller = jaxbContext.createMarshaller();
        this.jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        // output pretty printed
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * <b>version</b> must be equals to "1.0".<br/>
     */
    public void testÖVersion() {
        // Version Control. Read the iStarML Spec.
        assertTrue((this.istarml.version.equals("1.0")));
    }

    /**
     * Test <b>set, get and size</b> of diagram list.<br/>
     */
    public void testSizeGetSetDiagrams() {
        List diagrams = this.istarml.getDiagrams();
        assertNotNull(diagrams);
        assertEquals(1, diagrams.size());

        List<DiagramTag> newDiagrams = new ArrayList<>();
        this.istarml.setDiagrams(newDiagrams);
        assertEquals(newDiagrams, this.istarml.getDiagrams());
    }

//    public void testOutputDefaultXML(){
//        try {
//            this.jaxbMarshaller.marshal(istarml, System.out);
//        } catch (JAXBException ex) {
//            Logger.getLogger(IStarMLRootTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
    public void testOutputWithActorsXML() {
        Actor actor = ActorFactory.createActor();
        DiagramTag diagram = istarml.getDiagrams().get(0);
//        diagram.addActor(actor);
        try {
            this.jaxbMarshaller.marshal(istarml, System.out);
        } catch (JAXBException ex) {
            Logger.getLogger(IStarMLRootTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void exceptionExpected() {
    }
}
