/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sendsms;
import java.util.Vector;
import javax.microedition.lcdui.*;
import javax.microedition.lcdui.Display;
import javax.microedition.midlet.*;
import javax.microedition.rms.RecordStore;
import org.netbeans.microedition.lcdui.SimpleTableModel;
import sendsms.pk.SendSMSdotpk;

/**
 * @author Saim Shuja
 */
public class SendSMS extends MIDlet implements CommandListener, ItemCommandListener {
    
    private boolean midletPaused = false;
    private RecordStore rs = null;
    static final String REC_STORE = "sendsms";
    private SendSMSdotpk smsapi;
    private String apikey;
    

//<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Command exitCommand;
    private Command okCommand;
    private Command cancelCommand;
    private Command okCommand1;
    private Command itemCommand;
    private Command cancelCommand1;
    private Command okCommand2;
    private Command itemCommand1;
    private Command okCommand3;
    private Command itemCommand2;
    private Command okCommand4;
    private Command itemCommand3;
    private Command itemCommand4;
    private Command exitCommand1;
    private Form form;
    private Spacer spacer;
    private TextField textField;
    private TextField textField1;
    private Form form1;
    private StringItem stringItem2;
    private StringItem stringItem1;
    private StringItem stringItem4;
    private StringItem stringItem3;
    private Form form2;
    private TextField textField2;
    private TextField textField3;
    private Form form3;
    private TextField textField4;
    private Form form4;
    private TextField textField5;
    private Image image1;
    private SimpleTableModel tableModel1;
//</editor-fold>//GEN-END:|fields|0|
    private int j;

    /**
     * The HelloMIDlet constructor.
     */
    public SendSMS() {
        this.smsapi = new SendSMSdotpk();
    }

//<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
//</editor-fold>//GEN-END:|methods|0|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
    /**
     * Initializes the application. It is called only once when the MIDlet is
     * started. The method is called before the <code>startMIDlet</code> method.
     */
    private void initialize() {
//GEN-END:|0-initialize|0|0-preInitialize
        // write pre-initialize user code here
//GEN-LINE:|0-initialize|1|0-postInitialize
        // write post-initialize user code here
}//GEN-BEGIN:|0-initialize|2|
//</editor-fold>//GEN-END:|0-initialize|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {
//GEN-END:|3-startMIDlet|0|3-preAction
    try{
      rs = RecordStore.openRecordStore(REC_STORE, true );
    }catch (Exception e){}
    
