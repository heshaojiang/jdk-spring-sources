package com.sun.corba.se.spi.activation;

/**
* com/sun/corba/se/spi/activation/ServerAlreadyActiveHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../../../src/share/classes/com/sun/corba/se/spi/activation/activation.idl
* Monday, October 3, 2011 1:42:38 AM GMT-08:00
*/

public final class ServerAlreadyActiveHolder implements org.omg.CORBA.portable.Streamable
{
  public com.sun.corba.se.spi.activation.ServerAlreadyActive value = null;

  public ServerAlreadyActiveHolder ()
  {
  }

  public ServerAlreadyActiveHolder (com.sun.corba.se.spi.activation.ServerAlreadyActive initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = com.sun.corba.se.spi.activation.ServerAlreadyActiveHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    com.sun.corba.se.spi.activation.ServerAlreadyActiveHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return com.sun.corba.se.spi.activation.ServerAlreadyActiveHelper.type ();
  }

}