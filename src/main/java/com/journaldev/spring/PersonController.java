package com.journaldev.spring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
 
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@RestController
public class PersonController {
	
	@RequestMapping("/")
	public String welcome() throws Exception {
		readXml2();
		readXmlNameSpace();
		return "Welcome to Spring Boot REST...";
	}
	
	public void readXmlNameSpace() throws Exception{
		//Build DOM 
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true); // never forget this!
        DocumentBuilder builder = factory.newDocumentBuilder();
        ClassLoader classLoader = this.getClass().getClassLoader();
        Document doc = builder.parse(new File(classLoader.getResource("inventory-ns.xml").getFile()));
 
        //Create XPath
 
        XPathFactory xpathfactory = XPathFactory.newInstance();
        XPath xpath = xpathfactory.newXPath();	
        
        System.out.println("NAMESPACE IGNORE .......");
        
        XPathExpression expr1 = xpath.compile("//*[local-name() = 'name']/text()");
        Object result1 = expr1.evaluate(doc, XPathConstants.STRING);
        System.out.println("Name : "+result1);
        
        XPathExpression expr2 = xpath.compile("//*[local-name() = 'age']/text()");
        Object result2 = expr2.evaluate(doc, XPathConstants.STRING);
        System.out.println("Age : "+result2);
        
        XPathExpression expr3 = xpath.compile("//*[local-name() = 'sal']/text()");
        Object result3 = expr3.evaluate(doc, XPathConstants.STRING);
        System.out.println("Sal : "+result3);
        
        XPathExpression expr4 = xpath.compile("//*[local-name() = 'hello']/text()");
        Object result4 = expr4.evaluate(doc, XPathConstants.STRING);
        System.out.println("hello is empty string : "+result4.equals(""));
        
        XPathExpression expr5 = xpath.compile("//*[local-name() = 'addressfull']/text()");
        Object result5 = expr5.evaluate(doc, XPathConstants.STRING);
        System.out.println("addressfull is empty string : "+result5.equals(""));
        
        XPathExpression expr7 = xpath.compile("/*[local-name() = 'inventory']");
        Node rootNode = (Node) expr7.evaluate(doc, XPathConstants.NODE);
        System.out.println("Root Node Name : " + rootNode.getNodeName() + ", Root Node Value : " + rootNode.getNodeValue() + ", Root Node Type : " + rootNode.getNodeType());

        XPathExpression expr8 = xpath.compile("//*[local-name() = 'book'][1]/*[local-name() = 'price']/text()");
        Object result8 = expr8.evaluate(doc, XPathConstants.STRING);
        System.out.println("Book 1 price : " + result8);
        
        XPathExpression expr9 = xpath.compile("//*[local-name() = 'book'][2]/*[local-name() = 'price']/text()");
        Object result9 = expr9.evaluate(doc, XPathConstants.STRING);
        System.out.println("Book 2 price : " + result9);
        
        XPathExpression expr10 = xpath.compile("//*[local-name() = 'book'][3]/*[local-name() = 'price']/text()");
        Object result10 = expr10.evaluate(doc, XPathConstants.STRING);
        System.out.println("Book 3 price : " + result10);
        
        XPathExpression expr11 = xpath.compile("//*[local-name() = 'book'][1]/*[local-name() = 'title']/text()");
        Object result11 = expr11.evaluate(doc, XPathConstants.STRING);
        System.out.println("Book 1 title : " + result11);
        
        XPathExpression expr16 = xpath.compile("//*[local-name() = 'book'][2]/*[local-name() = 'title']/text()");
        Object result16 = expr16.evaluate(doc, XPathConstants.STRING);
        System.out.println("Book 2 title : " + result16);
        
        XPathExpression expr12 = xpath.compile("//*[local-name() = 'book'][5]/*[local-name() = 'title']/text()");
        Object result12 = expr12.evaluate(doc, XPathConstants.STRING);
        System.out.println("Book 5 title is empty string : " + result12.equals(""));
        
        XPathExpression expr13 = xpath.compile("//*[local-name() = 'book'][7]/abc/def/ghi/text()");
        Object result13 = expr13.evaluate(doc, XPathConstants.STRING);
        System.out.println("Book 7 ghi is empty string : " + result13.equals(""));
        
        XPathExpression expr14 = xpath.compile("//*[local-name() = 'book'][2]/*[local-name() = 'details']/*[local-name() = 'pages']/text()");
        Object result14 = expr14.evaluate(doc, XPathConstants.STRING);
        System.out.println("Book 2 No.of pages : " + result14);
        