        switchDisplayable(null, getForm1());//GEN-LINE:|3-startMIDlet|1|3-postAction
        // write post-action user code here
}//GEN-BEGIN:|3-startMIDlet|2|
//</editor-fold>//GEN-END:|3-startMIDlet|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {
//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
//GEN-LINE:|4-resumeMIDlet|1|4-postAction
        // write post-action user code here
}//GEN-BEGIN:|4-resumeMIDlet|2|
//</editor-fold>//GEN-END:|4-resumeMIDlet|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
    /**
     * Switches a current displayable in a display. The <code>display</code>
     * instance is taken from <code>getDisplay</code> method. This method is
     * used by all actions in the design for switching displayable.
     *
     * @param alert the Alert which is temporarily set to the display; if
     * <code>null</code>, then <code>nextDisplayable</code> is set immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {
//GEN-END:|5-switchDisplayable|0|5-preSwitch
        // write pre-switch user code here
Display display = getDisplay();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
        if (alert == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alert, nextDisplayable);
        }//GEN-END:|5-switchDisplayable|1|5-postSwitch
        // write post-switch user code here
}//GEN-BEGIN:|5-switchDisplayable|2|
//</editor-fold>//GEN-END:|5-switchDisplayable|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Displayables ">//GEN-BEGIN:|7-commandAction|0|7-preCommandAction
    /**
     * Called by a system to indicated that a command has been invoked on a
     * particular displayable.
     *
     * @param command the Command that was invoked
     * @param displayable the Displayable where the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {
//GEN-END:|7-commandAction|0|7-preCommandAction
        // write pre-action user code here
if (displayable == form) {//GEN-BEGIN:|7-commandAction|1|38-preAction
            if (command == cancelCommand) {//GEN-END:|7-commandAction|1|38-preAction
 // write pre-action user code here
switchDisplayable(null, getForm1());//GEN-LINE:|7-commandAction|2|38-postAction
 // write post-action user code here
} else if (command == okCommand) {//GEN-LINE:|7-commandAction|3|27-preAction
// if(textField.getString()=="")
// {
//    alert.setImage(getImage1());
//    alert.setString("You missied entering your username");
//    switchDisplayable(null, getAlert());
// }
// 
// if(textField1.getString()=="")
// {
//     
//    alert.setImage(getImage1());
//    alert.setString("You missied entering your paswsword");
//    switchDisplayable(null, getAlert());
// }
 if (smsapi.authenticate(textField.getString() , textField1.getString())) {
    
        this.addMessage("Logged in");
        this.apikey=this.smsapi.getAPIKey();
    } else {
        this.addMessage("Failed, try again");
    }
 
                switchDisplayable(null, getForm1());//GEN-LINE:|7-commandAction|4|27-postAction
//splashScreen.setImage(null);
//    splashScreen.setText("");
}//GEN-BEGIN:|7-commandAction|5|90-preAction
} else if (displayable == form1) {
    if (command == exitCommand1) {//GEN-END:|7-commandAction|5|90-preAction
        // write pre-action user code here
exitMIDlet();//GEN-LINE:|7-commandAction|6|90-postAction
 // write post-action user code here
}//GEN-BEGIN:|7-commandAction|7|51-preAction
} else if (displayable == form2) {
    if (command == cancelCommand1) {//GEN-END:|7-commandAction|7|51-preAction
 // write pre-action user code here
switchDisplayable(null, getForm1());//GEN-LINE:|7-commandAction|8|51-postAction
 // write post-action user code here
} else if (command == okCommand2) {//GEN-LINE:|7-commandAction|9|49-preAction
smsapi.sendSMS(textField2.getString(), textField3.getString());
        switchDisplayable(null, getForm1());//GEN-LINE:|7-commandAction|10|49-postAction
 stringItem1.setText("Message sent");
    }//GEN-BEGIN:|7-commandAction|11|70-preAction
} else if (displayable == form3) {
    if (command == okCommand3) {//GEN-END:|7-commandAction|11|70-preAction
 // write pre-action user code here
switchDisplayable(null, getForm1());//GEN-LINE:|7-commandAction|12|70-postAction
 // write post-action user code here
}//GEN-BEGIN:|7-commandAction|13|87-preAction
} else if (displayable == form4) {
    if (command == okCommand4) {//GEN-END:|7-commandAction|13|87-preAction
 // write pre-action user code here
switchDisplayable(null, getForm1());//GEN-LINE:|7-commandAction|14|87-postAction
 // write post-action user code here
}//GEN-BEGIN:|7-commandAction|15|7-postCommandAction
        }//GEN-END:|7-commandAction|15|7-postCommandAction
        // write post-action user code here
}//GEN-BEGIN:|7-commandAction|16|
//</editor-fold>//GEN-END:|7-commandAction|16|


//<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand ">//GEN-BEGIN:|18-getter|0|18-preInit
    /**
     * Returns an initialized instance of exitCommand component.
     *
     * @return the initialized component instance
     */
    public Command getExitCommand() {
        if (exitCommand == null) {
//GEN-END:|18-getter|0|18-preInit
            // write pre-init user code here
exitCommand = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|18-getter|1|18-postInit
            // write post-init user code here
}//GEN-BEGIN:|18-getter|2|
        return exitCommand;
    }
