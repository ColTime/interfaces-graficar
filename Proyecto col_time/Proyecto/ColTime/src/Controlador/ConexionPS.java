/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import coltime.Menu;
import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author fac.diseño02
 */
public class ConexionPS {

    public String mensaje = null;

    public ConexionPS() {//Constructos
    }

    public void enviarMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
//Falta validar que el puerto este abierto y disponible para poder mandar informacion, y de no ser asì se va a notificar al usuario que no puede realizar la toma de tiempo correspondiente a si àrea de producciòn.
    public void enlacePuertos() {
        CommPort puerto = null;
        String valor = "";
        try {
            Enumeration commports = CommPortIdentifier.getPortIdentifiers();//Se traen todos los puertos disponibles
            CommPortIdentifier myCPI = null;
            Scanner mySC;
            PrintStream myPS;
            while (commports.hasMoreElements()) {//Se valida que el puerto que necesito este disponible
                myCPI = (CommPortIdentifier) commports.nextElement();
                if (myCPI.getName().equals("COM3")) {
                    break;
                }
            }
            puerto = myCPI.open("Puerto Serial", 1000);//Abro el puerto y le mando dos parametros que son el nombre de la apertura y el tiempo de respuesta
            SerialPort mySP = (SerialPort) puerto;
            //
            mySP.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
            //
            mySC = new Scanner(mySP.getInputStream());//Datos de entrada al puerto
            myPS = new PrintStream(mySP.getOutputStream());//Datos de salia del puerto

            while (!mySC.hasNext()) {//Valida la informacion que va a ingresar!!
                mySC.close();
                mySC = null;
                mySC = new Scanner(mySP.getInputStream());
            }

            valor = mySC.next();//Valor de entrada

            Menu obj = new Menu();

            obj.LecturaCodigoQR(valor);//Se encargara de ler el codigo QR

            myPS.print(mensaje);//Valor de dalida
            mensaje = null;
            puerto.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
            puerto.close();
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }
}
