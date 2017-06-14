package com.lukew.WeatherApp;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/*
Program Title: WeatherReader
Author: Luke Williams
Created: 10-Mar-2016
Version: 1.0
*/

public class WeatherReader 
{
    
    private String urlName;
    private String weatherType;
    private String locationID;
    private String searchTerm;
    private boolean searchTermFound;
    private String[] weatherDescriptions;
    
    private File xmlSearchesFile;
    private boolean firstSearch;  

    public WeatherReader()
    {           
    }
    
    /**
     * sets the URL name to get the weather data for
     * @param urlName - the locations URL
     */
    public void setURLname(String urlName)
    {
        this.urlName = urlName;
    }
    
    /**
     * gets the current description of the weather
     * @return - collection of weather information
     */
    public String[] getWeatherDescription()
    {
        return weatherDescriptions;
    }
    
    
    /**
     * sets the location where the weather is requested for
     * @param searchTerm - the area to get weather for
     */
    public void setLocation(String searchTerm)
    {
        this.searchTerm = searchTerm;
        
        String weatherXMLURL = "http://api.geonames.org/search?q=" + searchTerm + "&maxRows=1&lang=en&username=eeu43f";
        
        try
        {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(weatherXMLURL);

            XPathFactory xpfactory = XPathFactory.newInstance();
            XPath path = xpfactory.newXPath();

            locationID = path.evaluate("/geonames/geoname/geonameId", doc);            
            
            urlName = "http://open.live.bbc.co.uk/weather/feeds/en/" + locationID + "/3dayforecast.rss";
        }
        
        catch(ParserConfigurationException | SAXException | IOException | XPathExpressionException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * retrieve the forecast details, and stores it in weatherDescriptions variable
     */
    public void setForecastDetails(int day)
    {        
        try 
        {                        
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();                               
            Document doc = builder.parse(new URL(urlName).openStream());                       
            
            String weatherInfo = doc.getElementsByTagName("title").item(day+1).getTextContent();
            String[] temp_descriptions = doc.getElementsByTagName("description").item(day).getTextContent().split(", ");
            
            temp_descriptions[4] = temp_descriptions[4] + ", " + temp_descriptions[5];
            temp_descriptions[5] = temp_descriptions[6];
            
            weatherDescriptions = new String[7];
            weatherDescriptions[0] = weatherInfo.substring(0, weatherInfo.indexOf(", "));
            
            for(int i = 1; i < weatherDescriptions.length; i++)
            {
                weatherDescriptions[i] = temp_descriptions[i - 1];
            }
 
            String s = weatherInfo.substring(weatherInfo.indexOf(":") + 1, weatherInfo.indexOf(",")); 
            weatherType = s.substring(s.indexOf(":") + 2);  

            searchTermFound = true;                             
        }
        
        //IOException will occur if location isn't found
        catch(IOException ie)
        {
            JOptionPane.showMessageDialog(new JFrame(), "ERROR : LOCATION NOT FOUND");
            System.out.println(ie.getMessage());
            searchTermFound = false;
            weatherDescriptions = new String[0];
            weatherType = "NOT FOUND";            
        }
        
        
        catch (ParserConfigurationException | SAXException ex) 
        {            
            System.out.println(ex.getMessage());
            searchTermFound = false;            
            weatherType = "ERROR";
        } 
    }
    
    /*
        WHERE TO FIND IMAGES
        http://www.metoffice.gov.uk/guide/weather/symbols        
    */
    
    /**
     * returns an image of the current weather of location
     * @return - the symbol of the weather
     */
    public ImageIcon getWeatherImage()
    {                
        String imageURI = "src/main/resources/images/weather icons/";
        String imageName;
        ImageIcon image;
        
        switch(weatherType)
        {
            case "Light Cloud"       : imageName = "lightcloud.png";     break;
            case "Thick Cloud"       : imageName = "thickcloud.png";     break;                  
            case "Heavy Rain Shower" :       
            case "Heavy Rain"        : imageName = "heavyrain.png";      break;                
            case "Sunny"             : imageName = "sunny.png";          break;
            case "Cloudy"            : imageName = "cloudy.png";         break;                
            case "Light Rain"        : 
            case "Light Rain Shower" : imageName = "lightrain.png";      break;                
            case "Sunny Intervals"   : imageName = "sunnyintervals.png"; break;
            case "Partly Cloudy"     : imageName = "partlycloudy.png";   break;
            case "Light Snow"        : imageName = "lightsnow.png";      break;
            case "Heavy Snow"        : imageName = "heavysnow.png";      break;
            case "Sleet"             : imageName = "sleet.png";          break;
            case "Thunder"           : imageName = "thunder.png";        break;
            case "Hail"              : imageName = "hail.png";           break;
            case "Clear Sky"         : imageName = "clearnight.png";     break;
            case "Fog"               : imageName = "fog.png";            break;
            case "Mist"              : imageName = "mist.png";           break;
            case "Drizzle"           : imageName = "drizzle.png";        break;
                
            default                  : imageName = "nodata.png";         break;
        }
        
        image = new ImageIcon(imageURI + imageName);
        
        return image;
    }            
}