//</editor-fold>//GEN-END:|18-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: form ">//GEN-BEGIN:|14-getter|0|14-preInit
    /**
     * Returns an initialized instance of form component.
     *
     * @return the initialized component instance
     */
    public Form getForm() {
        if (form == null) {
//GEN-END:|14-getter|0|14-preInit
            // write pre-init user code here
form = new Form("Send SMS", new Item[]{getTextField(), getSpacer(), getTextField1()});//GEN-BEGIN:|14-getter|1|14-postInit
            form.addCommand(getOkCommand());
            form.addCommand(getCancelCommand());
            form.setCommandListener(this);//GEN-END:|14-getter|1|14-postInit
            // write post-init user code here
}//GEN-BEGIN:|14-getter|2|
        return form;
    }
//</editor-fold>//GEN-END:|14-getter|2|



//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand ">//GEN-BEGIN:|26-getter|0|26-preInit
    /**
     * Returns an initialized instance of okCommand component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand() {
        if (okCommand == null) {
//GEN-END:|26-getter|0|26-preInit
 // write pre-init user code here
okCommand = new Command("Ok", Command.OK, 0);//GEN-LINE:|26-getter|1|26-postInit
 // write post-init user code here
}//GEN-BEGIN:|26-getter|2|
        return okCommand;
    }
//</editor-fold>//GEN-END:|26-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField ">//GEN-BEGIN:|22-getter|0|22-preInit
    /**
     * Returns an initialized instance of textField component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField() {
        if (textField == null) {
//GEN-END:|22-getter|0|22-preInit
 // write pre-init user code here
textField = new TextField("Username:", "", 32, TextField.ANY);//GEN-LINE:|22-getter|1|22-postInit
 // write post-init user code here
}//GEN-BEGIN:|22-getter|2|
        return textField;
    }
//</editor-fold>//GEN-END:|22-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: spacer ">//GEN-BEGIN:|23-getter|0|23-preInit
    /**
     * Returns an initialized instance of spacer component.
     *
     * @return the initialized component instance
     */
    public Spacer getSpacer() {
        if (spacer == null) {
//GEN-END:|23-getter|0|23-preInit
 // write pre-init user code here
spacer = new Spacer(16, 1);//GEN-LINE:|23-getter|1|23-postInit
 // write post-init user code here
}//GEN-BEGIN:|23-getter|2|
        return spacer;
    }
//</editor-fold>//GEN-END:|23-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField1 ">//GEN-BEGIN:|25-getter|0|25-preInit
    /**
     * Returns an initialized instance of textField1 component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField1() {
        if (textField1 == null) {
//GEN-END:|25-getter|0|25-preInit
 // write pre-init user code here
textField1 = new TextField("Password:", "", 32, TextField.ANY | TextField.PASSWORD);//GEN-LINE:|25-getter|1|25-postInit
 // write post-init user code here
}//GEN-BEGIN:|25-getter|2|
        return textField1;
    }
//</editor-fold>//GEN-END:|25-getter|2|



//<editor-fold defaultstate="collapsed" desc=" Generated Getter: image1 ">//GEN-BEGIN:|33-getter|0|33-preInit
    /**
     * Returns an initialized instance of image1 component.
     *
     * @return the initialized component instance
     */
    public Image getImage1() {
        if (image1 == null) {
//GEN-END:|33-getter|0|33-preInit
 // write pre-init user code here
try {//GEN-BEGIN:|33-getter|1|33-@java.io.IOException
                image1 = Image.createImage("/The-red-exclamation-mark-icon-1004191058.png");
            } catch (java.io.IOException e) {//GEN-END:|33-getter|1|33-@java.io.IOException
            }//GEN-LINE:|33-getter|2|33-postInit
 // write post-init user code here
}//GEN-BEGIN:|33-getter|3|
        return image1;
    }
