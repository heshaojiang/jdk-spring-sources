package com.sun.corba.se.spi.activation;


/**
* com/sun/corba/se/spi/activation/ServerAlreadyRegistered.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../../../src/share/classes/com/sun/corba/se/spi/activation/activation.idl
* Monday, October 3, 2011 1:42:38 AM GMT-08:00
*/

public final class ServerAlreadyRegistered extends org.omg.CORBA.UserException
{
  public int serverId = (int)0;

  public ServerAlreadyRegistered ()
  {
    super(ServerAlreadyRegisteredHelper.id());
  } // ctor

  public ServerAlreadyRegistered (int _serverId)
  {
    super(ServerAlreadyRegisteredHelper.id());
    serverId = _serverId;
  } // ctor


  public ServerAlreadyRegistered (String $reason, int _serverId)
  {
    super(ServerAlreadyRegisteredHelper.id() + "  " + $reason);
    serverId = _serverId;
  } // ctor

} // class ServerAlreadyRegistered
