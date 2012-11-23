package org.netbeans.j1.game.client;

import javax.xml.rpc.JAXRPCException;
import javax.xml.namespace.QName;
import javax.microedition.xml.rpc.Operation;
import javax.microedition.xml.rpc.Type;
import javax.microedition.xml.rpc.ComplexType;
import javax.microedition.xml.rpc.Element;

public class HighScoresService_Stub implements HighScoresService, javax.xml.rpc.Stub {
    
    private String[] _propertyNames;
    private Object[] _propertyValues;
    
    public HighScoresService_Stub() {
        _propertyNames = new String[] { ENDPOINT_ADDRESS_PROPERTY };
        _propertyValues = new Object[] { "http://193.86.76.42:8080/DukeHighScores/HighScoresService" };
//        _propertyValues = new Object[] { "http://lukas-notebook:8080/DukeHighScores/HighScoresService" };
    }
    
    public void _setProperty( String name, Object value ) {
        int size = _propertyNames.length;
        for (int i = 0; i < size; ++i) {
            if( _propertyNames[i].equals( name )) {
                _propertyValues[i] = value;
                return;
            }
        }
        String[] newPropNames = new String[size + 1];
        System.arraycopy(_propertyNames, 0, newPropNames, 0, size);
        _propertyNames = newPropNames;
        Object[] newPropValues = new Object[size + 1];
        System.arraycopy(_propertyValues, 0, newPropValues, 0, size);
        _propertyValues = newPropValues;
        
        _propertyNames[size] = name;
        _propertyValues[size] = value;
    }
    
    public Object _getProperty(String name) {
        for (int i = 0; i < _propertyNames.length; ++i) {
            if (_propertyNames[i].equals(name)) {
                return _propertyValues[i];
            }
        }
        if (ENDPOINT_ADDRESS_PROPERTY.equals(name) || USERNAME_PROPERTY.equals(name) || PASSWORD_PROPERTY.equals(name)) {
            return null;
        }
        if (SESSION_MAINTAIN_PROPERTY.equals(name)) {
            return new Boolean(false);
        }
        throw new JAXRPCException("Stub does not recognize property: " + name);
    }
    
    protected void _prepOperation(Operation op) {
        for (int i = 0; i < _propertyNames.length; ++i) {
            op.setProperty(_propertyNames[i], _propertyValues[i].toString());
        }
    }
    
    public boolean setHighScore(String name, int score) throws java.rmi.RemoteException {
        Object inputObject[] = new Object[] {
            name,
            new Integer(score)
        };
        
        Operation op = Operation.newInstance( _qname_operation_setHighScore, _type_setHighScore, _type_setHighScoreResponse );
        _prepOperation( op );
        op.setProperty( Operation.SOAPACTION_URI_PROPERTY, "" );
        Object resultObj;
        try {
            resultObj = op.invoke( inputObject );
        } catch( JAXRPCException e ) {
            Throwable cause = e.getLinkedCause();
            if( cause instanceof java.rmi.RemoteException ) {
                throw (java.rmi.RemoteException) cause;
            }
            throw e;
        }
        
        return ((Boolean )((Object[])resultObj)[0]).booleanValue();
    }
    
    public String[] getHighScores() throws java.rmi.RemoteException {
        Object inputObject[] = new Object[] {
        };
        
        Operation op = Operation.newInstance( _qname_operation_getHighScores, _type_getHighScores, _type_getHighScoresResponse );
        _prepOperation( op );
        op.setProperty( Operation.SOAPACTION_URI_PROPERTY, "" );
        Object resultObj;
        try {
            resultObj = op.invoke( inputObject );
        } catch( JAXRPCException e ) {
            Throwable cause = e.getLinkedCause();
            if( cause instanceof java.rmi.RemoteException ) {
                throw (java.rmi.RemoteException) cause;
            }
            throw e;
        }
        
        String[] _res = new String[((Object [])((Object []) resultObj)[0]).length];
        System.arraycopy(((Object []) resultObj)[0], 0, _res, 0, _res.length);
        return _res;
    }
    
    protected static final QName _qname_operation_getHighScores = new QName( "http://game.j1.netbeans.org/", "getHighScores" );
    protected static final QName _qname_operation_setHighScore = new QName( "http://game.j1.netbeans.org/", "setHighScore" );
    protected static final QName _qname_getHighScores = new QName( "http://game.j1.netbeans.org/", "getHighScores" );
    protected static final QName _qname_setHighScore = new QName( "http://game.j1.netbeans.org/", "setHighScore" );
    protected static final QName _qname_getHighScoresResponse = new QName( "http://game.j1.netbeans.org/", "getHighScoresResponse" );
    protected static final QName _qname_setHighScoreResponse = new QName( "http://game.j1.netbeans.org/", "setHighScoreResponse" );
    protected static final Element _type_getHighScores;
    protected static final Element _type_setHighScore;
    protected static final Element _type_setHighScoreResponse;
    protected static final Element _type_getHighScoresResponse;
    
    static {
        _type_getHighScores = new Element( _qname_getHighScores, _complexType( new Element[] {
        }), 1, 1, false );
        _type_getHighScoresResponse = new Element( _qname_getHighScoresResponse, _complexType( new Element[] {
            new Element( new QName( "", "return" ), Type.STRING, 0, Element.UNBOUNDED, true )}), 1, 1, false );
        _type_setHighScore = new Element( _qname_setHighScore, _complexType( new Element[] {
            new Element( new QName( "", "name" ), Type.STRING, 0, 1, false ),
            new Element( new QName( "", "score" ), Type.INT )}), 1, 1, false );
        _type_setHighScoreResponse = new Element( _qname_setHighScoreResponse, _complexType( new Element[] {
            new Element( new QName( "", "return" ), Type.BOOLEAN )}), 1, 1, false );
    }
    
    private static ComplexType _complexType( Element[] elements ) {
        ComplexType result = new ComplexType();
        result.elements = elements;
        return result;
    }
}