//</editor-fold>//GEN-END:|33-getter|3|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Items ">//GEN-BEGIN:|17-itemCommandAction|0|17-preItemCommandAction
    /**
     * Called by a system to indicated that a command has been invoked on a
     * particular item.
     *
     * @param command the Command that was invoked
     * @param displayable the Item where the command was invoked
     */
    public void commandAction(Command command, Item item) {
//GEN-END:|17-itemCommandAction|0|17-preItemCommandAction
 // write pre-action user code here
if (item == stringItem1) {//GEN-BEGIN:|17-itemCommandAction|1|63-preAction
            if (command == itemCommand) {//GEN-END:|17-itemCommandAction|1|63-preAction
 // write pre-action user code here
switchDisplayable(null, getForm2());//GEN-LINE:|17-itemCommandAction|2|63-postAction
 // write post-action user code here
}//GEN-BEGIN:|17-itemCommandAction|3|67-preAction
} else if (item == stringItem2) {
    if (command == itemCommand2) {//GEN-END:|17-itemCommandAction|3|67-preAction
 String inbox = (smsapi.getInbox().toString());
 getTextField4(); 
textField4.setString(inbox);
 

        switchDisplayable(null, getForm3());//GEN-LINE:|17-itemCommandAction|4|67-postAction
 // write post-action user code here
}//GEN-BEGIN:|17-itemCommandAction|5|84-preAction
} else if (item == stringItem3) {
    if (command == itemCommand4) {//GEN-END:|17-itemCommandAction|5|84-preAction
getTextField5();
textField5.setString("");
    textField5.setString(smsapi.getOutbox().toString());
        switchDisplayable(null, getForm4());//GEN-LINE:|17-itemCommandAction|6|84-postAction
 // write post-action user code here
}//GEN-BEGIN:|17-itemCommandAction|7|62-preAction
} else if (item == stringItem4) {
    if (command == okCommand1) {//GEN-END:|17-itemCommandAction|7|62-preAction
 
        switchDisplayable(null, getForm());//GEN-LINE:|17-itemCommandAction|8|62-postAction
 // write post-action user code here
}//GEN-BEGIN:|17-itemCommandAction|9|17-postItemCommandAction
        }//GEN-END:|17-itemCommandAction|9|17-postItemCommandAction
 // write post-action user code here
}//GEN-BEGIN:|17-itemCommandAction|10|
//</editor-fold>//GEN-END:|17-itemCommandAction|10|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: cancelCommand ">//GEN-BEGIN:|37-getter|0|37-preInit
    /**
     * Returns an initialized instance of cancelCommand component.
     *
     * @return the initialized component instance
     */
    public Command getCancelCommand() {
        if (cancelCommand == null) {
//GEN-END:|37-getter|0|37-preInit
 // write pre-init user code here
cancelCommand = new Command("Cancel", Command.CANCEL, 0);//GEN-LINE:|37-getter|1|37-postInit
 // write post-init user code here
}//GEN-BEGIN:|37-getter|2|
        return cancelCommand;
    }
//</editor-fold>//GEN-END:|37-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand1 ">//GEN-BEGIN:|41-getter|0|41-preInit
    /**
     * Returns an initialized instance of okCommand1 component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand1() {
        if (okCommand1 == null) {
//GEN-END:|41-getter|0|41-preInit
 // write pre-init user code here
okCommand1 = new Command("Login", Command.OK, 0);//GEN-LINE:|41-getter|1|41-postInit
 // write post-init user code here
}//GEN-BEGIN:|41-getter|2|
        return okCommand1;
    }
//</editor-fold>//GEN-END:|41-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemCommand ">//GEN-BEGIN:|45-getter|0|45-preInit
    /**
     * Returns an initialized instance of itemCommand component.
     *
     * @return the initialized component instance
     */
    public Command getItemCommand() {
        if (itemCommand == null) {
//GEN-END:|45-getter|0|45-preInit
 // write pre-init user code here
itemCommand = new Command("New message", Command.ITEM, 0);//GEN-LINE:|45-getter|1|45-postInit
 // write post-init user code here
}//GEN-BEGIN:|45-getter|2|
        return itemCommand;
    }
