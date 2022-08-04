/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.chess.ui;

import java.util.Timer;
import java.util.TimerTask;
import org.apache.batik.anim.dom.SVGDOMImplementation;
import org.w3c.dom.*;

/**
 *
 * @author Pedro
 */
public class Message {

    private String msg;
    private int time;
    
    private boolean running;
    private Document doc;
    private Element e;
    private Timer timer;
    private TimerTask task;
    private int x,y;

    public Message() {
        this.running=false;
    }

    public Message(String msg, int time, Document doc) {
        this.msg = msg;
        this.doc = doc;
        this.time = time;
        this.x=20;
        this.y=140;

        this.timer = new Timer();
        this.running = false;

    }

    public void stop() {
        this.running = false;
    }

    public void startTurno() {
        
        this.createElemento();
        this.running = true;
        this.task = new TimerTask() {
            @Override
            public void run() {
                running = false;
                Element l = doc.getElementById("msg");
                //System.out.println(l.getAttributeNS(null, "id"));
                doc.getDocumentElement().removeChild(l);
            }
        };
        this.timer.schedule(this.task, this.getTime());
    }
    public void start() {
        
        this.createElement();
        this.running = true;
        this.task = new TimerTask() {
            @Override
            public void run() {
                running = false;
                Element l = doc.getElementById("msg");
                //System.out.println(l.getAttributeNS(null, "id"));
                doc.getDocumentElement().removeChild(l);
            }
        };
        this.timer.schedule(this.task, this.getTime());
    }

    private void createElemento() {
       
        this.e = doc.createElementNS(SVGDOMImplementation.SVG_NAMESPACE_URI, "text");
        
        this.e.setAttributeNS(null, "x", "20");
        this.e.setAttributeNS(null, "y", "140");
        this.e.setAttributeNS(null, "fill", "blue");
        this.e.setAttributeNS(null, "font-family", "Verdana");
        this.e.setAttributeNS(null, "font-size", "35");
        this.e.setAttributeNS(null, "id", "msg");//this.msg);

        this.e.setAttributeNS(null, "stroke", "blue");
        this.e.setAttributeNS(null, "stroke-width", "3");
        this.e.setTextContent(this.getMsg());
        this.doc.getDocumentElement().appendChild(this.e);

    }
    private void createElement() {
       
        this.e = doc.createElementNS(SVGDOMImplementation.SVG_NAMESPACE_URI, "text");
        
        this.e.setAttributeNS(null, "x", "150");
        this.e.setAttributeNS(null, "y", "240");
        this.e.setAttributeNS(null, "fill", "red");
        this.e.setAttributeNS(null, "font-family", "Verdana");
        this.e.setAttributeNS(null, "font-size", "50");
        this.e.setAttributeNS(null, "id", "msg");//this.msg);

        this.e.setAttributeNS(null, "stroke", "blue");
        this.e.setAttributeNS(null, "stroke-width", "3");
        this.e.setTextContent(this.getMsg());
        this.doc.getDocumentElement().appendChild(this.e);

    }

    public boolean isRun() {
        return this.running;

    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @return the time
     */
    public int getTime() {
        return time;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @param time the time to set
     */
    public void setTime(int time) {
        this.time = time;
    }

}
