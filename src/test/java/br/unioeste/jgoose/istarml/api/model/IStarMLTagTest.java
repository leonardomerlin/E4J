package br.unioeste.jgoose.istarml.api.model;

import static org.junit.Assert.*;

import br.unioeste.jgoose.istarml.model.tag.DiagramTag;
import br.unioeste.jgoose.istarml.model.tag.IStarMLTag;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import static junit.framework.Assert.assertTrue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IStarMLTagTest {

    private IStarMLTag istarml;
    private Marshaller jaxbMarshaller;
    private Unmarshaller jaxbUnmarshaller;

    @Before
    public void setUp() throws Exception {
        // Common elements

        // iStarML: Root Tag of XML
        this.istarml = new IStarMLTag();

        // For XML annotation
        JAXBContext jaxbContext = JAXBContext.newInstance(
                IStarMLTag.class, DiagramTag.class);
        this.jaxbMarshaller = jaxbContext.createMarshaller();
        this.jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        // output pretty printed
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * <b>VERSION</b> must be equals to "1.0".<br/>
     */
    @Test
    public void version() {
        // Version Control. Read the iStarML Spec.
        assertTrue((IStarMLTag.VERSION.equals("1.0")));
    }

    /**
     * The istarml tag must be at least one diagram tag.
     */
    @Test
    public void mustBeAtLeastOneDiagramTag() {
        Set diagrams = this.istarml.getDiagrams();
        assertNotNull(diagrams);
        assertEquals(1, diagrams.size());
    }

    private void outputXML(Object element) {
        try {
            this.jaxbMarshaller.marshal(element, System.out);
        } catch (JAXBException ex) {
            Logger.getLogger(IStarMLTagTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void outputXMLDefault() {
        this.outputXML(istarml);
    }

    @Test
    public void outputXMLWithOneDiagram() {
        istarml.getDiagrams().clear();
        istarml.getDiagrams().add(new DiagramTag());
        this.outputXML(istarml);
    }

    @Test
    public void outputXMLWithMultiDiagrams() {
        istarml.getDiagrams().clear();
        istarml.getDiagrams().add(new DiagramTag());
        istarml.getDiagrams().add(new DiagramTag("id1", null));
        istarml.getDiagrams().add(new DiagramTag(null, "name2"));
        istarml.getDiagrams().add(new DiagramTag("id3", "name3"));
        this.outputXML(istarml);
    }
//    @Ignore("Not implemented yet")
//    @Test(expected = NullPointerException.class)
//    public void exceptionExpected() {
//    }
}