//</editor-fold>//GEN-END:|45-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand2 ">//GEN-BEGIN:|48-getter|0|48-preInit
    /**
     * Returns an initialized instance of okCommand2 component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand2() {
        if (okCommand2 == null) {
//GEN-END:|48-getter|0|48-preInit
 // write pre-init user code here
okCommand2 = new Command("Send", Command.OK, 0);//GEN-LINE:|48-getter|1|48-postInit
 // write post-init user code here
}//GEN-BEGIN:|48-getter|2|
        return okCommand2;
    }
//</editor-fold>//GEN-END:|48-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: cancelCommand1 ">//GEN-BEGIN:|50-getter|0|50-preInit
    /**
     * Returns an initialized instance of cancelCommand1 component.
     *
     * @return the initialized component instance
     */
    public Command getCancelCommand1() {
        if (cancelCommand1 == null) {
//GEN-END:|50-getter|0|50-preInit
 // write pre-init user code here
cancelCommand1 = new Command("Cancel", Command.CANCEL, 0);//GEN-LINE:|50-getter|1|50-postInit
 // write post-init user code here
}//GEN-BEGIN:|50-getter|2|
        return cancelCommand1;
    }
//</editor-fold>//GEN-END:|50-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemCommand1 ">//GEN-BEGIN:|54-getter|0|54-preInit
    /**
     * Returns an initialized instance of itemCommand1 component.
     *
     * @return the initialized component instance
     */
    public Command getItemCommand1() {
        if (itemCommand1 == null) {
//GEN-END:|54-getter|0|54-preInit
 // write pre-init user code here
itemCommand1 = new Command("Inbox", Command.ITEM, 0);//GEN-LINE:|54-getter|1|54-postInit
 // write post-init user code here
}//GEN-BEGIN:|54-getter|2|
        return itemCommand1;
    }
//</editor-fold>//GEN-END:|54-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemCommand2 ">//GEN-BEGIN:|66-getter|0|66-preInit
    /**
     * Returns an initialized instance of itemCommand2 component.
     *
     * @return the initialized component instance
     */
    public Command getItemCommand2() {
        if (itemCommand2 == null) {
//GEN-END:|66-getter|0|66-preInit
 // write pre-init user code here
itemCommand2 = new Command("Inbox", Command.ITEM, 0);//GEN-LINE:|66-getter|1|66-postInit
 // write post-init user code here
}//GEN-BEGIN:|66-getter|2|
        return itemCommand2;
    }
//</editor-fold>//GEN-END:|66-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand3 ">//GEN-BEGIN:|69-getter|0|69-preInit
    /**
     * Returns an initialized instance of okCommand3 component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand3() {
        if (okCommand3 == null) {
//GEN-END:|69-getter|0|69-preInit
 // write pre-init user code here
okCommand3 = new Command("Ok", Command.OK, 0);//GEN-LINE:|69-getter|1|69-postInit
 // write post-init user code here
}//GEN-BEGIN:|69-getter|2|
        return okCommand3;
    }
//</editor-fold>//GEN-END:|69-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: form1 ">//GEN-BEGIN:|36-getter|0|36-preInit
    /**
     * Returns an initialized instance of form1 component.
     *
     * @return the initialized component instance
     */
    public Form getForm1() {
        if (form1 == null) {
//GEN-END:|36-getter|0|36-preInit
 // write pre-init user code here
form1 = new Form("Send SMS", new Item[]{getStringItem1(), getStringItem2(), getStringItem3(), getStringItem4()});//GEN-BEGIN:|36-getter|1|36-postInit
            form1.addCommand(getExitCommand1());
            form1.setCommandListener(this);//GEN-END:|36-getter|1|36-postInit
 // write post-init user code here
}//GEN-BEGIN:|36-getter|2|
        return form1;
    }