        XPathExpression expr15 = xpath.compile("//*[local-name() = 'book'][*[local-name() = 'price'] = 7.50]/*[local-name() = 'details']/*[local-name() = 'pages']/text()");
        Object result15 = expr15.evaluate(doc, XPathConstants.STRING);
        System.out.println("Book 3 No.of pages : " + result15);
	}
	
	public void readXml2() throws Exception{
		//Build DOM 
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true); // never forget this!
        DocumentBuilder builder = factory.newDocumentBuilder();
        ClassLoader classLoader = this.getClass().getClassLoader();
        Document doc = builder.parse(new File(classLoader.getResource("inventory.xml").getFile()));
 
        //Create XPath
 
        XPathFactory xpathfactory = XPathFactory.newInstance();
        XPath xpath = xpathfactory.newXPath();
        
        XPathExpression expr1 = xpath.compile("//name/text()");
        Object result1 = expr1.evaluate(doc, XPathConstants.STRING);
        System.out.println("Name : "+result1);
        
        XPathExpression expr2 = xpath.compile("//age/text()");
        Object result2 = expr2.evaluate(doc, XPathConstants.STRING);
        System.out.println("Age : "+result2);
        
        XPathExpression expr3 = xpath.compile("//sal/text()");
        Object result3 = expr3.evaluate(doc, XPathConstants.STRING);
        System.out.println("Sal : "+result3);
        
        XPathExpression expr4 = xpath.compile("//hello/text()");
        Object result4 = expr4.evaluate(doc, XPathConstants.STRING);
        System.out.println("Hello : "+result4.equals(""));
        
        XPathExpression expr5 = xpath.compile("//addressfull/text()");
        Object result5 = expr5.evaluate(doc, XPathConstants.STRING);
        System.out.println("Addressfull : "+result5.equals(""));
                
        XPathExpression expr7 = xpath.compile("/inventory");
        Node rootNode = (Node) expr7.evaluate(doc, XPathConstants.NODE);
        System.out.println("Root Node Name : " + rootNode.getNodeName() + ", Root Node Value : " + rootNode.getNodeValue() + ", Root Node Type : " + rootNode.getNodeType());
        
        XPathExpression expr8 = xpath.compile("//book[1]/price/text()");
        Object result8 = expr8.evaluate(doc, XPathConstants.STRING);
        System.out.println("Book 1 price : " + result8);
        
        XPathExpression expr9 = xpath.compile("//book[2]/price/text()");
        Object result9 = expr9.evaluate(doc, XPathConstants.STRING);
        System.out.println("Book 2 price : " + result9);
        
        XPathExpression expr10 = xpath.compile("//book[3]/price/text()");
        Object result10 = expr10.evaluate(doc, XPathConstants.STRING);
        System.out.println("Book 3 price : " + result10);
        
        XPathExpression expr11 = xpath.compile("//book[1]/title/text()");
        Object result11 = expr11.evaluate(doc, XPathConstants.STRING);
        System.out.println("Book 1 title : " + result11);
        
        XPathExpression expr12 = xpath.compile("//book[5]/title/text()");
        Object result12 = expr12.evaluate(doc, XPathConstants.STRING);
        System.out.println("Book 5 title is empty : " + result12.equals(""));
        
        XPathExpression expr13 = xpath.compile("//book[7]/abc/def/ghi/text()");
        Object result13 = expr13.evaluate(doc, XPathConstants.STRING);
        System.out.println("Book 7 ghi is empty : " + result13.equals(""));
        
        XPathExpression expr14 = xpath.compile("//book[2]/details/pages/text()");
        Object result14 = expr14.evaluate(doc, XPathConstants.STRING);
        System.out.println("Book 2 No.of pages : " + result14);
        
        XPathExpression expr15 = xpath.compile("//book[price = 7.50]/details/pages/text()");
        Object result15 = expr15.evaluate(doc, XPathConstants.STRING);
        System.out.println("Book 3 No.of pages : " + result15);
	}
	
	public void readXml() throws Exception
    {
        //Build DOM 
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true); // never forget this!
        DocumentBuilder builder = factory.newDocumentBuilder();
        ClassLoader classLoader = this.getClass().getClassLoader();
        Document doc = builder.parse(new File(classLoader.getResource("inventory.xml").getFile()));
 
        //Create XPath
 
        XPathFactory xpathfactory = XPathFactory.newInstance();
        XPath xpath = xpathfactory.newXPath();
 
        System.out.println("n//1) Get book titles written after 2001");
 
        // 1) Get book titles written after 2001
        XPathExpression expr = xpath.compile("//book[@year>2001]/title/text()");
        Object result = expr.evaluate(doc, XPathConstants.NODESET);
        NodeList nodes = (NodeList) result;
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(nodes.item(i).getNodeValue());
        }
 
        System.out.println("n//2) Get book titles written before 2001");
 
        // 2) Get book titles written before 2001
        expr = xpath.compile("//book[@year<2001]/title/text()");
        result = expr.evaluate(doc, XPathConstants.NODESET);
        nodes = (NodeList) result;
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(nodes.item(i).getNodeValue());
        }
 
        System.out.println("n//3) Get book titles cheaper than 8 dollars");
 
        // 3) Get book titles cheaper than 8 dollars
        expr = xpath.compile("//book[price<8]/title/text()");
        result = expr.evaluate(doc, XPathConstants.NODESET);
        nodes = (NodeList) result;
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(nodes.item(i).getNodeValue());
        }
 
        System.out.println("n//4) Get book titles costlier than 8 dollars");
 
        // 4) Get book titles costlier than 8 dollars
        expr = xpath.compile("//book[price>8]/title/text()");
        result = expr.evaluate(doc, XPathConstants.NODESET);
        nodes = (NodeList) result;
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(nodes.item(i).getNodeValue());
        }
 
        System.out.println("n//5) Get book titles added in first node");
 
        // 5) Get book titles added in first node
        expr = xpath.compile("//book[1]/title/text()");
        result = expr.evaluate(doc, XPathConstants.NODESET);
        nodes = (NodeList) result;
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(nodes.item(i).getNodeValue());
        }
 
        System.out.println("n//6) Get book title added in last node");
 
        // 6) Get book title added in last node
        expr = xpath.compile("//book[last()]/title/text()");
        result = expr.evaluate(doc, XPathConstants.NODESET);
        nodes = (NodeList) result;
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(nodes.item(i).getNodeValue());
        }
 
        System.out.println("n//7) Get all writers");
 
        // 7) Get all writers
        expr = xpath.compile("//book/author/text()");
        result = expr.evaluate(doc, XPathConstants.NODESET);
        nodes = (NodeList) result;
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(nodes.item(i).getNodeValue());
        }
 
        System.out.println("n//8) Count all books titles ");
 
        // 8) Count all books titles
        expr = xpath.compile("count(//book/title)");
        result = expr.evaluate(doc, XPathConstants.NUMBER);
        Double count = (Double) result;
        System.out.println(count.intValue());
 
        System.out.println("n//9) Get book titles with writer name start with Neal");
 
        // 9) Get book titles with writer name start with Neal
        expr = xpath.compile("//book[starts-with(author,'Neal')]");
        result = expr.evaluate(doc, XPathConstants.NODESET);
        nodes = (NodeList) result;
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(nodes.item(i)
                                .getChildNodes()
                                .item(1)                //node <title> is on first index
                                .getTextContent());
        }
 
        System.out.println("n//10) Get book titles with writer name containing Niven");
 
        // 10) Get book titles with writer name containing Niven
        expr = xpath.compile("//book[contains(author,'Niven')]");
        result = expr.evaluate(doc, XPathConstants.NODESET);
        nodes = (NodeList) result;
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(nodes.item(i)
                                .getChildNodes()
                                .item(1)                //node <title> is on first index
                                .getTextContent());
        }
 
        System.out.println("//11) Get book titles written by Neal Stephenson");
 
        // 11) Get book titles written by Neal Stephenson
        expr = xpath.compile("//book[author='Neal Stephenson']/title/text()");
        result = expr.evaluate(doc, XPathConstants.NODESET);
        nodes = (NodeList) result;
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(nodes.item(i).getNodeValue());
        }
         
        System.out.println("n//12) Get count of book titles written by Neal Stephenson");
 
        // 12) Get count of book titles written by Neal Stephenson
        expr = xpath.compile("count(//book[author='Neal Stephenson'])");
        result = expr.evaluate(doc, XPathConstants.NUMBER);
        count = (Double) result;
        System.out.println(count.intValue());
 
        System.out.println("n//13) Reading comment node ");
 
        // 13) Reading comment node
        expr = xpath.compile("//inventory/comment()");
        result = expr.evaluate(doc, XPathConstants.STRING);
        String comment = (String) result;
        System.out.println(comment);
    }
	
}
