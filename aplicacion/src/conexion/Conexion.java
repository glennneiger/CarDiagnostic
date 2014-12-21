package conexion;

import java.io.IOException;

import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

import javax.bluetooth.DiscoveryListener;

import javax.comm.CommPortIdentifier;

/**
 * Clase abstracta que representa un tipo de conexi�n, actualmente hay dos tipos
 * de conexi�n soportadas SerialConexi�n, BluetoothConexi�n.
 */

public abstract class Conexion {
    protected final BufferConexion buffer; 
    protected Thread hilo;
    {
        buffer=new BufferConexion( );
    }
    
    
    public Conexion(){
       
    }
 /**
     * m�todo abstracto que debe ser implentado por las subclases de Conexi�n.
     * @throws IOException
     * @throws MuchosListenerException
     * @throws OperacionNoSoportadaException
     * @throws ConexionException
     */
    public abstract void abrirConexion() throws ConexionException;
  
  /**
     * cierra la conexi�n
     * @throws IOException
     */
    public abstract void cerrarConexion() throws ConexionException;
   
   /**
     * Escribe los datos en el puerto
     * @param datos
     * @throws IOException
     */
 public abstract void escribirPuerto(String datos, boolean bloqueante) throws IOException,ConexionException,
                                                                   TimeOutException;
   
    
    public BufferConexion getBufferConexion(){
        return buffer;
    }
   
     /**
     * add un escuchador de eventos.
     * @param BufferEventListener
     * @throws MuchosListenerException
     * @throws OperacionNoSoportadaException
     */
    public void addBufferEventListener(BufferEventListener e)throws MuchosListenerException,
    OperacionNoSoportadaException{
        buffer.addBufferEventListener(e);
    }
     public void cambiarBufferEventListener(BufferEventListener e) throws OperacionNoSoportadaException {
         buffer.cambiarBufferEventListener(e);
     }
     public void eliminarBufferEventListener(){
         buffer.eliminarBufferEventListener();
     }
     
     public abstract void cancelarEscrituraLectura  ();

   
}