//</editor-fold>//GEN-END:|36-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem1 ">//GEN-BEGIN:|58-getter|0|58-preInit
    /**
     * Returns an initialized instance of stringItem1 component.
     *
     * @return the initialized component instance
     */
    public StringItem getStringItem1() {
        if (stringItem1 == null) {
//GEN-END:|58-getter|0|58-preInit
 // write pre-init user code here
stringItem1 = new StringItem("New message", "Click to write ");//GEN-BEGIN:|58-getter|1|58-postInit
            stringItem1.addCommand(getItemCommand());
            stringItem1.setItemCommandListener(this);//GEN-END:|58-getter|1|58-postInit
 // write post-init user code here
}//GEN-BEGIN:|58-getter|2|
        return stringItem1;
    }
//</editor-fold>//GEN-END:|58-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem2 ">//GEN-BEGIN:|59-getter|0|59-preInit
    /**
     * Returns an initialized instance of stringItem2 component.
     *
     * @return the initialized component instance
     */
    public StringItem getStringItem2() {
        if (stringItem2 == null) {
//GEN-END:|59-getter|0|59-preInit
 // write pre-init user code here
stringItem2 = new StringItem("Inbox", "Click to check");//GEN-BEGIN:|59-getter|1|59-postInit
            stringItem2.addCommand(getItemCommand2());
            stringItem2.setItemCommandListener(this);//GEN-END:|59-getter|1|59-postInit
 // write post-init user code here
}//GEN-BEGIN:|59-getter|2|
        return stringItem2;
    }
//</editor-fold>//GEN-END:|59-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem3 ">//GEN-BEGIN:|60-getter|0|60-preInit
    /**
     * Returns an initialized instance of stringItem3 component.
     *
     * @return the initialized component instance
     */
    public StringItem getStringItem3() {
        if (stringItem3 == null) {
//GEN-END:|60-getter|0|60-preInit
 // write pre-init user code here
stringItem3 = new StringItem("Outbox", "Click to check");//GEN-BEGIN:|60-getter|1|60-postInit
            stringItem3.addCommand(getItemCommand4());
            stringItem3.setItemCommandListener(this);//GEN-END:|60-getter|1|60-postInit
 // write post-init user code here
}//GEN-BEGIN:|60-getter|2|
        return stringItem3;
    }
//</editor-fold>//GEN-END:|60-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem4 ">//GEN-BEGIN:|61-getter|0|61-preInit
    /**
     * Returns an initialized instance of stringItem4 component.
     *
     * @return the initialized component instance
     */
    public StringItem getStringItem4() {
        if (stringItem4 == null) {
//GEN-END:|61-getter|0|61-preInit
 // write pre-init user code here
stringItem4 = new StringItem("Account", "Not Logged in");//GEN-BEGIN:|61-getter|1|61-postInit
            stringItem4.addCommand(getOkCommand1());
            stringItem4.setItemCommandListener(this);//GEN-END:|61-getter|1|61-postInit
 // write post-init user code here
}//GEN-BEGIN:|61-getter|2|
        return stringItem4;
    }
//</editor-fold>//GEN-END:|61-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: form2 ">//GEN-BEGIN:|44-getter|0|44-preInit
    /**
     * Returns an initialized instance of form2 component.
     *
     * @return the initialized component instance
     */
    public Form getForm2() {
        if (form2 == null) {
//GEN-END:|44-getter|0|44-preInit
 // write pre-init user code here
form2 = new Form("New message", new Item[]{getTextField2(), getTextField3()});//GEN-BEGIN:|44-getter|1|44-postInit
            form2.addCommand(getOkCommand2());
            form2.addCommand(getCancelCommand1());
            form2.setCommandListener(this);//GEN-END:|44-getter|1|44-postInit
 // write post-init user code here
}//GEN-BEGIN:|44-getter|2|
        return form2;
    }
//</editor-fold>//GEN-END:|44-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: form3 ">//GEN-BEGIN:|56-getter|0|56-preInit
    /**
     * Returns an initialized instance of form3 component.
     *
     * @return the initialized component instance
     */
    public Form getForm3() {
        if (form3 == null) {
//GEN-END:|56-getter|0|56-preInit
 // write pre-init user code here
form3 = new Form("Inbox", new Item[]{getTextField4()});//GEN-BEGIN:|56-getter|1|56-postInit
            form3.addCommand(getOkCommand3());
            form3.setCommandListener(this);//GEN-END:|56-getter|1|56-postInit
 // write post-init user code here
}//GEN-BEGIN:|56-getter|2|
        return form3;
    }
