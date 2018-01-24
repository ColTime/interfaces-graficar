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
    private int existePuerto = 0;

    public ConexionPS() {//Constructos
    }

    int conexion = 0;
//Falta validar que el puerto este abierto y disponible para poder mandar informacion, y de no ser asì se va a notificar al usuario que no puede realizar la toma de tiempo correspondiente a si àrea de producciòn.

    public void enlacePuertos() {
        Menu obj = new Menu();
        CommPort puerto = null;
        String valor = "";
        try {
            Enumeration commports = CommPortIdentifier.getPortIdentifiers();//Se traen todos los puertos disponibles
            CommPortIdentifier myCPI = null;
            Scanner mySC;
            while (commports.hasMoreElements()) {//Se valida que el puerto que necesito este disponible
                existePuerto = 1;
                myCPI = (CommPortIdentifier) commports.nextElement();
                if (myCPI.getName().equals("COM4")) {
                    puerto = myCPI.open("Puerto Serial Operario", 100);//Abro el puerto y le mando dos parametros que son el nombre de la apertura y el tiempo de respuesta
                    SerialPort mySP = (SerialPort) puerto;
                    //
                    mySP.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
                    //
                    mySC = new Scanner(mySP.getInputStream());//Datos de entrada al puerto
                    obj.myPS = new PrintStream(mySP.getOutputStream());//Datos de salia del puerto

                    conexion = 1;
                    while (true) {//Valida el mismo puerto que se abrio!!
                        while (!mySC.hasNext()) {//Valida que en el puerto serial exista alguna linea de información
                            mySC.close();
                            mySC = null;
                            mySC = new Scanner(mySP.getInputStream());
                        }
                        valor = mySC.next();//Valor de entrada

                        obj.LecturaCodigoQR(valor);//Se encargara de ler el codigo QR

                        obj.myPS.print(mensaje);//Valor de dalida
                        mensaje = null;
                    }
//                    puerto.close();
//                    break;
                }
            }
            //
            if (conexion == 0) {// 0 =No se pudo realizar la conexion, 1: Conexion realizada correactamente.
                JOptionPane.showMessageDialog(null, "Error: " + "No se pudo conectar al puerto serial COM3.");
            }
            //
            if (existePuerto == 0) {//Se mostrara un mensaje diciendo que no existe ningun puerto serial disponible
                JOptionPane.showMessageDialog(null, "No existe ningun puerto serial disponible, por favor conecte el dispotitivo");
            } else {
                existePuerto = 0;
            }
            //
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
