package br.unioeste.leonardomerlin.tcc.istarml.tag;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.SAXParseException;

/**
 *
 * @author Leonardo Merlin - leonardo.merlin at unioeste.br
 */
@RunWith(Parameterized.class)
public class IStarMLTest {

    private Marshaller jaxbMarshaller;
    private Unmarshaller jaxbUnmarshaller;
    
    private StringReader xml;
    private Boolean expectedValidation;
    
    @Rule
    public ExpectedException thrown= ExpectedException.none();

    public IStarMLTest(String xml, Boolean expectedValidation) {
        this.xml = new StringReader(xml);
        this.expectedValidation = expectedValidation;
    }
    
    @Parameterized.Parameters
    public static Collection params() throws ParserConfigurationException, TransformerConfigurationException, TransformerException {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.newDocument();
        doc.setXmlStandalone(true);
        
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        
        StringWriter buffer = new StringWriter();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        
        Element istarmlTag = doc.createElement("istarml");
        Element diagramTag = doc.createElement("diagram");
        istarmlTag.appendChild(diagramTag);
        doc.appendChild(istarmlTag);
        
        DOMSource dom = new DOMSource(doc);
        transformer.transform(dom, new StreamResult(buffer));
        String str = buffer.toString();
        System.out.println("element:" + str);
        
        List<Object> parameters = new ArrayList<>();
        
//        System.out.println("element output" + element.toString());
        return Arrays.asList(new Object[][] {
                { "<istarml version=\"1.0\"/>", false }, // invalid
//                { "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><istarml version=\"1.0\"/>", true }, // invalid
//                { "<istarml version=\"1.0\"><istarml>", false }, // invalid
//                { "<istarml version=\"1.0\"></istarml>", false }, // invalid
//                { "<istarml version=\"1.0\"><diagram/></istarml>", false }, // invalid
//                { "<istarml version=\"1.0\"><diagram></diagram></istarml>", false }, // invalid
//                { "<istarml version=\"1.0\"><diagram id=\"asdf\"></diagram></istarml>", true }, // invalid
//                { "", false }
//                { "", true },
//                { "", false }
        });
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws JAXBException {
        // For XML annotation
        JAXBContext jaxbContext = JAXBContext.newInstance(IStarMLRoot.class, DiagramTag.class, ActorImpl.class);
        this.jaxbMarshaller = jaxbContext.createMarshaller();
        this.jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        // output pretty printed
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        
        
    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void testUnmarshall(){
        if (!this.expectedValidation) {
            thrown.expect(SAXParseException.class);
        }
        IStarMLRoot istarml = JAXB.unmarshal(this.xml, IStarMLRoot.class);            
    }
    
//    http://www.vogella.com/articles/JUnit/article.html#usingjunit_annotations

//    @Ignore("Not implemented yet")
//    @Test
//    public void importCorrectFile() {
//        
//    }
//    
//    @Ignore("Not implemented yet")
//    @Test(timeout = 500)
//    public void checkPerformance() {
////        Fails, if the method takes longer than 500 milliseconds.
//    }
//    
//    @Ignore("Not implemented yet")
//    @Test(expected = NullPointerException.class)
//    public void importIncorrectFile(){
////        Fails, if the method does not throw the named exception.
//        throw new NullPointerException("todo");
//    }
}