//</editor-fold>//GEN-END:|56-getter|2|



//<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField2 ">//GEN-BEGIN:|73-getter|0|73-preInit
    /**
     * Returns an initialized instance of textField2 component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField2() {
        if (textField2 == null) {
//GEN-END:|73-getter|0|73-preInit
 // write pre-init user code here
textField2 = new TextField("Number:", "", 32, TextField.ANY);//GEN-LINE:|73-getter|1|73-postInit
 // write post-init user code here
}//GEN-BEGIN:|73-getter|2|
        return textField2;
    }
//</editor-fold>//GEN-END:|73-getter|2|



//<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField3 ">//GEN-BEGIN:|75-getter|0|75-preInit
    /**
     * Returns an initialized instance of textField3 component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField3() {
        if (textField3 == null) {
//GEN-END:|75-getter|0|75-preInit
 // write pre-init user code here
textField3 = new TextField("Message:", "Write msg here", 140, TextField.ANY);//GEN-LINE:|75-getter|1|75-postInit
 // write post-init user code here
}//GEN-BEGIN:|75-getter|2|
        return textField3;
    }
//</editor-fold>//GEN-END:|75-getter|2|



//<editor-fold defaultstate="collapsed" desc=" Generated Getter: tableModel1 ">//GEN-BEGIN:|77-getter|0|77-preInit
    /**
     * Returns an initialized instance of tableModel1 component.
     *
     * @return the initialized component instance
     */
    public SimpleTableModel getTableModel1() {
        if (tableModel1 == null) {
//GEN-END:|77-getter|0|77-preInit
 // write pre-init user code here
tableModel1 = new SimpleTableModel(new java.lang.String[][]{}, new java.lang.String[]{"Number", "Message"});//GEN-LINE:|77-getter|1|77-postInit
 // write post-init user code here
}//GEN-BEGIN:|77-getter|2|
        return tableModel1;
    }
//</editor-fold>//GEN-END:|77-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField4 ">//GEN-BEGIN:|78-getter|0|78-preInit
    /**
     * Returns an initialized instance of textField4 component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField4() {
        if (textField4 == null) {
//GEN-END:|78-getter|0|78-preInit
 // write pre-init user code here
textField4 = new TextField("Inbox", "", 5000, TextField.ANY);//GEN-LINE:|78-getter|1|78-postInit
 // write post-init user code here
}//GEN-BEGIN:|78-getter|2|
        return textField4;
    }
//</editor-fold>//GEN-END:|78-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: form4 ">//GEN-BEGIN:|79-getter|0|79-preInit
    /**
     * Returns an initialized instance of form4 component.
     *
     * @return the initialized component instance
     */
    public Form getForm4() {
        if (form4 == null) {
//GEN-END:|79-getter|0|79-preInit
 // write pre-init user code here
form4 = new Form("Outbox", new Item[]{getTextField5()});//GEN-BEGIN:|79-getter|1|79-postInit
            form4.addCommand(getOkCommand4());
            form4.setCommandListener(this);//GEN-END:|79-getter|1|79-postInit
 // write post-init user code here
}//GEN-BEGIN:|79-getter|2|
        return form4;
    }
//</editor-fold>//GEN-END:|79-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField5 ">//GEN-BEGIN:|80-getter|0|80-preInit
    /**
     * Returns an initialized instance of textField5 component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField5() {
        if (textField5 == null) {
//GEN-END:|80-getter|0|80-preInit
 // write pre-init user code here
textField5 = new TextField("Outbox", "", 5000, TextField.ANY);//GEN-LINE:|80-getter|1|80-postInit
 // write post-init user code here
}//GEN-BEGIN:|80-getter|2|
        return textField5;
    }
//</editor-fold>//GEN-END:|80-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemCommand3 ">//GEN-BEGIN:|81-getter|0|81-preInit
    /**
     * Returns an initialized instance of itemCommand3 component.
     *
     * @return the initialized component instance
     */
    public Command getItemCommand3() {
        if (itemCommand3 == null) {
//GEN-END:|81-getter|0|81-preInit
 // write pre-init user code here
itemCommand3 = new Command("Item", Command.ITEM, 0);//GEN-LINE:|81-getter|1|81-postInit
 // write post-init user code here
}//GEN-BEGIN:|81-getter|2|
        return itemCommand3;
    }
//</editor-fold>//GEN-END:|81-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemCommand4 ">//GEN-BEGIN:|83-getter|0|83-preInit
    /**
     * Returns an initialized instance of itemCommand4 component.
     *
     * @return the initialized component instance
     */
    public Command getItemCommand4() {
        if (itemCommand4 == null) {
//GEN-END:|83-getter|0|83-preInit
 // write pre-init user code here
itemCommand4 = new Command("Outbox", Command.ITEM, 0);//GEN-LINE:|83-getter|1|83-postInit
 // write post-init user code here
}//GEN-BEGIN:|83-getter|2|
        return itemCommand4;
    }
//</editor-fold>//GEN-END:|83-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand4 ">//GEN-BEGIN:|86-getter|0|86-preInit
    /**
     * Returns an initialized instance of okCommand4 component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand4() {
        if (okCommand4 == null) {
//GEN-END:|86-getter|0|86-preInit
 // write pre-init user code here
okCommand4 = new Command("Ok", Command.OK, 0);//GEN-LINE:|86-getter|1|86-postInit
 // write post-init user code here
}//GEN-BEGIN:|86-getter|2|
        return okCommand4;
    }
//</editor-fold>//GEN-END:|86-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand1 ">//GEN-BEGIN:|89-getter|0|89-preInit
    /**
     * Returns an initialized instance of exitCommand1 component.
     *
     * @return the initialized component instance
     */
    public Command getExitCommand1() {
        if (exitCommand1 == null) {//GEN-END:|89-getter|0|89-preInit
 // write pre-init user code here
exitCommand1 = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|89-getter|1|89-postInit
 // write post-init user code here
}//GEN-BEGIN:|89-getter|2|
        return exitCommand1;
    }
//</editor-fold>//GEN-END:|89-getter|2|

    /**
     * Returns a display instance.
     *
     * @return the display instance.
     */
    public Display getDisplay() {
        return Display.getDisplay(this);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {
        switchDisplayable(null, null);
        destroyApp(true);
        notifyDestroyed();
    }

    /**
     * Called when MIDlet is started. Checks whether the MIDlet have been
     * already started and initialize/starts or resumes the MIDlet.
     */
    public void startApp() {
        if (midletPaused) {
            resumeMIDlet();
        } else {
            initialize();
            startMIDlet();
        }
        midletPaused = false;
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
        midletPaused = true;
    }

    /**
     * Called to signal the MIDlet to terminate.
     *
     * @param unconditional if true, then the MIDlet has to be unconditionally
     * terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
    }
    
    private void addMessage(String msg)
    {
        stringItem4.setText(msg);
    }
    
    private String[] split(String original,String separator) {
    Vector nodes = new Vector();
    // Parse nodes into vector
    int index = original.indexOf(separator);
    while(index >= 0) {
        nodes.addElement( original.substring(0, index) );
        original = original.substring(index+separator.length());
        index = original.indexOf(separator);
    }
    // Get the last node
    nodes.addElement( original );

     // Create split string array
    String[] result = new String[ nodes.size() ];
    if( nodes.size() > 0 ) {
        for(int loop = 0; loop < nodes.size(); loop++)
        {
            result[loop] = (String)nodes.elementAt(loop);
            System.out.println(result[loop]);
           
        }

    }
   return result;
}
    
}
